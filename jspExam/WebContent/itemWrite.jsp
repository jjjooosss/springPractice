<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	   Connection conn = null;
	   Statement stmt =null;
	   ResultSet rs =null;
	   
	   String url="jdbc:oracle:thin:@localhost:1521:xe";
	   String user="scott";
	   String pw="tiger";
   	String sql = "SELECT name, price, description FROM ITEM";
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try{
		String tname = request.getParameter("table");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pw);
		stmt = conn.createStatement();
	
		rs = stmt.executeQuery(sql);
		
		out.print("<table border='1'>");
		while(rs.next()){
		out.print("<tr>");
		out.print("<td>"+rs.getString("name")+"</td>");
		out.print("<td>"+rs.getString("price")+"</td>");
		out.print("<td>"+rs.getString("description")+"</td>");
		out.print("</tr>");
		}
		out.print("</table>");
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e){
			e.printStackTrace();
			}
	}
	%>
</body>
</html>