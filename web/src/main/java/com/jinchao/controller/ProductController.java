package com.jinchao.controller;

import com.github.pagehelper.PageInfo;
import com.jinchao.domain.Product;
import com.jinchao.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    //查询全部产品
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "2") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(productList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    //产品添加
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")  //只有admin角色才可以访问
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteProduct.do")
    public String deleteProduct(@RequestParam(name = "id",required = true) String id) throws Exception{
        productService.deleteProduct(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/edit.do")
    public ModelAndView updateProduct(@RequestParam(name = "id",required = true) String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findProductById(id);
        modelAndView.addObject("product" , product);
        modelAndView.addObject("id" , product.getId());
        modelAndView.setViewName("product-edit");
        return modelAndView;
    }

    @RequestMapping("/update.do")
    public String updateProduct(Product product){
        productService.updateProduct(product);
        return "redirect:findAll.do";
    }
}
