import java.util.ArrayList;

public class Article extends Activite {

	private String lienArticle;
	private String datePublication;
	private String lienPublication;

	private ArrayList<String> motcles = new ArrayList<>();
	private articleStatus status;
	private String resume;
    private ArrayList<Equipier> auteurs = new ArrayList<>();
    private ArrayList<Equipier> collaborateurs = new ArrayList<>();

    public Article(String id, String titre, ArrayList<Interet> interetsLie, String lienArticle, String datePublication, String lienPublication, ArrayList<Equipier> auteurs,  ArrayList<Equipier> collaborateurs , ArrayList<String> motcles, articleStatus status, String resume) {
        super(id, titre, interetsLie);
        this.lienArticle = lienArticle;
        this.datePublication = datePublication;
        this.lienPublication = lienPublication;
        this.motcles = motcles;
        this.status = status;
        this.resume = resume;
        this.auteurs = auteurs;
        this.collaborateurs = collaborateurs;

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

    @Override
    public void afficheFicheComplet() {
        System.out.println("Titre: " + this.getTitre()+"\n"+"Résumé: " + this.getResume());
        System.out.print("Auteurs: ");
        ArrayList<Equipier> listAuteur = this.getAuteurs();
        for (int i = 0; i < listAuteur.size();i++) {
            if(i<listAuteur.size()-1) {
                System.out.print(listAuteur.get(i).getPrenom() +" "+ listAuteur.get(i).getNomDeFamille());
            }else{
                System.out.println(listAuteur.get(i).getPrenom() +" "+ listAuteur.get(i).getNomDeFamille());
            }
        }
        System.out.print("Collaborateurs: ");
        ArrayList<Equipier> listCollaborateurs = this.getCollaborateurs();
        for (int i = 0; i < listCollaborateurs.size();i++) {
            if(i<listCollaborateurs.size()-1) {
                System.out.print(listCollaborateurs.get(i).getPrenom() +" "+ listCollaborateurs.get(i).getNomDeFamille());
            }else{
                System.out.println(listCollaborateurs.get(i).getPrenom() +" "+ listCollaborateurs.get(i).getNomDeFamille());
            }
        }
        System.out.println("Date de publication: "+this.getDatePublication() +"\n"+
                "Lien de la publication: "+this.getLienPublication()+"\n");
    }

}