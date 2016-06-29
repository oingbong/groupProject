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
		<h2>주문하기</h2>
		<p>주문상품 확인 및 할인가적용</p>
	</header>

	<section>
		<h3>회원 목록</h3>
		<h4>회원의 목록을 확인하세요</h4>
		<form method="post" action="insertOrderInfo.do">
			<div class="row uniform 50%">
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>상품</th>
								<th>상품명</th>
								<th>수량</th>
								<th>상품금액</th>
								<th>할인금액</th>
								<th>배송비</th>
								<th>총비용</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<input type="hidden" name="g_no" value="${list.g_no }">
								<td><img src="../resources/upload/${list.g_img }" width="100" height="100"></td>
								<td>${list.g_name }</td>
								<td><input type="text" value="${cnt }" name="oi_buycount"><br></td>
								<td> ${list.g_price }원</td>
								<td>${list.g_saleprice }원</td>
								<td>${list.g_delivery }원</td>
								<td>${oper }원</td>
							</tr>
						</tbody>
					</table>
				</div>
				
					<input type="hidden" value="${list.g_img }"><br>
		 			<input type="hidden" value="${oper }" name="oi_price"><br>
		 			
		<!-- ----------- -->
			<h3>배송 정보</h3>
			<h4>회원님의 배송정보를 확인해주세요</h4>
			
				<div class="table-wrapper">
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
								<td>${m.m_id }</td>
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

<!-- ------------------------------------------------- -->
<%-- <h2>주문상품 확인 및 할인가적용</h2>
<hr>
	<form action="insertOrderInfo.do" method="post">
		<input type="hidden" value="${list.g_no }" name="oi_goodsno">
		<table border="1" width="80%">
			<tr>
				<td>상품</td>
				<td>상품명</td>
				<td>수량</td>
				<td>상품금액</td>
				<td>할인금액</td>
				<td>배송비</td>
				<td>총비용</td>
			</tr>
		
			<tr>
				<td><img src="../resources/upload/${list.g_img }" width="100" height="100"></td>
				<td>${list.g_name }</td>
				<td><input type="text" value="${cnt }" name="oi_buycount"><br></td>
				<td> ${list.g_price }원</td>
				<td>${list.g_saleprice }원</td>
				<td>${list.g_delivery }원</td>
				<td>${oper }원</td>
			</tr>
		</table>
		
		 <input type="hidden" value="${list.g_img }"><br>
		 <input type="hidden" value="${oper }" name="oi_price"><br>
		
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
				<td>${m.m_id }</td>
				<td><input type="text" value="${m.m_name }" name="m_name">님</td>
				<td><input type="text" value="${m.m_addr }" name="m_addr"></td>
				<td><input type="text" value="${m.m_phone }" name="m_phone"></td>
				<td><input type="text" value="${m.m_email }" name="m_email"></td>
			</tr>
		</table>
		
		<input type="hidden" value="${m.m_id }" name="oi_id">
		<input type="submit" value="주문하기">

	</form>
 --%>
</body>
</html>