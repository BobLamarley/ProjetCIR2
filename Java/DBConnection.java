/**
 * Created by Thomas on 21/05/2015.
 */

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection{


    //URL de connexion
    private static String url ;
    //Nom du user
    private static String user ;
    //Mot de passe de l'utilisateur
    private static String password ;
    //Driver
    private static String driver ="com.mysql.jdbc.Driver";
    //Objet Connection
    private static Connection connect;
    // Status connection pour lever l'erreur MysqlSyntaxErroreception et savoir si on est bien co
    private static boolean statusConnection = true;

    //Constructeur privé
    private DBConnection(){

        try {
            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(url, user, password);
            statusConnection = true;

        } catch (SQLException e) {
            System.out.println("0");
           // e.printStackTrace();   // permet de ne plus afficher l'erreur dans le terminal
            statusConnection = false;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION , Probleme de Driver ? Asssurez vous de l'avoir placer dans le repertoire ou se trouve le programme !  ", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static boolean getStatusConnection (){
        return statusConnection;
    }

    //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
    public static Connection getFirstInstance(String url , String user , String password) {

            if (connect == null ) {

                // methode statique , ici le this n'existe pas il faut donc faire directement reference a la classe avec DBConnection
                DBConnection.url = url;
                DBConnection.password = password;
                DBConnection.user = user;

                    System.out.println("1");
                    new DBConnection();
                if(DBConnection.getStatusConnection() == true) {
                    System.out.println("Vous êtes bien connectés");
                }else{
                    System.out.println("Url , login , ou mdp incorrect");

                }
                System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");

            }

        System.out.println("Connexion a la base de donnees ");

        return connect;
    }
    //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
    public static Connection getInstance() {


        System.out.println("Retour de l'instance connect");

        return connect;
    }

}