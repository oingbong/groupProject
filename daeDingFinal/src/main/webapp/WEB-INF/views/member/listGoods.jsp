<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro(value) {
			location.href = "listGoods.do?type="+value;
	}
</script>
</head>
<body>
	<header class="major">
		<h2>상품목록</h2>
		<p>다양한 상품을 확인하세요</p>
	</header>
	<select onchange="pro(this.value)">
			<option value="" selected="selected">구분</option>
				<option value="1">의류</option>
				<option value="2">식품</option>
				<option value="3">뷰티</option>
				<option value="4">주방용품</option>
				<option value="5">가구</option>
				<option value="6">가전/디지털</option>
				<option value="7">스포츠레저</option>
				<option value="8">반려/애완용품</option>
	</select>
	<section>
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>-----------</th>
						<th>Category</th>
						<th>-----------</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="g" items="${list }" varStatus="status">
							<td>
								<div class="4u"><span class="image fit">
								<img src="../resources/upload/${g.g_img}" width="200" height="200"><br>
								<a href="detailGoods.do?g_no=${g.g_no }">${g.g_name }</a><br>
								${g.g_saleprice }
								</span>
								</div>
							</td>
							
							<c:if test="${ status.count%3==0}">
							</tr><tr>
							</c:if>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	
		<c:if test="${m_type==1 }">
			<a href="../member/insertGoods.do" class="button">상품등록</a>
		</c:if>
	</section>
	
	

</body>
</html>