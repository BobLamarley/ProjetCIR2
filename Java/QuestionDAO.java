/**
 * Created by Thomas on 26/05/2015.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class QuestionDAO extends DAO<Question> {

    public QuestionDAO(Connection connect) {
        super(connect);
    }
    public Question create(Question obj ) {

        int idQuest = obj.getIdQuest();
        String  intitule = obj.getIntitule();
        int bonnerep = obj.getBonneRep();
        String libelle = obj.getLibelle();
        int idjeurep = obj.getIdjeurep();
        // libelle = theme des questions , inititule = questions
System.out.println("INSERT INTO `basetest`.`questions` (`LIBELLE`, `IDJEUREP`, `IDQUEST`, `INTITULE`, `BONNEREP`) VALUES ( "+libelle+", "+idjeurep+","+idQuest+", "+intitule+", "+bonnerep+");" );

        try {
          this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO `basetest`.`questions` (`LIBELLE`, `IDJEUREP`, `IDQUEST`, `INTITULE`, `BONNEREP`) VALUES ( '"+libelle+"', '"+idjeurep+"','"+idQuest+"', '"+intitule+"', '"+bonnerep+"');" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
// Methode de suppression d'une question en passant un objet de type Question en param
    public Question delete(Question obj) {

        int idQuest = obj.getIdQuest();
        //String  intitule = obj.getIntitule();
        //String bonnerep = obj.getBonneRep();
        String libelle = obj.getLibelle();
        int idjeurep = obj.getIdjeurep();

        // libelle = theme des questions , inititule = questions
        System.out.println("DELETE FROM `basetest`.`questions` WHERE `questions`.`LIBELLE` = '"+libelle+"' AND `questions`.`IDJEUREP` = "+idjeurep+" AND `questions`.`IDQUEST` = "+idQuest+"" );

        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `basetest`.`questions` WHERE `questions`.`LIBELLE` = '"+libelle+"' AND `questions`.`IDJEUREP` = "+idjeurep+" AND `questions`.`IDQUEST` = "+idQuest+"" );
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return obj;
    }
    // Methode de suppression d'un jeu de question asssociée a une jeu de rep en passant son id en param
    public Question deleteAll(int idjeurep) {

        Question q = new Question();

        // libelle = theme des questions , inititule = questions
        System.out.println("DELETE FROM `questions` WHERE  `questions`.`IDJEUREP` = "+idjeurep+";" );

        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `questions` WHERE  `questions`.`IDJEUREP` = "+idjeurep+";" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return q;

    }

    // Methode de suppression d'un jeu de question asssociée a une jeu de rep en passant son libelle en param
    public Question deleteAll(String libelle) {

        Question q = new Question();

        // libelle = theme des questions , inititule = questions
        System.out.println("DELETE FROM `questions` WHERE  `questions`.`LIBELLE` = '"+libelle+"';" );

        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `questions` WHERE  `questions`.`LIBELLE` = '"+libelle+"';" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return q;

    }
// Methode d'update d'une question en passant en param un obj de type Question
    public Question update(Question obj) {

        int idQuest = obj.getIdQuest();
        String  intitule = obj.getIntitule();
        int bonnerep = obj.getBonneRep();
        String libelle = obj.getLibelle();
        int idjeurep = obj.getIdjeurep();

        // libelle = theme des questions , inititule = questions
        System.out.println("UPDATE `basetest`.`questions` SET `INTITULE` = '"+intitule+"', `BONNEREP` = '"+bonnerep+"' WHERE `questions`.`LIBELLE` = '"+libelle+"' AND `questions`.`IDJEUREP` = "+idjeurep+" AND `questions`.`IDQUEST` = "+idQuest+";" );

        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `basetest`.`questions` SET `INTITULE` = '" + intitule + "', `BONNEREP` = '" + bonnerep + "' WHERE `questions`.`LIBELLE` = '" + libelle + "' AND `questions`.`IDJEUREP` = " + idjeurep + " AND `questions`.`IDQUEST` = " + idQuest + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;

    }
    // methode d'update de question avec son id de jeu de rep


    /*
    // Methode d'update d'une question en passant en param l'idjeurep associé
    public Question update(int idjeurepChange , int idjeurepStatic) {


        // libelle = theme des questions , inititule = questions
        System.out.println("UPDATE `questions` SET `IDJEUREP` = '"+idjeurepChange+"' WHERE `questions`.`IDJEUREP` = "+idjeurepStatic+";" );

        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `basetest`.`questions` SET `INTITULE` = '"+intitule+"', `BONNEREP` = '"+bonnerep+"' WHERE `questions`.`LIBELLE` = '"+libelle+"' AND `questions`.`IDJEUREP` = "+idjeurep+" AND `questions`.`IDQUEST` = "+idQuest+";" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;

    }
    */
    // Recherche d'UNE questions associée a son jeu de reponse
    public Question find(int id) {
        Question question = new Question();


        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM questions WHERE IDJEUREP = " + id);


            if (result.first())
                question = new Question(
                        result.getInt(3), new String(result.getString(4)), result.getInt(5), new String(result.getString(2)), id);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    // Methode qui retourne toutes les questions associées à un jeu de reponses
    public Vector<Question> findAll(int id) {
        Question question = new Question();
        // Vector de Questions
        Vector<Question> vecQuestion = new Vector<>();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM questions WHERE IDJEUREP = " + id );
        while (result.next()) {
            System.out.println("Methode FINDALL");
            System.out.println("  3: " + result.getInt(3) + "  initule :" + new String(result.getString(4)) + "  bonne rep: "+result.getInt(5) +" libelle: "+ new String(result.getString(1)) +" 7: "+  id);
            vecQuestion.add(new Question(result.getInt(3), new String(result.getString(4)), result.getInt(5) , new String(result.getString(1)), id));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vecQuestion;

    }
    // Methode qui retourne toutes les questions associées à un libelle
    public Vector<Question> findAll(String libelle) {
        Question question = new Question();
        // Vector de Questions
        Vector<Question> vecQuestion = new Vector<>();
        System.out.println("vla les bugs ");
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM questions WHERE LIBELLE = '" + libelle+ "'");
            while (result.next()) {
                System.out.println("Methode FINDALL");
                System.out.println("  3: " + result.getInt(3) + "  initule :" + new String(result.getString(4)) + "  bonne rep:  "+ result.getInt(5) +" libelle: "+libelle +" 7: "+ (result.getInt(2)));
                vecQuestion.add(new Question(result.getInt(3), new String(result.getString(4)), result.getInt(5) , libelle, result.getInt(2)));
            }
        } catch (SQLException e) {
            System.out.println("Ca passe par ici putain de sa maman");
            e.printStackTrace();
        }
        return vecQuestion;

    }

// Affiche le vecteur de question
    public void printVector(Vector<Question> vecQuestion){
        int i;
        for(i=0;i<vecQuestion.size();i++){
            vecQuestion.elementAt(i).TransformToText();
        }
    }

    // Methode qui va rechercher le dernier idQuestion dans la table puis l'incrementer de 1 ( a cause des entités faibles , on ne peut pas gerer directement l'auto-increment donc on le fait ici a la main
    public int getMaxId(){
        int maxID = 0;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(IDQUEST) FROM questions");
                    if(result.first())
                        maxID = result.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxID+1;
    }

    public void getIntituleQuestionDAO (Vector<Question> vecQuestion) {
        int i;
        for(i=0;i<vecQuestion.size();i++){
            vecQuestion.elementAt(i).getIntitule();
        }
    }

}