import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class FenetreGraphique extends JFrame  {

   private JPanel panel;  
   private JLabel titreInt;
   private JTabbedPane onglets;
   private Font burgQ;
   private CreaOngletCat ongletCat;
   private CreaOngletJeuRep ongletJeuRep;
   private CreaOngletQuest ongletQuest;

   private String rep1;
   private String rep2;


    public FenetreGraphique() {	

       super();
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

       onglets.addTab("Categories", ongletCat);


       /**********************************Ajout de l'onglet Jeu de reponses*******************/

       ongletJeuRep = new CreaOngletJeuRep();
       onglets.addTab("Jeux de reponses", ongletJeuRep);



       /*********************************Ajout de l'onglet Questions**************************/


       ongletQuest = new CreaOngletQuest();
       onglets.addTab("Questions", ongletQuest);

       rep1 = getRep1();
       getRep2();


       onglets.setOpaque(true);
       panel.add(titreInt);
       panel.add(onglets);

       this.getContentPane().add(panel);

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
       this.setVisible(true);
    }
    
    
  public String getRep1(){
    rep1 = ongletJeuRep.getRep1();
    return rep1;
  }

  public String getRep2(){
    rep2 = ongletJeuRep.getRep2();
    return rep2;
  }

}