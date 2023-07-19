package com.lgy.spring_mvc_board_std.dao;

import com.lgy.spring_mvc_board_std.dto.BDto;

import java.util.ArrayList;
import java.util.HashMap;

public interface IBDao {
    ArrayList<BDto> list();
//    void write( String bname,  String btitle,  String bcontent);
    void write(HashMap<String,String> param);
//    BDto contentView(String strID);
    BDto contentView(HashMap<String,String> param);
    //    private void upHit( String bid); 생략
//    void modify( String bid,  String bname,  String btitle,  String bcontent);
    void modify(HashMap<String,String> param);
//    void delete( String strID)
    void delete(HashMap<String,String> param);
}
