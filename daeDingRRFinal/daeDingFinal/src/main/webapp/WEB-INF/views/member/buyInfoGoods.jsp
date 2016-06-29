<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	function pro(no) {
		var cnt = $("#cnt").val();
		var price = $("#price").val();
		location.href="insertCart.do?no="+no+"&cnt="+cnt+"&price="+price;
	}
</script>
</head>
<body>
	<header class="major">
		<h2>주문하기</h2>
		<p>상품의 정보를 확인해주세요</p>
	</header>

	<section>
		<form method="post" action="buyGoods.do">
			<div class="row uniform 50%">
				<input type="hidden" name="g_no" value="${list.g_no }">
				
					<div class="table-wrapper">
						<table>
							<thead>
								<tr align="left">
									<td>상품명 : ${list.g_name }</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<img src="../resources/upload/${list.g_img }"><br>
									</td>
									<td>
										
										<li>시중가 : ${list.g_price}</li>
										<li>할인금액 : ${list.g_saleprice }<input type="hidden" name="g_saleprice" value="${list.g_saleprice }" id="price"></li>
										<li>배송비 : ${list.g_delivery }<input type="hidden" name="g_delivery" value="${list.g_delivery }"></li>
										<div class="6u 12u$(4)">
											구매수량 : <input type="text" name="cnt" id="cnt" value="" placeholder="구매수량을 입력해주세요" />
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="구매하기" class="special" /></li>
						<li><input type="button" value="장바구니" onclick="pro(${list.g_no })"></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
	<!--  ---------------------- -->
<%-- <h2>상품 상세 페이지</h2>
	<hr>
	<form action="buyGoods.do" method="get">
	<input type="hidden" name="g_no" value="${list.g_no }">
		<table>
			<tr align="left">
				<td>상품명 : ${list.g_name }</td>
			</tr>
			<tr>
				<td>
					<img src="../resources/upload/${list.g_img }"><br>
				</td>
				<td>
					시중가 : ${list.g_price}<br>
					할인금액 : ${list.g_saleprice }<input type="hidden" name="g_saleprice" value="${list.g_saleprice }" id="price"><br>
					배송비 : ${list.g_delivery }<input type="hidden" name="g_delivery" value="${list.g_delivery }"><br>
					구매수량 : <input type="text" name="cnt" id="cnt"><br>
					<input type="submit" value="구매하기">
					<input type="button" value="장바구니" onclick="pro(${list.g_no })">
					
				</td>
			</tr>
		</table>	
	</form>
	 --%>

</body>
</html>