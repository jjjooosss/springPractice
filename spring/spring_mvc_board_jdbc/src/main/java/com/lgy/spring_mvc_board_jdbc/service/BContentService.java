package com.lgy.spring_mvc_board_jdbc.service;

import com.lgy.spring_mvc_board_jdbc.dao.BDao;
import com.lgy.spring_mvc_board_jdbc.dto.BDto;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BContentService implements BService{
    @Override
    public void execute(Model model) {
        Map<String, Object> map =  model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");
        String bid = request.getParameter("bid");

//		dao 호출
        BDao dao = new BDao();
//		게시글 하나의 내용을 BDto 객체로 받음(bid(글번호)를 넘겨서 select 쿼리 처리)
        BDto dto = dao.contentView(bid);
//		dto 객체를 모델에 추가(뷰에서 꺼내 사용할 수 있도록)
        model.addAttribute("content_view", dto);

    }
}
