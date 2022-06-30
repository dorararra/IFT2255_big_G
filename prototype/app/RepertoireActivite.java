import java.util.ArrayList;
import java.util.Random;

public class RepertoireActivite {
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Outil> outils = new ArrayList<>();
    private ArrayList<Projet> projets = new ArrayList<>();
    private ArrayList<String> tousLesID = new ArrayList<>();

    //chaque ID compose 1 lettre et 6 chiffre
    private String generate6Chiffre(){
        Random rand = new Random();
        String num = "";
        for(int i = 0;i<6;i++){
            num += rand.nextInt(10);
        }
        return num;
    }
    public String generateArticleId() {
        String idNum = generate6Chiffre();
        if (!tousLesID.contains(idNum)) {
            this.tousLesID.add(idNum);
            String id = 'A' + idNum;
            return id;
        } else return generateArticleId();
    }
    public void ajouteArticle(Article article){
        article.setId(generateArticleId());
        articles.add(article);
    }
    public  String generateOutilId(){
        String idNum = generate6Chiffre();
        if (!tousLesID.contains(idNum)) {
            this.tousLesID.add(idNum);
            String id = 'O' + idNum;
            return id;
        } else return generateOutilId();
    }


    public void ajouteOutil(Outil outil){
        outil.setId(generateOutilId());
        outils.add(outil);
    }

    public  String generateProjetId(){
        String idNum = generate6Chiffre();
        if (!tousLesID.contains(idNum)) {
            this.tousLesID.add(idNum);
            String id = 'P' + idNum;
            return id;
        } else return generateProjetId();
    }
    public void ajouteProjet(Projet projet){
        projet.setId(generateProjetId());
        projets.add(projet);
    }
    public void afficherListToutArticle(){
        int n = 0;
        for (Article article : articles) {
            n++;
            System.out.println(n + " . " + article);
        }
    }
    public  void afficherListToutOutil(){
        int n = 0;
        for (Outil outil : outils) {
            n++;
            System.out.println(n + " . " + outil);
        }
    }
    public void afficherListToutProjet(){
        int n = 0;
        for (Projet projet : projets) {
            n++;
            System.out.println(n + " . " + projet);
        }
    }
}