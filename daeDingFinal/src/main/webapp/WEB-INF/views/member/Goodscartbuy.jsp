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
	<section>
		<h3>장바구니 상품 전체 주문</h3>
		<h4>주문 리스트를 확인하세요</h4>
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>주문번호</th>
						<th>아이디</th>
						<th>물품번호</th>
						<th>물품개수</th>
						<th>물품가격</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${list }">
						<tr>
							<td>${c.c_no }</td>
							<td>${c.c_id }</td>
							<td>${c.c_goodsno }</td>
							<td>${c.c_goodscnt }</td>
							<td>${c.c_goodsprice }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

<!--  -->
<%-- <h2>장바구니 상품 전체 주문</h2>
<hr>

<table>
	<tr>
		<td>주문번호</td>
		<td>아이디</td>
		<td>물품번호</td>
		<td>물품개수</td>
		<td>물품가격</td>
	<tr>
	
	<c:forEach var="c" items="${list }">
		<tr>
			<td>${c.c_no }</td>
			<td>${c.c_id }</td>
			<td>${c.c_goodsno }</td>
			<td>${c.c_goodscnt }</td>
			<td>${c.c_goodsprice }</td>
		</tr>
	</c:forEach>
</table> --%>



</body>
</html>