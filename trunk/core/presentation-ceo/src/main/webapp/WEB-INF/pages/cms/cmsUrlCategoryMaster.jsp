<%@include file="../common/taglibs.jsp"%>
<div class="register-form">
	<div class="row">
		<div class="col-md-6">
			<input type="text" id="categoryName" ng-model="categoryName" placeholder="Category Name" />
		</div>
		<div class="col-md-6">
			<select id="type" ng-model="type">
				<option value="-1">Select Type</option>
				<option value="1">Footer</option>
				<option value="2">Header</option>
				<option value="3">Menu</option>
			</select>
		</div>
		<div class="clearfix"></div>
		<div class="col-md-3">
			<input type="checkbox" name="isActive" ng-model="isActive" /> <label for="active">Active</label>
		</div>
		<div class="clearfix"></div>
		<div class="col-md-2">
			<input type="button" value="Save" class="btn-blue" ng-click="save();"/>
		</div>
	</div>
</div>