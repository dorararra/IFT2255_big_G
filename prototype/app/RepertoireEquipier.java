import java.util.ArrayList;

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
        this.getTousMembre();
        int n = 0;
        for (Equipier mem : equipier) {
            n++;
            System.out.println(n + " . " + mem);

        }

    }

    /**
     * @param membre
     */
    public void afficherProfilComplet(Equipier membre) {
        System.out.println(membre.getPrenom() + membre.getNomDeFamille());
    }

    /**
     * @param prenom
     * @param nom
     */
    public Equipier chercherMembre(String prenom, String nom) {
        for (Equipier mem : equipier) {
            if ((mem.getPrenom() == prenom) && (mem.getNomDeFamille() == nom)) {
                System.out.println("Nom Complet: " + mem.getPrenom() + mem.getNomDeFamille());
                System.out.println("Adresse Courriel: " + mem.getAdresseCourriel());
                System.out.println("Intérêt: " + mem.getInscrireInteret());
                this.equipierTrouve = mem;
                return equipierTrouve;
            }
        }
        return null;
    }
    public int chercherMembreParCourriel(String adresseCourriel) {
        for (Equipier mem : equipier) {
            if ((mem.getAdresseCourriel() == adresseCourriel)){
                this.equipierTrouve = mem;
                return equipierTrouve.getNumeroDeTele();
            }
        }
        return 0;

    }
}

