import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class FenetrePopJeuRep extends JDialog implements ActionListener {


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
   private JPanel panel1;
   private JPanel panel2;
   private JPanel panel3;
   private JPanel panelInt1;
   private JPanel panelInt2;
   private JButton boutonActu;

  private CategorieDAO catDAO;
  private Categorie categorie;
  private JeuReponse jeuRep;
  private JeuReponseDAO jeuRepDAO;
  private String [] tabCat;
  private Set<Question> setQuestion;
  private String selectCat; 
  private int idJeuRep;
  private JButton boutonSup;
  private Question quest;
  private String newquestion;
  private QuestionDAO questDAO;
  private int bonnerep;



    public FenetrePopJeuRep() {	

       super();
       this.setModal(true);
       this.setTitle("Ajout d'une question");
       this.setSize(300, 220);
       this.setResizable(false); 

      panel1 = new JPanel();
      panel2 = new JPanel();
      panel3 = new JPanel();
      panelInt1 = new JPanel();
      panelInt2 = new JPanel();


      popJeuRep = new JPanel();
      popJeuRep.setLayout(new BorderLayout());
      panel1.setLayout(new BorderLayout());

      listeCat = new JComboBox(); 

      titreCat = new JLabel("Choisir une catégorie :");

      labelTitre = new JLabel("Ajout d'un jeu de réponses");

      boutonOK = new JButton("Ok");
      boutonActu = new JButton("actu");

      jeuRep1 = new TextField("",24);
      jeuRep2 = new TextField("",24);
      jeuRep3 = new JLabel("les deux");

      labelJeuRep1 = new JLabel("Réponse 1:");
      labelJeuRep2 = new JLabel("Réponse 2:");
      labelJeuRep3 = new JLabel("Réponse 3:");

      boutonOK.addActionListener(this);
      listeCat.addActionListener(this);
      boutonActu.addActionListener(this);

      panelInt1.add(labelTitre);
      panelInt1.add(boutonActu);
      panelInt2.add(titreCat);
      panelInt2.add(listeCat);

      panel1.add(panelInt1,BorderLayout.NORTH);
      panel1.add(panelInt2,BorderLayout.CENTER);

      panel2.add(labelJeuRep1);
      panel2.add(jeuRep1);
      panel2.add(labelJeuRep2);
      panel2.add(jeuRep2);
      panel2.add(labelJeuRep3);
      panel2.add(jeuRep3);
      panel3.add(boutonOK);

      popJeuRep.add(panel1,BorderLayout.NORTH);
      popJeuRep.add(panel2,BorderLayout.CENTER);
      popJeuRep.add(panel3,BorderLayout.SOUTH);

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
          jeuRepDAO = new JeuReponseDAO(DBConnection.getInstance());
          jeuRepDAO.create(new JeuReponse( selectCat , jeuRepDAO.getMaxId() , rep1 , rep2 ));
          this.setVisible(false);
        }

        if (e.getSource()== boutonActu ) {
          this.actuBoxCat();
        }

        if (e.getSource() == listeCat ) {
          JComboBox cat = (JComboBox)e.getSource();                         
          selectCat = (String)cat.getSelectedItem();
          System.out.println("selection d'une categorie");
          System.out.println(selectCat);
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