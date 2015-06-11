<?php
require_once("../controlleur/connect.php");
require("../modele/Score.php");

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
                $score[$i] = new Score($row['idscore'],$row['idpseudo'],$row['score'],$row['tempsrepmoy'],$row['pseudo']);
                
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
        $sql = "SELECT score.idscore,score.idpseudo,score.score,score.tempsrepmoy,joueur.pseudo FROM score ,joueur WHERE score.idpseudo = joueur.idpseudo AND score.idpseudo=".$userId." LIMIT 10";
        return $this->execute($sql);
    }

// Retrieves all scores associated by userName currently in the database.
    public function getPalmares() {
       $sql = "SELECT score.idscore,score.idpseudo,score.score,score.tempsrepmoy,joueur.pseudo FROM score ,joueur WHERE score.idpseudo =  joueur.idpseudo ORDER BY score.score DESC LIMIT 10 ";
        return $this->execute($sql);
    }

    public function insertPalmares($idpseudo , $score , $tempsmoy) {
       $sql = "INSERT INTO `score` (`idscore`, `idpseudo`, `score`, `tempsrepmoy`) VALUES (NULL, '".$idpseudo."', '".$score."', '".$tempsmoy."')";
        return $this->executeUpdate($sql);
    }

    
}




?>