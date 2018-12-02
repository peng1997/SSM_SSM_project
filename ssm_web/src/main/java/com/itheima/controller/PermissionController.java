package com.itheima.controller;

import com.itheima.service.IPermissionService;
import com.itheima.ssm.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
* 权限管理
* */
@Controller
@RequestMapping("/permission")
public class PermissionController {
@Autowired
private IPermissionService permissionService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return  mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission){
        try {
            permissionService.save(permission);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("权限添加失败");
        }
        return "redirect:/permission/findAll.do";
    }



}
