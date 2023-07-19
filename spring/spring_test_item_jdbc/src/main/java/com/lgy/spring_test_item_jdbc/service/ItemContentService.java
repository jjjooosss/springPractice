package com.lgy.spring_test_item_jdbc.service;

import com.lgy.spring_test_item_jdbc.dao.ItemDao;
import com.lgy.spring_test_item_jdbc.dto.ItemDto;
import org.springframework.ui.Model;

import java.util.ArrayList;

public class ItemContentService implements ItemService{
	@Override
	public void execute(Model model) {
		ItemDao dao = new ItemDao();
		ArrayList<ItemDto> dtos = dao.list();
		model.addAttribute("content_view", dtos);
	}
}
