package entite;

import java.util.Scanner;
import java.util.regex.Pattern;

class CreationUtilisateur {

	// PASSWORD
	// -------------

	// 4-8 character password requiring numbers and alphabets of both cases
	private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";

	// 4-32 character password requiring at least 3 out of 4 (uppercase
	// and lowercase letters, numbers & special characters) and at-most
	// 2 equal consecutive chars.
	private static final String COMPLEX_PASSWORD_REGEX = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|"
			+ "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" + "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|"
			+ "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})"
			+ "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" + "{8,32}$";

	private static final Pattern PASSWORD_PATTERN = Pattern.compile(COMPLEX_PASSWORD_REGEX);

	// -------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Renseignement -> Utilisateur
		System.out.println("Veuillez renseigner votre type de compte:\"Entreprise\" ou \"Client\": ");
		String type = sc.nextLine();
		if (type.equals("Entreprise")) {
//			System.out.println("Nom d'organisme: ");
//			String name = sc.nextLine();
//			System.out.println("Adresse d'organisme: ");
//			String address = sc.nextLine();
//			System.out.println("ville d'organisme: ");
//			String city = sc.nextLine();
//			System.out.println("email de contact: ");
//			String email = sc.nextLine();
//			System.out.println("Telephone contact: ");
//			String telephone = sc.nextLine();
//
//			int i = 0;
//			while (i < 14) {
//				System.out.println("Numéro de SIRET (14 chiffres): ");
//				double siret = sc.nextDouble();
//				String s = Double.toString(siret);
//				for (int j = 0; j < s.length(); j++) {
//					i++;
//				}
//				if (s.length() < 14) {
//					System.out.println("Numéro de SIRET trop court");
//				}else if (s.length() > 14) {
//					System.out.println("Numéro de SIRET trop long");
//				}
//			}
//
//			System.out.println("Condition de definition du mot de passe - Mot de passe "
//					+ "de 4 a 32 caracteres necessitant " + "au moins 3 sur 4 (lettres majuscules et minuscules, "
//					+ "chiffres et caractères speciaux) et au plus 2 caracteres " + "consecutifs egaux.");
//
//			System.out.println("Veuillez saisir un mot de passe:");
//			String password = sc.nextLine();
//
//			// Validate a password
//			if (PASSWORD_PATTERN.matcher(password).matches()) {
//				System.out.print("Le mot de passe " + password + " est valide");
//			} else {
//				System.out.print("Le mot de passe" + password + " est valide");
//			}
		main(args);
		} else if (type.equals("Client")) {

			System.out.println("Nom: ");
			String name = sc.nextLine();
			System.out.println("Prenom: ");
			String surname = sc.nextLine();
			System.out.println("Adresse: ");
			String address = sc.nextLine();
			System.out.println("ville: ");
			String city = sc.nextLine();
			System.out.println("email de contact: ");
			String email = sc.nextLine();
			System.out.println("Telephone contact: ");
			String telephone = sc.nextLine();

			System.out.println("Condition de definition du mot de passe - Mot de passe "
					+ "de 4 a 32 caracteres necessitant " + "au moins 3 sur 4 (lettres majuscules et minuscules, "
					+ "chiffres et caractères speciaux) et au plus 2 caracteres " + "consecutifs egaux.");

			boolean valide = false;
			while(valide!=true) {
			System.out.println("Veuillez saisir un mot de passe:");
			String password = sc.nextLine();
			
			// Validate a password
			if (PASSWORD_PATTERN.matcher(password).matches()) {
				valide = true;
				System.out.print("Le mot de passe " + password + " est valide");
			} else {
				valide=false;
				System.out.print("Le mot de passe" + password + " est invalide");
			} }
		} else
			System.out.println("Type incorrect, veuillez retenter.");
		
		//--------------------------------------------
		
	// BESOIN DE BASCULER LES METHODES VERS LE COTE CLIENT ETC.
		// LE MAIN APPELERA ENSUITE CETTE CLASSE POUR LA CREATION USER
		
	}
}