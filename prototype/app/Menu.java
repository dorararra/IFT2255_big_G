import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

	private int loggedUser; // 0 représente Membre, 1 représente Superviseur, 2 représente Administrateur
	private Boolean isMembre;
	private Boolean isSuperviseur;
	private Boolean isAdministrateur;
	private ControleurEquipier controleurEquipier;
	public ControleurActivite controleurActivite;
	private ControleurInteret controleurInteret;
	private ControleurCompte controleurCompte;
	private Equipier equipierLog;

	public Menu(ControleurEquipier controleurEquipier, ControleurActivite controleurActivite, ControleurInteret controleurInteret, ControleurCompte controleurCompte) {
		this.controleurEquipier = controleurEquipier;
		this.controleurCompte = controleurCompte;
		this.controleurInteret = controleurInteret;
		this.controleurCompte = controleurCompte;
		this.controleurActivite = controleurActivite;
	}

	public Boolean getMembre() {
		return isMembre;
	}

	public Boolean getSuperviseur() {
		return isSuperviseur;
	}

	public Boolean getAdministrateur() {
		return isAdministrateur;
	}

	private void printMenu() {
		System.out.println("************ Menu principal************\n" +
				"1. Consulter un membre\n" +
				"2. Consulter une activité\n" +
				"3. Chercher une activité\n" +
				"4. Consulter une activité je participe\n" +
				"5. Consulter un intérêt\n" +
				"6. Gérer une activité\n" +
				"7. Gérer la souscription\n" +
				"8. Mon compte\n" +
				"9. Fonction spéciale\n" +
				"Pressez 0 à quitter.");
	}

	public int loginMenu() {
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
				this.equipierLog = controleurEquipier.chercherEquipierParCourriel(adresseCourriel);
				if (equipierLog == null) {
					System.out.println("Votre adresse courriel est invalide. Réessayez SVP, ou pressez 0 à quitter.");
				} else {
					break;
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
					System.exit(0);
				}
				boolean mdpvalide = controleurEquipier.login(motDePasse, this.equipierLog);
				if (mdpvalide == true) {
					printMenu();
					menu();
				} else {
					System.out.println("Votre mot de passe est incorrect. Réessayez SVP, ou pressez 0 à quitter.");
				}
			}
		}
		return resultLogin;
	}

	public void reussiReturn() {
		System.out.println("Pressez 0 pour revenir au menu principal.");
		Scanner scannerQuit = new Scanner(System.in);
		while (scannerQuit.hasNextLine()) {
			String quit = scannerQuit.nextLine();
			if (quit.equals("0")) {
				printMenu();
				menu();
				break;
			} else {
				System.out.println("Le numéro que vous avez entré est invalide.");
			}
		}
	}

	private void menu() {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String order = input.nextLine();
			if (!order.isEmpty()) {
				switch (order) {
					case "1":
						consulterMembre();
						break;
					case "2":
						consulterActivite();
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

						System.exit(0);
						break;
					default:
						System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
						break;
				}
			}
		}

	}

	private void consulterMembre() {
		printMembreMenu();
		String id = null;
		Scanner scannerConMem = new Scanner(System.in);
		while (scannerConMem.hasNextLine()) {
			String order = scannerConMem.nextLine();
			if (!order.isEmpty()) {
				switch (order) {
					case "1":
						afficherListeMembre();
						break;
					case "2":
						chercherNomComplet();
						break;
					case "0":
						printMenu();
						menu();
						break;
					default:
						System.out.println("Le numéro que vous avez entré est invalide. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
						break;
				}
			}
		}
	}

	private void printMembreMenu() {
		System.out.println("1. Afficher la liste\n" +
				"2. Chercher par son nom complet\n" +
				"Pressez 0 pour revenir au menu principal.");
	}

	private void afficherListeMembre() {
		System.out.println("-----Membre-----");
		controleurEquipier.afficherListMembre();
		System.out.println("Entrez le numéro du membre vous voulez consulter, ou pressez 0 pour revenir au menu principal.");
		Scanner scannerNum = new Scanner(System.in);
		while (scannerNum.hasNextLine()) {
			String orderNum = scannerNum.nextLine();
			if (orderNum.equals("0")) {
				printMenu();
				menu();
				break;
			} else {
				boolean isInt = testInt(orderNum);
				if (isInt == true) {
					int orderselectionne = Integer.parseInt(orderNum);
					boolean valide = controleurEquipier.afficherProfilComplet(orderselectionne);
					if (valide == false) {
						System.out.println("Le numéro que vous avez entré est invalide.\n");
						afficherListeMembre();
						break;
					}
				} else {
					System.out.println("Le numéro que vous avez entré est invalide.\n");
					afficherListeMembre();
				}
				reussiReturn();
			}
		}
	}

	private void chercherNomComplet() {
		System.out.println("Entrez le nom complet de membre:");
		Scanner scannerNom = new Scanner(System.in);
		while (scannerNom.hasNextLine()) {
			String nomComplet = scannerNom.nextLine();

			if (!nomComplet.isEmpty()) {
				if (nomComplet.equals("0")) {
					printMenu();
					menu();
					break;
				} else {
					String[] nomliste = nomComplet.split(" ");
					if (nomliste.length != 2) {
						System.out.println("Le nom que vous avez entré n'existe pas. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
					} else {
						String prenom = nomliste[0];
						String nom = nomliste[1];
						boolean existe = controleurEquipier.chercherEquipierParNom(prenom, nom);
						if (existe == false) {
							System.out.println("Le nom que vous avez entré n'existe pas. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
						}
                        else{
                            reussiReturn();
                        }
					}
                    chercherNomComplet();
						}
					}
				}
			}

	private void printActiviteMenu() {
		System.out.println("1. Article" + "\n" +
				"2. Outil" + "\n" +
				"3. Projet" + "\n" +
				"Pressez 0 pour revenir au menu principal");
	}

	private void consulterActivite() {
		printActiviteMenu();
		Scanner sc2 = new Scanner(System.in);
		while (sc2.hasNextLine()) {
			String i2 = sc2.nextLine();

			switch (i2) {
				case "1":
					System.out.println("-----Article-----");
					afficherFicheComplet(1);
					break;
				case "2":
					System.out.println("-----Outil-----");
					afficherFicheComplet(2);
					break;
				case "3":
					System.out.println("-----Projet-----");
					afficherFicheComplet(3);
					break;
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					consulterActivite();
					break;
			}
		}
	}

	private void afficherFicheComplet(int type) {
		controleurActivite.afficherListToutActivite(type);
		System.out.println("Entrez le numéro vous voulez consulter, ou pressez 0 pour revenir au menu principal.");
		Scanner scannerAFC = new Scanner(System.in);
		while (scannerAFC.hasNextLine()) {
			String i2s = scannerAFC.nextLine();
			if (i2s.equals("0")) {
				printMenu();
				menu();
				break;
			}
			if (testInt(i2s)) {
				int i2 = Integer.parseInt(i2s);
				if (controleurActivite.sizeValide(type, i2)) {
					controleurActivite.afficheFicheComplet(type,i2);
					break;
				} else {
					System.out.println("Le numéro que vous avez entré est invalide. Réessayez SVP, ou pressez 0 à quitter.");
					//afficherFicheCompletArticle();
				}
			}else{
				System.out.println("Le numéro que vous avez entré est invalide.Réessayez SVP, ou pressez 0 à quitter.");
				//afficherFicheCompletArticle();

			}
		}
		reussiReturn();
	}

	private void chercherActiviteMenu() {
		System.out.println("1. Article" + "\n" +
				"2. Projet" + "\n" +
				"Pressez 0 pour revenir au menu principal.");
	}
	
	private void chercherArticle() {
		System.out.println("Entrez le numéro de l'article vous voulez consulter, ou pressez 0 pour revenir au menu principal." + "\n");
		Scanner sc2_1 = new Scanner(System.in);
		String in2_1 = sc2_1.nextLine();
		//controleurActivite.chercherArticle(in2_1);
	}

	private void chercherProjet() {
		System.out.println("Entrez responsable pour chercher un projet:" + "\n");
		Scanner sc2_2 = new Scanner(System.in);
		String in2_2 = sc2_2.nextLine();
		//controleurActivite.chercherProjet(in2_2);
	}

	private void chercherActivite() {
		chercherActiviteMenu();
		Scanner sc3 = new Scanner(System.in);
		String i3 = sc3.nextLine();
		switch (i3) {
			case "1":
				chercherArticle();
				break;
			case "2":
				chercherProjet();
				break;
			case "3":
				printMenu();
				menu();
				break;
			default:
				System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
				chercherActivite();

		}
	}

	private void consulterMonActivite() {
		// TODO - implement Menu.consulterMonActivite
		throw new UnsupportedOperationException();
	}

	private void consulterInteret() {
		// TODO - implement Menu.consulterMonActivite
		throw new UnsupportedOperationException();
	}

	private void gererActivite() {
		// TODO - implement Menu.gererActivite
		throw new UnsupportedOperationException();
	}

	private void gererSouscription() {
		// TODO - implement Menu.gererSouscription
		throw new UnsupportedOperationException();
	}

	private void gererCompte() {
		// TODO - implement Menu.gererSouscription
		throw new UnsupportedOperationException();
	}

	private void fonctionSpeciale() {
		// TODO - implement Menu.gererSouscription
		throw new UnsupportedOperationException();
	}

	public boolean testInt(String s) {
		try{
			Integer.parseInt(s);
			return true;
		}catch (NumberFormatException e){
			return false;

		}

	}
}