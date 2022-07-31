import java.util.ArrayList;
import java.util.HashMap;

public class RepertoireEquipier {

    private ArrayList<Membre> membre = new ArrayList<>();
    private ArrayList<Equipier> auteurs = new ArrayList<>();
    private ArrayList<Equipier> collaborateurs = new ArrayList<>();
    private ArrayList<Superviseur> superviseur = new ArrayList<>();
    private ArrayList<Administrateur> administrateur = new ArrayList<>();
    private ArrayList<Equipier> equipier = new ArrayList<>();
    private Equipier equipierTrouve;

    public void getTousMembre() {
        this.equipier = new ArrayList<>();
        equipier.addAll(membre);
        equipier.addAll(superviseur);
        equipier.addAll(administrateur);
    }
    public int getEquipierSize(){
        return equipier.size();
    }

    public void afficherListToutMembre(int begin) {
        int n = 0;
        int length = equipier.size();

        if((begin/30==0) && length<=30 ) {
            for (Equipier mem : equipier) {
                n++;
                System.out.println(n + ". " + mem.getPrenom() + " " + mem.getNomDeFamille() + "     " + mem.getAdresseCourriel()
                + "    " + mem.getNumeroDeTele());
            }
        }
        else if(begin+30>equipier.size()){
            for(int i= begin;i<equipier.size();i++){
                System.out.println(begin + ". "+equipier.get(i).getPrenom()+" "+equipier.get(i).getNomDeFamille());

            }
        }
        else{
            for(int i = 0;i<30;i++){
                System.out.println(begin + ". "+equipier.get(begin).getPrenom()+" "+equipier.get(begin).getNomDeFamille());
            }
        }
    }

    public void afficherProfilComplet(Equipier membre) {
        System.out.println("Nom complet: " + membre.getPrenom() + " " + membre.getNomDeFamille());
        System.out.println("Adresse courriel: " + membre.getAdresseCourriel());
        System.out.println("Numéro de téléphone: " + membre.getNumeroDeTele());
        System.out.println("Role: " + membre.getCompte().getRole());
        System.out.println("Intérets: " + membre.getInscrireInteret());
        System.out.println("Articles: " + membre.getInscrireActivite() + "\n");
    }

    public int chercherMembre(String prenomOuNomOuInteret) {
        ArrayList<Equipier> membreRelatif = new ArrayList<>();
        for (int i = 0; i < equipier.size(); i++) {
            if (String.valueOf(equipier.get(i).getPrenom()).equals(prenomOuNomOuInteret)) {
                membreRelatif.add(equipier.get(i));
            }
            if (String.valueOf(equipier.get(i).getNomDeFamille()).equals(prenomOuNomOuInteret)) {
                membreRelatif.add(equipier.get(i));
            }
            for (Interet interet : equipier.get(i).getInscrireInteret_()) {
                if (interet.getTitre().equals(prenomOuNomOuInteret)) {
                    membreRelatif.add(equipier.get(i));
                    break;
                }
            }
        }
        for (Equipier equipier : membreRelatif) {
            equipier.afficherProfilComplet();
        }
        return membreRelatif.size();
    }

    public void ajouterMembre(Equipier membre) {
        if (membre instanceof Membre) {
            this.membre.add((Membre) membre);
            String membreID = "M" + membre.getEquipierID();
            membre.setId(membreID);
        }else if(membre instanceof Superviseur){
            this.superviseur.add((Superviseur) membre);
            String superviseurID = "S" + membre.getEquipierID();
            membre.setId(superviseurID);
        }else if(membre instanceof Administrateur){
            this.administrateur.add((Administrateur) membre);
            String administrateurID = "A" + membre.getEquipierID();
            membre.setId(administrateurID);
        }
    }

    public void supprimerMembre(Equipier membre) {
        if (membre instanceof Membre) {
            this.membre.remove((Membre) membre);
        }else if(membre instanceof Superviseur){
            this.superviseur.remove((Superviseur) membre);
        }else if(membre instanceof Administrateur){
            this.administrateur.remove((Administrateur) membre);
        }
    }

    public void ajouterAuteur(Membre auteur){this.auteurs.add(auteur);}
    public void ajouterCollaborateur(Membre collaborateur){this.collaborateurs.add(collaborateur);}


    public Equipier getEquipierTrouve(int n){
        return equipier.get(n-1);

    }
    public boolean pagePrecedent(){
        return equipier.size()>=30;
    }

    public ArrayList<Equipier> getEquipier() {
        getTousMembre();
        return equipier;
    }
    public ArrayList<Equipier> getAuteurs(){
        return auteurs;
    }
    public ArrayList<Equipier> getCollaborateurs(){
        return collaborateurs;
    }

    public void setEquipier(ArrayList<Equipier> equipier) {
        this.equipier = equipier;
    }
}

