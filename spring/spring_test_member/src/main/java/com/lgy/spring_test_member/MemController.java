package com.lgy.spring_test_member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_test_member.command.MemLoginService;
import com.lgy.spring_test_member.command.MemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemController {
	MemService service;

	@RequestMapping("/login")
	public String login() {
		log.info("@# login");
		return "login";
	}

	@RequestMapping("/login_check")
	public String login_check(HttpServletRequest request, Model model){
		log.info("@# login_check");

		model.addAttribute("request", request);
		//아이디 비번이 담긴 리퀘스트, "request"의 이름은 service에있는 (HttpServletRequest)map.get("request");의 이름이다
		service = new MemLoginService();
		int re = service.execute(model);

//		아이디 비번 일치
		if (re == 1){
			return "redirect:login_ok";
		}

		return "redirect:login";
	}

@RequestMapping("/login_ok")
	public String login_ok() {
		log.info("@# login_ok");
		return "login_ok";
	}
}
