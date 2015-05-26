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


	public CreaOngletJeuRep() {

	  popupJeuRep = new FenetrePopJeuRep();

	  fonttitre = new Font("Arial",Font.BOLD , 20);	

      titreOngletJeuRep = new JLabel("Gestion des jeux de reponses");

      titreOngletJeuRep.setFont(fonttitre);

      panel_rep = new JPanel();

      paneltitreRep = new JPanel();

      panel_liste = new JPanel();

      maListe = new ArrayList<String>();

      maListe.add("Permier Element");
      maListe.add("Second Element");
      maListe.add("Troisieme Element");
      maListe.add("Quatrieme Element");
      maListe.add("Cinquieme Element");

      this.list=new JList();

      list.setListData(maListe.toArray());
	  panel_liste.add(list);

      panelGlob1 = new JPanel();
      panelGlob2 = new JPanel();
     
      panelGlob1.setLayout(new BorderLayout());

      titreOngletJeuRep.setFont(fonttitre);

      this.setLayout(new BorderLayout());


      paneltitreRep.add(titreOngletJeuRep);

      panelGlob1.add(paneltitreRep,BorderLayout.NORTH);

      String[] tabCat = {"cinema","histoire","people","ISEN"};

      listeCat = new JComboBox(tabCat);
	  titreCat = new JLabel("Choisir une categorie :");

      panel_rep.add(titreCat);
      panel_rep.add(listeCat);

      panelGlob1.add(panel_rep,BorderLayout.CENTER);

      boutonAjoutRep = new JButton("Ajouter un jeu de reponses");

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

    }


  public String getRep1(){
  	rep1 = popupJeuRep.getRep1();
    return rep1;
  }

  public String getRep2(){
  	rep2 = popupJeuRep.getRep2();
    return rep2;
  }

        
	
}