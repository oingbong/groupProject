<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="main" class="wrapper">
		<div class="container">

			<header class="major">
				<h2>회원상세정보</h2>
				<p>회원의 상세 정보를 확인하세요</p>
			</header>
				<ul>
					<li>아이디 : ${m.m_id }</li>
					<li>이름 : ${m.m_name }</li>
					<li>생일 : ${m.m_birth }</li>
					<li>성별 : ${m.m_gender }</li>
					<li>주소 : ${m.m_addr }</li>
					<li>휴대폰 : ${m.m_phone }</li>
					<li>이메일 : ${m.m_email }</li>
				</ul>
				
			<a href="updateMember.do?m_id=${m.m_id }" class="button small"><p>정보수정하기</p></a>
			<a href="deleteMember.do?m_id=${m.m_id }" class="button small"><p>회원삭제하기</p></a>

		</div>
	</section>

<%-- 	<fieldset>
		<legend>회원 정보</legend>
		아이디 : ${m.m_id }<br>
		이름 : ${m.m_name }<br>
		생일 : ${m.m_birth }<br>
		성별 : ${m.m_gender }<br>
		주소 : ${m.m_addr }<br>
		휴대폰 : ${m.m_phone }<br>
		이메일 : ${m.m_email }<br>
		
		<a href="updateMember.do?m_id=${m.m_id }">수정하러 가기</a>
		<a href="deleteMember.do?m_id=${m.m_id }">삭제하기</a>
	</fieldset> --%>
</body>
</html>