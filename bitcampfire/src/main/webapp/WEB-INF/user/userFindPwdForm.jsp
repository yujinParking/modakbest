<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>bitcampfire - 회원정보 수정</title>
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/semiproject/css/user/application.css">
</head>
<body>
<div class="layout-container">
 	<div class="main">
 		<jsp:include page="/WEB-INF/user/userSideBar.jsp"/>

<!-- -----------------------------------userFindPwdForm-------------------------------- -->


<div id="create-user" class="content" role="main">
	<h3 class="content-header">계정 찾기</h3>
	<form action="/find/user/send" method="post">
			<input type="hidden" name="_csrf" value="03c8d70f-65d7-480d-b5c5-0a61a07e163d">
		<div class="col-sm-8 col-sm-offset-2">
		    <div class="panel panel-default panel-margin-10">
		        <div class="panel-body panel-body-content text-center">
		            <p class="lead">이메일 주소를 입력해 주세요.</p>
		            <p>회원 가입시 입력하신 이메일 주소를 입력하시면,<br> 해당 이메일로 아이디 및 비밀번호 변경 링크를 보내드립니다.</p>
		            <!-- 유효성 검사 -->
		             <div id="alertDiv" class="alert alert-danger" role="alert">
		              </div> 
		            <!-- //유효성 검사  끝 -->
		            <div class="form-group">
		                <input id="user_email" type="email" name="email" class="form-control form-control-inline text-center" placeholder="이메일 주소" value="">
		            </div>
		            <input type="button" id="findPwdButton" class="btn btn-primary" value="계정 찾기" /> <a href="/" class="btn btn-default">취소</a>
		        </div>
		    </div>
		</div>
	</form>
</div>
         
<!-- -----------------------------------userFindPwdForm-------------------------------- -->
 	<jsp:include page="/WEB-INF/global/footer.jsp"/>   
   </div> <!-- main -->   
</div> <!-- layout-container --> 

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>   
<script type = "text/javascript" src="/semiproject/js/user/userSignupForm.js"></script> 
<script type="text/javascript">
var code = "";
var mailnumCheck = false;

$(function(){
	$('#alertDiv').hide();
	
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		
		$('#findPwdButton').click(function(){
			$('#alertDiv').hide();
			
			console.log('완성된 이메일 : ' + $('#user_email').val()); // 이메일 오는지 확인	
			
			if($('#user_email').val() == '') {
				$('#alertDiv').show();
				$('#alertDiv').html('[이메일] : 가입하신 이메일을 입력하세요')
				$('#alertDiv').css('color', 'red');
				$('#alertDiv').css('font-size', '8pt');
				
			}
			else if($('#user_email').val().match(regExp) == null) {
				$('#alertDiv').show();
				$('#alertDiv').html('[이메일] : 이메일 형식이 올바르지 않습니다.')
				$('#alertDiv').css('color', 'red');
				$('#alertDiv').css('font-size', '8pt');
				
			}else{
				$.ajax({
					type: 'post',
					url:'/semiproject/user/userSignup_emailCheck',
					data: {'user_email' : $('#user_email').val()}, 
					dataType: 'text', 
					success: function(data){
						//data = data.trim();
						//alert(data);
						if(data=='exist'){
							
							$.ajax({
								type : 'get',
								url : '/semiproject/user/pwdFindmailCheck?user_email='+$('#user_email').val(),
								success : function (data) {
									console.log("data : " +  data);
									code = data;
									alert('메일을 전송했습니다.\n메일에 들어가서 링크를 클릭하세요.');
								},
								error: function(err){
									console.log(err);
								}
							})	
							
							
						}else if(data=='non exist'){
							$('#check_alert').show();
							$('input[name="user_email_check"]').val($('#user_email').val());
							$('#check_alert').html('[이메일]: 존재하지 않는 이메일입니다.');
							$('#check_alert').css('color', 'blue');
							$('#check_alert').css('font-size', '8px');
						}
					},
					error: function(err){
						console.log(err);
					}
				});
			}
			
				
		});
		
		//메일이 존재하는지 여부도 구현해야함.
});


//비밀번호 유효성검사
/*  $('#user_email').focusout(function(){
	$('..alert alert-danger').hide();
	
 	if($('#user_email').val()!=null){
		$.ajax({ 
			url: '/semiproject/user/checkPwd',
			type: 'post',
			data: 'user_email='+$('#user_email').val(), */
			//data: 'user_email='+'manbal3@aaa',
			/* dataType: 'json', */
	
		/* 	success: function(data){
				alert(JSON.stringify(data));
							
				if(data == '') {
					$('.alert alert-danger').show();		
				}else $('.alert alert-danger').hide();					
			},
			error: function(err){
				console.log(err);
			}
		});
 	}
}); 
 */
</script>

</body>
</html> 











