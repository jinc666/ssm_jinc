package com.jinchao.controller;

import com.github.pagehelper.PageInfo;
import com.jinchao.domain.Orders;
import com.jinchao.service.IOrdersService;
import com.jinchao.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    /*    @RequestMapping("save.do")
        public String save(Orders orders) throws Exception {
            System.out.println(orders.toString());
            String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            //orders.setOrderTime(new Date());
            orders.setOrderTime(DateUtils.string2Date(format,"yyyy-MM-dd HH:mm"));
            ordersService.save(orders);
            System.out.println(orders.toString());
            return "redirect:findAll.do";
        }*/
    @RequestMapping("save.do")
    @PreAuthorize("authentication.principal.username=='tom'") //只有tom能进行添加操作
    public String save(Orders orders) throws Exception{
        orders.setOrderTime(new Date());
        ordersService.save(orders);
        return "redirect:findAll.do";
    }
}
