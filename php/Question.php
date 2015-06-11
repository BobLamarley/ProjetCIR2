<?php
class Question {
    // Eléments de notre utilisateur
    var $libelle;
    var $idjeurep;
    var $idquest;
    var $intitule;
    var $bonnerep;

   // function jeuReponse(){}
    
    function Question($libelle , $idjeurep, $idquest , $intitule, $bonnerep){
        $this->libelle= $libelle;
        $this->idjeurep = $idjeurep;
        $this->idquest = $idquest;
        $this->intitule = $intitule;
        $this->bonnerep= $bonnerep;
        
    }
    
    function getLibelle() {
       return $this->libelle;
    }
    function setLibelle($libelle){
        $this->libelle = $libelle;
    }
    
    function getIdJeuRep(){
        return $this->idjeurep;
    }
    
    function setId($idjeurep){
        $this->idjeurep = $idjeurep;
    }
    function getIntitule(){
        return $this->intitule;
    }
    function getBonneRep(){
        return $this->bonnerep ;
    }
}
?>