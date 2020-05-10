package com.jinchao.service;

import com.jinchao.domain.Permission;
import com.jinchao.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll()throws Exception;

    void save(Role role)throws Exception;

    Role findById(String roleId)throws Exception;

    List<Permission> findOtherPermission(String roleId)throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    void update(Role role);
}
