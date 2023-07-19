package com.lgy.spring_join.controller;

import com.lgy.spring_join.dto.EmpDeptDto;
import com.lgy.spring_join.service.EmpinfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@Slf4j
public class EmpInfoController {
    @Autowired
    private EmpinfoService service;
    @RequestMapping("/list")
    public String list(Model model){
        log.info("@# EmpInfoController.list()");
        ArrayList<EmpDeptDto> list = service.list();
        model.addAttribute("list",list);
        return "list";
    }

}
