package com.lgy.spring_join_resultmap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpJoinDeptDto {
//    테이블 기본 Dto 활용
    private ArrayList<EmpDto> emps;
    private ArrayList<DeptDto> depts;
}
