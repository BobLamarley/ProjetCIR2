<?php
class Score {
    // Attributs de la classe Score 
    var $idpseudo;
    var $idscore;
    var $tempsmoy;
    var $score;
    var $pseudo;

    
    function Score($idscore , $idpseudo ,$tempsmoy , $score , $pseudo){
        $this->idpseudo = $idpseudo;
        $this->idscore = $idscore;
        $this->tempsmoy = $tempsmoy;
        $this->score = $score;
        $this->pseudo = $pseudo;
    
    }
    function getIdpseudo(){
        return $idpseudo;
    }
    
    function getIdScore(){
        return $idscore;
    }
    
    function getScore() {
       return $this->score;
    }
    function setScore($score){
        $this->score = $score;
    }
    
    function getTempsMoy(){
        return $this->tempsmoy;
    }
    
    function setTempsMoy($tempsmpy){
        $this->tempsmoy = $tempsmoy;
    }
    function getPseudo(){
        return $this->pseudo;
    }
    
}
?>