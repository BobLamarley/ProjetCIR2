import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;


public class CreaOngletCat extends JPanel implements ActionListener  {

	private JLabel titreOngletCat;
	private JPanel panel_cat;
	private JPanel paneltitreCat;
	private JPanel panel_liste;
	private JPanel panelGlob1;
	private JPanel panelGlob2;
	private TextField texteCat;
	private JButton boutonAjoutCat;
	private Font fonttitre;
	private ArrayList<String> maListe;
	private JList list;
      private CategorieDAO catDAO;
      private JButton boutonActu;
      private String texteAjout;
      private Categorie categorie;
      private JButton boutonSup;
      private String element;
      //private JOptionPane dialogErreur;


	public CreaOngletCat() {

      /************************************** Initialisation de la liste de categories**********************************/

      
	fonttitre = new Font("Arial",Font.BOLD , 20);

      titreOngletCat = new JLabel("Gestion des catégories");

      titreOngletCat.setFont(fonttitre);

      this.setPreferredSize(new Dimension(650, 380));

      panel_cat = new JPanel();

      paneltitreCat = new JPanel();

      panel_liste = new JPanel();

      this.list=new JList();

      boutonActu = new JButton("actualiser");
      boutonActu.addActionListener(this);
      
	panel_liste.add(list);
      panel_liste.add(boutonActu);

      boutonSup = new JButton("supprimer");
      boutonSup.addActionListener(this);

      panel_liste.add(boutonSup);

      panelGlob1 = new JPanel();
      panelGlob2 = new JPanel();
     
      panelGlob1.setLayout(new BorderLayout());

      this.setLayout(new BorderLayout());


      paneltitreCat.add(titreOngletCat);

      panelGlob1.add(paneltitreCat,BorderLayout.NORTH);

      texteCat = new TextField("",24);


      boutonAjoutCat = new JButton("Ajouter une catégorie");

      boutonAjoutCat.addActionListener(this);

      panelGlob2.add(texteCat);
      panelGlob2.add(boutonAjoutCat);
      

      this.add(panelGlob1,BorderLayout.NORTH);


      this.add(panel_liste,BorderLayout.CENTER);

      this.add(panelGlob2, BorderLayout.SOUTH);


	}


	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == boutonAjoutCat) {
                  System.out.println("clic sur ajouter categorie");
                  texteAjout = texteCat.getText();
                  if (texteAjout.equals("")){
                        DialogErreur erreur = new DialogErreur();
                        erreur.catVide();
                  }
                  else {
                        categorie.setLibelle(texteAjout);
                        catDAO.create(categorie);
                        this.actuListe();
                  }
                  texteCat.setText("");
            }
            if (e.getSource() == boutonActu) {
                  this.actuListe();
            } 

            if (e.getSource() == boutonSup) {
                  Object [] erf = list.getSelectedValues();
                  for(int i = 0; i < erf.length; i++) {
                        System.out.println(erf[i]);
                        element = erf[i].toString();
                  }
                  Vector<Categorie> vectCat= new Vector<>();
                  vectCat = catDAO.findAll();
                  int i;
                  for(i=0;i<vectCat.size();i++){
                        categorie = vectCat.elementAt(i);
                        if(categorie.getLibelle().equals(element)) {
                              catDAO.delete(categorie);
                        }
                  }

            }
      }

      public void actuListe() {

            catDAO = new CategorieDAO(DBConnection.getInstance());
            maListe = new ArrayList<String>();

            Vector<Categorie> vectCat= new Vector<>();
            vectCat = catDAO.findAll();
            catDAO.printVector(vectCat);
            categorie = new Categorie();
            int i;
            for(i=0;i<vectCat.size();i++){
                   categorie = vectCat.elementAt(i);

                  maListe.add(categorie.getLibelle());
            }
            list.setListData(maListe.toArray());
      }
      
      public void ajouterCat() {

      }
	
}