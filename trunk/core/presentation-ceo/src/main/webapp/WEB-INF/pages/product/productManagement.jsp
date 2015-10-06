<%@include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Timeline</title>
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!--link rel="shortcut icon" href="images/favicon.png"-->
<link rel="stylesheet" href="<c:url value="../static/css/style.css" />" />
<link rel="stylesheet" href="<c:url value="../static/css/responsive.css" />" />
<link rel="stylesheet" href="<c:url value="../static/css/table-sorter.css" />" />

<script type="text/javascript" src='<c:url value="../static/js/jquery.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/bootstrap.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/script.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/tablesorter.js" />'></script>
</head>
<body>
	<!--Logo and Menu-->
	<header>
		<jsp:include page="../common/headerWithSession.jsp"></jsp:include>
	</header>
	<section id="main-section">
		<div class="container">
			<div class="row">
				<div class="col-md-2 col-sm-12 col-xs-12">
					<div class="left-section">
						<div class="panel panel-default mar-top-10">
							<div class="panel-heading">
								Product Management
								<!--  <a href="#" class="add">Add</a> -->
							</div>
							<div class="panel-body">
								<ul class="list-block">
									<li><a href="#" class="list-block" data-toggle="modal"
										data-target="#createProductModal">Create Product</a></li>
								</ul>
								<ul class="list-block">
									<li><a href="#">Product List</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-7 col-sm-12 col-xs-12">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<table id="tablesorter-demo" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
								<thead>
									<tr>
										<th class="header">First Name</th>
										<th class="header headerSortUp">Last Name</th>
										<th class="header">Age</th>
										<th class="header">Total</th>
										<th class="header">Discount</th>
										<th class="header">Difference</th>
										<th class="header">Date</th>
									</tr>
								</thead>
								<tbody>
									<tr class="odd">
										<td>Peter</td>
										<td>Parker</td>
										<td>28</td>
										<td>$9.99</td>
										<td>20.9%</td>
										<td>+12.1</td>
										<td>Jul 6, 2006 8:14 AM</td>
									</tr>
									<tr class="even">
										<td>Clark</td>
										<td>Kent</td>
										<td>18</td>
										<td>$15.89</td>
										<td>44%</td>
										<td>-26</td>
										<td>Jan 12, 2003 11:14 AM</td>
									</tr>
									<tr class="odd">
										<td>John</td>
										<td>Hood</td>
										<td>33</td>
										<td>$19.99</td>
										<td>25%</td>
										<td>+12</td>
										<td>Dec 10, 2002 5:14 AM</td>
									</tr>
									<tr class="even">
										<td>Bruce</td>
										<td>Evans</td>
										<td>22</td>
										<td>$13.19</td>
										<td>11%</td>
										<td>-100.9</td>
										<td>Jan 18, 2007 9:12 AM</td>
									</tr>
									<tr class="odd">
										<td>Bruce</td>
										<td>Evans</td>
										<td>22</td>
										<td>$13.19</td>
										<td>11%</td>
										<td>0</td>
										<td>Jan 18, 2007 9:12 AM</td>
									</tr>
									<tr class="even">
										<td>Bruce</td>
										<td>Almighty</td>
										<td>45</td>
										<td>$153.19</td>
										<td>44.7%</td>
										<td>+77</td>
										<td>Jan 18, 2001 9:12 AM</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="col-md-3 col-sm-3 col-xs-12 text-left xs">
								<ul class="pagination">
									<li><a href="#">First</a></li>
									<li><a href="#">Prev</a></li>
								</ul>
							</div>
							<div class="col-md-4 col-sm-4 col-xs-12 text-center xs">
								<ul class="pagination">
									<li><a href="#">1</a></li>
									<li class="active"><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
								</ul>
							</div>
							<div class="col-md-2 col-sm-2 col-xs-12 text-center xs">
								<span>Count</span> <select class="mar-bot-10 mar-top-10 width-auto">
									<option>10</option>
									<option>20</option>
									<option>30</option>
									<option>40</option>
									<option>50</option>
									<option>60</option>
									<option>70</option>
									<option>80</option>
									<option>90</option>
									<option>100</option>
								</select>
							</div>
							<div class="col-md-3 col-sm-3 col-xs-12 text-right xs">
								<ul class="pagination">
									<li><a href="#">Next</a></li>
									<li><a href="#">Last</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<jsp:include page="../common/menuWithSessionRight.jsp"></jsp:include>
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
		<p>Copyright &copy; Company name, 2012. All Rights Reserved</p>
	</footer>
	<!-- Product Create Modal -->
	<form action="saveProduct" method="post" id="createProductForm" name="createProductForm">
		<div id="createProductModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Create Product</h4>
					</div>
					<div class="modal-body" style="background: #EFECE0;">
						<div class="dialog-form">
							<ul>
								<li><label>Category</label> <input type="email" id="loginUserName"
									placeholder="Enter Your Email" /></li>
								<li><label> Sub-Category</label> <input type="password" id="loginPassword"
									placeholder="Enter Your Password" /></li>
							</ul>
							<ul>
								<li><label>Name</label> <input type="email" id="loginUserName"
									placeholder="Enter Your Email" /></li>
								<li><label>Price</label> <input type="password" id="loginPassword"
									placeholder="Enter Your Password" /></li>
							</ul>
							<ul>
								<li><label>Image</label> <input type="file" /></li>
							</ul>
							<ul>
								<li><input type="submit" value="Save" /></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(function() {
		$("#tablesorter-demo").tablesorter({
			sortList : [ [ 0, 0 ], [ 2, 1 ] ],
			widgets : [ 'zebra', 'filter' ]
		});

		$("#options").tablesorter({
			sortList : [ [ 0, 0 ] ],
			headers : {
				3 : {
					sorter : false
				},
				4 : {
					sorter : false
				}
			}
		});
	});
</script>
</html>