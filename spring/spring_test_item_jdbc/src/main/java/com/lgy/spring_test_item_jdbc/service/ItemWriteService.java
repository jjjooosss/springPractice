package com.lgy.spring_test_item_jdbc.service;

import com.lgy.spring_test_item_jdbc.dao.ItemDao;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ItemWriteService implements ItemService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		ItemDao dao = new ItemDao();
		dao.write(name, price, description);
	}
}
