package com.example.test.mapper;

import com.example.test.bean.DrawUserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDAO {

    //注册
    @Insert("insert into user(name, password, sex, province, city, address) " +
            "values (#{username},#{password},#{sex},#{province},#{city},#{address})")
    void regist(String username, String password, String sex, String province, String city, String address);

    //查询指定id的用户信息
    @Select("select * from user where id=#{id}")
    DrawUserBean seleltAll(int id);

    //检查登录信息
    @Select("select id,name,password from user where name=#{username}")
    DrawUserBean login(String username);

}
