import java.util.ArrayList;

public class ControleurInteret{

	private RepertoireInteret repertoire = new RepertoireInteret();

	/**
	 * 
	 * @param interet
	 */
	public void ajouterInteret(Interet interet) {
		repertoire.ajouterInteret(interet);
	}
    public ArrayList<Interet> getListInteret(){
        return repertoire.getListeInteret();
    }

    public void afficherListeInteret(){
		repertoire.afficherListeInteret();
	}

	public Interet getInteretCherche(int num){
		if(num>repertoire.getListeInteret().size() || num<0) {
			return null;
		}else{
			return repertoire.getListeInteret().get(num-1);
		}
	}

	/**
	 * 
	 * @param interet
	 */
	public void supprimerInteret(Interet interet) {
		// TODO - implement ControleurInteret.supprimerInteret
		repertoire.supprimerInteret(interet);
		for (Activite activite: interet.getActiviteSouscrit()){
			activite.supprimerInteret(interet);
		}
		for (Equipier equipier: interet.getMembreSouscrit()){
			equipier.modifierListeInteret(interet);
		}
	}

	/**
	 * 
	 * @param interet
	 */
	public Boolean modifierInteret(String interet) {
		// TODO - implement ControleurInteret.modifierInteret
		throw new UnsupportedOperationException();
	}
    /**
     *
     * @param info
     */


}