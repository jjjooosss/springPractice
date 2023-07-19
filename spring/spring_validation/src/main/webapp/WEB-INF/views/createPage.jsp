<%--
  Created by IntelliJ IDEA.
  User: GGG
  Date: 2023-06-22
  Time: 오후 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   createPage.jsp입니다.
    <form action="/student/create">
      아이디 : <input type="text" name="id"><br>
      비밀번호 : <input type="password" name="pw"><br>
      <input type="submit" value="전송">
    </form>
</body>
</html>
