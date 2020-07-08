<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<title>Insert title here</title>
<style type="text/css">
	.th-center{
		text-align: center;
	}

</style>

</head>
<body>
	<div class="container">
		<div class="row text-center">
			<h1>목록</h1>
		</div>
	

	
	<div class="row">
		<a href="/board/insert">글쓰기</a>
	</div>
	
	<div class="row">
		<table class="table table-bordered">
			<thead>
			<tr>
				<th class="th-center">글번호</th>
				<th class="th-center" style="width: 50%">제목</th>
				<th class="th-center">작성자</th>
				<th class="th-center">작성일</th>
				<th class="th-center">조회수</th>
			</tr>
			</thead>
			
			<tbody>
	<c:forEach items="${to.list }" var="dto">
		<tr>
			<td>${dto.bno}</td>
			<td><a href="/board/read/${dto.bno}">${dto.title}</a></td>
			<td>${dto.writer}</td>
			<td>${dto.regDate}</td>
			<td>${dto.viewcnt}</td>
		</tr> 
	</c:forEach>


</tbody>
		</table>
	</div>
		<div class="row text-center">
			<nav aria-label="Page navigation example">
  				<ul class="pagination">
  					<c:if test="${1<to.curPage }">
   					<li class="page-item"><a class="page-link" href="/board/listPage/${to.curPage-1 }">Previous</a></li>
   					</c:if>
    				<c:forEach begin="${to.beginPageNum }" end="${to.stopPageNum }" step="1" var="num">
    				<c:if test="${to.curPage eq num }"> 
    				<li class="page-item active" aria-current="page"><a class="page-link" href="/board/listPage/${num}">${num}</a></li>
    				</c:if>
    				<c:if test="${to.curPage ne num }">
    				<li class="page-item"><a class="page-link" href="/board/listPage/${num}">${num}</a></li>
    				</c:if>
    				</c:forEach>
    				<c:if test="${to.totalPage>to.curPage }"> 
    				<li class="page-item"><a class="page-link" href="/board/listPage/${to.curPage+1 }">Next</a></li>
    				</c:if>
 	 			</ul>
			</nav>
		</div>
	</div>

</body>
</html>