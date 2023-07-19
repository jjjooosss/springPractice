package com.lgy.spring_mvc_board_std.service;

import com.lgy.spring_mvc_board_std.dto.BDto;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;

public interface BService {
//    public void execute(Model model);
    ArrayList<BDto> list();
    void write(HashMap<String,String> param);
    BDto contentView(HashMap<String,String> param);
    void modify(HashMap<String,String> param);
    void delete(HashMap<String,String> param);
}
