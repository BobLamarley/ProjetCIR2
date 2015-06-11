var i = 100;

var counterBack = setInterval(function(){
  i=i-1;
  if(i>=0){
    
    $('.progress-bar').css('width', i + '%');
  } else {
      alert("maman a laide");
    window.location.href = "traitementbonnerep.php";
    
    
  }
}, 100);

