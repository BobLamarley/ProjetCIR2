<?php
require ("entete.php");
require ("JeuReponseDAO.php");
require ("QuestionDAO.php");
session_start(); // pour stocker la catégorie choisie pour plus tard

?>

<h2>Annonce du thème choisit aléatoirement :</h1>
<div class="row">
  <div class="col-sm-4">
      <p>
    <?php
    
        $jeuReponseDAO = new JeuReponseDAO();
        $res= $jeuReponseDAO->getRandomJeuReponse();
    
        
   
    $theme = $res[0]->getLibelle();
    $idjeurep = $res[0]->getIdJeuRep();

    $_SESSION['theme'] = $theme;
    $_SESSION['tour'] = 0;
    $_SESSION['idjeurep'] = $idjeurep;
    
    $result = $jeuReponseDAO->getByIdJeuRep($idjeurep);
    $rep1 = $result[0]->getRep1();
    $rep2 = $result[0]->getRep2();
    $_SESSION['rep1'] = $rep1;
    $_SESSION['rep2'] = $rep2;
    

    $questionDAO = new QuestionDAO();
    $question = $questionDAO->getRandomQuestions($idjeurep);

    var_dump($question);
    var_dump($idjeurep);

    $_SESSION['question'] = $question;

    echo'var_dump var sess';
    var_dump($_SESSION['question']);
    
    
    echo'var sess';
    var_dump($_SESSION);

    echo'<h3>'.$theme.'</h3>';

    //echo 'Question '.$tour.':'.$q1.'';

    ?>
      
      </p>
        
        <label> Etes vous prêts ?  </label>
        
	
        <a href="jeusolo.php"><button  class="btn btn-lg btn-primary" id="btnstart" >OUIIIII</button></a>
            
        
    
    </div>
</div>


</body>
</html>