package com.example.test.controller;

import com.example.test.bean.MyselfPrizeBean;
import com.example.test.bean.PrizeBean;
import com.example.test.bean.RuleBean;
import com.example.test.bean.UserPrizeBean;
import com.example.test.mapper.PrizeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DrawUserInfoController {

    @Autowired
    PrizeDAO prizeDAO;

    @RequestMapping("drawUserInfo")
    public String drawUserInfo(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        try {
            //判断登录
            int uid = Integer.parseInt(session.getAttribute("userId").toString());

            //获取我的奖品的信息，并保存到session上
            List<MyselfPrizeBean> myselfPrizeBeans = prizeDAO.selectUserPrize(uid);
            session.setAttribute("myselfPrizeBeans",myselfPrizeBeans);
            return "drawUserInfo";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }

}
