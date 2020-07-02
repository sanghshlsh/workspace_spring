<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
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
scriptlet tag에 선언된 list는 다른곳에서 받아온 list라고 가정<br>
list는 문자열로 변환하여 보내야 한다.						<br>
이는 Jackson bind가 해준다.<br>
<button class="btn"> at4 test </button>
<p> </p>
<%
	List<MemberDTO> list = new ArrayList<MemberDTO>();
	list.add(new MemberDTO("m001","kim",22));
	list.add(new MemberDTO("m002","lee",33));
	list.add(new MemberDTO("m003","park",44));

	ObjectMapper mapper = new ObjectMapper();
	String listStr = mapper.writeValueAsString(list);	//list를 문자열로 바꾸는 과정
	pageContext.setAttribute("listStr", listStr);		//바꾼데이터를 scriptlet 밖에서 사용하기 위해 바인딩

%>


<script type="text/javascript">
$(document).ready(function(){
	$('.btn').click(function(){
			$.ajax({
				type : 'post',
				url : 'at4',
				dataType : 'text',
				data : {
				listStr : JSON.stringify(${listStr}) 	
					} ,
				success : function(result){
					var obj = JSON.parse(result);
					
					$("p").text(obj[0]['id']);
					for(var i = 0 ; i <obj.length ; i++){
						for(x in obj[i]){
							console.log(x);
							console.log(obj[i][x]);
							console.log(":::::::::::::::::::::::")
							}
						}
					}
				
				});

		});	
});


</script>

</body>
</html>