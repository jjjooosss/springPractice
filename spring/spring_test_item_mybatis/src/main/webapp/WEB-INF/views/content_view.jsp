<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="500" border="1">
		<tr>
			<td>상품명</td>
			<td>가격</td>
			<td>설명</td>
		</tr>
<!-- 		list : 모델 객체에서 보낸 이름 -->
	<c:forEach items="${list}" var="dao">
		<tr>
			<td>${dao.name}</td>
			<td>${dao.price}</td>
			<td>${dao.description}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3">
			<a href="writeOk">글 작성하기</a>
		</td>
	</tr>
	</table>
</body>
</html>