package model;

public class Categorie {
	static private int idCategorie =0;
	private String nomCategorie;
	
	public Categorie(String nomCategorie) {
		super();
		++idCategorie;
		this.nomCategorie = nomCategorie;
	}

	public static int getIdCategorie() {
		return idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	

}
