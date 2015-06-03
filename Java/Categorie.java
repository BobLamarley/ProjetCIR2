import java.util.HashSet;
import java.util.Set;

/**
 * Created by Thomas on 21/05/2015.
 */


public class Categorie {
    //Intitule de la categorie
    private String libelle = "";

    private Set<JeuReponse> listJeuReponse = new HashSet<JeuReponse>();


    public Categorie( String libelle ) {

        this.libelle = libelle;

    }
    public Categorie(){};

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<JeuReponse> getListJeuReponse() {
        return  listJeuReponse;
    }

    public void setListJeuReponse(Set<JeuReponse> listJeuReponse) {
        this.listJeuReponse =  listJeuReponse;
    }

    //Ajoute une question à un jeu de question
    public void addJeuReponse(JeuReponse jeuReponse){
        if(!this.listJeuReponse.contains(jeuReponse)) {
            this.listJeuReponse.add(jeuReponse);
        }
    }

    //Retire une question à un jeu de questions
    public void removeJeuReponse(JeuReponse jeuReponse){
            this.listJeuReponse.remove(jeuReponse);
    }

    public String toString(){
        String str = 	"Libelle categorie : " + this.getLibelle() + "\n";
        str +=			"LISTE DES jeu de réponse et questions associée a cette categorie : \n";
        for(JeuReponse jeuReponse : this.listJeuReponse) {
            str += jeuReponse.toString() + "\n";
        }
        str +=			"\n.....................................\n";

        return str;
    }
    public void TransformToText(){

        System.out.println("Libelle Categorie : " + this.getLibelle()  );

    }


}