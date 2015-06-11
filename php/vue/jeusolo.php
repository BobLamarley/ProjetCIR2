<?php
require ("entetejs.php");
require("../modele/JeuReponseDAO.php");
require("../modele/QuestionDAO.php");
session_start(); // pour stocker la catégorie choisie pour plus tard

$theme = $_SESSION['theme'];


// Création de la var de sess boolShowResult pour savoir si on aff la page de question ou la page identique mais qui affiche la bonne rép

if(!isset($_SESSION['boolShowResult'])){
    $_SESSION['boolShowResult'] = false;
}
if($_SESSION['boolShowResult'] == true ) {
    //var_dump($_SESSION);
}
//echo'var boolshowresult ';
//var_dump($_SESSION['boolShowResult']);

$jeu =  $_SESSION['tour'][$_SESSION['jeu']];

//echo 'var jeu camamamamama'.$jeu.'';
// Attention au rechargement de page /////////////////////////////////////////
if($_SESSION['boolShowResult'] == false ) {
    $_SESSION['tour'][$_SESSION['jeu']] = $_SESSION['tour'][$_SESSION['jeu']]+1;
    
}

$tour = $_SESSION['tour'][$_SESSION['jeu']];
$idjeurep = $_SESSION['idjeurep'][$_SESSION['jeu']];
$rep1 = $_SESSION['rep1'][$_SESSION['jeu']];
$rep2 = $_SESSION['rep2'][$_SESSION['jeu']];


$taille = sizeof($_SESSION['question'][$_SESSION['jeu']]);
//echo'var dump var session question ' ;
//var_dump($_SESSION['question'][1][1]);

if( $tour > $taille){
    header("Location: ../controlleur/traitementannoncetheme.php"); // page a apeller quand le jeu sera fini
}


//echo 'lzlfllflf'.$taille.'';

if($_SESSION['boolShowResult'] == false){
    echo '<script language="Javascript">

var i = 100;

var counterBack = setInterval(function(){
  i=i-1;
  if(i>=0){
    $(".progress-bar").css("width", i + "%");
  } else {
    window.location.href = "../controlleur/traitementbonnerep.php";
    
    
  }
}, 100);



</script>';
} 
?>





<div class="row">
 
      <?php
      if($_SESSION['boolShowResult'] == false){
          
        echo ' <div class="display" id="bip"></div>';
      }

        ?>
      
     
     <?php
for($i=0;$i<$taille;$i++){
    //var_dump($_SESSION['question'][$_SESSION['jeu']][$i]);
}

    $ind = $tour - 1;
    $question = $_SESSION['question'][$_SESSION['jeu']][$ind];  // Pourquoi ca fait de la merde
   //echo'LE CHAMEAUUUUUUU4';
   // var_dump($question);
   // var_dump($_SESSION);
    $intitule = $question->getIntitule();
    $_SESSION['bonnerepcurr'] = $question->getBonneRep(); // numero de la bonne réponse associée a la question courante
    $bonnerepcurr = $_SESSION['bonnerepcurr'] ;
    //echo ' bonnerepcurr:'.$_SESSION['bonnerepcurr'].'';  a décommenter pour etre le meilleur du monde 
    
   
   // echo 'score:'.$_SESSION['score'].'';

//var_dump($_POST);
        

    ?>
      
    </div>
</div>
<div class="row">
    <div class="col-lg-8 col-lg-offset-2">
 <?php

echo '<h2>Question n°'.$tour.' : '.$intitule.' </h2>';

echo '<p id="score">score:'.$_SESSION['score'].'</p>';
   


      if($_SESSION['boolShowResult'] == false){
echo'
<div class="progress">
  <div class="progress-bar progress-bar-striped  progress-bar-success active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
    <span class="sr-only">100% Complete</span>
  </div>
</div>';
      }
?>

</div>
</div>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2">
    <?php if($_SESSION['boolShowResult'] == false){ 
            echo '<form method="post" action="../controlleur/traitementbonnerep.php">';
        }else{
            echo '<form method="post" action="../vue/affbonnerep.php">';
    }
    ?>
    </div>
</div>
<div class="row">
    <div class="col-lg-4 col-lg-offset-4">
            <?php if($_SESSION['boolShowResult'] == true){
        
                                    echo '<p>la bonne réponse était :</p>';
                    } 
            ?>
    </div>
</div>
<div class="row">
        <div class="col-lg-offset-1 col-lg-3">
            <input type="submit" style="visibility:hidden;" > <button onclick="writeTime()" name="btnrep" id="btnrep" type="submit" value="1" 
                                                                      <?php 
             if($_SESSION['boolShowResult'] == true){ 
                 echo 'disabled="disabled"';
                 if($_SESSION['bonnerepcurr'] == 1){ 
                     echo 'class="btn btn-lg btn-warning"'; 
                 }else{ 
                     echo'class="btn btn-lg btn-info"';
                    }
              } else{ 
                     echo'class="btn btn-lg btn-info"';
             } 
        ?> > <?php echo ''.$rep1.'' ?></button></input>
        </div>
    
        <div class="col-lg-3">
            <input type="submit" style="visibility:hidden;" >  <button  onclick="writeTime()" name="btnrep" id="btnrep" type ="submit" value="2" <?php 
             if($_SESSION['boolShowResult'] == true){ 
                 echo 'disabled="disabled"';
                 if($_SESSION['bonnerepcurr'] == 2){ 
                     echo 'class="btn btn-lg btn-warning"'; 
                 }else{ 
                     echo'class="btn btn-lg btn-info"';
                 }
             } else{ 
                     echo'class="btn btn-lg btn-info"';
             } 
        ?> > <?php echo ''.$rep2.'' ?></button>               </input>
        </div>

        <div class="col-lg-3">
         <input type="submit" style="visibility:hidden;" value="3" ><button onclick="writeTime()" id="btnrep" name="btnrep" type="submit" value="3" <?php 
             if($_SESSION['boolShowResult'] == true){ 
                 echo 'disabled="disabled"';
                 if($_SESSION['bonnerepcurr'] == 3){ 
                     echo 'class="btn btn-lg btn-warning"'; 
                 }else{ 
                     echo'class="btn btn-lg btn-info"';
                }
             }else{ 
                     echo'class="btn btn-lg btn-info"'; 
             }   
        ?>> Les deux</button></input>
        </div>
</div>
        <?php if($_SESSION['boolShowResult'] == false){ echo'<input type="hidden" id="time" name="time" value="100"  ></input>'; } ?>

<div class="row" id="space">
    <div class="col-lg-2 col-lg-offset-5">
       
           
       <?php if($_SESSION['boolShowResult'] == true){
        
                                echo'  <input type="submit" style="visibility:hidden;" value="6" ><button class="btn btn-lg btn-danger" name="nextq" type="submit" value="6">Question Suivante </button></input>';
            
                    } 
          
               
      

            ?>
         </form> 
  
</div>

        
</div>


<script type="application/javascript">
function writeTime(){
    document.getElementById('time').value = i;
}
</script>


</html>