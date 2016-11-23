<%@page import="com.app.mvc.util.UrlSortnerUtil"%>
<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:if test="${cityDTO!=null}">Search Results | ${cityDTO.cityName} | Get City Dealz</c:if> <c:if test="${cityDTO==null}">Find the Best Deals, Bargains, Events & Promos in Your City | Get City Dealz</c:if></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/jquery-ui.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="http://connect.facebook.net/en_US/all.js"></script>
<script src="https://apis.google.com/js/client.js?onload=handleClientLoad" gapi_processed="true"></script>

<script src="<c:url value='resources/js/googleLogin.js'/>"></script>
<script src="<c:url value='resources/js/facebookLogin.js'/>"></script>
<script>
	window.fbAsyncInit = FB.init({
		appId : '1499701620271988',
		status : true,
		cookie : true,
		xfbml : true
	});
</script>
<style type="text/css">
.circle {
	width: 100px;
	height: 100px;
	-moz-border-radius: 100px;
	-webkit-border-radius: 100px;
}

.inset {
	-moz-box-shadow: inset 0 3px 8px rgba(0, 0, 0, .4);
	-webkit-box-shadow: inset 0 3px 8px rgba(0, 0, 0, .4);
	box-shadow: inset 0 3px 8px rgba(0, 0, 0, .24);
}
</style>
</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=1499701620271988&version=v2.0";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<div id="wrapper">
		<%@include file="../common/header.jsp"%>
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
		<%@include file="../common/left.jsp"%>
		<!-- Menu section end here -->
		<div class="cent center-both no-right">
			<form action="searchQuery">
				<div style="height: 25px; width: 185px; background: rgb(37, 70, 87); border-radius: 6px;">
					<input name="query" class="searchfield" type="text" placeholder="Search" style="margin: 1px 0 0 4px;" />
				</div>
				<div style="margin: -25px 0px 0 186px;">
					<input type="submit" name="searchBtn" id="searchBtn" class="mediumBtn" value="Search" />
				</div>
			</form>
			<c:if test="${socialProfileDTO.emailId==null}">
				<div style="margin: -32px 0 0 454px;" id="facebookLoginBtn">
					<a href="javascript:void(0);" onclick="loginFacebook();"><img alt="facebook login" src="<c:url value='resources/images/fb-login.png'/>" width="100" height="35" /></a>
				</div>
				<div style="margin-top: -41px; float: right;" id="googleSignInBtn">
					<a href="javascript:void(0);" id="googlelogin"><img alt="facebook login" src="<c:url value='resources/images/gSignIn.png'/>" width="100" height="42" /></a>
				</div>
			</c:if>
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title"></div>
				<h3 class="msg">
					<em>Query : [${query}]</em>
				</h3>
				<ul>
					<c:forEach var="queryReuslt" items="${queryResultMap}">
						<li><a href="${queryReuslt.key}">${queryReuslt.value}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<%@include file="../common/right.jsp"%>
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
</body>

<script type="text/javascript">
$(function() {
	// Search
		
	// Search End
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

	ga('create', 'UA-36507206-1', 'auto');
	ga('send', 'pageview');
			
	var retVal = $.ajax({
		url : "jsonGetHotDealz",
		type : "POST",
		global : false,
		dataType : "json",
		async : false
	}).responseText;
	
	var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
	if (obj != null) {
		var bannerArr = obj.bannerDTOs;
		var sliderImage='';
		for(var i=0;i<bannerArr.length;i++){
			'<c:set var="merchantName" value="'+bannerArr[i].merchantName+'" />';
			<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
			<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" id="wrap'+(i+1)+'" style="visibility: hidden;"/></a>';
		}
		//sliderImage +='<div class="clr"></div>';
		$("#slider").append(sliderImage);
	}
});

(function(i, s, o, g, r, a, m) {
	i['GoogleAnalyticsObject'] = r;
	i[r] = i[r] || function() {
		(i[r].q = i[r].q || []).push(arguments)
	}, i[r].l = 1 * new Date();
	a = s.createElement(o), m = s.getElementsByTagName(o)[0];
	a.async = 1;
	a.src = g;
	m.parentNode.insertBefore(a, m)
})(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

ga('create', 'UA-36507206-1', 'auto');
ga('send', 'pageview');

</script>
<script type="text/javascript">
	$(function() {
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0 && '<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>'.length==0)
			window.location.href = "merchantHome";
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0 &&'<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>'.length!=0 && '<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>'=='1002')
			window.location.href = "component/adminDashboard";		
	});

	function becomeAmerchant() {
		window.open("become-a-merchant");
	}

	function rateDealz(rate, dealzId) {
		var retVal = $.ajax({
			url : "rateDealz",
			global : false,
			type : "POST",
			data : {
				rate : rate,
				dealzId : dealzId
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			if (obj.jsonMessage == null) {
				if (obj.currentRating == "1") {
					$("#ratingStart1" + dealzId).addClass('on');
				} else if (obj.currentRating == "2") {
					$("#ratingStart1" + dealzId).addClass('on');
					$("#ratingStart2" + dealzId).addClass('on');
				} else if (obj.currentRating == "3") {
					$("#ratingStart1" + dealzId).addClass('on');
					$("#ratingStart2" + dealzId).addClass('on');
					$("#ratingStart3" + dealzId).addClass('on');
				} else if (obj.currentRating == "4") {
					$("#ratingStart1" + dealzId).addClass('on');
					$("#ratingStart2" + dealzId).addClass('on');
					$("#ratingStart3" + dealzId).addClass('on');
					$("#ratingStart4" + dealzId).addClass('on');
				} else if (obj.currentRating == "5") {
					$("#ratingStart1" + dealzId).addClass('on');
					$("#ratingStart2" + dealzId).addClass('on');
					$("#ratingStart3" + dealzId).addClass('on');
					$("#ratingStart4" + dealzId).addClass('on');
					$("#ratingStart5" + dealzId).addClass('on');
				}
				$(".error").html('');
				$("#error"+dealzId).html('Thank You For Rating.');
				$("#currentRating"+dealzId).html(obj.currentRating+"");
			} else {
				//alert(obj.jsonMessage);
				$(".error").html('');
				$("#error"+dealzId).html('<li>' + obj.jsonMessage + '</li>');
			}
		}
	}

	function rate(currentRating, dealzId) {
		if (currentRating == "1") {
			$("#ratingStart1" + dealzId).addClass('on');
		} else if (currentRating == "2") {
			$("#ratingStart1" + dealzId).addClass('on');
			$("#ratingStart2" + dealzId).addClass('on');
		} else if (currentRating == "3") {
			$("#ratingStart1" + dealzId).addClass('on');
			$("#ratingStart2" + dealzId).addClass('on');
			$("#ratingStart3" + dealzId).addClass('on');
		} else if (currentRating == "4") {
			$("#ratingStart1" + dealzId).addClass('on');
			$("#ratingStart2" + dealzId).addClass('on');
			$("#ratingStart3" + dealzId).addClass('on');
			$("#ratingStart4" + dealzId).addClass('on');
		} else if (currentRating == "5") {
			$("#ratingStart1" + dealzId).addClass('on');
			$("#ratingStart2" + dealzId).addClass('on');
			$("#ratingStart3" + dealzId).addClass('on');
			$("#ratingStart4" + dealzId).addClass('on');
			$("#ratingStart5" + dealzId).addClass('on');
		}
		$("#currentRating"+dealzId).html(currentRating);
	}
	

	/* function shareOnFB(link, picture, name, desc, redirect) {
		window.open('https://www.facebook.com/dialog/feed?app_id=174025642805043&' + 'link=${pageContext.request.scheme}://${pageContext.request.serverName}/'+link + '&picture=http://gcddev.com/displayImage?image='
				+ picture + '&name=' + name + '&description=' + desc
				+ '&redirect_uri=${pageContext.request.scheme}://${pageContext.request.serverName}${requestScope["javax.servlet.forward.request_uri"]}');
	} */
	
    function PrintDiv(divToPrint) {
    	//alert(divToPrint);
       var divToPrint = document.getElementById(divToPrint);
       var popupWin = window.open('', '_blank', 'width=300,height=300');
       popupWin.document.open();
       popupWin.document.write('<html>'+document.getElementsByTagName('head')[0].innerHTML+'<body onload="window.print()">' + divToPrint.innerHTML + '</html>');
        popupWin.document.close();
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
        });
    }
    
    function searchQuery(){
    	if($(".searchfield").val()=='')
    		return false;
    	var retVal = $.ajax({
    		url : "jsonAutoFileQuery",
    		type : "POST",
    		global : false,
    		data :{
    			query:$(".searchfield").val()
    		},
    		dataType : "json",
    		async : false
    	}).responseText;
    	
    	var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
    	if (obj != null) {
    		var arr = new Array();
    		var i=0;
    		$.each( obj, function( keys, values ) {
    				var map1 = new Object();
    				map1['value'] = keys;
    				map1['label'] = values;
    				/* map1['desc'] = values;
    				map1['icon'] = values; */
    				arr[i++] = map1;
    		});
    		console.log(arr);    		
    		
    		$( ".searchfield" ).autocomplete({
    		      minLength: 0,
    		      source: arr,
    		      focus: function( event, ui ) {
    		    	  console.log(ui);
    		        $( ".searchfield" ).val( ui.item.label );
    		        return false;
    		      },
    		      select: function( event, ui ) {
    		        $( ".searchfield" ).val( ui.item.label );
    		        $( "#project-id" ).val( ui.item.value );
    		        window.location.href=ui.item.value;
    		       /*  $( "#project-description" ).html( ui.item.desc );
    		        $( "#project-icon" ).attr( "src", "images/" + ui.item.icon ); */
    		 
    		        return false;
    		      }
    		    })
    		    .autocomplete( "instance" )._renderItem = function( ul, item ) {
    		      return $( "<li>" )
    		        .append( "<a>" + item.label +"</a>" )
    		        .appendTo( ul );
    		    };
    	}
    }
</script>
</html>
