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
		<h2>주문 목록</h2>
		<p>회원님의 주문 목록을 확인하세요</p>
	</header>
	<section>
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>주문번호</th>
						<th>주문날짜</th>
						<th>총가격</th>
						<th>아이디</th>
						<th>물품개수</th>
						<th>물품번호</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="g" items="${list }">
						<tr>
							<td>${g.oi_no }</td>
							<td>${g.oi_date }</td>
							<td>${g.oi_price }</td>
							<td>${g.oi_id }</td>
							<td>${g.oi_buycount }</td>
							<td>${g.oi_goodsno }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
<!-- -------------------- -->
<%-- 	<h2>주문목록</h2>
	<hr>
	
	<table border="1" width="80%">
		<tr>
			<td>주문번호</td>
			<td>주문날짜</td>
			<td>총가격</td>
			<td>아이디</td>
			<td>물품개수</td>
			<td>물품번호</td>
		</tr>
	

	<c:forEach var="g" items="${list }">
		<tr>
			<td>${g.oi_no }</td>
			<td>${g.oi_date }</td>
			<td>${g.oi_price }</td>
			<td>${g.oi_id }</td>
			<td>${g.oi_buycount }</td>
			<td>${g.oi_goodsno }</td>
		</tr>
	</c:forEach>
	
	</table> --%>

</body>
</html>