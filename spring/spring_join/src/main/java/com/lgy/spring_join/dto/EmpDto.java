package com.lgy.spring_join.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {
//    단일 테이블 컬럼 Dto는 조인 Dto에 비해서 상대적으로 사용이 저조함
//    조인시 필요한 컬럼 외에도 나머지 컬럼들도 다 가져옴(차후 쿼리 추가나 변경 고려)
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Timestamp hiredate;
    private int sal;
    private int comm;
    private int deptno;
}
