import java.util.ArrayList;
import java.util.Random;

public class RepertoireActivite {
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Outil> outils = new ArrayList<>();
    private ArrayList<Projet> projets = new ArrayList<>();
    private ArrayList<String> tousLesID = new ArrayList<>();

    //chaque ID compose 1 lettre et 6 chiffre
    private String generate6Chiffre() {
        Random rand = new Random();
        String num = "";
        for (int i = 0; i < 6; i++) {
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

    public void ajouteArticle(Article article) {
        article.setId(generateArticleId());
        articles.add(article);
    }

    public String generateOutilId() {
        String idNum = generate6Chiffre();
        if (!tousLesID.contains(idNum)) {
            this.tousLesID.add(idNum);
            String id = 'O' + idNum;
            return id;
        } else return generateOutilId();
    }


    public void ajouteOutil(Outil outil) {
        outil.setId(generateOutilId());
        outils.add(outil);
    }

    public String generateProjetId() {
        String idNum = generate6Chiffre();
        if (!tousLesID.contains(idNum)) {
            this.tousLesID.add(idNum);
            String id = 'P' + idNum;
            return id;
        } else return generateProjetId();
    }

    public void ajouteProjet(Projet projet) {
        projet.setId(generateProjetId());
        projets.add(projet);
    }

    public void afficherListToutArticle() {
        int n = 0;
        for (Article article : articles) {
            n++;
            System.out.println(n + " . " + article);
        }
    }

    public void afficherListToutOutil() {
        int n = 0;
        for (Outil outil : outils) {
            n++;
            System.out.println(n + " . " + outil);
        }
    }

    public void afficherListToutProjet() {
        int n = 0;
        for (Projet projet : projets) {
            n++;
            System.out.println(n + " . " + projet);
        }
    }

    public void chercherArticle(String titreOuAuteurOuMotcle) {
        // article relatif
        ArrayList<Article> articleRelatif = new ArrayList<>();
        for (Article article : articles) {
            if (titreOuAuteurOuMotcle == article.getTitre() || article.getAuteurs().contains(titreOuAuteurOuMotcle)
                    || article.getMotcles().contains(titreOuAuteurOuMotcle)) {
                articleRelatif.add(article);
            }
            if (articleRelatif.size() != 0) {
                for (int j = 0; j < articleRelatif.size(); j++) {
                    System.out.println(j + 1 + " . " + articleRelatif.get(j).getTitre() + " " + articleRelatif.get(j).getAuteurs() +
                            articleRelatif.get(j).getDatePublication());

                }
            } else {
                System.out.println("Rien à afficher.");
            }
        }

    }
    public void chercherProjet(String responsable){
        // projet relatif
        ArrayList<Projet>projetRelatif = new ArrayList<>();
        for(Projet projet : projets){
            if(responsable == (projet.getResponsable().getPrenom()+" "+projet.getResponsable().getNomDeFamille())){
                projetRelatif.add(projet);

            }
        }
    }
}