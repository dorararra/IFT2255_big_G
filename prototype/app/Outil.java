import java.util.ArrayList;

public class Outil extends Activite {

	private Double version;
	private String lienRepertoire;
	private Equipier responsable;
	private ArrayList<Equipier> equipiers = new ArrayList<>();
    private ArrayList<Equipier> collaborateurs = new ArrayList<>();
    private ArrayList<Equipier> auteurs = new ArrayList<>();
	private ArrayList<Article> articles = new ArrayList<>();
	private ArrayList<Interet> interetsLie = new ArrayList<>();
    private ArrayList<String> motcles = new ArrayList<>();
	private String description;
    public  Outil(String id,String titre,String description,Double version,String lienRepertoire,  Equipier responsable,ArrayList<Equipier> collaborateurs,ArrayList<Article> articles,
                  ArrayList<String> motcles ,ArrayList<Interet> interetsLie){
        super(id, titre, interetsLie);
        this.version = version;
        this.lienRepertoire =lienRepertoire;
        this.responsable = responsable;
        this.equipiers = equipiers;
        this.articles = articles;




    }





    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public String getLienRepertoire() {
        return lienRepertoire;
    }

    public void setLienRepertoire(String lienRepertoire) {
        this.lienRepertoire = lienRepertoire;
    }

    public Equipier getResponsable() {
        return responsable;
    }

    public void setResponsable(Equipier responsable) {
        this.responsable = responsable;
    }

    public ArrayList<Equipier> getEquipiers() {
        return equipiers;
    }

    public void setEquipiers(ArrayList<Equipier> equipiers) {
        this.equipiers = equipiers;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public ArrayList<Interet> getInteretLie() {
        return interetsLie;
    }

    public void setInteretLie(ArrayList<Interet> interetLie) {
        this.interetsLie = interetLie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Equipier> getCollaborateurs() {
        return collaborateurs;
    }



    public ArrayList<String> getMotcles() {
        return motcles;
    }

    public void setMotcles(ArrayList<String> motcles) {
        this.motcles = motcles;
    }

    @Override
    public void afficheFicheComplet(){
        System.out.println("Nom: "+this.getTitre()+"\n"+ "Description: "+this.getDescription()+"\n"+ "Version: "+ this.getVersion()+"\n"
        + "Collaborateurs: "+ this.getCollaborateurs()+"\n"+ "Lien du Répertoire: "+ this.getLienRepertoire()+"\n" + "Article liés à l'outil: " + this.getArticles()+"\n");
    }
}