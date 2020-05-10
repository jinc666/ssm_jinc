package com.jinchao.controller;

import com.jinchao.domain.Permission;
import com.jinchao.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/eidt.do")
    public ModelAndView eidt(@RequestParam(name = "id", required = true) String id)throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Permission permission = permissionService.findById(id);
        modelAndView.addObject("permission", permission);
        modelAndView.addObject("id",permission.getId());
        modelAndView.setViewName("permission-edit");
        return modelAndView;
    }

    @RequestMapping("/update.do")
    public String update(Permission permission) throws Exception{
        permissionService.update(permission);
        return "redirect:findAll.do";
    }

}
