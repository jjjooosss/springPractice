package com.lgy.spring_test_member.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemDao {
	DataSource dataSource;
	public MemDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int loginCheck(String id, String pw) {
		int re = -1;
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;

		String db_pw = null;
		try {
			conn =dataSource.getConnection();
			String sql ="select mem_pwd from mvc_member where mem_uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()){//아이디가 있는 경우
				db_pw = rs.getString("mem_pwd");
				if (db_pw.equals(pw)){//데이터 베이스 조회된 비밀번호 = 파라미터의 비밀번호
					re=1;
				}else {//데이터 베이스 조회된 비밀번호 != 파라미터의 비밀번호
					re=0;
				}
			}else {}//아이디가 없는 경우(기본값 -1)
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return re;

	}
}
//sql 로그
//	CREATE TABLE MVC_MEMBER(
//		MEM_UID VARCHAR2(15),
//	MEM_PWD VARCHAR2(15),
//	MEM_NAME VARCHAR2(10)
//);
//
//		select mem_uid, mem_pwd from mvc_member where mem_uid=?;
//		insert into mvc_member values('aaa','123','abc');