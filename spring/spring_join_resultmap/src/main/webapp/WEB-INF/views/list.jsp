<%--
  Created by IntelliJ IDEA.
  User: GGG
  Date: 2023-06-19
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h3>${list}</h3>--%>
<table width="500" border="1">
    <tr>
        <td>사원번호</td>
        <td>이름</td>
        <td>부서번호</td>
        <td>부서명</td>
    </tr>
<%--    varStatus ="status" 속성을 주고, status.index는 0부터 c:foreach 돌면서 같이 반복--%>
    <c:forEach items="${list_emp}" var="dto" varStatus="status">
        <tr>
            <td>${dto.empno}</td>
            <td>${dto.ename}</td>
            <td>${list_dept[status.index].deptno}</td>
            <td>${list_dept[status.index].dname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
