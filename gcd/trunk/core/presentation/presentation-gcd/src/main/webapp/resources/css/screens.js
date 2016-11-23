var cmnScreenW;
var cmnScreenH;

var detectBrowser = navigator.userAgent.toLowerCase();
var cmnCorrection=0;
var cmnWCorrection=0;
if(detectBrowser.indexOf("firefox") > -1) {
	cmnScreenW = window.innerWidth;
	cmnScreenH = window.innerHeight;
	cmnCorrection=0;
	menuCorrection=0;
	menuInnerHeightCorrection=0;
	menuInnerWidthCorrection=0;
	WidthCorrection=0;
} else if(detectBrowser.indexOf("opera") > -1) {
	cmnScreenW = window.innerWidth;
	cmnScreenH = window.innerHeight;
	cmnCorrection=0;
	menuCorrection=0;	
	menuInnerHeightCorrection=0;
	menuInnerWidthCorrection=0;
	WidthCorrection=0;
} else if(detectBrowser.indexOf("msie") > -1) {
	cmnScreenW = window.screen.availWidth;
	cmnScreenH = window.screen.availHeight;
	if(document.documentElement.scrollHeight) {
		cmnScreenW =document.documentElement.scrollWidth;
		cmnScreenH = document.documentElement.scrollHeight;
	}
	cmnCorrection=0;
	cmnWCorrection=-8;
	menuCorrection=0;
	menuInnerHeightCorrection=0;
	menuInnerWidthCorrection=0;
	WidthCorrection=-20;
} else if(detectBrowser.indexOf("chrome") > -1) {
	cmnScreenW = document.documentElement.clientWidth;
	cmnScreenH = document.documentElement.clientHeight;
	cmnCorrection=0;
	menuCorrection=0;
	menuInnerHeightCorrection=0;
	menuInnerWidthCorrection=0;
	WidthCorrection=0;
} else {
	cmnScreenW = document.documentElement.clientWidth;
	cmnScreenH = document.documentElement.clientHeight;
	cmnCorrection=0;
	menuCorrection=0;
	menuInnerHeightCorrection=0;
	menuInnerWidthCorrection=0;
	WidthCorrection=0;
}  


var cmnControlW=cmnScreenW/7;
var cmnControlSmallW=cmnScreenW/10;
var cmnControlSmallerW=cmnScreenW/12;
var cmnControlSmallestW=cmnScreenW/20;
var cmnControlH=40;
var centerTbl=400*(cmnScreenW/1024);
if(centerTbl<400) {
	centerTbl=400;
}
document.write("<style>");
var headerHeight=33;
var menuScreenHeight=(cmnScreenH-headerHeight+cmnCorrection);
/* Landing Page Style Start */
document.write(".headerStyle { width:100%; height:"+headerHeight+"px; margin: 0px; padding: 0px;}");
document.write(".contentStyle { width:100%; height:"+menuScreenHeight+"px !important; margin: 0px; padding: 0px;}");
document.write(".footerStyle { width:100%; height:20px !important; margin: 0px; padding: 0px;}");

document.write("input[disabled='disabled'] {background: #EBEBE4; border:1px solid #A8A8A8;}");
document.write("input:disabled {background: #EBEBE4; border:1px solid #A8A8A8;}");
document.write(".mInput { margin-left:2px; width: "+cmnControlW+"px; padding-left: 2px;}");
document.write(".mInputROnly { background: #EBEBE4; border:1px solid #A8A8A8;}");
document.write(".mTextArea { margin-left:2px; width: "+cmnControlW+"px; }");
document.write(".mSelect { margin-left:2px; width: "+(cmnControlW+4)+"px; }");
document.write(".mcheckbox {margin-left:2px; }");
document.write(".readOnlyLabel {margin-left:2px; font-weight: bold; text-align:left; vertical-align: middle;}");

document.write(".mSmallInput { margin-left:2px; width: "+cmnControlSmallW+"px; padding-left: 2px;}");
document.write(".mSmallInputROnly { margin-left:2px; width: "+cmnControlSmallW+"px; background: #EBEBE4; border:1px solid #A8A8A8; }");
document.write(".mSmallTextArea { margin-left:2px; width: "+cmnControlSmallW+"px; }");
document.write(".mSmallInputROnly { margin-left:2px; width: "+cmnControlSmallW+"px; background: #EBEBE4; border:1px solid #A8A8A8; }");
document.write(".mSmallSelect { margin-left:2px; width: "+(cmnControlSmallW+4)+"px; }");
document.write(".mSmallcheckbox {margin-left:2px; }");

document.write(".mSmallerInput { margin-left:2px; width: "+cmnControlSmallerW+"px; padding-left: 2px;}");
document.write(".mSmallerInputROnly { margin-left:2px; width: "+cmnControlSmallerW+"px; background: #EBEBE4; border:1px solid #A8A8A8; }");
document.write(".mSmallerTextArea { margin-left:2px; width: "+cmnControlSmallerW+"px; }");
document.write(".mSmallerInputROnly { margin-left:2px; width: "+cmnControlSmallerW+"px; background: #EBEBE4; border:1px solid #A8A8A8; }");
document.write(".mSmallerSelect { margin-left:2px; width: "+(cmnControlSmallerW+4)+"px; }");
document.write(".mSmallercheckbox {margin-left:2px; }");

document.write(".mSmallestInput { margin-left:2px; width: "+cmnControlSmallestW+"px; padding-left: 2px;}");
document.write(".mSmallestInputROnly { margin-left:2px; width: "+cmnControlSmallestW+"px; background: #EBEBE4; border:1px solid #A8A8A8; }");
document.write(".mSmallestTextArea { margin-left:2px; width: "+cmnControlSmallestW+"px; }");
document.write(".mSmallestInputROnly { margin-left:2px; width: "+cmnControlSmallestW+"px; background: #EBEBE4; border:1px solid #A8A8A8; }");
document.write(".mSmallestSelect { margin-left:2px; width: "+(cmnControlSmallestW+4)+"px; }");
document.write(".mSmallestcheckbox {margin-left:2px; }");

/* Login Page Style Start */
document.write(".centerTbl {width: "+centerTbl+"px; margin: 0px;}");
/* Login Page Style End */



/* Landing Page Style End */


var menuTabIFrameHeight=(cmnScreenH-45+menuCorrection-10);
var menuInnerTabWidth=cmnScreenW+menuInnerWidthCorrection;
var menuInnerTabHeight=menuTabIFrameHeight+menuInnerHeightCorrection;

var TabWidth=cmnScreenW+WidthCorrection-12;
var TabContentWidth=TabWidth-8;
var GridWidth=TabWidth-10;
var InnerTabContentWidth=TabWidth-15;

/* Menu Frame Style Start */
document.write(".tabIFrameStyleSingleScreen { height:"+(menuTabIFrameHeight)+"px !important; width:99.4%; margin:4px !important;}");
document.write(".tabIFrameStyleMultiScreen { height:"+(menuTabIFrameHeight-28)+"px !important; width:99.4%; margin:4px !important;}");
/* Menu Frame Style End */


/* Inner Tab Style Start */
document.write(".innerTabHeight { height:"+(menuTabIFrameHeight-45)+"px !important;}");
document.write(".innerTabFullHeight { height:"+(menuTabIFrameHeight+4)+"px !important;}");
document.write(".screenFullHeight { height:"+(cmnScreenH-7)+"px !important;}");
document.write(".TabWidth { width:"+(TabWidth)+"px !important;}");
document.write(".TabContentWidth { width:"+(TabContentWidth)+"px !important;}");
document.write(".InnerTabContentWidth { width:"+(InnerTabContentWidth)+"px !important;}");
/* Inner Tab Style End */


document.write("");


document.write("</style>");