import java.io.Serializable;

public class ControleurActivite {
    private Article article;
    private Outil outil;
    private Projet projet;

    private RepertoireActivite repertoire = new RepertoireActivite();

    public void ajouteArticle(){
        repertoire.ajouteArticle(article);
        System.out.println("Article a déjà ajouté");
        System.out.println("ID: "+article.getId());
    }
    public  void ajouteProjet(){
        repertoire.ajouteProjet(projet);
        System.out.println("Projet a déjà ajouté");
        System.out.println("ID: "+ projet.getId());
    }
    public  void ajouteOutil(){
        repertoire. ajouteOutil(outil);
        System.out.println("Outil a déjà ajouté ");
        System.out.println("ID: "+ outil.getId());
    }


    public void afficherListToutArticle() {
        repertoire.afficherListToutArticle();
    }
    public void afficherListToutOutil(){
        repertoire.afficherListToutOutil();
    }
    public void afficherListToutProjet(){
        repertoire.afficherListToutProjet();
    }
    public void chercherArticle(String titreOuAuteurOuMotcle){
        repertoire.chercherArticle(titreOuAuteurOuMotcle);

    }
    public void chercherProjet(String responsable){
        repertoire.chercherProjet(responsable);
    }
    public void afficheFicheCompletArticle(int i){
        repertoire.afficheFicheCompletArticle(i);
    }
    public void afficheFicheCompletOutil(int i){
        repertoire.afficheFicheCompletOutil(i);
    }
    public void afficheFicheCompletProjet(int i){
        repertoire.afficheFicheCompletProjet(i);
    }
    public Boolean articleSizeValide(int i){
        return repertoire.articleSizeValide(i);
    }
    public Boolean outilSizeValide(int i) {
        return repertoire.outilSizeValide(i);
    }
    public Boolean projetSizeValide(int i){
        return repertoire.projetSizeValide(i);
    }


}