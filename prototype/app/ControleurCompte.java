public class ControleurCompte {

    private RepertoireCompte repertoire;

    /**
     * @param numCompte
     */
    public void supprimerCompte(String numCompte) {
        repertoire.supprimerCompte(numCompte);
    }



    /**
     * @param compte
     */
    public void ajouterCompte(Compte compte) {
        repertoire.ajouterCompte(compte);
    }

    /**
     * @param numCompte
     */
    public Compte getCompte(String numCompte) {
        return repertoire.getCompte(numCompte);
    }
}