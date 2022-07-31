import java.util.ArrayList;

public class Superviseur extends Equipier {

    public Superviseur(String id, String prenom, String nomDeFamille, String  numeroDeTele, String adresseCourriel,
                       String lienWeb, Condition titre, ArrayList<Activite> inscrireActivite,
					   ArrayList<Interet> inscrireInteret,ArrayList<Notification> listeNotification) {
        super(id, prenom, nomDeFamille, numeroDeTele, adresseCourriel, lienWeb, titre,
				inscrireActivite, inscrireInteret, listeNotification);

    }




	/**
	 * 
	 * @param interet
	 */
	public void ajouterInteret(Interet interet) {
		// TODO - implement Superviseur.ajouterInteret
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param interet
	 */
	public void modifierInteret(Interet interet) {
		// TODO - implement Superviseur.modifierInteret
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param interet
	 */
	public void supprimerInteret(Interet interet) {
		// TODO - implement Superviseur.supprimerInteret
		throw new UnsupportedOperationException();
	}

}