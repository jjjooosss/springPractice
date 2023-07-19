<%--
  Created by IntelliJ IDEA.
  User: suhyeon
  Date: 2023-06-10
  Time: 오후 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--폼 등록할 때 controller에 있는 register_ok를 호출함--%>
<form method="post" action="register_ok">
    <table border="1" align="center">
        <tr>
            <td colspan="2">
                <h1>회원 가입 신청</h1>
            </td>
        </tr>
        <tr>
            <td>User ID</td>
            <td><input type="text" name="mem_uid" /></td>
        </tr>
        <tr>
            <td>암호</td>
            <td><input type="text" name="mem_pwd" /></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="mem_name" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="등록" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
