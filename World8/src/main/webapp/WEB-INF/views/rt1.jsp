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
	버튼위 부모태그인 body를 통해 버튼을 클릭하는 방법
	'X-HTTP-Method-Override' : 'POST' --이 post는 ajax의 type과 관련있다.
	ajax의 type은 /조회get/입력post/수정put/삭제delete사용.
	<br>
	<button>rt1 Test</button>
	<p></p>

	<script type="text/javascript">
		$(document).ready(function() {
			$("body").on("click", "button", function() {
				var test1 = "hello";

				$.ajax({
					type : 'post',
					url : 'rt1',
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'POST'
						},
					dataType : 'text',
					data : JSON.stringify({
					test1 : test1
						}),
					success : function(result){
						console.log(result);
						}
					
					
				});
			});
		});
	</script>

</body>
</html>