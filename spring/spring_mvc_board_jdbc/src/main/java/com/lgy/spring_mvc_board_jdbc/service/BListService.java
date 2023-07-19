package com.lgy.spring_mvc_board_jdbc.service;

import com.lgy.spring_mvc_board_jdbc.dao.BDao;
import com.lgy.spring_mvc_board_jdbc.dto.BDto;
import org.springframework.ui.Model;

import java.util.ArrayList;

public class BListService implements BService {

    @Override
    public void execute(Model model) {
        BDao dao = new BDao();
//			게시글들을 dtos 객체로 받음
        ArrayList<BDto> dtos = dao.list();
//			void타입일때 데이터 보내는건 model 사용
//			dtos 객체를 list 이름으로 컨트롤러단으로 전송
        model.addAttribute("list", dtos);
    }
}
