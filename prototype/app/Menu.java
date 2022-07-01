import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class Menu implements Serializable {

	private int loggedUser; // 0 représente Membre, 1 représente Superviseur, 2 représente Administrateur
	private Boolean isMembre;
	private Boolean isSuperviseur;
	private Boolean isAdministrateur;
	private ControleurEquipier controleurEquipier;
	private ControleurActivite controleurActivite;
	private ControleurInteret controleurInteret;
	private ControleurCompte controleurCompte;

	public Menu(ControleurEquipier controleurEquipier, ControleurActivite controleurActivite, ControleurInteret controleurInteret, ControleurCompte controleurCompte) {
		this.controleurEquipier = controleurEquipier;
		this.controleurCompte = controleurCompte;
		this.controleurInteret = controleurInteret;
		this.controleurCompte = controleurCompte;
	}

	public Boolean getMembre() {return isMembre;}
	public Boolean getSuperviseur() {return isSuperviseur;}
	public Boolean getAdministrateur() {return isAdministrateur;}

	private void printMenu() {
		System.out.println("************ Menu Bénévole************\n"+
				"1. Consulter un membre\n"+
				"2. Consulter une activité\n"+
				"3. Chercher une activité\n"+
				"4. Consulter une activité je participe\n"+
				"5. Consulter un intérêt\n"+
				"6. Gérer une activité\n"+
				"7. Gérer la souscription\n"+
				"8. Mon compte\n"+
				"9. Fonction spéciale");
	}

	public int loginMenu(){
		System.out.println("Veuillez entrer votre adresse courriel, ou pressez 0 à quitter.");
		Scanner scan1 = new Scanner(System.in);
		int resultLogin = -1;
		while (scan1.hasNextLine()) {
			String adresseCourriel = scan1.nextLine();
			if (!adresseCourriel.isEmpty()) {
				if (adresseCourriel.equals("0")) {
					System.out.println("Vous êtes déconnecté.");
					System.exit(0);
				}
				int resultEntre = controleurEquipier.chercherEquipier(adresseCourriel);
				if (resultEntre >= 0){
					loggedUser = resultEntre;
					break;
				}else {
					System.out.println("Votre adresse courriel est invalide. Réessayez SVP, ou pressez 0 à quitter.");
				}
			}
		}

		System.out.println("Veuillez entrer votre mot de passe, ou pressez 0 à quitter.");
		Scanner scan2 = new Scanner(System.in);
		while (scan2.hasNextLine()) {
			String motDePasse = scan2.nextLine();
			if (!motDePasse.isEmpty()) {
				if (motDePasse.equals("0")) {
					System.out.println("Vous êtes déconnecté.");
					//serializaiton();
					System.exit(0);
				}
				resultLogin = controleurEquipier.login(motDePasse,loggedUser);
				if (resultLogin >= 0){
					printMenu();
					break;
				} else {
					System.out.println("Votre mot de passe est incorrect. Réessayez SVP, ou pressez 0 à quitter.");
				}
			}
		}
		return resultLogin;
	}

	public void Menu(){
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String order = input.nextLine();
			if (!order.isEmpty()) {
				switch (order) {
					case "1":
						consulterMembre();
						printMenu();
						break;
					case "2":
						consulterActivite();
						printMenu();
						break;
					case "3":
						chercherActivite();
						printMenu();
						break;
					case "4":
						consulterMonActivite();
						printMenu();
						break;
					case "5":
						consulterInteret();
						printMenu();
						break;
					case "6":
						gererActivite();
						printMenu();
						break;
					case "7":
						gererSouscription();
						printMenu();
						break;
					case "8":
						gererCompte();
						printMenu();
						break;
					case "9":
						fonctionSpeciale();
						printMenu();
						break;
					case "0":
						System.out.println("Vous êtes déconnecté.");
						//serializaiton();
						System.exit(0);
						break;
					default:
						System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
						break;
				}
			}
		}
	}

	/**
	 * Consulter le profil complet d’un membre par liste ou chercher un membre par son nom complet
	 */
	public void consulterMembre() {
		printMembreMenu();
		String id = null;
		Scanner scanner = new Scanner(System.in);
		OUT:
		while (scanner.hasNextLine()) {
			String order = scanner.nextLine();
			if (!order.isEmpty()) {
				switch (order) {
					// Consulter le profil complet d’un membre par liste
					case "1":
						controleurEquipier.
						System.out.println("Entrez le numéro du membre vous voulez consulter, ou pressez 0 pour revenir au menu.");

						break;
					// Chercher un membre par son nom complet
					case "2":
						System.out.println("Entrez le non complet de membre:");
						Scanner nomComplet = new Scanner(System.in);
						String codeId = nomComplet.nextLine();
						while (nomComplet.hasNextLine()){
							if (!codeId.isEmpty()) {
								if (codeId.equals("0")){
									printMenu();
									break OUT;
								}
								if (controleurEquipier.chercherEquipier(codeId)){
									//TODO
									break;

									case "0":
										printMenu();
										break;
									default:
										System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 pour revenir au menu.");
										break;
								}
							}
						}
				}

				private void printMembreMenu() {
					System.out.println("1. Afficher la liste\n"+
							"2. Chercher par son nom complet\n"+
							"3. Pressez 0 pour revenir au niveau précédent du menu.");
				}

				public void consulterMembreListe(){
					throw new UnsupportedOperationException();
				}

				public void chercherMembre(){
					throw new UnsupportedOperationException();
				}

				public void consulterActivite() {
					// TODO - implement Menu.consultActivite
					throw new UnsupportedOperationException();
				}

				public void chercherActivite() {
					// TODO - implement Menu.chercherActivite
					throw new UnsupportedOperationException();
				}

				public void consulterMonActivite() {
					// TODO - implement Menu.consulterMonActivite
					throw new UnsupportedOperationException();
				}

				public void consulterInteret() {
					// TODO - implement Menu.consulterMonActivite
					throw new UnsupportedOperationException();
				}

				public void gererActivite() {
					// TODO - implement Menu.gererActivite
					throw new UnsupportedOperationException();
				}

				public void gererSouscription() {
					// TODO - implement Menu.gererSouscription
					throw new UnsupportedOperationException();
				}

				public void gererCompte() {
					// TODO - implement Menu.gererSouscription
					throw new UnsupportedOperationException();
				}

				public void fonctionSpeciale() {
					// TODO - implement Menu.gererSouscription
					throw new UnsupportedOperationException();
				}

			}