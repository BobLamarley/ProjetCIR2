<?php
require_once("connect.php");
require("Score.php");

class ScoreDAO {
    private $bdd;
    
     function ScoreDAO(){  
         $db = new DBConnect();
         $bdd = $db->getDBConnect();
         $this->bdd = $bdd;
    }
    
// Executes the specified query and returns an associative array of object score .
    public function execute($sql) {
        $res = $this->bdd->query($sql);
        
        if($res->rowCount() > 0) {
            for($i = 0; $i < $res->rowCount() ; $i++) {
                $row =$res->fetch(PDO::FETCH_ASSOC);
                $score[$i] = new Score($row['IDSCORE'],$row['IDPSEUDO'],$row['SCORE'],$row['TEMPSREPMOY'],$row['PSEUDO']);
                
            }
        }
        return $score;
        
        $req->closeCursor();  // Close Connection
    }
    
// Executes the specified query and returns an associative array of object score .
    public function executeUpdate($sql) {
        $res = $this->bdd->query($sql);
        
        $res->closeCursor();  // Close Connection
    }
     

  // Retrieves the corresponding row for the specified user ID.
    public function getByUserId($userId) {
        $sql = "SELECT score.IDSCORE,score.IDPSEUDO,score.SCORE,score.TEMPSREPMOY,joueur.PSEUDO FROM score ,joueur WHERE score.IDPSEUDO = joueur.IDPSEUDO AND score.IDPSEUDO=".$userId." LIMIT 10";
        return $this->execute($sql);
    }

// Retrieves all scores associated by userName currently in the database.
    public function getPalmares() {
       $sql = "SELECT score.IDSCORE,score.IDPSEUDO,score.SCORE,score.TEMPSREPMOY,joueur.PSEUDO FROM score ,joueur WHERE score.IDPSEUDO =  joueur.IDPSEUDO ORDER BY score.SCORE DESC LIMIT 10 ";
        return $this->execute($sql);
    }

    public function insertPalmares($idpseudo , $score , $tempsmoy) {
       $sql = "INSERT INTO `score` (`IDSCORE`, `IDPSEUDO`, `SCORE`, `TEMPSREPMOY`) VALUES (NULL, '".$idpseudo."', '".$score."', '".$tempsmoy."')";
        return $this->executeUpdate($sql);
    }

    
}




?>