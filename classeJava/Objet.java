package model;

import java.text.SimpleDateFormat;

public class Objet {
	static private int idObjet;
	private String nomObjet;
	private String descriptionObjet;
	private double prixInitial;
	private double prixAchatImmediat;
	private SimpleDateFormat dateAjout;
	private SimpleDateFormat dateCloture;
	private int actifObjet;
	private Utilisateur utilisateur;
	private Categorie categorie;
	public Objet(String nomObjet, String descriptionObjet, double prixInitial, double prixAchatImmediat,
			SimpleDateFormat dateAjout, SimpleDateFormat dateCloture, int actifObjet, Utilisateur utilisateur,
			Categorie categorie) {
		super();
		++idObjet;
		this.nomObjet = nomObjet;
		this.descriptionObjet = descriptionObjet;
		this.prixInitial = prixInitial;
		this.prixAchatImmediat = prixAchatImmediat;
		this.dateAjout = dateAjout;
		this.dateCloture = dateCloture;
		this.actifObjet = actifObjet;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}
	public static int getIdObjet() {
		return idObjet;
	}
	public String getNomObjet() {
		return nomObjet;
	}
	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
	}
	public String getDescriptionObjet() {
		return descriptionObjet;
	}
	public void setDescriptionObjet(String descriptionObjet) {
		this.descriptionObjet = descriptionObjet;
	}
	public double getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(double prixInitial) {
		this.prixInitial = prixInitial;
	}
	public double getPrixAchatImmediat() {
		return prixAchatImmediat;
	}
	public void setPrixAchatImmediat(double prixAchatImmediat) {
		this.prixAchatImmediat = prixAchatImmediat;
	}
	public SimpleDateFormat getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(SimpleDateFormat dateAjout) {
		this.dateAjout = dateAjout;
	}
	public SimpleDateFormat getDateCloture() {
		return dateCloture;
	}
	public void setDateCloture(SimpleDateFormat dateCloture) {
		this.dateCloture = dateCloture;
	}
	public int getActifObjet() {
		return actifObjet;
	}
	public void setActifObjet(int actifObjet) {
		this.actifObjet = actifObjet;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

}
