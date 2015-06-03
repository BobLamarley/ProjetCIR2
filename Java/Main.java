import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class Main {

	/*private Controle controleur;
	private String test;
	private String result;*/

	public static void main(String[] args) {

		Controle controleur = new Controle();

		IntConnectionBDD run = new IntConnectionBDD();

		String test = "la \"mangue\" l'ai/*me et l'a*/dore";
		
		String result = controleur.controleChaine(test);

		System.out.println(result);
		System.out.println("Default Encoding:" + System.getProperty("file.encoding"));
	}
}