<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		${msg }
		<legend>로그인</legend>
			<form action="login.do" method="post">
			아이디 : <input type="text" name="m_id"><br>
			암호 <input type="password" name="m_pwd"><br>
			<input type="submit" value="로그인">
			<input type="reset" value="취소">
			</form>
	</fieldset>
</body>
</html>