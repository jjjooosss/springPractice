package com.lgy.spring_join_resultmap.controller;

import com.lgy.spring_join_resultmap.dto.DeptDto;
import com.lgy.spring_join_resultmap.dto.EmpDeptDto;
import com.lgy.spring_join_resultmap.dto.EmpDto;
import com.lgy.spring_join_resultmap.dto.EmpJoinDeptDto;
import com.lgy.spring_join_resultmap.service.EmpinfoService;
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
        ArrayList<EmpJoinDeptDto> list = service.list();

        log.info("@# list =>"+list);
        log.info("@# list.get(0).getEmps() =>"+list.get(0).getEmps());
        log.info("@# list.get(0).getDepts() =>"+list.get(0).getDepts());

        ArrayList<EmpDto> empDtos = list.get(0).getEmps();
        ArrayList<DeptDto> deptDtos = list.get(0).getDepts();

        model.addAttribute("list",list);
        model.addAttribute("list_emp",empDtos);
        model.addAttribute("list_dept",deptDtos);
        return "list";
//        return "";

    }

}
