import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by Thomas on 26/05/2015.
 */
public class JeuReponseDAO extends DAO<JeuReponse>{
   
    public JeuReponseDAO(Connection connect){
             super(connect);
        }
// Methode permettant de créer un jeu de réponse en construisant un obj jeureponse avec les parametres indiqués puis les envoyer grace a JEUREPONSEDAO.create()

    public JeuReponse create(JeuReponse obj){
            int idjeurep = obj.getId();
            String libelle = obj.getLibelle();
            String rep1 = obj.getRep1();
            String rep2 = obj.getRep2();
        try {
         this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO `basetest`.`jeureponses` (`LIBELLE`, `IDJEUREP`, `REP1`, `REP2`) VALUES ('"+libelle+"', '"+idjeurep+"', '"+rep1+"', '"+rep2+"');");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

// Méthode qui supprime le jeu de réponse grâce a son idjeurep et supprime toutes les questions associées a cet idjeurep avec la méthode QuestionDAO.delete()

    public JeuReponse delete(JeuReponse obj){

        int idjeurep = obj.getId();
        String libelle = obj.getLibelle();
        String rep1 = obj.getRep1();
        String rep2 = obj.getRep2();
        try {
            QuestionDAO questionDao = new QuestionDAO(this.connect);
            questionDao.deleteAll(idjeurep);

            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `basetest`.`jeureponses` WHERE `jeureponses`.`LIBELLE` = '"+libelle+"' AND `jeureponses`.`IDJEUREP` = "+idjeurep+"");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  obj;
    }
    // Méthode qui supprime le jeu de réponse grâce a son libelle et supprime toutes les questions associées a cet idjeurep avec la méthode QuestionDAO.delete()
    public JeuReponse delete(String libelle){
JeuReponse obj = new JeuReponse();

        try {


            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `basetest`.`jeureponses` WHERE `jeureponses`.`LIBELLE` = '"+libelle+"'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  obj;
    }
// Pour cette methode , ne pas oublier d'utiliser la methode QuestionDAO.update() pour mettre a jour les questions si l'on change le je de réponses

    public JeuReponse update(JeuReponse obj){
        int idjeurep = obj.getId();
        String libelle = obj.getLibelle();
        String rep1 = obj.getRep1();
        String rep2 = obj.getRep2();
        try {


            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `jeureponses` SET `REP1` = '"+rep1+"', `REP2` = '"+rep2+"' WHERE `jeureponses`.`IDJEUREP` = "+idjeurep+";");

            System.out.println("Update jeu rep");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  obj;

    }

    // Methode d'update et de changement de catégorie
    public JeuReponse updateCat(JeuReponse obj){
        int idjeurep = obj.getId();
        String libelle = obj.getLibelle();
        String rep1 = obj.getRep1();
        String rep2 = obj.getRep2();
        try {
            QuestionDAO qDao = new QuestionDAO(DBConnection.getInstance());
            Question q = new Question(-1,null,0,libelle,-1);
            qDao.update(q);

            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `jeureponses` SET `REP1` = '"+rep1+"', `REP2` = '"+rep2+"' WHERE `jeureponses`.`IDJEUREP` = "+idjeurep+";");

            System.out.println("Update jeu rep");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  obj;

    }


    // methode permettant de rechercher les jeu de réponses en fonction d'un id jeu rep ,elle remplie la liste de question dans un obj jeurep
    public JeuReponse find(int idjeurep){
        int i = 0;
        JeuReponse jeurep = new JeuReponse();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM questions WHERE IDJEUREP = '" + idjeurep +"'");
           if(result.first()) {
               jeurep = new JeuReponse(result.getString(1),result.getInt(2),result.getString(3),result.getString(4));
               result.beforeFirst(); // ramene le curseur avant la premeire ligne de la requete
              QuestionDAO questionDao = new QuestionDAO(this.connect);


                while(result.next()){
                    System.out.println("0");
                    Question q = questionDao.findAll(idjeurep).elementAt(i++);
                    String intitule = q.getIntitule();
                    System.out.println("Dans jeurepDAO intitule :" + intitule);
                    jeurep.addQuestion(q);
                    q.TransformToText();


                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jeurep;
    }

    // methode permettant de rechercher les jeu de réponses par son libelle ,elle remplie la liste de question dans un obj jeurep
    public Vector<JeuReponse> find(String libelle){
        int i = 0;
        JeuReponse jeurep = new JeuReponse();
        Vector<JeuReponse> vecJrp = new Vector<JeuReponse>();


        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM questions WHERE LIBELLE = '" + libelle +"'");
            if(result.first()) {

                result.beforeFirst(); // ramene le curseur avant la premeire ligne de la requete
                QuestionDAO questionDao = new QuestionDAO(this.connect);


                while(result.next()){
                    jeurep = new JeuReponse(result.getString(1),result.getInt(2),result.getString(3),result.getString(4));
                    System.out.println("0");
                    Question q = questionDao.findAll(libelle).elementAt(i++);
                    System.out.println("0123");
                    String intitule = q.getIntitule();
                    System.out.println("Dans jeurepDAO intitule :" + intitule);
                    jeurep.addQuestion(q);
                    q.TransformToText();
                    vecJrp.add(jeurep);


                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vecJrp;
    }

// methode permettant de rechercher les jeu de réponses en fonction d'une catégorie choisie , mais ne remplie pas la liste de questions pour chaque objet jeureponse
    // Elle sera utiliser par exemple lors de l'ajout d'une nouvelle question , dés qu'on aura choisie une categorie on fera une requete avec cette methode

    public Vector<JeuReponse> findAll(String libelle){
                Vector<JeuReponse> vecJeuReponse = new Vector<JeuReponse>();
                JeuReponse jeurep = new JeuReponse();

                try {
                    ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM jeureponses WHERE libelle = '" + libelle+"'");
            while (result.next()) {

                vecJeuReponse.add(new JeuReponse(result.getString(1),result.getInt(2),result.getString(3),result.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vecJeuReponse;
    }

    // méthode qui récupere le dernier id de jeu de réponse dans la base et l'incrémente de 1 pour le prochain jeu de reponse a ajouter
    public int getMaxId(){
        int maxID = 0;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(IDJEUREP) FROM jeureponses");
            if(result.first())
                maxID = result.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxID+1;

    }


// Methode permettant d'afficher un vecteur contenant des objets jeureponse
// Affiche le vecteur de question
public void printVector(Vector<JeuReponse> vecJeuReponse){
    int i;
    for(i=0;i<vecJeuReponse.size();i++){
        vecJeuReponse.elementAt(i).transformToText();
    }
}


}
