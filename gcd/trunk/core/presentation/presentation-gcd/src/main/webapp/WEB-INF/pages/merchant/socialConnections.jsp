<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template1.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>

<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />

<script src="https://apis.google.com/js/platform.js" async defer></script>
<style type="text/css">

/* Styles for DJ Image Slider with module id 87 */
#djslider-loader87 {
	margin: 0 auto;
	position: relative;
}

#djslider87 {
	margin: 0 auto;
	position: relative;
	height: 216px;
	width: 658px;
	max-width: 658px;
}

#slider-container87 {
	position: absolute;
	overflow: hidden;
	left: 0;
	top: 0;
	height: 100%;
	width: 100%;
}

#djslider87 ul#slider87 {
	margin: 0 !important;
	padding: 0 !important;
	border: 0 !important;
}

#djslider87 ul#slider87 li {
	list-style: none outside !important;
	float: left;
	margin: 0 !important;
	border: 0 !important;
	padding: 0 0px 0px 0 !important;
	position: relative;
	height: 216px;
	width: 658px;
	background: none;
	overflow: hidden;
}

#slider87 li img {
	width: 100%;
	height: auto;
	border: 0 !important;
	margin: 0 !important;
}

#slider87 li a img,#slider87 li a:hover img {
	border: 0 !important;
}

/* Navigation buttons */
#navigation87 {
	position: relative;
	top: 13.8888888889%;
	margin: 0 5px;
	text-align: center !important;
}

#prev87 {
	cursor: pointer;
	display: block;
	position: absolute;
	left: 0;
}

#next87 {
	cursor: pointer;
	display: block;
	position: absolute;
	right: 0;
}

table {
	display: table;
	border-collapse: separate;
	border-spacing: 2px;
	border-color: gray;
}

table[Attributes Style] {
	border-spacing: 0px;
}

th {
	font-weight: bold;
}

td,th {
	display: table-cell;
	vertical-align: inherit;
}
</style>

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
					    	console.log(retVal.given_name+" "+retVal.family_name+" "+retVal.id);
					    	$("#gPlusAccount").val('https://plus.google.com/'+retVal.id);
					    }
					  } else {
					    console.log('Sign-in state: ' + authResult['error']);
					  }
					}
				</script>
</head>
<body>
	<%@include file="../common/telliumTags.jsp"%>
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
		<%@include file="../common/merchantLeft.jsp"%>
		<!-- Menu section end here -->

		<div class="cent center-leftcenter-both no-right">
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="dashboard-area">
					<div id="title" class="merchantTitle">
						<span id="titleSpan">HI THERE ${SESSION_ATTR_USER_INFO.userName} MANAGE YOUR SOCIAL INFORMATION 
					</div>

					<br>
					<div class="items">
						<form:form id="socialConnectionForm" name="socialConnectionForm" class="formStyle">
							<h3 class="msg">
								<em>Manage Social Community Connections</em>
								<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
									<label class="error" id="error"></label>
								</div>
								<div id="success" class="success">
									<label></label><input type="text" style="display: none;" id="connectionId" />
								</div>
							</h3>
							<div class="profile">
								<table cellspacing="0" cellpadding="0" style="width: 100%;" class="tableStyle custom_td">
									<tbody>
										<tr>
											<th width="20%">&nbsp;</th>
											<th width="30%">&nbsp;</th>
											<th width="20%">Show On Page</th>
										</tr>
										<tr>
											<td><label id="jform_facebook_fan_page-lbl" class="hasTip" title="">Facebook Fan Page</label></td>
											<td><input type="text" value="${socialDTO.facebookFanPage}" name="facebookFanPage" id="facebookFanPage" class="lInput">
												<div id="facebook_fan_page_result">
													<input id="tuser_valid" type="hidden" value="true" name="fuser_valid">
												</div></td>
											<td><input type="checkbox" name="facebookFanPagechk" id="facebookFanPagechk"></td>

										</tr>
										<tr>
											<td>Facebook Post deals to:</td>
											<td><strong> ${socialDTO.fbPostDealzTo}</strong></td>
											<td><a href="signInFacebook"><img alt="Facebook Login" src="<c:url value='resources/images/connectToFacebook.jpg'/>" width="144" /></a></a></td>
										</tr>
										<tr>
											<td><label id="jform_twitter_id-lbl" class="hasTip" title="">Twitter Account</label></td>
											<td><input type="text" value="${socialDTO.twitterAccount}" name="twitterAccount" id="twitterAccount" class="lInput">
												<div id="twitter_fan_page_result">
													<input id="tuser_valid" type="hidden" value="true" name="tuser_valid" class="lInput" />
												</div></td>
											<td><input type="checkbox" name="twitterAccountchk" id="twitterAccountchk"></td>
										</tr>
										<tr>
											<td>Twitter Post to:</td>
											<td><strong> ${socialDTO.twitterScreenName}</strong></td>
											<td><a href="javascript:void(0);" onclick="getOAuthUrl();"><img alt="Twitter Login" src="<c:url value='resources/images/TwitterLogin.png'/>" width="144" /></a></td>
										</tr>
										<tr>
											<td><label id="jform_four_square_username-lbl" class="hasTip" title="" aria-invalid="false">Four Square Account</label></td>
											<td><input type="text" value="${socialDTO.fourSquareAccount}" name="fourSquareAccount" id="fourSquareAccount" class="lInput" /></td>
											<td><input type="checkbox" name="fourSquareAccountchk" id="fourSquareAccountchk"></td>
										</tr>
										<tr>
											<td><label id="jform_yelp_username-lbl" class="hasTip" title="">Yelp Account</label></td>
											<td><input type="text" value="${socialDTO.yelpAccount}" name="yelpAccount" id="yelpAccount" class="lInput" /></td>
											<td><input type="checkbox" name="yelpAccountchk" id="yelpAccountchk"></td>
										</tr>
										<tr>
											<td><label id="jform_flicker_username-lbl" class="hasTip" title="">Flicker Account</label></td>
											<td><input type="text" value="${socialDTO.flickerAccount}" name="flickerAccount" id="flickerAccount" class="lInput" /></td>
											<td><input type="checkbox" name="flickerAccountchk" id="flickerAccountchk"></td>
										</tr>
										<tr>
											<td><label id="jform_youtube_username-lbl" class="hasTip" title="">Youtube Account</label></td>
											<td><input type="text" value="${socialDTO.youtubeAccount}" name="youtubeAccount" id="youtubeAccount" class="lInput" /></td>
											<td><input type="checkbox" name="youtubeAccountchk" id="youtubeAccountchk"></td>
										</tr>
										<tr>
											<td><label id="jform_linkedin_username-lbl" class="hasTip" title="">Linkedin Profile</label></td>
											<td><input type="text" value="${socialDTO.linkedinProfile}" name="linkedinProfile" id="linkedinProfile" class="lInput" /></td>
											<td><input type="checkbox" name="linkedinProfilechk" id="linkedinProfilechk"></td>
										</tr>
										<tr>
											<td><label id="jform_trip_advisor_username-lbl" class="hasTip" title="">Trip Advisor Account</label></td>
											<td><input type="text" value="${socialDTO.tripAdvisorAccount}" name="tripAdvisorAccount" id="tripAdvisorAccount" class="lInput" /></td>
											<td><input type="checkbox" name="tripAdvisorAccountchk" id="tripAdvisorAccountchk"></td>
										</tr>
										<tr>
											<td><label id="jform_meetup_username-lbl" class="hasTip" title="">Meetup Account</label></td>
											<td><input type="text" value="${socialDTO.meetupAccount}" name="meetupAccount" id="meetupAccount" class="lInput" /></td>
											<td><input type="checkbox" name="meetupAccountchk" id="meetupAccountchk"></td>
										</tr>
										<tr>
											<td><label id="jform_open_table_username-lbl" class="hasTip" title="">Open Table Account</label></td>
											<td><input type="text" value="${socialDTO.openTableAccount}" name="openTableAccount" id="openTableAccount" class="lInput" /></td>
											<td><input type="checkbox" name="openTableAccountchk" id="openTableAccountchk"></td>
										</tr>
										<tr>
											<td>Pinterest Account</td>
											<td><input type="text" value="${socialDTO.pinterestAccount}" name="pinterestAccount" id="pinterestAccount" class="lInput" /></td>
											<td><input type="checkbox" name="pinterestAccountchk" id="pinterestAccountchk"></td>
										</tr>
										<tr>
											<td>Tumblr Account</td>
											<td><input type="text" value="${socialDTO.tumblrAccount}" name="tumblrAccount" id="tumblrAccount" class="lInput" /></td>
											<td><input type="checkbox" name="tumblrAccountchk" id="tumblrAccountchk"></td>
										</tr>
										<tr>
											<td>Instagram Account</td>
											<td><input type="text" value="${socialDTO.instagramAccount}" name="instagramAccount" id="instagramAccount" class="lInput" /></td>
											<td><input type="checkbox" name="instagramAccountchk" id="instagramAccountchk"></td>
										</tr>
										<tr>
											<td>Etsy Account</td>
											<td><input type="text" value="${socialDTO.etsyAccount}" name="etsyAccount" id="etsyAccount" class="lInput" /></td>
											<td><input type="checkbox" name="etsyAccountchk" id="etsyAccountchk"></td>
										</tr>
										<tr>
											<td>G+ Account</td>
											<td><input type="text" value="${socialDTO.gPlusAccount}" name="gPlusAccount" id="gPlusAccount" class="lInput" /></td>
											<td><input type="checkbox" name="gPlusAccountchk" id="gPlusAccountchk"> <span id="signinButton"> <span class="g-signin" data-callback="signinCallback" data-clientid="409160420325-ub8u1td20i4it7fi1mi2hcfvi77ao32p.apps.googleusercontent.com"
													data-cookiepolicy="single_host_origin" data-requestvisibleactions="http://schema.org/AddAction" data-scope="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email"> </span>
											</span></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td class="al-right button2"><input type="button" value="Reset" onclick="resetAll();">&nbsp;&nbsp;<input type="button" onclick="saveSocialConnection();" value="Update"></td>
										</tr>
									</tbody>
								</table>

								<div style="margin-bottom: 5%"></div>

								<table class="tableStyle custom_td" cellpadding="0" cellspacing="0" style="width: 100%; display: none;">
									<tbody>
										<tr>
											<th colspan="4">Twitter OAuth details for posting deals to twitter</th>
										</tr>
										<tr>
											<td>Consumer Key:<input type="text" style="display: none;" id="twitterOAuthdetailsId" value="${socialDTO.twitterOAuthdetailsId}" />
											</td>
											<td><input type="text" value="${socialDTO.consumerKey}" name="consumerKey" id="consumerKey" /></td>
											<td>Consumer Secret:</td>
											<td><input type="text" value="${socialDTO.consumerSecret}" name="consumerSecret" id="consumerSecret" /></td>
										</tr>
										<tr>
											<td>OAuth Token:</td>
											<td><input type="text" value="${socialDTO.oAuthToken}" name="oAuthToken" id="oAuthToken" /></td>
											<td>OAuth Secret:</td>
											<td><input type="text" value="${socialDTO.oAuthSecret}" name="oAuthSecret" id="oAuthSecret" /></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td align="right"><input type="button" value="Add Twitter Details" onclick="saveSocialConnection();"></input></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div style="margin-bottom: 5%"></div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
</body>
<script type="text/javascript">
$(function(){
	if ('<c:out value="${socialDTO.facebookFanPagechk}"/>' == "1")
		$("#facebookFanPagechk").attr('checked', true);

	if ('<c:out value="${socialDTO.twitterAccountchk}"/>' == "1")
		$("#twitterAccountchk").attr('checked', true);

	if ('<c:out value="${socialDTO.fourSquareAccountchk}"/>' == "1")
		$("#fourSquareAccountchk").attr('checked', true);

	if ('<c:out value="${socialDTO.yelpAccountchk}"/>' == "1")
		$("#yelpAccountchk").attr('checked', true);

	if ('<c:out value="${socialDTO.flickerAccountchk}"/>' == "1")
		$("#flickerAccountchk").attr('checked', true);

	if ('<c:out value="${socialDTO.youtubeAccountchk}"/>' == "1")
		$("#youtubeAccountchk").attr('checked', true);

	if ('<c:out value="${socialDTO.linkedinProfilechk}"/>' == "1")
		$("#linkedinProfilechk").attr('checked', true);

	if ('<c:out value="${socialDTO.tripAdvisorAccountchk}"/>' == "1")
		$("#tripAdvisorAccountchk").attr('checked', true);

	if ('<c:out value="${socialDTO.meetupAccountchk}"/>' == "1")
		$("#meetupAccountchk").attr('checked', true);

	if ('<c:out value="${socialDTO.openTableAccountchk}"/>' == "1")
		$("#openTableAccountchk").attr('checked', true);

	if ('<c:out value="${socialDTO.pinterestAccountchk}"/>' == "1")
		$("#pinterestAccountchk").attr('checked', true);
	
	if ('<c:out value="${socialDTO.gPlusAccountchk}"/>' == "1")
		$("#gPlusAccountchk").attr('checked', true);
	
	if ('<c:out value="${socialDTO.tumblrAccountchk}"/>' == "1")
		$("#tumblrAccountchk").attr('checked', true);
	
	if ('<c:out value="${socialDTO.etsyAccountchk}"/>' == "1")
		$("#etsyAccountchk").attr('checked', true);
	
	if ('<c:out value="${socialDTO.instagramAccountchk}"/>' == "1")
		$("#instagramAccountchk").attr('checked', true);
});

function saveSocialConnection() {
	if (validation()) {
		var retVal = $.ajax({
			url : "saveSocialConnection",
			type : "POST",
			global : false,
			data : {
				facebookFanPage : $("#facebookFanPage").val(),
				facebookFanPagechk : $("#facebookFanPagechk").is(':checked') == true ? "1" : "0",
				twitterAccount : $("#twitterAccount").val(),
				twitterAccountchk : $("#twitterAccountchk").is(':checked') == true ? "1" : "0",
				fourSquareAccount : $("#fourSquareAccount").val(),
				fourSquareAccountchk : $("#fourSquareAccountchk").is(':checked') == true ? "1" : "0",
				yelpAccount : $("#yelpAccount").val(),
				yelpAccountchk : $("#yelpAccountchk").is(':checked') == true ? "1" : "0",
				flickerAccount : $("#flickerAccount").val(),
				flickerAccountchk : $("#flickerAccountchk").is(':checked') == true ? "1" : "0",
				youtubeAccount : $("#youtubeAccount").val(),
				youtubeAccountchk : $("#youtubeAccountchk").is(':checked') == true ? "1" : "0",
				linkedinProfile : $("#linkedinProfile").val(),
				linkedinProfilechk : $("#linkedinProfilechk").is(':checked') == true ? "1" : "0",
				tripAdvisorAccount : $("#tripAdvisorAccount").val(),
				tripAdvisorAccountchk : $("#tripAdvisorAccountchk").is(':checked') == true ? "1" : "0",
				meetupAccount : $("#meetupAccount").val(),
				meetupAccountchk : $("#meetupAccountchk").is(':checked') == true ? "1" : "0",
				openTableAccount : $("#openTableAccount").val(),
				openTableAccountchk : $("#openTableAccountchk").is(':checked') == true ? "1" : "0",
				pinterestAccount : $("#pinterestAccount").val(),
				pinterestAccountchk : $("#pinterestAccountchk").is(':checked') == true ? "1" : "0",
				gPlusAccount : $("#gPlusAccount").val(),
				gPlusAccountchk : $("#gPlusAccountchk").is(':checked') == true ? "1" : "0",
				instagramAccount : $("#instagramAccount").val(),
				instagramAccountchk : $("#instagramAccountchk").is(':checked') == true ? "1" : "0",
				etsyAccount : $("#etsyAccount").val(),
				etsyAccountchk : $("#etsyAccountchk").is(':checked') == true ? "1" : "0",
				tumblrAccount : $("#tumblrAccount").val(),
				tumblrAccountchk : $("#tumblrAccountchk").is(':checked') == true ? "1" : "0",
				consumerKey : $("#consumerKey").val(),
				consumerSecret : $("#consumerSecret").val(),
				oAuthToken : $("#oAuthToken").val(),
				oAuthSecret : $("#oAuthSecret").val(),
				twitterOAuthdetailsId : $("#twitterOAuthdetailsId").val(),
				connectionId:${socialDTO.connectionId}+""
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			if (obj.jsonMessage != null) {
				$.alert.open('error', obj.jsonMessage);
			} else {
				$("#connectionId").val(obj.connectionId);
				$.alert.open('info', 'Social Connections saved successfully.');
			}
		} else {
			$.alert.open('error', 'Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
		}
	}
}

function validation() {
	if ($("#facebookFanPagechk").is(':checked') == true && trimString($("#facebookFanPage").val()) == "") {
		appFocus($("#facebookFanPage"));
		$.alert.open('error', 'Facebook Fan Page is Mandatory.');
		return false;
	}

	if ($("#twitterAccountchk").is(':checked') == true && trimString($("#twitterAccount").val()) == "") {
		appFocus($("#twitterAccount"));
		$.alert.open('error', 'Twitter Account is Mandatory.');
		return false;
	}

	if ($("#fourSquareAccountchk").is(':checked') == true && trimString($("#fourSquareAccount").val()) == "") {
		appFocus($("#fourSquareAccount"));
		$.alert.open('error', 'Four Square Account is Mandatory.');
		return false;
	}
	if ($("#yelpAccountchk").is(':checked') == true && trimString($("#yelpAccount").val()) == "") {
		appFocus($("#yelpAccount"));
		$.alert.open('error', 'Yelp Account is Mandatory.');
		return false;
	}

	if ($("#flickerAccountchk").is(':checked') == true && trimString($("#flickerAccount").val()) == "") {
		appFocus($("#flickerAccount"));
		$.alert.open('error', 'Flicker Account is Mandatory.');
		return false;
	}

	if ($("#youtubeAccountchk").is(':checked') == true && trimString($("#youtubeAccount").val()) == "") {
		appFocus($("#youtubeAccount"));
		$.alert.open('error', 'Youtube Account is Mandatory.');
		return false;
	}

	if ($("#linkedinProfilechk").is(':checked') == true && trimString($("#linkedinProfile").val()) == "") {
		appFocus($("#linkedinProfile"));
		$.alert.open('error', 'Linkedin Profile is Mandatory.');
		return false;
	}

	if ($("#tripAdvisorAccountchk").is(':checked') == true && trimString($("#tripAdvisorAccount").val()) == "") {
		appFocus($("#tripAdvisorAccount"));
		$.alert.open('error', 'Trip Advisor Account is Mandatory.');
		return false;
	}

	if ($("#meetupAccountchk").is(':checked') == true && trimString($("#meetupAccount").val()) == "") {
		appFocus($("#meetupAccount"));
		$.alert.open('error', 'Meetup Account is Mandatory.');
		return false;
	}

	if ($("#openTableAccountchk").is(':checked') == true && trimString($("#openTableAccount").val()) == "") {
		appFocus($("#openTableAccount"));
		$.alert.open('error', 'Open Table Account is Mandatory.');
		return false;
	}

	if ($("#pinterestAccountchk").is(':checked') == true && trimString($("#pinterestAccount").val()) == "") {
		appFocus($("#pinterestAccount"));
		$.alert.open('error', 'Pinterest Account is Mandatory.');
		return false;
	}
	return true;
}


function resetAll(){
	$('input[type=text]').val("");
	$('input[type=checkbox]').prop('checked', false);
}

function getOAuthUrl(){
	var retVal = $.ajax({
		url:"jsonTwitterOAuthUrl",
		type:"POST",
		global:false,
		data:{
			
		},
		dataType:"json",
		async:false
	}).responseText;
	
	if(retVal!=null){
		document.location.href=retVal+"";
	}
}
</script>
</html>