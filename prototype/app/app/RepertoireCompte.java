import java.util.ArrayList;

public class RepertoireCompte {

	private ArrayList<Compte> comptes = new ArrayList<>();;
	private int index;


	/**
	 * 
	 * @param numCompte
	 */
	public Boolean supprimerCompte(String numCompte) {
		// TODO - implement RepertoireCompte.supprimerCompte
		throw new UnsupportedOperationException();
	}

	public Compte chercherCompteParCourriel(String adresseCourriel) {
		for (Compte compte: comptes) {
			if ((adresseCourriel.equals(compte.getAdresseCourriel()))){
				return compte;
			}
		}
		return null;
	}

	public void afficherListeCompte(){
		int n=0;
		for(Compte compte: comptes){
			n++;
			System.out.println(n + ". " + compte.getMembre().getPrenom()+" "+compte.getMembre().getNomDeFamille());
		}
	}

	/**
	 * 
	 * @param compte
	 */
	public void ajouterCompte(Compte compte) {
		comptes.add(compte);
		compte.getMembre().setCompte(compte);
	}

	/**
	 * 
	 * @param numCompte
	 */
	public ArrayList<Compte> getListeComptes(){
		return this.comptes;
	}

}