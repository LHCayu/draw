package com.example.test.controller;

import com.example.test.bean.IntentionBean;
import com.example.test.mapper.IntentionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IntentionController {

    @Autowired
    IntentionDAO intentionDAO;

    @RequestMapping("intention")
    public String intentionIndex(){
        return "intention";
    }

    @RequestMapping("intentionSubmit")
    public String intention(HttpServletRequest request, String checkbox1[], String checkbox2[], String divGifts, Model model){
        HttpSession session = request.getSession();
        int phone=0;
        int ipad=0;
        int kettle=0;
        int mobileSource=0;
        try {
            //获取用户id
            int uid = Integer.parseInt(session.getAttribute("userId").toString());
            //获取表单信息，并查看哪些选项被选中，选中的标志为1，否则为0
            for (int i = 0; i < checkbox1.length; i++) {
                if (checkbox1[i].equals("手机")) {
                    phone++;
                } else if (checkbox1[i].equals("平板")) {
                    ipad++;
                }
            }
            for (int i = 0; i < checkbox2.length; i++) {
                if (checkbox2[i].equals("滤水壶")) {
                    kettle++;
                } else if (checkbox2[i].equals("移动电源")) {
                    mobileSource++;
                }
            }
            //获取指定id的用户意向信息，如果有，则更新信息，如果没有。则插入信息
            IntentionBean intentionBean = intentionDAO.selectIntention(uid);
            if (intentionBean != null) {
                System.out.println(phone);
                System.out.println(ipad);
                System.out.println(kettle);
                System.out.println(mobileSource);
                intentionDAO.updateIntention(uid, phone, ipad, kettle, mobileSource, divGifts);
                model.addAttribute("result", "表单重新提交成功！");
            } else {
                intentionDAO.insertIntention(uid, phone, ipad, kettle, mobileSource, divGifts);
                model.addAttribute("result", "表单提交成功，感谢您的反馈！");
            }
        } catch (Exception e) {
            //表单空着会提交失败
            model.addAttribute("result", "表单未填满，提交失败！");
        }
        return "intention";
    }

}
