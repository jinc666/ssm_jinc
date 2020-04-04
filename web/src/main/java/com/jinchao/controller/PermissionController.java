package com.jinchao.controller;

import com.jinchao.dao.IPermissionDao;
import com.jinchao.domain.Permission;
import com.jinchao.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
