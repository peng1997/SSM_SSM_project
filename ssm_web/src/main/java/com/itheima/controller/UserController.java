package com.itheima.controller;

import com.itheima.service.IUserService;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userlist = userService.findAll();
        mv.addObject("userList",userlist);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        try {
            userService.save(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("用户添加失败");
        }
        return "redirect:/user/findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id" )String userId)  {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = null;
        try {
            userInfo = userService.findById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询用户信息失败");
        }
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

}
