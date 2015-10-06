<%@include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Second Activation Action</title>
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport" />
<!--link rel="shortcut icon" href="images/favicon.png"-->
<link rel="stylesheet" href="<c:url value="../static/css/style.css" />"></link>
<link rel="stylesheet" href="<c:url value="../static/css/responsive.css" />" />

<!-- Main Scripts -->
<script type="text/javascript" src='<c:url value="../static/js/jquery.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/bootstrap.js" />'></script>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<!-- End Scripts -->
</head>
<body>

	<!--Logo and Menu-->
	<header class="no-pad">
		<div class="sub_header_wrapper dark-bg">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="logo">
							<a href="#">CEO</a>
						</div>
					</div>
					<div class="col-md-6">
						<div class="search">
							<input type="text" placeholder="Lets Start Saving..." /> <input type="submit" value="Search" />
						</div>
					</div>
					<div class="col-md-3">
						<nav class="top-navigation cart-nav">
							<ul class="text-right">
								<li><a href="#" class="color-white"><span class="cart">0</span><i
										class="fa fa-cart-plus fa-3x"></i></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<div class="navigation">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<a href="#" id="trigger"><span class="fa fa-navicon fa-2x"></span></a>
							<nav class="main-navigation">
								<ul>
									<li><a href="#"><span class="fa fa-home"></span> HOME</a></li>
									<li><a href="#"><span class="fa fa-info-circle"></span> ABOUT</a></li>
									<li><a href="#"><span class="fa fa-image"></span> GALLERY</a></li>
									<li><a href="#"><span class="fa fa-user"></span> FRIENDS</a></li>
									<li><a href="#"><span class="fa fa-newspaper-o"></span> TIMELINE</a></li>
									<li><a href="#"><span class="fa fa-rss"></span> BLOG & FORUMS</a></li>
									<li><a href="#"><span class="fa fa-tasks"></span> TASKS</a></li>
									<li><a href="#"><span class="fa fa-group"></span> GROUP</a></li>
									<li><a href="#"><span class="fa fa-file-text-o"></span> PAGES</a></li>
								</ul>
							</nav>
							<div class="mobile-nav">
								<div class="dropdown">
									<button class="btn dropdown-toggle" type="button" data-toggle="dropdown">
										Menu <span class="fa fa-navicon"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#"><span class="fa fa-home"></span> HOME</a></li>
										<li><a href="#"><span class="fa fa-info-circle"></span> ABOUT</a></li>
										<li><a href="#"><span class="fa fa-image"></span> GALLERY</a></li>
										<li><a href="#"><span class="fa fa-user"></span> FRIENDS</a></li>
										<li><a href="#"><span class="fa fa-newspaper-o"></span> TIMELINE</a></li>
										<li><a href="#"><span class="fa fa-rss"></span> BLOG & FORUMS</a></li>
										<li><a href="#"><span class="fa fa-tasks"></span> TASKS</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="top-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="status-bar center">
						<h1 class="regular color-white">Market Opportunities</h1>
						<ul>
							<li><a href="#"><span>1</span></a></li>
							<li><a href="#"><span>2</span></a></li>
							<li><a href="#" class="active"><span>3</span></a></li>
							<li><a href="#"><span>4</span></a></li>
							<li><a href="#"><span>5</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<section id="main-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<h1 class="color-black text-center">The 30 Day Market Watch, Report</h1>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="market-report-tbl">
						<table border="0" cellpadding="0" cellspacing="0" class="table table-condensed">
							<thead>
								<tr>
									<th colspan="5" class="bg-primary">Build your 24/7 consumer business market watch</th>
									<th colspan="5" class="bg-success">Your estimated profit next 30 days</th>
									<th colspan="3" class="bg-danger">According to your selections</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="Show how many are joining">Preselected</span></td>
									<td class="bg-info"><span data-toggle="tooltip" data-placement="top"
										title="Show how many expecting profit">Pending</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="View product categories">Categories</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="Market activity past 24 hours">24 hrs</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="Market activity past 30 hours">30 days</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="Paid and quilified to earn">QM's</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="Rising market volume">Potential</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="Watching incomestreams">Watching</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top" title="">Growth</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="Selection lacking funding">Losing</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="What you have earned">Profit</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top"
										title="Potentials earnings">Potentials</span></td>
									<td class="bg-warning"><span data-toggle="tooltip" data-placement="top" title="">Day
											to cash out</span></td>
								</tr>
								<tr>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
								</tr>
								<tr>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
								</tr>
								<tr>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
								</tr>
								<tr>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
									<td class="bg-white"><span>68468</span></td>
								</tr>
								<tr>
									<td class="bg-white"><span></span></td>
									<td class="bg-white"><span></span></td>
									<td class="bg-white"><span></span></td>
									<td class="bg-white"><span></span></td>
									<td class="bg-white"><span></span></td>
									<td class="bg-white"><span></span></td>
									<td class="bg-white"><span></span></td>
									<td class="bg-warning text-left" colspan="2"><span><strong>Earnings</strong></span></td>
									<td class="bg-danger"><span data-toggle="tooltip" data-placement="top"
										title="How much money is passing your account"><strong>&euro; 2,317</strong></span></td>
									<td class="bg-warning"><span><strong>&euro; 2,317</strong></span></td>
									<td class="bg-warning"><span><strong>&euro; 2,317</strong></span></td>
									<td class="bg-warning"><span></span></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<p>&nbsp;</p>
					<p class="text-center">
						<a class="btn-blue btn-default btn-lg font-15" href="#" onclick="document.location.href='registerStepFour'">Build Your First Free Market
							Report</a>
					</p>
					<p>&nbsp;</p>
				</div>
			</div>
		</div>
	</section>
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
		<ul>
			<li><a href="#" class="color-white">Site Terms</a></li>
			<li><a href="#" class="color-white">Terms and Conditions of Sale</a></li>
			<li><a href="#" class="color-white">Privacy Policy</a></li>
			<li><a href="#" class="color-white">About Us</a></li>
			<li><a href="#" class="color-white">Contact Us</a></li>
		</ul>
		<p>Copyright © Company name, 2012. All Rights Reserved</p>
	</footer>
</body>
</html>