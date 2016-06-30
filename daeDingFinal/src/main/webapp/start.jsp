<%@page import="org.springframework.web.filter.CharacterEncodingFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>

<body>
	<%-- <% CharacterEncodingFilter %> --%>
	<a href="member/listMember.do">회원목록</a><br>
	<a href="member/insertMember.do">회원가입</a><br>
	<a href="member/listGoods.do">상품목록</a><br>
	<a href="member/insertGoods.do">상품등록</a><br>
	<a href="member/insertNotice.do">공지사항 등록</a><br>
	<a href="member/listNotice.do">공지사항 목록</a><br>
	<a href="member/insertQuestion.do">문의사항 등록</a><br>
	<a href="member/listQuestion.do">문의사항 목록</a><br>
	<a href="member/listQna.do">Q&A</a><br>
	<a href="member/listOrderInfo.do">주문 목록</a><br>
</body>
</html>
