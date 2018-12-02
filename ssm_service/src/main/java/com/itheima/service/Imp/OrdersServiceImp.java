package com.itheima.service.Imp;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IOrdersDao;
import com.itheima.service.IOrdersService;
import com.itheima.ssm.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImp implements IOrdersService {
    @Autowired
     private IOrdersDao iOrdersDao;
    @Override
    public List<Orders> findAll(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);   //疑问
        return iOrdersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return  iOrdersDao.findById(ordersId);
    }
}
