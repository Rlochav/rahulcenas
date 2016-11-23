<%@page import="com.app.mvc.util.UrlSortnerUtil"%>
<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:if test="${cityDTO!=null}">${cityDTO.cityName} Deal Alert Sign Up | Get City Dealz</c:if></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>

<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://apis.google.com/js/client.js?onload=OnLoadCallback"></script>
<script type="text/javascript">
					function signinCallback(authResult) {
					  if (authResult['status']['signed_in']) {
					    //document.getElementById('signinButton').setAttribute('style', 'display: none');
					    gapi.client.setApiKey('AIzaSyBD1Gq-gv7pQCvhGROVLapuM0HikN-0st4');

					    var retVal = $.ajax({
							url : "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token="+authResult.access_token,
							type : "GET",
							global : false,
							dataType : "json",
							async : false
						}).responseText;
					   
					    retVal = jQuery.parseJSON(retVal);
					    if(retVal!=null){
					    	console.log(retVal.given_name+" "+retVal.family_name+" "+retVal.email);
					    	$("#firstName").val(retVal.given_name);
					    	$("#lastName").val(retVal.family_name);
					    	$("#emailId").val(retVal.email);
					    	$("#socialProfileDetails").hide();
					    	$("#userNamz").html("Hi "+retVal.given_name+",");
					    }
					  } else {
					    console.log('Sign-in state: ' + authResult['error']);
					  }
					}
				</script>

</head>
<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=1499701620271988&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

	<script src="http://connect.facebook.net/en_US/all.js"></script>
	<script>
	window.fbAsyncInit = FB.init({
		appId : '1499701620271988',
		status : true,
		cookie : true,
		xfbml : true
	});
</script>
	<div id="wrapper">
		<%@include file="../common/header4.jsp"%>
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
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title">Get the Latest Daily Deals in ${cityDTO.cityName} First!</div>
				<br>
				<div class="items">
					<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
						<span id="userNamz"></span>
						<table id="socialProfileDetails">
							<tr>
								<td>First Name:</td>
								<td><input type="text" id="firstName" class="mInput" value="${fName}" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>Last Name:</td>
								<td><input type="text" id="lastName" class="mInput" value="${lName}" /></td>
								<td><div style="margin: 0 0 0 132px;">
										<a href="#" onclick="loginFacebook();"><img alt="facebook login" src="<c:url value='resources/images/fb-login.png'/>" width="111" height="35" /></a> <span id="signinButton"> <span class="g-signin" data-callback="signinCallback"
											data-clientid="409160420325-ub8u1td20i4it7fi1mi2hcfvi77ao32p.apps.googleusercontent.com" data-cookiepolicy="single_host_origin" data-requestvisibleactions="http://schema.org/AddAction"
											data-scope="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email"> </span>
										</span>
									</div></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><input type="text" id="emailId" class="mInput" onblur="validateEmail(this);" value="${email}" /></td>
								<td>&nbsp;</td>
							</tr>
						</table>
						<table class="items_list subscribers" style="width: 100%;" border="0">
							<th><input type="checkbox" id="categoryChk" name="categoryChk" onclick="" />&nbsp;Choose Your Neighborhoods</th>
							<th><input type="checkbox" id="neighborhoodsChk" name="neighborhoodsChk" />&nbsp;Choose Your Categories</th>
							<th>Follow Us</th>
							<c:forEach var="categoryDTOss" items="${subscriptionCtg}">
								<tr>
									<td>
										<div id="neighbor-div">
											<c:forEach var="categoryDTO" items="${categoryDTOss.categoryDTOs}">
												<input type="checkbox" class="CidRow" value="${categoryDTO.categoryId}" /> ${categoryDTO.categoryName} <br />
											</c:forEach>
										</div>
									</td>
									<td>
										<div id="category-div">
											<c:forEach var="neighborhoodDTO" items="${categoryDTOss.neighborhoodDTOs}">
												<input type="checkbox" class="NidRow" value="${neighborhoodDTO.neighborhoodId}" /> ${neighborhoodDTO.neighborhoodName} <br />
											</c:forEach>
										</div>
									</td>
									<td><br> <br> <a href="http://www.facebook.com/GetCityDealz" target="_blank"> <img src="<c:url value='resources/images/facebook-24x24.png'/>" title="Facebook">
									</a>&nbsp;&nbsp; <a href="http://www.twitter.com/GetCityDealz" target="_blank"> <img src="<c:url value='resources/images/twitter-24x24.png'/>" title="Twitter"></a></td>
								</tr>
							</c:forEach>
						</table>
						<table class="items_list" width="100%" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td style="width: 27%;">To subscribe to a specific merchant, subscribe from their page</td>
								<td><input type="radio" name="type_of_subscriber" value="1" checked="checked">Receive email as new deal gets created<input type="radio" name="type_of_subscriber" value="2">Receive email as daily digest<br> <br>
									<div style="float: right;">
										<input type="reset" value="Reset My Choices" /> <input type="button" onclick="subscribe();" value="Send Me My Deals" />
									</div></td>
							</tr>
						</table>
					</form:form>
				</div>
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
	$(function(){
		
		if("${email}"!=""){
			$("#socialProfileDetails").hide();
			$("#userNamz").html("Hi ${fName},");
		}
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
	$(document).on('click change', 'input[name="categoryChk"]', function() {
		var checkboxes = $('.CidRow');
		if ($(this).is(':checked')) {
			checkboxes.prop("checked", true);
		} else {
			checkboxes.prop("checked", false);
		}
	});

	$(document).on('click change', 'input[name="neighborhoodsChk"]',
			function() {
				var checkboxes = $('.NidRow');
				if ($(this).is(':checked')) {
					checkboxes.prop("checked", true);
				} else {
					checkboxes.prop("checked", false);
				}
			});
	function validateEmail(emailField) {
		var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

		if (reg.test(emailField.value) == false) {
			$.alert.open('error', 'e-Mail Address is invalid.');
			return false;
		}

		return true;

	}
	function subscribe() {
		var cRows = $('.CidRow:checkbox:checked').map(function() {
			return this.value;
		}).get();

		var nRows = $('.NidRow:checkbox:checked').map(function() {
			return this.value;
		}).get();

		var subscriptionType = $("input[type='radio'][name='type_of_subscriber']:checked");

		subscriptionType = subscriptionType.val();

		var retVal = $.ajax({
			url : "jsonSubscribeDeails",
			type : "POST",
			global : false,
			data : {
				firstName : $("#firstName").val(),
				lastName : $("#lastName").val(),
				emailId : $("#emailId").val(),
				subscriptionType : subscriptionType,
				nRows : nRows + "",
				cRows : cRows + ""
			},
			dataType : "json",
			async : false
		}).responseText;

		if (retVal.length > 0) {
			$.alert.open('info', retVal + "");
		}
		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj == null)
			$.alert
					.open(
							'info',
							"Congratulations! You have successfully subscribed to deal. A mail is sent to you as conformation");
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
            
            $("#firstName").val(fName);
	    	$("#lastName").val(lName);
	    	$("#emailId").val(response.email);
	    	$("#socialProfileDetails").hide();
	    	
            $("#socialProfileDetails").hide();
			$("#userNamz").html("Hi "+fName+",");
        });
    }
</script>
</html>
