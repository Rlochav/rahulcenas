$(document).ready(function(){
setInterval(function(){autochange()},4500);
var index=1;
function autochange()
{

   $('.wrap').fadeOut(500);
   $('#wrap'+index).fadeIn();
   if(index<6) index++; else index=1;
}
});



function fflip(id){

  slideup();
    $(".ppanel"+id).slideDown("slow");
  }


function slideup(){

 $(".ppanelf1,.ppanelf2,.ppanelf3,.ppanelf4,.ppanelf5,.ppanelf6,.ppanelf7,.ppanelf8").slideUp("slow");

  }

