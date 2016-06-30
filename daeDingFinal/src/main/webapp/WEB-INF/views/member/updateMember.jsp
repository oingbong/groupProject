<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="major">
		<h2>회원수정</h2>
		<p>수정 할 회원의 정보를 입력해주세요</p>
	</header>

	<section>
		<form method="post" action="updateMember.do">
			<div class="row uniform 50%">
				<input type="hidden" name="m_type" value="${m.m_type }">
				<div class="6u 12u$(4)">
					아이디 : <input type="text" name="m_id" id="m_id" value="${m.m_id }" placeholder="아이디를 입력해주세요" readonly="readonly"/>
				</div>
				<div class="6u 12u$(4)">
					이름 : <input type="text" name="m_name" id="m_name" value="${m.m_type }" placeholder="이름을 가격을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					비밀번호 : <input type="password" name="m_pwd" id="m_pwd" value="${m.m_pwd }" placeholder="비밀번호를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					생일 : <input type="text" name="m_birth" id="m_birth" value="${m.m_birth }" placeholder="생일을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					성별 : <input type="text" name="m_gender" id="m_gender" value="${m.m_gender }" placeholder="성별을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					주소 : <input type="text" name="m_addr" id="m_addr" value="${m.m_addr }" placeholder="주소를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					핸드폰 : <input type="text" name="m_phone" id="m_phone" value="${m.m_phone }" placeholder="핸드폰을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					이메일 : <input type="text" name="m_email" id="m_email" value="${m.m_email }" placeholder="이메일을 입력해주세요" />
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="수정" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
<!-- ---------------------- -->
<%-- 	<fieldset>
		<legend>회원 수정</legend>
		<form action="updateMember.do" method="post">
			아이디 : <input type="text" name="m_id" value="${m.m_id }" readonly="readonly"><br>
			<input type="hidden" name="m_type" value="${m.m_type }"><br>
			이름 : <input type="text" name="m_name" value="${m.m_name }"><br>
			비밀번호 : <input type="password" name="m_pwd" value="${m.m_pwd }"><br>
			생일 : <input type="text" name="m_birth" value="${m.m_birth }"><br>
			성별 : <input type="text" name="m_gender" value="${m.m_gender }"><br>
			주소 : <input type="text" name="m_addr" value="${m.m_addr }"><br>
			핸드폰 : <input type="text" name="m_phone" value="${m.m_phone }"><br>
			이메일 : <input type="text" name="m_email" value="${m.m_email }"><br>
			<input type="submit" value="수정하기">
			<input type="reset" value="취소하기">
		</form>
	</fieldset> --%>
</body>
</html>