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
		<h2>로그인</h2>
		<p>로그인 후 사용해 주시기 바랍니다.</p>
	</header>

	<section>
		<form method="post" action="login.do">
			<div class="row uniform 50%">
				<div class="6u 12u$(4)">
					아이디 : <input type="text" name="m_id" id="m_id" value="" placeholder="아이디를 입력해주세요" />
				</div>
				<div class="6u$ 12u$(4)">
					비밀번호 : <input type="password" name="m_pwd" id="m_pwd" value="" placeholder="비밀번호를 입력해주세요" />
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="로그인" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
	<a href="insertMember.do" class="button">회원가입</a>
</body>
</html>