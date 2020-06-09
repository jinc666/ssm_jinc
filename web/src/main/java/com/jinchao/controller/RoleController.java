package com.jinchao.controller;

import com.jinchao.domain.Permission;
import com.jinchao.domain.Role;
import com.jinchao.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //根据RoleId查询出role  并查询出可以添加 的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //1.根据roleId查询role
        Role role = roleService.findById(roleId);
        //2.根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermission(roleId);
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", otherPermissions);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }

    @RequestMapping("/edit.do")
    public ModelAndView edit(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role byId = roleService.findById(id);
        modelAndView.addObject("role", byId);
        modelAndView.addObject("id", byId.getId());
        modelAndView.setViewName("role-edit");
        return modelAndView;
    }

    @RequestMapping("/update.do")
    public String update(Role role) throws Exception {
        roleService.update(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/showPermission.do")
    public ModelAndView findPermissionByRoleId(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> lp = roleService.findPermissionByRoleId(id);
        modelAndView.addObject("role", lp);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }
}

