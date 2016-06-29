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
	// Q&A ����
	function pro(f_no) {
		q=confirm("Q&A ���� �����ҷ���?")
		if(q==true){
			alert("������ Q&A�� �����Ǿ����ϴ�.")
			location.href = "deleteFaq.do?f_no="+f_no;
		}else{
			alert("�ٽ� �ѹ� �����غ�����.")
		}
	}
	// Q&A ����
	function pro2(f_no) {
		q=confirm("Q&A �����Ϸ� ������?")
		if(q==true){
			alert("Q&A ������������ �̵��մϴ�.")
			location.href = "updateFaq.do?f_no="+f_no;
		}else{
			alert("�ٽ� �ѹ� �����غ�����.")
		}
	}	
</script>
</head>
<body>
	<header class="major">
		<h2>FAQ</h2>
		<p>�����ϴ� �������� Ȯ���غ�����</p>
		<!-- <p>�ֹ���ǰ Ȯ�� �� ���ΰ�����</p> -->
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
							<button class="button small" onclick="pro2(${f.f_no})">����</button>
							<button class="button small" onclick="pro(${f.f_no})">����</button>
						</c:if>
					</p>
				</div>
			</c:forEach>
			
		</div>
			<br>
			<c:if test="${m_type==1 }">
				<a href="insertFaq.do" class="button">FAQ���</a><br>
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
					<a href="updateQna.do?a_no=${q.a_no }">����</a>
					<a href="deleteQna.do?a_no=${q.a_no }">����</a>
				</p>
			</div>
			
		</c:forEach>
		
	</div>
	
	<c:if test="${m_type==1 }">
		<a href="insertQna.do">���</a><br>
	</c:if>
	 --%>


</body>
