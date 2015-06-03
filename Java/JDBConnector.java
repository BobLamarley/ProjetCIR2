import javax.swing.*;
import java.sql.*;

/**
 * Created by Thomas on 20/05/2015.
 */
public class JDBConnector {
    private String url, user ,password;
    private String driver="com.mysql.jdbc.Driver";
    private Connection con=null;
    private Statement st = null;
    private ResultSet rs = null;
    private Accueil a;
    // Constructeur JDBConnector
   public JDBConnector (){
      this.url=a.getUrl();
      this.user=a.getUser();
      this.password=a.getPassword();



        try {
            Class.forName(driver).newInstance();
            this.con = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion effective !");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
        }



   }
// Methode de fermeture de la connexion a la BDD
   public void closeJDBConnector() {
       try {
           if (con != null) con.close();
       } catch (SQLException e) {
       }
   }



}
