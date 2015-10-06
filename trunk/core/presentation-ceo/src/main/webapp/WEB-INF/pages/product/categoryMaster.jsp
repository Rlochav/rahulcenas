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
						<div class="panel panel-default">
							<div class="panel-heading">
								Category Management
								<!--  <a href="#" class="add">Add</a> -->
							</div>
							<div class="panel-body">
								<ul class="list-block">
									<li><a href="#" class="list-block" data-toggle="modal" data-target="#categoryModal">Create
											Category</a></li>
								</ul>
								<ul class="list-block">
									<li><a href="openCategoryMaster" class="list-block">Category List</a></li>
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
										<th class="header">Category Code</th>
										<th class="header headerSortUp">Category Name</th>
									</tr>
								</thead>
								<tbody>
									<!--  Data will load via ajax call :)-->
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="col-md-3 col-sm-3 col-xs-12 text-left xs">
								<ul class="pagination">
									<li><a style="cursor: pointer;" onclick="first();">First</a></li>
									<li><a style="cursor: pointer;" onclick="prev();">Prev</a></li>
								</ul>
							</div>
							<div class="col-md-4 col-sm-4 col-xs-12 text-center xs">
								<!-- <ul class="pagination">
									<li><a href="#">1</a></li>
									<li class="active"><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
								</ul> -->
							</div>
							<div class="col-md-2 col-sm-2 col-xs-12 text-center xs">
								<!-- <span>Count</span> <select class="mar-bot-10 mar-top-10 width-auto">
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
								</select> -->
							</div>
							<div class="col-md-3 col-sm-3 col-xs-12 text-right xs">
								<ul class="pagination">
									<li><a style="cursor: pointer;" onclick="next();">Next</a></li>
									<li><a style="cursor: pointer;" onclick="last();">Last</a></li>
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
	<!-- Category Create Modal -->
	<form action="#" method="post" id="createProductForm" name="createProductForm">
		<div id="categoryModal" class="modal fade" role="dialog">
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
								<li><label>Category Code</label> <input type="text" id="categoryCode"
									placeholder="Enter Your Email" /></li>
								<li><label> Category Name</label> <input type="text" id="categoryName"
									placeholder="Enter Your Password" /></li>
							</ul>
							<ul>
								<li><input type="button" value="Save" onclick="saveProduct();" /></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	var currentStart = 0;
	var count = 10;
	var totalRecords = 0;
	$(function() {
		$("#tablesorter-demo").tablesorter({
			//sortList : [ [ 0, 0 ] ],
			widgets : [ 'zebra' ]
		});

		first();
	});

	function first() {
		loadCategoryTable(0, count);
	}

	function next() {
		if (currentStart > 0 && currentStart < totalRecords) {
			loadCategoryTable(currentStart, count);
		}
	}

	function last() {
		if ((totalRecords % count) != 0) {
			loadCategoryTable((totalRecords - (totalRecords % count)), count);
		} else {
			loadCategoryTable((totalRecords - count), count);
		}
	}

	function prev() {
		if (currentStart > 0) {
			loadCategoryTable((currentStart - (count + count)), count);
		}
	}

	function loadCategoryTable(start, count) {
		$("tbody").empty();
		if (start == 0) {
			currentStart = count;
		} else if (start < 0) {
			start = 0;
			currentStart = count;
		} else {
			currentStart = start + count;
		}

		var retVal = $.ajax({
			url : "searchCategory",
			type : "post",
			global : false,
			data : {
				start : start,
				count : count
			},
			dataType : "json",
			async : false
		}).responseText;

		if (retVal != null && retVal != '') {
			retVal = jQuery.parseJSON(retVal);
			var arr = retVal.categoryDTOs;
			totalRecords = retVal.total;
			var row = 1;
			var html = '';
			for (var i = 0; i < arr.length; i++) {
				if (row % 2 == 0) {
					html += '<tr class="even"><td>' + arr[i].categoryCode + '</td><td>' + arr[i].categoryName + '</td></tr>';
				} else {
					html += '<tr class="odd"><td>' + arr[i].categoryCode + '</td><td>' + arr[i].categoryName + '</td></tr>';
				}
				row++;
			}

			$("tbody").append(html);
		}
	}

	function saveProduct() {
		var cCode = $("#categoryCode").val();
		var cName = $("#categoryName").val();

		var retVal = $.ajax({
			url : "saveCategory",
			type : "post",
			global : false,
			data : {
				categoryCode : cCode,
				categoryName : cName
			},
			dataType : "json",
			async : false
		}).responseText;

		loadCategoryTable(0, count);
		document.createProductForm.reset();
	}
</script>
</html>