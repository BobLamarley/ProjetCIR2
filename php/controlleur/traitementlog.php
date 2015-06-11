<?php
session_start();
require("../modele/UserDAO.php");

$userDAO = new UserDAO();
$res = $userDAO->getUsers();
var_dump($_POST);

$_SESSION['boolLogSuccessful'] = true;

if(!isset($_POST['pseudo']) || $_POST['pseudo'] == '' ){
    
    header("Location: ../vue/index.php");
    $_SESSION['boolLogSuccessful'] = false;
    
}else{
   

    $username = strtolower($_POST['pseudo']);
    $_SESSION['pseudo'] = $username;
    $boolUserExist = false; // Boolean to know if the user already exist in database or if we create new user

    for($i=0;$i<sizeof($res);$i++){
        if($username == $res[$i]->getUsername()){
              $boolUserExist = true;                                  
        }
    }


    if($boolUserExist == false){
        $userDAO->createUser($username);

    }
        // A faire tout le temps

    $user = $userDAO->getByUsername($username); // on rempli l'objet user , pour connaitre son idjoueur , ca servira plus tard


    header("Location: ../vue/menuprincipal.php"); // Commenter cette ligne pour voir ce qui ce passe pdt le traitement
}

?>