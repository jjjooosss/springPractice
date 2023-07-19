package com.lgy.spring_test_item_mybatis.dao;

import com.lgy.spring_test_item_mybatis.dto.ItemDto;

import java.util.ArrayList;

public interface ItemDao {
    public ArrayList<ItemDto> list();
    public void write( String name, String price, String description);
}
