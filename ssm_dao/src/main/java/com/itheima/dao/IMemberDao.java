package com.itheima.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
