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
	private Equipier equipierLog;

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
		System.out.println("************ Menu principal************\n"+
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
				int resultEntre = -1;
				this.equipierLog = controleurEquipier.chercherEquipierParCourriel(adresseCourriel);
				char fir = equipierLog.getId().charAt (0);
				resultEntre = Character.getNumericValue(fir);
				System.out.println(this.equipierLog.getId());
				if (resultEntre == 0){
					loggedUser = 0;
					break;
				}else if (resultEntre == 1){
					loggedUser = 1;
					break;
				}else if (resultEntre == 2) {
					loggedUser = 2;
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


				resultLogin = controleurEquipier.login(motDePasse,this.equipierLog);
				if (resultLogin >= 0){
					printMenu();
					Menu();
				} else {
					System.out.println("Votre mot de passe est incorrect. Réessayez SVP, ou pressez 0 à quitter.");
				}
			}
		}
		return resultLogin;
	}

	private void Menu(){
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String order = input.nextLine();
			if (!order.isEmpty()) {
				switch (order) {
					case "1":
						consulterMembre();

						break;
					case "2":
						//consulterActivite();
						printMenu();
						break;
					case "3":
						//chercherActivite();
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
	private void consulterMembre() {
		printMembreMenu();
		String id = null;
		Scanner scanner = new Scanner(System.in);

		String order = scanner.nextLine();
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
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 pour revenir au menu.");
					break;
			}
		}
	}


	private void printMembreMenu () {
		System.out.println("1. Afficher la liste\n" +
				"2. Chercher par son nom complet\n" +
				"3. Pressez 0 pour revenir au niveau précédent du menu.");
	}

	private void afficherListeMembre() {
		controleurEquipier.afficherListMembre();
		System.out.println("Entrez le numéro du membre vous voulez consulter, ou pressez 0 pour revenir au menu principal.");
		Scanner scannerNum = new Scanner(System.in);
		int orderNum = scannerNum.nextInt();
		if (orderNum == 0) {
			printMenu();
		} else {
			boolean valide = controleurEquipier.afficherProfilComplet(orderNum);
			if (valide == false) {
				System.out.println("invalide");
				afficherListeMembre();
			}
			System.out.println("Pressez 0 pour revenir au menu principal.");
			Scanner scannerQuit = new Scanner(System.in);
			int quit = scannerQuit.nextInt();
			if (quit == 0) {
				printMenu();
			}
		}
	}


	private void chercherNomComplet(){
		System.out.println("Entrez le nom complet de membre:");
		Scanner scannerNom = new Scanner(System.in);
		String nomComplet = scannerNom.nextLine();

		if (!nomComplet.isEmpty()) {
			if (nomComplet.equals("0")) {
				printMenu();
			}else{
				String[] nomliste = nomComplet.split(" ");
				if(nomliste.length != 2) {
					System.out.println("n'existe pas");
				}else {
					String prenom = nomliste[0];
					String nom = nomliste[1];
					boolean existe = controleurEquipier.chercherEquipierParNom(prenom, nom);
					if (existe == false) {
						System.out.println("n'existe pas");
					}
				}
				System.out.println("Pressez 0 pour revenir au menu principal.");
				Scanner scannerQuit = new Scanner(System.in);
				String quit = scannerQuit.nextLine();
				if(quit.equals("0")){
					printMenu();
				}
			}
		}
	}



    private  void printActiviteMenu(){
        System.out.println("1. Article"+"\n"+"2. Projet"+"\n"+"3. Outil"+"\n"+"4. Pressez 0 pour revenir au niveau précédent du menu");
    }

	private void consulterActivite() {
		printActiviteMenu();
		Scanner sc2 = new Scanner(System.in);
		int i2 = sc2.nextInt();
		switch (i2) {
			case 1:
				System.out.println("-----Article-----");
				controleurActivite.afficherListToutArticle();
				System.out.println("\n");
				afficherFicheCompletArticle();
			case 2:
				System.out.println("-----Projet-----");
				controleurActivite.afficherListToutProjet();
				System.out.println("\n");
				afficherFicheCompletProjet();

			case 3:
				System.out.println("-----Outil-----");
				controleurActivite.afficherListToutOutil();
				afficherFicheCompletOutil();
			case 4:
				printMenu();
				Menu();
			default:
				System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
				consulterActivite();
		}
	}

    private void afficherFicheCompletArticle(){
        System.out.println("Entrez le numéro de l'acticle vous voulez consulter, ou pressez 0 pour revenir au menu:");
        Scanner sc2 = new Scanner(System.in);
        int i2 = sc2.nextInt();
        if(i2 == 0){
            printMenu();
            Menu();
        }
        if(controleurActivite.articleSizeValide(i2)){
            controleurActivite.afficheFicheCompletArticle(i2);
        }
        System.out.println("invalide");
        afficherFicheCompletArticle();
    }

    private void afficherFicheCompletOutil(){
        System.out.println("Entrez le numéro de l'outil vous voulez consulter, ou pressez 0 pour revenir au menu:");
        Scanner sc2 = new Scanner(System.in);
        int i2 = sc2.nextInt();
        if(i2 == 0){
            printMenu();
            Menu();
        }
        if(controleurActivite.outilSizeValide(i2)){
            controleurActivite.afficheFicheCompletOutil(i2);
        }
        System.out.println("invalide");
        afficherFicheCompletOutil();
    }
    private void afficherFicheCompletProjet(){
        System.out.println("Entrez le numéro du projet vous voulez consulter, ou pressez 0 pour revenir au menu:");
        Scanner sc2 = new Scanner(System.in);
        int i2 = sc2.nextInt();
        if(i2 == 0){
            printMenu();
            Menu();
        }
        if(controleurActivite.projetSizeValide(i2)){
            controleurActivite.afficheFicheCompletProjet(i2);
        }
        System.out.println("invalide");
        afficherFicheCompletProjet();
    }

    private void chercherActiviteMenu(){
        System.out.println("1. Article"+"\n"+"2. Projet"+"\n"+"4. Pressez 0 pour revenir au niveau précédent du menu");
    }

    private void chercherArticle(){
            System.out.println("Entrez le numéro de l'article vous voulez consulter, ou pressez 0 pour revenir au menu:" + "\n");
            Scanner sc2_1 = new Scanner(System.in);
            String in2_1 = sc2_1.nextLine();
            controleurActivite.chercherArticle(in2_1);
        }
    private void chercherProjet(){
        System.out.println("Entrez responsable pour chercher un projet:"+"\n");
        Scanner sc2_2 = new Scanner(System.in);
        String in2_2 = sc2_2.nextLine();
        controleurActivite.chercherProjet(in2_2);
    }
    private void chercherActivite() {
        chercherActiviteMenu();
        Scanner sc3 = new Scanner(System.in);
        int i3 = sc3.nextInt();
        switch (i3) {
            case 1:
                chercherArticle();
            case 2:
                chercherProjet();
            case 3:
                printMenu();
                Menu();
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

	}