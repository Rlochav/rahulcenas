<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:if test="${cityDTO!=null}">${cityDTO.cityName} Map of Deals | Get City Dealz</c:if></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />
<link href="<c:url value='/resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://apis.google.com/js/client.js?onload=handleClientLoad" gapi_processed="true"></script>

<script src="<c:url value='/resources/js/googleLogin.js'/>"></script>
<script src="<c:url value='/resources/js/facebookLogin.js'/>"></script>

<style>
html,body,#map-canvas {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#panel {
	position: absolute;
	top: 5px;
	left: 50%;
	margin-left: -180px;
	z-index: 5;
	background-color: #fff;
	padding: 5px;
	border: 1px solid #999;
}

clazz {
	list-style-type: circle;
}
</style>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>

<script>	
	var lat  = [<c:forEach var="a" items="${dealzs}"><c:if test="${a.latitude != null}">${a.latitude},</c:if></c:forEach>];
	var lng  = [<c:forEach var="a" items="${dealzs}"><c:if test="${a.latitude != null}">${a.longitude},</c:if></c:forEach>];
	
	var berlin = new google.maps.LatLng(Math.max.apply(null, lat),Math.max.apply(null, lng));
	
	var neighborhoods = [<c:forEach var="a" items="${dealzs}"><c:if test="${a.latitude != null}">new google.maps.LatLng(${a.latitude}, ${a.longitude}),</c:if></c:forEach>];
	var markers  = [];
	var iterator = 0;

	var map;

	function initialize() {
		var mapOptions = {
			zoom : 10,
			center : new google.maps.LatLng(29.9653661,-90.0629989),
			mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);		
	}
	
	var contentString = [<c:forEach var="a" items="${dealzs}"><c:if test="${a.latitude != null}"> 
							"<div style='overflow: hidden; width: 397px; height: 190px;'><div class='' style='overflow: auto;'><div><img src='<c:out value='../displayImage?image=${a.merchantDTOs.logoImagePath}'/>' width='150px' height='100px'></div><div style='float:right;'>${a.merchantDTOs.merchantName}<br/>${locs.address1} ${locs.address2} ${locs.address3} ${a.merchantDTOs.cityText} ${a.merchantDTOs.state} ${a.merchantDTOs.zipCode}<br/> ${a.merchantDTOs.contactPhone} ${a.merchantDTOs.emailId}<br/>${a.merchantDTOs.websiteUrl}<br/>Recent Deal: <a id='dealbymap_deal_link' target='_blank' href='../${a.merchantName}/deal/${a.urlTitle}--${a.dealId}'>${a.merchantDTOs.latestDealTitle}!</a></div></div></div>",
							</c:if></c:forEach>];

	function drop() {
		 for (var i = 0; i < neighborhoods.length; i++) {
		   setTimeout(function() {
		     addMarker();
		   }, i * 200);
		}
	}
	//var infowindow = "";
	function addMarker() {
		var marker = new google.maps.Marker({
			map : map,
			animation : google.maps.Animation.DROP,
			draggable : false,
			position: neighborhoods[iterator]
		});
		var infowindow = new google.maps.InfoWindow({
		content : contentString[iterator]
		});
		
		google.maps.event.addListener(marker, 'click', function() {
			infowindow.open(map, marker);
		});
	  markers.push(marker);
	  iterator++;
	}
	
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body onload="drop();">
	<%@include file="../common/telliumTags.jsp"%>
	<script src="http://connect.facebook.net/en_US/all.js"></script>
	<script>
	window.fbAsyncInit = FB.init({
		appId : '1499701620271988',
		status : true,
		cookie : true,
		xfbml : true
	});
</script>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=1499701620271988&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
	<div id="wrapper">
		<%@include file="../common/header1.jsp"%>
		<div class="tagline">
			<div class="moduletable">
				<div class="custom">
					<p class="MsoNormal">
						<strong><spring:message code="common.html.000002"></spring:message></strong>
					</p>
				</div>
			</div>
		</div>
		<!-- Header section end here -->

		<%@include file="../common/left1.jsp"%>
		<!-- Menu section end here -->


		<div class="cent center-both no-right">
			<form action="../searchQuery">
				<div style="height: 25px; width: 185px; background: rgb(37, 70, 87); border-radius: 6px;">
					<input name="query" class="searchfield" type="text" placeholder="Search" style="margin: 1px 0 0 4px;" />
				</div>
				<div style="margin: -25px 0px 0 186px;">
					<input type="submit" name="searchBtn" id="searchBtn" class="mediumBtn" value="Search" />
				</div>
			</form>
			<c:if test="${socialProfileDTO.emailId==null}">
				<div style="margin: -32px 0 0 454px;" id="facebookLoginBtn">
					<a href="javascript:void(0);" onclick="loginFacebook();"><img alt="facebook login" src="<c:url value='/resources/images/fb-login.png'/>" width="100" height="35" /></a>
				</div>
				<div style="margin-top: -41px; float: right;" id="googleSignInBtn">
					<a href="javascript:void(0);" id="googlelogin"><img alt="facebook login" src="<c:url value='/resources/images/gSignIn.png'/>" width="100" height="42" /></a>
				</div>
			</c:if>
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title">Deals By Map</div>
				<div id="deal_content">
					<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
						<!-- Gmap Start-->
						<div id="map-canvas" style="width: 650px; height: 500px; margin: 0 0 0 2px;" align="center"></div>
						<!--Gmap End -->
					</form:form>
				</div>
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<%@include file="../common/right1.jsp"%>
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->


</body>
<script type="text/javascript">
$(function(){
	var retVal = $.ajax({
		url : "../jsonGetHotDealz",
		type : "POST",
		global : false,
		dataType : "json",
		async : false
	}).responseText;
	//alert(retVal);
	var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
	if (obj != null) {
		var bannerArr = obj.bannerDTOs;
		var sliderImage='';
		for(var i=0;i<bannerArr.length;i++){
			'<c:set var="merchantName" value="'+bannerArr[i].merchantName+'" />';
			<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
			<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="../displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
		}
		$("#slider").append(sliderImage);
	}
});
$("#city").change(function() {
	var geocoder = new google.maps.Geocoder();
	var address = $("#city option:selected").text();
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			var latitude = results[0].geometry.location.lat();
			var longitude = results[0].geometry.location.lng();
			$("#latitude").val(latitude);
			$("#longitude").val(longitude);
			initialize();
		} else {
			alert("Request failed.");
		}
	});
});

function openWindow(url) {
	window.open(url);
}

function loginFacebook() {
    FB.login(function(response) {
        if (response.authResponse) {
            // connected
        testAPI();
        } else {
            // cancelled
        }
    }, { scope: 'email' });
    }

function testAPI() {

    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
        console.log('Good to see you, ' + response.name + '.' + ' Email: ' + response.email + ' Facebook ID: ' + response.id);
        var strName = (response.name).split(" ");
        var fName = strName[0];
        var lName;
        if(strName.length>1)
        	lName = strName[1];
        doSubscribeViaChannel(fName,lName,response.email);
        $("#facebookLoginBtn").remove();
		$("#googleSignInBtn").remove();
    });
}

function validate(){
	if($(".searchfield").val()=='')
		return false;
	event.preventDefault();
}

function doSubscribeViaChannel(fName,lName,emailId){
	$.alert.open('confirm', 'Thanks for signing in!  Would you like to subscribe to local deal alerts now?', function(button) {
		if (button == 'yes') {
			window.location.href="http://neworleans.gcddev.com/subscribe?fName="+fName+"&lName="+lName+"&email="+emailId;
		}
		if (button == 'no') {
			var retVal = $.ajax({
				url : "../socialDetailsConsumer",
				global : false,
				type : "POST",
				data : {
					fName : fName,
					lName : lName,
					emailId:emailId
				},
				dataType : "json",
				async : false
			}).responseText;
		}
	});
}
</script>
</html>
