function loginFacebook() {
	FB.login(function(response) {
		if (response.authResponse) {
			// connected
			testAPI();
		} else {
			// cancelled
		}
	}, {
		scope : 'email'
	});
}

function testAPI() {
	console.log('Welcome!  Fetching your information.... ');
	FB.api('/me', function(response) {
		console.log('Good to see you, ' + response.name + '.' + ' Email: ' + response.email + ' Facebook ID: ' + response.id);
		var strName = (response.name).split(" ");
		var fName = strName[0];
		var lName;
		if (strName.length > 1)
			lName = strName[1];
		var retVal2 = $.ajax({
			url : "socialDetailsConsumer",
			global : false,
			type : "POST",
			data : {
				fName : fName,
				lName : lName,
				emailId : response.email,
				account : "Facebook"
			},
			dataType : "json",
			async : false
		}).responseText;
		var obj = jQuery.parseJSON(retVal2.length != 0 ? retVal2 : null);
		if (obj != null) {
			if (obj.id != null || obj.id != "") {
				$.alert.open('confirm', 'Thanks for signing in!  Would you like to subscribe to local deal alerts now?', function(button) {
					if (button == 'yes') {
						window.location.href = "http://neworleans.gcddev.com/subscribe?fName=" + fName + "&lName=" + lName + "&email=" + response.email;
					}
					if (button == 'no') {

					}
				});
			}
		}
	});
}