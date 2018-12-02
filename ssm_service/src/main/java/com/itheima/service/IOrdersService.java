package com.itheima.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll(Integer page,Integer pageSize) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
