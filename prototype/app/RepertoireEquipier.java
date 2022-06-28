import java.util.ArrayList;

public class RepertoireEquipier {

	private ArrayList<Membre> membre = new ArrayList<>();
	private ArrayList<Superviseur> superviseur = new ArrayList<>();
	private ArrayList<Administrateur> administrateur= new ArrayList<>();
    private ArrayList<Equipier> equipier = new ArrayList<>();
	public Equipier afficherListToutMembre() {
        for (int i = 0; i < membre.size(); i++) {
            equipier.add(membre.get(i));
        }
        for (int i = 0; i < superviseur.size(); i++) {
            equipier.add(superviseur.get(i));
        }
        for (int i = 0; i < administrateur.size(); i++) {
            equipier.add(administrateur.get(i));
        }
        for (int i = 0; i < equipier.size(); i++) {
            return equipier.get(i);

        }

    }

	/**
	 * 
	 * @param membre
	 */
	public void afficherProfilComplet(Equipier membre) {
        System.out.println(membre.prenom + membre.nom);


	}

	/**
	 * 
	 * @param prenom
	 * @param nom
	 */
	public void chercherMembre(String prenom, String nom) {
		// TODO - implement RepertoireEquipier.chercherMembre
		throw new UnsupportedOperationException();
	}

}