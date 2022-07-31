import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Menu {
	private ControleurEquipier controleurEquipier;
	public ControleurActivite controleurActivite;
	private ControleurInteret controleurInteret;
	private ControleurCompte controleurCompte;
	private Compte compteLog;
	private Equipier equipierLog;
	private  ArrayList<Equipier> auteurs = new ArrayList<>();
	private  ArrayList<Equipier> collaborateurs = new ArrayList<>();
	private ArrayList<String> motCle = new ArrayList<>();
	private ArrayList<Interet> interets = new ArrayList<>();
	private Equipier responsableOutil = equipierLog;
	private Equipier responsableArticle;
	private Equipier responsableProjet;

	public Menu(ControleurEquipier controleurEquipier, ControleurActivite controleurActivite, ControleurInteret controleurInteret, ControleurCompte controleurCompte) {
		this.controleurEquipier = controleurEquipier;
		this.controleurInteret = controleurInteret;
		this.controleurCompte = controleurCompte;
		this.controleurActivite = controleurActivite;
	}

	public void printMenu() {
		String existeNewNotification = "";
		if (this.equipierLog.existeNewNotification()){
			existeNewNotification="(new)";
		}
		System.out.println("************ Menu principal************\n" +
				"[1]: Consulter un membre\n" +
				"[2]: Consulter une activité\n" +
				"[3]: Chercher une article\n" +
				"[4]: Consulter un intérêt\n" +
				"[5]: Ajouter une activité\n" +
				"[6]: Modifier une activité\n" +
				"[7]: Gérer la souscription\n" +
				"[8]: Notification "+existeNewNotification+"\n" +
				"[9]: Fonction spéciale\n" +
				"[0]: Quitter");
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
				this.compteLog = controleurCompte.chercherCompteParCourriel(adresseCourriel);
				if (this.compteLog == null) {
					System.out.println("Votre adresse courriel est invalide. Réessayez SVP, ou pressez 0 à quitter.");
					loginMenu();
					break;
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
				boolean mdpvalide = controleurCompte.login(motDePasse, this.compteLog);
				if (mdpvalide && compteLog.getStatus().equals(CompteStatus.valide)) {
					this.equipierLog = compteLog.getMembre();
					this.controleurEquipier.setEquipierLog(equipierLog);
					printMenu();
					menu();
				} else if(mdpvalide && compteLog.getStatus().equals(CompteStatus.enAttente)){
					System.out.println("Veuillez attendre la validation de l'administrateur.");
					System.exit(0);
				}else if(mdpvalide && compteLog.getStatus().equals(CompteStatus.suspendu)){
					System.out.println("Votre compte a été suspendu.");
					System.exit(0);
				}else {
					System.out.println("Votre mot de passe est incorrect. Réessayez SVP, ou pressez 0 à quitter.");
				}
			}
		}
		//  && this.equipierLog.getCompte().equals("valide")
		return resultLogin;
	}

	public void reussiReturn() {
		System.out.println("[0]: Revenir au menu principal");
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

	public void menu() {
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
						chercherArticle();
						break;
					case "4":
						consulterListeInteret();
						printMenu();
						break;
					case "5":
						creerActivite();
						printMenu();
						break;
					case "6":
						modifierActivite();
						printMenu();
						break;
					case "7":
						gererSouscription();
						printMenu();
						break;
					case "8":
						consulterNotification();
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

	public void consulterMembre() {
		int n = 0;
		controleurEquipier.afficherListMembre(n);
		System.out.println("\n" + "[-]: page précédante     " + "[+]: page suivante"+ "\n" +
				"[1]: Filtrer par nom" + "\n" +
				"[2]: Visualiser la fiche d'un membre" + "\n" +
				"Entrez le numéro ou la symbole, ou pressez 0 pour revenir au menu principal.");
		Scanner scannerConMem = new Scanner(System.in);
		while (scannerConMem.hasNextLine()) {
			String order = scannerConMem.nextLine();
			if (!order.isEmpty()) {
				switch (order) {
					case "-":
						if(!controleurEquipier.pagePrecedent()){
                            System.out.println("Il y a juste une page. \nEntrez le numéro ou la symbole, ou pressez 0 pour revenir au menu principal.");
                        }
                        else if(n/30 == 0){
                            System.out.println("C'est la première page.\nEntrez le numéro ou la symbole, ou pressez 0 pour revenir au menu principal.");
                        }
                        else{
                            n-=30;
                            controleurEquipier.afficherListMembre(n);
                        }
                        break;
					case "+":
                        if(!controleurEquipier.pagePrecedent()){
                            System.out.println("Il y a juste une page.\nEntrez le numéro ou la symbole, ou pressez 0 pour revenir au menu principal.");
                            break;
                        }
                        if(n+30<=controleurEquipier.getEquipierSize()){
                            System.out.println("C'est la dernière page.\nEntrez le numéro ou la symbole, ou pressez 0 pour revenir au menu principal.");
                            break;
                        }
                        else{
                            n+=30;
                            controleurEquipier.afficherListMembre(n);
                        }
                        break;
					case "1":
                        chercherNomComplet();
						break;
					case "2":
                        afficherProfilCompletMembre();
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

	public void afficherProfilCompletMembre() {
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
						afficherProfilCompletMembre();
						break;
					}
				} else {
					System.out.println("Le numéro que vous avez entré est invalide.\n");
					afficherProfilCompletMembre();
				}
				reussiReturn();
			}
		}
	}

	public void chercherNomComplet() {
		System.out.println("Entrez le prénom ou nom ou intérêt du membre, ou pressez 0 pour revenir au menu principal:");
		Scanner scannerNom = new Scanner(System.in);
		while (scannerNom.hasNextLine()) {
			String nomComplet = scannerNom.nextLine();
			if (!nomComplet.isEmpty()) {
				if (nomComplet.equals("0")) {
					printMenu();
					menu();
					break;
				} else {
					boolean existe = controleurEquipier.chercherEquipierParNom(nomComplet);
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

	public void printActiviteMenu() {
		System.out.println("[1]: Article" + "\n" +
				"[2]: Outil" + "\n" +
				"[3]: Projet" + "\n" +
				"[0]: Revenir au menu principal");
	}

	public void consulterActivite() {
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


	public void afficherFicheComplet(int type) {
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
					Activite activiteTrouve = controleurActivite.afficheFicheComplet(type,i2);
					gererCetActivite(activiteTrouve);
					break;
				} else {
					System.out.println("Le numéro que vous avez entré est invalide. Réessayez SVP, ou pressez 0 à quitter.");
					//afficherFicheCompletArticle();
				}
			}else{
				System.out.println("Le numéro que vous avez entré est invalide. Réessayez SVP, ou pressez 0 à quitter.");
				//afficherFicheCompletArticle();

			}
		}
		reussiReturn();
	}

	public void chercherArticle() {

		System.out.println("Entrez le titre, auteur ou mot-clés de l'article ou pressez 0 pour revenir au menu principal." + "\n");

		Scanner sc2_1 = new Scanner(System.in);
		String in2_1 = sc2_1.nextLine();
        if(in2_1 .equals("0")){
            printMenu();
            menu();
        }
        ArrayList<Article> articleTrouve = controleurActivite.chercher(in2_1);
        if (articleTrouve.size() != 0) {
            Article articleChoisit = (Article) choisitUnObjet(articleTrouve);
            articleChoisit.afficheFicheComplet();
            gererCetActivite(articleChoisit);
            reussiReturn();
        }else {
            System.out.println("L'information que vous avez entré n'existe pas. Réessayez SVP, ou pressez 0 à quitter.");
            chercherArticle();
        }
	}

	public void gererCetActivite(Activite activite){
		if(compteLog.getRole().equals(Role.administrateur)){
			System.out.println("[1]: Souscrire" + "\n" +
					"[2]: Supprimer" + "\n" +
					"[0]: Revenir au menu principal");
			Scanner sc3 = new Scanner(System.in);
			while (sc3.hasNextLine()) {
				String i3 = sc3.nextLine();
				switch (i3) {
					case "1":
						if(!this.equipierLog.getInscrireActivite_().contains(activite)) {
							this.equipierLog.inscrireActivite(activite);
							activite.addMembreSouscrit(equipierLog);
							System.out.println("Vous avez suivi cet activité.");
						}else{
							System.out.println("Cet activité est déjà dans votre liste.");
						}
						reussiReturn();
						break;
					case "2":
						controleurActivite.supprimerActivite(activite);
						System.out.println("Vous avez supprimé cet activité.");
						reussiReturn();
						break;
					case "0":
						printMenu();
						menu();
						break;
					default:
						System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
						gererCetActivite(activite);
						break;
				}
			}
		}else {
			System.out.println("[1]: Souscrire" + "\n" +
					"[0]: Revenir au menu principal");
			Scanner sc3 = new Scanner(System.in);
			while (sc3.hasNextLine()) {
				String i3 = sc3.nextLine();
				switch (i3) {
					case "1":
						if(!this.equipierLog.getInscrireActivite_().contains(activite)) {
							this.equipierLog.inscrireActivite(activite);
							activite.addMembreSouscrit(equipierLog);
							System.out.println("Vous avez suivi cet activité.");
						}else{
							System.out.println("Cet activité est déjà dansvotre liste.");
						}
						reussiReturn();
						break;
					case "0":
						printMenu();
						menu();
						break;
					default:
						System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
						gererCetActivite(activite);
						break;
				}
			}
		}
	}

    public void notOpen(){
        System.out.println("À bientôt,pressez 0 pour revenir au menu principal");
        Scanner sc3 = new Scanner(System.in);
        String i3 = sc3.nextLine();
        if(i3.equals("0")){
        printMenu();
        menu();
    }
        else{
            notOpen();
        }
        }



	public void consulterListeInteret() {
		controleurInteret.afficherListeInteret();
		System.out.println("Entrez le numéro vous voulez consulter, ou pressez 0 pour revenir au menu principal.");
		Scanner sc3 = new Scanner(System.in);
		while (sc3.hasNextLine()) {
			String i3 = sc3.nextLine();
			if (i3.equals("0")) {
				printMenu();
				menu();
			} else {
				boolean isInt = testInt(i3);
				if (isInt == true) {
					int orderselectionne = Integer.parseInt(i3);
					Interet interetCherche = controleurInteret.getInteretCherche(orderselectionne);
					if (interetCherche == null) {
						System.out.println("Le numéro que vous avez entré est invalide.\n");
						consulterListeInteret();
						break;
					}else {
						consulterInteret(interetCherche);
						break;
					}
				} else {
					System.out.println("Le numéro que vous avez entré est invalide.\n");
					consulterListeInteret();
					break;
				}
			}
		}
	}

	public void consulterInteret(Interet interet){
		System.out.println("[1]: Visualiser les membres associés"+ "\n" +
				"[2]: Visualiser les activités associés" + "\n" +
				"[3]: Souscrire cet intérêt" + "\n" +
				"[0]: Revenir au menu principal");
		Scanner sc4 = new Scanner(System.in);
		while (sc4.hasNextLine()) {
			String i4 = sc4.nextLine();
			switch (i4) {
				case "1":
					System.out.println("-----Membres Associés-----");
					interet.afficherMembreAssocieInteret();
					System.out.println("\n");
					reussiReturn();
					break;
				case "2":
					System.out.println("-----Activités Associés-----");
					interet.afficherActiviteAssocieInteret();
					reussiReturn();
					break;
				case "3":
					souscrireInteret(interet);
					reussiReturn();
					break;
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					consulterInteret(interet);
					break;
			}
		}
		sc4.close();
	}

	public void creerActivite() {
		System.out.println("[1]: Article" + "\n" +
				"[2]: Outil" + "\n" +
				"[3]: Projet" + "\n" +
				"Entrez le type d'activité vous voulez créer, ou pressez 0 pour revenir au menu principal.");
		Scanner sc5 = new Scanner(System.in);
		while (sc5.hasNextLine()) {
			String i5 = sc5.nextLine();
			switch (i5) {
				case "1":
					creerArticle();
					break;
				case "2":
					creerOutil();
				case "3":
					creerProjet();
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					creerActivite();
					break;
			}
		}
	}

	public void creerArticle() {
		String titre = addTitre();
		String resume = addResume();
		String lienPublication = addLienPublication();
		String datePublication = "null";
		String id = "A1";
		int n = 0;
		controleurEquipier.afficherListMembre(n);
		responsableArticle = addResponsableArticle();
		auteurs = addAuteur();
		controleurEquipier.afficherListMembre(n);
		collaborateurs = addCollaborateur();
		motCle = addMotcle();
		controleurInteret.afficherListeInteret();
		interets = addInteret();
		Article newArticle = new Article(id, titre, resume, lienPublication, datePublication, articleStatus.brouillon, responsableArticle, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		for (Equipier auteur : auteurs) {
			newArticle.addAuteur(auteur);
		}
		for (Equipier collaborateur : collaborateurs) {
			newArticle.addCollaborateurs(collaborateur);
		}
		for (String motCle : motCle) {
			newArticle.addMotcles(motCle);
		}
		for (Interet interet : interets) {
			newArticle.addInteretsLie(interet);
		}
		controleurActivite.ajouteArticle(newArticle);

		newArticle.setDatePublication(getDate());
		auteurs.clear();
		collaborateurs.clear();
		motCle.clear();
		interets.clear();
		responsableArticle = null;
		sentNotification(1,newArticle);
		System.out.println("Vous avez réussi créer un article! ");
		reussiReturn();
	}
	public String addLienPublication() {
		System.out.println("Entrez le lien article, ou pressez 0 pour revenir au menu principal.");
		Scanner sc53 = new Scanner(System.in);
		String i53 = sc53.nextLine();
		if (i53.equals("0")) {
			printMenu();
			menu();
		}
		return i53;
	}


	public String addTitre() {
		System.out.println("Entrez le titre/nom, ou pressez 0 pour revenir au menu principal.");
		Scanner sc51 = new Scanner(System.in);
		String i51 = sc51.nextLine();
		if (i51.equals("0")) {
			printMenu();
			menu();
		} else if (i51.replace(" ", "").length() == 0) {
			System.out.println("Vous avez rien entrez.");
			return addTitre();
		} else if (i51.length() > 50) {
			System.out.println("Le length doit être moins de 50 caractère");
			return addTitre();
		}
		return i51;

	}

	public String addResume() {
		System.out.println("Entrez le résumé/description, ou pressez 0 pour revenir au menu principal.");
		Scanner sc52 = new Scanner(System.in);
		String i52 = sc52.nextLine();
		if (i52.equals("0")) {
			printMenu();
			menu();
		}
		if (i52.length() == 0) {
			addResume();
		}
		if (i52.length() > 500) {
			System.out.println("Le length doit être moins de 500 caractère");
			addResume();
		}

		return i52;

	}

	public ArrayList<Equipier> addAuteur() {
		System.out.println("Entrez le numéro de l'auteur vous voulez ajouter ou pressez 'c' pour continuer.");
		if(!auteurs.contains(equipierLog)) {
			auteurs.add(equipierLog);
		}
		Scanner sc56 = new Scanner(System.in);
		String i56 = sc56.nextLine();
		if (Objects.equals(i56, "0")) {
			printMenu();
			menu();
		} else if (i56.equals("c")) {
			return auteurs;
		} else if (testInt(i56)) {
			int i5 = Integer.parseInt(i56);
			if ((0 < i5) && (i5 <= controleurEquipier.getEquipierSize())) {
				if ((!auteurs.contains(controleurEquipier.getEquipierTrouve(i5))) || !auteurs.contains(responsableArticle)) {
					auteurs.add(controleurEquipier.getEquipierTrouve(i5));
					addAuteur();
				} else {
					System.out.println("Le personne que vous avez choisi déjà ajouter, réessayer SVP: ");
					addAuteur();
				}
			} else {
				System.out.println("Le numéro que vous entrez est invalide");
				addAuteur();
			}
		} else {
			System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
			addAuteur();
		}
		return auteurs;
	}

	public Equipier addResponsableArticle() {
		System.out.println("Choisir le responsable:");
		Scanner sc56 = new Scanner(System.in);
		String i56 = sc56.nextLine();
		if (Objects.equals(i56, "0")) {
			printMenu();
			menu();
		} else if (testInt(i56)) {
			int i5 = Integer.parseInt(i56);
			if ((0<i5)&&(i5 <= controleurEquipier.getEquipierSize())) {
				responsableArticle = controleurEquipier.getEquipierTrouve(i5);
				return responsableArticle;
			} else {
				System.out.println("Le numéro que vous entrez est invalide");
				addResponsableArticle();
			}
		} else {
			System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
			addResponsableArticle();
		}
		return responsableArticle;
	}

	public ArrayList<Equipier> addCollaborateur() {
		System.out.println("Entrez le numéro du collaborateur vous voulez ajouter ou pressez 'c' pour continuer:  ");
		Scanner sc57 = new Scanner(System.in);
		String i57 = sc57.nextLine();
		if (i57.equals("0")) {
			printMenu();
			menu();
		} else if (i57.equals("c")) {
			return collaborateurs;

		} else if (testInt(i57)) {
			int i571 = Integer.parseInt(i57);
			if ((0 < i571) && (i571 <= controleurEquipier.getEquipierSize())) {
				if ((!collaborateurs.contains(controleurEquipier.getEquipierTrouve(i571)) && (!auteurs.contains(controleurEquipier.getEquipierTrouve(i571)))
						&& ((responsableOutil == null) || (!responsableOutil.equals(controleurEquipier.getEquipierTrouve(i571)))))) {
					collaborateurs.add(controleurEquipier.getEquipierTrouve(i571));
					addCollaborateur();
				} else {
					System.out.println("Le personne que vous avez choisi déjà ajouter, réessayer SVP: ");
					addCollaborateur();
				}
			} else {
				System.out.println("Le numéro que vous entrez est invalide");
				addCollaborateur();
			}

		} else {
			System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
			addCollaborateur();
		}
		return collaborateurs;
	}

	public ArrayList<String> addMotcle() {
		System.out.println("Entrez le mot-clé vous voulez ajouter ou pressez 'c' pour continuer.");
		Scanner sc582 = new Scanner(System.in);
		String i582 = sc582.nextLine();
		if (i582.equals("0")) {
			printMenu();
			menu();
		} else if (Objects.equals(i582, "c")) {
			return motCle;
		}
		int length = i582.length();
		for (int i = 0; i < motCle.size(); i++) {
			length += motCle.get(i).length();
		}
		if (length > 40) {
			System.out.println("le length du mots-clé doit être moins de 40 caractères");
			addMotcle();
		} else {
			motCle.add(i582.replace(" ", ""));
			addMotcle();
		}
		return motCle;
	}

	public ArrayList<Interet> addInteret() {
		if (interets.size() == 0) {
			System.out.println("Entrez le numéro du l'intérêt lié ou pressez '0' pour revenir au menu principal.");
		} else if (interets.size() >= 5) {
			int t = 0;
			return interets;

		} else {
			System.out.println("Entrez le numéro du l'intérêt lié ou pressez 'c' pour continuer ou pressez '0' pour revenir au menu principal.");
		}
		Scanner sc59 = new Scanner(System.in);
		String i59 = sc59.nextLine();
		if (i59.equals("0")) {
			printMenu();
			menu();
		} else if ((Objects.equals(i59, "c")) && (interets.size() != 0)) {
			int h = 1;
		} else if ((Objects.equals(i59, "c")) && (interets.size() == 0)) {
			System.out.println("Vous devez choisir au moins un interet.");
			addInteret();
		} else {
			boolean isInt = testInt(i59);
			if (isInt == true) {
				int orderselectionne = Integer.parseInt(i59);
				Interet interetCherche = controleurInteret.getInteretCherche(orderselectionne);
				if (interetCherche == null) {
					System.out.println("Le numéro que vous avez entré est invalide.\n");
					addInteret();
				} else {
					if (!interets.contains(controleurInteret.getInteretCherche(Integer.parseInt(i59)))) {
						interets.add(controleurInteret.getInteretCherche(Integer.parseInt(i59)));
						addInteret();
					} else {
						System.out.println("Vous avez déjà ajouter cet intérêt");
						addInteret();
					}
				}
			} else {
				System.out.println("Ce que vous avez entré est invalide.\n");
				addInteret();
			}
		}
		return interets;
	}


	public void creerOutil() {
		String nom = addTitre();
		String description = addResume();
		String version = addVersion();
		String lienRepertoire = addLienRepertoire();
		int n = 0;
		controleurEquipier.afficherListMembre(n);
		responsableOutil = addResponsableOutil();
		controleurEquipier.afficherListMembre(n);
		collaborateurs = addCollaborateur();
		motCle = addMotcle();
		controleurInteret.afficherListeInteret();
		interets = addInteret();
		String id = "A2";
		Outil newOutil = new Outil(id, nom, description, version, lienRepertoire, responsableOutil, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		for (Equipier collaborateur : collaborateurs) {
			newOutil.addCollaborateur(collaborateur);
		}
		for (String motcle : motCle) {
			newOutil.addMotcles(motcle);
		}
		for (Interet interet : interets) {
			newOutil.addInteretLie(interet);
		}
		controleurActivite.ajouteOutil(newOutil);
		collaborateurs.clear();
		motCle.clear();
		interets.clear();
		sentNotification(1,newOutil);
		System.out.println("Vous avez réussi créer un outil! ");
		reussiReturn();
	}

	public String addLienRepertoire() {
		System.out.println("Entrez le lien du repertoire, ou pressez 0 pour revenir au menu principal.");
		Scanner sc54 = new Scanner(System.in);
		String i54 = sc54.nextLine();
		String lienRepertoire = i54;
		return i54;
	}

	public String addVersion() {
		System.out.println("Entrez la version, ou pressez 0 pour revenir au menu principal.");
		Scanner sc53 = new Scanner(System.in);
		String i53 = sc53.nextLine();
		String version = i53;
		return version;
	}

	public Equipier addResponsableOutil() {
		System.out.println("Choisir le responsable:");
		Scanner sc56 = new Scanner(System.in);
		String i56 = sc56.nextLine();
		if (Objects.equals(i56, "0")) {
			printMenu();
			menu();
		} else if (testInt(i56)) {
			int i5 = Integer.parseInt(i56);
			if ((0<i5)&&(i5 <= controleurEquipier.getEquipierSize())) {
				this.responsableOutil = controleurEquipier.getEquipierTrouve(i5);
				return this.responsableOutil;
			} else {
				System.out.println("Le numéro que vous entrez est invalide");
				return addResponsableOutil();
			}
		} else {
			System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
			return addResponsableOutil();
		}
		return this.responsableOutil;
	}

	public String addDateDebut() {
		System.out.println("Entrez la date de début(format YYYY-MM-DD) ou pressez 0 pour revenir au menu principal: ");
		Scanner sc53 = new Scanner(System.in);
		String i53 = sc53.nextLine();
		if (i53.equals("0")) {
			printMenu();
			menu();
		}
		if (i53.length() == 0) {
			addDateDebut();

		}
		return i53;
	}

	public String addDateFin() {
		System.out.println("Entrez le date de fin, ou pressez 0 pour revenir au menu principal.");
		Scanner sc54 = new Scanner(System.in);
		String i54 = sc54.nextLine();
		if (i54.equals("0")) {
			printMenu();
			menu();
		}
		if (i54.length() == 0) {
			addDateFin();

		}
		return i54;
	}

	public Equipier addResponsableProjet() {
		System.out.println("Choisir le responsable:");
		Scanner sc56 = new Scanner(System.in);
		String i56 = sc56.nextLine();
		if (Objects.equals(i56, "0")) {
			printMenu();
			menu();
		} else if (testInt(i56)) {
			int i5 = Integer.parseInt(i56);
			if ((0 < i5) && (i5 <= controleurEquipier.getEquipierSize())) {
				if (controleurEquipier.getEquipierTrouve(i5).getTitre() != Condition.professeur) {
					System.out.println("Responsable du projet doit être un professeur.");
					addResponsableProjet();
				} else {
					responsableProjet = controleurEquipier.getEquipierTrouve(i5);
					return responsableProjet;
				}
			} else {
				System.out.println("Le numéro que vous entrez est invalide");
				addResponsableProjet();
			}
		} else {
			System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
			addResponsableProjet();
		}
		return responsableProjet;

	}


	public void creerProjet() {
		String titre = addTitre();
		String description = addResume();
		String dateDebut = addDateDebut();
		String dateFin = "None";
		int n = 0;
		controleurEquipier.afficherListMembre(n);
		responsableProjet = addResponsableProjet();
		controleurInteret.afficherListeInteret();
		interets = addInteret();
		String id = "A3";
		Projet newProjet = new Projet(id, titre, description, dateDebut, dateFin, responsableProjet, new ArrayList<>());
		for (int i = 0; i < interets.size(); i++) {
			newProjet.addInteretsLie(interets.get(i));
		}
		controleurActivite.ajouteProjet(newProjet);
		interets.clear();
		System.out.println("Vous avez réussi créer un projet! ");
		reussiReturn();
	}

	public void modifierActivite() {
		System.out.println("[1]: Article" + "\n" +
				"[2]: Outil" + "\n" +
				"[3]: Projet" + "\n" +
				"Entrez le type d'activité vous voulez modifier, ou pressez 0 pour revenir au menu principal.");
		Scanner sc5 = new Scanner(System.in);
		while (sc5.hasNextLine()) {
			String i5 = sc5.nextLine();
			switch (i5) {
				case "1":
					modifierArticle();
					break;
				case "2":
					modifierOutil();
				case "3":
					modifierProjet();
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					creerActivite();
					break;
			}
		}
	}
	public void modifierArticle() {
		controleurActivite.afficherListToutActivite(1);
		Scanner scannerArticle = new Scanner(System.in);
		while (scannerArticle.hasNextLine()) {
			String iArticle = scannerArticle.nextLine();
			if (iArticle.equals("0")) {
				printMenu();
				menu();
				break;
			}
			if (testInt(iArticle)) {
				int i2 = Integer.parseInt(iArticle);
				if (controleurActivite.sizeValide(1, i2)) {
					if(controleurActivite.chercherParNumArticle(i2).getResponsable()==(equipierLog.getPrenom()+" "+equipierLog.getNomDeFamille())){
						System.out.println(
								"[1]: Changer le titre\n" +
										"[2]: Changer le résumé\n" +
										"[3]: Changer le lien article\n" +
										"[4]: Changer la date de la publication\n" +
										"[5]: Changer les auteurs\n" +
										"[6]: Changer le responsable\n" +
										"[7]: Changer les collaborateurs\n" +
										"[8]: Changer les mot-clés\n" +
										"[9]: Changer les intérêts\n" +
										"[0]: Quitter");
						Scanner scchange = new Scanner(System.in);
						while (scchange.hasNextLine()) {
							String iChange = scchange.nextLine();
							switch (iChange) {
								case "1":
									controleurActivite.chercherParNumArticle(i2).setTitre(addTitre());
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "2":
									controleurActivite.chercherParNumArticle(i2).setResume(addResume());
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "3":
									controleurActivite.chercherParNumArticle(i2).setLienPublication(addLienPublication());
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "4":
									controleurActivite.chercherParNumArticle(i2).setDatePublication(addDateFin());
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "5":
									modifierAuteur(controleurActivite.chercherParNumArticle(i2));
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "6":
									controleurEquipier.afficherListMembre(0);
									controleurActivite.chercherParNumArticle(i2).setResponsable(addResponsableArticle());
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "7":
									modifierCollaborateur(controleurActivite.chercherParNumArticle(i2));
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "8":
									modifierMotcle(controleurActivite.chercherParNumArticle(i2));
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "9":
									modifierInteret(controleurActivite.chercherParNumArticle(i2));
									sentNotification(2,controleurActivite.chercherParNumArticle(i2));
									reussiReturn();
									break;
								case "0":
									printMenu();
									menu();
									break;
								default:
									System.out.println("Aucun résultat.");
									modifierOutil();
									break;


							}
						}
					}
					else{
						System.out.println("Vous n'êtes pas responsable de cet article");
						modifierArticle();
					}


					;
					break;
				} else {
					System.out.println("Le numéro que vous avez entré est invalide. Réessayez SVP, ou pressez 0 à quitter.");

				}
			} else {
				System.out.println("Le numéro que vous avez entré est invalide. Réessayez SVP, ou pressez 0 à quitter.");

			}
		}
		reussiReturn();
	}

	public void modifierAuteur(Article article){
		System.out.println("[1]: Add un auteur" + "\n" +
				"[2]: supprimer un auteur" + "\n" +
				"Entrez le numéro vous voulez choisir, ou pressez 0 pour revenir au menu principal.");


	}

	public void modifierOutil() {
		controleurActivite.afficherListToutActivite(2);
		Scanner scannerOutil = new Scanner(System.in);
		while (scannerOutil.hasNextLine()) {
			String iOutil = scannerOutil.nextLine();
			if (iOutil.equals("0")) {
				printMenu();
				menu();
				break;
			}
			else if (testInt(iOutil)) {
				int i222 = Integer.parseInt(iOutil);
				if (controleurActivite.sizeValide(2, i222)) {
					if (Objects.equals(controleurActivite.chercherParNumOutil(i222).getResponsable(), equipierLog.getPrenom() + " " + equipierLog.getNomDeFamille())) {
						System.out.println(
								"[1]: Changer le nom\n" +
										"[2]: Changer la description\n" +
										"[3]: Changer la version\n" +
										"[4]: Changer le lien du repertoire\n" +
										"[5]: Changer le  responsable\n" +
										"[6]: Changer les collaborateurs\n" +
										"[7]: Changer les mot-clés\n" +
										"[8]: Changer les intérêts\n" +
										"[0]: Quitter\n"+
										"Entrez votre choix:"
						);
						Scanner scchangeOutil = new Scanner(System.in);
						while (scchangeOutil.hasNextLine()) {
							String iChange = scchangeOutil.nextLine();
							switch (iChange) {
								case "0":
									printMenu();
									menu();
									break;
								case "1":
									controleurActivite.chercherParNumOutil(i222).setTitre(addTitre());
									sentNotification(2,controleurActivite.chercherParNumOutil(i222));
									reussiReturn();
									break;
								case "2":
									controleurActivite.chercherParNumOutil(i222).setDescription(addResume());
									sentNotification(2,controleurActivite.chercherParNumOutil(i222));
									reussiReturn();
									break;
								case "3":
									controleurActivite.chercherParNumOutil(i222).setVersion(addVersion());
									sentNotification(2,controleurActivite.chercherParNumOutil(i222));
									reussiReturn();
									break;
								case "4":
									controleurActivite.chercherParNumOutil(i222).setLienRepertoire(addLienRepertoire());
									sentNotification(2,controleurActivite.chercherParNumOutil(i222));
									reussiReturn();
									break;
								case "5":
									controleurEquipier.afficherListMembre(0);
									controleurActivite.chercherParNumOutil(i222).setResponsable(addResponsableOutil());
									sentNotification(2,controleurActivite.chercherParNumOutil(i222));
									reussiReturn();
									break;
								case "6":
									modifierCollaborateur(controleurActivite.chercherParNumOutil(i222));
									sentNotification(2,controleurActivite.chercherParNumOutil(i222));
									reussiReturn();
									break;
								case "7":
									modifierMotcle(controleurActivite.chercherParNumOutil(i222));
									sentNotification(2,controleurActivite.chercherParNumOutil(i222));
									reussiReturn();
									break;
								case "8":
									modifierInteret(controleurActivite.chercherParNumOutil(i222));
									sentNotification(2,controleurActivite.chercherParNumOutil(i222));
									reussiReturn();
									break;

								default:
									System.out.println("Aucun résultat.");
									modifierOutil();
									break;

							}
						}
					}
					else {
						System.out.println("Vous n'êtes pas responsable de cet outil.");
						modifierOutil();
					}
				}
			}
		}
	}
	public void modifierMotcle(Activite activite){
		motCle = activite.getListMotcle();
		System.out.println("[1]: Add un mot-clé" + "\n" +
				"[2]: supprimer un mot-clé" + "\n" +
				"Entrez le numéro vous voulez choisir, ou pressez 0 pour revenir au menu principal.");
		Scanner modifierMotcle = new Scanner(System.in);
		while (modifierMotcle.hasNextLine()) {
			String mMot = modifierMotcle.nextLine();
			switch (mMot){
				case "1":
					ArrayList<String> motcleAdd = addMotcle();
					for(int i = 0;i<motcleAdd.size();i++){
						activite.addMotcles(motcleAdd.get(i));
					}
					System.out.println("Déjà ajouté.");
					reussiReturn();
					break;
				case "2":
					System.out.println(activite.getMotcle());
					System.out.println("Entrez le numéro du mot-clé vous voulez supprimer ou pressez '0' pour revenir au menu principale:");
					Scanner sc67 = new Scanner(System.in);
					String i67 = sc67.nextLine();
					if (Objects.equals(i67, "0")) {
						printMenu();
						menu();
					}
					else if(testInt(i67)){
						int i6 = Integer.parseInt(i67);
						if((0<i6)&&(i6<=activite.getListMotcle().size())){
							activite.supprimerMotcle(i6);
							System.out.println("Déjà supprimer.");
							reussiReturn();
						}
						else{
							System.out.println("Le numéro que vous entrez est invalide");
							modifierMotcle(activite);

						}
					}
					else{
						System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
						modifierMotcle(activite);

					}
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					modifierMotcle(activite);
					break;


			}
		}




	}
	public void modifierCollaborateur(Activite activite) {
		collaborateurs = activite.getListCollaborateurs();
		System.out.println("[1]: Add un collaborateur" + "\n" +
				"[2]: supprimer un collaborateur" + "\n" +
				"Entrez le numéro vous voulez choisir, ou pressez 0 pour revenir au menu principal.");
		Scanner modifierCollaborateur = new Scanner(System.in);
		while (modifierCollaborateur.hasNextLine()) {
			String mColla = modifierCollaborateur.nextLine();
			switch (mColla) {
				case "1":
					controleurEquipier.afficherListMembre(0);
					ArrayList<Equipier> collaborateurAdd = addCollaborateur();
					for (int i = 0; i < collaborateurAdd.size(); i++) {
						activite.addCollaborateurs(collaborateurAdd.get(i));

					}
					System.out.println("Déjà ajouté.");
					reussiReturn();
					break;
				case "2":
					activite.getCollaborateurs();
					System.out.println("Entrez le numéro du collaborateur vous voulez supprimer ou pressez '0' pour revenir au menu principale:");
					Scanner sc66 = new Scanner(System.in);
					String i66 = sc66.nextLine();
					if (Objects.equals(i66, "0")) {
						printMenu();
						menu();
					} else if (testInt(i66)) {
						int i6 = Integer.parseInt(i66);
						if ((0 < i6) && (i6 <= activite.getListCollaborateurs().size())) {
							activite.supprimerCollaborateur(i6);
							System.out.println("Déjà supprimer.");
							reussiReturn();
						} else {
							System.out.println("Le numéro que vous entrez est invalide");
							modifierCollaborateur(activite);

						}
					} else {
						System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
						modifierCollaborateur(activite);

					}
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					modifierCollaborateur(activite);
					break;


			}
		}
	}
	public void modifierInteret(Activite activite){
		interets = activite.getListInteretsLie();
		System.out.println("[1]: Add un intérêt" + "\n" +
				"[2]: supprimer un intérêt" + "\n" +
				"Entrez le numéro vous voulez choisir, ou pressez 0 pour revenir au menu principal.");
		Scanner modifierInteretLie = new Scanner(System.in);
		while (modifierInteretLie.hasNextLine()) {
			String mInteret = modifierInteretLie.nextLine();
			switch (mInteret){
				case "1":
					controleurInteret.afficherListeInteret();
					ArrayList<Interet> interetAdd = addInteret();
					for(int i = 0;i<interetAdd.size();i++){
						activite.addInteretsLie(interetAdd.get(i));
					}
					System.out.println("Déjà ajouté.");
					reussiReturn();
					break;
				case "2":
					activite.getInteretsLie();
					System.out.println("Entrez le numéro de l'intérêt vous voulez supprimer ou pressez '0' pour revenir au menu principale:");
					Scanner sc66 = new Scanner(System.in);
					String i66 = sc66.nextLine();
					if (Objects.equals(i66, "0")) {
						printMenu();
						menu();
					}
					else if(testInt(i66)){
						int i6 = Integer.parseInt(i66);
						if((0<i6)&&(i6<=activite.getListInteretsLie().size())){
							activite.supprimerInteretLIe(i6);
							System.out.println("Déjà supprimer.");
							reussiReturn();
						}
						else{
							System.out.println("Le numéro que vous entrez est invalide");
							modifierInteret(activite);

						}
					}
					else{
						System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 pour revenir au menu principal.");
						modifierInteret(activite);

					}
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					modifierInteret(activite);
					break;


			}
		}

	}
	public void modifierProjet(){
		controleurActivite.afficherListToutActivite(3);
		Scanner scannerProjet = new Scanner(System.in);
		while (scannerProjet.hasNextLine()) {
			String iProjet = scannerProjet.nextLine();
			if (iProjet.equals("0")) {
				printMenu();
				menu();
				break;
			}
			if (testInt(iProjet)) {
				int i2 = Integer.parseInt(iProjet);
				if (controleurActivite.sizeValide(3, i2)) {
					System.out.println(controleurActivite.chercherParNumProjet(i2).getResponsable());
					System.out.println(equipierLog.getPrenom() + " " + equipierLog.getNomDeFamille());
					if (Objects.equals(controleurActivite.chercherParNumProjet(i2).getResponsable(), equipierLog.getPrenom() + " " + equipierLog.getNomDeFamille())) {
						System.out.println(
								"[1]: Changer le titre\n" +
										"[2]: Changer la description\n" +
										"[3]: Changer la date de début\n" +
										"[4]: Changer la date de fin\n" +
										"[5]: Changer le responsable\n" +
										"[6]: Changer les intérêts\n" +
										"[0]: Quitter\n"+"Entrez le numéro vous voulez choisir:");
						Scanner scchange = new Scanner(System.in);
						while (scchange.hasNextLine()) {
							String iChange = scchange.nextLine();
							switch (iChange) {
								case "1":
									controleurActivite.chercherParNumProjet(i2).setTitre(addTitre());
									sentNotification(2,controleurActivite.chercherParNumProjet(i2));
									reussiReturn();
									break;
								case "2":
									controleurActivite.chercherParNumProjet(i2).setDescription(addResume());
									sentNotification(2,controleurActivite.chercherParNumProjet(i2));
									reussiReturn();
									break;
								case "3":
									controleurActivite.chercherParNumProjet(i2).setDateDeDebut(addDateDebut());
									sentNotification(2,controleurActivite.chercherParNumProjet(i2));
									reussiReturn();
									break;
								case "4":
									controleurActivite.chercherParNumProjet(i2).setDateDeFin(addDateFin());
									sentNotification(2,controleurActivite.chercherParNumProjet(i2));
									break;
								case "5":
									controleurEquipier.afficherListMembre(0);
									controleurActivite.chercherParNumProjet(i2).setResponsable(addResponsableProjet());
									sentNotification(2,controleurActivite.chercherParNumProjet(i2));
									reussiReturn();
									break;
								case "6":
									modifierInteret(controleurActivite.chercherParNumProjet(i2));
									sentNotification(2,controleurActivite.chercherParNumProjet(i2));
									reussiReturn();
									break;
								case "0":
									printMenu();
									menu();
									break;
								default:
									System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
									modifierOutil();
									break;

							}

						}
					} else {
						System.out.println("Vous n'êtes pas responsable de ce projet");
						modifierProjet();

					}
				}
			}
		}
	}


	public void souscrireInteret(Interet interet){
		if(!this.equipierLog.getInscrireInteret_().contains(interet)) {
			this.equipierLog.inscrireInteret(interet);
			interet.setMembreSouscrit(equipierLog);
			for (Activite activite : interet.getActiviteSouscrit()) {
				this.equipierLog.inscrireActivite(activite);
			}
			System.out.println("Vous avez suivi cet intérêt.");
		}else{
			System.out.println("Cet intérêt est déjà dans votre liste.");
		}

	}

	public void gererSouscription() {
		System.out.println("[1]: gérer des intérêts suivi"+ "\n" +
				"[2]: gérer des activité suivi" + "\n" +
				"[0]: Revenir au menu principal");
		Scanner sc6 = new Scanner(System.in);
		while (sc6.hasNextLine()) {
			String i6 = sc6.nextLine();
			switch (i6) {
				case "1":
					System.out.println("-----Intérêts suivis-----");
					this.controleurEquipier.afficherInscrireInteret();
					ArrayList<Interet> inscrireInteret = equipierLog.getInscrireInteret_();
					Interet interetAmodifier =(Interet) choisitUnObjet(inscrireInteret);
					gererInteretSuivi(interetAmodifier);
					reussiReturn();
					break;
				case "2":
					System.out.println("-----Activité suivis-----");
					this.controleurEquipier.afficherInscrireActivite();
					ArrayList<Activite> inscrireActivite = equipierLog.getInscrireActivite_();
					Activite activiteAmodifier =(Activite) choisitUnObjet(inscrireActivite);
					gererActiviteSuivi(activiteAmodifier);
					reussiReturn();
					break;
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					gererSouscription();
					break;
			}
		}
		sc6.close();
	}



	public void gererInteretSuivi(Interet interet){
		System.out.println("[1]: consulter cet intérêt"+ "\n" +
				"[2]: annuler la souscription" + "\n" +
				"Entrez le numéro vous voulez creer, ou pressez 0 pour revenir au menu principal.");
		Scanner sc7 = new Scanner(System.in);
		while (sc7.hasNextLine()) {
			String i7 = sc7.nextLine();
			switch (i7) {
				case "1":
					consulterInteret(interet);
					break;
				case "2":
					equipierLog.modifierListeInteret(interet);
					interet.supprimerMembreSouscrit(equipierLog);
					System.out.println("Vous avez annuler la souscription.");
					reussiReturn();
					break;
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					gererSouscription();
					break;
			}
		}
	}

	public void gererActiviteSuivi(Activite activite){
		System.out.println("[1]: consulter cet activité"+ "\n" +
				"[2]: annuler la souscription" + "\n" +
				"Entrez le numéro vous voulez creer, ou pressez 0 pour revenir au menu principal.");
		Scanner sc7 = new Scanner(System.in);
		while (sc7.hasNextLine()) {
			String i7 = sc7.nextLine();
			switch (i7) {
				case "1":
					activite.afficheFicheComplet();
					reussiReturn();
					break;
				case "2":
					equipierLog.modifierListeActivite(activite);
					activite.supprimerMembreSouscrit(equipierLog);
					System.out.println("Vous avez annuler la souscription.");
					reussiReturn();
					break;
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					gererSouscription();
					break;
			}
		}
	}

	public void consulterNotification(){
		ArrayList<Notification> listeNotification = afficherListeNotification(equipierLog);
		System.out.println("Entrez le numéro que vous voulez consulter, ou pressez 0 pour revenir au menu principal.\n"+
				"ou pressez + pour modifier le facon de recevoir des notifications.");
		Scanner scannerNum = new Scanner(System.in);
		while (scannerNum.hasNextLine()) {
			String orderNum = scannerNum.nextLine();
			if (orderNum.equals("0")) {
				printMenu();
				menu();
				break;
			} else if(orderNum.equals("+")){
				System.out.println("Est-ce que vous voulez recevoir des notifications par E-mail?" + "\n"+
						"[1]: Oui"+ "\n" +
						"[0]: Non");
				Scanner sc = new Scanner(System.in);
				while (sc.hasNextLine()){
					String s = sc.nextLine();
					switch (s) {
						case "0":
							equipierLog.setRecevoirNotifParCouriel(false);
							System.out.println("Vous choisissez de recevoir des notifications par Système.");
							reussiReturn();
							break;
						case "2":
							equipierLog.setRecevoirNotifParCouriel(true);
							System.out.println("Vous choisissez de recevoir des notifications par E-mail.");
							reussiReturn();
							break;
						default:
							System.out.println("Aucun résultat. Réessayez SVP");
							gererSouscription();
							break;
					}
				}
			} else {
				Notification notificationConsulter = null;
				boolean isInt = testInt(orderNum);
				if (isInt == true) {
					int orderselectionne = Integer.parseInt(orderNum)-1;
					if (orderselectionne<0 || orderselectionne >= listeNotification.size()) {
						System.out.println("Le numéro que vous avez entré est invalide.\n");
						consulterNotification();
						break;
					}
					notificationConsulter = listeNotification.get(orderselectionne);
				} else {
					System.out.println("Le numéro que vous avez entré est invalide.\n");
					consulterNotification();
					break;
				}
				notificationConsulter.afficherFicheComplet();
				notificationConsulter.setVu(true);
				reussiReturn();
			}
		}


	}
	public ArrayList<Notification> afficherListeNotification(Equipier equipier){
		ArrayList<Notification> listeNotification = equipier.getListeNotification();
		System.out.println("---------------Notification---------------");
		int n = 0;
		for (Notification notification: listeNotification){
			n++;
			String nomDeNotification = n + ". " + notification.getTitre();
			if (notification.isVu()==false){
				nomDeNotification += "(new)";
			}
			System.out.println(nomDeNotification);
		}
		return listeNotification;
	}

	public void sentNotification(int type,Activite activite){
		if(type == 1){
			String titre = equipierLog.getPrenom()+" "+equipierLog.getNomDeFamille()+" a crée "+activite.getTitre();
			Notification newNotification = new Notification(titre,activite,equipierLog,addDiscription(),getDate());
			for (Interet interet: activite.getListInteretsLie()){
				for (Equipier equipier: interet.getMembreSouscrit()) {
					if (!equipier.isRecevoirNotifParCouriel()){
						equipier.addNotification(newNotification);
					}else {
						envoyerCourriel(equipier,newNotification);
					}
				}
			}
		}else if(type == 2){
			String titre = equipierLog.getPrenom()+" "+equipierLog.getNomDeFamille()+" a modifié "+activite.getTitre();
			Notification newNotification = new Notification(titre,activite,equipierLog,addDiscription(),getDate());
			for (Equipier equipier: activite.getMembreSouscrit()) {
				if (!equipier.isRecevoirNotifParCouriel()){
					equipier.addNotification(newNotification);
					System.out.println(equipierLog.getListeNotification().size());
				}else {
					envoyerCourriel(equipier,newNotification);
				}
			}
		}else {
			String titre = equipierLog.getPrenom()+" "+equipierLog.getNomDeFamille()+" a supprimé "+activite.getTitre();
			Notification newNotification = new Notification(titre,activite,equipierLog,addDiscription(),getDate());
			for (Equipier equipier: activite.getMembreSouscrit()) {
				if (!equipier.isRecevoirNotifParCouriel()){
					equipier.addNotification(newNotification);
				}else {
					envoyerCourriel(equipier,newNotification);
				}
			}
		}
	}

	public void envoyerCourriel(Equipier equipier,Notification notification){
		String to = equipier.getCompte().getAdresseCourriel();

		String from = this.equipierLog.getCompte().getAdresseCourriel();

		String host = "localhost";

		Properties properties = System.getProperties();


		properties.setProperty("mail.smtp.host", host);

		//des operations pour envoyer e-mail//
	}


	public String addDiscription(){
		System.out.println("Entrez la discription de notification");
		Scanner sc54 = new Scanner(System.in);
		String i54 = sc54.nextLine();
		String discription = i54;
		return discription;
	}
	public void fonctionSpeciale() {
		if(compteLog.getRole().equals(Role.administrateur)) {
			gererCompte();
		}else if(compteLog.getRole().equals(Role.superviseur)) {
			gererInteret();
		}else {
			System.out.println("Vous n'avez pas de fonction spéciale.");
			reussiReturn();
		}
	}

	public void gererCompte() {
		controleurCompte.afficherListeCompte();
		System.out.println("Entrez le numéro de compte que vous voulez gérer, ou pressez 0 pour revenir au menu principal.");
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
					Compte compte = controleurCompte.getCompteCherche(orderselectionne);
					if (compte==null) {
						System.out.println("Le numéro que vous avez entré est invalide.\n");
						gererInteret();
						break;
					}
					gererUnCompte(compte);
				} else {
					System.out.println("Le numéro que vous avez entré est invalide.\n");
					gererInteret();
				}
			}
		}
	}
	public void gererUnCompte(Compte compte){
		System.out.println("[1]: Modifier son role"+ "\n" +
				"[2]: Suspendre ce compte" + "\n" +
				"[3]: Réactiver ce compte" + "\n" +
				"Entrez le numéro vous voulez creer, ou pressez 0 pour revenir au menu principal.");
		Scanner sc8 = new Scanner(System.in);
		while (sc8.hasNextLine()) {
			String i8 = sc8.nextLine();
			switch (i8) {
				case "1":
					modifierRole(compte);
					break;
				case "2":
					if(compte.getStatus()==CompteStatus.valide) {
						compte.setStatus(CompteStatus.suspendu);
						System.out.println("Vous avez suspendu ce compte");
					}else {
						System.out.println("Ce compte est déjà suspendu.");
					}
					reussiReturn();

					break;
				case "3":
					if(compte.getStatus()==CompteStatus.suspendu) {
						compte.setStatus(CompteStatus.valide);
						System.out.println("Vous avez réactivé ce compte");
					}else {
						System.out.println("Ce compte est déjà activé.");
					}
					reussiReturn();
					break;
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					gererSouscription();
					break;
			}
		}
	}
	public void modifierRole(Compte compte){
		System.out.println("[1]: Membre"+ "\n" +
				"[2]: Superviseur" + "\n" +
				"[3]: Administrateur" + "\n" +
				"Entrez le numéro de role, ou pressez 0 pour revenir au menu principal.");
		Scanner sc9 = new Scanner(System.in);
		while (sc9.hasNextLine()) {
			String i9 = sc9.nextLine();
			Equipier equipier = compte.getMembre();
			switch (i9) {
				case "1":
					compte.setRole(Role.membre);
					Membre newMembre = new Membre(equipier.getId(),equipier.getPrenom(),equipier.getNomDeFamille(),
							equipier.getNumeroDeTele(), equipier.getAdresseCourriel(),equipier.getLienWeb(),
							equipier.getTitre(),null,equipier.getInscrireActivite_(),
							equipier.getInscrireInteret_(), equipier.getListeNotification());
					compte.setMembre(newMembre);
					newMembre.setCompte(compte);
					controleurEquipier.supprimerMembre(equipier);
					controleurEquipier.ajouterMembre(newMembre);
					System.out.println("Vous avez modifié le role.");
					reussiReturn();
					break;
				case "2":
					compte.setRole(Role.superviseur);
					Superviseur newSuperviseur = new Superviseur(equipier.getId(),equipier.getPrenom(),equipier.getNomDeFamille(),
							equipier.getNumeroDeTele(), equipier.getAdresseCourriel(),equipier.getLienWeb(),
							equipier.getTitre(),equipier.getInscrireActivite_(),
							equipier.getInscrireInteret_(), equipier.getListeNotification());
					compte.setMembre(newSuperviseur);
					newSuperviseur.setCompte(compte);
					controleurEquipier.supprimerMembre(equipier);
					controleurEquipier.ajouterMembre(newSuperviseur);
					System.out.println("Vous avez modifié le role.");
					reussiReturn();
					break;
				case "3":
					compte.setRole(Role.administrateur);
					Administrateur newAdministrateur = new Administrateur(equipier.getId(),equipier.getPrenom(),equipier.getNomDeFamille(),
							equipier.getNumeroDeTele(), equipier.getAdresseCourriel(),equipier.getLienWeb(),
							equipier.getTitre(),null,equipier.getInscrireActivite_(),
							equipier.getInscrireInteret_(), equipier.getListeNotification());
					compte.setMembre(newAdministrateur);
					newAdministrateur.setCompte(compte);
					controleurEquipier.supprimerMembre(equipier);
					controleurEquipier.ajouterMembre(newAdministrateur);
					System.out.println("Vous avez modifié le role.");
					reussiReturn();
					break;
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					modifierRole(compte);
					break;
			}
		}
	}

	public void gererInteret(){
		System.out.println("[1]: créer un intérêt"+ "\n" +
				"[2]: modifier un intérêt" + "\n" +
				"[3]: supprimer un intérêt" + "\n" +
				"Entrez le numéro d'opération vous voulez faire, ou pressez 0 pour revenir au menu principal.");
		Scanner sc8 = new Scanner(System.in);
		while (sc8.hasNextLine()) {
			String i8 = sc8.nextLine();
			switch (i8) {
				case "1":
					creerInteret();
					break;
				case "2":
					notOpen();
					reussiReturn();
					break;
				case "3":
					supprimerInteret();
					reussiReturn();
					break;
				case "0":
					printMenu();
					menu();
					break;
				default:
					System.out.println("Aucun résultat. Réessayez SVP, ou pressez 0 à quitter.");
					gererInteret();
					break;
			}
		}
	}



	public void creerInteret(){
		System.out.println("Entrez le titre, ou pressez 0 pour revenir au menu principal.");
		Scanner sc91 = new Scanner(System.in);
		String i91 = sc91.nextLine();
		if (i91.equals("0")) {
			printMenu();
			menu();
		}
		String titre = i91;
		System.out.println("Entrez le description, ou pressez 0 pour revenir au menu principal.");
		Scanner sc52 = new Scanner(System.in);
		String i52 = sc52.nextLine();
		if (i52.equals("0")) {
			printMenu();
			menu();
		}
		String description = i52;
		Interet newInteret = new Interet(titre,description);
		controleurInteret.ajouterInteret(newInteret);

		System.out.println("Intérêt ajouté. Pressez 0 pour revenir au menu principal.");
		reussiReturn();
	}

	public void supprimerInteret() {
		controleurInteret.afficherListeInteret();
		System.out.println("Entrez le numéro d'intérêt que vous voulez supprimer, ou pressez 0 pour revenir au menu principal.");
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
					Interet interet = controleurInteret.getInteretCherche(orderselectionne);
					if (interet==null) {
						System.out.println("Le numéro que vous avez entré est invalide.\n");
						supprimerInteret();
						break;
					}
					controleurInteret.supprimerInteret(interet);
					System.out.println("Vous avez supprimé cet intérêt.");
					reussiReturn();
				} else {
					System.out.println("Le numéro que vous avez entré est invalide.\n");
					supprimerInteret();
					break;
				}
			}
		}
	}



	public boolean testInt(String s) {
		try{
			Integer.parseInt(s);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}
	public Object choisitUnObjet(ArrayList arrayList){
		System.out.println("Entrez le numéro que vous voulez consulter, ou pressez 0 pour revenir au menu principal.");
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
					int orderselectionne = Integer.parseInt(orderNum)-1;
					if (orderselectionne<0 || orderselectionne >= arrayList.size()) {
						System.out.println("Le numéro que vous avez entré est invalide.\n");
						return choisitUnObjet(arrayList);
					}
					return arrayList.get(orderselectionne);
				} else {
					System.out.println("Le numéro que vous avez entré est invalide.\n");
					return choisitUnObjet(arrayList);
				}
			}
		}
		return null;
	}
	public String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}