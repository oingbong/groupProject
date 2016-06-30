<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro(c_no) {
		q=confirm("상품을 정말 삭제할래요?")
		if(q==true){
			alert("선택한 상품이 삭제되었습니다.")
			location.href = "deleteCart.do?c_no="+c_no;
		}else{
			alert("다시 한번 생각해보세요.")
		}
	}
</script>
</head>
<body>
	<header class="major">
		<h2>장바구니</h2>
		<p>장바구니 목록을 확인하세요</p>
		<!-- <p>주문상품 확인 및 할인가적용</p> -->
	</header>

	<section>
		<form method="post" action="listbuyCart.do">
			<!-- <div class="row uniform 50%"> -->
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>장바구니번호</th>
								<th>물품번호</th>
								<th>물품가격</th>
								<th>물품개수</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${list }" varStatus="3">
								<tr>
									<td>${c.c_no }<input type="hidden" value="${c.c_no }" name="c_no"></td>
									<td>${c.c_goodsno }<input type="hidden" value="${c.c_goodsno}" name="c_goodsno"></td>
									<td>${c.c_goodsprice }<input type="hidden" value="${c.c_goodsprice }" name="c_goodsprice"></td>
									<td>${c.c_goodscnt }<input type="hidden" value="${c.c_goodscnt }" name="c_goodscnt"></td>
									<td onclick="pro(${c.c_no})">삭제</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="전체 주문하기" class="special"></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			<!-- </div> -->
		</form>
	</section>

<!-- -------------------------------------------- -->
<%-- 	<h2>장바구니</h2>
	
	<form action="listbuyCart.do" method="get">

	<table border="1" width="80%">
			<tr>
				<td>장바구니번호</td>
				<td>물품번호</td>
				<td>물품가격</td>
				<td>물품개수</td>
				<td>삭제</td>
			</tr>

		<c:forEach var="c" items="${list }" varStatus="3">
			<tr>
				<td>${c.c_no }<input type="hidden" value="${c.c_no }" name="c_no"></td>
				<td>${c.c_goodsno }<input type="hidden" value="${c.c_goodsno}" name="c_goodsno"></td>
				<td>${c.c_goodsprice }<input type="hidden" value="${c.c_goodsprice }" name="c_goodsprice"></td>
				<td>${c.c_goodscnt }<input type="hidden" value="${c.c_goodscnt }" name="c_goodscnt"></td>
				<td>삭제</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<input type="submit" value="전체 주문하기">
	
	</form> --%>
	
</body>
</html>