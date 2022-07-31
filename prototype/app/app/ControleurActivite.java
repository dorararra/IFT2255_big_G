import java.util.ArrayList;

public class ControleurActivite {

    private RepertoireArticle repertoireArticle = new RepertoireArticle();
    private RepertoireOutil repertoireOutil = new RepertoireOutil();
    private RepertoireProjet repertoireProjet = new RepertoireProjet();
    private Article article;
    private Outil outil;
    private Projet projet ;
    private Equipier auteur;

    public void ajouteArticle(Article article) {
        repertoireArticle.ajouter(article);
    }

    public void ajouteOutil(Outil outil) {
        repertoireOutil.ajouter(outil);
    }

    public void ajouteProjet(Projet projet) {
        repertoireProjet.ajouter(projet);
    }

    public Article chercherParNumArticle(int i){
        return repertoireArticle.chercherParNum(i);
    }

    public Outil chercherParNumOutil(int i){
        return repertoireOutil.chercherParNum(i);
    }

    public Projet chercherParNumProjet(int i){
        return repertoireProjet.chercherParNum(i);
    }

    public void afficherListToutActivite(int type) {
        if (type == 1) {
            repertoireArticle.afficherListe();
        } else if (type == 2) {
            repertoireOutil.afficherListe();
        } else if (type == 3) {
            repertoireProjet.afficherListe();
        }
    }
/*

 */
    public ArrayList<Article> chercher(String titreOuAuteurOuMotcle){
    // sum of article relatif
        return repertoireArticle.chercher(titreOuAuteurOuMotcle);
}

    public Activite afficheFicheComplet(int type, int i){
        if(type == 1) {
            Article article = (Article) repertoireArticle.getActivites().get(i - 1);
            article.afficheFicheComplet();
            return article;
        } else if(type == 2) {
            Outil outil = (Outil) repertoireOutil.getActivites().get(i - 1);
            outil.afficheFicheComplet();
            return outil;
        }else if (type == 3) {
            Projet projet = (Projet) repertoireProjet.getActivites().get(i - 1);
            projet.afficheFicheComplet();
            return projet;
        }else{
            return null;
        }
    }

    public Boolean sizeValide(int type, int i) {
        if (type==1) {
            if (i > 0 && i <= repertoireArticle.getActivites().size()) {
                return true;
            }
            return false;
        }else if (type==2) {
            if (i > 0 && i <= repertoireOutil.getActivites().size()) {
                return true;
            }
            return false;
        }else{
            if (i > 0 && i <= repertoireProjet.getActivites().size()) {
                return true;
            }
            return false;
        }
    }

    public void setRepertoire(RepertoireArticle repertoireArticle,RepertoireOutil repertoireOutil,RepertoireProjet repertoireProjet){
        this.repertoireArticle = repertoireArticle;
        this.repertoireOutil = repertoireOutil;
        this.repertoireProjet = repertoireProjet;
    }
    public void supprimerActivite(Activite activite){
        if(Article.class.isInstance(activite)) {
            repertoireArticle.supprimer(activite);
        }else if(Outil.class.isInstance(activite)){
            repertoireOutil.supprimer(activite);
        }else if(Projet.class.isInstance(activite)){
            repertoireProjet.supprimer(activite);
        }
        for (Interet interet: activite.getListInteretsLie()){
            interet.supprimerActiviteSouscrit(activite);
        }
        for (Equipier equipier: activite.getMembreSouscrit()){
            equipier.modifierListeActivite(activite);
        }
    }
}