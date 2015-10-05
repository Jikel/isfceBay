package dal;

import java.util.LinkedList;

import launcher.Launcher;
import model.Utilisateur;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//import sun.text.normalizer.Utility;

public class DBOperationsMock implements DBOperations {

	private LinkedList<Utilisateur> utilisateurs = new LinkedList<Utilisateur>();
	
	public DBOperationsMock() {
		Utilisateur utilisateur1 = new Utilisateur("anas","anas","123");
		utilisateurs.add(utilisateur1);
	}

	public LinkedList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public boolean createUtilisateur(Utilisateur newUtilisateur) {
		if (utilisateurs.contains(newUtilisateur))
			return false;
		else {
			utilisateurs.add(newUtilisateur);
			return true;
		}
	}

	public Utilisateur getUtilisateur(String log, String pwd) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getMail().equals(log) && utilisateur.getPassword().equals(pwd)){
				return utilisateur;
			}
		}
		return null;
	}


}
