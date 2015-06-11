<?php
session_start();
require ("entete.php");
require ("UserDAO.php");
require ("ScoreDAO.php");

//var_dump($_SESSION);

// remise a 0 des variables qui font tourner le jeu
    $_SESSION['rageQuit'] = false;
    $_SESSION['jeu'] = 0;
    if(!isset($_SESSION['pseudo'])){
        $pseudo = "invite";
        
        $guestDAO = new UserDAO();
        $guest = $guestDAO->getByUsername($pseudo);
        if(sizeof($guest) == 0){
            $guestDAO->createUser($pseudo);
        }else{
            $idpseudo= $guestDAO['id'];
        }
         
        
        
    }else{
        
        $pseudo = $_SESSION['pseudo'];
        $userDAO = new UserDAO();
        $user = $userDAO->getByUsername($pseudo);
        $idpseudo = $user[0]->getID();
        //var_dump($user);
        
    }
       
    

       
    for($i=0;$i<sizeof($_SESSION['question']);$i++){
        $totquest = sizeof($_SESSION['question'][$i]);
    }
       
    $tot = ($_SESSION['nbjeu']*$totquest);
     // echo ''.$tot.'';
       
    $tempsmoy = $_SESSION['tempsmoy'] / $totquest;
    $score = $_SESSION['score'];
 //  echo 'tempsmoy'.$tempsmoy.'';
    if($tempsmoy <= 10 && $tempsmoy >=0 && isset($_SESSION['pseudo'] )){
        $scoreDAO = new ScoreDAO();
        $scoreDAO->insertPalmares($idpseudo, $score , $tempsmoy);
       
    }

// Si dans les 10 meilleurs score , ne pas oublier la redirection vers palmares.php
echo '<div class="row">';
echo '<div class="col-lg-offset-4 col-lg-4">';
echo '<h2> Votre pseudo : '.$pseudo.'';
echo '<h2> Score final :'.$score.'</h2>';
echo '<h2> Temps moyen de réponse :'.$tempsmoy.' sec/rep</h2>';
echo '</div></div>';
echo '<div class="row">';
echo '<div class="col-lg-offset-4 col-lg-4">';
echo '<a href="menuprincipal.php"><button  class="btn btn-lg btn-success">Retour vers le menu principal</button></a>';
echo '</div></div>';

?>


