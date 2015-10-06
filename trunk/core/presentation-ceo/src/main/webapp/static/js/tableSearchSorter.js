/**
 * 
 */

function first() {
	loadCategoryTable(0, count);
}

function next() {
	if (currentStart > 0 && currentStart < totalRecords) {
		loadCategoryTable(((currentStart / count) * count), count);
	}
}

function last() {
	if ((totalRecords % count) != 0) {
		loadCategoryTable((totalRecords - (totalRecords % count)), count);
	} else {
		loadCategoryTable((totalRecords - count), count);
	}
}

function prev() {
	if (currentStart > 0) {
		loadCategoryTable((((currentStart / count) * count) - count), count);
	}
}

function loadCategoryTable(start, count) {
	$("tbody").empty();
	if (start == 0) {
		currentStart = count;
	} else if (start < 0) {
		start = 0;
		currentStart = count;
	} else {
		currentStart = start;
	}

	var retVal = $.ajax({
		url : "searchCategory",
		type : "post",
		global : false,
		data : {
			start : start,
			count : count
		},
		dataType : "json",
		async : false
	}).responseText;

	if (retVal != null && retVal != '') {
		retVal = jQuery.parseJSON(retVal);
		var arr = retVal.categoryDTOs;
		totalRecords = retVal.total;
		var row = 1;
		var html = '';
		for (var i = 0; i < arr.length; i++) {
			if (row % 2 == 0) {
				html += '<tr class="even"><td>' + arr[i].categoryCode + '</td><td>' + arr[i].categoryName + '</td></tr>';
			} else {
				html += '<tr class="odd"><td>' + arr[i].categoryCode + '</td><td>' + arr[i].categoryName + '</td></tr>';
			}
			row++;
		}

		$("tbody").append(html);
	}
}