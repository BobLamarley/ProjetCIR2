<?php

session_start();
//var_dump($_POST);
//var_dump($_SESSION);
$_SESSION['time'][$_SESSION['jeu']] = $_POST['time'];


//var_dump($_SESSION);
$bonnerep = $_SESSION['bonnerepcurr'];
$_SESSION['boolShowResult'] = true;
$taille = sizeof($_SESSION['question'][$_SESSION['jeu']]);
$tour = $_SESSION['tour'][$_SESSION['jeu']];

if ($tour <=  $taille){
    header("Location: jeusolo.php");
    
}


// Détermination du score
if( $bonnerep == $_POST['btnrep']){
    if($_SESSION['time'][$_SESSION['jeu']] >= 0 && $_SESSION['time'][$_SESSION['jeu']] < 10){
             $_SESSION['score'] =   $_SESSION['score'] +1;
             $_SESSION['tempsmoy'] += 9 ;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 10 && $_SESSION['time'][$_SESSION['jeu']] < 20){
             $_SESSION['score'] =   $_SESSION['score'] +2;
             $_SESSION['tempsmoy'] += 8;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 20 && $_SESSION['time'][$_SESSION['jeu']] < 30){
             $_SESSION['score'] =   $_SESSION['score'] +3;
             $_SESSION['tempsmoy'] += 7;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 30 && $_SESSION['time'][$_SESSION['jeu']] < 40){
             $_SESSION['score'] =   $_SESSION['score'] +4;
             $_SESSION['tempsmoy'] += 6;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 40 && $_SESSION['time'][$_SESSION['jeu']] < 50){
             $_SESSION['score'] =   $_SESSION['score'] +5;
             $_SESSION['tempsmoy'] += 5;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 50 && $_SESSION['time'][$_SESSION['jeu']] < 60){
             $_SESSION['score'] =   $_SESSION['score'] +6;
            $_SESSION['tempsmoy'] += 4;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 60 && $_SESSION['time'][$_SESSION['jeu']] < 70){
             $_SESSION['score'] =   $_SESSION['score'] +7;
             $_SESSION['tempsmoy'] += 3;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 70 && $_SESSION['time'][$_SESSION['jeu']] < 80){
             $_SESSION['score'] =   $_SESSION['score'] +8;
             $_SESSION['tempsmoy'] += 2;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 80 && $_SESSION['time'][$_SESSION['jeu']] < 90){
             $_SESSION['score'] =   $_SESSION['score'] +9;
              $_SESSION['tempsmoy'] += 1;
    }else if($_SESSION['time'][$_SESSION['jeu']] >= 90 && $_SESSION['time'][$_SESSION['jeu']] < 100){
             $_SESSION['score'] =   $_SESSION['score'] +10;
             $_SESSION['tempsmoy'] += 0;
    } else if ($_SESSION['time'][$_SESSION['jeu']] < 0){
             $_SESSION['tempsmoy'] += 10;
        
    }
    echo 'Vous avez trouver la bonne réponse';
                                                                                                     
}else{
        
    echo' t es vraiment nul ';
        
}

 

?>