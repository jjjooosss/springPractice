package com.boot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dto.MemDto;


@Mapper
public interface MemDao {
//    ArrayList<MemDto> loginOk(HashMap<String, String> param);
    MemDto loginOk(HashMap<String, String> param);
    void register(HashMap<String, String> param);
}
