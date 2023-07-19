package com.lgy.spring_mvc_board_std.service;

import com.lgy.spring_mvc_board_std.dto.BDto;
import com.lgy.spring_mvc_board_std.dto.Criteria;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;

public interface BService {
//    페이징 처리 없는 목록
    ArrayList<BDto> list();
//    페이징 처리 하는 목록(오버로딩함)
    ArrayList<BDto> list(Criteria cri);
    void write(HashMap<String,String> param);
    BDto contentView(HashMap<String,String> param);
    void modify(HashMap<String,String> param);
    void delete(HashMap<String,String> param);
    int getTotalCount();
}
