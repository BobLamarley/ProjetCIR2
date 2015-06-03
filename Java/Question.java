/**
 * Created by Thomas on 21/05/2015.
 */
public class Question {
    // Attributs
    private int idQuest;
    private String intitule;
    private int bonnerep;
    private String libelle ;
    private int idjeurep;
    
    // Constructeurs
        public Question(){}
        // Constructeur de questions avec connaissance de sa catégorie et don son jeud e reponse associé
        public Question(int idQuest , String intitule, int bonnerep , String libelle , int idjeurep){

            this.idQuest = idQuest;
            this.intitule=intitule;
            this.bonnerep = bonnerep;
            this.libelle = libelle;
            this.idjeurep = idjeurep;


        }

    // Accesseurs
    public int getIdQuest() {
        return idQuest;
    }

    public void setIdQuest(int idQuest) {
        this.idQuest = idQuest;
    }

    public int getBonneRep(){
        return bonnerep;
    }

    public void setBonnerep(int bonnerep){
        this.bonnerep = bonnerep;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getLibelle(){
        return libelle;
    }

    public int getIdjeurep(){
        return idjeurep;
    }

    public void setIdjeurep(int idjeurep){
        this.idjeurep = idjeurep;
    }

    public void TransformToText(){

        System.out.println("Id Question : " + this.getIdQuest() + "intitule Question :" + this.getIntitule() + "Bonne reponse :" + this.getBonneRep() + "Libelle : " + this.getLibelle() + "id jeu rep : " + this.getIdjeurep());

    }

}
