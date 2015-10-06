/**
 * 
 */

function validate(title, message, type) {
	$.notify({
		title : '<strong>' + title + '</strong>',
		message : message
	}, {
		type : type
	});
}

function trimString(str) {
	if (undefined == str)
		return "";
	if ('undefined' == str)
		return "";
	if (null == str)
		return null;
	return ltrimString(rtrimString(str));
}

function ltrimString(str) {
	for (var k = 0; k < str.length && isWhitespace(str.charAt(k)); k++)
		;
	return str.substring(k, str.length);
}

function rtrimString(str) {
	for (var j = str.length - 1; j >= 0 && isWhitespace(str.charAt(j)); j--)
		;
	return str.substring(0, j + 1);
}

function isWhitespace(charToCheck) {
	var whitespaceChars = " \t\n\r\f" + String.fromCharCode(160);
	return (whitespaceChars.indexOf(charToCheck) != -1);
}

function onlyChars(userIdVal) {
	var userIdReg = /^[a-zA-Z\s]+$/;
	var test_userId = userIdReg.test(userIdVal);
	if (test_userId == false) {
		return false;
	}
}