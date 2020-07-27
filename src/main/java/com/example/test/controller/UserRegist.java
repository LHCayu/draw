package com.example.test.controller;

import com.example.test.mapper.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserRegist {
    @Autowired
    UserDAO userDAO;

    @RequestMapping("/register")
    public String show(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String test(String username, String password, String sex, String province, String city, String address) {
        //获取表单信息，注册用户
        userDAO.regist(username, password, sex, province, city, address);

        return "redirect:login";
    }

}
