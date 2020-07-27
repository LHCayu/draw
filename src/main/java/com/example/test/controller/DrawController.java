package com.example.test.controller;

import com.example.test.bean.RuleBean;
import com.example.test.bean.PrizeBean;
import com.example.test.mapper.PrizeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@Controller
public class DrawController {

    @Autowired
    PrizeDAO prizeDAO;

    @RequestMapping("/")
    public String defaultIndex(){
        return "index";
    }


    @RequestMapping("draw")
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        try {
            //判断登录
            int uid = Integer.parseInt(session.getAttribute("userId").toString());

            //保存奖品池和规则的信息到session
            List<PrizeBean> prizeBeans = prizeDAO.selectAllPrize();
            List<RuleBean> ruleBeans = prizeDAO.selectRule();
            session.setAttribute("prizeBeans",prizeBeans);
            session.setAttribute("ruleBeans",ruleBeans);
            return "draw";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }

    @RequestMapping("/drawStart")
    public String drawStart(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        try {
            //判断登录
            int uid = Integer.parseInt(session.getAttribute("userId").toString());
            //获取随机抽取奖品的id
            int id = chance();
            //查询奖品剩余的数量
            PrizeBean prizeBean = prizeDAO.checkNum(id);
            int num = prizeBean.getNum();
            String name;
            if (num <= 0 && id != 3 && id != 5 && id != 7) {
                name = "奖品已经全部派完，下次早点来哦";
            } else {
                name = prizeBean.getName();
                //获取当前时间
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format.format(date);
                if (prizeBean.getName().equals("谢谢惠顾")) {

                } else {
                    //当奖品还有剩余并且奖品不是谢谢惠顾时，把奖品信息写入数据库，奖品表的奖品数量减一
                    prizeDAO.drawSuccess(id);
                    prizeDAO.addPrizeSuccess(uid, prizeBean.getId(), time, "点击领取");
                }
            }
            //保存成功抽取奖品的名字
            model.addAttribute("successDrawPrizeName", name);
            return "draw";
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }

    //抽奖概率
    public int chance() {
        int drawId=3;
        int n = (int) (Math.random() * (10000) + 1);
        if (n == 10000) {
            drawId=4;
        } else if (n >= 9990) {
            drawId=9;
        } else if (n >= 8500) {
            drawId=8;
        } else if (n >= 8000) {
            drawId = 6;
        } else if (n >= 7000) {
            drawId = 1;
        } else if (n >= 4000) {
            drawId=2;
        }
        return drawId;
    }
}
