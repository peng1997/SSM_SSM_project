package com.itheima.service.Imp;

import com.itheima.dao.IPermissionDao;
import com.itheima.service.IPermissionService;
import com.itheima.ssm.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jnlp.PersistenceService;
import java.util.List;
@Service
public class PermissionServiceImp implements IPermissionService {
 @Autowired
 private IPermissionDao iPermissionDao;

    @Override
    public List<Permission> findAll() {
        return  iPermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        iPermissionDao.save(permission);
    }
}
