<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- GoogoleMap Asynchronously Loading the API ********************************************* -->
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">

      function initialize() {
        var mapLocation = new google.maps.LatLng('37.552342 ', '126.937781'); // 지도에서 가운데로 위치할 위도와 경도 
        var markLocation = new google.maps.LatLng('37.552342', '126.937781'); // 마커가 위치할 위도와 경도

        var mapOptions = {
          center: mapLocation, // 지도에서 가운데로 위치할 위도와 경도(변수)
          zoom: 18, // 지도 zoom단계
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };

        var map = new google.maps.Map(document.getElementById("map-canvas"), // id: map-canvas, body에 있는 div태그의 id와 같아야 함
            mapOptions);

        var size_x = 60; // 마커로 사용할 이미지의 가로 크기
        var size_y = 60; // 마커로 사용할 이미지의 세로 크기

        // 마커로 사용할 이미지 주소
        var image = new google.maps.MarkerImage( 'http://www.larva.re.kr/home/img/boximage3.png',
                            new google.maps.Size(size_x, size_y),
                            '',
                            '',
                            new google.maps.Size(size_x, size_y));

        var marker;
        marker = new google.maps.Marker({ 
               position: markLocation, // 마커가 위치할 위도와 경도(변수)
               map: map,
               icon: image, // 마커로 사용할 이미지(변수)
//             info: '말풍선 안에 들어갈 내용',
               title: '회사위치' // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
        });
        var content = "서울시 마포구 신수동"; // 말풍선 안에 들어갈 내용

        // 마커를 클릭했을 때의 이벤트. 말풍선 뿅~
        var infowindow = new google.maps.InfoWindow({ content: content});
        google.maps.event.addListener(marker, "click", function() {

            infowindow.open(map,marker);
        });
      }
      google.maps.event.addDomListener(window, 'load', initialize);

</script>
</head>
<body>
	<header class="major">
		<h2>Contact Us</h2>
		<p>회사위치</p>
	</header>
	<div id="map-canvas" style="width: 100%; height: 400px;"></div>
		<ul>
			<p><small><strong>대딩 프로젝트</strong></small></p>
				<p><small>박제현</small></p>
				<p><small>오재현</small></p>
				<p><small>하희경</small></p>
		</ul>
</body>
</html>