 
package entite;
 
public class Utilisateur {
 
	private String nom;
	private String email;
	private double telephone;
	
	private String adresse;
	private String ville;
	
	public Utilisateur(String nom, String email, double telephone, String adresse, String ville) {
	this.nom=nom;
	this.email=email;
	this.telephone=telephone;
	this.adresse=adresse;
	this.ville=ville;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getTelephone() {
		return telephone;
	}
	public void setTelephone(double telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
 
}