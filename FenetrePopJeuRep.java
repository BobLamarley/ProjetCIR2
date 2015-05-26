import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class FenetrePopJeuRep extends JFrame implements ActionListener {


   private JPanel popJeuRep;
   private JComboBox listeJeuRep;
   private JLabel titreCat;
   private JLabel titreJeuRep;
   private JComboBox listeCat;
   private JButton boutonOK;
   private JLabel labelTitre;
   private TextField jeuRep1;
   private TextField jeuRep2;
   private JLabel jeuRep3;
   private JLabel labelJeuRep1;
   private JLabel labelJeuRep2;
   private JLabel labelJeuRep3;
   private String rep1;
   private String rep2;


    public FenetrePopJeuRep() {	

       super();
       this.setTitle("Ajout d'une question");
       this.setSize(300, 200);
       this.setResizable(false); 

      String[] tabCat = {"cinema","histoire","people","ISEN"};

     
      popJeuRep = new JPanel();

      listeCat = new JComboBox(tabCat); 

      titreCat = new JLabel("Choisir une categorie :");

      labelTitre = new JLabel("Ajout d'une question");

      boutonOK = new JButton("Ok");

      jeuRep1 = new TextField("",24);
      jeuRep2 = new TextField("",24);
      jeuRep3 = new JLabel("les deux");

      labelJeuRep1 = new JLabel("Reponse 1:");
      labelJeuRep2 = new JLabel("Reponse 2:");
      labelJeuRep3 = new JLabel("Reponse 3:");

      boutonOK.addActionListener(this);

      popJeuRep.add(labelTitre);
      popJeuRep.add(titreCat);
      popJeuRep.add(listeCat);
      popJeuRep.add(labelJeuRep1);
      popJeuRep.add(jeuRep1);
      popJeuRep.add(labelJeuRep2);
      popJeuRep.add(jeuRep2);
      popJeuRep.add(labelJeuRep3);
      popJeuRep.add(jeuRep3);
      popJeuRep.add(boutonOK);


      rep1 = "lama";
      rep2 = "sticot";


      popJeuRep.setOpaque(true);

      this.getContentPane().add(popJeuRep);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);             
      this.setVisible(false);

    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boutonOK) {
          System.out.println("clic sur ok");
          rep1 = jeuRep1.getText();
          rep2 = jeuRep2.getText();
          this.setVisible(false); 
        }
        
  }


  public String getRep1(){
    return rep1;
  }

  public String getRep2(){
    return rep2;
  }



}