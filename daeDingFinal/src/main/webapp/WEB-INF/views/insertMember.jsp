<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
    <script>
        $(document).ready(function () {
        	
            $('#calendar').datepicker({
            	dateFormat: 'yy/mm/dd',
            	onSelect:function(){
            	//alert($(this).getDate());
            	//var currentDate = $(this).datepicker( "getDate",  {dateFormat: 'yy년 mm월 dd일'} );
            	//alert("ok");
            }});
                        
            
        });
    </script>
</head>
<body>    

	<header class="major">
		<h2>회원가입</h2>
		<p>회원정보를 입력해 주세요</p>
	</header>

	<section>
		<form method="post" action="insertMember.do">
			<div class="row uniform 50%">
				<div class="6u 12u$(4)">
					아이디 : <input type="text" name="m_id" id="m_id" value="" placeholder="아이디를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					<input type="hidden" name="m_type" value="1"/>
				</div>
				<div class="6u 12u$(4)">
					이름 : <input type="text" name="m_name" id="m_name" value="" placeholder="이름을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					비밀번호 : <input type="password" name="m_pwd" id="m_pwd" value="" placeholder="비밀번호를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					생일 : <input type="text" name="m_birth" id="calendar" value="" placeholder="생일을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					성별 : <input type="text" name="m_gender" id="m_gender" value="" placeholder="성별을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					주소 : <input type="text" name="m_addr" id="m_addr" value="" placeholder="주소를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					핸드폰 : <input type="text" name="m_phone" id="m_phone" value="" placeholder="핸드폰을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					이메일 : <input type="text" name="m_email" id="m_email" value="" placeholder="이메일을 입력해주세요" />
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="회원가입" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
</body>
</html>