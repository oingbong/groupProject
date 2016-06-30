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
		<form method="post" action="updateGoods.do">
			<div class="row uniform 50%">
				<input type="hidden" value="${list.g_no }" name="g_no">
				<div class="6u 12u$(4)">
					물품명 : <input type="text" name="g_name" id="g_name" value="${list.g_name }" placeholder="물품명 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					정상가격 : <input type="text" name="g_price" id="g_price" value="${list.g_price }" placeholder="할인 전 가격을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					할인가격 : <input type="password" name="g_saleprice" id="g_saleprice" value="${list.g_saleprice }" placeholder="할인 후 가격을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					배송비 : <input type="text" name="g_delivery" id="g_delivery" value="${list.g_delivery }" placeholder="배송비을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					회사명 : <input type="text" name="g_companyname" id="g_companyname" value="${list.g_companyname }" placeholder="회사명을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					이미지 : <input type="text" name="g_img" id="g_img" value="${list.g_img }" placeholder="이미지를 입력해주세요" />
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
<!-- ------------------------------------ -->
<%-- 	<h2>물품 수정하기</h2>
	<hr>
	
	<form action="updateGoods.do" method="post">
	
		<input type="hidden" value="${list.g_no }" name="g_no"><br>
		물품명 : <input type="text" value="${list.g_name }" name="g_name"><br>
		정상가격 : <input type="text" value="${list.g_price }" name="g_price"><br>
		할인가격 : <input type="text" value="${list.g_saleprice }" name="g_saleprice"><br>
		배송비 : <input type="text" value="${list.g_delivery }" name="g_delivery"><br>
		회사명 : <input type="text" value="${list.g_companyname }" name="g_companyname"><br>
		이미지 : <input type="text" value="${list.g_img }" name="g_img"><br>
		
		<input type="submit" value="수정"><input type="reset" value="취소">
	</form> --%>

</body>
</html>