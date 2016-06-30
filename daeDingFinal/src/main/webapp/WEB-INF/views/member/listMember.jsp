<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro(m_id) {
		q=confirm("회원을 정말 삭제할래요?")
		if(q==true){
			alert("선택한 회원이 삭제되었습니다.")
			location.href = "deleteMember.do?m_id="+m_id;
		}else{
			alert("다시 한번 생각해보세요.")
		}
	}
</script>
</head>
<body>
	<header class="major">
		<h2>회원 목록</h2>
		<p>회원의 목록을 확인해보세요</p>
	</header>
	<section>
 		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>아이디</th>
						<th>회원유형</th>
						<th>이름</th>
						<th>비밀번호</th>
						<th>생일</th>
						<th>성별</th>
						<th>주소</th>
						<th>핸드폰</th>
						<th>이메일</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="m" items="${list }">
						<tr>
							<td>${m.m_id}</td>
							<td>${m.m_type}</td>
							<td><a href="detailMember.do?m_id=${m.m_id }">${m.m_name}</a></td>
							<td>${m.m_pwd}</td>
							<td>${m.m_birth}</td>
							<td>${m.m_gender}</td>
							<td>${m.m_addr}</td>
							<td>${m.m_phone}</td>
							<td>${m.m_email}</td>
							<td onclick="pro(${m.m_id})">삭제</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>