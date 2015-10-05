package model;

import java.text.SimpleDateFormat;

public class Profil {
	static private int idProfil=0;
	private String nom;
	private String prenom;
	private SimpleDateFormat dateNaissance;
	private int sexe;
	private String adresse;
	private String pays;
	
	public Profil(String nom, String prenom, SimpleDateFormat dateNaissance, int sexe, String adresse,
			String pays) {
		super();
		++idProfil;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.pays = pays;
	}
	public int getIdProfil() {
		return idProfil;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public SimpleDateFormat getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(SimpleDateFormat dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getSexe() {
		return sexe;
	}
	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	

	
}
