<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script>
<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="resources/images/icon.png">
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/main.js'/>"></script>
</head>
<body>
	<%@include file="../common/telliumTags.jsp"%>
	<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
		<h3 class="msg">
			<em>The Latest Deals</em>
		</h3>
		<c:forEach var="listVar" items="${dealzs}">
			<div class="shadow">
				<div class="deals_left">
					<img src="displayImage?image=${listVar.imagePath}" />
				</div>
				<div class="deals_right">
					<div class="border">
						<strong><c:out value="${listVar.title}" /></strong>
					</div>
					<div class="border">
						<span><c:out value="${listVar.restriction}" /></span>
					</div>
					<div class="border">
						<div class="deal-start">
							<b>Deal Start :</b>
							<c:out value="${listVar.startDate}" />
						</div>
						<div class="deal-start">
							<b>Deal End :</b>
							<c:out value="${listVar.endDate}" />
						</div>
						<div class="clr"></div>
					</div>
					<div class="border2">
						<b>Description :</b>
						<c:out value="${listVar.description}" />
					</div>
					<div class="border">
						<div class="share-deal share">
							<p>Share Deal on Facebook</p>
							<a style="cursor: pointer;" onclick="shareOnFB('link','<c:out value="${listVar.imagePath}" />','<c:out value="${listVar.title}" />','<c:out value="${listVar.description}" />','redirect');"><img src="<c:url value='resources/images/facebook-share-this-deal-ic1.png'/>" /></a>
						</div>
						<div class="share-deal rate">
							<p>Rate this deal</p>
							Rating: (<label id="currentRating${listVar.dealId}"></label>/5)
							<div class="rating">
								<div class="cancel">
									<a style="cursor: pointer;" title="Cancel Rating">Cancel Rating</a>
								</div>
								<div class="star" id="ratingStart1<c:out value="${listVar.dealId}"/>">
									<a style="cursor: pointer;" title="Give it 1/1" style="width: 100%;" onclick="rateDealz(1,${listVar.dealId});">1</a>
								</div>
								<div class="star" id="ratingStart2<c:out value="${listVar.dealId}"/>">
									<a style="cursor: pointer;" title="Give it 2/2" style="width: 100%;" onclick="rateDealz(2,${listVar.dealId});">2</a>
								</div>
								<div class="star" id="ratingStart3<c:out value="${listVar.dealId}"/>">
									<a style="cursor: pointer;" title="Give it 3/3" style="width: 100%;" onclick="rateDealz(3,${listVar.dealId});">3</a>
								</div>
								<div class="star" id="ratingStart4<c:out value="${listVar.dealId}"/>">
									<a style="cursor: pointer;" title="Give it 4/4" style="width: 100%;" onclick="rateDealz(4,${listVar.dealId});">4</a>
								</div>
								<div class="star" id="ratingStart5<c:out value="${listVar.dealId}"/>">
									<a style="cursor: pointer;" title="Give it 5/5" style="width: 100%;" onclick="rateDealz(5,${listVar.dealId});">5</a>
								</div>
							</div>
							<script type="text/javascript">
							$(function(){
								rate(${listVar.currentRating},${listVar.dealId});
							})
							</script>
						</div>
						<div class="share-deal subscribe">
							<p>Subscribe to Merchant</p>
							<img src="<c:url value='resources/images/email-16x16.png'/>" />&nbsp;<img src="<c:url value='resources/images/twitter-16x16.png'/>" />&nbsp;<img src="<c:url value='resources/images/facebook-16x16.png'/>" />
						</div>
						<div class="clr"></div>
						<label class="error" id="error${listVar.dealId}"></label>
					</div>
				</div>
				<div class="clr"></div>
			</div>
		</c:forEach>
	</form:form>
</body>
<script type="text/javascript">
	function openDelazPost() {
		window.parent.openPage('postDealz');
	}

	function shareOnFB(link, picture, name, desc, redirect) {
		window.open('https://www.facebook.com/dialog/feed?app_id=174025642805043&' + 'link=http://162.209.102.165:8080/AppWeb/'
				+ '&picture=http://162.209.102.165:8080/AppWeb/displayImage?image=' + picture + '&name=' + name + '&description=' + desc
				+ '&redirect_uri=http://162.209.102.165:8080/AppWeb/');
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
				//alert(obj.currentRating);
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
</script>
</html>