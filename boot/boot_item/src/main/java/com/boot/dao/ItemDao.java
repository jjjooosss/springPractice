package com.boot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dto.ItemDto;

@Mapper
public interface ItemDao {
    public ArrayList<ItemDto> list();
    public void write(HashMap<String, String> param);
}
