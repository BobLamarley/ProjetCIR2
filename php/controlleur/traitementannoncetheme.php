<?php
session_start();
$test = $_SESSION['tour'][$_SESSION['jeu']];
$test3=sizeof($_SESSION['question'][$_SESSION['jeu']]);
echo'test333333 '.$test3.'';
$test4 = $_SESSION['jeu'];
echo'var jeu !!!!!'.$test4.'';


echo 'var tour jeu < nbjeu'.$test.'';
$test2 = $_SESSION['nbjeu'];
echo 'var nbjeu'.$test2.'';
if($_SESSION['tour'][$_SESSION['jeu']] >  sizeof($_SESSION['question']) ){
    if($_SESSION['jeu'] < ($_SESSION['nbjeu']-1) ){
        $_SESSION['jeu']+=1;
        header("Location: ../vue/annoncetheme.php");
    }else{
        $_SESSION['jeu']=0;
        header("Location: ../vue/finjeusolo.php");
    }
    
}


/*
if($_SESSION['tour'][$_SESSION['jeu']] < $_SESSION['nbjeu'] ){
    $_SESSION['jeu'] += 1;
    header("Location: jeusolo.php");
}else{
    header("Location: resultat.php");
}
*/
var_dump($_POST);

?> 