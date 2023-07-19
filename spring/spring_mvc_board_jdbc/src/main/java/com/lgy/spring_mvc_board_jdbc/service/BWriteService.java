package com.lgy.spring_mvc_board_jdbc.service;

import com.lgy.spring_mvc_board_jdbc.dao.BDao;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BWriteService implements BService {

    @Override
    public void execute(Model model) {
        Map<String, Object> map = model.asMap();
//		request : 컨트롤러 단에서 보내주는 이름
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String bname = request.getParameter("bname");
        String btitle = request.getParameter("btitle");
        String bcontent = request.getParameter("bcontent");

        BDao dao = new BDao();
//		dao만 호출
        dao.write(bname, btitle, bcontent);
    }
}
