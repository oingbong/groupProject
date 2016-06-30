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
		<h2>FAQ 등록</h2>
		<p>등록할 공지사항의 정보를 입력해주세요</p>
	</header>

	<section>
		<form method="post" action="insertFaq.do" enctype="multipart/form-data">
			<div class="row uniform 50%">
				<div class="6u 12u$(4)">
					제목 : <input type="text" name="f_title" id="f_title" value="" placeholder="글제목을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					내용 : <br>
					<textarea rows="5" cols="60" name="f_content"></textarea>
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="FAQ 등록" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>
<!--  -->
<!-- 	<fieldset>
		<legend>Q&A 등록</legend>
		<form action="insertQna.do" method="post">
			제목 : <input type="text" name="a_title"><br>
			내용 : <br>
			<textarea rows="10" cols="60" name="a_content"></textarea><br>
			<input type="submit" value="등록하기">
			<input type="reset" value="취소하기">
		</form>
	</fieldset> -->
</body>
</html>