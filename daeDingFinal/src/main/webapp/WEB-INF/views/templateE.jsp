<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<% String cp = request.getContextPath(); %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	Transit by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Elements - Transit by TEMPLATED</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="<%=cp%>/resources/bootstrap/js/jquery.min.js"></script>
		<script src="<%=cp%>/resources/bootstrap/js/skel.min.js"></script>
		<script src="<%=cp%>/resources/bootstrap/js/skel-layers.min.js"></script>
		<script src="<%=cp%>/resources/bootstrap/js/init.js"></script>
			<link rel="stylesheet" href="<%=cp%>/resources/bootstrap/css/skel.css" />
			<link rel="stylesheet" href="<%=cp%>/resources/bootstrap/css/style.css" />
			<link rel="stylesheet" href="<%=cp%>/resources/bootstrap/css/style-xlarge.css" />
		<script type="text/javascript">
			//function getTime() { 
				
			 	$(function() {
				
	
				/* document.getElementById("counter1").innerHTML = hoursRound; 
				document.getElementById("counter2").innerHTML = minutesRound; 
				document.getElementById("counter3").innerHTML = secondsRound;  */
				/* newtime = window.setTimeout("getTime();", 1000); */ 
					setInterval(function() {
						
						var now = new Date(); 
				//dday = new Date(2013,02,14,18,00,00); 
				var dday = new Date(2016,08,15,00,00,00); 
				// 원하는 날짜, 시간 정확하게 초단위까지 기입.
				var days = (dday - now) / 1000 / 60 / 60 / 24; 
				var daysRound = Math.floor(days); 
				var hours = (dday - now) / 1000 / 60 / 60 - (24 * daysRound); 
				var hoursRound = Math.floor(hours); 
				var minutes = (dday - now) / 1000 /60 - (24 * 60 * daysRound) - (60 * hoursRound); 
				var minutesRound = Math.floor(minutes); 
				var seconds = (dday - now) / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) - (60 * minutesRound); 
				var secondsRound = Math.round(seconds); 
				
				str = daysRound+"일 "+hoursRound+"시 "+minutesRound+"분 "+secondsRound + "초 "
						$("#eventT").html("이벤트 남은시간 : "+str);						
					},1000)	
				 
			//} 
			
			/* var dt = new Date();
			
			var month = dt.getMonth()+1;
			var day = dt.getDate();
			var year = dt.getFullYear();
			var hour = dt.getHours();
			var minute = dt.getMinutes();
			var seconds = dt.getSeconds();
			
			var tt = year+"년"+month+"월"+day+"일"+hour+"시"+minute+"분"+seconds+"초";
			$(function() {
				setTimeout(function() {
					$.ajax("#",{success:function(data){
						$("#eventT").append(tt);
					}})
				},1000)*/
			}) 
		</script>	
	</head>
	<body>

		<!-- Header -->
		<!-- 로그인 안했을때 -->
		<c:if test="${m_type == 9 || m_type != 0 && m_type !=1}">
			<header id="header">
				<h1><a href="member/index.do">DaeDing</a></h1>
				<nav id="nav">
					<ul>
						<li id="eventT"></li>
						<li><a href="member/index.do">Home</a></li>
						<li><a href="member/listNotice.do">공지사항</a></li>
						<li><a href="member/listGoods.do">상품목록</a></li>
						<li><a href="member/listOrderInfo.do">주문현황</a></li>
						<li><a href="member/listCart.do">장바구니</a></li>
						<li><a href="member/listQuestion.do">문의하기</a></li>
						<li><a href="member/listFaq.do">자주하는질문</a></li>
						<li><a href="member/contactUs.do">Contact Us</a></li>
						<c:if test="${m_type==1 }">
							<li><a href="member/listMember.do">회원목록</a></li>
						</c:if>
						<c:if test="${m_type==1 || m_type==0 }">
							<li><a href="/home/logout.do" class="button special">Log Out</a></li>
						</c:if>	
					</ul>
				</nav>
			</header>
		</c:if>
		<!-- 로그인 했을때 -->
		<c:if test="${m_type == 0 || m_type ==1 }">
			<header id="header">
				<h1><a href="../member/index.do">DaeDing</a></h1>
				<nav id="nav">
					<ul>
						<li id="eventT">이벤트 남은시간 </li>
						<li><a href="../member/index.do">Home</a></li>
						<li><a href="../member/listNotice.do">공지사항</a></li>
						<li><a href="../member/listGoods.do">상품목록</a></li>
						<li><a href="../member/listOrderInfo.do">주문현황</a></li>
						<li><a href="../member/listCart.do">장바구니</a></li>
						<li><a href="../member/listQuestion.do">문의하기</a></li>
						<li><a href="../member/listFaq.do">자주하는질문</a></li>
						<li><a href="../member/contactUs.do">Contact Us</a></li>
						<c:if test="${m_type==1 }">
							<li><a href="../member/listMember.do">회원목록</a></li>
						</c:if>
						<li><a href="/home/logout.do" class="button special">Log Out</a></li>
					</ul>
				</nav>
			</header>
		</c:if>
		
		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">

					<!-- Form -->
					<jsp:include page="${viewPage }"></jsp:include>
			</section>


		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<section class="links">
						<div class="row">
							<section class="3u 6u(medium) 12u$(small)">
								<h3>협력사</h3>
								<ul class="unstyled">
									<li><a href="#"></a></li>
									<li><a href="http://www.hanbitedu.co.kr/">한빛교육센터</a></li>
									<li><a href="http://www.hrd.go.kr"/>고용노동부 HRD-Net</a></li>
									<li><a href="http://www.sogang.ac.kr/">서강대학교</a></li>
									<li><a href="http://k-turtle.co.kr/">거구장</a></li>
								</ul>
							</section>
							<section class="3u 6u$(medium) 12u$(small)">
								<h3>경쟁업체</h3>
								<ul class="unstyled">
									<li><a href="http://www.coupang.com/">쿠팡</a></li>
									<li><a href="http://www.ticketmonster.co.kr/">티몬</a></li>
									<li><a href="http://www.wemakeprice.com/">위메프</a></li>
								</ul>
							</section>
							<section class="3u 6u(medium) 12u$(small)">
								<h3>참고 사이트</h3>
								<ul class="unstyled">
									<li><a href="https://www.google.co.kr/">Google</a></li>
									<li><a href="https://www.oracle.com/index.html">Oracle</a></li>
									<li><a href="http://www.w3schools.com/">w3schools</a></li>
									<li><a href="https://www.wikipedia.org/">wikipedia</a></li>
									<li><a href="http://spring.io/">spring</a></li>
								</ul>
							</section>
							<section class="3u$ 6u$(medium) 12u$(small)">
								<h3>Illum, tempori, saepe</h3>
								<ul class="unstyled">
									<li><a href="#">Lorem ipsum dolor sit</a></li>
									<li><a href="#">Recusandae, culpa necessita nam</a></li>
									<li><a href="#">Cupiditate, debitis adipisci blandi</a></li>
									<li><a href="#">Tempore nam, enim quia</a></li>
									<li><a href="#">Explicabo molestiae dolor labore</a></li>
								</ul>
							</section>
						</div>
					</section>
					<div class="row">
						<div class="8u 12u$(medium)">
							<ul class="copyright">
								<li></li>
								<li>(주)대딩 | 팀원 : 박제현 , 오재현 , 하희경 | 사업자 등록번호 : 111-22-33333</li>
								<li>통신판매업신고 : 2016-서울마포-11111 | 개인정보관리책임자 : 관리자 help@daeding.com</li>
								<li>서울시 마포구 신수동 63-14 구프라자 3층 </li>
								<li>&copy; Untitled. All rights reserved.</li>
							</ul>
						</div>
						<div class="4u$ 12u$(medium)">
							<ul class="icons">
								<li>
									<a class="icon rounded fa-facebook"><span class="label">Facebook</span></a>
								</li>
								<li>
									<a class="icon rounded fa-twitter"><span class="label">Twitter</span></a>
								</li>
								<li>
									<a class="icon rounded fa-google-plus"><span class="label">Google+</span></a>
								</li>
								<li>
									<a class="icon rounded fa-linkedin"><span class="label">LinkedIn</span></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</footer>

	</body>
</html>