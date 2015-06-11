<?php
header("Location: ../vue/jeusolo.php");
session_start();

var_dump($_SESSION);

$_SESSION['boolShowResult'] = false;

var_dump($_SESSION);

?>