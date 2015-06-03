import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.*;
import java.lang.String;


public class Controle {

	private String chaine;

	public Controle() {
		chaine = new String("");
	}

	public void exeptQuote()  {
		chaine = chaine.replace("'", "\\'");
	}

	public void exeptSlash() {
		
		chaine = chaine.replace("/", "\\/");
	}
	public void exeptEtoile () {
		chaine = chaine.replace("*", "\\*");
	}

	public String controleChaine(String src) {
		chaine = src;
		this.exeptQuote();
		this.exeptSlash();
		this.exeptEtoile();
		return chaine;
	}

}