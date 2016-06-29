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
		<h2>물품수정</h2>
		<p>수정할 물품의 정보를 입력해주세요</p>
	</header>

	<section>
		<form method="post" action="updateNotice.do" enctype="multipart/form-data">
			<div class="row uniform 50%">
				<input type="hidden" name="n_no" value="${n.n_no }">
				<input type="hidden" name="n_fname" value="${n.n_fname }">	
				<input type="hidden" name="n_fsize" value="${n.n_fsize }">	
				
				<div class="6u 12u$(4)">
					글제목 : <input type="text" name="n_title" id="n_title" value="${n.n_title }" placeholder="제목을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					작성자 : <input type="text" name="n_writer" id="n_writer" value="${n.n_writer }" placeholder="회사명을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					내용 : <br>
					<textarea rows="5" cols="60" name="n_content"></textarea>
				</div>
				<div class="6u 12u$(4)">
					암호 : <input type="password" name="n_content" id="n_content" value="${n.n_content }" placeholder="회사명을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					첨부파일 : <input type="file" name="uploadFile" id="uploadFile"  placeholder="첨부파일을 입력해주세요" />
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
<!-- ----------------------------------------- -->
<%-- 	<h2>게시물 수정</h2>
	
	<form action="updateNotice.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="n_no" value="${n.n_no }">
	<input type="hidden" name="n_fname" value="${n.n_fname }">	
	<input type="hidden" name="n_fsize" value="${n.n_fsize }">	
	글제목 : <input type="text" name="n_title" value="${n.n_title }"><br>
	작성자 : <input type="text" name="n_writer" value="${n.n_writer }"><br>
	내용 : <br>
	<textarea rows="10" cols="80" name="n_content">${n.n_content }</textarea><br>
	암호 : <input type="password" name="n_pwd"><br>
	첨부파일 : <input type="file" name="uploadFile" ><br>
	<input type="submit" value="수정">
	<input type="reset" value="취소">
	</form> --%>
	
</body>
</html>