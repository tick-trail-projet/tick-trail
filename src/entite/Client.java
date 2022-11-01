package entite;

import java.util.Date;

public class Client extends Utilisateur{
 
	private String code_client;
	private double NumID;
	
	private String prenom;
	
	private Date datecreation;
	private double solde;
	private double ptsfidelites;
 
	// CONSTRUCTEURS
	// -------------
		// Initialisation
 
	public Client(String code_client, String nom, Date datecreation, 
			double solde, String adresse, double telephone, String email,
			String prenom, String ville, Double ptsfidelites, Double NumID) {
		super(nom,email,telephone,adresse,ville);
		this.code_client = code_client;
		this.datecreation = datecreation;
		this.solde = solde;
		this.prenom = prenom;
		this.ptsfidelites = ptsfidelites;
		this.NumID = NumID;
	}
	//-------------------------
	
	
	
	// Getters
	//--------------------------
 
	public String getCode_client() {
		return code_client;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public double getSolde() {
		return solde;
	}
	public String getPrenom() {
		return prenom;
	}
	public double getPtsfidelites() {
		return ptsfidelites;
	}
	public double getNumID() {
		return NumID;
	}
 
 
	// Setters
 
	public void setCode_client(String code_client) {
		this.code_client = code_client;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	} 
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setPtsfidelites(double ptsfidelites) {
		this.ptsfidelites = ptsfidelites;
	}

	public void setNumID(double numID) {
		this.NumID = numID;
	}
	//--------------------------
 
}