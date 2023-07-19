package com.lgy.spring_test_member_mybatis.controller;

import com.lgy.spring_test_member_mybatis.dao.MemDao;
import com.lgy.spring_test_member_mybatis.dto.MemDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Slf4j
@Controller
public class MemController {

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("register")
    public String register(){
        log.info("register");

        return "register";
    }
    @RequestMapping("login")
    public String login(){
        log.info("login");

        return "login";
    }
    @RequestMapping("loginSuccess")
    public String loginSuccess(){
        log.info("loginSuccess");

        return "loginSuccess";
    }
    @RequestMapping("loginOk")
    public String loginOk(HttpServletRequest request, Model model){
        log.info("loginOk");
        model.addAttribute("request", request);
        int re = -1;

        MemDao dao = sqlSession.getMapper(MemDao.class);
        String memUid = request.getParameter("mem_uid");
        System.out.println(memUid);
        ArrayList<MemDto> login = dao.loginOk(request.getParameter("mem_uid"));
        if (!login.isEmpty()){
            String memPwd = login.get(0).getMem_pwd();
            re = (memPwd.equals(request.getParameter("mem_pwd"))) ? 1:0;
        }
        model.addAttribute("loginStatus",re);
        return "loginOk";
    }
    @RequestMapping("registerOk")
    public String registerOk(HttpServletRequest request, Model model){
        log.info("registerOk");
        model.addAttribute("request",request);
        MemDao dao = sqlSession.getMapper(MemDao.class);
        dao.register(request.getParameter("mem_uid"),
                     request.getParameter("mem_pwd"),
                     request.getParameter("mem_name"));
        return "redirect:login";
    }

}
