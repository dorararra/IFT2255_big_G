import java.util.ArrayList;

public abstract class Equipier {

	private String id;
	private String prenom;
	private String nomDeFamille;
	private int numeroDeTele;
	private String adresseCourriel;
	private String lienWeb;
	private Condition titre;
	private ArrayList<Activite> inscrireActivite = new ArrayList<>();
	private ArrayList<Interet> inscrireInteret = new ArrayList<>();
    private int numNotification;
    private Compte compte;

    public Equipier(String id, String prenom, String nomDeFamille, int numeroDeTele, String adresseCourriel, String lienWeb,
                    Condition titre, ArrayList<Activite> inscrireActivite, ArrayList<Interet> inscrireInteret, Compte compte){
        this.id = id;
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
        this.numeroDeTele =numeroDeTele;
        this.adresseCourriel = adresseCourriel;
        this.lienWeb = lienWeb;
        this.titre = titre;
        this.inscrireInteret = inscrireInteret;
        this.inscrireActivite = inscrireActivite;
        this.numNotification = numNotification;
        this.compte = compte;
    }
    public String getId(){
        return this.id;
    }
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

    public void setInscrireActivite(ArrayList<Activite> inscrireActivite) {
        this.inscrireActivite = inscrireActivite;
    }

    public ArrayList<Interet> getInscrireInteret() {
        return inscrireInteret;
    }

    public void setInscrireInteret(ArrayList<Interet> inscrireInteret) {
        this.inscrireInteret = inscrireInteret;
    }

    public ArrayList<Activite> getInscrireActivite() {
        return inscrireActivite;
    }

    public int getNumNotification(){return this.numNotification;}
    public void setNumNotification(int numNotification){this.numNotification = numNotification;}

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Boolean avoirNotification() {
		if(this.numNotification == 0){
            System.out.println("Vous n'avez pas notification.");
            return false;
        }
        if(this.numNotification != 0){
            System.out.println("Vous avez "+ this.numNotification + "notification");
            return true;
        }
        return  null;
	}


	/**
	 * 
	 * @param activite
	 */
	public void creerActivite(Activite activite) {

	}

	/**
	 * 
	 * @param activite
	 */
	public void inscrireActivite(Activite activite) {
		this.inscrireActivite.add(activite);
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
		this.inscrireInteret.add(interet);
	}


}