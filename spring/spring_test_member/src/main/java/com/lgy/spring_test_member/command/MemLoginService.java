package com.lgy.spring_test_member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.spring_test_member.dao.MemDao;

public class MemLoginService implements MemService {
	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String uid = request.getParameter("mem_uid");
		String pwd = request.getParameter("mem_pwd");
		
		MemDao dao = new MemDao();
		int re = dao.loginCheck(uid,pwd);
//		컨트롤러에 re전달(0,1,-1 중에서)
		return re;
	}

}
