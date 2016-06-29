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
		<h2>상품등록</h2>
		<p>등록할 상품의 정보를 입력해주세요</p>
	</header>
	
	<section>
		<form method="post" action="insertGoods.do" enctype="multipart/form-data">
			<div class="row uniform 50%">
				<div class="6u 12u$(4)">
					<select name="g_type" id="g_type">
						<option selected="selected">분류를 선택하세요~</option>
						<option value="1">의류</option>
						<option value="2">식품</option>
						<option value="3">뷰티</option>
						<option value="4">주방용품</option>
						<option value="5">가구</option>
						<option value="6">가전/디지털</option>
						<option value="7">스포츠레저</option>
						<option value="8">반려/애완용품</option>
					</select>
				</div>
				<div class="6u 12u$(4)">
					상품명 : <input type="text" name="g_name" id="g_name" value="" placeholder="물건명을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					가격 : <input type="text" name="g_price" id="g_price" value="" placeholder="가격을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					할인가격 : <input type="text" name="g_saleprice" id="g_saleprice" value="" placeholder="할인가격을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					배송비 : <input type="text" name="g_delivery" id="g_delivery" value="" placeholder="배송비를 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					업체명 : <input type="text" name="g_companyname" id="g_companyname" value="" placeholder="업체명을 입력해주세요" />
				</div>
				<div class="6u 12u$(4)">
					이미지 : <input type="file" name="g_uploadimg" id="g_uploadimg" value="" />
				</div>
				
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="물품등록" class="special" /></li>
						<li><input type="reset" value="취소" /></li>
					</ul>
				</div>
			</div>
		</form>
	</section>

<!--  -->
<!--  	<h2>물품등록</h2>
	<hr>

	<form action="insertGoods.do" method="post" enctype="multipart/form-data">
		물건명 : <input type="text" name="g_name"><br>
		가격 : <input type="text" name="g_price"><br>
		할인가격 : <input type="text" name="g_saleprice"><br>
		배송비 : <input type="text" name="g_delivery"><br>
		업체명 : <input type="text" name="g_companyname"><br>		
		이미지 : <input type="file" name="g_uploadimg"><br>
		
		<input type="submit" value="등록">
		<input type="reset" value="취소">
			
	</form> -->



</body>
</html>