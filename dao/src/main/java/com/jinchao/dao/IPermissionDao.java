package com.jinchao.dao;

import com.jinchao.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id)throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission)throws Exception;

    @Select("select * from permission where id = #{id}")
    Permission findById(String id)throws Exception;

    @Update("update permission set permissionName=#{permissionName},url=#{url} where id = #{id}")
    void update(Permission permission);
}
