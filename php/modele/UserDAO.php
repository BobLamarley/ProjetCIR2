<?php
require_once("../controlleur/connect.php");
require("../modele/User.php");

class UserDAO {
    private $bdd;
    
     function UserDAO(){  
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
                $user[$i] = new User($row['idpseudo'],$row['pseudo']);
                
                //$user[$i]->setId($row[IDPSEUDO]);
                //$user[$i]->setUsername($row[PSEUDO]);
                
            }
        }
        return $user;
        
        $req->closeCursor();  // on ferme la co
    }
    
    
    // Executes the specified query and returns nothing
    public function executeInsert($sql) {
        
        $res = $this->bdd->query($sql);
        
        $res->closeCursor();  // on ferme la co
    }
    
    

  // Retrieves the corresponding row for the specified user ID.
    public function getByUserId($userId) {
        $sql = "SELECT * FROM joueur WHERE idpseudo= '".$userId."'";
        return $this->execute($sql);
    }
    
    // Retrieves the corresponding row for the specified user ID.
    public function getByUsername($username) {
        $sql = "SELECT * FROM joueur WHERE pseudo = '".$username."'";
        //echo ''.$sql.'';
        return $this->execute($sql);
    }

// Retrieves all users currently in the database.
    public function getUsers() {
        $sql = "SELECT * FROM joueur";
        return $this->execute($sql);
    }

    //Create a new User
    public function CreateUser($username){
        $sql = "INSERT INTO `joueur` (`idpseudo`, `pseudo`) VALUES (NULL, '".$username."')";
        $this->executeInsert($sql);
        
    }

    
}




?>