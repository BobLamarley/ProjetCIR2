import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class PopupModifQuest extends JDialog implements ActionListener {

   private JButton boutonOK;
   private TextField question;
   private JPanel ongletQuest;
   private JLabel titreOnglet;
   private String texte;
   private JButton boutonActu;
   private JComboBox listeBR;
   private JeuReponse jeuReponse;
   private QuestionDAO questDAO;
   private int bonnerep;
   private Question modifQuestion;
   private JLabel labelBR;
   private Controle controleur;
   private String questionControle;



    public PopupModifQuest() {	

       super();
       this.setModal(true);
       this.setTitle("Modification d'une question");
       this.setSize(250, 130);
       this.setResizable(false);
       jeuReponse = new JeuReponse();
       modifQuestion = new Question();

       labelBR = new JLabel("Bonne réponse:");


      titreOnglet = new JLabel("Modifier question");
      ongletQuest = new JPanel();

      listeBR = new JComboBox();

      boutonOK = new JButton("ok");
      question = new TextField("",30);
      boutonOK.addActionListener(this);
      ongletQuest.add(titreOnglet);
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
          System.out.println("clic sur ok");
          DialogErreur erreur = new DialogErreur();
          texte = question.getText();
          if (texte.equals("")){
              erreur.questionVide();
          }
          else {
          questDAO = new QuestionDAO(DBConnection.getInstance());
          controleur = new Controle();
          questionControle = controleur.controleChaine(texte);
          String selectBR = new String((String)listeBR.getSelectedItem());
          if ( selectBR.equals(jeuReponse.getRep1())) {
              bonnerep = 1;
          }
          else if (selectBR.equals(jeuReponse.getRep2())) {
              bonnerep = 2;
          } 
          else if (selectBR.equals("les deux")) {
              bonnerep = 3;
          }
          modifQuestion.setIntitule(texte);
          modifQuestion.setBonnerep(bonnerep);
          questDAO.update(modifQuestion);
          System.out.println("ca passe la requete");
          this.setVisible(false);
          question.setText("");
          listeBR.removeAllItems();
          }
  
        }
  
  }

  public String getText() {
    return texte;
  }

  public void setText(String selectQuestion) {
      question.setText(selectQuestion);
  }

  public void setReponse( JeuReponse jeurep) {
    jeuReponse = jeurep;
    Vector<String> vectBonneRep = new Vector<>();
    vectBonneRep.add(jeuReponse.getRep1());
    vectBonneRep.add(jeuReponse.getRep2());
    vectBonneRep.add("les deux");
    listeBR.removeAllItems();
    listeBR.setModel(new DefaultComboBoxModel(vectBonneRep));
    ongletQuest.updateUI();
  }

  public void setQuestion (Question laQuestion ) {
    modifQuestion = laQuestion;
    System.out.println(modifQuestion.getLibelle());
  }

}