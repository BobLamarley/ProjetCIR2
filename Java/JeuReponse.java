import java.util.HashSet;
import java.util.Set;

/**
 * Created by Thomas on 21/05/2015.
 */
public class JeuReponse {
    private int id;
    private String Libelle;
    private String rep1;
    private String rep2;

    public JeuReponse(){}  // consturucteur par defaut

    private Set<Question> listQuestion = new HashSet<Question>();

    public JeuReponse(String Libelle , int id , String rep1 , String rep2 ){
        this.id = id;
        this.Libelle = Libelle ;
        this.rep1 = rep1;
        this.rep2 = rep2;


    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }
    public  int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getRep1(){
        return rep1;
    }

    public void setRep1(String rep1){
        this.rep1=rep1;
    }

    public String getRep2(){
        return rep2;
    }

    public void setRep2(String rep2){
        this.rep2=rep2;
    }

    public Set<Question> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(Set<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    //Ajoute une question à un jeu de question
    public void addQuestion(Question question){
        System.out.println("Methode AddQuestion");
        if(!this.listQuestion.contains(question)) {
            System.out.println("La question s'ajoute bien.");
            this.listQuestion.add(question);
        }
    }
    //public Question getQuestion(int id){
       // return this.listQuestion.get(id);
   // }
    //Retire une question à un jeu de questions
    public void removeQuestion(Question question){
        this.listQuestion.remove(question);
    }

    public String toString(){
        String str = 	"Id jeu reponse : " + this.getId() + "\n";
        str += 			"rep1 : " + this.getRep1() + "\n";
        str += 			"rep1 : " + this.getRep2() + "\n";
        str +=			"LISTE DES Questions : \n";
        for(Question question : this.listQuestion) {
            str += question.toString() + "\n";
        }
        str +=			"\n.....................................\n";

        return str;
    }

    public String transformToText(){
        String strRep = this.getRep1() + ", " + this.getRep2() + ", les deux"; 
       return strRep;

    }
}
