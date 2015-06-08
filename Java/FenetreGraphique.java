import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class FenetreGraphique extends JFrame implements WindowListener {

   private JPanel panel;  
   private JLabel titreInt;
   private JTabbedPane onglets;
   private Font burgQ;
   private CreaOngletCat ongletCat;
   private CreaOngletJeuRep ongletJeuRep;
   private CreaOngletQuest ongletQuest;

   private String rep1;
   private String rep2;
   public static FenetreGraphique fenetre = new FenetreGraphique();
   private JTextArea display;

    public FenetreGraphique() {	

       super();
       display = new JTextArea();
       this.setTitle("Gestion de la BDD");
       this.setSize(700, 500);
       this.setResizable(false);
       panel = new JPanel(); 
      
       onglets = new JTabbedPane(SwingConstants.TOP);

       titreInt = new JLabel("Burger Quizz Editor");
       burgQ = new Font("Arial",Font.BOLD , 35);
       titreInt.setFont(burgQ);


       /***********************************Ajout de l'onglet Categorie**********************/

       ongletCat = new CreaOngletCat();

       onglets.addTab("Catégories", ongletCat);


       /**********************************Ajout de l'onglet Jeu de reponses*******************/

       ongletJeuRep = new CreaOngletJeuRep();
       onglets.addTab("Jeux de réponses", ongletJeuRep);



       /*********************************Ajout de l'onglet Questions**************************/


       ongletQuest = new CreaOngletQuest();
       onglets.addTab("Questions", ongletQuest);


       onglets.setOpaque(true);
       panel.add(titreInt);
       panel.add(onglets);

       this.getContentPane().add(panel);

       addWindowListener(this);

       //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);             
       this.setVisible(false);
    }

    public void windowClosing(WindowEvent e) {
        displayMessage("WindowListener method called: windowClosing.");
        DialogErreur erreur = new DialogErreur();
        VerifResult verif = new VerifResult(DBConnection.getInstance());
        verif.selectCat();
        if (verif.getManqueCat().size() == 0 && verif.getManqueJeuRep().size() == 0 ) {
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           System.out.println("il n'y a pas d'erreurs");
        }
        else {
        erreur.afficheManqueJeuRep(verif.getManqueCat());
        erreur.afficheManqueQuest(verif.getManqueJeuRep());
        System.out.println("ca passe dans le else");
        
      }

      }

      void displayMessage(String msg) {
        display.append(msg);
        System.out.println(msg);
    }
    public void windowClosed(WindowEvent e) {
        
    }

    public void windowOpened(WindowEvent e) {
       
    }

    public void windowIconified(WindowEvent e) {
        
    }

    public void windowDeiconified(WindowEvent e) {
        
    }

    public void windowActivated(WindowEvent e) {
        
    }

    public void windowDeactivated(WindowEvent e) {
        
    }
}