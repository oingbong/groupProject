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
		<h2>공지사항 삭제</h2>
		<p>삭제하는 게시물의 암호를 사용하세요</p>
	</header>

	<section>
		<form method="post" action="deleteNotice.do">
			<div class="row uniform 50%">
				<div class="6u 12u$(4)">
					<input type="hidden" name="n_no" value="${n_no }">
					암호 : <input type="password" name="n_pwd" id="n_pwd" value="" placeholder="비밀번호를 입력해주세요" />
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="삭제" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
<!--  -->
<%-- 	<h2>게시물 삭제</h2>
	<hr>
	<form action="deleteNotice.do" method="post">
		<input type="hidden" name="n_no" value="${n_no }">
		암호 : <input type="password" name="n_pwd">
		<input type="submit" value="삭제">
	</form> --%>
</body>
</html>