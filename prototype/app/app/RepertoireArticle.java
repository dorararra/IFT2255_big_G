import java.util.ArrayList;

public class RepertoireArticle extends Repertoire {
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Article> articleRelatif;

    public void ajouter(Activite activite){
        Article article = (Article) activite;
        article.setId(generateId());
        this.articles.add(article);
    }
    public void supprimer(Activite activite){
        Article article = (Article) activite;
        this.articles.remove(article);
    }

    public ArrayList getActivites(){
        ArrayList activites = this.articles;
        return activites;
    }

    public ArrayList<Article> chercher(String motCle) {
        ArrayList<Article> articleRelatif = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            ArrayList<String> motChercher = articles.get(i).getMotChercher();
            for (int j = 0; j < motChercher.size(); j++) {
                if (motChercher.get(j).equals(motCle)){
                    articleRelatif.add(articles.get(i));
                    break;
                }
            }
        }
        this.articleRelatif = articleRelatif;
        int n = 0;
        for (Activite activite : this.articleRelatif) {
            n++;
            print(n,activite);
        }
        return this.articleRelatif;
    }

    public Article chercherParNum(int i) {

        Article article = articles.get(i-1);
        return article;

    }
}

