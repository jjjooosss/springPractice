package com.lgy.spring_mvc_board_jdbc.controller;

import com.lgy.spring_mvc_board_jdbc.service.*;
import com.lgy.spring_mvc_board_jdbc.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class BController {
//    BCommand service;
    BService service;
    public JdbcTemplate template;

//    @Autowired : spring template를 자동으로 끌고 와줌
//    servlet-context.xml에 있는 template 객체를 저장(this.template)
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
//        Constant.template 를 dao에서 사용
        Constant.template = this.template;
    }

    //	게시판 목록 조회
    @RequestMapping("/list")
    public String list(Model model) {
        log.info("@# list");

//		service(service) 단 호출
//		BListCommand service =  new BListCommand();
//		저장, 수정, 삭제 할 때마다 객체 생성 할 필요 없이 인터페이스 활용하면 됨
        service = new BListService();
        service.execute(model);

        return "list";
    }
    //	request: 뷰에서 값을 받아옴
    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        log.info("@# write");
//		request 에 bname, btitle, bcontent 값들이 있음
        model.addAttribute("request", request);
//		service 단 호출
        service = new BWriteService();
        service.execute(model);
//		model 에 request 를 담고 있음
//		글작성 후 다시 list로 리다이렉트됨
        return "redirect:list";
    }

    @RequestMapping("/write_view")
    public String write_view() {
        log.info("@# write_view");

        return "write_view";
    }

    @RequestMapping("/content_view")
    public String content_view(HttpServletRequest request, Model model) {
        log.info("@# content_view");

        model.addAttribute("request", request);
        service = new BContentService();
        service.execute(model);

        return "content_view";
    }
    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, Model model) {
        log.info("@# modify");

        model.addAttribute("request", request);
        service = new BModifyService();
        service.execute(model);

        return "redirect:list";
    }
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        log.info("@# delete");

        model.addAttribute("request", request);
        service = new BDeleteService();
        service.execute(model);

        return "redirect:list";
    }
}
