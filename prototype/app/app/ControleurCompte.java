public class ControleurCompte {

    private RepertoireCompte repertoire = new RepertoireCompte();
    private Compte compteLog;

    public Compte chercherCompteParCourriel(String adresseCourriel) {
        return repertoire.chercherCompteParCourriel(adresseCourriel);
    }

    /**
     * @param numCompte
     */
    public void supprimerCompte(String numCompte) {
        repertoire.supprimerCompte(numCompte);
    }


    public boolean login(String motDePasse, Compte compte) {
        if (compte.getMotDePasse().equals(motDePasse)) {
            return true;
        }
        //pour tous les autres possibles, retourner -1
        return false;
    }

    public void afficherListeCompte() {
        repertoire.afficherListeCompte();
    }

    public Compte getCompteCherche(int num) {
        if (num > repertoire.getListeComptes().size() || num < 0) {
            return null;
        } else {
            return repertoire.getListeComptes().get(num - 1);
        }
    }

    /**
     * @param compte
     */
    public void ajouterCompte(Compte compte) {
        repertoire.ajouterCompte(compte);
    }
}