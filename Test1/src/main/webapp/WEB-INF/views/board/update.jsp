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
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>수정</h1>		
		</div>
		<div class="row">
		<form action="/board/update" method="post">
			<input value="${vo.bno }" type="hidden" name="bno">
			<div class="form-group">
				<label for="title">제목</label>
				<input required value="${vo.title }" class="form-control" name="title">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input required value="${vo.writer }" class="form-control" name="writer">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea required class="form-control" rows="5" name="content"> ${vo.content }</textarea>
			</div>
			</form>
		</div>
		<div class="row">
			<div class="form-group">
				<button class="btn btn-warning" id="updatebtn">수정</button>
				<button class="btn btn-primary" id="listbtn">목록</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("div").on("click","#updatebtn",function(){
				$("form").submit();
			});
			$("div").on("click","#listbtn",function(){
				location.assign("/board/list");
			});
		});

	</script>

</body>
</html>