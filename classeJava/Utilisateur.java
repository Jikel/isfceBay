package model;

public class Utilisateur {
	static private int idUtilisateur=0;
	private String mail;
	private String password;
	private Profil profil;
	
	public Utilisateur(String mail, String password, Profil profil) {
		super();
		++idUtilisateur;
		this.mail = mail;
		this.password = password;
		this.profil = profil;
	}

	public static int getIdUtilisateur() {
		return idUtilisateur;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	

}
