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
			<h1>글 자세히 보기</h1>		
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-sm-6"></div>
				<div class="col-sm-2">
					<label for="bno">글번호</label>
					<input readonly value="${vo.bno }" class="form-control">
				</div>
				<div class="col-sm-2">
					<label for="viewcnt">조회수</label>
					<input readonly value="${vo.viewcnt }" class="form-control">
				</div>
				<div class="col-sm-2">
					<label for="regDate">작성일</label>
					<input readonly value="${vo.regDate }" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="title">제목</label>
				<input readonly value="${vo.title }" class="form-control">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input readonly value="${vo.writer }" class="form-control">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea readonly class="form-control" rows="5"> ${vo.content }</textarea>
			</div>
			<div class="form-group">
				<label for="updateDate">수정일</label>
				<input readonly value="${vo.updateDate }" class="form-control">
			</div>
		</div>
		<div class="row">
			<div class="form-group" id="btnDiv">
				<button class="btn btn-info"  id="reply_form">댓글</button>
				<button class="btn btn-warning" id="update">수정</button>
				<button class="btn btn-danger" id="delete">삭제</button>
				<button class="btn btn-primary" id="list">목록</button>
			</div>
		</div><!--  class = row -->
		<div class="row">
			<div class="collapse" id="myCollapsible">
				<div class="form-group">
					<label for="replyer">작성자</label>
					<input class="form-control" id="replyer"><!-- form으로 묶어 데이터를 보내는 것이 아닌 ajax로 데이터를 보내기 때문에 name태그가 필요 없고 id태그가 필요하다.-->
				</div>
				
				<div class="form-group">
					<label for="replytext">내용</label>
					<input class="form-control" id="replytext">
				</div>
		
				<div class="form-group">
					<button class="btn btn-primary" id="replyInsertBtn">댓글 등록</button>
				</div>
				
			</div>
		</div>
		<div class="row" id="replies"><%--이 내부 코드들은 이미 아래 getList(bno) 함수에 넣어 두었기에  삭제해도 무관한 코드들 --%>
			<div class="panel panel-success">
  				<div class="panel-heading">
  					<span>rno : 3</span>, <span>작성자 : 홍길동 </span>
  					<span class="pull-right">2020년 7월 7일 ...</span>
  				</div>
  				<div class="panel-body">
    				<p> 댓글 내용입니다.</p>
    				<%-- 커스텀 데이터 속성 data- 로 시작 --%>
    				<button data-rno="3" class="btn btn-warning btn-xs replymodify"> 수정 </button>
    				<button data-rno="3" class="btn btn-danger btn-xs replydelete"> 삭제 </button>
  				</div>
			</div>
		</div>
		
	</div><!-- class = container -->	
	
	<script type="text/javascript">
		$(document).ready(function(){
			var bno = ${vo.bno};

			getList(bno);
			
			$("#btnDiv").on("click","#update",function(){
				location.assign("/board/update/${vo.bno}");
			});
			$("#btnDiv").on("click","#delete",function(){
				location.assign("/board/delete/${vo.bno}");
			});
			$("#btnDiv").on("click","#list",function(){
				location.assign("/board/list");
			});
			$("#btnDiv").on("click","#reply_form",function(){
				$("#myCollapsible").collapse("toggle");
			});
			
			$('#replyInsertBtn').click(function(){ 				
				var replyer = $('#replyer').val();
				var replytext = $('#replytext').val();				
				$.ajax({
					type: 'post',
					url: '/replies',  
					headers: {
						"Content-Type": "application/json",
						"X-HTTP-Method-Override": "POST"
					},
					dataType: 'text',
					data: JSON.stringify({
						bno: bno,  
						replyer: replyer,
						replytext: replytext
					}),
					success : function(result){
						$('#replyer').val("");
						$('#replytext').val("");

						getList(bno);
					},
					error : function(request,status,error){
						console.log(error);
					}		
				});		
			});

			$("#replies").on("click",".replymodify",function(){
				var rno = $(this).attr("data-rno");
				alert(rno+"번 : 수정버튼이 눌렸습니다.");
			});

			$("#replies").on("click",".replydelete",function(){
				var rno = $(this).attr("data-rno");
				alert(rno+"번 : 삭제버튼이 눌렸습니다.");

				$(this).parent().parent().remove();
			});				
		});

		function getList(bno){
			var str = '';			
			$.getJSON("/replies/all/"+bno, function(data){
				for(var i = 0 ; i < data.length ; i++){
					str += '<div class="panel panel-success"><div class="panel-heading"><span>rno : '+ data[i]["rno"]+'</span>, <span>작성자 :'+ data[i]["replyer"]+'</span><span class="pull-right">'+data[i]["updatedate"]+'</span></div><div class="panel-body"><p> '+data[i]["replytext"]+'</p><button data-rno="'+ data[i]["rno"] +'" class="btn btn-warning btn-xs replymodify"> 수정 </button><button data-rno="'+ data[i]["rno"] +'" class="btn btn-danger btn-xs replydelete"> 삭제</button></div></div>';
				}
				$("#replies").html(str);				
			});
		}

	</script>

</body>
</html>