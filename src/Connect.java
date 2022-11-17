import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.SQLException;



public class Connect {
Scanner sc =new Scanner(System.in);
String sql =sc.nextLine();

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ticktrail?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user="root";
        String passwd="";


try{
Connection connect = DriverManager.getConnection(url, user,passwd);
System.out.println("Connecter");
java.sql.Statement statement =  connect.createStatement();
java.sql.ResultSet resultSet =  statement.executeQuery("SELECT * FROM cities");
}catch (Exception e){
e.printStackTrace();
System.out.println("Erreur de connexion");
System.exit(0);
}




}

    
}
