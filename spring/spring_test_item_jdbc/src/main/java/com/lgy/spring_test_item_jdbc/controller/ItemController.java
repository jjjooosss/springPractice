package com.lgy.spring_test_item_jdbc.controller;

import com.lgy.spring_test_item_jdbc.service.ItemContentService;
import com.lgy.spring_test_item_jdbc.service.ItemService;
import com.lgy.spring_test_item_jdbc.service.ItemWriteService;
import com.lgy.spring_test_item_jdbc.util.Constant;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class ItemController {
	ItemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list");
		
		service = new ItemContentService();
		service.execute(model);
		return "content_view";
	}
	
	@RequestMapping("/write")
	public String writeResult(HttpServletRequest request, Model model) {
		log.info("@# write");
		
		model.addAttribute("request", request);
		service = new ItemWriteService();
		service.execute(model);
		return "writeResult";
	}
	@RequestMapping("/writeOk")
	public String write() {
		log.info("@# write");
		
		return "itemWrite";
	}
}
