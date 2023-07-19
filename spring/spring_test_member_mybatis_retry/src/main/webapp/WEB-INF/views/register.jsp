<%--
  Created by IntelliJ IDEA.
  User: suhyeon
  Date: 2023-06-12
  Time: 오후 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" align="center">
        <%--폼 등록할 때 controller에 있는 registerOk를 호출함--%>
        <form action="registerOk" method="post">
            <tr align="center">
                <td colspan="2">
                    <h1>회원 가입 신청</h1>
                </td>
            </tr>
            <tr>
                <td>User ID</td>
                <td><input type="text" name="mem_uid"></td>
            </tr>
            <tr>
                <td>PassWord</td>
                <td><input type="text" name="mem_pwd"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="mem_name"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="등록"/>
                </td>
            </tr>
        </form>
    </table>
</body>
</html>
