<?php
class JeuReponse {
    // Eléments de notre utilisateur
    var $libelle;
    var $idjeurep;
    var $rep1;
    var $rep2;

   // function jeuReponse(){}
    
    function JeuReponse($libelle , $idjeurep, $rep1 , $rep2){
        $this->libelle= $libelle;
        $this->idjeurep = $idjeurep;
        $this->rep1 = $rep1;
        $this->rep2= $rep2;
        
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
     function getRep1(){
        return $this->rep1;
    }
    function getRep2(){
        return $this->rep2;
    }
}
?>