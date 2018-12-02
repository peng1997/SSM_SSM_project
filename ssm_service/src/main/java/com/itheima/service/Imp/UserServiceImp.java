package com.itheima.service.Imp;

import com.itheima.dao.IUserdao;
import com.itheima.service.IUserService;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImp implements IUserService {
   @Autowired
    private IUserdao iUserdao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(iUserdao==null?true:false);
        UserInfo userInfo =null;
        try {
           userInfo=iUserdao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        System.out.println(user);
        return user;
    }

    private Collection<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName())); //ROLE_USER
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception {
        return  iUserdao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);
        iUserdao.save(userInfo);
    }

    @Override
    public UserInfo findById(String userId) throws Exception {
        return  iUserdao.findById(userId);
    }
}

