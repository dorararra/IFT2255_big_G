import java.util.ArrayList;

public class Article extends Activite {

	private String lienArticle;
	private String datePublication;
	private String lienPublication;
    private ArrayList<Equipier> auteurs = new ArrayList<>();
    private ArrayList<Equipier> collaborateurs = new ArrayList<>();
	private ArrayList<String> motcles = new ArrayList<>();
	private articleStatus status;
	private String resume;

    public Article(String id, String titre, ArrayList<Interet> interetsLie, String lienArticle, String datePublication, String lienPublication, ArrayList<Equipier> auteurs,  ArrayList<Equipier> collaborateurs , ArrayList<String> motcles, articleStatus status, String resume) {
        super(id, titre, interetsLie);
        this.lienArticle = lienArticle;
        this.datePublication = datePublication;
        this.lienPublication = lienPublication;
        this.auteurs = auteurs;
        this.collaborateurs = collaborateurs;
        this.motcles = motcles;
        this.status = status;
        this.resume = resume;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getLienPublication() {
        return lienPublication;
    }

    public void setLienPublication(String lienPublication) {
        this.lienPublication = lienPublication;
    }


    public ArrayList<Equipier> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(ArrayList<Equipier> auteurs) {
        this.auteurs = auteurs;
    }

    public ArrayList<Equipier> getCollaborateurs() {
        return collaborateurs;
    }

    public void setCollaborateurs(ArrayList<Equipier> collaborateurs) {
        this.collaborateurs = collaborateurs;
    }

    public ArrayList<String> getMotcles() {
        return motcles;
    }

    public void setMotcles(ArrayList<String> motcles) {
        this.motcles = motcles;
    }

    public articleStatus getStatus() {
        return status;
    }

    public void setStatus(articleStatus status) {
        this.status = status;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getLienArticle() {
		return this.lienArticle;
	}

	/**
	 * 
	 * @param lienArticle
	 */
	public void setLienArticle(String lienArticle) {
		this.lienArticle = lienArticle;
	}
    @Override
    public void afficheFicheComplet(Activite activite) {
        System.out.println("Titre: " + this.getTitre()+"\n"+"Résumé " + this.getResume() + "\n"
                            + "Auteurs: "+ this.getAuteurs() + "Collaborateurs: "+ this.getCollaborateurs()+
                            "Date de Publication: "+this.getDatePublication() + "Lien de Publication: "+this.getLienPublication());

    }

}