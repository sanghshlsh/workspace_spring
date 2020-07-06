<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			bootstrap v3 적용<br>
		</div>
	</div>
	<div class="container">
		<div class="row">
		<h1>글쓰기</h1>
			<form action="/board/insert" method="post">
				<div class="form-group">
				<label for="title">제목</label>
				<input name="title" required id="title" class="form-control">
				</div>
				<div class="form-group"> 
				<label for="writer">작성자</label> 
				<input name="writer" required id="writer" class="form-control"> 
				</div>
				<div class="form-group">
				<label for="content">내용</label>
				<textarea name="content" required rows='5' id="content" class="form-control"> </textarea>
				</div>
			</form>
			<div class="form-group">
				<button class="btn btn-danger" id="insertbtn">등록</button>
				<button class="btn btn-link" id="listbtn">목록</button>
			</div>
		</div>


	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#insertbtn").click(function(){
				$("form").submit();
				});

			$("#listbtn").click(function(){
				location.href="/board/listPage/1";
				});
		
		});
	</script>


</body>
</html>