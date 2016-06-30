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
		<h2>답변 메일 보내기ㅁㄻㄴㅇㄻㄴㅇㄻㄴㅇㄻㄴㄻㄴㅇㄹ</h2>
		<p>답변 할 내용 확인해주세요</p>
	</header>

	<section>
		<form method="post" action="sendMail.do">
			<div class="row uniform 50%">
				<input type="hidden" value="${m.m_email }">
				<input type="hidden" name="q_yesNo" value="1">
				<div class="6u 12u$(4)">
					문의글번호 : <input type="text" name="q_no" id="q_no" value="" placeholder="문의글번호를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					답변 : <br>
					<textarea rows="5" cols="60" name="q_answer"></textarea>
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="답변메일 보내기" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
<!-- ----------------------- -->
<%-- 	<fieldset>
		<legend>답변 메일 보내기</legend>
		<form action="sendMail.do" method="post">
			<input type="hidden" value="${m.m_email }">
			문의글번호 : <input type="text" name="q_no" value="q_no"><br>
			답변 : <br> 
			<textarea rows="10" cols="60" name="q_answer"></textarea><br>
			<input type="hidden" name="q_yesNo" value="1">
			<input type="submit" value="답변메일 보내기">
			<input type="reset" value="취소하기" >
		</form>
	</fieldset> --%>
</body>
</html>