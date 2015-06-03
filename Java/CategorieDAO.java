import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Thomas on 29/05/2015.
 */
public class CategorieDAO extends DAO<Categorie> {

    public CategorieDAO(Connection connect) {
        super(connect);
    }

    public Categorie create(Categorie obj){
       String  libelle = obj.getLibelle();

        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO `basetest`.`categorie` (`LIBELLE`) VALUES ('"+libelle+"');" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public Categorie update(Categorie obj){

        return obj;
    }
    public Categorie delete(Categorie obj){
        String libelle = obj.getLibelle();

        try {
            System.out.println("Début suppr cat :");
            QuestionDAO questionDao = new QuestionDAO(this.connect);
            questionDao.deleteAll(libelle);
            System.out.println("Dans Categ DAO aprés suppr question par libelle");
            JeuReponseDAO jeuReponseDAO = new JeuReponseDAO(this.connect);
            jeuReponseDAO.delete(libelle);
            System.out.println("Dans Categ DAO aprés suppr jeu rep par libelle");

            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `basetest`.`categorie` WHERE `LIBELLE` = '"+libelle+"'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;

    }

    public Categorie find(String libelle){
        int i = 0;
        Categorie cat = new Categorie();
        Set<JeuReponse> setJrp = new HashSet<JeuReponse>();


        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM jeureponses WHERE LIBELLE = '" + libelle +"'");

            int nombreLignes = result.getRow();

            System.out.println("nb lignes "+ nombreLignes);

            if(result.first()) {
                cat = new Categorie(result.getString(1));
                result.beforeFirst(); // ramene le curseur avant la premeire ligne de la requete
               JeuReponseDAO jeuReponseDAO = new JeuReponseDAO(this.connect);



                while (result.next()) {
                    i++;
                    System.out.println("0123456789");
                    Vector<JeuReponse> vecJrp = jeuReponseDAO.find(libelle);
                    cat.addJeuReponse(vecJrp.elementAt(i));
                    System.out.println("wsvdv89");
                    vecJrp.elementAt(i).transformToText();


                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat;
    }
    // methode qui stocke toutes les categories existantes dans un vecteur
    public Vector<Categorie> findAll(){
        Vector<Categorie> vecCategorie = new Vector<Categorie>();

        Categorie categorie = new Categorie();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM categorie");
            while (result.next()) {

                vecCategorie.add(new Categorie(result.getString(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vecCategorie;
    }

    public void printVector(Vector<Categorie> vecCategorie){
        int i;
        for(i=0;i<vecCategorie.size();i++){
            vecCategorie.elementAt(i).TransformToText();
        }
    }



}