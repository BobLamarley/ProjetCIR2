<?php
require_once("connect.php");
require("JeuReponse.php");

class JeuReponseDAO {
    private $bdd;
    
     function JeuReponseDAO(){  
         $db = new DBConnect();
         $bdd = $db->getDBConnect();
         $this->bdd = $bdd;
    }
    
// Executes the specified query and returns an associative array of results.
    public function execute($sql) {
        
        $res = $this->bdd->query($sql);
        //$num = $stmt->num_rows();
        
        if($res->rowCount() > 0) {
            for($i = 0; $i < $res->rowCount() ; $i++) {
                $row =$res->fetch(PDO::FETCH_ASSOC);
                $jeurep[$i] = new JeuReponse($row['LIBELLE'],$row['IDJEUREP'],$row['REP1'],$row['REP2']);
                
               
                
            }
        }
        return $jeurep;
        
        $req->closeCursor();  // on ferme la co
    }
    

  // Retrieves the corresponding row for the specified user ID.
    public function getByIdJeuRep($idJeuRep) {
        $sql = "SELECT * FROM jeureponses WHERE IDJEUREP= '".$idJeuRep."'";
        return $this->execute($sql);
    }
    

// Retrieves all users currently in the database.
    public function getJeuReponses() {
        $sql = "SELECT * FROM jeureponses";
        return $this->execute($sql);
    }
    
  
    public function getRandomJeuReponse(){
        $sql = "SELECT * FROM jeureponses ORDER BY RAND() LIMIT 1";
        return $this->execute($sql);
        
    }

    

    
}




?>