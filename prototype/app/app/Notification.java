public class Notification {
    private String titre;
    private Activite activiteLiee;
    private Equipier auteur;
    private String descriptifTexte;
    private String datePublication;
    private boolean vu = false;

    public Notification(String titre,Activite activiteLiee,Equipier auteur,String descriptifTexte, String datePublication){
        this.titre =titre;
        this.activiteLiee  =activiteLiee;
        this.auteur = auteur;
        this.descriptifTexte = descriptifTexte;
        this.datePublication = datePublication;
    }




    public boolean isVu() {
        return vu;
    }



    public void setVu(boolean vu) {
        this.vu = vu;
    }
    public void afficherFicheComplet(){
        System.out.println("Titre: " + this.activiteLiee.getTitre());
        System.out.println("Auteur: " + this.auteur.getPrenom() + " " + this.auteur.getNomDeFamille());
        System.out.println("Description: " + this.descriptifTexte);
        System.out.println("Date de publication: " + this.datePublication);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
