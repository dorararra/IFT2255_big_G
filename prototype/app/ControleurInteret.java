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

	/**
	 * 
	 * @param interet
	 */
	public Boolean supprimerInteret(String interet) {
		// TODO - implement ControleurInteret.supprimerInteret
		throw new UnsupportedOperationException();
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