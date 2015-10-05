package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import model.*;

public class DBOperationsSQLite implements DBOperations {

	private static String dbUrl="jdbc:sqlite:src\\ISFCEBAY.sqlite";
	
	public DBOperationsSQLite() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public LinkedList<Utilisateur> getUtilisateurs() {

		LinkedList<Utilisateur> utilisateurs = new LinkedList<Utilisateur>();
		Connection c = null;
		Statement stmt = null;

		try {
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur;");

			while (rs.next()) {
				String idToCast = rs.getString("idUtilisateur");
				int id = Integer.parseInt(idToCast);
				String pseudo = rs.getString("pseudo");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				/*
				System.out.println("ID = " + id);
				System.out.println("NOM = " + nom);
				System.out.println("MAIL = " + mail);
				System.out.println("PASSWORD = " + password);
				*/
				Utilisateur utilisateur = new Utilisateur(id,pseudo,mail,password);
				utilisateurs.add(utilisateur);
			}
			
			rs.close();
			stmt.close();
			c.close();
			return (utilisateurs);
	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}

	}
	

	public boolean createUtilisateur(Utilisateur newUtilisateur) {

		Connection connectionDB = null;
		PreparedStatement requeteSQLPreparee = null;
		
		try {
			connectionDB = DriverManager.getConnection(dbUrl);
			connectionDB.setAutoCommit(true);
						
			requeteSQLPreparee = connectionDB.prepareStatement("INSERT INTO Utilisateur(pseudo, email, password) VALUES(?, ?, ?);");
			requeteSQLPreparee.setString(1, newUtilisateur.getPseudo());
			requeteSQLPreparee.setString(2, newUtilisateur.getMail());
			requeteSQLPreparee.setString(3, newUtilisateur.getPassword());
						
			// !!!
			// ATTENTION, pour un INSERT sql, on n'utilise pas la méthode executeQuery, mais cette méthode ci (executeUpdate()) :
			requeteSQLPreparee.executeUpdate();
			//newUtilisateur.setId(this.getUtilisateur(newUtilisateur.getPseudo(), newUtilisateur.getPassword()).getId());
						
			requeteSQLPreparee.close();
			connectionDB.close();
			
			return true;
	
		} catch (Exception e) {
			System.out.println("ERREUR OPERATION DB");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public boolean createProfil(Profil profilToAdd) {

		Connection connectionDB = null;
		PreparedStatement requeteSQLPreparee = null;
		
		try {
			connectionDB = DriverManager.getConnection(dbUrl);
			connectionDB.setAutoCommit(true);			
			requeteSQLPreparee = connectionDB.prepareStatement("INSERT INTO Profil( nom, prenom, dateNaissance, sexe, adresse, pays,idUtilisateur) VALUES( ?, ?, ?, ?, ?, ?, ?);");
			requeteSQLPreparee.setString(1, profilToAdd.getNom());
			requeteSQLPreparee.setString(2, profilToAdd.getPrenom());
			requeteSQLPreparee.setString(3, profilToAdd.getDateNaissance().toString());
			requeteSQLPreparee.setString(4, Integer.toString(profilToAdd.getSexe()));
			requeteSQLPreparee.setString(5, profilToAdd.getAdresse());
			requeteSQLPreparee.setString(6, profilToAdd.getPays());
			requeteSQLPreparee.setString(7, Integer.toString(profilToAdd.getUser().getId()));
						
			// !!!
			// ATTENTION, pour un INSERT sql, on n'utilise pas la méthode executeQuery, mais cette méthode ci (executeUpdate()) :
			requeteSQLPreparee.executeUpdate();
			requeteSQLPreparee.close();
			connectionDB.close();
			
			return true;
	
		} catch (Exception e) {
			System.out.println("ERREUR OPERATION DB");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public Categorie getCategorie(int id){
		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Categorie categorie = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.prepareStatement("SELECT * FROM Categorie WHERE idCategorie=?");
			stmt.setString(1, Integer.toString(id));
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String nomCat = rs.getString("nomCategorie");
				categorie = new Categorie(id,nomCat);
			}
			return categorie;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}	
	}
	public Utilisateur getUtilisateur (int id){

		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Utilisateur utilisateur = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur=?");
			stmt.setString(1, Integer.toString(id));
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String pseudo = rs.getString("fkpseudo");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				utilisateur = new Utilisateur(id,pseudo,mail,password);
			}
			return utilisateur;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
	
	}
	public Utilisateur getUtilisateur(String log, String pwd) {
		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Utilisateur utilisateur = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(true);
			stmt = c.prepareStatement("SELECT * FROM Utilisateur WHERE ( pseudo = ? OR email = ? ) AND password= ?");
			stmt.setString(1, log);
			stmt.setString(2, log);
			stmt.setString(3, pwd);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("idUtilisateur");
				String pseudo = rs.getString("pseudo");
				String mail = rs.getString("email");
				String password = rs.getString("password");
				utilisateur = new Utilisateur(id,pseudo,mail,password);
			}
			return utilisateur;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
	}
	public Profil getProfil(Utilisateur user) {
		Connection c = null;
		PreparedStatement stmt = null;

		try {
			Profil profil = null;
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.prepareStatement("SELECT * FROM Profil WHERE  fkUtilisateur=?");
			stmt.setString(1, Integer.toString(user.getId()));
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String idToCast = rs.getString("idProfil");
				int id = Integer.parseInt(idToCast);
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				SimpleDateFormat naissance = new SimpleDateFormat((rs.getString("dateNaissance")));
				String sexeToCast = rs.getString("sexe");
				int sexe = Integer.parseInt(sexeToCast);
				String adresse = rs.getString("adresse");
				String pays = rs.getString("pays");
				profil = new Profil(id,nom,prenom,naissance,sexe,adresse,pays,user);
			}
			return profil;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
	}
	
	public LinkedList<Objet> getObjet() {

		LinkedList<Objet> objets = new LinkedList<Objet>();
		Connection c = null;
		Statement stmt = null;

		try {
			c = DriverManager
					.getConnection(dbUrl);
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Objet ORDER BY dateCloture;");

			while (rs.next()) {
				String idToCast = rs.getString("idObjet");
				int id = Integer.parseInt(idToCast);
				String nomObjet = rs.getString("nomObjet");
				String descriptionObjet = rs.getString("descriptionObjet");
				String prixToCast = rs.getString("prixInitial");
				double prixInitial = Double.parseDouble(prixToCast);
				String prixAchatImmediatToCast = rs.getString("prixAchatImmediat");
				double prixAchatImmediat = Double.parseDouble(prixAchatImmediatToCast);
				SimpleDateFormat dateAjout = new SimpleDateFormat((rs.getString("dateAjout")));
				SimpleDateFormat dateCloture = new SimpleDateFormat((rs.getString("dateCloture")));
				String actifToCast = rs.getString("actifObjet");
				int isActif = Integer.parseInt(actifToCast);
				String idUserToCast = rs.getString("fkUtilisateur");
				int idUser = Integer.parseInt(idUserToCast);
				Utilisateur user= this.getUtilisateur(idUser);
				String catToCast = rs.getString("fkCategorie");
				Categorie categorie = getCategorie(Integer.parseInt(catToCast));
				Objet objet = new Objet(id,nomObjet,descriptionObjet,prixInitial,prixAchatImmediat,dateAjout,dateCloture,isActif,user,categorie);
				objets.add(objet);
			}
			
			rs.close();
			stmt.close();
			c.close();
			return (objets);
	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}

	}

}
