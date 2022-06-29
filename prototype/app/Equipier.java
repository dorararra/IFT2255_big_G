public class Equipier {

	private String id;
	private String prenom;
	private String nomDeFamille;
	private int numeroDeTele;
	private String adresseCourriel;
	private String lienWeb;
	private Condition titre;
	private Superviseur superviseur;
	private Activite[] inscrireActivite;
	private Interet[] inscrireInteret;

    public Equipier(String id, String prenom, String nomDeFamille,int numeroDeTele,String adresseCourriel, String lienWeb,
                    Condition titre, Superviseur superviseur,  Activite[] inscrireActivite, Interet[] inscrireInteret ){
        this.id = id;
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
        this.numeroDeTele =numeroDeTele;
        this.adresseCourriel = adresseCourriel;
        this.lienWeb = lienWeb;
        this.titre = titre;
        this.superviseur = superviseur;
        this.inscrireActivite = inscrireActivite;
        this.inscrireInteret = inscrireInteret;
    }




    /**
     *
     * @param info
     */
	public void modifierProfil(Equipier info) {
		// TODO - implement Equipier.modifierProfil
		throw new UnsupportedOperationException();
	}

	public Boolean avoirNotification() {
		// TODO - implement Equipier.avoirNotification
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param activite
	 */
	public void creerActivite(String activite) {
		// TODO - implement Equipier.creerActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param activite
	 */
	public void inscrireActivite(Activite activite) {
		// TODO - implement Equipier.inscrireActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param activite
	 */
	public void modifierListeActivite(Activite activite) {
		// TODO - implement Equipier.modifierListeActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param interet
	 */
	public void modifierListeInteret(Interet interet) {
		// TODO - implement Equipier.modifierListeInteret
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param interet
	 */
	public void inscrireInteret(Interet interet) {
		// TODO - implement Equipier.inscrireInteret
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param activite
	 */
	public void modifierActivite(Activite activite) {
		// TODO - implement Equipier.modifierActivite
		throw new UnsupportedOperationException();
	}

}