package com.itheima.service.Imp;

import com.itheima.dao.IRoleDao;
import com.itheima.service.IRoleService;
import com.itheima.ssm.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImp implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }
}
