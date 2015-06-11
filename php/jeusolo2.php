<?php
require ("entetejs.php");
require("JeuReponseDAO.php");
require("QuestionDAO.php");
session_start(); // pour stocker la catégorie choisie pour plus tard
$theme = $_SESSION['theme'];


// Création de la var de sess boolShowResult pour savoir si on aff la page de question ou la page identique mais qui affiche la bonne rép

if(!isset($_SESSION['boolShowResult'])){
    $_SESSION['boolShowResult'] = false;
}

echo'var boolshowresult ';
var_dump($_SESSION['boolShowResult']);

$jeu =  $_SESSION['tour'][$_SESSION['jeu']];
echo 'var jeu camamamamama'.$jeu.'';

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
    header("Location: traitementannoncetheme.php"); // page a apeller quand le jeu sera fini
}


echo 'lzlfllflf'.$taille.'';


?>


<div class="row">
  <div >
<h2>Bienvenue</h2>
    </div>
</div>
<!--
<script>
  function timer() {
      
    $(".progress-bar").css("width", n + "%");
      
    $("#pourcentage").text(n + "%");
      var n=0;
    if(n < 100) {
      setTimeout(function() {
        timer(n + 10);
      }, 1000);
    }
  }
  
</script>
-->
<?php
      if($_SESSION['boolShowResult'] == false){
echo'
<div class="progress">
  <div class="progress-bar progress-bar-striped  progress-bar-success active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
    <span class="sr-only">100% Complete</span>
  </div>
</div>';
      }
?>





<div class="row">
  <div >
      <?php
      if($_SESSION['boolShowResult'] == false){
          
        echo ' <div class="display" id="bip"></div>';
        echo '<script language="JavaScript">
            var counter = 10;
            var intervalId = null;
            function action(){
                    clearInterval(intervalId);
                    document.getElementById("bip").innerHTML = "TERMINE!";
                   
            }
            function bip(){
                document.getElementById("bip").innerHTML = counter + " secondes restantes";
                counter--;
                
            
                
            }
            function compteur(){
                intervalId = setInterval(bip, 1000);
                setTimeout(action, counter * 1000);
                
            }
            
           $("#btnrep").click( function (){
            cont = counter;
            $.ajax({
            url : "traitementbonnerep.php",
            type : "POST", // Le type de la requête HTTP, ici devenu POST
            data : "counter=" + cont, // On fait passer nos variables, exactement comme en GET, au script more_com.php
            dataType : "html"

    });

});
            
            
      </script>';
      }

        ?>
      
     
     <?php
for($i=0;$i<$taille;$i++){
    var_dump($_SESSION['question'][$_SESSION['jeu']][$i]);
}

    $ind = $tour -1;
    $question = $_SESSION['question'][$_SESSION['jeu']][$ind];  // Pourquoi ca fait de la merde
echo'LE CHAMEAUUUUUUU4';
    var_dump($question);
    var_dump($_SESSION);
    $intitule = $question->getIntitule();
    $_SESSION['bonnerepcurr'] = $question->getBonneRep(); // numero de la bonne réponse associée a la question courante
    $bonnerepcurr = $_SESSION['bonnerepcurr'] ;
    

    echo 'Question '.$tour.':'.$intitule.'';

var_dump($_POST);
        

    ?>
      
    </div>
</div>

<div class="row">
    
   
            <?php if($_SESSION['boolShowResult'] == true){
        
                                    echo 'la bonne réponse était :';
                    } 
            ?>
    
</div>         
        <div class="row">
        <div class="col-sm-offset-2 col-sm-3">
            <input type="submit" style="visibility:hidden;" > <button onclick="postcount()" name="btnrep" id="btnrep" type ="submit" value="1" <?php 
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
    
        <div class="col-sm-3">
            <input type="submit" style="visibility:hidden;" >  <button onclick="postcount()" name="btnrep" id="btnrep" type ="submit" value="2" <?php 
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

        <div class="col-sm-3">
         <input type="submit" style="visibility:hidden;" value="3" ><button onclick="postcount()" id="btnrep" name="btnrep" type="submit" value="3" <?php 
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
       <?php if($_SESSION['boolShowResult'] == true){
        
                                echo'  <input type="submit" style="visibility:hidden;" value="6" ><button class="btn btn-lg btn-danger" name="nextq" type="submit" value="6">Question Suivante </button></input>';
                    } 
            ?>
                
        
</div>


</body>
</html>