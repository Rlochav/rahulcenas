<%@include file="../common/taglibs.jsp"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>CEO Stocks</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/imart/style.css'/>" />
<script src="<c:url value='/resources/js/imart/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/js/imart/home.js'/>" type="text/javascript"></script>
</script>
<!-- Place this tag in your head or just before your close body tag. -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src='http://assets.pinterest.com/js/pinit.js' type='text/javascript' />
<script src="https://apis.google.com/js/client.js?onload=handleClientLoad" gapi_processed="true"></script>

</head>
<body>
	<%@include file="../common/header.jsp"%>
	<section id="menu-bar">
		<div class="row row-eq-height menu-bar-content">
			<div class="width16 left menu columns" style="opacity: 0;">
				<div class="demo-container clear">
					<%@include file="../common/left.jsp"%>
				</div>
			</div>
			<div class="width80 right">
				<div class="maxwidth banner">
					<ul class="bxslider-1">
						<li><a href="#" class="slider-post-buy-requirement"><img
								src="resources/images/imart/Buy-On-Indiamart1.jpg" alt="Buy On Indiamart"
								title="Buy On Indiamart" width="1033" height="450" /></a></li>
						<li><a href="#" class="slider-post-buy-requirement"><img
								src="resources/images/imart/pbr-1.1.jpg" alt="Post buy Requirement"
								title="Post buy Requirement" width="1033" height="450" /></a></li>
						<li><a href="#"><img src="resources/images/imart/trending_now.jpg" alt="Trending Now"
								title="Trending Now" usemap="#Map" width="1033" height="450" /></a></li>
						<li><a href="#"><img src="resources/images/imart/prem_brand_new-1.1.jpg"
								alt="Top Brands" title="Top Brands" usemap="#MapPre" width="1033" height="450" /></a></li>
					</ul>
					<div id="bx-pager">
						<%
						if (dto2 != null && !CollectionUtils.isEmpty(dto2.getGcdMetaDTOs())) {
							for (GcdMetaDTO g : dto2.getGcdMetaDTOs()) {
								String img = null;
								if (g.getImagePath() != null) {
									img = g.getImagePath().replace(".", "_do_custom_separator_");
								}
								if (g.getShowOnPage().equals("Yes")) {
					%>
						<a data-slide-index="<%=g.getAlign()%>" class="<%=g.getElementClass()%>" href="#"><%=g.getImageAlt()%></a>
						<%
						}
							}
						}
					%>
						<!-- <a data-slide-index="1" href="#"
							class="slider-post-req">Post Buy Requirement</a> <a data-slide-index="2" href="#">Trending
							Now</a> <a data-slide-index="3" href="#">Top Brands</a> -->
					</div>
					<map name="Map">
						<area shape="rect" coords="2,1,201,227" href="#" alt="">
						<area shape="rect" coords="201,2,619,224" href="#" alt="">
						<area shape="rect" coords="619,2,1032,225" href="#" alt="">
						<area shape="rect" coords="3,227,411,446" href="#" alt="">
						<area shape="rect" coords="413,293,826,447" href="#" alt="">
						<area shape="rect" coords="604,224,827,293" href="#" alt="">
						<area shape="rect" coords="828,225,1031,446" href="#" alt="">
						<area shape="rect" coords="427,235,601,293" href="#" alt="">
					</map>
					<map name="MapPre">
						<area shape="rect" coords="2,0,201,151" href="#" target="_blank" alt="Benq">
						<area shape="rect" coords="200,2,419,151" href="#" target="_blank" alt="JCB">
						<area shape="rect" coords="417,0,618,150" href="#" target="_blank" alt="Finolex">
						<area shape="rect" coords="618,0,834,151" href="#" target="_blank" alt="ais">
						<area shape="rect" coords="832,0,1031,150" href="#" target="_blank" target="_blank"
							alt="Fenesta">
						<area shape="rect" coords="0,151,199,301" href="#" target="_blank" alt="somany">
						<area shape="rect" coords="834,150,1034,299" href="#" target="_blank" alt="johnson">
						<area shape="rect" coords="-7,300,200,450" href="#" target="_blank" alt="Widex">
						<area shape="rect" coords="199,301,411,451" href="#" target="_blank" alt="Liugong">
						<area shape="rect" coords="411,302,614,453" href="#" target="_blank" alt="Eicher">
						<area shape="rect" coords="612,300,835,459" href="#" target="_blank" alt="Amplifon">
						<area shape="rect" coords="835,299,1030,450" href="#" target="_blank"
							alt="Mahindra Techmaster">
					</map>
					<div id="blfrmcnt" style="display: none;">
						<div id="buy_lead_gen_form" class="t12_frm_area" style="display: none;">
							<div id="t21_maindiv">
								<div id="t21_frm_area" style="">
									<div id="t21_head"></div>
									<form name="t21_eto_bl_form" id="t21_eto_bl_form"
										onsubmit="return callIfGlobalJSLoaded_isq(temp21Obj, 'checkData_isq');" method="post"
										action="">
										<div class="relt">
											<div style="position: absolute; top: -20px; right: 43%; display: none" name="error_title"
												id="t21_error_title">
												<div style="position: relative">
													<div class="bln-bx">
														<div id="t21_title_errmsg" data-role="content">Invalid Input</div>
														<a class="bln-arw" style="top: 85%" data-role="arrow"></a>
													</div>
												</div>
											</div>
											<input type="text" id="t21_q_title" name="q_title"
												class="t21_input ui-autocomplete-input"
												onblur="if(this.value=='') {this.value='Enter product/service name';this.style.color='#CCCCCA';};"
												onfocus="this.style.color='#000';if(this.value=='Enter product/service name'){this.value='';}"
												onclick="if(document.getElementById('t21_error_title').style.display=='block'){  document.getElementById('t21_error_title').style.display='none';document.getElementById('t21_q_title').className='t21_input';}"
												onkeypress="this.style.color='#000';if(this.value=='Enter product/service name'){this.value='';}; if(document.getElementById('t21_error_title').style.display=='block'){ document.getElementById('t21_error_title').style.display='none';document.getElementById('t21_q_title').className ='t21_input';}"
												placeholder="Enter product/service name" value="Enter product/service name"
												maxlength="100" autocomplete="off" spellcheck="true"
												style="width: 99.2%; color: rgb(204, 204, 202);" role="textbox" aria-autocomplete="list"
												aria-haspopup="true">
										</div>
										<textarea name="q_desc" id="t21_q_desc" style="resize: none; color: #CCCCCA"
											onblur="if (this.value=='') {this.value='Provide specific details about : &quot;Product/Service required&quot;, &quot;Quality&quot;, &quot;Standard&quot;, &quot;Size&quot; etc...';this.style.color='#CCCCCA';};"
											onfocus="this.style.color='#000';if(this.value=='Provide specific details about : &quot;Product/Service required&quot;, &quot;Quality&quot;, &quot;Standard&quot;, &quot;Size&quot; etc...'){this.value='';}"
											onkeypress="this.style.color='#000';if(this.value=='Provide specific details about : &quot;Product/Service required&quot;, &quot;Quality&quot;, &quot;Standard&quot;, &quot;Size&quot; etc...'){this.value='';}"
											placeholder="Provide specific details about : &quot;Product/Service required&quot;, &quot;Quality&quot;, &quot;Standard&quot;, &quot;Size&quot; etc..."></textarea>
										<div></div>
										<div id="t21_q_contact_dtl1" class="relt" style="display: block;">
											<dl
												style="border: 1px solid #ccc; margin: 5px 0px 0px 2px; padding: 8px 0px 7px 0px; box-shadow: 0 -2px 0px rgba(0, 0, 0, 0.1) inset; box-sizing: border-box; -moz-box-sizing: border-box; border-radius: 0px; text-align: center; height: 40px; width: 15%; float: left; background-color: #fff"
												id="t21_Country_dropdown" class="dropdown" autocomplete="off">
												<dt>
													<a><span style="background-position: 0px -1694px"></span>
														<div class="as_arrow"></div> </a><span class="value"></span>
												</dt>
												<dd>
													<ul class="country_list" style="display: none;">
														<li class="country_list_item"
															onclick="javascript:t21_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;91&quot;,&quot;label&quot;:&quot;India  +91&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;India&quot;,&quot;iso&quot;:&quot;IN&quot;,&quot;icon_order&quot;:&quot;154&quot;}})"><span
															style="background-position: 0px -1694px"></span><a>India +91</a></li>
														<li class="country_list_item"
															onclick="javascript:t21_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;1&quot;,&quot;label&quot;:&quot;United States Of America  +1&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;United States Of America&quot;,&quot;iso&quot;:&quot;US&quot;,&quot;icon_order&quot;:&quot;4&quot;}})"><span
															style="background-position: 0px -44px"></span><a>United States Of America +1</a></li>
														<li class="country_list_item"
															onclick="javascript:t21_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;971&quot;,&quot;label&quot;:&quot;United Arab Emirates  +971&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;United Arab Emirates&quot;,&quot;iso&quot;:&quot;AE&quot;,&quot;icon_order&quot;:&quot;202&quot;}})"><span
															style="background-position: 0px -2222px"></span><a>United Arab Emirates +971</a></li>
														<li class="country_list_item"
															onclick="javascript:t21_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;44&quot;,&quot;label&quot;:&quot;United Kingdom  +44&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;United Kingdom&quot;,&quot;iso&quot;:&quot;GB&quot;,&quot;icon_order&quot;:&quot;5&quot;}})"><span
															style="background-position: 0px -55px"></span><a>United Kingdom +44</a></li>
														<li class="country_list_item"
															onclick="javascript:t21_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;61&quot;,&quot;label&quot;:&quot;Australia  +61&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;Australia&quot;,&quot;iso&quot;:&quot;AU&quot;,&quot;icon_order&quot;:&quot;156&quot;}})"><span
															style="background-position: 0px -1716px"></span><a>Australia +61</a></li>
														<li class="showmore"><a
															onclick="Suggester({&quot;type&quot;:&quot;isd&quot;,&quot;element&quot;:&quot;t21_Country_dropdown&quot;,fields: &quot;cname,iso,icon_order&quot;,displayFields:&quot;cname,value&quot;,displaySeparator:&quot;  +&quot;,&quot;defaultValue&quot;:&quot;IN&quot;,&quot;showmore&quot; : &quot;false&quot;,&quot;onSelect&quot;:t21_bl_onSelect_countryISO});return;">Show
																More</a></li>
													</ul>
												</dd>
											</dl>
											<div id="t21_indian_user" style="overflow: visible; display: block;">
												<div style="position: absolute; top: 50px; right: 21%; display: none" name="error_mob"
													id="t21_error_mob">
													<div style="position: relative">
														<div class="bln-bx" style="padding: 6px 11px;">
															<div id="t21_mob_errmsg" data-role="content">Invalid Mobile Number</div>
															<a class="bln-arw" style="top: -5px; left: 11px; transform: rotate(-135deg);"
																data-role="arrow"></a>
														</div>
													</div>
												</div>
												<input type="text" class="iso" readonly name="iso" id="t21_iso"
													style="width: 55px; float: left; border-right: 0px; border-radius: 0px; background: rgb(238, 238, 238); text-align: left; margin-top: 5px"
													tabindex="-1"> <input type="text" name="q_mobile" class="t21_input"
													id="t21_q_mobile"
													onkeypress="if(document.getElementById('t21_error_mob').style.display=='block'){		document.getElementById('t21_error_mob').style.display='none';document.getElementById('t21_q_mobile').className = 't21_input';}"
													onfocus="this.style.color='#000';if(this.value=='Mobile'){this.value=''; };;return isNumberKey(event);"
													style="width: 67% !important; float: left; margin-left: -1px; color: rgb(204, 204, 202); margin-top: 5px"
													onblur="if (this.value=='') {this.value='Mobile';this.style.color='#CCCCCA'; };if(document.getElementById('t21_error_mob').style.display=='block'){	  document.getElementById('t21_error_mob').style.display='none';document.getElementById('t21_q_mobile').className = 't21_input';}"
													onclick="if(document.getElementById('t21_error_mob').style.display=='block'){				  document.getElementById('t21_error_mob').style.display='none';document.getElementById('t21_q_mobile').className = 't21_input';}"
													placeholder="Mobile" value="Mobile" maxlength="15">
											</div>
											<div id="t21_forgien_user" style="display: none">
												<div style="position: absolute; top: -26px; left: 82%; display: none" name="error_email"
													id="t21_error_email">
													<div style="position: relative">
														<div class="bln-bx">
															<div id="t21_email_errmsg" data-role="content">Invalid E-mail ID</div>
															<a class="bln-arw" style="top: 81%; left: 14px; transform: rotate(44deg)"
																data-role="arrow"></a>
														</div>
													</div>
												</div>
												<input type="text" name="q_email" id="t21_q_email" class="t21_input" maxlength="100"
													onblur="if (this.value=='') {this.value='Email';this.style.color='#CCCCCA'; };if(this.value!='Email'){callIfGlobalJSLoaded_isq(temp21Obj,'displayVal');}"
													onclick="if(document.getElementById('t21_error_email').style.display=='block'){document.getElementById('t21_error_email').style.display='none';document.getElementById('t21_q_email').className = 't21_input';document.getElementById('t21_q_email').classList.remove('highlight-err');}"
													onfocus="this.style.color='#000';if(this.value=='Email'){this.value=''; }"
													onkeypress="this.style.color='#000';if(this.value=='Email'){this.value=''; };if(document.getElementById('t21_error_email').style.display=='block'){document.getElementById('t21_error_email').style.display='none';document.getElementById('t21_q_email').className = 't21_input';document.getElementById('t21_q_email').classList.remove('highlight-err');}"
													placeholder="Email" value="Email"
													style="width: 84%; float: left; margin-left: -1px; color: rgb(204, 204, 202); margin-top: 5px">
											</div>
											<div id="t21_contact_foreign" style="display: none">
												<div style="position: absolute; top: 64px; right: -1%; display: none"
													name="error_first_name" id="t21_error_first_name">
													<div style="position: relative">
														<div class="bln-bx">
															<div id="t21_fname_errmsg" data-role="content">Kindly enter Full Name</div>
															<a class="bln-arw" style="top: 37%; left: -4px; transform: rotate(128deg)"
																data-role="arrow"></a>
														</div>
													</div>
												</div>
												<input type="text" class="t21_input" name="q_first_name" id="t21_q_first_name"
													style="width: 99.2%" placeholder="Name"
													onclick="if(document.getElementById('t21_error_first_name').style.display=='block'){		document.getElementById('t21_error_first_name').style.display='none';document.getElementById('t21_q_first_name').className = 't21_input';}"
													onkeypress="if(document.getElementById('t21_error_first_name').style.display=='block'){		document.getElementById('t21_error_first_name').style.display='none';document.getElementById('t21_q_first_name').className = 't21_input';}">
											</div>
										</div>
										<div id="t21_q_buyer_details2" style="display: none;">
											<div id="t21_q_buyer_details1" style="display: none;"></div>
											<span name="bl_notme" id="t21_bl_notme" style="display: none;">(Not me)</span>
										</div>
										<div id="t21_sbtndiv">
											<input type="submit" name="submit" value="Get Instant Quotes" id="t21_sbtn">
										</div>
										<input name="q_post" value="Send Your Buy Requirement" type="hidden"> <input
											name="q_country_iso" value="IN" type="hidden" id="t21_q_country_iso"> <input
											name="q_country" value="IN" type="hidden"> <input name="q_city" value=""
											type="hidden"> <input name="q_state_others" value="" type="hidden"> <input
											type="hidden" name="q_ph_country1" value="+91"> <input type="hidden"
											name="q_country_name" value="India"> <input name="q_state" value="" type="hidden">
										<input type="hidden" name="q_type" value="B"> <input type="hidden"
											name="q_category" value="-1"> <input type="hidden" name="q_mcat" value="-1">
										<input type="hidden" name="q_modid" value="IMHOME"> <input type="hidden"
											name="q_page_referrer" value=""> <input type="hidden" name="q_updatedusing"
											value="Buyers Enquiry Form"> <input type="hidden" name="afflid" value="-7">
										<input name="q_utyp" value="" type="hidden"> <input name="q_imurl" value=""
											type="hidden"> <input type="hidden" value="" name="q_qty"> <input
											type="hidden" value="" name="q_qty_list_val1"> <input type="hidden" value=""
											name="q_vd11"> <input type="hidden" value="" name="q_comp_name"> <input
											type="hidden" value="" name="q_website"> <input type="hidden" value="0"
											name="bl_is_usr_flg"> <input type="hidden" value="1" name="q_offrid"
											id="t21_q_offrid"> <input type="hidden" value="" name="q_city_others"
											id="t21_q_city_others">
									</form>
									<div id="t21_q_send_req_loading"
										style="background: rgba(255, 255, 255, 0.5) none repeat scroll 0% 0%; height: 100%; position: absolute; top: 0px; width: 100%; display: none">
										<div class="blloader"></div>
									</div>
								</div>
							</div>
							<div id="t21_enrichform_maindiv" style="display: none"></div>
							<span id="t21_q_lead_enrichment"></span> <span id="t21_q_lead_conversion"></span> <span
								id="t21_q_lead_impressionload"></span>
						</div>
					</div>
				</div>
				<div class="maxwidth space">
					<div class="tabs-content left">
						<!-- .tabs-content starts -->
						<div class="content">
							<div class="con-tab primary">
								<a class="head-tab1 active">Electronics and Electrical</a> <a class="head-tab2">Computer
									& IT Solutions</a> <a class="head-tab3">Telecom Equipment & Goods</a>
							</div>
							<div class="row collapse row-eq-height primary-category">
								<div class="cat-tab head-tab1 active">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33 left" data-equalizer-watch="inner-height">
											<ul class="bxslider">
												<!-- .bxslider starts -->
												<li class="first"><a href="#">
														<div class="position text-center">
															<h4>LED Bulbs</h4>
															<hr />
															<p>Save Electricity</p>
														</div>
												</a></li>
												<li class="first"><a href="#">
														<div class="position text-center">
															<h4>Washing Machines</h4>
															<hr />
															<p>Clothing Wellness</p>
														</div>
												</a></li>
												<li class="first"><a href="#">
														<div class="position text-center">
															<h4>Electric Fans</h4>
															<hr />
															<p>Switch Freshness</p>
														</div>
												</a></li>
												<li class="first"><a href="#">
														<div class="position text-center">
															<h4>Refrigerators</h4>
															<hr />
															<p>The Chiller Zone</p>
														</div>
												</a></li>
											</ul>
											<!-- .bxslider ends -->
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 left border-right dec-space columns">
													<a class="bg-grey left cat-1 img-1" href="#"> <!--<img class="" src="images/img_keys.png" alt="" />-->
														<h5 class="position">
															Electrical<br /> Switches
														</h5>
													</a>
												</div>
												<a class="width33 left text-center padding8 cat-1 img-2" href="#">
													<h6>Solar Street Lights</h6> <!--<img class="" src="images/img_solar.png" alt="" />-->
												</a>
											</div>
											<div class="row">
												<div class="maxwidth border-top row-eq-height">
													<a class="width33 text-center border-right columns cat-1 img-3" href="#">
														<h6>Air Coolers</h6> <!--<img class="" src="images/img_machine.png" alt="" />-->
													</a> <a class="width33 text-center border-right columns cat-1 img-4" href="#">
														<h6>Security Cameras</h6> <!--<img class="" src="images/img_camera.png" alt="" />-->
													</a> <a class="width33 text-center columns cat-1 img-5" href="#">
														<h6>Split Air Conditioners</h6> <!--<img class="" src="images/img_ac.png" alt="" />-->
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="cat-tab head-tab2">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33 left">
											<ul>
												<li class="second"><a href="#">
														<div class="position text-center">
															<h4>Fiber Optic Cable</h4>
															<hr />
															<p>Light Guide</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-1 img-1" href="#">
														<h5 class="position">Cat 6 Cable</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-1 img-2" href="#">
													<h6>Hard Disk Drive</h6>
												</a>
											</div>
											<div class="maxwidth border-top none columns">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-1 img-3" href="#">
														<h6>Networking Rack</h6>
													</a> <a class="width33 text-center border-right columns cat-1 img-4" href="#">
														<h6>Multi Recharge Modem</h6>
													</a> <a class="width33 text-center columns cat-1 img-5" href="#">
														<h6>Tally Accounting Software</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="cat-tab head-tab3">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33">
											<ul>
												<li class="third"><a href="#">
														<div class="position text-center">
															<h4>Walkie Talkie</h4>
															<hr />
															<p>Communicate Easily</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-1 img-1" href="#">
														<h5 class="position">Smart Phone</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-1 img-2" href="#">
													<h6>Mobile Cover</h6>
												</a>
											</div>
											<div class="maxwidth border-top none">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-1 img-3" href="#">
														<h6>Mobile Signal Booster</h6>
													</a> <a class="width33 text-center border-right columns cat-1 img-4" href="#">
														<h6>Video Conferencing System</h6>
													</a> <a class="width33 text-center columns cat-1 img-5" href="#">
														<h6>Power Bank</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="con-tab fourth">
								<a class="head-tab1 active">Apparel & Garments</a> <a class="head-tab2">Fashion &
									Accessories</a> <a class="head-tab3">Sports Goods, Toys & Games</a>
							</div>
							<div class="row row-eq-height fourth-category">
								<div class="cat-tab head-tab1 active">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33">
											<ul class="bxslider">
												<li class="fourth"><a href="#">
														<div class="position text-center">
															<h4>Indian Sarees</h4>
															<hr />
															<p>Perfect Attire</p>
														</div>
												</a></li>
												<li class="fourth"><a href="#">
														<div class="position text-center">
															<h4>Mens Suits</h4>
															<hr />
															<p>SUIT UP-IN STYLE!</p>
														</div>
												</a></li>
												<li class="fourth"><a href="#">
														<div class="position text-center">
															<h4>Denim Jeans</h4>
															<hr />
															<p>Denim Decoded</p>
														</div>
												</a></li>
												<li class="fourth"><a href="#">
														<div class="position text-center">
															<h4>Men Shirts</h4>
															<hr />
															<p>Feel Light , Show Style</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-3 img-1" href="#">
														<h5 class="position">Bridal Lehenga</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-3 img-2" href="#">
													<h6>Ladies Kurtis</h6>
												</a>
											</div>
											<div class="maxwidth border-top none">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-3 img-3" href="#">
														<h6>Ladies Salwar Suits</h6>
													</a> <a class="width33 text-center border-right columns cat-3 img-4" href="#">
														<h6>Tracksuits</h6>
													</a> <a class="width33 text-center columns cat-3 img-5" href="#">
														<h6>Ladies Tops</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="cat-tab head-tab2">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33">
											<ul>
												<li class="second"><a href="#">
														<div class="position text-center">
															<h4>Leather Bags</h4>
															<hr />
															<p>Genuine Leather</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-3 img-1" href="#">
														<h5 class="position">Mens Footwear</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-3 img-2" href="#">
													<h6>Jute Bags</h6>
												</a>
											</div>
											<div class="maxwidth border-top none">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-3 img-3" href="#">
														<h6>School Bags</h6>
													</a> <a class="width33 text-center border-right columns cat-3 img-4" href="#">
														<h6>Womens Footwear</h6>
													</a> <a class="width33 text-center columns cat-3 img-5" href="#">
														<h6>Ladies Hand Bags</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="cat-tab head-tab3">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33 left">
											<ul>
												<li class="third"><a href="#">
														<div class="position text-center">
															<h4>Gym Equipments</h4>
															<hr />
															<p>Healthy lifestyle</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-3 img-1" href="#">
														<h5 class="position">Swimming Pool Equipment</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-3 img-2" href="#">
													<h6>Kids Toys</h6>
												</a>
											</div>
											<div class="maxwidth border-top none columns">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-3 img-3" href="#">
														<h6>Sports Shoes</h6>
													</a> <a class="width33 text-center border-right columns cat-3 img-4" href="#">
														<h6>Cricket Bat</h6>
													</a> <a class="width33 text-center columns cat-3 img-5" href="#">
														<h6>Soft Toys</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="con-tab secondry">
								<a class="head-tab1 active">Medical & Healthcare</a> <a class="head-tab2">Herbal &
									Ayurvedic Product</a> <a class="head-tab3">Cosmetics & Personal Care</a>
							</div>
							<div class="row collapse secondry-category">
								<div class="cat-tab head-tab1 active">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33 left">
											<ul class="bxslider">
												<li class="second"><a href="#">
														<div class="position text-center">
															<h4>Protein Powder</h4>
															<hr />
															<p>Shape Yourself</p>
														</div>
												</a></li>
												<li class="second"><a href="#">
														<div class="position text-center">
															<h4>ECG Machines</h4>
															<hr />
															<p>Heart Essentials</p>
														</div>
												</a></li>
												<li class="second"><a href="#">
														<div class="position text-center">
															<h4>Dental X-Ray Machines</h4>
															<hr />
															<p>Clinic Essentials</p>
														</div>
												</a></li>
												<li class="second"><a href="#">
														<div class="position text-center">
															<h4>Skin Ointment</h4>
															<hr />
															<p>Better Than Bare</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right head-tab1 active">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-2 img-1" href="#">
														<h5 class="position">Eye Drops</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-2 img-2" href="#">
													<h6>Wheelchairs</h6>
												</a>
											</div>
											<div class="maxwidth border-top none columns">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-2 img-3" href="#">
														<h6>Body Massager</h6>
													</a> <a class="width33 text-center border-right columns cat-2 img-4" href="#">
														<h6>Surgical Gloves</h6>
													</a> <a class="width33 text-center columns cat-2 img-5" href="#">
														<h6>Hearing Aids</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="cat-tab head-tab2">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33">
											<ul>
												<li class="second"><a href="#">
														<div class="position text-center">
															<h4>Flax Seed</h4>
															<hr />
															<p>Nutrition</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-2 img-1" href="#">
														<h5 class="position">Medicinal Plant</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-2 img-2" href="#">
													<h6>Natural Honey</h6>
												</a>
											</div>
											<div class="maxwidth border-top none">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-2 img-3" href="#">
														<h6>Aloe Vera Juice</h6>
													</a> <a class="width33 text-center border-right columns cat-2 img-4" href="#">
														<h6>Ayurvedic Medicine</h6>
													</a> <a class="width33 text-center columns cat-2 img-5" href="#">
														<h6>Moringa Seeds</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="cat-tab head-tab3">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33 left">
											<ul>
												<li class="third"><a href="#">
														<div class="position text-center">
															<h4>Beauty Cosmetics</h4>
															<hr />
															<p>Better Beauty,Better Makeup</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-2 img-1" href="#">
														<h5 class="position">Baby Diapers</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-2 img-2" href="#">
													<h6>Human Hair</h6>
												</a>
											</div>
											<div class="maxwidth border-top none columns">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-2 img-3" href="#">
														<h6>Perfumes</h6>
													</a> <a class="width33 text-center border-right columns cat-2 img-4" href="#">
														<h6>Detergent Powder</h6>
													</a> <a class="width33 text-center columns cat-2 img-5" href="#">
														<h6>Hand Sanitizer</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- Second Ends -->
							<div class="con-tab ternary">
								<a class="head-tab1 active">Industrial Plant & Machine</a> <a class="head-tab2">Industrial
									Supplies</a> <a class="head-tab3"> Mechanical Parts & Spares</a>
							</div>
							<div class="row row-eq-height ternary-category">
								<div class="cat-tab head-tab1 active">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33">
											<ul class="bxslider">
												<li class="third"><a href="#">
														<div class="position text-center">
															<h4>Arc Welding Machines</h4>
															<hr />
															<p>Boost Your Welding</p>
														</div>
												</a></li>
												<li class="third"><a href="#">
														<div class="position text-center">
															<h4>Flour Mill Machines</h4>
															<hr />
															<p>Domestic And Industrial</p>
														</div>
												</a></li>
												<li class="third"><a href="#">
														<div class="position text-center">
															<h4>Digital Printing</h4>
															<hr />
															<p>Capture Anything</p>
														</div>
												</a></li>
												<li class="third"><a href="#">
														<div class="position text-center">
															<h4>Solar Power Plants</h4>
															<hr />
															<p>Go Solar</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-3 img-1" href="#">
														<h5 class="position">Air Filters</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-3 img-2" href="#">
													<h6>Water Dispensers</h6>
												</a>
											</div>
											<div class="maxwidth border-top none">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-3 img-3" href="#">
														<h6>Hydraulic Jacks</h6>
													</a> <a class="width33 text-center border-right columns cat-3 img-4" href="#">
														<h6>Dal Mill Machines</h6>
													</a> <a class="width33 text-center columns cat-3 img-5" href="#">
														<h6>Hydraulic Presses</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="cat-tab head-tab2">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33">
											<ul>
												<li class="second"><a href="#">
														<div class="position text-center">
															<h4>Air Compressors</h4>
															<hr />
															<p>Maximum Performance</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-3 img-1" href="#">
														<h5 class="position">Acrylic Sheet</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-3 img-2" href="#">
													<h6>HDPE Pipes</h6>
												</a>
											</div>
											<div class="maxwidth border-top none">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-3 img-3" href="#">
														<h6>Water Tanks</h6>
													</a> <a class="width33 text-center border-right columns cat-3 img-4" href="#">
														<h6>Toughened Glass</h6>
													</a> <a class="width33 text-center columns cat-3 img-5" href="#">
														<h6>MS Pipe</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="cat-tab head-tab3">
									<div class="tab-menu"></div>
									<div class="tab-wrap">
										<div class="width33 left">
											<ul>
												<li class="third"><a href="#">
														<div class="position text-center">
															<h4>Submersible Pumps</h4>
															<hr />
															<p>Water Solutions</p>
														</div>
												</a></li>
											</ul>
										</div>
										<div class="width66 bg-white right">
											<div class="row row-eq-height">
												<div class="width66 border-right columns">
													<a class="bg-grey left cat-3 img-1" href="#">
														<h5 class="position">Ball Valves</h5>
													</a>
												</div>
												<a class="width33 text-center padding8 cat-3 img-2" href="#">
													<h6>Aluminium Die Casting</h6>
												</a>
											</div>
											<div class="maxwidth border-top none columns">
												<div class="row row-eq-height">
													<a class="width33 text-center border-right columns cat-3 img-3" href="#">
														<h6>MS Bolt Nut</h6>
													</a> <a class="width33 text-center border-right columns cat-3 img-4" href="#">
														<h6>Diesel Engine Pump Sets</h6>
													</a> <a class="width33 text-center columns cat-3 img-5" href="#">
														<h6>Vacuum Pumps</h6>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- First Tabs Ends -->
					</div>
					<!-- .tabs-content starts -->

				</div>
			</div>
		</div>
	</section>

	<!--buyer dashboard section ends-->

	<section id="products">
		<!-- #products starts -->
		<div class="row">
			<div class="large-12 text-center">
				<h3>Products From Premium Brands</h3>
				<ul class="bxslider-logos text-center">
					<li class="brand-1"><a href="#">benq India limited<!--<img src="images/logo-1.png" alt="" />-->
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a></li>
					<li class="brand-2">
						<!--<img src="images/logo-2.png" alt="" />--> <a href="#">mahindra and mahindra
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
					<li class="brand-3">
						<!--<img src="images/logo-3.png" alt="" />--> <a href="#">Finolex pipes fittings
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
					<li class="brand-4">
						<!--<img src="images/logo-4.png" alt="" />--> <a href="#">eicher motors limited
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
					<li class="brand-5">
						<!--<img src="images/logo-5.png" alt="" />--> <a href="#">fenesta building system
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
					<li class="brand-6">
						<!--<img src="images/logo-5.png" alt="" />--> <a href="#">jcb india ltd
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
					<li class="brand-7">
						<!--<img src="images/logo-5.png" alt="" />--> <a href="#">walpast
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
					<li class="brand-8">
						<!--<img src="images/logo-5.png" alt="" />--> <a href="#">liugong
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
					<li class="brand-9">
						<!--<img src="images/logo-5.png" alt="" />--> <a href="#">Amplifon
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
					<li class="brand-10 last">
						<!--<img src="images/logo-5.png" alt="" />--> <a href="#">mahindra Earth Master
							<div class="overlay">
								<span class="btn">View Products</span>
							</div>
					</a>
					</li>
				</ul>
			</div>
		</div>
	</section>
	<!-- #products ends -->
	<section id="business">
		<!-- #business starts -->
		<div class="row collapse">
			<div class="large-12 text-center columns">
				<h3>Trusted By Largest Of Businesses</h3>
			</div>
		</div>
		<div class="row row-eq-height big-buyer-section">
		
			<div class="large-5 slider">
			
				<ul class="bxslider-normal text-center">
					<li>
						<p>
							Excellent prompt response and professional service.<br /> Good going. keep it up.
						</p>
						<h4>Biseshwar Mishra,</h4>
						<h5>Tata Motors, India</h5> <a class="btn" href="#">Read more...</a>
					</li>
					
				</ul>
			</div>
			
			<div class="large-7 bg-white big-buyer-slider">
				<ul class="bxslider-normal text-center bblogo">
					<li>
						<div class="width30 left bblogo-1">
							<a href="#"> <!--<img src="images/logo_voltas.png" alt="" />-->bharat electronics
							</a>
						</div>
						<div class="width30 left bblogo-2">
							<a href="#"> <!--<img src="images/logo_aditya.png" alt="" />-->tata motors
							</a>
						</div>
						<div class="width30 left bblogo-3">
							<a href="#"> <!--<img src="images/logo_indian.png" alt="" />-->iocl
							</a>
						</div>
						<div class="width30 left bblogo-4">
							<a href="#"> <!--<img src="images/logo_mahindra.png" alt="" />-->hindalco
							</a>
						</div>
						<div class="width30 left bblogo-5">
							<a href="#"> <!--<img src="images/logo_tata.png" alt="" />-->ntpc
							</a>
						</div>
						<div class="width30 left bblogo-6">
							<a href="#"> <!--<img src="images/logo_ntpc.png" alt="" />-->mahindra and mahindra
							</a>
						</div>
						<div class="large-12 text-center columns">
							<a class="btn" href="#">View more...</a>
						</div>
					</li>
					<li>
						<div class="width30 left bblogo-7">
							<a href="#"> <!--<img src="images/logo_voltas.png" alt="" />-->reliance
							</a>
						</div>
						<div class="width30 left bblogo-8">
							<a href="#"> <!--<img src="images/logo_aditya.png" alt="" />-->larsen-toubro
							</a>
						</div>
						<div class="width30 left bblogo-9">
							<a href="#"> <!--<img src="images/logo_indian.png" alt="" />-->maruti-suzuki
							</a>
						</div>
						<div class="width30 left bblogo-10">
							<a href="#"> <!--<img src="images/logo_mahindra.png" alt="" />-->raymonds
							</a>
						</div>
						<div class="width30 left bblogo-11">
							<a href="#"> <!--<img src="images/logo_tata.png" alt="" />-->jsw-steel
							</a>
						</div>
						<div class="width30 left bblogo-12">
							<a href="#"> <!--<img src="images/logo_ntpc.png" alt="" />-->itc
							</a>
						</div>
						<div class="large-12 text-center columns">
							<a class="btn" href="#">View more...</a>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</section>
	<!-- #business ends -->
	<div>
		<!-- Footer Start Here::-->
		<%@include file="../common/bottom.jsp"%>
		<!-- Footer End Here::-->
	</div>

	<!--script tag starts-->
	<script src="<c:url value='resources/js/imart/jquery.bxslider.min.1.6.js'/>"></script>
	<script type="text/javascript">
$(document).ready(function(){
    $('.bxslider-normal').bxSlider({ 
		auto: 'true',

		controls: false
    });

});
</script>
	<script type="text/javascript">
$(document).ready(function(){
    $('.bxslider-logos').bxSlider({
		auto: 'true',
		slideWidth: 260,
		autoHover: true,
		minSlides: 5,
		maxSlides: 5,
		moveSlides: 5,
		slideMargin: 0,
		controls: false,
		pager: true
    });
});
</script>

	<!--custom index js-->
	<script type="text/javascript">
$(document).ready(function(){
$(".hwrk").click(function(){
    $("#hwrkB").slideToggle("slow",function(){});
	$('#navi').toggleClass("toppos");
	$('#navi').toggleClass("abs");
	$('.width16.menu').toggleClass("abss");
	return false;
 });
 
});

</script>
	<!-- Menu JS -->
	<script>
$(document).ready(function(){
$(window).scroll(function() {
        if ($(this).scrollTop() > 40) {
			 $('#navi').addClass('fix');
			 $('.width16.menu').addClass("sticky"); 
			 $('.width80.right').addClass("sticky");
			
			} else {
				$('#navi').removeClass('fix');
				$('.width16.menu').removeClass("sticky");
				$('.width80.right').removeClass("sticky"); 
			}
var productTop = $("#products").offset().top;
var scorllMenu = productTop - 750; 
//var bottom = winheight - link.height();
//bottom = offset.top - bottom;
if($(this).scrollTop() > scorllMenu){
 $('.width16.menu').removeClass("sticky"); 
 $('.width16.menu').addClass("sticky-btm"); 
}
else{
$('.width16.menu').removeClass("sticky-btm"); 
}
});
});


</script>
	<script>
$('.identified-arrow').click(function(){
var recomTopPosition=document.getElementById('recommended-product-buyer').offsetTop;
//var naviheight=$('#navi').outerHeight();
var headerheight=$('#header').outerHeight();
var actualheight=recomTopPosition-headerheight;
var recomTopPosition1=document.getElementById('recommended-product-supplier').offsetTop;
var actualheight1=recomTopPosition1-headerheight;
if(recomTopPosition){
$('html, body').animate({scrollTop:actualheight}, 'slow');
}
else{
$('html, body').animate({scrollTop:actualheight1}, 'slow');
}
return false;
});
</script>
	<script type="text/javascript">
$(document).ready(function($){
	$('#mega-1').dcVerticalMegaMenu({
		rowItems: '5',
		speed: '1',  
		effect: 'show',
		direction: 'right'
	});
});

</script>
	<script>

//tracking
$(document).ready(function(){
	
//mega menu link tracking
$(".menu li a").click(function() {
var power_label=$.trim($(this).text());
//var actual_length=power_label.substr(0, power_label.length-1);
var this_href = $(this).attr('href');

gatrack(this_href, 'IM_Homepage'+userType+'', 'Power_Menu',power_label, 0);

});	


//banner tracking

 $('.bxslider-1 li a').click(function(e) {
        var img_href = $(this).find('img').attr('href');
        var img_title = $(this).find('img').attr('title');
       gatrack(img_href, 'IM_Homepage'+userType+'', 'Banner Area',img_title, 0);
});


$('.primary-category  a').click(function(){
	
	var href_text=$(this).attr('href');
	var text1;
	if ($(this).find("h4").length) {
     text1 = $(this).find("h4").text();
	 gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 1', text1 , 0);
	}else if($(this).children("h5").length)
	{
		text1 = $(this).children("h5").text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 1', text1 , 0);
	}else if($(this).children("h6").length){
		text1 =$(this).children("h6").text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 1', text1 , 0);
	} 
	else{
	
	   text1 =$(this).text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 1', text1 , 0);
	
	}
	

});




$('.secondry-category  a').click(function(){
	
	var href_text=$(this).attr('href');
	var text1;
	if ($(this).find("h4").length) {
     text1 = $(this).find("h4").text();
	 gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 2', text1 , 0);
	}else if($(this).children("h5").length)
	{
		text1 = $(this).children("h5").text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 2', text1 , 0);
	}else if($(this).children("h6").length){
		text1 =$(this).children("h6").text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 2', text1 , 0);
	}
  else{
	
	   text1 =$(this).text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 1', text1 , 0);
	
	}	
  
});
$('.ternary-category  a').click(function(){
	
	var href_text=$(this).attr('href');
	var text1;
	if ($(this).find("h4").length) {
     text1 = $(this).find("h4").text();
	 gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 3', text1 , 0);
	}else if($(this).children("h5").length)
	{
		text1 = $(this).children("h5").text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 3', text1 , 0);
	}else if($(this).children("h6").length){
		text1 =$(this).children("h6").text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 3', text1 , 0);
	}
   else{
	
	   text1 =$(this).text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 1', text1 , 0);
	
	}	
  
});


$('.fourth-category  a').click(function(){
	
	var href_text=$(this).attr('href');
	var text1;
	if ($(this).find("h4").length) {
     text1 = $(this).find("h4").text();
	 gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 4', text1 , 0);
	}else if($(this).children("h5").length)
	{
		text1 = $(this).children("h5").text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 4', text1 , 0);
	}else if($(this).children("h6").length){
		text1 =$(this).children("h6").text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 4', text1 , 0);
	}
   else{
	
	   text1 =$(this).text();
		gatrack(href_text, 'IM_Homepage'+userType+'','Industry Slider 1', text1 , 0);
	
	}	
  
});


$("#products li a").click(function() {
$this = $(this).attr('href');
gatrack(this, 'IM_Homepage'+userType+'', 'Big Buyer Gallery',$.trim($(this).text()), 0);

});

$("#business .big-buyer-slider li a").click(function() {
$this = $(this).attr('href');
gatrack(this, 'IM_Homepage'+userType+'', 'Big Supplier Gallery',$.trim($(this).text()), 0);
});

  $('map[name="Map"] area').click(function(){
			     var map_href = $(this).attr('href');
			     gatrack(map_href, 'IM_Homepage'+userType+'', 'Banner Area','trending now', 0);
   });
   
    $('map[name="MapPre"] area').click(function(){
			     var map_href = $(this).attr('href');
			     gatrack(map_href, 'IM_Homepage'+userType+'', 'Banner Area','Top Brands', 0);
   });
   
 
});

</script>
	<script>
$(document).on('click','.ctrBx ul li a',function() {
$this = $(this).attr('href');
gatrack($this, 'IM_Homepage'+userType+'', 'Dir_Cat',$(this).text(), 0);
});
</script>
	<script type="text/javascript">
$(window).load(function(){
$.ajaxSetup({cache: true});
$('#new-footer').load('/gl-include/gl-imfooter.html');
});
</script>
	<script type="text/javascript">
 
 
 
		$(document).ready(function(){
			$('.slider-post-buy-requirement').click(function(event){
			
			event.preventDefault();
			 openOnClickBLForm();
			return false;

			});
			
		});
	
</script>

	<!-- Menu strip JS  -->
	<script>
$(window).on('load resize',function(){
if(($(window).width()>=1007) && ($(window).width()<=1140)){
$(".width16.left.menu.columns").hover(function(){
$("#menu-bar .width16").addClass("extend");
    }, function(){
	$("#menu-bar .width16").removeClass("extend");

});
}
else{
$("#menu-bar .width16").removeClass("extend");
}
});
</script>
</body>
</html>