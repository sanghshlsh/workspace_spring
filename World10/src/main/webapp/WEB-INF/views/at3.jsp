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
	데이터를 json 형태로 넣어야한다.<br>
	데이터를 json 형태로 넘겨주고 <br>
	<button id="btn">at3 test</button>
	<p class="name"></p>
	<p></p>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btn").click(function() {
				$.ajax({
					type : 'post',
					url : 'at3',
					dataType : 'text',
					data : {
						'id' : 'm006',
						'name' : 'lee',
						'age' : 33
					},
					success : function(result) {
						$("p").text(result);
						var obj = JSON.parse(result);
						console.log(obj.id);
						$(".name").text(obj.name);
						console.log(obj.age);
					},
					error : function(request, status, error) {
						$("p").text(error);
					}
				});
			});
		});
	</script>

</body>
</html>