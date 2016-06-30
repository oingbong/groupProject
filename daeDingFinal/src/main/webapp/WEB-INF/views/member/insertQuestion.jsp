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
		<h2>문의메일 작성</h2>
		<p>문의 사항을 입력해주세요</p>
	</header>

	<section>
		<form method="post" action="insertQuestion.do" >
			<!-- <div class="row uniform 50%"> -->
				<div class="6u 12u$(4)">
					<select name="q_type" >
						<!-- <option value="q_title">문의분류</option>
						<option value="q_product">제품문의</option>
						<option value="q_delivery">배송문의</option> -->
						<option value="문의분류">문의분류</option>
						<option value="제품문의">제품문의</option>
						<option value="배송문의">배송문의</option>
					</select>
				</div>
				<div class="6u 12u$(4)">
					제목 : <input type="text" name="q_title" id="q_title" value="" placeholder="제목을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					문의내용 : <br>
					<textarea rows="5" cols="60" name="q_content" placeholder="문의내용을 입력해주세요" ></textarea>
				</div>				
				
				<div class="6u 12u$(4)">
					아이디 : <input type="text" name="q_id" id="q_id" value="${s.m_id }" placeholder="아이디를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					비밀번호 : <input type="password" name="q_pwd" id="q_pwd" value="" placeholder="비밀번호를 입력해주세요" />
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="물품등록" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			<!-- </div> -->
		</form>
	</section>
<!--  -->
 <%-- 	<h2>문의메일 쓰기</h2>
	<hr>
	
	<form action="insertQuestion.do" method="post">
	
	<select name="q_type" >
			<option value="q_title">문의분류</option>
			<option value="q_product">제품문의</option>
			<option value="q_delivery">배송문의</option>
		</select><br>
	제목 : <input type="text" name="q_title"><br>
	문의내용<br>
	<textarea rows="5" cols="30" name="q_content"></textarea><br>
	아이디 : <input type="text" name="q_id" value="${s.m_id }"><br>
	비밀번호 : <input type="password" name="q_pwd"><br>
	
	<input type="submit" value="등록">
	<input type="reset" value="취소">
	</form>  --%>

</body>
</html>