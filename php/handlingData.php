<?php

header("Content-Type: text/plain"); // Utilisation d'un header pour spécifier le type de contenu de la page. Ici, il s'agit juste de texte brut (text/plain). 

$variable1 = (isset($_GET["var1"])) ? $_GET["var1"] : NULL;


if ($variable1 ) {
	// Faire quelque chose...
	echo "OK";
} else {
	echo "FAIL";
}

?>