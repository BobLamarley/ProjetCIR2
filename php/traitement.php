<?php


require("menuprincipal.php");
//require("QuestionDAO.php");
//require("JeuReponseDAO.php");
require("ScoreDAO.php");

$id = $_POST['id'];
//$UserDAO = new UserDAO();
//$JeuReponseDAO = new JeuReponseDAO();
//$res = $UserDAO->getByUserId($id);
//$res = $UserDAO->getUsers();
//$res = $JeuReponseDAO->getRandomJeuReponse();
//var_dump($res);

//$libelle = $res[0]->getLibelle();
//$QuestionDAO = new QuestionDAO();
//$res2 = $QuestionDAO->getRandomQuestion(3);
//$res = $QuestionDAO->getQuestions();
//$JeuReponseDAO = new JeuReponseDAO();
//$res2 = $JeuReponseDAO->getRandomJeuReponse();


// Test de la classe scoreDAO
$ScoreDAO = new ScoreDAO();
$res2 = $ScoreDAO->getPalmares();
var_dump($res2);
//var_dump($res);


?>