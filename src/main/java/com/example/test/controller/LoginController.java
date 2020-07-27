package com.example.test.controller;

import com.example.test.bean.DrawUserBean;
import com.example.test.mapper.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    //登录验证
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request) {
        DrawUserBean userBean = userDAO.login(username);
        System.out.println(userBean.getName() + " " + userBean.getPassword());
        System.out.println(password);
        if (userBean.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("userName",username);
            session.setAttribute("userId",userBean.getId());
            return "redirect:draw";
        } else {
            return "error";
        }
    }

    //返回登录
    @RequestMapping("backLogin")
    public String backLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName",null);
        session.setAttribute("userId",null);
        return "redirect:/login";
    }

}
