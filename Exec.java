
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;






public class Exec  {
	
	
	
	//DB connection
	static Connection connection  = null;
	static String databaseName = "";
	static String url = "jdbc:mysql://localhost:3306/trickandtrail?characterEncoding=utf8";
	
	
	static String username = "root";
	static String password = "K1191Vxt2222";
	
	
	
		
	
	

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException,  SQLException   {
		Ticket t1 = new Ticket("669","06/03/22","Orleans - Paris",32.50 , 0);
		
		
		System.out.println(t1.ImpTicket());
		System.out.println(t1.getDate());
		
		
		//BDD
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(url, username, password);
		
		
		
		
			//Clear Tables
			PreparedStatement clear1 = connection.prepareStatement("TRUNCATE TABLE client");
			
			int status01 = clear1.executeUpdate();
			if(status01 != 0) {
				System.out.println("Connecté à la base de données ");
				System.out.println("CLEAR");
				
			}
			PreparedStatement clear2 = connection.prepareStatement("TRUNCATE TABLE ticket");
			
			int status02 = clear2.executeUpdate();
			if(status02 != 0) {
				
				System.out.println("CLEAR");
				
			}
			PreparedStatement clear3 = connection.prepareStatement("TRUNCATE TABLE trajet");
			
			int status03 = clear3.executeUpdate();
			if(status03 != 0) {
				
				System.out.println("CLEAR");
				
			}
			
			//Insertion client
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Client(Num,Pseudonyme,Mot_de_passe,Email) VALUES ('8','Louis','0000','Louis02@gmail.com');");
			
			int status = ps.executeUpdate();
			if(status != 0) {
				System.out.println("Connecté à la base de données ");
				System.out.println("Insertion client réussie !");
				
			}
			
			
			
			//Insertion ticket
			
			PreparedStatement ticket = connection.prepareStatement("INSERT INTO Ticket(Num,Date) VALUES ('1','"+t1.getDate()+"');");
			
			int status2 = ticket.executeUpdate();
			if(status2 != 0) {
				System.out.println("Connecté à la base de données ");
				System.out.println("insertion ticket réussie");
				
			}
			
			
			//Application
			
			App tAt = new App();
			tAt.setVisible(true);
		
		
			//Création ticket
			
	
	
		
		
		  
		  
	}
	

}
