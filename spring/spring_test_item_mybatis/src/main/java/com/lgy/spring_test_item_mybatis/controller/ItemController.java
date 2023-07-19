package com.lgy.spring_test_item_mybatis.controller;

import com.lgy.spring_test_item_mybatis.dao.ItemDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class ItemController {

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/list")
    public String list(Model model) {
        log.info("@# list");
        ItemDao dao = sqlSession.getMapper(ItemDao.class);
        model.addAttribute("list",dao.list());

        return "content_view";
    }

    @RequestMapping("/write")
    public String writeResult(HttpServletRequest request, Model model) {
        log.info("@# writeResult");

        ItemDao dao = sqlSession.getMapper(ItemDao.class);
        dao.write(request.getParameter("name")
                    ,request.getParameter("price")
                    ,request.getParameter("description"));
        return "writeResult";
    }
    @RequestMapping("/writeOK")
    public String write() {
        log.info("@# write");

        return "itemWrite";
    }
}