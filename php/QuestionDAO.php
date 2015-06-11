<?php
require_once("connect.php");
require("Question.php");

class QuestionDAO {
    private $bdd;
    
     function QuestionDAO(){  
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
                $quest[$i] = new Question($row['LIBELLE'],$row['IDJEUREP'],$row['IDQUEST'],$row['INTITULE'],$row['BONNEREP']);
                
                //$user[$i]->setId($row[IDPSEUDO]);
                //$user[$i]->setUsername($row[PSEUDO]);
                
            }
        }
        return $quest;
        
        $req->closeCursor();  // on ferme la co
    }
    
    // Execute specified query and return number , use for a COUNT in SQL request
public function executeCount($sql) {
        
        $res = $this->bdd->query($sql);
        //$num = $stmt->num_rows();
        $count =$res->fetch(PDO::FETCH_ASSOC);
     return $count;
        
        $req->closeCursor();  // on ferme la co
    }
    
  // Retrieves the corresponding row for the specified Jeu Rep ID.
    public function getByIdJeuRep($idJeuRep) {
        $sql = "SELECT * FROM questions WHERE IDJEUREP= '".$idJeuRep."'";
        return $this->execute($sql);
    }
    
    
    //Random questions in array Question
    public function getRandomQuestions($idJeuRep){
        $nbQuest = 4;  // Constante qui définit le nombre de questions par jeu de rep qui défileront dans le jeu
        $array = $this->executeCount("SELECT COUNT(*) FROM questions WHERE IDJEUREP= '".$idJeuRep."'");
        $sql = "SELECT * FROM questions WHERE IDJEUREP=".$idJeuRep." ORDER BY RAND() LIMIT ".$nbQuest;
        
       // if( $array['COUNT(*)'] > $nbQuest ){
              return $this->execute($sql);
        //}else{
           echo 'Il manque des questions associée à ce jeu de réponse , veuillez en rajouter ';
       //}
     
                 
    }

// Retrieves all users currently in the database.
    public function getQuestions() {
        $sql = " SELECT * FROM questions ";
        return $this->execute($sql);
    }
    

    

    

    
}




?>