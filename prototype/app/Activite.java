import java.util.ArrayList;

public abstract class Activite {

	private String id;
	private String titre;
	private ArrayList<Interet> interetsLie;
    public Activite(String id,String titre, ArrayList<Interet> interetsLie){
        this.id = id;
        this.titre = titre;
        this.interetsLie = interetsLie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArrayList<Interet> getInteretsLie() {
        return this.interetsLie;
    }

    public void setInteretsLie(ArrayList<Interet> interetsLie) {
        this.interetsLie = interetsLie;
    }


	/**
	 *
	 * @param activite
	 */
	public void afficheFicheComplet() {

        }



}