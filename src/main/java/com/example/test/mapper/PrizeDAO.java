package com.example.test.mapper;

import com.example.test.bean.*;
import com.example.test.bean.RuleBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PrizeDAO {
    //获取奖品的所有信息
    @Select("SELECT * FROM prize")
    List<PrizeBean> selectAllPrize();

    //查询指定id的产品
    @Select("SELECT * FROM prize WHERE id=#{id}")
    PrizeBean checkNum(int id);

    //成功抽到奖品后，奖品的数量减一
    @Update("UPDATE prize SET num=num-1 WHERE id=#{id}")
    void drawSuccess(int id);

    //查询所有规则
    @Select("SELECT * FROM rule")
    List<RuleBean> selectRule();

    //成功抽到奖品后，将信息写进数据库
    @Insert("insert into user_prize(uid, pid, time, nowStatus) " +
            "values (#{uid},#{pid},#{time},#{nowStatus})")
    void addPrizeSuccess(int uid, int pid, String time, String nowStatus);

    //联合用户抽奖表和奖品表，在我的奖品页面输出相应的信息
    @Select("SELECT user_prize.id,prize.name,user_prize.time,prize.info,user_prize.nowStatus FROM user_prize JOIN prize ON user_prize.pid=prize.id WHERE user_prize.uid=#{uid}")
    List<MyselfPrizeBean> selectUserPrize(int uid);


}
