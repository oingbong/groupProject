<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Accordion - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#accordion").accordion();
	});
	// Q&A 삭제
	function pro(f_no) {
		q=confirm("Q&A 정말 삭제할래요?")
		if(q==true){
			alert("선택한 Q&A가 삭제되었습니다.")
			location.href = "deleteFaq.do?f_no="+f_no;
		}else{
			alert("다시 한번 생각해보세요.")
		}
	}
	// Q&A 수정
	function pro2(f_no) {
		q=confirm("Q&A 수정하러 갈래요?")
		if(q==true){
			alert("Q&A 수정페이지로 이동합니다.")
			location.href = "updateFaq.do?f_no="+f_no;
		}else{
			alert("다시 한번 생각해보세요.")
		}
	}	
</script>
</head>
<body>
	<header class="major">
		<h2>FAQ</h2>
		<p>자주하는 질문들을 확인해보세요</p>
		<!-- <p>주문상품 확인 및 할인가적용</p> -->
	</header>
	
	<section>
		<div class="table-wrapper" id="accordion">
			<c:forEach var="f" items="${list }">
				<h3>${f.f_title }</h3>
				<div>
					<p>
						${f.f_content }
					</p>
					<p>
						<c:if test="${m_type==1 }">
							<button class="button small" onclick="pro2(${f.f_no})">수정</button>
							<button class="button small" onclick="pro(${f.f_no})">삭제</button>
						</c:if>
					</p>
				</div>
			</c:forEach>
			
		</div>
			<br>
			<c:if test="${m_type==1 }">
				<a href="insertFaq.do" class="button">FAQ등록</a><br>
			</c:if>
	</section>

<!-- ------------------------- -->
<%-- 	<h2>Q & A</h2>
	<hr>
	<div id="accordion">
		<c:forEach var="q" items="${list }">
			<h3>${q.a_title }</h3>
			<div>
				<p>
					${q.a_content }
				</p>
				<p>
					<a href="updateQna.do?a_no=${q.a_no }">수정</a>
					<a href="deleteQna.do?a_no=${q.a_no }">삭제</a>
				</p>
			</div>
			
		</c:forEach>
		
	</div>
	
	<c:if test="${m_type==1 }">
		<a href="insertQna.do">등록</a><br>
	</c:if>
	 --%>


</body>
