package com.itheima.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.service.IOrdersService;
import com.itheima.ssm.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private  IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")
                                            Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4")
                                        Integer pageSize) throws Exception {
        System.out.println(page);
        System.out.println(pageSize);
        List<Orders> ordersList = ordersService.findAll(page, pageSize);
        System.out.println(ordersList.size());
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
    @RequestMapping("/findById.do")
    public  ModelAndView findById(@RequestParam(name = "id",defaultValue = "1") String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
