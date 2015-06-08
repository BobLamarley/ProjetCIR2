import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class FenetrePopQuest extends JDialog implements ActionListener {

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

     private CategorieDAO catDAO;
  private Categorie categorie;
  private JeuReponse jeuRep;
   private JeuReponse jeuRep2;
   private JeuReponseDAO jeuRepDAO;
   private JeuReponseDAO jeuRepDAO2;
  private String [] tabCat;
  private Set<Question> setQuestion;
  private String selectCat; 
  private int idJeuRep;
  private JButton boutonSup;
  private Question quest;
  private JButton boutonActu;
  private String newquestion;
  private QuestionDAO questDAO;
  private int bonnerep;
  private JLabel labelBR;
  private JComboBox listeBR;
  private JeuReponse jeuRepCorrect;
  private String questionControle;
  private Controle controleur;





    public FenetrePopQuest() {	

       super();
       this.setModal(true);
       this.setTitle("Ajout d'une question");
       this.setSize(300, 260);
       this.setResizable(false); 

      jeuRepCorrect = new JeuReponse();

      ongletQuest = new JPanel();

      listeCat = new JComboBox();

      listeJeuRep = new JComboBox();

      listeBR = new JComboBox();

      boutonActu = new JButton("actu");
      boutonActu.addActionListener(this);

      titreCat = new JLabel("Choisir une catégorie :");

      labelBR = new JLabel("Bonne réponse:");

      titreJeuRep = new JLabel("Choisir un jeu de réponses :");

      labelTitre = new JLabel("Ajout d'une question");

      boutonOK = new JButton("Ok");

      question = new TextField("",24);

      labelquestion = new JLabel("Question:");

      boutonOK.addActionListener(this);
      listeCat.addActionListener(this);
      listeJeuRep.addActionListener(this);
      listeBR.addActionListener(this);

      ongletQuest.add(labelTitre);
      ongletQuest.add(boutonActu);
      ongletQuest.add(titreCat);
      ongletQuest.add(listeCat);
      ongletQuest.add(titreJeuRep);
      ongletQuest.add(listeJeuRep);
      ongletQuest.add(labelquestion);
      ongletQuest.add(question);
      ongletQuest.add(labelBR);
      ongletQuest.add(listeBR);
      ongletQuest.add(boutonOK);


      ongletQuest.setOpaque(true);

      this.getContentPane().add(ongletQuest);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);             
      this.setVisible(false);
  

    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boutonOK) {
          controleur = new Controle();
          DialogErreur erreur = new DialogErreur();
          System.out.println("clic sur ok");
          questDAO = new QuestionDAO(DBConnection.getInstance());
          newquestion = question.getText();
          if (newquestion.equals("")) {
              erreur.questionVide();
          }
          if (selectCat == null) {
            erreur.selectCatVide();
          }
          if (jeuRepCorrect == null) {
            erreur.jeuRepVide();
          }

          else if ( selectCat != null && jeuRepCorrect != null && !newquestion.equals("")) {
          questionControle = controleur.controleChaine(newquestion);
          String selectBR = new String((String)listeBR.getSelectedItem());
          if ( selectBR.equals(jeuRepCorrect.getRep1())) {
              bonnerep = 1;
          }
          else if (selectBR.equals(jeuRepCorrect.getRep2())) {
              bonnerep = 2;
          } 
          else if (selectBR.equals("les deux")) {
              bonnerep = 3;
          }
          questDAO.create(new Question( questDAO.getMaxId(), questionControle , bonnerep , selectCat, idJeuRep ));
          System.out.println("ca passe la requete");
          this.setVisible(false);
          question.setText("");
          selectCat = null;
          jeuRepCorrect = null;
          listeBR.removeAllItems();
          listeCat.removeAllItems();
          listeJeuRep.removeAllItems();
          }      
        }


        if (e.getSource() == boutonActu) {
          this.actuBoxCat();
        }


        if (e.getSource() == listeCat) {    
                                                                       //GESTION SELECTION DE LA CATEGORIE
           JComboBox cat = (JComboBox)e.getSource();                         
            selectCat = (String)cat.getSelectedItem();
            System.out.println("selection d'une categorie");
            System.out.println(selectCat);
            this.actuBoxJeuRep(selectCat);  
        }


        if (e.getSource()== listeJeuRep ) {
          JComboBox jeuRepCombo = (JComboBox)e.getSource();                         
          String selectJeuRep = (String)jeuRepCombo.getSelectedItem();
          System.out.println("selection d'un jeu de rep");
          System.out.println(selectJeuRep);
          Vector<JeuReponse> vectJeuRep= new Vector<>();
          System.out.println(selectCat);
          vectJeuRep = jeuRepDAO.findAll(selectCat);
          jeuRepDAO.printVector(vectJeuRep);
          jeuRep2 = new JeuReponse();
          jeuRepCorrect = new JeuReponse();
          for(int i=0;i<vectJeuRep.size();i++){
              jeuRep2 = vectJeuRep.elementAt(i);
              if (jeuRep2.transformToText().equals(selectJeuRep)) {
                  idJeuRep = jeuRep2.getId();
                  jeuRepCorrect = jeuRep2;
                  System.out.println("id jeu rep trouve");
              }
          }

          this.actuBoxBonneRep(jeuRepCorrect);
        }

  }

  public void actuBoxCat() {

    catDAO = new CategorieDAO(DBConnection.getInstance());
    Vector<Categorie> vectCat= new Vector<>();
    vectCat = catDAO.findAll();
    catDAO.printVector(vectCat);
    categorie = new Categorie();
    int i;
    Vector<String> vectLibelle = new Vector<>();
    for(i=0;i<vectCat.size();i++){

      categorie = vectCat.elementAt(i);
      vectLibelle.add(categorie.getLibelle());

    }
    listeCat.removeAllItems();
    listeCat.setModel(new DefaultComboBoxModel(vectLibelle));
    //this.updateUI();

  }

  public void actuBoxJeuRep( String libelle) {

    System.out.println("ca passe dans ActuBox");
    Vector<JeuReponse> vectJeuRep= new Vector<>();
    jeuRepDAO = new JeuReponseDAO(DBConnection.getInstance());
    vectJeuRep = jeuRepDAO.findAll(libelle);
    jeuRepDAO.printVector(vectJeuRep);
    jeuRep = new JeuReponse();
    int i;
    Vector<String> vectlistRep = new Vector<>();
    for(i=0;i<vectJeuRep.size();i++){

      jeuRep = vectJeuRep.elementAt(i);
      vectlistRep.add(jeuRep.transformToText());

    }
    listeJeuRep.removeAllItems();
    listeJeuRep.setModel(new DefaultComboBoxModel(vectlistRep));
    ongletQuest.updateUI();

  }

  public void actuBoxBonneRep( JeuReponse jeuRep) {

    System.out.println("ca passe dans ActuBoxJeuRep");
    jeuRepDAO = new JeuReponseDAO(DBConnection.getInstance());
    
    Vector<String> vectBonneRep = new Vector<>();
    vectBonneRep.add(jeuRep.getRep1());
    vectBonneRep.add(jeuRep.getRep2());
    vectBonneRep.add("les deux");
    listeBR.removeAllItems();
    listeBR.setModel(new DefaultComboBoxModel(vectBonneRep));
    ongletQuest.updateUI();

  }


}