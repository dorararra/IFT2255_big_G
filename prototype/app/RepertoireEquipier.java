import java.util.ArrayList;
import java.util.HashMap;

public class RepertoireEquipier {

    private ArrayList<Membre> membre = new ArrayList<>();
    private ArrayList<Superviseur> superviseur = new ArrayList<>();
    private ArrayList<Administrateur> administrateur = new ArrayList<>();
    private ArrayList<Equipier> equipier = new ArrayList<>();
    private Equipier equipierTrouve;

    public void getTousMembre() {
        equipier.addAll(membre);
        equipier.addAll(superviseur);
        equipier.addAll(administrateur);
    }

    public void afficherListToutMembre() {
        int n = 0;
        for (Equipier mem : equipier) {
            n++;
            System.out.println(n + " . " + mem.getPrenom() + " " + mem.getNomDeFamille());

        }

    }

    /**
     * @param membre
     */
    public void afficherProfilComplet(Equipier membre) {
        System.out.println(membre.getPrenom() + membre.getNomDeFamille());
        System.out.println(membre.getAdresseCourriel());
        System.out.println(membre.getNumeroDeTele());
        System.out.println(membre.getInscrireInteret());
        //todo activite
    }

    /**
     * @param prenom
     * @param nom
     */
    public Equipier chercherMembre(String prenom, String nom) {
        for (Equipier mem : equipier) {
            if ((mem.getPrenom().equals(prenom)) && (mem.getNomDeFamille().equals(nom))){
                this.equipierTrouve = mem;
                return equipierTrouve;
            }
        }
        return null;
    }

    public void ajouterMembre(Membre membre) {
        this.membre.add(membre);
    }

    public Equipier chercherMembreParCourriel(String adresseCourriel) {
        for (Equipier mem : equipier) {
            if ((adresseCourriel.equals(mem.getAdresseCourriel()))){
                this.equipierTrouve = mem;
                return equipierTrouve;
            }
        }
        return null;
    }

    public ArrayList<Equipier> getEquipier() {
        getTousMembre();
        return equipier;
    }

    public void setEquipier(ArrayList<Equipier> equipier) {
        this.equipier = equipier;
    }
}

