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
				<h2>상품 상세정보</h2>
				<p>상품의 정보를 확인하세요</p>
			</header>
				<ul>
					<li>물품번호 : ${list.g_no }</li>
					<li>물품명 : ${list.g_name }</li>
					<li>정상가격 : ${list.g_price }</li>
					<li>할인가격 : ${list.g_saleprice }</li>
					<li>배송비 : ${list.g_delivery }</li>
					<li>회사명 : ${list.g_companyname }</li>
					<!-- <a href="#" class="image fit"> -->
					<li><img src="../resources/upload/${list.g_img}" width="200" height="200"/></li>
					<li>첨부파일 : ${list.g_img }</li>
				</ul>
				
				<ul class="actions">
						<li><a href="buyInfoGoods.do?g_no=${list.g_no }" class="button">주문하기</a></li>
					<c:if test="${m_type==1 }">
						<li><a href="updateGoods.do?g_no=${list.g_no }" class="button alt">수정하기</a></li>
						<li><a href="deleteGoods.do?g_no=${list.g_no }" class="button alt">삭제</a></li>
					</c:if>
					
				</ul>
<%-- 		<a href="updateGoods.do?g_no=${list.g_no }"><p>수정</p></a>
			<a href="deleteGoods.do?g_no=${list.g_no }"><p>삭제</p></a>
			<a href="buyInfoGoods.do?g_no=${list.g_no }"><p>주문하기</p></a> --%>
		</div>
	</section>
<%--	
	<h2>물품 상세정보</h2>
	<hr>

 	물품번호 : ${list.g_no }<br>
	물품명 : ${list.g_name }<br>
	정상가격 : ${list.g_price }<br>
	할인가격 : ${list.g_saleprice }<br>
	배송비 : ${list.g_delivery }<br>
	회사명 : ${list.g_companyname }<br>
	**상품**<br>
	<img src="../resources/upload/${list.g_img}" width="100" height="100"><br>
	
	<a href="updateGoods.do?g_no=${list.g_no }">수정</a>
	<a href="deleteGoods.do?g_no=${list.g_no }">삭제</a>
	<a href="buyInfoGoods.do?g_no=${list.g_no }">주문하기</a> --%>

</body>
</html>