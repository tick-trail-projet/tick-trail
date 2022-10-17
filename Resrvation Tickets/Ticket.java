
import java.text.DateFormat;
import java.util.Date;

public class Ticket {

	// Ticket herite de Client
	// NumTicket --> numClient/dateTicket
	//
	//
	//

	Date aujourdhui = new Date();

	DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

	private int numTicket;
	private String numClient; // BD VIDE
	private String date;
	private String nomTrajet ; // BD VIDE;
	private String imp;// impression ticket
	private double prix;

	Ticket(String numClient, String date , String nomTrajet , double prix ,int numTicket  ) {

		this.numClient = numClient ; 
		this.date = date;		
		this.nomTrajet = nomTrajet  ;
		this.prix = prix;
		this.numTicket = numTicket ;
		
	}

	
	public void ReservationTicket() {
		
		 
		System.out.println(Integer.parseInt(this.getNumClient())+"");
	}

	public String ImpTicket() {
		return imp = "Numéro Client : " + this.getNumClient() + "\n" + "Date de création : " + this.getDate() + "\n" +
					 "Nom du trajet : " + this.getNomTrajet() + "\n" + "Horaire Trajet : " + "00 : 00 : 00" + "\n" +
					 "Prix : " + this.getPrix(); 
			

		
	}

	// GETTERS
	public String getNumClient() {

		return numClient;
	}

	public int getNumTicket() {

		return numTicket;
	}

	public String getDate() {
		date = shortDateFormat.format(aujourdhui);
		return date;
	}

	public String getNomTrajet() {

		return nomTrajet;
	}

	public String getImp() {

		return imp;
	}

	public double getPrix() {

		return prix;

	}
}
