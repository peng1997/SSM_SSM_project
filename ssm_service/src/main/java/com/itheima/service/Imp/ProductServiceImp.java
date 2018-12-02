package com.itheima.service.Imp;

import com.itheima.dao.IProductDao;
import com.itheima.service.IProductService;
import com.itheima.ssm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private IProductDao iProductDao;
    @Override
    public List<Product> findAll() throws Exception {
        List<Product> all = iProductDao.findAll();
        return all;
    }

    @Override
    public void save(Product product) throws Exception {
        iProductDao.save(product);
    }

}
