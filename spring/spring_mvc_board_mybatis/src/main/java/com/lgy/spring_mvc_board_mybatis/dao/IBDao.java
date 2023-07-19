package com.lgy.spring_mvc_board_mybatis.dao;

import com.lgy.spring_mvc_board_mybatis.dto.BDto;

import java.util.ArrayList;

public interface IBDao {
     ArrayList<BDto> list();
     void write( String bname,  String btitle,  String bcontent);
     BDto contentView(String strID);
//    private void upHit( String bid);
     void modify( String bid,  String bname,  String btitle,  String bcontent);
     void delete( String strID);
}
