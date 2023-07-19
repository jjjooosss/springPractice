<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500">
		<form method="post" action="write">
			<tr>
				<td>&nbsp;&nbsp;상품명&nbsp;
				<input type="text" name="name" size="30">
				</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;가격&nbsp;&nbsp;
				<input type="text" name="price" size="30">
				</td>
			</tr>
			<tr>
				<td>상품설명
				<input type="text" name="description" size="30">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
					<input type="reset" value="취소">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>