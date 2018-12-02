package com.itheima.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("select * from Traveller where id=#{id}")
    public List<Traveller> findByOrdersId(String id);
}
