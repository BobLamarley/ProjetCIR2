<?php
session_start();
require("entete.php");

 if(!isset($_SESSION['rageQuit'])){
        $_SESSION['rageQuit'] = true; // Cette variable vaut true si la personne a quitté la partie en cours de partie , sinon elle vaut false car elle sera mis a false dans finjeusolo.php , elle sert a la remise a 0 des constantes importantes du jeu
    } else if ($_SESSION['rageQuit'] == false &&  $_SESSION['jeu'] == 0){
     $_SESSION['rageQuit'] = true;
    }
 if ($_SESSION['rageQuit'] == true ){
        $_SESSION['boolShowResult'] = false;
        $_SESSION['jeu'] = 0;
        $_SESSION['score'] = 0;
      $_SESSION['tempsmoy'] = 0;
    }
var_dump($_SESSION);
?>

<h2>Menu principal</h1>
<div class="row">
	<div class="col-sm-4">
		<a href="annoncetheme.php" class="btn btn-lg btn-primary" >Jeu Solo</a>
	</div>
	<div class="col-sm-4">
		<a href="menuprincipal.php" class="btn btn-lg btn-primary" >Jeu Multijoueur</a>
	</div>
	<div class="col-sm-4">
		<a href="palmares.php" class="btn btn-lg btn-primary" >Palmarès</a>
	</div>
    
   
</div>


</body>
</html>