import java.io.Serializable;
import java.util.ArrayList;

public class ControleurActivite {

    private RepertoireActivite repertoire = new RepertoireActivite();
    private Article article;
    private Outil outil;
    private Projet projet;

    public void ajouteArticle(Article article){repertoire.ajouteArticle(article);}
    public void ajouteOutil(Outil outil){
        repertoire. ajouteOutil(outil);
    }
    public void ajouteProjet(Projet projet){
        repertoire.ajouteProjet(projet);
    }

    public void afficherListToutActivite(int type) {
        if (type==1) {
            repertoire.afficherListToutArticle();
        }else if (type==2) {
            repertoire.afficherListToutOutil();
        }else{
            repertoire.afficherListToutProjet();
        }
    }
    public void afficherListToutOutil(){
        repertoire.afficherListToutOutil();
    }
    public void afficherListToutProjet(){
        repertoire.afficherListToutProjet();
    }

    public boolean chercherArticle(String titreOuAuteurOuMotcle){
        // sum of article relatif
         int total =  repertoire.chercherArticle(titreOuAuteurOuMotcle);
         if(total>0){
             return  true;
         }
         else{
             return  false;
         }
    }
    public boolean chercherProjet(String responsable){
        int total = repertoire.chercherProjet(responsable);
        if(total>0){
            return true;
        }
        else{
            return false;
        }
    }

    public void afficheFicheComplet(int type, int i){repertoire.afficheFicheComplet(type,i);}


    /*public void afficheFicheCompletOutil(int i){
        repertoire.afficheFicheCompletOutil(i);
    }
    public void afficheFicheCompletProjet(int i){
        repertoire.afficheFicheCompletProjet(i);
    }

     */

    public Boolean sizeValide(int type, int i){
        return repertoire.sizeValide(type, i);
    }
   /* public Boolean outilSizeValide(int i) {
        return repertoire.outilSizeValide(i);
    }
    public Boolean projetSizeValide(int i){
        return repertoire.projetSizeValide(i);
    }


    */
    public void setRepertoire(RepertoireActivite repertoire){this.repertoire = repertoire;}
}