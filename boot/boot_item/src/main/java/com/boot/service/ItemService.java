package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.boot.dto.ItemDto;

public interface ItemService {
    public ArrayList<ItemDto> list();
    public void write(HashMap<String, String> param);
}
