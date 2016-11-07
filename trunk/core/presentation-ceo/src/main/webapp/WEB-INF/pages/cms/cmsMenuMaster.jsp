<%@include file="../common/taglibs.jsp"%>
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
		<div class="col-md-2">
			<input type="button" value="Save" class="btn-blue" onclick="doRegister();" />
		</div>
	</div>
</div>