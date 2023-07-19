package com.lgy.spring_mvc_board_std.dao;

import com.lgy.spring_mvc_board_std.dto.BDto;
import com.lgy.spring_mvc_board_std.dto.Criteria;

import java.util.ArrayList;
import java.util.HashMap;

public interface IBDao {
    ArrayList<BDto> list();
//    Criteria 객체를 이용해서 페이징 처리
    ArrayList<BDto> listWithPaging(Criteria cri);
    void write(HashMap<String,String> param);
    BDto contentView(HashMap<String,String> param);
    void modify(HashMap<String,String> param);
    void delete(HashMap<String,String> param);
    int getTotalCount();
}
