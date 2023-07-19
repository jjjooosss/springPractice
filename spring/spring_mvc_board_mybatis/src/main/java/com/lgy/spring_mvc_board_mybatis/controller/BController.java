package com.lgy.spring_mvc_board_mybatis.controller;

import com.lgy.spring_mvc_board_mybatis.dao.IBDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class BController {
//    BService service;
//    public JdbcTemplate template;

//    @Autowired
//    public void setTemplate(JdbcTemplate template) {
//        this.template = template;
//        Constant.template = this.template;
//    }

//     이렇게하면 servlet-context쪽의 sqlSession 객체에 연결
    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/list")
    public String list(Model model) {
        log.info("@# list");

//        service = new BListService();
//        service.execute(model);

//        getMapper : dao로 연결
        IBDao dao = sqlSession.getMapper(IBDao.class);
//        dao의 list가 xml에 있는 쿼리를 타고 다시 여기로 온다
//        그전엔 이렇게 했었음 model.addAttribute("list",dtos);
//        서비스단에서 처리했던 것을 컨트롤러 단에서 처리
        model.addAttribute("list",dao.list());


        return "list";
    }
    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {
        log.info("@# write");
//        model.addAttribute("request", request);
//        service = new BWriteService();
//        service.execute(model);
        IBDao dao = sqlSession.getMapper(IBDao.class);
//        서비스단에서 처리했던 것을 컨트롤러 단에서 처리
        dao.write(request.getParameter("bname")
                ,request.getParameter("btitle")
                ,request.getParameter("bcontent"));
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

//        model.addAttribute("request", request);
//        service = new BContentService();
//        service.execute(model);
        IBDao dao = sqlSession.getMapper(IBDao.class);
//        BDto dto = dao.contentView(bid); //기존 서비스단에서 처리한것
////		dto 객체를 모델에 추가(뷰에서 꺼내 사용할 수 있도록)
//        model.addAttribute("content_view", dto);
        // 서비스단에서 처리했던 것을 컨트롤러 단에서 처리
        model.addAttribute("content_view", dao.contentView(request.getParameter("bid")));

        return "content_view";
    }
    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, Model model) {
        log.info("@# modify");

//        model.addAttribute("request", request);
//        service = new BModifyService();
//        service.execute(model);
//        서비스단에서 처리했던 것을 컨트롤러 단에서 처리
        IBDao dao = sqlSession.getMapper(IBDao.class);
        dao.modify(request.getParameter("bid")
                ,request.getParameter("bname")
                ,request.getParameter("btitle")
                ,request.getParameter("bcontent"));

        return "redirect:list";
    }
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        log.info("@# delete");

//        model.addAttribute("request", request);
//        service = new BDeleteService();
//        service.execute(model);
//        서비스단에서 처리했던 것을 컨트롤러 단에서 처리
        IBDao dao = sqlSession.getMapper(IBDao.class);
//        dao.delete(bid);
        dao.delete(request.getParameter("bid"));
        return "redirect:list";
    }
}
