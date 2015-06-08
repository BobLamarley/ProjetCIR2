import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class CreaOngletJeuRep extends JPanel implements ActionListener  {


	private JLabel titreOngletJeuRep;
	private JPanel panel_rep;
	private JPanel paneltitreRep;
	private JPanel panel_liste;
	private JPanel panelGlob1;
	private JPanel panelGlob2;
	private JButton boutonAjoutRep;
	private Font fonttitre;
	private ArrayList<String> maListe;
	private JList list;
	private JLabel titreCat;
  private JComboBox listeCat;
  private FenetrePopJeuRep popupJeuRep;
  private String rep1;
  private String rep2;
  private JeuReponse jeuRep;
  private JeuReponseDAO jeuRepDAO;
  private String categorieSelect;
  private CategorieDAO catDAO;
  private Categorie categorie;
  private JButton boutonActu;
  private JButton boutonSup;
  private String element;
  private JButton boutonModif;
  private PopupModifJeuRep popupModif;
  //private JOptionPane dialogErreur;



	public CreaOngletJeuRep() {

    popupModif = new PopupModifJeuRep();

	  popupJeuRep = new FenetrePopJeuRep();

	  fonttitre = new Font("Arial",Font.BOLD , 20);	

      titreOngletJeuRep = new JLabel("Gestion des jeux de réponses");

      titreOngletJeuRep.setFont(fonttitre);

      panel_rep = new JPanel();

      paneltitreRep = new JPanel();

      panel_liste = new JPanel();

      maListe = new ArrayList<String>();

      this.list=new JList();
      list.setListData(maListe.toArray());
	    panel_liste.add(list);

      boutonActu = new JButton("actualiser");
      boutonActu.addActionListener(this);

      boutonModif = new JButton("Modifier");
      boutonModif.addActionListener(this);
      panel_liste.add(boutonModif);

      boutonSup = new JButton("supprimer");
      boutonSup.addActionListener(this);
      panel_liste.add(boutonSup);


      panelGlob1 = new JPanel();
      panelGlob2 = new JPanel();
     
      panelGlob1.setLayout(new BorderLayout());

      titreOngletJeuRep.setFont(fonttitre);

      this.setLayout(new BorderLayout());


      paneltitreRep.add(titreOngletJeuRep);
      paneltitreRep.add(boutonActu);

      panelGlob1.add(paneltitreRep,BorderLayout.NORTH);


      listeCat = new JComboBox();
      listeCat.addActionListener(this);

	    titreCat = new JLabel("Choisir une catégorie :");

      panel_rep.add(titreCat);
      panel_rep.add(listeCat);

      panelGlob1.add(panel_rep,BorderLayout.CENTER);

      boutonAjoutRep = new JButton("Ajouter un jeu de réponses");

      boutonAjoutRep.addActionListener(this);

      panelGlob2.add(boutonAjoutRep);

      this.add(panelGlob1,BorderLayout.NORTH);


      this.add(panel_liste,BorderLayout.CENTER);

      this.add(panelGlob2, BorderLayout.SOUTH);


	}


	public void actionPerformed(ActionEvent e) {

	      if (e.getSource() == boutonAjoutRep) {
          	System.out.println("clic sur ajouter jeu reponses");
          	popupJeuRep.setVisible(true);
          }

        if (e.getSource() == boutonModif) { 
          System.out.println("clic sur modif jeu reponses");
              Object [] erf = list.getSelectedValues();
              for(int i = 0; i < erf.length; i++) {
                        System.out.println(erf[i]);
                        element = erf[i].toString();
                  }
            if (element == null) {
                DialogErreur erreur = new DialogErreur();
                erreur.jeuRepVide();
            }
            else {

                  Vector<JeuReponse> vectJeuRep= new Vector<>();
                  vectJeuRep = jeuRepDAO.findAll(categorieSelect);
                  
                  for(int i=0;i<vectJeuRep.size();i++){
                        jeuRep = vectJeuRep.elementAt(i);
                        if(jeuRep.transformToText().equals(element)) {
                              popupModif.setRep1(jeuRep.getRep1());
                              popupModif.setRep2(jeuRep.getRep2());
                              popupModif.setJeuRep(jeuRep);
                        }
                  } 
                  popupModif.setVisible(true);
                  element = null;

            }
           
          }

        if (e.getSource() == listeCat) {    
                                                                //GESTION SELECTION DE LA CATEGORIE
            JComboBox cat = (JComboBox)e.getSource();                         
            String selectCat = (String)cat.getSelectedItem();
            System.out.println("selection d'une categorie");
            categorieSelect = selectCat;
            System.out.println(categorieSelect);
            Vector<JeuReponse> vectJeuRep= new Vector<>();
            jeuRepDAO = new JeuReponseDAO(DBConnection.getInstance());
            vectJeuRep = jeuRepDAO.findAll(categorieSelect);
            jeuRepDAO.printVector(vectJeuRep);
            jeuRep = new JeuReponse();
            int i;
            Vector<String> vectlistRep = new Vector<>();
            for(i=0;i<vectJeuRep.size();i++){

                  jeuRep = vectJeuRep.elementAt(i);
                  vectlistRep.add(jeuRep.transformToText());

            }
            list.setListData(vectlistRep.toArray());
        } 

        if (e.getSource() == boutonActu ) {
          this.actuBoxCat();
        }

        if (e.getSource() == boutonSup ) {
           Object [] erf = list.getSelectedValues();
                  for(int i = 0; i < erf.length; i++) {
                        System.out.println(erf[i]);
                        element = erf[i].toString();
                  }
                  if (element == null) {
                      DialogErreur erreur = new DialogErreur();
                      erreur.jeuRepVide();
                  }
                  else {
                    Vector<JeuReponse> vectJeuRep= new Vector<>();
                    vectJeuRep = jeuRepDAO.findAll(categorieSelect);
                  
                    for(int i=0;i<vectJeuRep.size();i++){
                        jeuRep = vectJeuRep.elementAt(i);
                        if(jeuRep.transformToText().equals(element)) {
                              jeuRepDAO.delete(jeuRep);

                        }
                    }
                    element = null;
                  }

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


        
	
}