var latlngstr = '';
var marker;
var map;
function initialize() {
	var mapProp = {
		center : new google.maps.LatLng(28.613458776875632, 77.23182639160154),
		zoom : 10,
		zoomControl : true,
		zoomControlOptions : {
			style : google.maps.ZoomControlStyle.SMALL
		},
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById("gmap"), mapProp);

	var styles = [ {
		stylers : [ {
			hue : "#859785"
		}, {
			saturation : -80
		} ]
	}, {
		featureType : "road",
		elementType : "geometry",
		stylers : [ {
			lightness : -10
		}, {
			visibility : "simplified"
		} ]
	}, {
		featureType : "road",
		elementType : "labels",
		stylers : [ {
			visibility : "off"
		} ]
	} ];

	map.setOptions({
		styles : styles
	});

	marker = new google.maps.Marker({
		map : map,
		draggable : true,
		animation : google.maps.Animation.DROP,
		position : new google.maps.LatLng(28.613458776875632, 77.23182639160154)
	});

	google.maps.event.addListener(marker, 'dragend', function() {
		$("#lat").val(marker.getPosition().lat());
		$("#lng").val(marker.getPosition().lng());
	});

}
google.maps.event.addDomListener(window, 'load', initialize);
