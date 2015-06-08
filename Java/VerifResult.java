import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class VerifResult {
  
  	private Connection connect;
  	private Vector<String> vectCat;
  	private Vector<String> erreur;
  	private Vector<Integer> vectIdJeuRep;
  	private Vector<Integer> idJeuRepManque;
  	private Vector<String> vectJeuRep;


    public VerifResult(Connection c){
    		 connect = c;           
        }

    public void selectCat() {
    	 vectCat = new Vector<>();

    	try {
    		ResultSet result = this.connect.createStatement(
            	ResultSet.TYPE_SCROLL_INSENSITIVE,
            	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT libelle FROM categorie WHERE 1");
    		while(result.next()){
                    vectCat.add(result.getString(1));
               	 }
            int i;
        	for (i=0;i<vectCat.size();i++) {
            	System.out.println(vectCat.elementAt(i));
        	}
    	}
    	catch (SQLException e) {
            e.printStackTrace();
        }
        this.verifJeuRep();        
    }

    public void verifJeuRep() {
    	erreur = new Vector<>();
        Vector<Integer> vectNB = new Vector<>();
        System.out.println(vectCat.size());
    	try {
		for (int i=0;i<vectCat.size();i++) {
			String element = vectCat.elementAt(i);
    		ResultSet result = this.connect.createStatement(
            	ResultSet.TYPE_SCROLL_INSENSITIVE,
            	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM jeureponses WHERE LIBELLE = '"+element+"';");
    		while(result.next()){
                   	 vectNB.add(result.getInt(1));
               		}
    		for (int j=0;j<vectNB.size();j++) {
            		System.out.println(vectNB.elementAt(j));
            		if (vectNB.elementAt(j)< 2) {
            			erreur.add(element);
            			System.out.println("Il manque des jeu de réponses (le minimum est deux ) a la catégorie :"+element);
            		}
            		if (vectNB.elementAt(j)>= 2) {
            			System.out.println("Il ne manque aucun jeu de réponses");
            		}
        	}
        	System.out.println("lama");
        	vectNB.clear();
    	}

    	}
    	catch (SQLException e) {
            e.printStackTrace();
        }
        this.selectIdJeuRep(); 	
    }

    public void selectIdJeuRep() {
    	try {
			vectIdJeuRep = new Vector<>();
    		ResultSet result = this.connect.createStatement(
            	ResultSet.TYPE_SCROLL_INSENSITIVE,
            	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT `idjeurep` FROM `jeureponses` WHERE 1");
    		while(result.next()){
                   	 vectIdJeuRep.add(result.getInt(1));
               		}
        	System.out.println("Select des id jeu de réponses");

    	}
    	catch (SQLException e) {
            e.printStackTrace();
        }
         this.verifJeuQuest();	
    }

    public void verifJeuQuest() {
    	Integer erreurint;
    	idJeuRepManque = new Vector<>();
    	Vector<Integer> vectQuest = new Vector<>();
    	try {
		for (int i=0;i<vectIdJeuRep.size();i++) {
			Integer idJeuRep = vectIdJeuRep.elementAt(i);
    		ResultSet result = this.connect.createStatement(
            	ResultSet.TYPE_SCROLL_INSENSITIVE,
            	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM questions WHERE idjeurep = '"+idJeuRep+"';");
    		while(result.next()){
                   	 vectQuest.add(result.getInt(1));
               		}
    		for (int j=0;j<vectQuest.size();j++) {
            		System.out.println(vectQuest.elementAt(j));
            		if (vectQuest.elementAt(j)< 4) {
            			erreurint = idJeuRep;
            			System.out.println("ID du jeu réponses ou il manque des quest:"+idJeuRep);
            			idJeuRepManque.add(idJeuRep);
            		}
        	}
        	System.out.println("lama");
        	vectQuest.clear();
    	}

    	}
    	catch (SQLException e) {
            e.printStackTrace();
        }
        this.showJeuRepManque();
    }
    public void showJeuRepManque() {
    	vectJeuRep = new Vector<>();
    	try {
    	for (int i=0;i<idJeuRepManque.size();i++) {
    		Integer elem = idJeuRepManque.elementAt(i);
    		ResultSet result = this.connect.createStatement(
            	ResultSet.TYPE_SCROLL_INSENSITIVE,
            	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT rep1 , rep2 FROM jeureponses WHERE idjeurep = '"+elem+"';");
    		while(result.next()){
                   	 vectJeuRep.add(result.getString(1)+", "+result.getString(2)+", les deux");
               		}
    	}
    	}
    	catch (SQLException e) {
            e.printStackTrace();
        }
        this.afficheCat();
        this.afficheJeuRep();
    }

    public void afficheCat() {

    	 for (int i=0;i<erreur.size();i++) {
            		System.out.println("il manque des jeux de réponses à la catégorie:"+erreur.elementAt(i));
		}
    }
    public void afficheJeuRep() {

    	 for (int i=0;i<vectJeuRep.size();i++) {
            		System.out.println("Il manque des questions au jeu de réponses:"+vectJeuRep.elementAt(i));
		}
    }

    public Vector<String> getManqueCat() {
    	System.out.println(erreur);
    	return erreur;
    }
    public Vector<String> getManqueJeuRep() {
    	return vectJeuRep;
    }

}