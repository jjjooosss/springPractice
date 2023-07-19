package com.lgy.spring_mvc_board_jdbc.service;

import com.lgy.spring_mvc_board_jdbc.dao.BDao;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BModifyService implements BService{
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String bid = request.getParameter("bid");
        String btitle = request.getParameter("btitle");
        String bcontent = request.getParameter("bcontent");
        String bname = request.getParameter("bname");

        BDao dao = new BDao();
        dao.modify(bid, bname, btitle, bcontent);

    }
}
