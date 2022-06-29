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
    public String getId(){return this.id;}
    /**
     *
     * @param id
     */
    public void setId(String id){this.id = id;}

    public String getPrenom(){return this.prenom;}
    public void setPrenom(String prenom){this.prenom = prenom;}

    public String getNomDeFamille(){return this.nomDeFamille;}
    public void setNomDeFamille(String nomDeFamille){this.nomDeFamille = nomDeFamille;}

    public  int  getNumeroDeTele(){return this.numeroDeTele;}
    public void setNumeroDeTele(int numeroDeTele){this.numeroDeTele = numeroDeTele;}

    public String getAdresseCourriel(){return this.adresseCourriel;}
    public void setAdresseCourriel(String adresseCourriel){this.adresseCourriel = adresseCourriel;}

    public String getLienWeb(){return  this.lienWeb;}
    public  void setLienWeb(String lienWeb){this.lienWeb = lienWeb;}

    public Condition getTitre(){return this.titre;}
    public  void setTitre(Condition titre){this.titre = titre;}

    public Superviseur getSuperviseur(){return this.superviseur;}
    public void setSuperviseur(Superviseur superviseur){this.superviseur = superviseur;}

    public  Interet[] getInscrireInteret(){return this.inscrireInteret;}
    public void setInscrireInteret(Interet[] inscrireInteret){this.inscrireInteret = inscrireInteret;}

    public Activite[] getInscrireActivite(){return  this.inscrireActivite;}
    public  void setInscrireActivite(Activite[] inscrireActivite){this.inscrireActivite = inscrireActivite;}






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