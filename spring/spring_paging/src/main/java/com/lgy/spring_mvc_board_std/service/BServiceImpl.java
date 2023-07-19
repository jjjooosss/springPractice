package com.lgy.spring_mvc_board_std.service;

import com.lgy.spring_mvc_board_std.dao.IBDao;
import com.lgy.spring_mvc_board_std.dto.BDto;
import com.lgy.spring_mvc_board_std.dto.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
//Service단인것을 인텔리제이에게 알려주지않으면 Autowired의 경고표시 사라지지않음
@Service("service")
public class BServiceImpl implements BService{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public ArrayList<BDto> list() {
        log.info("@# BServiceImpl.list() start");
        IBDao dao = sqlSession.getMapper(IBDao.class);
//        model.addAttribute("list",dao.list());
//        모델에 담을 필요 x
        ArrayList<BDto> list = dao.list();
        log.info("@# BServiceImpl.list() end");
        return list;
    }

    @Override
    public ArrayList<BDto> list(Criteria cri) {
        log.info("@# BServiceImpl.list(Criteria cri) start");
        log.info("@# cri =========>"+cri);

        IBDao dao = sqlSession.getMapper(IBDao.class);

        log.info("@# BServiceImpl.list(Criteria cri) end");

        return dao.listWithPaging(cri);
    }

    @Override
    public void write(HashMap<String, String> param) {
        log.info("@# BServiceImpl.write() start");
        IBDao dao = sqlSession.getMapper(IBDao.class);
//        dao.write(request.getParameter("bname")
//                ,request.getParameter("btitle")
//                ,request.getParameter("bcontent"));
        dao.write(param);
        log.info("@# BServiceImpl.write() end");
    }

    @Override
    public BDto contentView(HashMap<String, String> param) {
        log.info("@# BServiceImpl.contentView() start");

        IBDao dao = sqlSession.getMapper(IBDao.class);
//        model.addAttribute("content_view", dao.contentView(request.getParameter("bid")));
        BDto dto = dao.contentView(param);

        log.info("@# BServiceImpl.contentView() end");

        return dto;
    }

    @Override
    public void modify(HashMap<String, String> param) {
        log.info("@# BServiceImpl.modify() start");

        IBDao dao = sqlSession.getMapper(IBDao.class);
//        dao.modify(request.getParameter("bid")
//                ,request.getParameter("bname")
//                ,request.getParameter("btitle")
//                ,request.getParameter("bcontent"));
//
//        return "redirect:list";
        dao.modify(param);
        log.info("@# BServiceImpl.modify() end");

    }

    @Override
    public void delete(HashMap<String, String> param) {
        log.info("@# BServiceImpl.delete() start");

        IBDao dao = sqlSession.getMapper(IBDao.class);
        dao.delete(param);
        log.info("@# BServiceImpl.delete() end");

    }

    @Override
    public int getTotalCount() {
        log.info("@# BServiceImpl.getTotalCount()");
        IBDao dao = sqlSession.getMapper(IBDao.class);

        return dao.getTotalCount();
    }
}
