package com.lgy.spring_join_resultmap.dao;

import com.lgy.spring_join_resultmap.dto.EmpJoinDeptDto;

import java.util.ArrayList;

public interface EmpInfoDao {
//    public ArrayList<EmpDto> list();
//    public ArrayList<EmpDeptDto> list();
    public ArrayList<EmpJoinDeptDto> list();
}
