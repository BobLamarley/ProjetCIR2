import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class PopupModifJeuRep extends JDialog implements ActionListener {

   private JButton boutonOK;

   private JPanel panelGlobal;

   private JLabel titreJeuRep;

   private String texte;

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
   private JeuReponse jeurep;
   private JeuReponseDAO jeuRepDAO;

    public PopupModifJeuRep() {	

       super();
       this.setModal(true);
       this.setTitle("Modification d'un jeu de r�ponses");
       this.setSize(300, 200);
       this.setResizable(false);
       panelGlobal = new JPanel();
      panelGlobal.setLayout(new BorderLayout());

      titreJeuRep = new JLabel("Modifier jeu de r�ponses");

      panel1 = new JPanel();
      panel2 = new JPanel();
      panel3 = new JPanel();
      panelInt1 = new JPanel();
      panelInt2 = new JPanel();

      boutonOK = new JButton("ok");
      boutonOK.addActionListener(this);
      panel1.add(titreJeuRep);
      panelGlobal.setLayout(new BorderLayout());

      jeuRep1 = new TextField("",24);
      jeuRep2 = new TextField("",24);
      jeuRep3 = new JLabel("les deux");

      labelJeuRep1 = new JLabel("R�ponse 1:");
      labelJeuRep2 = new JLabel("R�ponse 2:");
      labelJeuRep3 = new JLabel("R�ponse 3:");
      panel2.add(labelJeuRep1);
      panel2.add(jeuRep1);
      panel2.add(labelJeuRep2);
      panel2.add(jeuRep2);
      panel2.add(labelJeuRep3);
      panel2.add(jeuRep3);
      panel3.add(boutonOK);

      panelGlobal.add(panel1,BorderLayout.NORTH);
      panelGlobal.add(panel2,BorderLayout.CENTER);
      panelGlobal.add(panel3,BorderLayout.SOUTH);


      panelGlobal.setOpaque(true);

      this.getContentPane().add(panelGlobal);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);             
      this.setVisible(false);
  

    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boutonOK) {
          System.out.println("clic sur ok");
          jeuRepDAO = new JeuReponseDAO(DBConnection.getInstance());
          jeurep.setRep1(jeuRep1.getText());
          jeurep.setRep2(jeuRep2.getText());
          jeuRepDAO.update(jeurep);
          this.setVisible(false);

        }
  }

  public void setRep2(String rep2) {
    jeuRep2.setText(rep2);
  }

  public void setRep1(String rep1) {
      jeuRep1.setText(rep1);
  }

  public void setJeuRep(JeuReponse jeureponse) {
      jeurep = jeureponse;
  }

}