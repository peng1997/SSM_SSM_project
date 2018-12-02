package com.itheima.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

   @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    List<Role> findRoleByUserId(String userid);

   @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(rolename,roledesc) values (#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

}
