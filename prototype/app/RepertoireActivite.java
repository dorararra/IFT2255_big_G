import java.util.ArrayList;

public class RepertoireActivite {
    private ArrayList<Activite> activites = new ArrayList<>();
	private ArrayList<Article> articles = new ArrayList<>();
	private ArrayList<Outil> outils = new ArrayList<>();
    private ArrayList<Projet> projets = new ArrayList<>();

    public void ajouteActivite(Activite activite){
        activites.add(activite);

    }
    public void ajouteArticle(Article article){
        articles.add(article);
    }
    public void ajouteOutil(Outil outil){
        outils.add(outil);
    }
    public void ajouteProjet(Projet projet){
        projets.add(projet);
    }
    public void afficherListToutArticle(){
        int n = 0;
        for(int i = 0;i<articles.size();i++){
            System.out.println(n+" . "+articles.get(i));
        }
    }
    public  void afficherListToutOutil(){
        int n = 0;
        for(int i = 0;i<outils.size();i++){
            System.out.println(n+ " . "+outils.get(i));
        }
    }
    public void afficherListToutProjet(){
        int n = 0;
        for(int i = 0; i<projets.size();i++){
            System.out.println(n+" . "+ projets.get(i));
        }
    }


}