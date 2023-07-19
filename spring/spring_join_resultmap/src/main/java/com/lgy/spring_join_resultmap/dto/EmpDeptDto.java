package com.lgy.spring_join_resultmap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDeptDto {
//    조인을 많이 하기 때문에 아래와 같은 형식으로 많이 사용
//    emp table
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Timestamp hiredate;
    private int sal;
    private int comm;
//    private int deptno;
//dept table
    private int deptno;
    private String dname;
    private String loc;
}
