package com.lgy.spring_test_item_std.service;

import com.lgy.spring_test_item_std.dto.ItemDto;

import java.util.ArrayList;
import java.util.HashMap;

public interface ItemService {
    public ArrayList<ItemDto> list();
    public void write(HashMap<String, String> param);
}
