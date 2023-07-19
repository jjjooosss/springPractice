<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		String sql ="insert into item values(?,?,?)";
	    Connection conn = null;
	    PreparedStatement pstmt =null;
	   
	    String url="jdbc:oracle:thin:@localhost:1521:xe";
	    String user="scott";
	    String pw="tiger";
	   
	   try{
		   	Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, Integer.parseInt(price));
			pstmt.setString(3, description);
			pstmt.executeUpdate();
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	   }
	%>
	<a href="itemWrite.jsp">결과 보기</a>
</body>
</html>