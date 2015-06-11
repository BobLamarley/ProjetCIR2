<?php
require ("entetejs.php");
require ("../modele/JeuReponseDAO.php");
require ("../modele/QuestionDAO.php");
session_start(); // pour stocker la catégorie choisie pour plus tard

?>


<div class="row">
  <div class="col-lg-8 col-lg-offset-2">
      <?php
    
     
    
 if (!isset($_SESSION['jeu'])){
        $_SESSION['jeu'] = 0; // Si cette variable vaut 0 , on est alors dans le premier jeu de question , elle servira a acceder aux tableaux avec les indices 
    }

   
    $nbJeu = 2; // Var qui def le nombre de tour de questions dans des themes differents
    $_SESSION['nbjeu'] = $nbJeu;
   

    // Choix du premier jeu de rep
    for($i=0;$i<$nbJeu;$i++){
        $jeuReponseDAO = new JeuReponseDAO();
        $res[$i] = $jeuReponseDAO->getRandomJeuReponse();
        if($i>0){
            
            $sortab = array_unique($res,SORT_REGULAR);
            
            if ( sizeof($sortab) > $i){
            //    echo ' pas de doublons ';
            }else{
                $i=$i-sizeof($sortab) ;
               // var_dump($i);
            }
        }
    }

    $sortab = array_unique($res,SORT_REGULAR); 
    $longsortab = sizeof($sortab);
/*
echo 'jeureponse';
 var_dump($jeuReponseDAO);
    echo'tab non trie de jeurep';
        print_r($res);
    echo'tab trie';
    var_dump($sortab);
    echo ' long tab trie';
    var_dump($longsortab);
*/
    
    $_SESSION['theme'] = array();
    $_SESSION['tour'] = array();
    $_SESSION['idjeurep'] = array();
    $_SESSION['rep1'] = array();
    $_SESSION['rep2'] = array();

      
   for($j=0;$j<$nbJeu;$j++){
      // var_dump($j);
    $theme = $sortab[$j][0]->getLibelle();
       //echo'prout';
      // var_dump($theme);
    $idjeurep = $sortab[$j][0]->getIdJeuRep();
   
    $_SESSION['theme'][$j] = $theme;
    $_SESSION['tour'][$j] = 0;
    
    $_SESSION['idjeurep'][$j] = $idjeurep;
   
    $jeuReponseDAO = new JeuReponseDAO();
    $result[$j] = $jeuReponseDAO->getByIdJeuRep($idjeurep);
       
  $rep1 = $result[$j][0]->getRep1();
   $rep2 = $result[$j][0]->getRep2();
   $_SESSION['rep1'][$j] = $rep1;
   $_SESSION['rep2'][$j] = $rep2;
    
   }

//var_dump($_SESSION);
//echo'result';
// var_dump($result);

    $questionDAO = new QuestionDAO();
   

    
    //var_dump($idjeurep);
    //var_dump($_SESSION);
    $_SESSION['question'] = array();

for ($k=0;$k<$nbJeu;$k++){
     $question[$k] = $questionDAO->getRandomQuestions( $_SESSION['idjeurep'][$k]);
    $_SESSION['question'][$k] = $question[$k];
}
    /*
    echo'var_dump var sess';
    var_dump($_SESSION['question']);
    
    
    echo'var sess';
    var_dump($_SESSION);
    
    var_dump($_SESSION['theme'][$_SESSION['jeu']]);
    */
  

    //echo 'Question '.$tour.':'.$q1.'';
    $tour = $_SESSION['jeu']+1;
      echo '<h2>Thème du tour n°'.$tour.' : '.$_SESSION['theme'][$_SESSION['jeu']] .' </h2>';
     

 ?>   
      
      </p>
        
        <p> Etes vous prêts ?  </p>
        
	
        <a href="../vue/jeusolo.php"><button  class="btn btn-lg btn-primary" id="btnstart" data-toggle="modal" data-target="#myModal">Oui je suis prêt</button></a>
    
    
    
<!-- 
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
Jouer
</button>


<div class="modal fade show" id="myModal"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
       <a href="jeusolo.php"><button  class="btn btn-lg btn-primary" id="btnstart" data-toggle="modal" data-target="#myModal">Oui je suis prêt</button></a>
      </div>
    </div>
  </div>
</div>
  
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    -->
</div>
</div>


</body>
</html>