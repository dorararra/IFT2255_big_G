public class RoundTable {

	public static void main(String[] args) {
		RepertoireEquipier repertoireEquipier = new RepertoireEquipier();
		ControleurEquipier controleurEquipier = new ControleurEquipier();
		ControleurActivite controleurActivite = new ControleurActivite();
		ControleurInteret controleurInteret = new ControleurInteret();
		ControleurCompte controleurCompte = new ControleurCompte();

		controleurEquipier.setRepertoire(repertoireEquipier);

		Compte compteDora = new Compte("g","12345",null,null,"12345");

		Membre dora = new Membre("007","Dora","Peng",122346262,"g",
				"www.google.com",null,null,null,null, compteDora);

		controleurEquipier.ajouterMembre(dora);
		System.out.println(repertoireEquipier.getEquipier().size());

		Menu menu = new Menu(controleurEquipier, controleurActivite, controleurInteret, controleurCompte);
		int resultLogin = menu.loginMenu();
	}

}