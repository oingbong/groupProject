<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro(sortField) {
		location.href = "listNotice.do?sort="+sortField;
	}
</script>
</head>
<body>
	<section>
		<h3>공지사항 목록</h3>
		<h4>공지사항을 확인해보세요</h4>
		
		
		<form method="post" action="listNotice.do">
			<div class="row uniform 50%">
				<div class="12u$">
					<select name="searchField" >
						<option value="n_title">글제목</option>
						<option value="n_writer">작성자</option>
						<option value="n_content">글내용</option>
					</select>
					<ul class="actions">
						<li><input type="text" name="keyword" /></li>
						<li><input type="submit" value="검색" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
		
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th onclick="pro('n_no')">글번호</th>
						<th onclick="pro('n_title')">제목</th>
						<th onclick="pro('n_writer')">작성자</th>
						<th>작성일</th>
						<th onclick="pro('n_hit')">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="n">
						<tr>
							<td>${n.n_no }</td>
							<td>
							 	<!-- 답글의 깊이(b_level) 만큼 들여쓰기 -->
							 	<c:forEach  var="i" begin="1" end="${n.b_level }">
							 		&nbsp;&nbsp;
							 	</c:forEach>
							 	<c:if test="${n.b_level>0 }">
							 		=>
							 	</c:if>
							 					 	
							 	<a href="detailNotice.do?n_no=${n.n_no }">${n.n_title }</a> 
							</td>
							<td>${n.n_writer }</td>
							<td>${n.n_date }</td>
							<td>${n.n_hit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<center>${pageStr }</center> 
			
		</div>
			<c:if test="${m_type==1 }">
				<a href="insertNotice.do" class="button"><p>글 등록</p></a>
			</c:if>
	</section>
	
<!-- ---------------------------------------------- -->
<%-- 	<c:if test="${m_type==1 }">
	<a href="insertNotice.do">글 등록</a><br>
	</c:if>
	<h2>게시물 목록</h2>
	<hr>
	<form action="listNotice.do" method="post">
		<select name="searchField" >
			<option value="n_title">글제목</option>
			<option value="n_writer">작성자</option>
			<option value="n_content">글내용</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>		
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		
		<c:forEach items="${list }" var="n">
			<tr>
				<td>${n.n_no }</td>
				<td>
				 	<!-- 답글의 깊이(b_level) 만큼 들여쓰기 -->
				 	<c:forEach  var="i" begin="1" end="${n.b_level }">
				 		&nbsp;&nbsp;
				 	</c:forEach>
				 	<c:if test="${n.b_level>0 }">
				 		=>
				 	</c:if>
				 					 	
				 	<a href="detailNotice.do?n_no=${n.n_no }">${n.n_title }</a> 
				</td>
				<td>${n.n_writer }</td>
				<td>${n.n_date }</td>
				<td>${n.n_hit }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<center>${pageStr }</center>  --%>	
</body>
</html>