/*
<!-- COPYRIGHT (C) 2012 Vinculum Solutions (P) Limited. All Rights Reserved. -->
<!--		
	Application     :       eRetail
	Module          :       Validation Javascript
	File            :       commonFunction.js
	Purpose         :       Common Validation methods
	Author			:		Jyotsna Singhal

	Change History  :

		Change/Bug ID		Correction Date			Comments
		-----------			----------------		----------                
        11982			       17/07/2012           Validation method for numeric fields - isValidFieldLengthSize

-->

 */

//****************Global variables for Seperators Start*******************//
var tableSep = String.fromCharCode(25);
var rowSep = String.fromCharCode(23);
var columnSep = String.fromCharCode(21);
var valSep = String.fromCharCode(19);
var eventSep = String.fromCharCode(182); // for �
// ****************Global variables for Seperators End*******************//

function disableKeyCombination(e) {
	// list all CTRL + key combinations you want to disable
	var forbiddenKeysWithCtrl = new Array('v');
	var key;
	var isCtrl;
	var isShift;

	if (window.event) {
		key = window.event.keyCode; // IE
		if (window.event.ctrlKey)
			isCtrl = true;
		else
			isCtrl = false;

		if (window.event.shiftKey)
			isShift = true;
		else
			isShift = false;
	} else {
		key = e.which; // firefox
		if (e.ctrlKey)
			isCtrl = true;
		else
			isCtrl = false;

		if (e.shiftKey)
			isShift = true;
		else
			isShift = false;
	}

	// if ctrl is pressed check if other key is in forbidenKeys array
	if (isCtrl) {
		for (i = 0; i < forbiddenKeysWithCtrl.length; i++) {
			// case-insensitive comparation
			if (forbiddenKeysWithCtrl[i].toLowerCase() == String.fromCharCode(key).toLowerCase()) {
				alert('Key combination [Ctrl + ' + String.fromCharCode(key) + '] has been disabled.');
				return false;
			}
		}
	}
	if (isShift) {
		if (45 == key) {
			alert('Key combination [Shift + Insert] has been disabled.');
			return false;
		}
	}
	return true;
}

function MouseDownHandler(evt) {
	evt = (evt) ? evt : window.event;
	if (evt.button == 2) { // RIGHT CLICK
		alert("Right click is not allowed.");
	}
}

// removing leading & trailing spaces of a string.
function ltrimString(str) {
	for ( var k = 0; k < str.length && isWhitespace(str.charAt(k)); k++)
		;
	return str.substring(k, str.length);
}
function rtrimString(str) {
	for ( var j = str.length - 1; j >= 0 && isWhitespace(str.charAt(j)); j--)
		;
	return str.substring(0, j + 1);
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
function isWhitespace(charToCheck) {
	var whitespaceChars = " \t\n\r\f" + String.fromCharCode(160);
	return (whitespaceChars.indexOf(charToCheck) != -1);
}

function validateKeys(event, act, ctrlObj) {
	if (ctrlObj.value != "") {
		switch (act) {
		case "currency":
			re = /[^0-9.]+/i;
			reg = /[^0-9.]+/g;
			break;
		case "positiveInt":
			re = /[^0-9]+/i;
			reg = /[^0-9]+/g;
			break;
		case "alphabets":
			re = /[^a-zA-Z ]+/i;
			reg = /[^a-zA-Z ]+/g;
			break;
		case "alphanumeric":
			re = /[^a-zA-Z0-9. ]+/i;
			reg = /[^a-zA-Z0-9. ]+/g;
			break;
		case "alphabetic and special":
			re = /[^a-zA-Z0-9. ,%$@*:;()&\'\_\/#-]+/i;
			reg = /[^a-zA-Z0-9. ,%$@*:;()&\'\_\/#-]+/g;
			break;
		case "Time":
			re = /[^0-9: ]+/i;
			reg = /[^0-9: ]+/g;
			break;
		case "Textarea":
			re = /[^a-zA-Z0-9. _#,$@*()&:;\'\-\/]+/i;
			reg = /[^a-zA-Z0-9. _#,$@*()&:;\'\-\/]+/g;
			break;
		case "Date":
			re = /[^0-9\/ ]+/i;
			reg = /[^0-9\/ ]+/g;
			break;
		}
		if (undefined == re || "" == re) {
			alert("Validation Type [" + act + "] is not configured in validateKeys().");
			return false;
		}

		if (re.test(ctrlObj.value)) {
			ctrlObj.value = ctrlObj.value.replace(reg, "");
			return false;
		}
	}
	return true;
}
function validateKeyPress(event, act, ctrlObj) {
	var key;
	var re;
	if (window.event) { // IE
		key = window.event.keyCode;
	} else {
		key = event.which; // firefox
	}

	var detectBrowser = navigator.userAgent.toLowerCase();

	var keyCode = (event.keyCode) ? event.keyCode : ((event.charCode) ? event.charCode : event.which);
	if (detectBrowser.indexOf("firefox") > -1) {
		// Ignoring keypress In case of EnterKey,Arrowskey,BackSpacekey and
		// Delete key
		if (keyCode == "13" || keyCode == "27" || keyCode == "40" || keyCode == "38" || keyCode == "9" || keyCode == "46" || keyCode == "8")
			return true;
	} else if (detectBrowser.indexOf("msie") > -1) {
		if (keyCode == "13" || keyCode == "27")
			return true;

	} else if (detectBrowser.indexOf("chrome") > -1) {
		if (keyCode == "13" || keyCode == "27")
			return true;
	}
	// Below Line can be used for All browsers

	var keyChar = String.fromCharCode(key);
	switch (act) {
	case "currency":
		re = /[^0-9.]+/i;
		break;
	case "positiveInt":
		re = /[^0-9]+/i;
		break;
	case "alphabets":
		re = /[^a-zA-Z ]+/i;
		break;
	case "alphanumeric":
		re = /[^a-zA-Z0-9. ]+/i;
		break;
	case "alphabetic and special":
		re = /[^a-zA-Z0-9. ,%$@*:;()&\'\_\/#-]+/i;
		break;
	case "Time":
		re = /[^0-9: ]+/i;
		break;
	case "Textarea":
		re = /[^a-zA-Z0-9. _#,$@*()&:;\'\-\/]+/i;
		break;
	case "Date":
		re = /[^0-9\/ ]+/i;
		break;
	}
	if (undefined == re || "" == re) {
		alert("Validation Type [" + act + "] is not configured in validateKeyPress().");
		return false;
	}

	if (re.test(keyChar)) {
		return false;
	}
	return true;
}

function validateEMailOnFocusLost(event, ctrlObj) {
	ctrlObj.value = trimString(ctrlObj.value);
	var keyChar = ctrlObj.value;
	if (keyChar == undefined || keyChar == null || keyChar == "") {

	} else if (validateEmail(keyChar)) {
		stopAlert();
	} else {
		showAlert('Invalid eMail Address.');

		if (window.event) { // IE
			window.event.preventDefault();
		} else {
			event.preventDefault(); // firefox
		}
		tryFocus(ctrlObj);
		try {
			ctrlObj.select();
		} catch (e) {
		}
		return false;
	}
	return true;
}

function validateEmail(elementValue) {
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	return emailPattern.test(elementValue);
}

function validateEMailKeyPress(objCtrl) {
	var keyVal = window.event.keyCode;
	if (keyVal >= 48 && keyVal <= 57)
		return true;
	if (keyVal >= 64 && keyVal <= 90)
		return true;
	if (keyVal >= 97 && keyVal <= 122)
		return true;
	if (keyVal == 45 || keyVal == 46 || keyVal == 95)
		return true;

	return false;
}

function convertTo2Decimal(ctrlObj) {
	var tempValue = '';
	try {
		if ("" != ctrlObj.value && !isNaN(ctrlObj.value)) {
			var maxLen = ctrlObj.maxLength;
			var arr = ctrlObj.value.split(".");
			if (undefined != arr[1] && arr[1].length > 2) {
				ctrlObj.value = arr[0] + '.' + arr[1].substring(0, 2);
			}
			if (maxLen - 2 > ctrlObj.value.length) {
				arr = ctrlObj.value.split(".");
				if (arr.length >= 2) {
					if (arr[1].length == 0)
						arr[1] = '00';
					else if (arr[1].length == 1)
						arr[1] += '0';
					tempValue = arr[0] + '.' + arr[1].substring(0, 2);
				} else {
					tempValue = arr[0] + '.00';
				}

				if (undefined != maxLen && 0 != maxLen)
					tempValue = tempValue.substring(0, maxLen);
				ctrlObj.value = tempValue;
			}
		} else {
			ctrlObj.value = '';
		}
	} catch (exp) {
		ctrlObj.value = '';
	}
}

function convertToDecimal(ctrlObj, val1, val2) {
	var arr = ctrlObj.value.split(".");
	if (arr[1] != undefined && arr[1].length > val2 && arr[0] != undefined && arr[0].length <= val1) {
		convertTo2Decimal(ctrlObj);
	} else if (arr[0] != undefined && arr[0].length <= val1) {
		convertTo2Decimal(ctrlObj);
	} else {
		return false;
	}

	return true;
}

function convertTo2DecimalValue(numVal) {
	var tempValue = '';
	try {
		numVal = numVal + "";
		if ("" != numVal && !isNaN(numVal)) {
			var arr = numVal.split(".");
			if (undefined != arr[1] && arr[1].length > 2) {
				numVal = arr[0] + '.' + arr[1].substring(0, 2);
			} else {
				if (arr.length >= 2) {
					if (arr[1].length == 0)
						arr[1] = '00';
					else if (arr[1].length == 1)
						arr[1] += '0';
					tempValue = arr[0] + '.' + arr[1].substring(0, 2);
				} else {
					tempValue = arr[0] + '.00';
				}
				numVal = tempValue;
			}
		} else {
			numVal = '';
		}
	} catch (exp) {
		numVal = '';
	}
	return numVal;
}

function tryFocus(ctrlObj) {
	try {
		ctrlObj.focus();
	} catch (e) {
	}
	try {
		ctrlObj.addClass("ui-state-error");
		setTimeout('$("#' + ctrlObj[0].id + '").removeClass("ui-state-error");', 4000); // milliseconds
	} catch (e) {
	}
}

function getFloatValue(val) {
	try {
		val = parseFloat(val);
		if (isNaN(val))
			val = 0;
	} catch (e) {
		val = 0;
	}
	return val;
}

function getIntValue(val) {
	try {
		val = parseInt(val);
		if (isNaN(val))
			val = null;
	} catch (e) {
		val = null;
	}
	return val;
}

function checkPositiveFloat(val) {
	try {
		if (!(parseFloat(val) == val) || val < 0) {
			return false;
		}
	} catch (e) {
		return false;
	}
	return true;
}

function checkPositiveInt(val) {
	try {
		if (!(parseInt(val) == val) || val < 0) {
			return false;
		}
	} catch (e) {
		return false;
	}
	return true;
}

function isValidInteger(val) {
	try {
		if (!(parseInt(val) == val)) {
			return false;
		}
	} catch (e) {
		return false;
	}
	return true;
}

function isValidFloat(val) {
	try {
		if (!(parseFloat(val) == val)) {
			return false;
		}
	} catch (e) {
		return false;
	}
	return true;
}

function isValidIntegerIgnoreBlank(val) {
	if (trimString(val) == "")
		return true;
	try {
		if (!(parseInt(val) == val)) {
			return false;
		}
	} catch (e) {
		return false;
	}
	return true;
}

function isValidFloatIgnoreBlank(val) {
	if (trimString(val) == "")
		return true;
	try {
		if (!(parseFloat(val) == val)) {
			return false;
		}
	} catch (e) {
		return false;
	}
	return true;
}

function isValidFieldLengthSize(val, type) {
	if (trimString(val) == "")
		return true;
	try {
		if (type == 'Short') {
			if (parseFloat(val) > parseFloat("32767"))
				return false;
		}
		if (type == '10_3') {
			if (parseFloat(val) > parseFloat("9999999"))
				return false;
		}
		if (type == '7_3') {
			if (parseFloat(val) > parseFloat("9999"))
				return false;
		}
	} catch (e) {
		return false;
	}
	return true;
}

function validateCurrency(ctrlObj) {
	if (ctrlObj.value != "") {
		if (!checkPositiveFloat(ctrlObj.value)) {
			showAlert("Invalid data entered.");
			ctrlObj.value = "";
			ctrlObj.focus();
			return false;
		} else if (parseInt(ctrlObj.value).toString().length > 9) {
			showAlert("Out of range data entered.");
			ctrlObj.value = "";
			ctrlObj.focus();
			return false;
		} else {
			convertTo2Decimal(ctrlObj);
		}
	}
	stopAlert();
}

function validatePositiveInt(ctrlObj) {
	if (ctrlObj.value != "") {
		if (!checkPositiveInt(ctrlObj.value)) {
			showAlert("Invalid data entered.");
			ctrlObj.value = "";
			ctrlObj.focus();
			return false;
		} else if (parseInt(ctrlObj.value).toString().length > 9) {
			showAlert("Out of range data entered.");
			ctrlObj.value = "";
			ctrlObj.focus();
			return false;
		}
	}
	stopAlert();
}

function CodeValueStruct(sCode, sText) {
	this.code = sCode;
	this.text = sText;
}

function fillCombo(cmbId, jsonCodeValueObj) {

	var req = document.getElementById(cmbId);
	var optn;
	req.options.length = 0;
	for ( var j = 0; j < jsonCodeValueObj.length; j++) {
		optn = document.createElement("option");

		optn.value = jsonCodeValueObj[j].code;
		optn.text = jsonCodeValueObj[j].text;
		optn.title = jsonCodeValueObj[j].text;

		req.options.add(optn);
	}
	req.selectedIndex = 0;
}

/*
 * BIRT Report Functions Start
 */

function genBIRTReport(reportName, params, format, locale, toolbarRequired, reportFolderName, reportTitle) {
	var rptFolderName = "";
	if (reportFolderName != null && trimString(reportFolderName) != "") {
		rptFolderName = trimString(reportFolderName) + "%2F";
	}

	if (typeof reportTitle == "undefined" || reportTitle == null)
		reportTitle = reportName;

	var sURL = "/birt/frameset?__id=birtViewer&__title=" + reportTitle + "&__report=report%2F" + rptFolderName + reportName
			+ ".rptdesign&__masterpage=false&__format=" + format + "&__toolbar=" + toolbarRequired + "&__locale=" + locale + params;
	var sFeaturs = "resizable=1, toolbar=0, location=0, directories=0, status=0, menubar=0, scrollbars=1, dialog=0";
	window.open(sURL, "BIRTReports", sFeaturs);
}

function getBIRTUrl(reportName, params, format, locale, toolbarRequired, reportFolderName, reportTitle) {
	var rptFolderName = "";
	if (reportFolderName != null && trimString(reportFolderName) != "") {
		rptFolderName = trimString(reportFolderName) + "%2F";
	}

	if (typeof reportTitle == "undefined" || reportTitle == null)
		reportTitle = reportName;

	var sURL = "/birt/frameset?__id=birtViewer&__title=" + reportTitle + "&__report=report%2F" + rptFolderName + reportName
			+ ".rptdesign&__masterpage=false&__format=" + format + "&__toolbar=" + toolbarRequired + "&__locale=" + locale + params;
	return sURL;
}

/*
 * BIRT Report Functions End
 */

/*
 * Inline SJGrid Editing Functions Start
 */
function GridInlineEditKeyDownHandler(evt, gridId) {
	var evt = (evt) ? evt : window.event;
	if (evt.target)
		evtl = evt.target;
	else if (evt.srcElement)
		evtl = evt.srcElement;

	var element = evt.srcElement;

	if (element == undefined)
		element = evtl;

	// alert(element.tagName);
	// alert(element.id);

	var keyVal = evt.keyCode;
	switch (keyVal) {
	case 13:
		// Enter Key Pressed
		var gridObj = $("#" + gridId);
		var currId = element.id.substring(0, element.id.indexOf("_"));
		gridObj.jqGrid('saveRow', currId);
		validateEditInlineAfterSave(evt, gridObj, currId);
		evt.preventDefault();
		return false;
		break;
	case 27:
		// Enter Key Pressed
		var gridObj = $("#" + gridId);
		var currId = element.id.substring(0, element.id.indexOf("_"));

		gridObj.jqGrid('restoreRow', currId);
		validateEditInlineAfterSave(evt, gridObj, currId);
		evt.preventDefault();
		return false;
		break;
	case 40:
		// Down Arrow Key Pressed
		try {
			if (element.tagName.toUpperCase() != "SELECT")
				return downArrowKeyDown(element.id, gridId, evt);
		} catch (e) {
		}
		break;
	case 38:
		// Up Arrow Key Pressed
		try {
			if (element.tagName.toUpperCase() != "SELECT")
				return upArrowKeyDown(element.id, gridId, evt);
		} catch (e) {
		}
		break;
	case 9:
		// Tab Key Pressed
		try {
			if (evt.shiftKey) {
				return backTabKeyDown(element.id, gridId, evt);
			} else {
				return nextTabKeyDown(element.id, gridId, evt);
			}
		} catch (e) {
		}
		break;
	}
}

function backTabKeyDown(idName, gridId, evt) {
	try {
		var gridObj = $("#" + gridId);
		var currId = idName.substring(0, idName.indexOf("_"));
		var idFieldName = idName.substring(idName.indexOf("_") + 1, idName.length);
		currId = parseInt(currId);
		if (isFirstEditableCell(gridObj, idFieldName, currId)) {
			var rowIds = gridObj.jqGrid('getDataIDs');
			if (!(currId <= 1 || currId > rowIds.length)) {
				gridObj.jqGrid('saveRow', currId);
				if (validateEditInlineAfterSave(evt, gridObj, currId)) {
					gridObj.jqGrid('setSelection', (currId - 1), true);
					gridObj.jqGrid('editRow', currId - 1);
					var focusFieldName = getLastEditableFieldName(gridObj, currId - 1);
					$("#" + (currId - 1) + "_" + focusFieldName).focus();
					return true;
				}
				evt.preventDefault();
				return false;
			} else if (currId == 1) {
				gridObj.jqGrid('saveRow', currId);
				validateEditInlineAfterSave(evt, gridObj, currId);
			}
		}
	} catch (e) {
		alert(e.message);
	}
}

function nextTabKeyDown(idName, gridId, evt) {
	try {
		var gridObj = $("#" + gridId);
		var currId = idName.substring(0, idName.indexOf("_"));// gridObj.jqGrid('getGridParam','selrow');
		var idFieldName = idName.substring(idName.indexOf("_") + 1, idName.length);
		currId = parseInt(currId);
		if (isLastEditableCell(gridObj, idFieldName, currId)) {
			var rowIds = gridObj.jqGrid('getDataIDs');
			if (!(currId < 1 || currId >= rowIds.length)) {
				gridObj.jqGrid('saveRow', currId);
				if (validateEditInlineAfterSave(evt, gridObj, currId)) {
					gridObj.jqGrid('setSelection', (currId + 1), true);
					gridObj.jqGrid('editRow', currId + 1);
					var focusFieldName = getFirstEditableFieldName(gridObj, currId + 1);
					$("#" + (currId + 1) + "_" + focusFieldName).focus();
				}
				evt.preventDefault();
				return false;
			} else if (currId == rowIds.length) {
				gridObj.jqGrid('saveRow', currId);
				validateEditInlineAfterSave(evt, gridObj, currId);
			}
		}
	} catch (e) {
		alert(e.message);
	}
}

function upArrowKeyDown(idName, gridId, evt) {
	try {
		var gridObj = $("#" + gridId);
		var currId = idName.substring(0, idName.indexOf("_"));
		var idFieldName = idName.substring(idName.indexOf("_") + 1, idName.length);
		currId = parseInt(currId);
		var rowIds = gridObj.jqGrid('getDataIDs');
		if (!(currId <= 1 || currId > rowIds.length)) {
			gridObj.jqGrid('saveRow', currId);
			if (validateEditInlineAfterSave(evt, gridObj, currId)) {
				gridObj.jqGrid('setSelection', (currId - 1), true);
				gridObj.jqGrid('editRow', currId - 1);
				$("#" + (currId - 1) + "_" + idFieldName).focus();
				return true;
			} else
				return false;
		}
	} catch (e) {
		alert(e.message);
	}
}

function downArrowKeyDown(idName, gridId, evt) {
	try {
		var gridObj = $("#" + gridId);
		var currId = idName.substring(0, idName.indexOf("_"));
		var idFieldName = idName.substring(idName.indexOf("_") + 1, idName.length);
		currId = parseInt(currId);
		var rowIds = gridObj.jqGrid('getDataIDs');
		if (!(currId < 1 || currId >= rowIds.length)) {
			gridObj.jqGrid('saveRow', currId);
			if (validateEditInlineAfterSave(evt, gridObj, currId)) {
				gridObj.jqGrid('setSelection', (currId + 1), true);
				gridObj.jqGrid('editRow', currId + 1);
				$("#" + (currId + 1) + "_" + idFieldName).focus();
				return true;
			} else
				return false;
		}
	} catch (e) {
		alert(e.message);
	}
}

function isFirstEditableCell(gridObj, idFieldName, currId) {
	var colModelArr = gridObj.jqGrid('getGridParam', 'colModel');
	for ( var i = 0; i < colModelArr.length; i++) {
		if (colModelArr[i].editable && !colModelArr[i].hidden && isFocusable($("#" + (currId) + "_" + colModelArr[i].name))) {
			if (colModelArr[i].name == idFieldName)
				return true;
			else
				return false;
		}
	}
	return false;
}

function isLastEditableCell(gridObj, idFieldName, currId) {
	var colModelArr = gridObj.jqGrid('getGridParam', 'colModel');
	for ( var i = colModelArr.length - 1; i >= 0; i--) {
		if (colModelArr[i].editable && !colModelArr[i].hidden && isFocusable($("#" + (currId) + "_" + colModelArr[i].name))) {
			if (colModelArr[i].name == idFieldName)
				return true;
			else
				return false;
		}
	}
	return false;
}

function isFocusable(ctrlObj) {
	try {
		if (ctrlObj.length <= 0)
			return false;
	} catch (e) {
	}

	if (ctrlObj.is(':disabled'))
		return false;
	if (!ctrlObj.is(':visible'))
		return false;

	return true;
}

function getFirstEditableFieldName(gridObj, currId) {
	var colModelArr = gridObj.jqGrid('getGridParam', 'colModel');
	for ( var i = 0; i < colModelArr.length; i++) {
		if (colModelArr[i].editable && !colModelArr[i].hidden && isFocusable($("#" + (currId) + "_" + colModelArr[i].name))) {
			return colModelArr[i].name;
		}
	}
	return "";
}
function getLastEditableFieldName(gridObj, currId) {
	var colModelArr = gridObj.jqGrid('getGridParam', 'colModel');
	for ( var i = colModelArr.length - 1; i >= 0; i--) {
		if (colModelArr[i].editable && !colModelArr[i].hidden && isFocusable($("#" + (currId) + "_" + colModelArr[i].name))) {
			return colModelArr[i].name;
		}
	}
	return "";
}

function setCellFocus(gridObj, cellRowId, cellName, defaultValue, isError) {
	var currentValue = gridObj.jqGrid('getCell', cellRowId, cellName);
	if (defaultValue != null)
		gridObj.jqGrid('setCell', cellRowId, cellName, defaultValue);
	// gridObj.jqGrid('resetSelection');
	// gridObj.jqGrid('setSelection',cellRowId, true);
	gridObj.jqGrid('editRow', cellRowId);
	// if(isError)
	$("#" + (cellRowId) + "_" + cellName).addClass("ui-widget ui-state-error");
	// else
	// $("#"+(cellRowId)+"_"+cellName).addClass("ui-widget ui-state-highlight");
	$("#" + (cellRowId) + "_" + cellName).val(currentValue);
	$("#" + (cellRowId) + "_" + cellName).focus();
	$("#" + (cellRowId) + "_" + cellName).select();
}

function validateLastSelectedRow(gridObj, rowid, e) {
	var lastSelectedRow_inbMainGrid = gridObj[0].summary;
	if (lastSelectedRow_inbMainGrid != undefined && lastSelectedRow_inbMainGrid != null && trimString(lastSelectedRow_inbMainGrid) != ""
			&& rowid !== lastSelectedRow_inbMainGrid) {
		gridObj.jqGrid('saveRow', lastSelectedRow_inbMainGrid);
		if (!validateEditInlineAfterSave(e, gridObj, lastSelectedRow_inbMainGrid)) {
			return false;
		}
	}
	gridObj[0].summary = rowid;
	return true;
}

/*
 * Inline SJGrid Editing Functions End
 */

function trimToMaxLength(Object, MaxLen) {
	if (Object.value.length > MaxLen) {
		Object.value = Object.value.substring(0, MaxLen);
		removeEnterKey(Object);
	}
}
function removeEnterKey(obj) {
	var i = 0;
	var j = 0;
	var sretVal = "";
	str = obj.value;
	for (i = 0; i < obj.value.length; i++) {
		if (str.charCodeAt(i) == 13) {
			sretVal = sretVal + " ";
			i++;
		} else
			sretVal = sretVal + str.charAt(i);
	}
	obj.value = sretVal;
}
function imposeMaxLength(Object, MaxLen) {
	try {
		var key;
		if (window.event) { // IE
			key = window.event.keyCode;
		} else {
			key = event.which; // firefox
		}
		if (key == 0 || key == 8)
			return true;
	} catch (e) {
	}

	if (Object.value.length >= MaxLen) {
		return false;
	}
	return true;
}

function setReadOnly(ctrlId, realOnlyFlag) {
	try {
		if (document.getElementById(ctrlId)) {
			document.getElementById(ctrlId).readOnly = realOnlyFlag;
			if (realOnlyFlag) {
				document.getElementById(ctrlId).style.background = '#EBEBE4';
			} else {
				document.getElementById(ctrlId).style.background = 'white';
			}
		}
	} catch (e) {
	}
}

var dateRangeSplitter = 'to';

function changeDateRangeData(sourceCtrlId, fromCtrlId, toCtrlId) {
	var dateRange = trimString($("#" + sourceCtrlId).val());
	var clearDataFlag = false;
	if (dateRange != '') {
		var dateRangeArr = dateRange.split(dateRangeSplitter);
		if (trimString(dateRangeArr[0]).length > 6) {
			$("#" + fromCtrlId).val(trimString(dateRangeArr[0]));
			if (dateRangeArr.length >= 2 && trimString(dateRangeArr[1]).length > 6) {
				$("#" + toCtrlId).val(trimString(dateRangeArr[1]));
			} else {
				$("#" + toCtrlId).val(trimString(dateRangeArr[0]));
			}
		} else {
			clearDataFlag = true;
		}
	} else {
		clearDataFlag = true;
	}

	if (clearDataFlag) {
		$("#" + fromCtrlId).val("");
		$("#" + toCtrlId).val("");
	}
}

function htmDesignSetDateRangeData(ctrlId) {
	var visibleCtrlId = "visible" + ctrlId;
	var fromCtrlId = "from" + ctrlId;
	var toCtrlId = "to" + ctrlId;
	var dateRange = trimString($("#" + visibleCtrlId).val());
	var clearDataFlag = false;
	if (dateRange != '') {
		var dateRangeArr = dateRange.split(dateRangeSplitter);
		if (trimString(dateRangeArr[0]).length > 6) {
			$("#" + fromCtrlId).val(trimString(dateRangeArr[0]));
			if (dateRangeArr.length >= 2 && trimString(dateRangeArr[1]).length > 6) {
				$("#" + toCtrlId).val(trimString(dateRangeArr[1]));
			} else {
				$("#" + toCtrlId).val(trimString(dateRangeArr[0]));
			}
			$("#" + ctrlId).val($("#" + fromCtrlId).val() + valSep + $("#" + toCtrlId).val());
		} else {
			clearDataFlag = true;
		}
	} else {
		clearDataFlag = true;
	}

	if (clearDataFlag) {
		$("#" + fromCtrlId).val("");
		$("#" + toCtrlId).val("");
		$("#" + ctrlId).val("");
	}
}

function getSELECTText(selectCtrlId, value) {
	var selectOptions = document.getElementById(selectCtrlId).options;
	for ( var i = 0; i < selectOptions.length; i++) {
		if (selectOptions[i].value == value) {
			return selectOptions[i].text;
		}
	}
	return null;
}

function showImageBeforeUpload(input, imgCtrlId) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#' + imgCtrlId).attr('src', e.target.result);
		};
		reader.readAsDataURL(input.files[0]);
	} else if (input.value != null && input.value != "") {
		$('#' + imgCtrlId).attr('src', input.value);
	}
}

function getFormDataIntoJsonString(formCtrl, dtoPrefix) {
	var jsonString = "";
	var els = formCtrl.elements;
	for ( var i = 0, len = els.length; i < len; i++) {
		if (els[i].name.indexOf(dtoPrefix) != 0)
			continue;
		var spltdName = els[i].name.split('.');
		if (spltdName.length != 2)
			continue;

		jsonString += '"' + spltdName[1] + '":"' + els[i].value + '",';
	}
	if (jsonString.length > 0)
		jsonString = jsonString.substring(0, jsonString.length - 1);

	jsonString = "{" + jsonString + "}";
	return jsonString;
}

function refreshCache() {
	var retVal = $.ajax({
		url : "jsonRefillCache",
		type : "POST",
		global : false,
		data : {},
		datatype : "json",
		async : false
	}).responseText;
}

function isTableVisible(tblName) {
	// var IsVisibleFormFlag=eval("sFormViewDesignArr."+tblName).IsVisible;
	// if(IsVisibleFormFlag=="N")
	// return false;
	return true;
}

function isTableEditable(tblName) {
	// if(!isTableVisible(tblName))
	// return false;
	// var IsEditableFormFlag=eval("sFormViewDesignArr."+tblName).IsEditable;
	// if(IsEditableFormFlag=="N")
	// return false;
	return true;
}
function getIntVal(sValue) {
	var iValue = 0;
	try {
		iValue = parseInt(sValue);
		if (isNaN(iValue))
			iValue = 0;
	} catch (e) {
	}
	return iValue;
}

function getFormDataIntoJson(formCtrl, dtoPrefix) {
	var jsonString = "";
	var els = formCtrl.elements;
	for ( var i = 0, len = els.length; i < len; i++) {
		if (els[i].name.indexOf(dtoPrefix) != 0)
			continue;
		var spltdName = els[i].name.split(':');
		if (spltdName.length != 2)
			continue;

		jsonString += '"' + spltdName[1] + '":"' + validateData4Database(els[i].value) + '",';
	}
	if (jsonString.length > 0)
		jsonString = jsonString.substring(0, jsonString.length - 1);

	jsonString = "{" + jsonString + "}";
	return jsonString;
}

function validateData4Database(val) {
	if (typeof val == 'undefined' || val == null)
		return null;
	return val;
}

function appFocus(obj) {
	try {
		obj.focus();
	} catch (e) {
	}
	try {
		$('#' + obj[0].id).addClass("focus");
		setTimeout('$("#' + obj[0].id + '").removeClass("focus");', 2500);
	} catch (e) {
		// TODO: handle exception
	}
}

function createSocialMediaUrl(url) {
	var lastIndex;
	lastIndex = url.lastIndexOf('/');
	if (lastIndex == url.length) {
		url = url.substring(0, url.length - 1);
		lastIndex = url.lastIndexOf('/');
	}

	if (url.indexOf('vimeo'))
		return 'https://www.youtube.com/embed' + url.substring(lastIndex, url.length);
	if (url.indexOf('you'))
		return 'http://www.youtube.com/embed/'+url.substring(lastIndex, url.length);
return null;
}
