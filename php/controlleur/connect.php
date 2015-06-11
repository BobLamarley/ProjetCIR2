<?php

class DBConnect{
    
    private $bdd;
    
    function DBConnect(){
        try{
            $this->bdd = new PDO('mysql:host=127.0.0.1;dbname=example','root','', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'));
            $this->bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            

        }catch (Exception $e){
                die('Erreur : ' . $e->getMessage());
        }
       
        
    
    }
    
    function getDBConnect(){
        return $this->bdd;
    }
}
?>