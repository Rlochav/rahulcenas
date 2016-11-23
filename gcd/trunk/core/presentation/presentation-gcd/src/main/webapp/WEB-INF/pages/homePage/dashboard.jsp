<%@include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ng-app="Dashboard" class="ng-scope">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@charset "UTF-8"; 

[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not
	(.ng-animate ){
	display: none !important;
}

ng\:form {
	display: block;
}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/Dashboard_files/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/Dashboard_files/font-awesome.min.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/Dashboard_files/dashboard.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/Dashboard_files/blue.css'/>" />

<script type="text/javascript" src="<c:url value='/resources/Dashboard_files/angular.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/Dashboard_files/angular-cookies.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/Dashboard_files/ng-bootstrap-tpls.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/Dashboard_files/bootstrap.js'/>"></script>

</head>
<body ng-controller="MasterCtrl" class="ng-scope">
	<div id="page-wrapper" ng-class="{&#39;active&#39;: toggle}" class="active">

		<!-- Sidebar -->

		<div id="sidebar-wrapper">
			<ul class="sidebar">
				<li class="sidebar-main"><a href="./Dashboard_files/Dashboard.html" ng-click="toggleSidebar()"> Dashboard <span class="menu-icon glyphicon glyphicon-transfer"></span>
				</a></li>
				<li class="sidebar-title"><span>NAVIGATION</span></li>
				<li class="sidebar-list"><a href="./Dashboard_files/Dashboard.html">Dashboard <span class="menu-icon fa fa-tachometer"></span></a></li>
				<li class="sidebar-list"><a href="./Dashboard_files/Dashboard.html">Servers <span class="menu-icon fa fa-tasks"></span></a></li>
				<li class="sidebar-list"><a href="./Dashboard_files/Dashboard.html">Settings <span class="menu-icon fa fa-cogs"></span></a></li>
				<li class="sidebar-title separator"><span>QUICK LINKS</span></li>
				<li class="sidebar-list"><a href="./Dashboard_files/Dashboard.html" target="_blank">Forums <span class="menu-icon fa fa-external-link"></span></a></li>
			</ul>
			<div class="sidebar-footer">
				<div class="col-xs-4">
					<a href="https://github.com/Ehesp/Responsive-Dashboard" target="_blank"> Github </a>
				</div>
				<div class="col-xs-4">
					<a href="./Dashboard_files/Dashboard.html" target="_blank"> About </a>
				</div>
				<div class="col-xs-4">
					<a href="./Dashboard_files/Dashboard.html"> Support </a>
				</div>
			</div>
		</div>

		<!-- End Sidebar -->

		<div id="content-wrapper">
			<div class="page-content">

				<!-- Header Bar -->

				<div class="row header">
					<div class="col-xs-12">
						<div class="meta pull-left">
							<div class="page">Dashboard</div>
							<div class="breadcrumb-links">Home / Dashboard</div>
						</div>
						<div class="user pull-right">
							<div class="item dropdown">
								<a href="./Dashboard_files/Dashboard.html" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false"> <img src="./Dashboard_files/avatar.jpg">
								</a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li class="dropdown-header">Joe Bloggs</li>
									<li class="divider"></li>
									<li class="link"><a href="./Dashboard_files/Dashboard.html"> Profile </a></li>
									<li class="link"><a href="./Dashboard_files/Dashboard.html"> Menu Item </a></li>
									<li class="link"><a href="./Dashboard_files/Dashboard.html"> Menu Item </a></li>
									<li class="divider"></li>
									<li class="link"><a href="./Dashboard_files/Dashboard.html"> Logout </a></li>
								</ul>
							</div>
							<div class="item dropdown">
								<a href="./Dashboard_files/Dashboard.html" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false"> <i class="fa fa-bell-o"></i>
								</a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li class="dropdown-header">Notifications</li>
									<li class="divider"></li>
									<li><a href="./Dashboard_files/Dashboard.html">Server Down!</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!-- End Header Bar -->

				<!-- Main Content -->
				<div class="row alerts-container ng-scope" data-ng-controller="AlertsCtrl" data-ng-show="alerts.length">
					<div class="col-xs-12">
						<!-- ngRepeat: alert in alerts -->
						<div class="alert ng-isolate-scope alert-success alert-dismissable" ng-class="{&#39;alert-success&#39;: true, &#39;alert-dismissable&#39;: closeable}" role="alert"
							data-ng-repeat="alert in alerts" type="success" close="closeAlert($index)">
							<button ng-show="closeable" type="button" class="close" ng-click="close()">
								<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
							</button>
							<div ng-transclude="">
								<span class="ng-binding ng-scope">Thanks for visiting! Feel free to create pull requests to improve the dashboard!</span>
							</div>
						</div>
						<!-- end ngRepeat: alert in alerts -->
						<div class="alert ng-isolate-scope alert-danger alert-dismissable" ng-class="{&#39;alert-danger&#39;: true, &#39;alert-dismissable&#39;: closeable}" role="alert" data-ng-repeat="alert in alerts"
							type="danger" close="closeAlert($index)">
							<button ng-show="closeable" type="button" class="close" ng-click="close()">
								<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
							</button>
							<div ng-transclude="">
								<span class="ng-binding ng-scope">Found a bug? Create an issue with as many details as you can.</span>
							</div>
						</div>
						<!-- end ngRepeat: alert in alerts -->
					</div>
				</div>

				<div class="row">
					<div class="col-lg-3 col-md-6 col-xs-12">
						<div class="widget">
							<div class="widget-body">
								<div class="widget-icon green pull-left">
									<i class="fa fa-users"></i>
								</div>
								<div class="widget-content pull-left">
									<div class="title">80</div>
									<div class="comment">Users</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-xs-12">
						<div class="widget">
							<div class="widget-body">
								<div class="widget-icon red pull-left">
									<i class="fa fa-tasks"></i>
								</div>
								<div class="widget-content pull-left">
									<div class="title">16</div>
									<div class="comment">Servers</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-xs-12">
						<div class="widget">
							<div class="widget-body">
								<div class="widget-icon orange pull-left">
									<i class="fa fa-sitemap"></i>
								</div>
								<div class="widget-content pull-left">
									<div class="title">225</div>
									<div class="comment">Documents</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div class="spacer visible-xs"></div>
					<div class="col-lg-3 col-md-6 col-xs-12">
						<div class="widget">
							<div class="widget-body">
								<div class="widget-icon blue pull-left">
									<i class="fa fa-support"></i>
								</div>
								<div class="widget-content pull-left">
									<div class="title">62</div>
									<div class="comment">Tickets</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="widget">
							<div class="widget-title">
								<i class="fa fa-tasks"></i> Servers <a href="./Dashboard_files/Dashboard.html" class="pull-right">Manage</a>
							</div>
							<div class="widget-body medium no-padding">
								<div class="table-responsive">
									<table class="table">
										<tbody>
											<tr>
												<td>RDVMPC001</td>
												<td>238.103.133.37</td>
												<td><span class="text-success"><i class="fa fa-check"></i></span></td>
											</tr>
											<tr>
												<td>RDVMPC002</td>
												<td>68.66.63.170</td>
												<td><span class="text-success"><i class="fa fa-check"></i></span></td>
											</tr>
											<tr>
												<td>RDVMPC003</td>
												<td>76.117.212.33</td>
												<td><span tooltip="Server Down!" class="text-danger ng-scope"><i class="fa fa-warning"></i></span></td>
											</tr>
											<tr>
												<td>RDPHPC001</td>
												<td>91.88.224.5</td>
												<td><span class="text-success"><i class="fa fa-check"></i></span></td>
											</tr>
											<tr>
												<td>RDESX001</td>
												<td>197.188.15.93</td>
												<td><span class="text-success"><i class="fa fa-check"></i></span></td>
											</tr>
											<tr>
												<td>RDESX002</td>
												<td>168.85.154.251</td>
												<td><span class="text-success"><i class="fa fa-check"></i></span></td>
											</tr>
											<tr>
												<td>RDESX003</td>
												<td>209.25.191.61</td>
												<td><span tooltip="Server Down!" class="text-danger ng-scope"><i class="fa fa-warning"></i></span></td>
											</tr>
											<tr>
												<td>RDESX004</td>
												<td>252.37.192.235</td>
												<td><span class="text-success"><i class="fa fa-check"></i></span></td>
											</tr>
											<tr>
												<td>RDTerminal01</td>
												<td>139.71.18.207</td>
												<td><span class="text-success"><i class="fa fa-check"></i></span></td>
											</tr>
											<tr>
												<td>RDTerminal02</td>
												<td>136.80.122.212</td>
												<td><span tooltip="Could not connect!" class="text-warning ng-scope"><i class="fa fa-flash"></i></span></td>
											</tr>
											<tr>
												<td>RDDomainCont01</td>
												<td>196.80.245.33</td>
												<td><span class="text-success"><i class="fa fa-check"></i></span></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="widget">
							<div class="widget-title">
								<i class="fa fa-users"></i> Users <input type="text" placeholder="Search" class="form-control input-sm pull-right">
								<div class="clearfix"></div>
							</div>
							<div class="widget-body medium no-padding">
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th class="text-center">ID</th>
												<th>Username</th>
												<th>Role</th>
												<th>Account</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="text-center">1</td>
												<td>Joe Bloggs</td>
												<td>Super Admin</td>
												<td>AZ23045</td>
											</tr>
											<tr>
												<td class="text-center">2</td>
												<td>Timothy Hernandez</td>
												<td>Admin</td>
												<td>AU24783</td>
											</tr>
											<tr>
												<td class="text-center">3</td>
												<td>Joe Bickham</td>
												<td>User</td>
												<td>AM23781</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="widget">
							<div class="widget-title">
								<i class="fa fa-plus"></i> Extras
								<button class="btn btn-sm btn-info pull-right">Button</button>
								<div class="clearfix"></div>
							</div>
							<div class="widget-body">

								<div class="message">
									This is a standard message which will also work the ".no-padding" class, I can also <span class="error">be an error message!</span>
								</div>

								<hr>

								<div class="message">
									<a href="http://angular-ui.github.io/bootstrap/" target="_blank">UI Bootstrap</a> is included, so you can use <a href="./Dashboard_files/Dashboard.html" tooltip="I&#39;m a tooltip!"
										class="ng-scope">tooltips</a> and all of the other native Bootstrap JS components!
								</div>

								<hr>

								<form class="form-horizontal ng-pristine ng-valid" role="form">
									<div class="form-group has-feedback has-success">
										<label for="label" class="col-sm-2 control-label">Inline Form</label>
										<div class="col-sm-5">
											<input type="text" class="form-control"> <span class="fa fa-key form-control-feedback"></span>
										</div>
										<div class="col-sm-5">
											<div class="input-mask">I'm an input mask!</div>
										</div>
										<div class="row">
											<div class="col-sm-offset-2 col-sm-10">
												<span class="help-block form-group-inline-message">I'm a properly padded inline message!</span>
											</div>
										</div>
									</div>
								</form>

							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="widget">
							<div class="widget-title">
								<i class="fa fa-cog fa-spin"></i> Loading Directive <a href="http://tobiasahlin.com/spinkit/" target="_blank" class="pull-right">SpinKit</a>
							</div>
							<div class="widget-body">
								<!-- Check out the Angular Directive inside bootstrap.js! -->
								<div class="loading">
									<div class="double-bounce1"></div>
									<div class="double-bounce2"></div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- End Main Content -->

			</div>
			<!-- End Page Content -->
		</div>
		<!-- End Content Wrapper -->
	</div>
	<!-- End Page Wrapper -->

</body>
</html>