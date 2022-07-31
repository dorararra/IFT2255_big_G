import java.util.ArrayList;

public class Membre extends Equipier {
    private Superviseur superviseur;
    public Membre(String id, String prenom, String nomDeFamille, String numeroDeTele, String adresseCourriel,
                  String lienWeb, Condition titre, Superviseur superviseur, ArrayList<Activite> inscrireActivite,
                  ArrayList<Interet> inscrireInteret,ArrayList<Notification> listeNotification) {
        super(id, prenom, nomDeFamille, numeroDeTele, adresseCourriel, lienWeb, titre,
                inscrireActivite, inscrireInteret, listeNotification);
         setSuperviseur(superviseur);
    }

    public Superviseur getSuperviseur() {
        return superviseur;
    }
    public void setSuperviseur(Superviseur superviseur) {
        this.superviseur = superviseur;
    }
}