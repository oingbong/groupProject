<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
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
				<h2>공지사항 상세보기</h2>
				<p>공지사항 내용을 확인하세요</p>
			</header>
				<ul>
					<li>글번호 : ${n.n_no }</li>
					<li>글제목 : ${n.n_title }</li>
					<li>작성자 : ${n.n_writer }</li>
					<li>내용 : ${n.n_content }</li>
					<li>조회수 : ${n.n_hit }</li>
					<li>작성일 : ${n.n_date }</li>
					<li><img src="../resources/upload/${n.n_fname }"> </li>
					<li>첨부파일 : ${n.n_fname }(${n.n_fsize })</li>
				</ul>
				<ul class="actions">
						<li><a href="insertNotice.do?n_no=${n.n_no }" class="button">답글작성</a></li>
					<c:if test="${m_type==1 }">	
						<li><a href="updateNotice.do?n_no=${n.n_no }" class="button alt">수정</a></li>
						<li><a href="deleteNotice.do?n_no=${n.n_no }" class="button alt">삭제</a></li>
					</c:if>
				</ul>

		</div>
	</section>

<%-- 
	<h2>글 상세보기</h2>
	<hr>
	글번호 : ${n.n_no }<br>
	글제목 : ${n.n_title }<br>
	작성자 : ${n.n_writer }<br>
	내용 :<br>
	<textarea rows="10" cols="80">${n.n_content }</textarea> <br>
	조회수 : ${n.n_hit }<br>
	작성일 : ${n.n_date }<br>
	첨부파일 : ${n.n_fname }(${n.n_fsize })<br>
	<hr>
	<a href="insertNotice.do?n_no=${n.n_no }">답글작성</a>
	<a href="updateNotice.do?n_no=${n.n_no }">수정</a>
	<a href="deleteNotice.do?n_no=${n.n_no }">삭제</a> --%>
		
</body>
</html>