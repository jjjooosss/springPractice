<%--
  Created by IntelliJ IDEA.
  User: GGG
  Date: 2023-06-12
  Time: 오전 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="login_status" value="${login_status}"/>

<c:choose>
    <c:when test="${login_status eq '1'}">
        <script>
            location = "http://localhost:8091/spring_test_member_mybatis/login_ok"
        </script>
    </c:when>
    <c:when test="${login_status eq '-1'}">
        <script>
            alert("아이디가 존재하지 않습니다");
            history.back(-2);
        </script>
    </c:when>
    <c:otherwise>
        <script>
            alert("비밀번호가 맞지 않습니다");
            history.back(-2);
        </script>
    </c:otherwise>
</c:choose>
</body>
</html>