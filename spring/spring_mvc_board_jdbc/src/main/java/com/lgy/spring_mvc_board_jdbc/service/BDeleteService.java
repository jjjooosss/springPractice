package com.lgy.spring_mvc_board_jdbc.service;

import com.lgy.spring_mvc_board_jdbc.dao.BDao;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BDeleteService implements BService{
    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest)map.get("request");
        String bid = request.getParameter("bid");

        BDao dao = new BDao();
        dao.delete(bid);
    }
}
