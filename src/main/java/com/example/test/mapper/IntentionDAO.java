package com.example.test.mapper;

import com.example.test.bean.IntentionBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IntentionDAO {
    //用户第一次意向调查时执行的方法
    @Insert("INSERT INTO intention(uid,phone,ipad,kettle,mobileSource,divGifts) " +
            "VALUES(#{uid},#{phone},#{ipad},#{kettle},#{mobileSource},#{divGifts})")
    void insertIntention(int uid,int phone,int ipad,int kettle,int mobileSource,String divGifts);

    //查询用户是否是第一次进行意向调查
    @Select("SELECT * FROM intention WHERE uid=#{uid}")
    IntentionBean selectIntention(int uid);

    //更新用户的意向调查
    @Update("UPDATE intention SET phone=#{phone},ipad=#{ipad},kettle=#{kettle}," +
            "mobileSource=#{mobileSource},divGifts=#{divGifts} where uid=#{uid}")
    void updateIntention(int uid,int phone,int ipad,int kettle,int mobileSource,String divGifts);
}
