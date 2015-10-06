/********************************************************************************************************************
	Mobile Menu
********************************************************************************************************************/	


$(document).ready(function(){
  $("#trigger").click(function(){
    $(".main-navigation").slideToggle(500);
  });
});


/********************************************************************************************************************
	Icon Nav Pop-up
********************************************************************************************************************/	


$(document).ready(function(){
  
  $("#main-section").click(function(){
    $(".icon-menus > ul > li, .right-nav > ul > li").removeClass('show-pop-up');
  });
	
  $(".icon-menus > ul > li").click(function(){
	  if(!$(this).hasClass('show-pop-up')){
		$(".icon-menus > ul > li").removeClass('show-pop-up');
		$(this).addClass('show-pop-up');
	  }
	  else{
		  $(".icon-menus > ul > li").removeClass('show-pop-up');
	  }
  });
	
  $(".right-nav > ul > li").click(function(){
	  if(!$(this).hasClass('show-pop-up')){
		$(".right-nav > ul > li").removeClass('show-pop-up');
		$(this).addClass('show-pop-up');
	  }
	  else{
		  $(".right-nav > ul > li").removeClass('show-pop-up');
	  }
  });
  
});


/********************************************************************************************************************
	Accordion
********************************************************************************************************************/	

$(document).ready(function() {
	 
	//ACCORDION BUTTON ACTION (ON CLICK DO THE FOLLOWING)
	$('.accordionButton').click(function() {

		//REMOVE THE ON CLASS FROM ALL BUTTONS
		$('.accordionButton').removeClass('on');
		  
		//NO MATTER WHAT WE CLOSE ALL OPEN SLIDES
	 	$('.accordionContent').slideUp('normal');
   
		//IF THE NEXT SLIDE WASN'T OPEN THEN OPEN IT
		if($(this).next().is(':hidden') == true) {
			
			//ADD THE ON CLASS TO THE BUTTON
			$(this).addClass('on');
			  
			//OPEN THE SLIDE
			$(this).next().slideDown('normal');
		 } 
		  
	 });
	
	/*** REMOVE IF MOUSEOVER IS NOT REQUIRED ***/
	
	//ADDS THE .OVER CLASS FROM THE STYLESHEET ON MOUSEOVER 
	$('.accordionButton').mouseover(function() {
		$(this).addClass('over');
		
	//ON MOUSEOUT REMOVE THE OVER CLASS
	}).mouseout(function() {
		$(this).removeClass('over');										
	});
	
	/*** END REMOVE IF MOUSEOVER IS NOT REQUIRED ***/

/********* CLOSES ALL S ON PAGE LOAD *********/	
	$('.accordionContent').hide();

});


