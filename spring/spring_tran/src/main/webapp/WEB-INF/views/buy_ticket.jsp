<%--
  Created by IntelliJ IDEA.
  User: GGG
  Date: 2023-06-22
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <p>카드 결제</p>
  <form action="buy_ticket_card">
    고객 아이디:<input type="text" name="consumerId"><br>
    티켓 구매수:<input type="text" name="amount"><br>
    <input type="submit" value="구매">
  </form>
</body>
</html>
