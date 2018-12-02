package com.itheima.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws  Exception;

    void save(Role role) throws Exception;

}
