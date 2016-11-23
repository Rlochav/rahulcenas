var pathname = $(location).attr('href');
var clientId;
var apiKey;
if (pathname.indexOf("neworleans") > 0) {
	clientId = "409160420325-ub8u1td20i4it7fi1mi2hcfvi77ao32p.apps.googleusercontent.com";
	apiKey = "AIzaSyDH5U1ak8f1ehZS2vehC6GXS3_ZKB1ZGfo";
} else {
	clientId = "444894883269-1karm3bk3t1jvrfvq3j2l8e7om2735a0.apps.googleusercontent.com";
	apiKey = "AIzaSyBD1Gq-gv7pQCvhGROVLapuM0HikN-0st4";
}

var scopes = 'https://www.googleapis.com/auth/userinfo.email ';
var google = false;

// Use a button to handle authentication the first time.
function handleClientLoad() {
	gapi.client.setApiKey(apiKey);
	checkAuth();
	// var x = setTimeout(checkAuth, 1000);
}

function checkAuth() {
	gapi.auth.authorize({
		client_id : clientId,
		scope : scopes,
		immediate : true
	}, handleAuthResult);
}

function handleAuthResult(authResult) {

	if (authResult && !authResult.error) {
		makeApiCall();
	}
}

function handleAuthClick(event) {
	// startWait();
	gapi.auth.authorize({
		client_id : clientId,
		scope : scopes,
		immediate : false
	}, handleAuthResult);

	return false;
}

// Load the API and make an API call. Display the results on the screen.
function makeApiCall() {
	gapi.client.load('plus', 'v1', function() {
		var request = gapi.client.plus.people.get({
			'userId' : 'me'
		});

		request.execute(function(resp) {
			// var resp = JS
			console.log(resp);
			var userEmail = resp.emails[0].value;
			var id = resp.id;
			var FirstName = resp.displayName;
			var fname = FirstName.split(' ');
			var retVal1 = $.ajax({
				url : "socialDetailsConsumer",
				global : false,
				type : "POST",
				data : {
					fName : fname[0],
					lName : fname[1],
					emailId : userEmail,
					account : "Google"
				},
				dataType : "json",
				async : false
			}).responseText;
			var obj = jQuery.parseJSON(retVal1.length != 0 ? retVal1 : null);
			if (obj != null) {
				if (obj.id != null || obj.id != "") {
					$.alert.open('confirm', 'Thanks for signing in!  Would you like to subscribe to local deal alerts now?', function(button) {
						if (button == 'yes') {
							window.location.href = "http://neworleans.gcddev.com/subscribe?fName=" + fname[0] + "&lName=" + fname[1] + "&email=" + userEmail;
						}
						if (button == 'no') {

						}
					});
				}
			}
		});
	});
}

$(function() {
	var authorizeButton = document.getElementById('googlelogin');
	if (authorizeButton != null)
		authorizeButton.onclick = handleAuthClick;
});