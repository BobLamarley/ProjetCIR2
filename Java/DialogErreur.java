import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

public class DialogErreur extends JOptionPane  {

	private JOptionPane dialog;

	public DialogErreur() {
		dialog = new JOptionPane();
	}

	public void catVide() {
        dialog.showMessageDialog(null, "Veuillez entrer une categorie", "Attention", JOptionPane.WARNING_MESSAGE);
	}
	public void jeuRepVide() {
        dialog.showMessageDialog(null, "Veuillez sélectionner un jeu de réponses", "Attention", JOptionPane.WARNING_MESSAGE);
	}

	public void textRepVide() {
        dialog.showMessageDialog(null, "Veuillez entrer les réponses", "Attention", JOptionPane.WARNING_MESSAGE);
	}

	public void selectQuestionVide() {
		dialog.showMessageDialog(null, "Veuillez sélectionner une question", "Attention", JOptionPane.WARNING_MESSAGE);
	}
	public void questionVide() {
		dialog.showMessageDialog(null, "Veuillez rentrer une question", "Attention", JOptionPane.WARNING_MESSAGE);
	}
	public void selectCatVide() {
        dialog.showMessageDialog(null, "Veuillez sélectionner une categorie", "Attention", JOptionPane.WARNING_MESSAGE);
	}

	public void afficheManqueJeuRep(Vector<String> vect) {
		Vector<String> vecteurCat = new Vector<>();
		vecteurCat = vect;
		for(int i = 0 ; i < vecteurCat.size() ;i++ ) {
		dialog.showMessageDialog(null, "Il manque des jeux de réponses à la catégorie: "+vecteurCat.elementAt(i), "Attention une catégorie doit contenir minimum 2 jeux de réponses", JOptionPane.WARNING_MESSAGE);
		}
	}
	public void afficheManqueQuest(Vector<String> vectJ) {
		Vector<String> vecteurJeuRep = new Vector<>();
		vecteurJeuRep = vectJ;
		for(int i = 0 ; i < vecteurJeuRep.size() ;i++ ) {
		dialog.showMessageDialog(null, "Il manque des questions au jeu de réponses: "+vecteurJeuRep.elementAt(i), "Attention un jeu de réponses doit contenir minimum 4 questions", JOptionPane.WARNING_MESSAGE);
		}
	}
}