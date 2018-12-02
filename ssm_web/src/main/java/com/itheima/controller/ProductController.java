package com.itheima.controller;

import com.itheima.service.IProductService;
import com.itheima.ssm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/save")
    public  String save(Product product){
        try {
            productService.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加异常");
        }
        return "redirect:findAll.do";
    }
}
