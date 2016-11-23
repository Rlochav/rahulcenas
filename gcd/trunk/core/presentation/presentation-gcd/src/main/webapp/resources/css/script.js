
$(function(){

	$("#city").change(function(){
		filterData($(this).val(),'city','region',map);	
	});
	
	$("#region").change(function(){
		filterData($(this).val(),'region','landmark',map);		
	});
	
	$("#landmark").change(function(){
		if($(this).val()=="00")
		{
			$(this).css("width","40px");
			$(this).css("color","#e0e3df");
			$("#landmark option").css("color","#797f5c");
			$("#inputlandmark").show();
			$("#location").css("width","40px");
			$("#location").css("color","#e0e3df");
			$("#location option").css("color","#797f5c");
			$("#inputlocation").show();
		}
		else
		{
			$("#inputlandmark").hide();
			$(this).css("width","70%");
			$(this).css("color","#797f5c");
			$("#location").css("color","#797f5c")
			$("#location").css("width","70%");
			$("#inputlocation").hide();
			//filterData($(this).val(),'landmark','location');
		}
			
	});

	$("#location").change(function(){
		if($(this).val()=="00")
		{
			$(this).css("width","40px");
			$("#inputlocation").show();
		}
		else
		{
			$("#inputlocation").hide();
			$(this).css("width","70%");
		
		}
			
	});

	$('#myfile').change(function(){
		
	 	 uploadimg();
		 
	 });

	$("#amnt").mouseenter(function(){
		$(this).animate({height:'220px'});
	});
	$("#amnt").mouseout(function(e){
		
		if((e.pageX>215)||(e.pageY>520))
			$("#amnt").animate({height:'25px'});
	});

	$("#gmap").css("height",(screen.height-200)+'px');
	$(".divleft").css("height",(screen.height-200)+'px');
	


});

function filterData(srcid,srctable,dstid,map)
{
	
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    	$("#"+dstid).html(xmlhttp.responseText);
    	if(srcid==0||srcid==00)
	    	srcid=1;
		getlatlong(srcid,srctable,marker,map);	
    }
  }
xmlhttp.open("GET","resources/filterData.php?srcid="+srcid+"&dstid="+dstid,true);
xmlhttp.send();
}

function uploadimg (){
//Submit the form.
var theform = document.getElementById('uploadform');
theform.submit();

$('#uploadframe').load(function(){
        var inp=document.getElementById('myfile');
		if(inp.files.length>0)
	 	 $('#filenum').val(inp.files.length+' Files uploaded');
          
	});
}


//getElementById('lat').value = getElementById('myfile').value;

function getlatlong(srcid,srctable,marker,map)
{
	
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    	 	var latlngstr=xmlhttp.responseText;
    	 	var latlngarr=latlngstr.split(',');
			var lat=latlngarr[0];
			var lng=latlngarr[1];
			var latlng = new google.maps.LatLng(lat,lng);
    		marker.setPosition(latlng);
			$("#lat").val(lat);
			$("#lng").val(lng);
			map.setCenter(latlng);
    }
  }
xmlhttp.open("GET","resources/getmarkerposition.php?srcid="+srcid+"&srctable="+srctable,true);
xmlhttp.send();
}
