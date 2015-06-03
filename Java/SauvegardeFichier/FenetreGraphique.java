import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class FenetreGraphique extends JFrame implements ActionListener  {

   private JList list;
   private JList list2;
   private JList list3;
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

   private JLabel titreCat2;
   private JComboBox listeCat2;

   private JButton boutonAjoutQuest;

   private JButton boutonAjoutRep;
   private JButton boutonAjoutCat;

   private ArrayList<String> maListe;

   private FenetrePop popupQuest;

   private TextField texteCat;

    public FenetreGraphique() {	

       super();
       this.setTitle("Gestion de la BDD");
       this.setSize(700, 500);
       this.setResizable(false); 

       String[] tabCat = {"cinema","histoire","people","ISEN"};

      String[] tabJeuRep = {"Bernard Tapie, un tapis, les deux","lama , sticot , les deux"};

      listeCat = new JComboBox(tabCat);

      listeJeuRep = new JComboBox(tabJeuRep);

      titreCat = new JLabel("Choisir une categorie :");

      titreJeuRep = new JLabel("Choisir un jeu de reponses :");

      titreOngletQuest = new JLabel("Gestion des questions");

      titreCat2 = new JLabel("Choisir une categorie :");
      listeCat2 = new JComboBox(tabCat);
  



      maListe = new ArrayList<String>();


      maListe.add("Permier Element");
      maListe.add("Second Element");
      maListe.add("Troisieme Element");
      maListe.add("Quatrieme Element");
      maListe.add("Cinquieme Element");

      this.list=new JList();
      this.list2 = new JList();
      this.list3 = new JList();

      list.setListData(maListe.toArray());
      list2.setListData(maListe.toArray());
      list3.setListData(maListe.toArray());

      JPanel panel_liste = new JPanel();

      panel_liste.add(list);

      popupQuest= new FenetrePop();

      panel = new JPanel();

      titreInt = new JLabel("Burger Quizz Editor");

      onglets = new JTabbedPane(SwingConstants.TOP);

      burgQ = new Font("Arial",Font.BOLD , 35);

      fonttitre = new Font("Arial",Font.BOLD , 20);

      titreInt.setFont(burgQ);

    /* ------------------Onglet de catégories--------------*/

      ongletCat = new JPanel();

      titreOngletCat = new JLabel("Gestion des categories");

      titreOngletCat.setFont(fonttitre);

      ongletCat.setPreferredSize(new Dimension(650, 380));

      onglets.addTab("Categories", ongletCat);

      JPanel panel_cat1 = new JPanel();

      JPanel paneltitreCat = new JPanel();

      JPanel panel_liste3 = new JPanel();

      panel_liste3.add(list3);

      JPanel panelGlobCat1 = new JPanel();
      JPanel panelGlobCat2 = new JPanel();
     
     panelGlobCat1.setLayout(new BorderLayout());

      ongletCat.setLayout(new BorderLayout());


      paneltitreCat.add(titreOngletCat);

      panelGlobCat1.add(paneltitreCat,BorderLayout.NORTH);

      texteCat = new TextField("",24);


      boutonAjoutCat = new JButton("Ajouter une categorie");

      boutonAjoutCat.addActionListener(this);

      panelGlobCat2.add(texteCat);
      panelGlobCat2.add(boutonAjoutCat);
      

      ongletCat.add(panelGlobCat1,BorderLayout.NORTH);


      ongletCat.add(panel_liste3,BorderLayout.CENTER);

      ongletCat.add(panelGlobCat2, BorderLayout.SOUTH);






    /* ------------------Onglet de Jeu de réponses--------------*/

      ongletJeuRep = new JPanel();

      titreOngletJeuRep = new JLabel("Gestion des jeux de reponses");

      titreOngletJeuRep.setFont(fonttitre);


      onglets.addTab("Jeux de reponses", ongletJeuRep);

      JPanel panel_rep1 = new JPanel();

      JPanel paneltitreRep = new JPanel();

      JPanel panel_liste2 = new JPanel();

      panel_liste2.add(list2);

      JPanel panelGlobRep1 = new JPanel();
      JPanel panelGlobRep2 = new JPanel();
     
     panelGlobRep1.setLayout(new BorderLayout());

      titreOngletJeuRep.setFont(fonttitre);

      ongletJeuRep.setLayout(new BorderLayout());


      paneltitreRep.add(titreOngletJeuRep);

      panelGlobRep1.add(paneltitreRep,BorderLayout.NORTH);

      panel_rep1.add(titreCat2);
      panel_rep1.add(listeCat2);

      panelGlobRep1.add(panel_rep1,BorderLayout.CENTER);

      /*panel_quest2.setLayout(new BorderLayout());*/


      boutonAjoutRep = new JButton("Ajouter un jeu de reponses");

      boutonAjoutRep.addActionListener(this);

      panelGlobRep2.add(boutonAjoutRep);

      ongletJeuRep.add(panelGlobRep1,BorderLayout.NORTH);


      ongletJeuRep.add(panel_liste,BorderLayout.CENTER);

      ongletJeuRep.add(panelGlobRep2, BorderLayout.SOUTH);




    /* ------------------Onglet de Questions--------------*/


      ongletQuest = new JPanel();

      panel_tableau = new JPanel();

      

      JPanel panel_quest1 = new JPanel();

      JPanel paneltitre = new JPanel();

      JPanel panel_quest2 = new JPanel();

      JPanel panelGlob1 = new JPanel();
      JPanel panelGlob2 = new JPanel();

      panelGlob1.setLayout(new BorderLayout());

      /*panelGlob2.setLayout(new BorderLayout());*/

      ongletQuest.setLayout(new BorderLayout());

      titreOngletQuest.setFont(fonttitre);

      paneltitre.add(titreOngletQuest);

      panelGlob1.add(paneltitre,BorderLayout.NORTH);

      panel_quest1.add(titreCat);
      panel_quest1.add(listeCat);

      panelGlob1.add(panel_quest1,BorderLayout.CENTER);

      /*panel_quest2.setLayout(new BorderLayout());*/

      panel_quest2.add(titreJeuRep);
      panel_quest2.add(listeJeuRep);

      boutonAjoutQuest = new JButton("Ajouter une question");

      boutonAjoutQuest.addActionListener(this);

      panelGlob2.add(boutonAjoutQuest);

      panelGlob1.add(panel_quest2,BorderLayout.SOUTH);


      ongletQuest.add(panelGlob1,BorderLayout.NORTH);

      /*panelGlob2.add(tableau,BorderLayout.NORTH);*/

      //panel_liste.setPreferredSize(new Dimension(350, 280));

      ongletQuest.add(panel_liste2,BorderLayout.CENTER);

      ongletQuest.add(panelGlob2, BorderLayout.SOUTH);

      onglets.addTab("Questions", ongletQuest);
  

    /*------------------------------Fin Onglet Questions------------------------*/





      onglets.setOpaque(true);
      panel.add(titreInt);
      panel.add(onglets);

      this.getContentPane().add(panel);

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
       this.setVisible(true);
    }
    
   

    public void actionPerformed(ActionEvent e) {

  
        if (e.getSource() == boutonAjoutQuest) {
          System.out.println("clic sur ajouter question");
          popupQuest.setVisible(true);
        }
        
}

}