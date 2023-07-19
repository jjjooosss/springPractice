
<%--
  Created by IntelliJ IDEA.
  User: suhyeon
  Date: 2023-06-12
  Time: 오후 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="loginStatus" value="${loginStatus}"/>

<c:choose>
    <c:when test="${loginStatus eq '1'}">
        <script>
            location = "http://localhost:8090/spring_test_member_std/loginSuccess"
        </script>
    </c:when>
    <c:when test="${loginStatus eq '-1'}">
        <script>
            alert("아이디가 존재하지 않습니다");
            history.back(-1);
        </script>
    </c:when>
    <c:otherwise>
        <script>
            alert("비밀번호가 맞지 않습니다");
            history.back(-1);
        </script>
    </c:otherwise>
</c:choose>
</body>
</html>

