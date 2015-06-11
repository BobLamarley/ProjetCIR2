<?php
require("entete.php");
require("ScoreDAO.php");
?>

<h2>Palmarès</h1>
<div class="row">
	<div class="col-sm-12">
		<a href="menuprincipal.php" class="btn btn-lg btn-primary" >Menu principal</a>
	</div>
</div>

<div class="container">    
  <table class="table table-hover table-condensed" id="tableaupalma">
    <thead>
      <tr>
          <th>Position</th>
        <th>Pseudo</th>
          <th>Score</th>
        <th>Temps Moyen</th>
        
      </tr>
    </thead>
    <tbody>
        
            <?php
            $ScoreDAO = new ScoreDAO();
            $res = $ScoreDAO->getPalmares();
         

      for ( $i=0 ; $i < sizeof($res);  $i++ ) {
        echo '<tr>';
        
        $j=$i+1;
            
        

       
                echo '<th >'.$j.'</th>';
                echo '<th >'.$res[$i]->getPseudo().'</th>';
               echo '<th >'.$res[$i]->getTempsMoy().'</th>';
                echo '<th >'.$res[$i]->getScore().' sec/rep</th>';
           
               
            
            
        
        
            
        
        echo '</tr>';
    }
          ?>                             
                                     
    </tbody>
  </table>
</div>


</body>
</html>