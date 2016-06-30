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
		<h2>장바구니 전체주문</h2>
		<p>주문정보를 확인해주세요</p>
	</header>

	<section>
		<form method="get" action="insertOrderInfo.do">
			<div class="row uniform 50%">
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>물품번호</th>
								<th>상품번호</th>
								<th>물품가격</th>
								<th>물품개수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${list }" varStatus="3">
								<tr>
									<td>${c.c_no }<input type="hidden" value="${c.c_no }" name="c_no"></td>
									<td>${c.c_goodsno }<input type="hidden" value="${c.c_goodsno}" name="oi_goodsno"></td>
									<td>${c.c_goodsprice }<input type="hidden" value="${c.c_goodsprice }" name="oi_price"></td>
									<td>${c.c_goodscnt }<input type="hidden" value="${c.c_goodscnt }" name="oi_buycount"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

		<!-- ----------- -->
			
				<div class="table-wrapper">
			<h3>배송 정보</h3>
			<h4>회원님의 배송정보를 확인해주세요</h4>
					<table>
						<thead>
							<tr>
								<th>아이디</th>
								<th>이름</th>
								<th>주소</th>
								<th>연락처</th>
								<th>이메일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${m.m_id }
								<td><input type="text" value="${m.m_name }" name="m_name">님</td>
								<td><input type="text" value="${m.m_addr }" name="m_addr"></td>
								<td><input type="text" value="${m.m_phone }" name="m_phone"></td>
								<td><input type="text" value="${m.m_email }" name="m_email"></td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="12u$">
					<ul class="actions">
						<li><input type="hidden" value="${m.m_id }" name="oi_id"></li>
						<li><input type="submit" value="주문하기" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>

<!-- ------------------------------------------------------------------- -->
<%-- <form action="insertOrderInfo.do" method="post">

<hr>
<h2>장바구니 전체주문</h2>
<hr>
	
	<table border="1" width="80%">
			<tr>
				<td>물품번호</td>
				<td>상품번호</td>
				<td>물품가격</td>
				<td>물품개수</td>
			</tr>

		<c:forEach var="c" items="${list }" varStatus="3">
			<tr>
				<td>${c.c_no }<input type="hidden" value="${c.c_no }" name="c_no"></td>
				<td>${c.c_goodsno }<input type="hidden" value="${c.c_goodsno}" name="oi_goodsno"></td>
				<td>${c.c_goodsprice }<input type="hidden" value="${c.c_goodsprice }" name="oi_price"></td>
				<td>${c.c_goodscnt }<input type="hidden" value="${c.c_goodscnt }" name="oi_buycount"></td>
			</tr>
		</c:forEach>
		
		
		
	</table>
	
	<hr>
	<h2>배송 정보</h2>
	<hr>
	
	<table border="1" width="80%">
	
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>주소</td>
		<td>연락처</td>
		<td>이메일</td>
	</tr>
	
	<tr>
		<td>${m.m_id }<input type="hidden" value="${m.m_id }" name="oi_id"></td>
		<td><input type="text" value="${m.m_name }" name="m_name">님</td>
		<td><input type="text" value="${m.m_addr }" name="m_addr"></td>
		<td><input type="text" value="${m.m_phone }" name="m_phone"></td>
		<td><input type="text" value="${m.m_email }" name="m_email"></td>
	</tr>

	</table>
	
	<input type="submit" value="주문하기">
	
	</form>
	 --%>

</body>
</html>