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
		<h2>공지사항 등록</h2>
		<p>등록할 공지사항의 정보를 입력해주세요</p>
	</header>

	<section>
		<form method="post" action="insertNotice.do" enctype="multipart/form-data">
			<input type="hidden" name="n_no" value="${n_no }">
			<input type="hidden" name="b_ref" value="${b_ref }">
			<input type="hidden" name="b_level" value="${b_level }">
			<input type="hidden" name="b_step" value="${b_step }">
			<div class="row uniform 50%">
				<div class="6u 12u$(4)">
					글제목 : <input type="text" name="n_title" id="n_title" value="" placeholder="글제목을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					작성자 : <input type="text" name="n_writer" id="n_writer" value="${s.m_id }" placeholder="작성자를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					내용 : <br>
					<textarea rows="5" cols="60" name="n_content"></textarea>
				</div>
				<div class="6u 12u$(4)">
					암호 : <input type="password" name="n_pwd" id="n_pwd" value="" placeholder="암호를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					첨부파일 : <input type="file" name="uploadFile" id="uploadFile" value="" />
				</div>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="공지사항 등록" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>

<%-- 	<h2>공지사항 등록</h2>
	
	<form action="insertNotice.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="n_no" value="${n_no }">
	<input type="hidden" name="b_ref" value="${b_ref }">
	<input type="hidden" name="b_level" value="${b_level }">
	<input type="hidden" name="b_step" value="${b_step }">
	
	글제목 : <input type="text" name="n_title"><br>
	작성자 : <input type="text" name="n_writer" value="${m_name }"><br>
	내용 : <br>
	<textarea rows="10" cols="80" name="n_content"></textarea><br>
	암호 : <input type="password" name="n_pwd"><br>
	첨부파일 : <input type="file" name="uploadFile"><br>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
	</form> --%>
	 
</body>
</html>