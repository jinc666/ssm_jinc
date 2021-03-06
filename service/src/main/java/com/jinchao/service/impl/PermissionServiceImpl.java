package com.jinchao.service.impl;

import com.jinchao.dao.IPermissionDao;
import com.jinchao.domain.Permission;
import com.jinchao.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) throws Exception{
        return permissionDao.findById(id);
    }

    @Override
    public void update(Permission permission)throws Exception {
        permissionDao.update(permission);
    }
}
