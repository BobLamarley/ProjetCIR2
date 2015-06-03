import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class FenetrePop extends JFrame implements ActionListener {

   private JList list;
   private JPanel panel;  
   private JLabel titreInt;
   private JTabbedPane onglets;
   private Font burgQ;
   private Font fonttitre;
   private JPanel ongletCat;
   private JLabel titreOngletCat;
   private JPanel ongletJeuRep;
   private JLabel titreOngletJeuRep;
   private JPanel ongletQuest;
   private JPanel panel_tableau;
   private JComboBox listeJeuRep;
   private JLabel titreCat;
   private JLabel titreJeuRep;
   private JLabel titreOngletQuest;
   private JComboBox listeCat;

   private JButton boutonOK;
   private JLabel labelTitre;
   private ArrayList<String> maListe;
   private TextField question;

   private JLabel labelquestion;

    public FenetrePop() {	

       super();
       this.setTitle("Ajout d'une question");
       this.setSize(300, 200);
       this.setResizable(false); 

       String[] tabCat = {"cinema","histoire","people","ISEN"};

      String[] tabJeuRep = {"Bernard Tapie, un tapis, les deux","lama , sticot , les deux"};

      ongletQuest = new JPanel();

      listeCat = new JComboBox(tabCat);

      listeJeuRep = new JComboBox(tabJeuRep);

      titreCat = new JLabel("Choisir une categorie :");

      titreJeuRep = new JLabel("Choisir un jeu de reponses :");

      labelTitre = new JLabel("Ajout d'une question");

      boutonOK = new JButton("Ok");

      question = new TextField("",24);

      labelquestion = new JLabel("Question:");

      boutonOK.addActionListener(this);

      ongletQuest.add(labelTitre);
      ongletQuest.add(titreCat);
      ongletQuest.add(listeCat);
      ongletQuest.add(titreJeuRep);
      ongletQuest.add(listeJeuRep);
      ongletQuest.add(labelquestion);
      ongletQuest.add(question);
      ongletQuest.add(boutonOK);


      ongletQuest.setOpaque(true);

      this.getContentPane().add(ongletQuest);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);             
      this.setVisible(false);
  

    }
    public void actionPerformed(ActionEvent e) {

  
        if (e.getSource() == boutonOK) {
          System.out.println("clic sur ok");
          this.setVisible(false);
          
        }
        
  }
}