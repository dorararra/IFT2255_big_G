import java.util.ArrayList;

public class Administrateur extends Equipier {
    private Superviseur superviseur;
    public Administrateur(String id, String prenom, String nomDeFamille, int numeroDeTele, String adresseCourriel, String lienWeb, Condition titre, Superviseur superviseur, ArrayList<Activite> inscrireActivite, ArrayList<Interet> inscrireInteret,Compte compte) {
        super(id, prenom, nomDeFamille, numeroDeTele, adresseCourriel, lienWeb, titre,  inscrireActivite, inscrireInteret,compte);
        setSuperviseur(superviseur);
    }

    public Superviseur getSuperviseur() {
        return superviseur;
    }
    public void setSuperviseur(Superviseur superviseur) {
        this.superviseur = superviseur;
    }

	/**
	 * 
	 * @param equipier
	 * @param role
	 */
	public void assignerRole(Equipier equipier, Role role) {
		// TODO - implement Administrateur.assignerRole
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param equipier
	 * @param role
	 */
	public void modifierRole(Equipier equipier, Role role) {
		// TODO - implement Administrateur.modifierRole
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param activite
	 */
	public void supprimerActivite(Activite activite) {
		// TODO - implement Administrateur.supprimerActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param compte
	 */
	public void suspendreCompte(Compte compte) {
		// TODO - implement Administrateur.suspendreCompte
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param compte
	 */
	public void reactiverCompte(Compte compte) {
		// TODO - implement Administrateur.reactiverCompte
		throw new UnsupportedOperationException();
	}

}