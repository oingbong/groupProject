<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="major">
		<h2>문의 목록</h2>
		<p>문의 목록들을 확인해보세요</p>
	</header>
	<section>
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>문의분류</th>
						<th>제목</th>
						<th>고객명</th>
						<th>등록날짜</th>
						<th>처리유무</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="q" items="${list }">
						<tr>
							<td>${q.q_no }</td>
							<td>${q.q_type }</td>
							<td><a href="detailQuestion.do?q_no=${q.q_no }">${q.q_title }</a></td>
							<td>${q.q_id }</td>
							<td>${q.q_date }</td>
							<td>
							<c:set var="check" value="${q.q_yesNo }"></c:set>
							<c:choose>
								<c:when test="${check==1 }"><font color="blue">처리후</font></c:when>
								<c:when test="${check==0 }"><font color="red" >처리전</font></c:when>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
				<a href="../member/insertQuestion.do" class="button"><p>문의 글쓰기</p></a>
	</section>
<!-- ------------------------------ -->
<%-- <fieldset>
<legend>문의게시판</legend>


	<table border="1" width="80%">
		<tr>
			<td>번호</td>
			<td>문의분류</td>
			<td>제목</td>
			<td>고객명</td>
			<td>등록날짜</td>
			<td>처리유무</td>
		</tr>

		<c:forEach var="q" items="${list }">
			<tr>
				<td>${q.q_no }</td>
				<td>${q.q_type }</td>
				<td><a href="detailQuestion.do?q_no=${q.q_no }">${q.q_title }</a></td>
				<td>${q.q_id }</td>
				<td>${q.q_date }</td>
				<td>
				<c:set var="check" value="${q.q_yesNo }"></c:set>
				<c:choose>
					<c:when test="${check==1 }"><font color="blue">처리후</font></c:when>
					<c:when test="${check==0 }"><font color="red" >처리전</font></c:when>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="../member/insertQuestion.do">글쓰기</a>
	
</fieldset> --%>

</body>
</html>