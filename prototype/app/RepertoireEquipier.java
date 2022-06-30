import java.util.ArrayList;

public class RepertoireEquipier {

	private ArrayList<Membre> membre = new ArrayList<>();
	private ArrayList<Superviseur> superviseur = new ArrayList<>();
	private ArrayList<Administrateur> administrateur= new ArrayList<>();
    private ArrayList<Equipier> equipier = new ArrayList<>();
    public void getTousMembre(){
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
	 * 
	 * @param membre
	 */
	public void afficherProfilComplet(Equipier membre) {
        System.out.println(membre.getPrenom() + membre.getNomDeFamille());
	}

	/**
	 * 
	 * @param prenom
	 * @param nom
	 */
	public void chercherMembre(String prenom, String nom) {
        for (Equipier mem : equipier) {
            if ((mem.getPrenom() == prenom) && (mem.getNomDeFamille() == nom)) {
                System.out.println("Nom Complet: " + mem.getPrenom() + mem.getNomDeFamille());
                System.out.println("Adresse Courriel: " + mem.getAdresseCourriel());
                System.out.println("Intérêt: " + mem.getInscrireInteret());

            }

        }
            }
        }


