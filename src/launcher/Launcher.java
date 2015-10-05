package launcher;

import dal.DBOperations;
import dal.DBOperationsMock;
import dal.DBOperationsSQLite;
import ihm.ConnexionConsole;
import ihm.ConnexionSwing;
import uc.GestionUtilisateurs;
import uc.GestionUtilisateursImpl;

public class Launcher {

	private ConnexionConsole connexionConsole;
	private ConnexionSwing connexionSwing;
	private DBOperations dBOperations;
	private GestionUtilisateurs gestionUtilisateurs;

	public Launcher() {
		// CHOIX DB MOCK/SQLITE
		dBOperations=new DBOperationsMock();
		dBOperations = new DBOperationsSQLite();

		gestionUtilisateurs = new GestionUtilisateursImpl(this);

		// CHOIX INTERFACE SWING/CONSOLE
		 //connexionSwing = new ConnexionSwing(this);
		 connexionConsole=new ConnexionConsole(this);
	}

	public static void main(String[] args) {
		Launcher launch = new Launcher();
	}

	//public ConnexionConsole getConnexionConsole() {
		//return connexionConsole;
	//}

	public ConnexionSwing getConnexionSwing() {
		return connexionSwing;
	}

	public GestionUtilisateurs getGestionUtilisateurs() {
		return gestionUtilisateurs;
	}

	public DBOperations getDBOperations() {
		return dBOperations;
	}

}
