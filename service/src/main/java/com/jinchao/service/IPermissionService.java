package com.jinchao.service;

import com.jinchao.domain.Permission;

import java.util.List;

public interface IPermissionService {

    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    List<Permission> findAll()throws Exception;

    /**
     * 添加权限
     * @param permission
     * @throws Exception
     */
    void save(Permission permission)throws Exception;

    /**
     * 根据Id查看权限信息
     * @param id
     * @return
     * @throws Exception
     */
    Permission findById(String id)throws Exception;

    /**
     * 权限修改
     * @param permission
     */
    void update(Permission permission)throws Exception;
}
