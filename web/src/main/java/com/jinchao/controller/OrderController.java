package com.jinchao.controller;

import com.github.pagehelper.PageInfo;
import com.jinchao.domain.Orders;
import com.jinchao.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    //这个注解不能省略ROLE_这个前缀
    //@Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "2") Integer size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        //pageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders byId = ordersService.findById(ordersId);
        modelAndView.addObject("orders", byId);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

    //orders-edit
    @RequestMapping("/edit.do")
    public ModelAndView edit(String id)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Orders order = ordersService.findById(id);
        modelAndView.addObject("order" , order);
        modelAndView.addObject("id" ,order.getId());
        modelAndView.setViewName("orders-edit");
        return modelAndView;
    }

    @RequestMapping("/update.do")
    public String update(Orders orders)throws Exception{
        ordersService.update(orders);
        return "redirect:findAll.do";
    }
}
