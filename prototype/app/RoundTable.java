import java.util.ArrayList;

public class RoundTable {

	public static void main(String[] args) {
		RepertoireEquipier repertoireEquipier = new RepertoireEquipier();
        RepertoireActivite repertoireActivite = new RepertoireActivite();
		ControleurEquipier controleurEquipier = new ControleurEquipier();
		ControleurActivite controleurActivite = new ControleurActivite();
		ControleurInteret controleurInteret = new ControleurInteret();
		ControleurCompte controleurCompte = new ControleurCompte();

		controleurEquipier.setRepertoire(repertoireEquipier);
        controleurActivite.setRepertoire(repertoireActivite);


		Compte compteDora = new Compte("54321@geodes.com","12345",null,null,"12345");
        Compte compteJessie = new Compte("98765@geodes.com","987",null,null,"54323");

		Membre dora = new Membre("007","Dora","Peng",122346262,"54321@geodes.com",
				"www.google.com",null,null,null,null, compteDora);
        Membre Jessie = new Membre("120","Jessie","Galasso",321,"98765@geodes.com",
               "www.google.com",Condition.professeur,null,null,null, compteJessie);


        Interet interet = new Interet("7967","Pattern mining","Pattern mining is a topic of data mining concerned with finding statistically relevant patterns between data examples where the values are delivered in a sequence.");
        controleurInteret.ajouterInteret(interet);
        controleurEquipier.ajouterAuteur(Jessie);
        controleurEquipier.ajouterCollaborateur(dora);
        ArrayList<String> motCleArticle1 =new ArrayList<>();
        motCleArticle1.add("CodeRecommendation");
        motCleArticle1.add("CodeTemplate");
        motCleArticle1.add("CodeSimilarity");
        ArrayList<Equipier> auteursArticle1 = controleurEquipier.getAuteurs();
        ArrayList<Equipier> collaborateursArticle1 = controleurEquipier.getCollaborateurs();
        Article article1 = new Article("A123","Fine-Grained Analysis of Similar Code Snippets",null,
               "https://discord.com/channels/@me/973583906903318628/992627298706661516","10 June 2022",
                "https://link.springer.com/chapter/10.1007/978-3-031-08129-3_1",auteursArticle1,collaborateursArticle1, motCleArticle1,null,null);

        Outil outil1 = new Outil("O123","lowkey","lowkey is a low-level and transparent framework for real-time collaborative framework for multi-level and multi-view modeling.",
                3.0, "https://github.com/geodes-sms/lowkey", null, null,null,null,null);

        Projet projet1 = new Projet("0321", "IVADO", "Inference of Simulation Models in Digital Twins by Reinforcement Learning.",
                "20 December 2021", "2024", Jessie, null);

        controleurActivite.ajouteArticle(article1);
        controleurActivite.ajouteOutil(outil1);
        controleurActivite.ajouteProjet(projet1);
		controleurEquipier.ajouterMembre(dora);
        controleurEquipier.ajouterMembre(Jessie);
		repertoireEquipier.getEquipier();
        repertoireActivite.getArticle();

		Menu menu = new Menu(controleurEquipier, controleurActivite, controleurInteret, controleurCompte);
		int resultLogin = menu.loginMenu();
	}

}