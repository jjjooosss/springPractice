<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.div_page ul{
			display: flex;
			list-style: none;
		}
	</style>
</head>
<body>
	<table width="500" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bid}</td>
				<td>${dto.bname}</td>
				<td>
<%-- 					<a href="content_view?bid=${dto.bid}">${dto.btitle}</a> --%>
					<a class="move_link" href="${dto.bid}">${dto.btitle}</a>
				</td>
				<td>${dto.bdate}</td>
				<td>${dto.bhit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<a href="write_view">글작성</a>
			</td>
		</tr>
	</table>
	
	<form id="searchForm" method="get">
		<select name="type">
			<option value="" <c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
			<option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
			<option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
			<option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
			<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 or 내용</option>
			<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 or 작성자</option>
			<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW'?'selected':''}"/>>제목 or 내용 or 작성자</option>
		</select>
<!-- 	Criteria 를 이용해서 키워드 값을 넘김 -->
		<input type="text" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>
		<button>Search</button>
	</form>
	
	<h3>${pageMaker}</h3>
	
	<div class="div_page">
		<ul>
			<c:if test="${pageMaker.prev}">
				<li class="paginate_button">
<!-- 					시작페이지 - 1 하면 이전의 10개 페이지 표시 -->
<!-- 				ex>11->10(1~10), 21->20(11~20) -->
					<a href="${pageMaker.startPage - 1}">
						[Previous]
					</a>
				</li>
			</c:if>
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
<%-- 				<li>${num}</li> --%>
<%-- 				<li ${pageMaker.cri.pageNum == num ? "style='color:red'":""} > --%>
<!-- 				현재 페이지는 배경색 노란색으로 표시 -->
				<li class="paginate_button" ${pageMaker.cri.pageNum == num ? "style='background-color:yellow'":""} >
<!-- 					클릭한 현재페이지 번호를 링크로 연결 -->
					<a href="${num}">
						[${num}]
					</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next}">
				<li class="paginate_button">
<!-- 					끝페이지 + 1 하면 이후의 10개 페이지 표시 -->
<!-- 				ex>10->11(11~20), 20->21(21~30) -->
					<a href="${pageMaker.endPage + 1}">
						[Next]
					</a>
				</li>
			</c:if>
		</ul>
	</div>
	
<!-- 	<form method="get" id="actionForm" action="list"> -->
<!-- actionForm.attr 에서 list or content_view 로 submit 해서 action 삭제 -->
	<form method="get" id="actionForm">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
<%-- 		<input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type }"/>'>  --%>
<%-- 		<input type='hidden' name='keyword' value='<c:out value="${ pageMaker.cri.keyword }"/>'> --%>
		<input type='hidden' name='type' value="${ pageMaker.cri.type }"> 
		<input type='hidden' name='keyword' value="${ pageMaker.cri.keyword }">
	</form>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var actionForm = $("#actionForm");
	
// 	페이지번호 처리
	$(".paginate_button a").on("click", function(e){
// 		기본 동작 막음: 페이지 링크를 통해서 이동
		e.preventDefault();
// 		console.log("click~!!!");
		
// 		게시글 클릭후 뒤로가기 누를때 &bid=번호 계속 누적되는거 방지
		var bno = actionForm.find("input[name='bid']").val();
		if (bno != '') {
			actionForm.find("input[name='bid']").remove();
		}
		
		console.log("@# href ===>"+$(this).attr("href"));
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
// 		actionForm.submit();
// 		게시글 클릭후 뒤로가기 누를때 content_view 찾아가는거 방지
		actionForm.attr("action","list").submit();
	});
	
// 	게시글 처리
	$(".move_link").on("click",function(e){
		e.preventDefault();
		var targetBno = $(this).attr("href");
// 		console.log("move click~!!!");
// 		console.log("@# href ===>"+$(this).attr("href"));
		
		history.replaceState({}, null, null);
// 		게시글 클릭후 뒤로가기 누를때 &bid=번호 계속 누적되는거 방지
		var bno = actionForm.find("input[name='bid']").val();
		if (bno != '') {
			actionForm.find("input[name='bid']").remove();
		}


// "content_view?bid=${dto.bid}" 에 있는 ?bid= 의 bid 와 name 을 매칭
		actionForm.append("<input type='hidden' name='bid' value='"+targetBno+"'>")
// 		actionForm.attr("action","content_view");//오류
// 컨트롤러에 content_view 로 찾아감
		actionForm.attr("action","content_view").submit();
	});
	
	var searchForm = $("#searchForm");
	
// 	Search 버튼 클릭
	$("#searchForm button").on("click",function(){
// 		validation check
		if(!searchForm.find("option:selected").val()){
			alert("검색종류를 선택하세요");
			return false;
		}
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요");
			return false;
		}
		
		searchForm.attr("action","list").submit();
	});
</script>















