
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by Thomas on 20/05/2015.
 */
public class IntConnectionBDD extends JFrame  implements ActionListener {


    private JLabel ConnectLabel = new JLabel("Bienvenue dans l'accueil de connexion :");

    private JTextField urlField = new JTextField("jdbc:mysql://127.0.0.1/BaseTest");
    private JLabel urlLabel = new JLabel("Url :");

    private JTextField userField = new JTextField("root");
    private JLabel userLabel = new JLabel("User :");

    private JTextField passwordField= new JTextField();
    private JLabel passwordLabel = new JLabel("Password :");

    private JButton connection;

    private FenetreGraphique interfaceBDD;



    public IntConnectionBDD(){
        super();   // Appel du constructeur de la super-classe (JFrame)
        interfaceBDD = new FenetreGraphique();
        this.setTitle("Access DataBase");  // on donne un titre a notre fenetre
        Font police = new Font("Arial", Font.BOLD, 14);  // on spécifie quel type de police , ainsi que la taille utilisée dans notre fenetre

        JPanel panel_connect = new JPanel();  //
        JPanel panel_url = new JPanel();
        JPanel panel_user = new JPanel();
        JPanel panel_password = new JPanel();  // Panel contenant le JTextFiel password et le JLabel Password
        JPanel panel_connection = new JPanel(); // Panel contenant le bouton  connection

        connection = new JButton("Connection");
        connection.addActionListener(this);

        urlField.setPreferredSize(new Dimension(100, 30));
        userField.setPreferredSize(new Dimension(100, 30));
        passwordField.setPreferredSize(new Dimension(100, 30));
        panel_connect.add(ConnectLabel, BorderLayout.CENTER);

        panel_url.add(urlLabel,BorderLayout.WEST);
        panel_url.add(urlField,BorderLayout.EAST);
        panel_user.add(userLabel,BorderLayout.WEST);
        panel_user.add(userField,BorderLayout.EAST);
        panel_password.add(passwordLabel,BorderLayout.WEST);
        panel_password.add(passwordField,BorderLayout.EAST);
        panel_connection.add(connection,BorderLayout.CENTER);


        getContentPane().add(panel_connect, BorderLayout.NORTH);     // on ajoute panel_top au nord de notre panneau principal
        getContentPane().add(panel_url, BorderLayout.WEST);     // on ajoute panel_top au nord de notre panneau principal
        getContentPane().add(panel_user, BorderLayout.CENTER);
        getContentPane().add(panel_password, BorderLayout.EAST);
        getContentPane().add(panel_connection, BorderLayout.SOUTH);



        this.pack();


        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // on rend posssible la fermeture de la fenetre en cliquant sur la croix

        this.setVisible(true); // on rend la fentre visible






    }


    public String getUrl(){
            return urlField.getText();
    }

    public String getUser(){
        return  userField.getText();
    }

    public String getPassword(){
        return passwordField.getText();
    }

    public String toString () {
       return String.format("url : %sUser :%sPassword :%s", this.getUrl(), this.getUser(), this.getPassword());
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == connection){
            interfaceBDD.setVisible(true);
            this.setVisible(false);
            System.out.println(userField.getText() + "  " + urlField.getText() + "   " + passwordField.getText());

            DBConnection.getFirstInstance(urlField.getText(), userField.getText(), passwordField.getText());
            Connection connect = DBConnection.getInstance();

        }
    }

    }
