import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class CreaOngletQuest extends JPanel implements ActionListener  {


	private JLabel titreOngletQuest;
	private JPanel panel_quest1;
	private JPanel panel_quest2;
	private JPanel paneltitreQuest;
	private JPanel panel_liste;
	private JPanel panelGlob1;
	private JPanel panelGlob2;
	private JButton boutonAjoutQuest;
	private Font fonttitre;
	private ArrayList<String> maListe;
	private JList list;
	private JLabel titreCat;
   	private JComboBox listeCat;
   	private JComboBox listeJeuRep;
	private JLabel titreJeuRep;
	private FenetrePopQuest popupQuest;
  private JButton boutonModif;
  private PopupModifQuest popupModif;
  private String element;
  private JButton boutonActu;
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
  private Question question;
  private JeuReponse jeuRepFin;
  private JList listBonneRep;




	public CreaOngletQuest() {


    popupModif = new PopupModifQuest();
		popupQuest= new FenetrePopQuest();

		fonttitre = new Font("Arial",Font.BOLD , 20);	

		titreOngletQuest = new JLabel("Gestion des questions");


    boutonActu = new JButton("Actualiser");
    boutonActu.addActionListener(this);

		titreCat = new JLabel("Choisir une catégorie :");

		titreJeuRep = new JLabel("Choisir un jeu de réponses :");

    
		panel_liste = new JPanel();

     	maListe = new ArrayList<String>();

      	list=new JList();

        listBonneRep = new JList();

        boutonModif = new JButton("Modifier la question");

        boutonModif.addActionListener(this);
      
      	list.setListData(maListe.toArray());
        listBonneRep.setListData(maListe.toArray());

        boutonSup = new JButton("supprimer");
        boutonSup.addActionListener(this);
      
	  	  panel_liste.add(list);
        panel_liste.add(listBonneRep);
        panel_liste.add(boutonModif);
        panel_liste.add(boutonSup);

      	panel_quest1 = new JPanel();

        paneltitreQuest = new JPanel();

        panel_quest2 = new JPanel();

      	panelGlob1 = new JPanel();
      	panelGlob2 = new JPanel();

      	panelGlob1.setLayout(new BorderLayout());

      	this.setLayout(new BorderLayout());

      	titreOngletQuest.setFont(fonttitre);

      	paneltitreQuest.add(titreOngletQuest);
        paneltitreQuest.add(boutonActu);

      	panelGlob1.add(paneltitreQuest,BorderLayout.NORTH);

        listeCat = new JComboBox();
        listeCat.addActionListener(this);

        listeJeuRep = new JComboBox();
        listeJeuRep.addActionListener(this);


      	panel_quest1.add(titreCat);
      	panel_quest1.add(listeCat);

      	panelGlob1.add(panel_quest1,BorderLayout.CENTER);

      	panel_quest2.add(titreJeuRep);
      	panel_quest2.add(listeJeuRep);

      	boutonAjoutQuest = new JButton("Ajouter une question");

      	boutonAjoutQuest.addActionListener(this);

      	panelGlob2.add(boutonAjoutQuest);

      	panelGlob1.add(panel_quest2,BorderLayout.SOUTH);

      	this.add(panelGlob1,BorderLayout.NORTH);

      	this.add(panel_liste,BorderLayout.CENTER);

      	this.add(panelGlob2, BorderLayout.SOUTH);


	}


	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == boutonAjoutQuest) {
          	System.out.println("clic sur ajouter question");
          	popupQuest.setVisible(true);
        }
    if (e.getSource() == listeCat) {    
                                                                //GESTION SELECTION DE LA CATEGORIE
       JComboBox cat = (JComboBox)e.getSource();                         
      selectCat = (String)cat.getSelectedItem();
      System.out.println("sélection d'une catégorie");
      System.out.println(selectCat);
       this.actuBoxJeuRep(selectCat); 

    }

    if (e.getSource() == listeJeuRep) {
                                                                // GESTION SELECTION DU JEU DE REP
      jeuRepDAO2 = new JeuReponseDAO(DBConnection.getInstance());
      JComboBox jeuRepCombo = (JComboBox)e.getSource();                         
      String selectJeuRep = (String)jeuRepCombo.getSelectedItem();
      System.out.println("sélection d'un jeu de rep");
      System.out.println(selectJeuRep);
      QuestionDAO lesquest = new QuestionDAO(DBConnection.getInstance());
      Vector<Question> vectQuestion = new Vector<>();
      Vector<JeuReponse> vectJeuRep= new Vector<>();
      System.out.println(selectCat);
      vectJeuRep = jeuRepDAO2.findAll(selectCat);
      jeuRepDAO2.printVector(vectJeuRep);
      jeuRep2 = new JeuReponse();
      int i;
      jeuRepFin = new JeuReponse();
      Vector<String> vectlistQuest = new Vector<>();

      for(i=0;i<vectJeuRep.size();i++){
        jeuRep2 = vectJeuRep.elementAt(i);
        if (jeuRep2.transformToText().equals(selectJeuRep)) {
          idJeuRep = jeuRep2.getId();
          jeuRepFin=jeuRep2;
          System.out.println("id jeu rep trouve");
        }
      }
      System.out.println(idJeuRep);
      String labonnerep = new String("");
      int idbonnerep;
      String intitulequest;
      String objetReturn;
      vectQuestion = lesquest.findAll(idJeuRep);
      lesquest.printVector(vectQuestion);
      lesquest.getIntituleQuestionDAO(vectQuestion);
      for(i=0;i<vectQuestion.size();i++){
            vectlistQuest.add(vectQuestion.elementAt(i).getIntitule());
      }
      list.setListData(vectlistQuest.toArray());

      Vector<String> vectlistBonneRep = new Vector<>();

      for(i=0;i<vectQuestion.size();i++){
        idbonnerep = vectQuestion.elementAt(i).getBonneRep();
        if (idbonnerep == 1) {
           labonnerep = jeuRepFin.getRep1();
        }
        else if ( idbonnerep == 2 ) {
          labonnerep = jeuRepFin.getRep2();
        }
        else if (idbonnerep == 3) {
          labonnerep = "les deux";
        }
        objetReturn = new String("Bonne réponse: " + labonnerep );
        vectlistBonneRep.add(objetReturn);
      }
      listBonneRep.setListData(vectlistBonneRep.toArray());
    }

    if (e.getSource() == boutonModif) {
      QuestionDAO questionDAO = new QuestionDAO(DBConnection.getInstance());
        Object [] erf = list.getSelectedValues();
        for(int i = 0; i < erf.length; i++) {
            System.out.println(erf[i]);
            element = erf[i].toString();
        }
        if (element == null) {
              DialogErreur erreur = new DialogErreur();
              erreur.selectQuestionVide();
        }
        else {
          popupModif.setText(element);
          popupModif.setReponse(jeuRepFin);
          Vector<Question> vectQuest = new Vector<>();
          vectQuest = questionDAO.findAll(idJeuRep);
                  
        for(int i=0;i<vectQuest.size();i++){
            question = vectQuest.elementAt(i);
            if(question.getIntitule().equals(element)) {
                popupModif.setQuestion(question);
            }
        }

        popupModif.setVisible(true);
      }
      element = null;
    }


    if (e.getSource() == boutonActu) {
      this.actuBoxCat();
    }


    if (e.getSource() == boutonSup ) {
        QuestionDAO questionDAO = new QuestionDAO(DBConnection.getInstance());
        Object [] erf = list.getSelectedValues();
                  for(int i = 0; i < erf.length; i++) {
                        System.out.println(erf[i]);
                        element = erf[i].toString();
                  }
                  if (element == null) {
                      DialogErreur erreur = new DialogErreur();
                      erreur.selectQuestionVide();
                  }
                  else {

                    Vector<Question> vectQuest = new Vector<>();
                    System.out.println(idJeuRep);
                    vectQuest = questionDAO.findAll(idJeuRep);
                  
                    for(int i=0;i<vectQuest.size();i++){
                        question = vectQuest.elementAt(i);
                        if(question.getIntitule().equals(element)) {
                              questionDAO.delete(question);
                        }
                    }
                  }
                  element = null;
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
    this.updateUI();

  }


	
}