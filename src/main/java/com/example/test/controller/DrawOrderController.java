package com.example.test.controller;

import com.example.test.bean.DrawUserBean;
import com.example.test.bean.MyselfPrizeBean;
import com.example.test.mapper.UserDAO;
import com.example.test.mapper.PrizeOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DrawOrderController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PrizeOrderDAO prizeOrderDAO;

    //实物，获取当前用户的信息，跳转到表单，自动填写表单
    @RequestMapping("drawOrder")
    public String drawOrder(HttpServletRequest request, int upid){
        HttpSession session = request.getSession();
        try {
            //判断登录
            int uid = Integer.parseInt(session.getAttribute("userId").toString());
            DrawUserBean drawUserBean = userDAO.seleltAll(uid);
            session.setAttribute("userBean",drawUserBean);
            session.setAttribute("upid",upid);
            return "order";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }

    //微信，获取当前用户信息，跳转表单
    @RequestMapping("drawWXOrder")
    public String drawWXOrder(HttpServletRequest request, int upid){
        HttpSession session = request.getSession();
        try {
            //判断登录
            int uid = Integer.parseInt(session.getAttribute("userId").toString());
            DrawUserBean drawUserBean = userDAO.seleltAll(uid);
            session.setAttribute("userBean",drawUserBean);
            session.setAttribute("upid",upid);
            return "WXOrder";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }

    //填写实物信息时填写的表单
    @RequestMapping("checkOrder")
    public String checkOrder(HttpServletRequest request,String phone,String address){
        HttpSession session = request.getSession();
        try {
            //判断登录
            int upid = Integer.parseInt(session.getAttribute("upid").toString());
            prizeOrderDAO.addOrder(upid, phone, address);
            prizeOrderDAO.updatePrizeStatus(upid);
            return "draw";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:drawUserInfo";
    }

    //填写微信红包信息时的表单
    @RequestMapping("checkWXOrder")
    public String checkWXOrder(HttpServletRequest request){
        HttpSession session = request.getSession();
        try {
            //判断登录
            int upid = Integer.parseInt(session.getAttribute("upid").toString());
            prizeOrderDAO.updatePrizeStatus(upid);
            return "draw";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:drawUserInfo";
    }

}
