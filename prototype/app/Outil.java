import java.util.ArrayList;

public class Outil extends Activite {

	private Double version;
	private String lienRepertoire;
	private Equipier responsable;
	private ArrayList<Equipier> equipiers = new ArrayList<>();
	private ArrayList<Article> articles = new ArrayList<>();
	private ArrayList<String> interetLie = new ArrayList<>();
	private String description;
    public  Outil(String id,String titre, ArrayList<Interet> interetsLie,Double version, String lienRepertoire,
                  Equipier responsable,ArrayList<Equipier> equipiers ,ArrayList<Article> articles,ArrayList<String> interetLie){
        super(id, titre, interetsLie);
        this.version = version;
        this.lienRepertoire =lienRepertoire;
        this.responsable = responsable;
        this.equipiers = equipiers;
        this.articles = articles;
        this.interetLie = interetLie;


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

    public ArrayList<String> getInteretLie() {
        return interetLie;
    }

    public void setInteretLie(ArrayList<String> interetLie) {
        this.interetLie = interetLie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}