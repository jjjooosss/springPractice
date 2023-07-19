package com.boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@ResponseBody
public class DemoController {
	@ResponseBody
	@RequestMapping("/")
	public String home() {
		log.info("Boot Gradle~~!!!");
		return "gradle";
	}
	
	@RequestMapping("/hello.do")
	public String home(Model model) {
		log.info("안녕하세요~~!!!");
		model.addAttribute("message","hello.jsp입니다.");
		return "hello";
	}

}
