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



	public CreaOngletQuest() {

		popupQuest= new FenetrePopQuest();

		fonttitre = new Font("Arial",Font.BOLD , 20);	

		titreOngletQuest = new JLabel("Gestion des questions");

		String[] tabJeuRep = {"Bernard Tapie, un tapis, les deux","lama , sticot , les deux"};

		String[] tabCat = {"cinema","histoire","people","ISEN"};

		titreCat = new JLabel("Choisir une categorie :");

		titreJeuRep = new JLabel("Choisir un jeu de reponses :");

		listeJeuRep = new JComboBox(tabJeuRep);

		listeCat = new JComboBox(tabCat);

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

      	panel_quest1 = new JPanel();

        paneltitreQuest = new JPanel();

        panel_quest2 = new JPanel();

      	panelGlob1 = new JPanel();
      	panelGlob2 = new JPanel();

      	panelGlob1.setLayout(new BorderLayout());

      	this.setLayout(new BorderLayout());

      	titreOngletQuest.setFont(fonttitre);

      	paneltitreQuest.add(titreOngletQuest);

      	panelGlob1.add(paneltitreQuest,BorderLayout.NORTH);

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

    }
        
	
}