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
		<h2>FAQ 글 수정</h2>
		<p>자주하는 질문에 대한 내용 수정을 하세요</p>
	</header>

	<section>
		<form method="post" action="updateFaq.do" enctype="multipart/form-data">
			<div class="row uniform 50%">
			
				<input type="hidden" name="f_no" value="${f.f_no }">
				
				<div class="6u 12u$(4)">
					글제목 : <input type="text" name="f_title" id="f_title" value="${f.f_title }" placeholder="글제목을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					내용 : <br>
					<textarea rows="5" cols="60" name="f_content">${f.f_content }</textarea>
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="수정" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
<!-- ------------------------------------- -->
<%-- 	<h2>게시물 수정</h2>
	
	<form action="updateQna.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="a_no" value="${a.a_no }">
		글제목 : <input type="text" name="a_title" value="${a.a_title }"><br>
		내용 : <br>
		<textarea rows="10" cols="80" name="a_content">${a.a_content }</textarea><br>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form> --%>
	
</body>
</html>