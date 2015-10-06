<%@include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Ceo Stocks</title>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport" />
<!--link rel="shortcut icon" href="images/favicon.png"-->
<link rel="stylesheet" href="<c:url value="static/css/style.css" />"></link>
<link rel="stylesheet" href="<c:url value="static/css/jquery.bxslider.css" />"></link>
<link rel="stylesheet" href="<c:url value="static/css/responsive.css" />"></link>
</head>
<body>

	<!--Header-->
	<header>
		<jsp:include page="../common/headerWithoutSession.jsp"></jsp:include>
	</header>
	<!--Header Ends-->

	<!--Content-->
	<section id="main-section">
		<div class="container">
			<div class="row">
				<div class="col-md-7">
					<jsp:include page="../gadgets/slider.jsp"></jsp:include>
				</div>
				<div class="col-md-5">
					<div class="register-form">
						<h1>
							Register<br /> <small>It is free and always be.</small>
						</h1>
						<div class="row">
							<div class="col-md-6">
								<input type="text" id="firstName" placeholder="First Name" />
							</div>
							<div class="col-md-6">
								<input type="text" id="lastName" placeholder="Last Name" />
							</div>
							<div class="col-md-12">
								<input type="email" id="emailAddress" placeholder="Your Email" />
							</div>
							<div class="col-md-12">
								<input type="email" id="reemailAddress" placeholder="Type Your Email Again" />
							</div>
							<div class="col-md-12">
								<input type="password" id="newPassword" placeholder="New Password" />
							</div>
							<div class="clearfix"></div>
							<div class="col-md-12">
								<h3>Birthday</h3>
								<div class="col-md-4 no-pad">
									<select id="dateOfBirthMonth">
										<option value="-1">Month</option>
										<option value="1">Jan</option>
										<option value="2">Feb</option>
										<option value="3">Mar</option>
										<option value="4">Apr</option>
										<option value="5">May</option>
										<option value="6">Jun</option>
										<option value="7">Jul</option>
										<option value="8">Aug</option>
										<option value="9">Sep</option>
										<option value="10">Oct</option>
										<option value="11">Nov</option>
										<option value="12">Dec</option>
									</select>
								</div>
								<div class="col-md-4 no-pad">
									<select id="dateOfBirthDay">
										<option value="-1">Day</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
									</select>
								</div>
								<div class="col-md-4 no-pad">
									<select id="dateOfBirthYear">
										<option value="-1">Year</option>
										<option value="2000">2000</option>
										<option value="2001">2001</option>
										<option value="2002">2002</option>
										<option value="2003">2003</option>
										<option value="2004">2004</option>
										<option value="2005">2005</option>
										<option value="2006">2006</option>
										<option value="2007">2007</option>
										<option value="2008">2008</option>
										<option value="2009">2009</option>
										<option value="2010">2010</option>
										<option value="2011">2011</option>
										<option value="2012">2012</option>
										<option value="2013">2013</option>
										<option value="2014">2014</option>
										<option value="2015">2015</option>
									</select>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="col-md-3">
								<input type="radio" name="gender" id="male" value="1" /> <label for="male">Male</label>
							</div>
							<div class="col-md-3">
								<input type="radio" name="gender" id="female" value="2" /> <label for="female">Female</label>
							</div>
							<div class="clearfix"></div>
							<div class="col-md-12">
								<select id="country">
									<option value="-1">Select Country</option>
									<option value="1">Australia</option>
									<option value="2">India</option>
									<option value="3">United Arab Emirates</option>
									<option value="4">United Kingdom</option>
									<option value="5">United States</option>
								</select>
							</div>
							<div class="clearfix"></div>
							<div class="col-md-12">
								<input type="button" value="Sign me up!" class="btn-blue" onclick="doRegister();" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-7">
					<div class="status-bar">
						<ul>
							<li><a href="#" class="active"><span>1</span></a>
								<p>
									<strong>Create an account</strong>
								</p></li>
							<li><a href="#"><span>2</span></a>
								<p>Select income potential</p></li>
							<li><a href="#"><span>3</span></a>
								<p>Market opportunities</p></li>
							<li><a href="#"><span>4</span></a>
								<p>View profit estimations</p></li>
							<li><a href="#"><span>5</span></a>
								<p>Professional networking</li>
						</ul>
					</div>
				</div>
				<div class="col-md-5">
					<div class="advertise">
						<h2 class="text-center color-grey">
							<em>ADVERTISE HERE</em>
						</h2>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="col-md-4">
					<div class="page-content panel panel-default">
						<h2 class="panel-heading">MARKET</h2>
						<div class="panel-body">
							<p>A CEO Stocks user will have quick access to many good investment options and online
								credit convertable to given or known currency like € $ ¥, DKr, Nkr, Sek etc. Pro CEO Stocks
								user will have access to a full version of an online forecast reporting system for viewing
								investment potentials, various profit options, market trends and full access to the market
								sharing fund and faster dynamic business report.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="page-content panel panel-default">
						<h2 class="panel-heading">GRAB OPPORTUNITIES</h2>
						<div class="panel-body">
							<p>A CEO Stocks user will have quick access to many good investment options and online
								credit convertable to given or known currency like € $ ¥, DKr, Nkr, Sek etc. Pro CEO Stocks
								user will have access to a full version of an online forecast reporting system for viewing
								investment potentials, various profit options, market trends and full access to the market
								sharing fund and faster dynamic business report.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="page-content panel panel-default">
						<h2 class="panel-heading">SERVICES</h2>
						<div class="panel-body">
							<p>A CEO Stocks user will have quick access to many good investment options and online
								credit convertable to given or known currency like € $ ¥, DKr, Nkr, Sek etc. Pro CEO Stocks
								user will have access to a full version of an online forecast reporting system for viewing
								investment potentials, various profit options, market trends and full access to the market
								sharing fund and faster dynamic business report.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--Content Ends-->

	<!--Footer-->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<h3>Starting Your Online Business</h3>
					<ul>
						<li><a href="#" class="color-white">CEO Stock Option Plans</a></li>
						<li><a href="#" class="color-white">My Binary Renewal</a></li>
						<li><a href="#" class="color-white">User Type</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h3>Shopping And Selling</h3>
					<ul>
						<li><a href="#" class="color-white">Company Registration</a></li>
						<li><a href="#" class="color-white">Applying for an account</a></li>
						<li><a href="#" class="color-white">Transfer Funding</a></li>
						<li><a href="#" class="color-white">Marketing tools</a></li>
						<li><a href="#" class="color-white">Private Registration</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h3>Website Services</h3>
					<ul>
						<li><a href="#" class="color-white">SSL Certificates</a></li>
						<li><a href="#" class="color-white">Custom Web Design</a></li>
						<li><a href="#" class="color-white">Email Marketing</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h3>I Want To ...</h3>
					<ul>
						<li><a href="#" class="color-white">Apply for a sharing fund</a></li>
						<li><a href="#" class="color-white">Promote my company</a></li>
						<li><a href="#" class="color-white">Start a Blog</a></li>
						<li><a href="#" class="color-white">Connect the online credit to my web</a></li>
						<li><a href="#" class="color-white">Log Into My Account</a></li>
						<li><a href="#" class="color-white">Get Help</a></li>
						<li><a href="#" class="color-white">Promte this site for rewards</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<footer class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul>
						<li><a href="#" class="color-white">Site Terms</a></li>
						<li><a href="#" class="color-white">Terms & Conditions of Sale</a></li>
						<li><a href="#" class="color-white">Privacy Policy</a></li>
						<li><a href="#" class="color-white">About Us</a></li>
						<li><a href="#" class="color-white">Contact Us</a></li>
					</ul>
					<p>
						Copyright &copy; <a href="#" class="color-white">Company name</a>, 2012. All Rights Reserved
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!--Footer Ends-->

	<!-- Main Scripts -->
	<script type="text/javascript" src='<c:url value="static/js/jquery.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="static/js/bootstrap.js" />'></script>
	<script type="text/javascript" src='<c:url value="static/js/jquery.bxslider.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="static/js/script.js" />'></script>

	<script type="text/javascript" src='<c:url value="static/js/bootstrap-notify.js" />'></script>
	<script type="text/javascript" src='<c:url value="static/js/bootstrap-notify.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="static/js/common.js" />'></script>
	<!-- End Scripts -->
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('.bxslider').bxSlider({
			auto : 'true',
			pagerCustom : '#bx-pager'
		});
	});

	$("#loginPassword").on('keydown', function(e) {
		if (e) {
			var keyCode = (e.keyCode)? e.keyCode: ((e.charCode)? e.charCode: e.which);
			
			if (keyCode === 13) {
				doLogin();
			}
		}
	});

	function doLogin() {
		if (trimString($("#loginUserName").val()) == "") {
			validate("Ooops!", "e-mail cann't be empty.", 'danger');
			return false;
		}
		if (trimString($("#loginPassword").val()) == "") {
			validate("Ooops!", "Password cann't be empty.", 'danger');
			return false;
		}

		var retVal = $.ajax({
			url : "doLogin",
			global : false,
			type : "POST",
			data : {
				userId : $("#loginUserName").val(),
				password : $("#loginPassword").val()
			},
			async : false,
			datatype : "json"
		}).responseText;

		if (retVal != "") {
			validate("Ooops!", retVal, 'danger');
		} else {
			document.location.href = 'component/home';
		}
	}

	function doRegister() {
		if (registerValidate()) {
			var notify = $.notify('<strong>Saving</strong> Do not close this page...', {
				type : 'success',
				allow_dismiss : false,
				showProgressbar : true
			});

			setTimeout(function() {
				notify.update('message', '<strong>Saving</strong> Page Data.');
			}, 1000);

			setTimeout(function() {
				notify.update('message', '<strong>Saving</strong> User Data.');
			}, 2000);

			setTimeout(function() {
				notify.update('message', '<strong>Saving</strong> Profile Data.');
			}, 3000);

			setTimeout(function() {
				notify.update('message', '<strong>Checking</strong> for errors.');
			}, 4000);

			setTimeout(function() {
				var retVal = $.ajax({
					url : "doRegister",
					global : false,
					type : "POST",
					data : {
						firstName : $("#firstName").val(),
						lastName : $("#lastName").val(),
						emailAddress : $("#emailAddress").val(),
						newPassword : $("#newPassword").val(),
						gender : $('input[name=gender]:checked').val(),
						dateOfBirth : $('#dateOfBirthMonth').val() + "/" + $('#dateOfBirthDay').val() + "/" + $('#dateOfBirthYear').val(),
						country : $('#country').val()
					},
					async : false,
					datatype : "json"
				}).responseText;

				if (retVal != "") {
					validate("Ooops!", retVal, 'danger');
				} else {
					$.notify({
						title : 'Activation: Pending',
						message : 'Activation e-mail send to <strong>' + $("#emailAddress").val() + '</strong>'
					}, {
						type : 'pastel-warning',
						delay : 5000,
						template : '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">'
								+ '<span data-notify="title">{1}</span>' + '<span data-notify="message">{2}</span>' + '</div>'
					});
					resetAll();
				}
			}, 5300);
		}
	}

	function registerValidate() {

		if (trimString($("#firstName").val()) == "") {
			validate("Ooops!", "First Name cann't be empty.", 'danger');
			return false;
		}
		if (trimString($("#firstName").val()) != "") {
			if (!trimString($("#firstName").val()).match(/^[a-zA-Z]+$/)) {
				validate("Ooops!", "First Name is invalid.", 'danger');
				return false;
			}
		}
		if (trimString($("#lastName").val()) == "") {
			validate("Ooops!", "Last Name cann't be empty.", 'danger');
			return false;
		}
		if (trimString($("#lastName").val()) != "") {
			if (!trimString($("#lastName").val()).match(/^[a-zA-Z]+$/)) {
				validate("Ooops!", "Last Name is invalid.", 'danger');
				return false;
			}
		}
		if (trimString($("#emailAddress").val()) == "") {
			validate("Ooops!", "e-mail cann't be empty", 'danger');
			return false;
		}
		if (trimString($("#emailAddress").val()) != "") {
			var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if (!regex.test(trimString($("#emailAddress").val()))) {
				validate("Ooops!", "e-mail is invalid.", 'danger');
				return false;
			}
		}
		if (trimString($("#reemailAddress").val()) == "") {
			validate("Ooops!", "e-mail cann't be empty", 'danger');
			return false;
		}
		if (trimString($("#reemailAddress").val()) != trimString($("#emailAddress").val())) {
			validate("Ooops!", "e-mail and confirm e-mail doesn't match.", 'danger');
			return false;
		}
		if (trimString($("#newPassword").val()) == "") {
			validate("Ooops!", "Password cann't be empty", 'danger');
			return false;
		}
		if ($('input[name=gender]:checked').length <= 0) {
			validate("Ooops!", "Gender cann't be empty", 'danger');
			return false;
		}
		if ($('#dateOfBirthMonth').val() == "-1" || $('#dateOfBirthDay').val() == "-1" || $('#dateOfBirthYear').val() == "-1") {
			validate("Ooops!", "Date Of Birth cann't be empty", 'danger');
			return false;
		}
		if ($('#country').val() == "-1") {
			validate("Ooops!", "Country cann't be empty", 'danger');
			return false;
		}
		return true;
	}

	function resetAll() {
		$("#firstName").val("");
		$("#lastName").val("");
		$("#emailAddress").val("");
		$("#reemailAddress").val("");
		$("#newPassword").val("");
		$("#dateOfBirthMonth").val("-1");
		$("#dateOfBirthDay").val("-1");
		$("#dateOfBirthYear").val("-1");
		$("#country").val("-1");
	}
</script>
</html>