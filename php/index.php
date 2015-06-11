<?php
session_start();
require("entete.php");
require("connect.php");


?>

<div class="row">
	<div class="col-sm-6">
		<img src="images/seloupoivre.jpg" width="600" height="400">
	</div>
	<div class="col-sm-6">
	
        <form method="post" action="traitementlog.php"  enctype="multipart/form-data">
            <p>
    	<label>Votre pseudo</label> : <input type="text" name="pseudo"/>
	       </p>
            <?php
    if (isset($_SESSION['boolLogSuccessful'] )){
        if($_SESSION['boolLogSuccessful'] == false ){
            echo'Veuillez rentrer un pseudo';
        }
    }
            ?>
		<input type="submit" style="visibility:hidden;" ><button  class="btn btn-lg btn-primary" >Jouer !</button></input>
        
        </form>
	</div>
</div>




</body>
</html>