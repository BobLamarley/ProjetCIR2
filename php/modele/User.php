<?php
class User {
    // Eléments de notre utilisateur
    var $username;
    var $id;

   // function User(){}
    
    function User($id , $username){
        $this->id = $id;
        $this->username = $username;
    }
    
    function getUsername() {
       return $this->username;
    }
    function setUsername($username){
        $this->username = $username;
    }
    
    function getId(){
        return $this->id;
    }
    
    function setId($id){
        $this->id = $id;
    }
}
?>