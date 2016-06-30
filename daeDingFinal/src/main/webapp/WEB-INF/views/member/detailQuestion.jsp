<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="major">
		<h2>답변메일 보내기</h2>
		<p>답변 할 내용을 작성해주세요</p>
	</header>
	
	<section id="main" class="wrapper">
		<div class="container">
			<h2>질문 내용</h2>
				문의자 : <input type="text" value="${s.m_name }"><br>
				문의메일 : <input type="text" value="${s.m_email }"><br>
				문의날짜 : <input type="text" value="${q.q_date }"><br>
				문의내용 : <br>
				<textarea rows="5" cols="60">${q.q_content }</textarea><br>
		</div>
	</section>

<c:if test="${m_type==1 }">
	<section>
		<form method="post" action="sendMail.do">
		
			<h2>답변 하기</h2>
			
			<div class="row uniform 50%">
				<input type="hidden" value="${s.m_email }" name="q_email">
				<input type="hidden" value="${s.m_id }" name="q_id">
				<input type="hidden" value="1" name="q_yesNo">
				<br>
				<input type="hidden" name="q_">
				<br>
				
				<div class="6u 12u$(4)">
					문의글번호 : <input type="text"  value="${q.q_no }" name="q_no">
				</div>
				<div class="12u$">
					답변 : <br>
					<textarea name="q_answer" id="q_answer" placeholder="답변을 입력해주세요" rows="6"></textarea>
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
</c:if>

<!--  -->
<%-- 	<fieldset>
		<legend>답변 메일 보내기</legend>
		문의자 : <input type="text" value="${s.m_name }"><br>
		문의메일 : <input type="text" value="${s.m_email }"><br>
		문의날짜 : <input type="text" value="${q.q_date }"><br>
		문의내용 : <br>
		<textarea rows="5" cols="60">${q.q_content }</textarea>
		
		<form action="sendMail.do" method="post">
			<input type="hidden" value="${s.m_email }" name="q_email">
			<input type="hidden" value="${s.m_id }" name="q_id">
			<input type="hidden" value="1" name="q_yesNo">
			문의글번호 : <input type="text"  value="${q.q_no }" name="q_no"><br>
			<input type="hidden" name="q_">
			답변 : <br> 
			<textarea rows="10" cols="60" name="q_answer"></textarea><br>
			<input type="submit" value="답변메일 보내기">
			<input type="reset" value="취소하기" >
		</form>
	</fieldset> --%>
</body>
</html>