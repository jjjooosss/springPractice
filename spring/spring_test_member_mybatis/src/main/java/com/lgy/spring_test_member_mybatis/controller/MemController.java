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

@Controller
@Slf4j
public class MemController {

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/login")
    public String login(){
        log.info("@# login======>");
        return "login";
    }

    @RequestMapping("/login_yn")
    public String login_yn(HttpServletRequest request, Model model) {
        log.info("@# login_yn======>");

        MemDao dao = sqlSession.getMapper(MemDao.class);
        ArrayList<MemDto> dtos = dao.loginYn(request.getParameter("mem_uid"));
        int re = -1;
        String pwd = request.getParameter("mem_pwd");
        if (dtos.isEmpty()) {
            
        } else {
            MemDto memDto = dtos.get(0);

            if (memDto.getMem_pwd().equals(pwd)) {
                re = 1;
                
            } else {
                re = 0;
            }
        }
        model.addAttribute("login_status",re);
        return "login_check";
    }
    @RequestMapping("/login_ok")
    public String login_ok(){
        log.info("@# login_ok======>");
        return "login_ok";
    }
    @RequestMapping("/register")
    public String register(){
        log.info("@# register======>");
        return "register";
    }
    @RequestMapping("/register_ok")
    public String register_ok(HttpServletRequest request, Model model){
        log.info("@# register_ok======>");

        MemDao dao = sqlSession.getMapper(MemDao.class);
        dao.register(request.getParameter("mem_uid")
                    ,request.getParameter("mem_pwd")
                    ,request.getParameter("mem_name"));
        return "redirect:login";
    }
}
