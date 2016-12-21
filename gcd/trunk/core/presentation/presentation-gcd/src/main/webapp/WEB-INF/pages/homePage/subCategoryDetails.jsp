<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Product Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/main.css">
<link type="text/css" rel="stylesheet" href="css/pre-load.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jq-ac-ui.js"></script>
<script type="text/javascript" src="js/blgenCommon_min.js"></script> 
<!--[if IE 8]><html class="ie8"> <![endif]--><!--[if lte IE 7]> <html class="ie8"> <![endif]--><!-- Event tracking code start-->
<script type="text/javascript">
function recordOutboundLink(link, category, action, value, timeOutFlag) {

var linkHref = '';
if ( typeof(link) == 'string' && link.match(/\/\//) )
{
linkHref = link;
} else {
linkHref = link.href;
}
if(action == 'Fetch-0' && category == 'Trac-Fetch-More'  )
{   
    _gaq.push(['_trackEvent', category, action, linkHref, value,true]);
}
else{
    _gaq.push(['_trackEvent', category, action, linkHref, value]);
}

if ( timeOutFlag == 1 ) {
setTimeout('document.location = "' + linkHref + '"', 100);
}
}
function recordInboundLinkS_bounce(link,category, action, value, noninteraction) {
_gaq.push(['_trackEvent', category, action, link, value, noninteraction]);
}
</script>
<!-- Event tracking code end-->
</head>

<body>
<script type="text/javascript">
var IMAppBanner= 'NO';
    page.catID = '759';
    page.mcatName = 'LED Panel Light';
    page.modreftype = '2';
    page.suppType = 'product';
    page.btnStatus = changeColorEnquirySent;
    page.countryCode = 'IN';
    page.country = 'India';
    page.countryIp = '47.8.44.123';
    page.mcatIds = [121185];
    page.loginQ = new Array();
    page.login = function() {
           for (var j=0; j< page.loginQ.length; j++)
           {
                   if(typeof page.loginQ[j] === "function")
                   {
                               page.loginQ[j].apply();
                   } 
           }
    }
  
    page.loginQ.push(getLoginString);
       function changeColorEnquiryAlreadySent()
        {
                 var cookieData = (readCookie('imEqGl')) ? readCookie('imEqGl') : 'undef';
                 if ( cookieData != null && cookieData != '' && cookieData != 'undef' ) 
                 {
                         var cookieDataArray = cookieData.split(",");
                         for (i=0; i<cookieDataArray.length; i++) 
                         {
                               var did = cookieDataArray[i];
                                 try{
                         $("#"+did).removeClass().addClass("bg esd hl a2 td f2 wdt bo td c3 a1").fadeIn("slow").css({"cursor":"default"}).html("<span>Enquiry Sent</span>").removeAttr("onclick");
                                       }catch (err){
                                 
                                 }
                             // make id eid class name changed
                         }
                 }
         }
       // function which change the enquiry color after sent....
       // this function calling in enquiry.js by call back method
         
       function changeColorEnquirySent(enq_id)
       {
             try
             {
                   $("#"+enq_id).hide();
                  setTimeout(function() {
                                   $("#"+enq_id).removeClass().addClass("bg esd hl a2 td f2 wdt bo td").fadeIn("slow").css({"cursor":"default"}).html("<span>Enquiry Sent</span>").removeAttr("onclick");
                                   }, 500);
                   $("#"+enq_id).focus();
             } 
            catch ( e ) {
             }
       }
//$(window).load(function(){ changeColorEnquiryAlreadySent();});  
$( document ).ready(function() {changeColorEnquiryAlreadySent();});
setTimeout(function(){head.js("//utils.imimg.com/enquiry/js/serveEnquiry.js")}, 1);
if(0)
{
               var new_Cook = new userDataCookie();
               var pv = new_Cook.get('xnHist').pv || 0;
               var set_obj = {
                       'city':'',
                        'pv' : pv              
                        };
               new_Cook.set(set_obj, 'xnHist');
}
</script>
<%@include file="../common/header.jsp"%>
<div class="q_hm1 fxmn"> 
  <script type="text/javascript">
function open_bl_page(){
if(document.getElementById('bl_overlay_layer_v2')) 
    {
            if(document.getElementById('bl_overlay_layer_v2').style.display=='none')
            {       
                    
                        new BLForm({ tempID:"14", mcatName:"LED Panel Light", catID:"759" , mcatID:"121185",modID:"DIR",afflID:"-2",hideFormFn:"revert"});
                        $('#bl_overlay_layer').load("//dir.indiamart.com/blgen-include/template14.html");
                        document.getElementById('bl_overlay_layer').style.display='block';                                                    
            }
    }
    else {
                        new BLForm({ tempID:"14", mcatName:"LED Panel Light", catID:"759" , mcatID:"121185",modID:"DIR",afflID:"-2",hideFormFn:"revert"});
                        $('#bl_overlay_layer').load("//dir.indiamart.com/blgen-include/template14.html");
                        document.getElementById('bl_overlay_layer').style.display='block';     
    }
}
$('.ih-pbr').unbind('click');
$('.ih-pbr').click(function(event){event.preventDefault();openOnClickBLForm(); $(this).css("cursor","pointer");});
new BLForm({ tempID:"9", customHeadline:"", mcatName:"LED Panel Light", catID:"759",modID:"DIR",mcatID:"121185"});
</script>
  <div id="t9_maindiv" style="display:none;z-index:99;position:fixed;top:0px;width:100%;left:0px;height:100%;">
    <div id="t9_bglayer" style="background:#000;opacity:0.5;filter:alpha(opacity=50);bottom: 0;cursor: pointer;height: 100%;left: 0;opacity: 0.7;overflow: hidden;position: fixed;top: 0;width: 100%;z-index: 3;"></div>
    <div style="/* display:table-cell; *//* vertical-align:middle; */">
      <div class="blnewform_wrapper mrg-aut" style="z-index:4">
        <div class="blnewform_sec1_cont2 f_bold" style="padding: 12px 0 12px 270px;display:none;" id="t9_heading"></div>
        <div id="t9_close_botton" class="cross" onclick="bl_revert(temp9Obj);">X</div>
        <div>
          <div id="t9_eto_ofr_ftr_frm" class="blnewform_sec1 disp-inl vat">
            <div class="blnewform_sec1_cont1">
              <div class="blnewform_sec1_cont1_img blnewform_sprit mrg-aut bgpos1 "></div>
              <div class="blnewform_sec1_cont2 f_bold"> Send Your <br>
                Buy Requirement <span class="f-nrm"> Save time and let us provide you <br>
                with verified contacts </span> </div>
            </div>
            <div class="cont">
              <div id="t9_q_buyer_details2" class="conthd txt-cnt f_bold" style="display:none">Your Contact Details</div>
              <div id="t9_q_buyer_details1" style="display:none" class="cont2">
                <div id="t9_bl_notme"></div>
              </div>
            </div>
          </div>
          <div class="blnewform_sec2 disp-inl">
            <div>
              <form name="t9_eto_footer_form" id="t9_eto_footer_form" onsubmit="return callIfGlobalJSLoaded_isq(temp9Obj, 'checkData_isq');" method="post" action="#" class="f-form">
                <ul class="mrg-aut">
                  <li class="relt margin-btm15" onclick="bl_slideup('t9_q_title','t9_name-l');bl_labeltxt(temp9Obj,'name-l');">
                    <div style=" position:absolute; top:-26px;right:26%;display:none" id="t9_error_title">
                      <div style=" position:relative">
                        <div class="bln-bx">
                          <div id="t9_title_errmsg" data-role="content">Invalid Input</div>
                          <a class="bln-arw" data-role="arrow"></a> </div>
                      </div>
                    </div>
                    <input class="inpt-des t9_input ui-autocomplete-input" type="text" name="q_title" id="t9_q_title" onblur="bl_slidedown('t9_q_title','t9_name-l');bl_labeltextchange(temp9Obj,'name-l');if(this.value != 'Enter product/service name'){return callIfGlobalJSLoaded_isq(temp9Obj, 'checkMcatID');}" onfocus="bl_slideup('t9_q_title','t9_name-l'); bl_labeltxt(temp9Obj,'name-l');" onkeypress="this.style.color='#000';if(document.getElementById('t9_error_title').style.display=='block'){document.getElementById('t9_name-l').className='bl_fr-lb';document.getElementById('t9_error_title').style.display='none';document.getElementById('t9_q_title').className = 'inpt-des t9_input';}" onclick="if(document.getElementById('t9_error_title').style.display=='block'){document.getElementById('t9_name-l').className='bl_fr-lb';document.getElementById('t9_error_title').style.display='none';document.getElementById('t9_q_title').className = 'inpt-des t9_input';}" maxlength="100" autocomplete="off" spellcheck="true" role="textbox" aria-autocomplete="list" aria-haspopup="true">
                    <label class="bl_fr-lb" id="t9_name-l">Enter product/service name</label>
                  </li>
                  <li id="t9_spec_txt" class="det_inf" style="display:none">Specifications: <span class="sub_del">(Detailed information will get you accurate responses)</span></li>
                  <li class="margin-btm15" id="t9_qty_div">
                    <div class="disp-inl wid4">
                      <ul>
                        <!--<li class="form-txt f_bold">Estimated quantity</li>-->
                        <li class="relt" onclick="bl_slideup('t9_q_qty_enrichmt','t9_quan-l')">
                          <div style=" position:absolute; top: -7px;left: -56%;display:none" id="t9_error_qty">
                            <div style=" position:relative">
                              <div class="bln-bx">
                                <div id="t9_qty_errmsg" data-role="content">Please enter <br>
                                  Quantity</div>
                                <a class="bln-arw" style="top: 17px;left:96%;transform:rotate(-404deg);" data-role="arrow"></a> </div>
                            </div>
                          </div>
                          <input type="text" id="t9_q_qty_enrichmt" name="q_qty_enrichmt" class="inpt-des t9_input" onblur="bl_slidedown('t9_q_qty_enrichmt','t9_quan-l')" onfocus="bl_slideup('t9_q_qty_enrichmt','t9_quan-l')" onclick="if(document.getElementById('t9_error_qty').style.display=='block'){document.getElementById('t9_quan-l').className='bl_fr-lb';
                             document.getElementById('t9_error_qty').style.display='none';document.getElementById('t9_q_qty_enrichmt').className = 'inpt-des t9_input'; }" onkeypress="this.style.color='#000';if(document.getElementById('t9_error_qty').style.display=='block'){  document.getElementById('t9_quan-l').className='bl_fr-lb';                document.getElementById('t9_error_qty').style.display='none';document.getElementById('t9_q_qty_enrichmt').className = 'inpt-des t9_input';}">
                          <label class="bl_fr-lb" id="t9_quan-l">Quantity</label>
                        </li>
                      </ul>
                    </div>
                    <div style="margin-left: 26px; vertical-align: top;" class="disp-inl wid4 flt-rgt">
                      <ul>
                        <!--<li class="form-txt f_bold" >Select Unit</li>-->
                        <li class="relt" onclick="bl_slideup('t9_q_qty_list_val','t9_unit-l')">
                          <div style="position:absolute; top: 43px;left:0px;display:none" id="t9_error_qty_unit">
                            <div style=" position:relative">
                              <div class="bln-bx">
                                <div id="t9_qty_unit_msg" data-role="content">Please select Unit for Quantity</div>
                                <a class="bln-arw" style="top: -16%;left: 17%;transform: rotate(225deg);" data-role="arrow"></a> </div>
                            </div>
                          </div>
                          <select class="inpt-des t9_input" id="t9_q_qty_list_val" name="q_qty_list_val" onfocus="bl_slideup('t9_q_qty_list_val','t9_unit-l')" onchange="bl_slideup('t9_q_qty_list_val','t9_unit-l');if(this.value == ''){this.style.color='#acacac';} else {this.style.color='#000000'};if(document.getElementById('t9_error_qty_unit').style.display=='block'){document.getElementById('t9_error_qty_unit').style.display='none';document.getElementById('t9_q_qty_list_val').className = 'inpt-des t9_input'; document.getElementById('t9_unit-l').className = 'bl_fr-lb';	}" onclick="if(document.getElementById('t9_error_qty_unit').style.display=='block'){					  document.getElementById('t9_error_qty_unit').style.display='none';document.getElementById('t9_q_qty_list_val').className = 'inpt-des t9_input';}" onkeypress="bl_slideup('t9_q_qty_list_val','t9_unit-l');if(document.getElementById('t9_error_qty_unit').style.display=='block'){			document.getElementById('t9_error_qty_unit').style.display='none';document.getElementById('t9_q_qty_list_val').className = 'inpt-des t9_input';document.getElementById('t9_unit-l').className = 'bl_fr-lb';	}" onblur="bl_slidedown('t9_q_qty_list_val','t9_unit-l')" style="background-color: transparent;-webkit-appearance: none;-moz-appearance: none;appearance: none;background: transparent url(data:image/gif;base64,R0lGODlhDwAUAIABAH9/f////yH5BAEAAAEALAAAAAAPABQAAAIXjI+py+0Po5wH2HsXzmw//lHiSJZmUAAAOw==) no-repeat 98% 50% !important;outline:none;padding:18px 3px 4px 10px;float:right;line-height:normal;padding-left:2px!important">
                            <option value=""> </option>
                            <option value="Kilogram">Kilogram</option>
                            <option value="Nos">Nos</option>
                            <option value="Pieces">Pieces</option>
                            <option value="Tons">Tons</option>
                            <option value="Units">Units</option>
                            <optgroup label="--Others--"></optgroup>
                            <option value="20' Container">20' Container</option>
                            <option value="40' Container">40' Container</option>
                            <option value="Bags">Bags</option>
                            <option value="Bag">Bag</option>
                            <option value="Barrel">Barrel</option>
                            <option value="Barrels">Barrels</option>
                            <option value="Bottles">Bottles</option>
                            <option value="Boxes">Boxes</option>
                            <option value="Bushel">Bushel</option>
                            <option value="Bushels">Bushels</option>
                            <option value="Cartons">Cartons</option>
                            <option value="Dozens">Dozens</option>
                            <option value="Foot">Foot</option>
                            <option value="Gallon">Gallon</option>
                            <option value="Grams">Grams</option>
                            <option value="Hectare">Hectare</option>
                            <option value="Kilogram">Kilogram</option>
                            <option value="Kilometer">Kilometer</option>
                            <option value="Litre">Litre</option>
                            <option value="Litres">Litres</option>
                            <option value="Long Ton">Long Ton</option>
                            <option value="Meter">Meter</option>
                            <option value="Metric Ton">Metric Ton</option>
                            <option value="Metric Tons">Metric Tons</option>
                            <option value="Nos">Nos</option>
                            <option value="Ounce">Ounce</option>
                            <option value="Packets">Packets</option>
                            <option value="Packs">Packs</option>
                            <option value="Pair">Pair</option>
                            <option value="Pairs">Pairs</option>
                            <option value="Piece">Piece</option>
                            <option value="Pieces">Pieces</option>
                            <option value="Pound">Pound</option>
                            <option value="Reams">Reams</option>
                            <option value="Rolls">Rolls</option>
                            <option value="Sets">Sets</option>
                            <option value="Sheets">Sheets</option>
                            <option value="Short Ton">Short Ton</option>
                            <option value="Square Feet">Square Feet</option>
                            <option value="Square Meters">Square Meters</option>
                            <option value="Tons">Tons</option>
                            <option value="Units">Units</option>
                          </select>
                          <label class="bl_fr-lb" id="t9_unit-l">Select Unit</label>
                        </li>
                      </ul>
                    </div>
                  </li>
                  <li id="t9_q_isq" class="margin-btm15" style="display:none;width:468px"></li>
                  <li class="relt margin-btm15" onclick="bl_slideup('t9_q_desc','t9_area-l');bl_labeltxt(temp9Obj,'area-l');">
                    <div style="padding-top: 18px;" id="t9_desc_div">
                      <textarea class="inpt-des txtarea t9_input" name="q_desc" id="t9_q_desc" onblur="bl_slidedown('t9_q_desc','t9_area-l');bl_labeltextchange(temp9Obj,'area-l')" onfocus="bl_slideup('t9_q_desc','t9_area-l');bl_labeltxt(temp9Obj,'area-l');" style="resize: none; outline:none; height:40px!important; border-left:0px!important;border-bottom: 1px solid rgb(107, 173, 216); padding-top:0px!important"></textarea>
                      <label class="bl_fr-lb" id="t9_area-l" style=" line-height:15px"> Provide any specific details  about : 'Product/Service required', 'Quality', 'Standard', 'Size' etc...</label>
                    </div>
                  </li>
                  <li id="t9_q_contact_dtl1" class="relt" style="display: block;">
                    <div style="padding-left:0px">
                      <div class="flt-lt">
                        <dl id="t9_Country_dropdown" class="dropdown ddp" style=" float: left;    border-bottom: 1px solid rgb(107, 173, 216);    margin: 0px 0px 0px 2px;    padding: 8px 0px 7px 0px;    box-sizing: border-box; -moz-box-sizing: border-box; border-radius: 0px;border-right: 0px; text-align: left;    height: 42px;
    background: #ffffff;" autocomplete="off">
                          <dt><a><span style="background-position:0px -1694px"></span>
                            <div class="as_arrow"></div>
                            </a><span class="value"></span></dt>
                          <dd>
                            <ul class="country_list" style="display: none;">
                              <li class="country_list_item" onclick="javascript:t9_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;91&quot;,&quot;label&quot;:&quot;India  +91&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;India&quot;,&quot;iso&quot;:&quot;IN&quot;,&quot;icon_order&quot;:&quot;154&quot;}})"><span style="background-position:0px -1694px"></span><a>India  +91</a></li>
                              <li class="country_list_item" onclick="javascript:t9_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;1&quot;,&quot;label&quot;:&quot;United States Of America  +1&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;United States Of America&quot;,&quot;iso&quot;:&quot;US&quot;,&quot;icon_order&quot;:&quot;4&quot;}})"><span style="background-position:0px -44px"></span><a>United States Of America  +1</a></li>
                              <li class="country_list_item" onclick="javascript:t9_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;971&quot;,&quot;label&quot;:&quot;United Arab Emirates  +971&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;United Arab Emirates&quot;,&quot;iso&quot;:&quot;AE&quot;,&quot;icon_order&quot;:&quot;202&quot;}})"><span style="background-position:0px -2222px"></span><a>United Arab Emirates  +971</a></li>
                              <li class="country_list_item" onclick="javascript:t9_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;44&quot;,&quot;label&quot;:&quot;United Kingdom  +44&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;United Kingdom&quot;,&quot;iso&quot;:&quot;GB&quot;,&quot;icon_order&quot;:&quot;5&quot;}})"><span style="background-position:0px -55px"></span><a>United Kingdom  +44</a></li>
                              <li class="country_list_item" onclick="javascript:t9_bl_onSelect_countryISO(event,{&quot;value&quot;:&quot;61&quot;,&quot;label&quot;:&quot;Australia  +61&quot;,&quot;data&quot;:{&quot;cname&quot;:&quot;Australia&quot;,&quot;iso&quot;:&quot;AU&quot;,&quot;icon_order&quot;:&quot;156&quot;}})"><span style="background-position:0px -1716px"></span><a>Australia  +61</a></li>
                              <li class="showmore"><a onclick="Suggester({&quot;type&quot;:&quot;isd&quot;,&quot;element&quot;:&quot;t9_Country_dropdown&quot;,fields: &quot;cname,iso,icon_order&quot;,displayFields:&quot;cname,value&quot;,displaySeparator:&quot;  +&quot;,&quot;defaultValue&quot;:&quot;IN&quot;,&quot;showmore&quot; : &quot;false&quot;,&quot;onSelect&quot;:t9_bl_onSelect_countryISO});return;">Show More</a></li>
                            </ul>
                          </dd>
                        </dl>
                      </div>
                      <div id="t9_indian_user" style="display: block;">
                        <div style=" position:absolute; top:4px; left: 250px;display:none" id="t9_error_mob">
                          <div style=" position:relative">
                            <div class="bln-bx">
                              <div id="t9_mob_errmsg" data-role="content">Invalid  Mobile Number</div>
                              <a class="bln-arw" style="top: 9px;left: -4px; transform: rotate(-230deg);" data-role="arrow"></a> </div>
                          </div>
                        </div>
                        <div class="flt-lt">
                          <input type="text" value="" readonly name="iso" id="t9_iso" style="float: left; border: 0px!important; padding-top: 0px!important; border-radius:0px; text-align: center; background: #eeeaea; border-bottom: 1px solid rgb(107, 173, 216)!important; width:60px; height:42px; box-sizing:border-box" tabindex="-1" disabled="">
                        </div>
                        <div class="relt flt-lt" onclick="bl_slideup('t9_q_mobile','t9_mob-l')">
                          <input type="text" name="q_mobile" id="t9_q_mobile" class="inpt-des int-spc disp-inl t9_input" maxlength="15" onkeypress="if(document.getElementById('t9_error_mob').style.display=='block'){	document.getElementById('t9_mob-l').className = 'bl_fr-lb';				  document.getElementById('t9_error_mob').style.display='none';document.getElementById('t9_q_mobile').className = 'inpt-des int-spc disp-inl t9_input';};return isNumberKey(event);this.style.color='#000';" style="width:351px !important; box-sizing:border-box; float:left;  border-radius:0px; margin-top:0px; border-top-right-radius:3px;border-bottom-right-radius:3px;height:42px; padding-left:2px!mportant; padding-left:2px!important" onblur="bl_slidedown('t9_q_mobile','t9_mob-l')" onclick="if(document.getElementById('t9_error_mob').style.display=='block'){					  document.getElementById('t9_error_mob').style.display='none';document.getElementById('t9_mob-l').className = 'bl_fr-lb';	document.getElementById('t9_q_mobile').className = 'inpt-des int-spc disp-inl t9_input';}" onfocus="bl_slideup('t9_q_mobile','t9_mob-l')">
                          <label class="bl_fr-lb" id="t9_mob-l" style="left:2px">Mobile Number</label>
                        </div>
                      </div>
                      <div id="t9_forgien_user" style="display: none;">
                        <div style=" position:absolute; top: 4px;left: 250px;display:none" id="t9_error_email">
                          <div style=" position:relative">
                            <div class="bln-bx">
                              <div id="t9_email_errmsg" data-role="content">Invalid E-mail ID</div>
                              <a class="bln-arw" style="top: 9px;left: -4px; transform: rotate(-230deg)" data-role="arrow"></a> </div>
                          </div>
                        </div>
                        <div class="relt flt-lt" onclick="bl_slideup('t9_q_email','t9_email-l')">
                          <input type="text" name="q_email" id="t9_q_email" class="inpt-des int-spc disp-inl t9_input" onkeypress="if(document.getElementById('t9_error_email').style.display=='block'){document.getElementById('t9_email-l').className = 'bl_fr-lb';document.getElementById('t9_error_email').style.display='none';document.getElementsByName('q_email').className = 'inpt-des int-spc disp-inl t9_input';document.getElementById('t9_q_email').classList.remove('highlight-err');}" onclick="if(document.getElementById('t9_error_email').style.display=='block'){document.getElementById('t9_email-l').className = 'bl_fr-lb';document.getElementById('t9_error_email').style.display='none';document.getElementsByName('q_email').className = 'inpt-des int-spc disp-inl t9_input';document.getElementById('t9_q_email').classList.remove('highlight-err');}" style="width:412px;height:42px;vertical-align:top; padding-left:2px!important" onfocus="bl_slideup('t9_q_email','t9_email-l')" onblur="bl_slidedown('t9_q_email','t9_email-l');if(this.value!='Email'){callIfGlobalJSLoaded_isq(temp9Obj,'displayVal');}">
                          <label class="bl_fr-lb" id="t9_email-l" style="left:2px">Email ID</label>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li id="t9_contact_foreign" class="relt" style="display:none; clear:both">
                    <div style=" position:absolute; top: 4px;left: 250px;display:none" id="t9_error_first_name">
                      <div style=" position:relative">
                        <div class="bln-bx">
                          <div id="t9_fname_errmsg" data-role="content">Kindly enter full name</div>
                          <a class="bln-arw" style="top: 9px;left: -4px; transform: rotate(-230deg)" data-role="arrow"></a> </div>
                      </div>
                    </div>
                    <div onclick="bl_slideup('t9_q_first_name','t9_for-name-l')" class="relt flt-lt" style="width:100%">
                      <input type="text" name="q_first_name" id="t9_q_first_name" value="" onfocus="bl_slideup('t9_q_first_name','t9_for-name-l')" onblur="bl_slidedown('t9_q_first_name','t9_for-name-l')" onclick="if(document.getElementById('t9_error_first_name').style.display=='block'){		document.getElementById('t9_error_first_name').style.display='none';document.getElementById('t9_for-name-l').className = 'bl_fr-lb';document.getElementById('t9_q_first_name').className = 'inpt-des t9_input';}" onkeypress="if(document.getElementById('t9_error_first_name').style.display=='block'){document.getElementById('t9_for-name-l').className = 'bl_fr-lb';	document.getElementById('t9_error_first_name').style.display='none';document.getElementById('t9_q_first_name').className = 'inpt-des t9_input';}" class="inpt-des t9_input" style="padding-left:2px">
                      <label id="t9_for-name-l" class="bl_fr-lb" style="left:1px"> Full Name </label>
                    </div>
                    <div class="clr-b"></div>
                  </li>
                  <li class="hgt2 clr-b">&nbsp;</li>
                  <li style="position:relative">
                    <input type="submit" value="Submit Your Requirement" class="form-btn f_bold">
                  </li>
                </ul>
                <input name="q_post" value="Send Your Buy Requirement" type="hidden">
                <input name="q_country_iso" value="IN" type="hidden" id="t9_q_country_iso">
                <input name="q_country" value="IN" type="hidden">
                <input name="q_city" value="" type="hidden">
                <input name="q_state_others" value="" type="hidden">
                <input name="q_state" value="" type="hidden">
                <input type="hidden" name="q_country_name" value="India">
                <input type="hidden" name="q_ph_country1" value="+91">
                <input type="hidden" name="q_type" value="B">
                <input type="hidden" name="q_category" value="759">
                <input type="hidden" name="q_mcat" value="121185">
                <input type="hidden" name="q_modid" value="DIR">
                <input type="hidden" name="q_page_referrer" value="">
                <input type="hidden" name="q_updatedusing" value="Buyers Enquiry Form">
                <input type="hidden" name="afflid" value="-9">
                <input name="q_utyp" value="" type="hidden">
                <input name="q_imurl" value="" type="hidden">
                <input type="hidden" value="" name="q_qty">
                <input type="hidden" value="" name="q_qty_list_val1">
                <input type="hidden" value="" name="q_vd11">
                <input type="hidden" value="" name="q_comp_name">
                <input type="hidden" value="" name="q_website">
                <input type="hidden" value="0" name="bl_is_usr_flg">
                <input type="hidden" value="1" name="q_offrid" id="t9_q_offrid">
                <input type="hidden" value="" name="q_city_others" id="t9_q_city_others">
              </form>
            </div>
          </div>
          <div class="blnewform_sec3 disp-inl">
            <ul class="ben-form mrg-aut">
              <li>
                <div class="blnewform_sprit benefit1 bl_wid mrg-aut"></div>
                <div class="txt-cnt">Convenient</div>
              </li>
              <li class="hgt2"></li>
              <li>
                <div class="blnewform_sprit benefit2 bl_wid mrg-aut"></div>
                <div class="txt-cnt">Competitive<br>
                  Quotes</div>
              </li>
              <li class="hgt2"></li>
              <li>
                <div class="blnewform_sprit benefit3 bl_wid mrg-aut"></div>
                <div class="txt-cnt">Choice of <br>
                  Suppliers</div>
              </li>
            </ul>
            <div style="clear:both">&nbsp;</div>
          </div>
        </div>
        <div id="t9_q_send_req_loading" style="height:100%;position: absolute;top:0px;width: 100%;display: none;z-index: 999;">
          <div style="width: 906px;margin:0 auto;height: 100%;background: #fff;opacity: 0.7;">
            <div class="blloader"></div>
          </div>
        </div>
      </div>
      <div class="clr-b"></div>
    </div>
  </div>
  <div id="t9_enrichform_maindiv" style="display:none;"></div>
  <span id="t9_q_lead_enrichment"></span> <span id="t9_q_lead_conversion"></span> <span id="t9_q_lead_impressionload"></span> <!--HEADER COMPLETED TIME: 1.3224--><!--NewImpcat package calling start: 1.3225 --><!--NewImpcat package calling end: 1.3226 -->
  <div id="scroll_bl" class="obl" style="padding:0 0 15px 0px"> <script type="text/javascript">
			new BLForm({ tempID:"20", customHeadline:"", mcatName:"LED Panel Light",mcatID:"121185",catID:"759",afflID:"",modID:"DIR"});
			</script>
    <div class="wl-list0" id="t20_maindiv">
      <form name="t20_eto_bl_form" id="t20_eto_bl_form" method="post" onsubmit="return callIfGlobalJSLoaded_isq(temp20Obj, 'checkData_isq');" action="#" style="margin-bottom:4px">
        <div class="arrow">
          <div class="heading">What do you want to buy</div>
        </div>
        <div style=" width:559px" class="flt-lt">
          <table width="100%" cellspacing="0" cellpadding="0">
            <tbody>
              <tr>
                <td id="t20_tdwidth"><div class="relt flt-lt" style="margin-left:20px;margin-top:5px; width:100%; min-width:160px" onclick="bl_slideup('t20_q_title','t20_name-l'); bl_labeltxt(temp20Obj,'name-l')">
                    <div style=" position:absolute;top:46px;left:23%;display:none" name="error_title" id="t20_error_title">
                      <div style=" position:relative">
                        <div class="bln-bx">
                          <div id="t20_title_errmsg" data-role="content">Invalid Input</div>
                          <a class="bln-arw" style="top: -21%;left: 17%;transform: rotate(-494deg);" data-role="arrow"></a> </div>
                      </div>
                    </div>
                    <input type="text" class="prodfcp t20_input ui-autocomplete-input" name="q_title" id="t20_q_title" onblur="bl_slidedown('t20_q_title','t20_name-l');bl_labeltextchange(temp20Obj,'name-l')" onfocus="bl_slideup('t20_q_title','t20_name-l'); bl_labeltxt(temp20Obj,'name-l')" value="" style="line-height:1;  margin-left:0px; padding-top:10px!important" onclick="if(document.getElementById('t20_error_title').style.display=='block'){					  document.getElementById('t20_error_title').style.display='none';document.getElementById('t20_q_title').className = 'prodfcp t20_input';document.getElementById('t20_name-l').className = 'bl_fr-lb';}" onkeypress="if(document.getElementById('t20_error_title').style.display=='block'){document.getElementById('t20_q_title').className = 'prodfcp t20_input';	document.getElementById('t20_name-l').className = 'bl_fr-lb';			  document.getElementById('t20_error_title').style.display='none';document.getElementById('t20_name-l').className = 'bl_fr-lb';}" spellcheck="true" autocomplete="off" role="textbox" aria-autocomplete="list" aria-haspopup="true">
                    <label for="t20_name-l" class="bl_fr-lb" id="t20_name-l">Enter product/service name</label>
                  </div></td>
                <td style="float:right"><div id="t20_q_contact_dtl1" class="flt-lt" style="display: block;">
                    <dl style="float: left; border-bottom: 1px solid rgb(107, 173, 216);margin: 7px 0px 0px 4px;padding:10px 0px 0px 6px; background: #f5f5f5; height:38px; box-sizing:border-box" id="t20_Country_dropdown" class="dropdown" autocomplete="off">
                      <dt><a><span style="background-position:0px -1694px"></span>
                        <div class="as_arrow"></div>
                        </a><span class="value"></span></dt>
                      <dd>
                        <ul class="country_list" style="display: none;">
                          <li class="country_list_item" ><span style="background-position:0px -1694px"></span><a>India  +91</a></li>
                          <li class="country_list_item" ><span style="background-position:0px -44px"></span><a>United States Of America  +1</a></li>
                          <li class="country_list_item" ><span style="background-position:0px -2222px"></span><a>United Arab Emirates  +971</a></li>
                          <li class="country_list_item" ><span style="background-position:0px -55px"></span><a>United Kingdom  +44</a></li>
                          <li class="country_list_item" ><span style="background-position:0px -1716px"></span><a>Australia  +61</a></li>
                          <li class="showmore"><a href="">Show More</a></li>
                        </ul>
                      </dd>
                    </dl>
                    <div id="t20_indian_user" style="display:block;" class="relt flt-lt">
                      <input type="text" class="iso_code" disabled="" value="" id="t20_iso" name="iso" readonly>
                      <div style=" position:absolute; top: 52px;left: 42%;display:none" name="error_mob" id="t20_error_mob">
                        <div style=" position:relative">
                          <div class="bln-bx">
                            <div id="t20_mob_errmsg" data-role="content">Invalid Mobile Number</div>
                            <a class="bln-arw" style="top:-21%;left: 17%;transform: rotate(-494deg);" data-role="arrow"></a> </div>
                        </div>
                      </div>
                      <div onclick="bl_slideup('t20_q_mobile','t20_mob-l')" class="relt flt-lt" style="margin-top:5px">
                        <input type="text" name="q_mobile" id="t20_q_mobile" class="mobfcp t20_input" onfocus="bl_slideup('t20_q_mobile','t20_mob-l')" onkeypress="if(document.getElementById('t20_error_mob').style.display=='block'){document.getElementById('t20_mob-l').className = 'bl_fr-lb';				  document.getElementById('t20_error_mob').style.display='none';document.getElementById('t20_q_mobile').className = 'mobfcp t20_input';};return isNumberKey(event);" style="line-height:100%!important;width:110px;margin-left:-1px; padding-left:2px!important; border-left:0px;padding-top: 10px !important; outline:none; background-color:transparent!important " onclick="if(document.getElementById('t20_error_mob').style.display=='block'){					  document.getElementById('t20_error_mob').style.display='none';document.getElementById('t20_q_mobile').className = 'mobfcp t20_input';document.getElementById('t20_mob-l').className = 'bl_fr-lb';}" onblur="bl_slidedown('t20_q_mobile','t20_mob-l');" value="" maxlength="15">
                        <label for="t20_mob-l" class="bl_fr-lb" id="t20_mob-l" style="left:2px">Mobile Number</label>
                      </div>
                    </div>
                    <div id="t20_forgien_user" style="display:none; margin-left:-2px!important; float:right; margin-top:5px">
                      <div style=" position:absolute; top:51px;left: 54%;display:none" name="error_email" id="t20_error_email">
                        <div style=" position:relative">
                          <div class="bln-bx">
                            <div id="t20_email_errmsg" data-role="content">Invalid E-mail ID</div>
                            <a class="bln-arw" style="top:-21%;left: 17%;transform: rotate(-494deg);" data-role="arrow"></a> </div>
                        </div>
                      </div>
                      <div onclick="bl_slideup('t20_q_email','t20_email-l')" class="relt flt-lt">
                        <input type="text" name="q_email" id="t20_q_email" class="mobfcp t20_input" onfocus="bl_slideup('t20_q_email','t20_email-l')" onclick="if(document.getElementById('t20_error_email').style.display=='block'){document.getElementById('t20_error_email').style.display='none';document.getElementsByName('q_email').className = 'mobfcp t20_input';document.getElementById('t20_email-l').className = 'bl_fr-lb';document.getElementById('t20_q_email').classList.remove('highlight-err2');}" onkeypress="if(document.getElementById('t20_error_email').style.display=='block'){document.getElementById('t20_error_email').style.display='none';document.getElementsByName('q_email').className = 'mobfcp t20_input';document.getElementById('t20_email-l').className = 'bl_fr-lb';document.getElementById('t20_q_email').classList.remove('highlight-err2');}" style="color:#aaaaaa;line-height:100%!important ; width:134px;margin-left:-1px; padding-left:2px!important; padding-top:10px!important" onblur="bl_slidedown('t20_q_email','t20_email-l');if (this.value=='') {};if(this.value!='Email'){callIfGlobalJSLoaded_isq(temp20Obj,'displayVal');}" value="">
                        <label for="t20_email-l" class="bl_fr-lb" id="t20_email-l" style="left:2px">Email ID</label>
                      </div>
                      <div class="relt flt-lt" style="margin-left:10px">
                        <div style=" position:absolute; top: 44px;left: 30%;display:none" name="error_first_name" id="t20_error_first_name">
                          <div style=" position:relative">
                            <div class="bln-bx">
                              <div id="t20_fname_errmsg" data-role="content">Please enter Name</div>
                              <a class="bln-arw" style="left: 10%;top: -6px;
    transform: rotate(-133deg);" data-role="arrow"></a> </div>
                          </div>
                        </div>
                        <div onclick="bl_slideup('t20_q_first_name','t20_for-name-l')">
                          <input type="text" name="q_first_name" id="t20_q_first_name" value="" onfocus="bl_slideup('t20_q_first_name','t20_for-name-l')" onblur="bl_slidedown('t20_q_first_name','t20_for-name-l')" onclick="if(document.getElementById('t20_error_first_name').style.display=='block'){		document.getElementById('t20_error_first_name').style.display='none';document.getElementById('t20_q_first_name').className = 'mobfcp t20_input';document.getElementById('t20_for-name-l').className = 'bl_fr-lb';}" onkeypress="if(document.getElementById('t20_error_first_name').style.display=='block'){		document.getElementById('t20_error_first_name').style.display='none';document.getElementById('t20_q_first_name').className = 'mobfcp t20_input';document.getElementById('t20_for-name-l').className = 'bl_fr-lb';}" class="mobfcp t20_input" style="border-left:1px solid #ccc; width:145px">
                          <label id="t20_for-name-l" class="bl_fr-lb" name="t20_for-name-l" style="left:0px">Full Name</label>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="cntct-info-div" id="t20_q_buyer_details1" style="display:none; float:right">
                    <div class="cntct-detail">
                      <div class="blstrip-mbwrapper"> <span class="blstrip-mn blstrip-muser" id="muser_span" style="display:none"></span> <span style="display: none; float: left;" id="t20_q_buyer_details2"></span></div>
                      <div class="t20_clb"></div>
                      <div class="blstrip-mbwrapper"> <span class="blstrip-mn blstrip-mbic" id="muser_mobile" style="display:none"></span> <span id="t20_q_buyer_details4" style="display: none; float: left;"></span> </div>
                      <div class="blstrip-mbwrapper"> <span class="blstrip-mn blstrip-memail" id="muser_email" style="display:none"></span> <span id="t20_q_buyer_details3" style="display:none;float:left;"></span> </div>
                      <div id="t20_bl_notme" class="cntct-div-nt" onclick="bl_notme(temp20Obj);"><!--Not me--></div>
                    </div>
                  </div></td>
              </tr>
              <tr> </tr>
            </tbody>
          </table>
        </div>
        <div class="flt-rgt">
          <input type="submit" class="bl_btn" value="Submit Buy Request" style="margin-left:10px; margin-top:8px;  margin-right:6px">
        </div>
        <input name="q_post" value="Send Your Buy Requirement" type="hidden">
        <input name="q_country_iso" value="IN" type="hidden" id="t20_q_country_iso">
        <input name="q_country" value="IN" type="hidden">
        <input name="q_city" value="" type="hidden">
        <input name="q_state_others" value="" type="hidden">
        <input name="q_state" value="" type="hidden">
        <input type="hidden" name="q_type" value="B">
        <input type="hidden" name="q_category" value="759">
        <input type="hidden" name="q_mcat" value="121185">
        <input type="hidden" name="q_modid" value="DIR">
        <input type="hidden" name="q_page_referrer" value="">
        <input type="hidden" name="q_updatedusing" value="Buyers Enquiry Form">
        <input type="hidden" name="afflid" value="-33">
        <input name="q_utyp" value="" type="hidden">
        <input name="q_imurl" value="" type="hidden">
        <input type="hidden" value="" name="q_qty">
        <input type="hidden" value="" name="q_qty_list_val1">
        <input type="hidden" value="" name="q_vd11">
        <input type="hidden" value="" name="q_comp_name">
        <input type="hidden" value="" name="q_website">
        <input type="hidden" value="0" name="bl_is_usr_flg">
        <input type="hidden" value="1" name="q_offrid" id="t20_q_offrid">
        <input type="hidden" name="q_country_name" value="India" id="t20_q_country_name">
        <input type="hidden" name="q_ph_country1" value="+91" id="t20_q_ph_country1">
        <input type="hidden" name="q_city_others" value="" id="t20_q_city_others">
        <input type="hidden" name="template_name" value="t20_eto_footer_form_enrichmt" id="t20_template_name">
      </form>
    </div>
    <div id="t20_q_send_req_loading" style="background: rgba(255, 255, 255, 0.5) none repeat scroll 0% 0%; height: 100%; width: 100%; display: none; z-index: 99; position: relative; top: -74px;">
      <div class="blloader"></div>
    </div>
    <div class="t20_clb"></div>
  </div>
  <!--   Breadcrumb starts here  -->
  <div class="brds">
    <div class="brd brd_m">
      <ul>
        <!-- Groups start-->
        <li class="ar_w"><a href="" target="_top"><span itemprop="title"><span style="display:none;">Business Directory</span><img class="h_img bg nr" alt="dot" src="images/z.gif" style="padding-right: 5px;"></span></a></li>
        <!-- Mcats start-->
        <li class="ar_w"><a itemprop="url" href="" target="_top" id="mcat"><span itemprop="title">Interior and Exterior Lighting</span></a></li>
        <!-- Mcats end-->
        <li style="border:none; color:#444; font-weight:bold"><span class="ar_w">LED Panel Light</span></li>
      </ul>
      <p style="padding:0; margin:0; clear:both"> </p>
    </div>
    <p style="clear:both"> </p>
  </div>
  <div class="msec ">
    <div class="wl_l "> 
      <script type="text/javascript"> ims.grid_view=1;
		ims.grid_class="bg listIcon";
		//ims.tooltip_msg="txt-list";
		ims.grid_text='Grid View';
		ims.curr_state='grv';
		var new_Cookie = new userDataCookie();
                var pv = new_Cookie.get('xnHist').pv || 0;
                var cty= new_Cookie.get('xnHist').city || '';
                var set_obj = {
                       'city': cty,
                        'pv' : pv,
                        'cvstate' : ims.curr_state
                        };
               new_Cookie.set(set_obj, 'xnHist');
		</script> <script type="text/javascript">
var new_Cookie = new userDataCookie();
               var pv = new_Cookie.get('xnHist').pv || 0;
               var cty= new_Cookie.get('xnHist').city || '';
               var set_obj = {
                       'city': cty,
                        'pv' : pv,
                        'cvstate' : ims.curr_state
                        };
               new_Cookie.set(set_obj, 'xnHist');
       </script><!-- google_ad_section_start -->
      <div class="bgw t-con bxs">
        <div class="ctyt">
          <p class="fl_w fr" style="color: #666666;font-family: Tahoma;font-size: 13px;padding: 2px 5px 0 3px;">4588 Products Available</p>
          <div class="sh-dv">
            <h1>LED Panel Light from India</h1>
          </div>
        </div>
        <p style="clear:both"></p>
        <div class="rfch"> <!--  Starting Div  -->
          <form method="post" style="float: right;">
            <div style="float: right;padding-top:5px;padding-right:5px;margin-top: 3px;">
              <input type="text" name="city_ss" id="txt-city" class="srin ui-autocomplete-input">
              <div class="srl bg"> </div>
            </div>
            <input type="image" src="images/z.gif" alt="dot" id="city_sugg">
          </form>
          <div style="width: 500px; overflow: hidden; float: left; height: 25px; margin-bottom: 5px; margin-top: 5px;">
            <ul>
              <li style="color:#C94105;font-weight: bold;font-size:13px;">All India</li>
              <li> <a title="LED Panel Light in Delhi" href="">Delhi</a> </li>
              <li> <a title="LED Panel Light in Mumbai" href="">Mumbai</a> </li>
              <li> <a title="LED Panel Light in Chennai" href="">Chennai</a> </li>
              <li> <a title="LED Panel Light in Pune" href="">Pune</a> </li>
              <li> <a title="LED Panel Light in Ahmedabad" href="">Ahmedabad</a> </li>
              <li> <a title="LED Panel Light in Surat" href="">Surat</a> </li>
            </ul>
          </div>
          <p class="m2"></p>
          <div class="rfbl">
            <ul>
              <span style="color: rgb(150, 44, 3);letter-spacing: 0.4px; font-weight:bold; font-size:12px;"></span>
              <li> <a href="">Manufacturer </a></li>
              <li> <a href="">Wholesaler </a></li>
              <li> <a href="">Retailer </a></li>
              <li> <a href="">Exporter </a></li>
            </ul>
            <p class="m2"></p>
          </div>
          <span class="r-pr">
          <input type="checkBox" id="pcheck" value="2">
          <label for="pcheck">With Price</label>
          </span> </div>
      </div>
      <div class="clear1"></div>
    </div>
    <div style="position: relative;width: 300px;float: left;margin-left: 14px;height: 95px;margin-bottom: 10px;">
      <div class="prdm bgw bxs recentSupplier mh ">
        <div class="ppm2">
          <div class="k9 g9 e4">
            <ul id="rc">
              <li><span class="bg"></span><a class="rcwr" style="padding: 0px; font-weight: 700;" title="Square Panel Light" href="">Square Panel Light</a></li>
              <li><span class="bg"></span><a class="rcwr" style="padding: 0px; font-weight: 700;" title="Round LED Light" href="">Round LED Light</a></li>
              <li><span class="bg"></span><a class="rcwr" style="padding: 0px; font-weight: 700;" title="Round Panel Light" href="">Round Panel Light</a></li>
              <li><span class="bg"></span><a class="rcwr" style="padding: 0px; font-weight: 700;" title="LED Downlight" href="">LED Downlight</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript"> 
                        var relatedLineCnt=0;
                        var relCntJs=1;
                        var ctrMoreMcat=0;
for(relCntJs = 1; relCntJs <= 4; relCntJs++)
{
        
        if($(".prdm ul li:nth-child("+relCntJs+")").height() > 26 )
        {
            var tempHeight=$(".prdm ul li:nth-child("+relCntJs+")").height();
            relatedLineCnt +=1 ;
            tempHeight=tempHeight-26;
            relatedLineCnt += tempHeight/20 ;
        }
        else if($(".prdm ul li:nth-child("+relCntJs+")").height() > 0)
        {
            relatedLineCnt +=1 ;
        }
        else
        {
             break;
        }
        
        if(relatedLineCnt>4)
        {
            var j=1;
            
            if(tempHeight > 0 && ctrMoreMcat==0 )
            {
               $("#moreMcat").html("<span class='mmor'><div class='fd_ar'><span></span></div></span>");
               ctrMoreMcat++;
            }
            for(j = relCntJs; j <= 4; j++)
            {
                $(".prdm ul li:nth-child("+j+")").addClass('cth');
            }
            break;
        } 
}
if($(".prdm ul li:nth-child(5)").height() > 0 )
{
     $("#moreMcat").html("<span class='mmor'><div class='fd_ar'><span></span></div></span>");
}
</script>
    <div class="wlm   ">
      <div id="container-slider2" style="width:1000px;margin:10px 0;float:left" class="econ">
        <div id="list-container" class="e-ad">
          <div class="list-impcat">
            <div class="rlink"><span style="float: left">Buy <a target="_blank" href="">Brackets</a> on</span></div>
            <div> <a class="unit item" target="_blank" href="#">
              <div class="imgc"> <img data-original="images/cfl.jpg" src="images/cfl.jpg" alt="ads"> </div>
              <span class="title" title="Forus 12W LED Slim Panel Light Round">Forus 12W LED Slim Panel Light Round</span>
              <div class="prc" style="height:22px;">Rs 555</div>
              <div class="ecom-container on"> <span class="grbtn">Buy Now</span> </div>
              </a> <a class="unit item" target="_blank" href="#">
              <div class="imgc"> <img data-original="images/cfl.jpg" src="images/cfl.jpg" alt="ads"> </div>
              <span class="title" title="Forus 12W LED Slim Panel Light Round">Forus 12W LED Slim Panel Light Round</span>
              <div class="prc" style="height:22px;">Rs 555</div>
              <div class="ecom-container on"> <span class="grbtn">Buy Now</span> </div>
              </a> <a class="unit item" target="_blank" href="#">
              <div class="imgc"> <img data-original="images/cfl.jpg" src="images/cfl.jpg" alt="ads"> </div>
              <span class="title" title="Forus 12W LED Slim Panel Light Round">Forus 12W LED Slim Panel Light Round</span>
              <div class="prc" style="height:22px;">Rs 555</div>
              <div class="ecom-container on"> <span class="grbtn">Buy Now</span> </div>
              </a> <a class="unit item" target="_blank" href="#">
              <div class="imgc"> <img data-original="images/cfl.jpg" src="images/cfl.jpg" alt="ads"> </div>
              <span class="title" title="Forus 12W LED Slim Panel Light Round">Forus 12W LED Slim Panel Light Round</span>
              <div class="prc" style="height:22px;">Rs 555</div>
              <div class="ecom-container on"> <span class="grbtn">Buy Now</span> </div>
              </a> <a class="unit item" target="_blank" href="#">
              <div class="imgc"> <img data-original="images/cfl.jpg" src="images/cfl.jpg" alt="ads"> </div>
              <span class="title" title="Forus 12W LED Slim Panel Light Round">Forus 12W LED Slim Panel Light Round</span>
              <div class="prc" style="height:22px;">Rs 555</div>
              <div class="ecom-container on"> <span class="grbtn">Buy Now</span> </div>
              </a> <a class="unit item" target="_blank" href="#">
              <div class="imgc"> <img data-original="images/cfl.jpg" src="images/cfl.jpg" alt="ads"> </div>
              <span class="title" title="Forus 12W LED Slim Panel Light Round">Forus 12W LED Slim Panel Light Round</span>
              <div class="prc" style="height:22px;">Rs 555</div>
              <div class="ecom-container on"> <span class="grbtn">Buy Now</span> </div>
              </a> <a class="unit item" target="_blank" href="#">
              <div class="imgc"> <img data-original="images/cfl.jpg" src="images/cfl.jpg" alt="ads"> </div>
              <span class="title" title="Forus 12W LED Slim Panel Light Round">Forus 12W LED Slim Panel Light Round</span>
              <div class="prc" style="height:22px;">Rs 555</div>
              <div class="ecom-container on"> <span class="grbtn">Buy Now</span> </div>
              </a> <a class="unit item" target="_blank" href="#">
              <div class="imgc"> <img data-original="images/cfl.jpg" src="images/cfl.jpg" alt="ads"> </div>
              <span class="title" title="Forus 12W LED Slim Panel Light Round">Forus 12W LED Slim Panel Light Round</span>
              <div class="prc" style="height:22px;">Rs 555</div>
              <div class="ecom-container on"> <span class="grbtn">Buy Now</span> </div>
              </a> </div>
          </div>
        </div>
      </div>
      <div id="LST1" data-dispid="8990671588" data-glid="696155" data-csttypwgt="149" data-csttypnm="LEADER" data-city="Noida" data-state="Uttar Pradesh" class="lst llc lst    img">
        <ul>
          <li>
            <div class="ldf"><a onmouseover="title_show(this)" class="pnm" href="" target="_blank">6W Circular Slim LED Panel Light</a></div>
            <div class="ribn "><a id="1imgenq" class="NP-1">
              <div class="bg rib"></div>
              <div class="ld_i imwd"><img alt="6w circular slim led panel light" id="bu1" src="images/led-flat.jpg" data-limg="images/led-flat.jpg"></div>
              <span class="nat bst"></span></a></div>
            <div class="lstw">
              <div class="ldc">
                <p id="trimmed_desc1" class="desc des_p">We offer 6W slim LED panel lights in circular shapes as per following specifications:<br>
                  Bright light<br>
                  White and cool white colors available<br>
                  Life - 50000 hrs.<br>
                  Very high efficiency &gt; 90%<br>
                  Very high<a href="#" class="wh mlin">more..</a></p>
              </div>
            </div>
          </li>
          <li class="spro">
            <div class="nsim"><span> <img id="rp1_1" data-slimg="images/led-small.jpg" data-prc="" src="images/led-small.jpg" alt="3W Circular Slim LED Panel Light" title="3W Circular Slim LED Panel Light"></span></div>
            <div class="nsim"><span><img id="rp1_2" data-slimg="images/led-small.jpg" data-prc="" src="images/led-small.jpg" alt="12W Circular Slim LED Panel Lights" title="12W Circular Slim LED Panel Lights"></span></div>
            <div class="nsim"><span><img id="rp1_3" data-slimg="images/led-small.jpg" data-prc="" src="images/led-small.jpg" alt="18W Circular Slim LED Panel Lights" title="18W Circular Slim LED Panel Lights"></span></div>
          </li>
        </ul>
        <div class="nes">
          <p class="cmcl"><span class="cnm"> <span itemprop="name" class="lcname"><a onclick="recordOutboundLink(this, 'LEADER', 'Pos1-Website',0,0);getInterestRecord({'modreftypflag':'2', 'displayId':'8990671588', 'modid':'DIR', 'R_glusr_id':'696155','mcat_id':'121185'});" href="http://www.protonicsystems.com/" target="_blank">Protonics Systems India Private Limited</a></span><span class="vcom"></span> <span class="td t_v cur" style="display:inline-block;" onmouseover="showTTip('tool-tip_n1');" onmouseout="hideTTip('tool-tip_n1')"><span class="ttl wd2 doff" id="tool-tip_n1"><span class="twrw"><span></span></span><span class="t_ts">&nbsp;</span></span><span class="bg t_se"></span></span></span></p>
          <span class="clg" onmouseover="showcityTTip('citytt1');" onmouseout="hidecityTTip('citytt1');" data-rlocation="Sector 81">Sector 81, Noida<span class="srad cty-t" id="citytt1"><span class="on" itemprop="streetAddress">C-45, Sector 81, Phase 2, </span><span class="ct_l" itemprop="addressLocality">Noida</span><span>- </span><span itemprop="postalCode">201305</span><span>, </span><span itemprop="addressRegion">Uttar Pradesh</span></span></span></div>
        <div class="hlb"><span class="ls_co phn">
          <input type="hidden" id="pnsh1" value="08079453345">
          <span itemprop="telephone" id="pns1">08079453345</span></span></div>
        <p class="senq"><span id="1dispid8990671588" class="bp btn2g td NP-1">Send Enquiry</span></p>
      </div>
      <div id="LST2" data-dispid="13643681155" data-glid="12732472" data-csttypwgt="199" data-csttypnm="TSCATALOG" data-city="Noida" data-state="Uttar Pradesh" class="lst nlc mft grd mstar ws img">
        <ul>
          <li>
            <div class="ldf"><a onmouseover="title_show(this)" class="pnm" href="" target="_blank">LED Flat Panel Opal</a></div>
            <div class="ribn "><a id="2imgenq" class="NP-2">
              <div class="bg rib"></div>
              <div class="nor_i imwd"><img alt="led flat panel opal" id="bu2" src="images/led-flat.jpg" data-limg="images/led-flat.jpg"></div>
              <span class="nat bst"></span></a></div>
            <div class="lstw">
              <div class="ldc">
                <p id="trimmed_desc2" class="desc des_p">Specification:<br>
                  LED Flat Panel Opal highly energy efficient 2’X2’ LED flat panel is specially designed with long lasting LED source with high efficiency optical performance<a href="#" target="_blank" class="wh mlin" onclick="recordOutboundLink(this, 'TSCATALOG', 'Pos2-More',0,0);getInterestRecord({'modreftypflag':'2', 'displayId':'13643681155', 'modid':'DIR', 'R_glusr_id':'12732472','mcat_id':'121185'});" id="2">more..</a></p>
                <div id="2prcenq" class="prc NP-2">Rs 5,200<span class="quan">Piece</span>
                  <div class="pr_t">Approximate Price - Rs 5,200 / Piece</div>
                </div>
              </div>
            </div>
          </li>
        </ul>
        <div class="nes">
          <p class="cmcl"><span class="cnm"> <span itemprop="name" class="lcname"><a onclick="recordOutboundLink(this, 'TSCATALOG', 'Pos2-Website',0,0);getInterestRecord({'modreftypflag':'2', 'displayId':'13643681155', 'modid':'DIR', 'R_glusr_id':'12732472','mcat_id':'121185'});" href="http://www.indiamart.com/halonix-limited/" target="_blank">Halonix Technologies Private Limited</a></span><span class="vcom"></span> <span class="td t_v cur" style="display:inline-block;" onmouseover="showTTip('tool-tip_n2');" onmouseout="hideTTip('tool-tip_n2')"><span class="ttl wd2 doff" id="tool-tip_n2"><span class="twrw"><span></span></span><span class="t_ts">&nbsp;</span></span><span class="bg t_se"></span></span></span></p>
          <span class="clg" onmouseover="showcityTTip('citytt2');" onmouseout="hidecityTTip('citytt2');" data-rlocation="">Noida<span class="srad cty-t" id="citytt2"><span class="on" itemprop="streetAddress">Plot No. 31, Block No. B, Phase-II, Near Luxor Factory, Gautam Budh Nagar, </span><span class="ct_l" itemprop="addressLocality">Noida</span><span>- </span><span itemprop="postalCode">201305</span><span>, </span><span itemprop="addressRegion">Uttar Pradesh</span></span></span></div>
        <div class="hlb"><span class="ls_co phn">
          <input type="hidden" id="pnsh2" value="08045338456">
          <span itemprop="telephone" id="pns2">08045338456</span></span></div>
        <p class="senq"><span id="2dispid13643681155" class="bp btn2g td NP-2">Send Enquiry</span></p>
      </div>
      <script type="text/javascript">$('.resizer125').load(function() {resizehw(this, 125, 125);});
                   $('.resizer200').load(function() { resizehw(this, 222, 222);});</script> </div>
  
  <div class="cont1">
  <div class="rcu rl w50">
    <div class="title">Other Products related to Interior and Exterior Lighting</div>
    <div style="float: left">
      <div class="rc_i"><img src="images/led-small.jpg"></div>
    </div>
    <div class="bx">
      <ul>
        <li><a href="#">LED Lights</a></li>
        <li><a href="#">Flat LED Panel Light</a></li>
        <li><a href="#">Surface Mounted Lights</a></li>
        <li><a href="#">LED Ceiling Lights</a></li>
        <li><a href="#">LED Surface Mounted Light</a></li>
        <li><a href="#">Lighting Panels</a></li>
      </ul>
    </div>
  </div>
  <div class="rcu city">
    <div class="title">LED Panel Light also available in </div>
    <div class="bx">
      <ul>
        <li><a title="LED Panel Light in Bengaluru" href="">Bengaluru</a></li>
        <li><a title="LED Panel Light in Hyderabad" href="">Hyderabad</a></li>
        <li><a title="LED Panel Light in Noida" href="">Noida</a></li>
      </ul>
    </div>
  </div>
  </div>
  </div>
  <div class="c3"></div>
  
</div>
<div> 
  <!-- Footer Start Here::-->
 <%@include file="../common/bottom.jsp"%>
  <!-- Footer End Here::--> 
</div>
<div id="IdentifiedPopUpHTML"></div>

<!-- Remarketing code --> 
<script type="text/javascript">
  var c_imesh = readCookie("ImeshVisitor");
  var pv_count=0;
	 if(readCookie("xnHist") > "")
    {
        if(getparamVal(readCookie("xnHist"), "pv") != "")
        {
            pv_count=getparamVal(readCookie("xnHist"), "pv");
        }
    }
	//console.log(pv_count);
  if(c_imesh == '' && pv_count == 2){
   $.ajaxSetup({ cache: true });
   $.getScript("//utils.imimg.com/globalhf/identified_popup.js",function(){
   
        getIdentifiedPopUpHTMLForm1();  
    	setTimeout(function(){identify_Banner()},3000);
         if($('#identyfy_usr_ctl').length){
		 $('#bl_layer').css("visibility","hidden");
		}
		else{
		 $('#bl_layer').css("visibility","visible");
		}
   
   });
   
   $('#countrySuggesterIdenPop').click(function(){
       changePopUpInput(identifiedPopName,1);
   });  
   is_form_open=0;	
 }
function recordInboundLinkS_bounce(category, action, label, value, noninteraction) {
    _gaq.push(['_trackEvent', window.location.href , action, label, value, noninteraction]);
 }
 function recordOutboundLink3(category, action) {
        _gaq.push(['_trackEvent', category, action, 'trackPageviewParam']);
        }



$(window).load(function() {
/* <![CDATA[ */
var google_conversion_id = 1067418746;
var google_custom_params = window.google_tag_params;
var google_remarketing_only = true;
/* ]]> */

$.getScript( "//www.googleadservices.com/pagead/conversion.js" );

/*(function() {
var _fbq = window._fbq || (window._fbq = []);
if (!_fbq.loaded) {
var fbds = document.createElement('script');
fbds.async = true;
fbds.src = '//connect.facebook.net/en_US/fbds.js';
var s = document.getElementsByTagName('script')[0];
s.parentNode.insertBefore(fbds, s);
_fbq.loaded = true;
}
_fbq.push(['addPixelId', '1000024446685311']);
})();*/
//window._fbq = window._fbq || [];
//window._fbq.push(['track', 'PixelInitialized', {}]);

   
     // use page view count, we have not added it right now.
  
  
   
   

});
</script>
<noscript>
&amp;lt;div style="display:inline;"&amp;gt; &amp;lt;img height="1" width="1" style="border-style:none;" alt="google" src="//googleads.g.doubleclick.net/pagead/viewthroughconversion/1067418746/?value=0&amp;amp;amp;guid=ON&amp;amp;amp;script=0"/&amp;gt; &amp;lt;/div&amp;gt;
</noscript>
<noscript>
&amp;lt;img height="1" width="1" alt="facebook" style="display:none" src="https://www.facebook.com/tr?id=1000024446685311&amp;amp;amp;ev=PixelInitialized" /&amp;gt;
</noscript>
<!-- Remarketing code end --> 

<script type="text/javascript">
var sugg = '';
var sugg_city = '';
var city_nm = '';
//setTimeout(function(){head.js("//utils.imimg.com/suggest/js/jq-ac-ui.js")}, 1);
head.ready("jq-ac-ui.js", function()
{
  function auto_suggest()
   {
    if(typeof(Suggester)!="undefined") 
    {
       sugg = new Suggester({"element":"search_string", "onSelect":selecttext, "placeholder":"Enter product / service to search", "classPlaceholder":"ui-placeholder-input","autocompleteClass":"im-gl-header","defaultBox":true});
       $('#btnSearch').click(function(){sugg.onEnd();});
       if(document.getElementById("txt-city")){               
sugg_city = new Suggester({"element":"txt-city","onSelect":selecttext_city,"type":"city","placeholder":"Enter city...", "classPlaceholder":".drop1","minStringLengthToDisplaySuggestion":1,"autocompleteClass":"cls-city"});
}
       setTimeout(function(){
	       sugg.recent({"cities": '', "cats": '759', "mcats": '121185', "mcatnames": 'LED Panel Light', "groups": '13'});
	       }, 5000);
	       
    } else {	    setTimeout(function(){auto_suggest()}, 50);
    }
 }
    auto_suggest();
    
});
</script><!--FOOTER COMPLETED TIME: 1.647 -->
</body>
</html>