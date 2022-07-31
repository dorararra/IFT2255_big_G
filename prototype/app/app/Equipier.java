import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Equipier {
    private static int totalCount = 0;
	private int equipierID;
	private String id;
	private String prenom;
	private String nomDeFamille;
	private String numeroDeTele;
	private String adresseCourriel;
	private String lienWeb;
	private Condition titre;
	private ArrayList<Activite> inscrireActivite;
	private ArrayList<Interet> inscrireInteret ;
    private ArrayList<Notification> listeNotification;

    public boolean isRecevoirNotifParCouriel() {
        return recevoirNotifParCouriel;
    }

    public void setRecevoirNotifParCouriel(boolean recevoirNotifParCouriel) {
        this.recevoirNotifParCouriel = recevoirNotifParCouriel;
    }

    private boolean recevoirNotifParCouriel = false;
    private Compte compte = null;

    public Equipier(String id, String prenom, String nomDeFamille, String numeroDeTele, String adresseCourriel,
                    String lienWeb, Condition titre, ArrayList<Activite> inscrireActivite,
                    ArrayList<Interet> inscrireInteret,ArrayList<Notification> listeNotification){
        ++totalCount;
        this.equipierID = totalCount;
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
        this.numeroDeTele =numeroDeTele;
        this.adresseCourriel = adresseCourriel;
        this.lienWeb = lienWeb;
        this.titre = titre;
        this.inscrireInteret = inscrireInteret;
        this.inscrireActivite = inscrireActivite;
        this.listeNotification = listeNotification;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getEquipierID() {
        DecimalFormat decimalFormat = new DecimalFormat("00000000");
        return decimalFormat.format(equipierID);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom(){return this.prenom;}
    public void setPrenom(String prenom){this.prenom = prenom;}

    public String getNomDeFamille(){return this.nomDeFamille;}
    public void setNomDeFamille(String nomDeFamille){this.nomDeFamille = nomDeFamille;}

    public  String  getNumeroDeTele(){return this.numeroDeTele;}
    public void setNumeroDeTele(String numeroDeTele){this.numeroDeTele = numeroDeTele;}

    public String getAdresseCourriel(){return this.adresseCourriel;}
    public void setAdresseCourriel(String adresseCourriel){this.adresseCourriel = adresseCourriel;}

    public String getLienWeb(){return  this.lienWeb;}
    public  void setLienWeb(String lienWeb){this.lienWeb = lienWeb;}

    public Condition getTitre(){return this.titre;}
    public  void setTitre(Condition titre){this.titre = titre;}


    public ArrayList<Notification> getListeNotification(){
        return this.listeNotification;
    }
    public void setNumNotification(ArrayList<Notification> listeNotification){
        this.listeNotification = listeNotification;
    }

    public String getInscrireInteret() {
        String result = "";
        for (Interet interet : inscrireInteret) {
            result += interet.getTitre();
            result += "   ";
        }
        return result;
    }

    public String  getInscrireActivite() {
        String result = "";
        for(Activite activite : inscrireActivite){
            result += activite.getTitre();
            result += "   ";
        }
        return result;
    }




    public void afficherProfilComplet() {
        System.out.println("Nom complet: " + this.getPrenom() + " " + this.getNomDeFamille());
        System.out.println("Adresse courriel: " + this.getAdresseCourriel());
        System.out.println("Numéro de téléphone: " + this.getNumeroDeTele());
        System.out.println("Role: " + this.compte.getRole());
        System.out.println("Intérets: " + this.getInscrireInteret());
        System.out.println("Articles: " + this.getInscrireActivite() + "\n");

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
        this.inscrireActivite.remove(activite);
	}

	/**
	 * 
	 * @param interet
	 */
	public void modifierListeInteret(Interet interet) {
		// TODO - implement Equipier.modifierListeInteret
        this.inscrireInteret.remove(interet);
	}
	public void addNotification(Notification notification){
	    this.listeNotification.add(notification);
    }

	/**
	 * 
	 * @param interet
	 */
	public void inscrireInteret(Interet interet) {
		this.inscrireInteret.add(interet);
	}
    public ArrayList<Interet> getInscrireInteret_() {
        return this.inscrireInteret;
    }
    public ArrayList<Activite> getInscrireActivite_(){
        return this.inscrireActivite;
    }

    public boolean existeNewNotification() {
	    for (Notification notification: this.listeNotification){
	        if (!notification.isVu()){
	            return true;
            }
        }
        return false;
    }

}