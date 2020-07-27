package com.example.test.mapper;

import com.example.test.bean.DrawUserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PrizeOrderDAO {

    //录入每个实物奖品的收货地址
    @Insert("INSERT INTO `order`(upid,phone,address) " +
            "VALUES (#{upid},#{phone},#{address})")
    void addOrder(int upid, String phone, String address);

    //成功上传收货信息后把我的奖品状态改为已领取
    @Update("UPDATE user_prize SET nowStatus=\"已领取\" WHERE id=#{upid}")
    void updatePrizeStatus(int upid);
}
