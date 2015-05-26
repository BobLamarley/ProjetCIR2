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


	public CreaOngletCat() {


	  fonttitre = new Font("Arial",Font.BOLD , 20);

      titreOngletCat = new JLabel("Gestion des categories");

      titreOngletCat.setFont(fonttitre);

      this.setPreferredSize(new Dimension(650, 380));

      panel_cat = new JPanel();

      paneltitreCat = new JPanel();

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

      this.setLayout(new BorderLayout());


      paneltitreCat.add(titreOngletCat);

      panelGlob1.add(paneltitreCat,BorderLayout.NORTH);

      texteCat = new TextField("",24);


      boutonAjoutCat = new JButton("Ajouter une categorie");

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
        }

    }
        
	
}