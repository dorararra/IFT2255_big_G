import java.util.ArrayList;

public abstract class Repertoire {
    private ArrayList<Activite> activites = new ArrayList<>();
    private ArrayList<String> tousLesID = new ArrayList<>();
    private String generateIDNumber() {
        String IdNum = String.valueOf(tousLesID.size());
        return  IdNum;
    }

    public String generateId() {
        String idNum = generateIDNumber();
        {
            this.tousLesID.add(idNum);
            String id = 'A' + idNum;
            return id;
        }
    }

    public abstract void ajouter(Activite activite);
    public abstract void supprimer(Activite activite);

    public void afficherListe() {
        ArrayList<Article> arrayList = this.getActivites();
        int n = 0;
        for (Activite activite : arrayList) {
            n++;
            print(n,activite);
        }
    }

    public void print(int n,Activite activite){
        System.out.print(n + ". ");
        activite.printInfoBasic();
    }




    public abstract ArrayList getActivites();

}





/*
    //chaque ID compose 1 lettre et 6 chiffre
    private String generateIDNumber() {
        String IdNum = String.valueOf(tousLesID.size());
        return  IdNum;
    }

    public String generateId() {
        String idNum = generateIDNumber();
        {
            this.tousLesID.add(idNum);
            String id = 'A' + idNum;
            return id;
        }
    }

    public abstract void ajouter(Activite activite);


    public void ajouteOutil(Outil outil) {
        outil.setId(generateOutilId());
        outils.add(outil);
    }

    public String generateProjetId() {
        String idNum = generateIDNumber();
        {
            this.tousLesID.add(idNum);
            String id = 'P' + idNum;
            return id;
        }
    }

    public void ajouteProjet(Projet projet) {
        projet.setId(generateProjetId());
        projets.add(projet);
    }

    public void afficherListToutArticle() {
        int n = 0;
        for (Article article : articles) {
            n++;
            System.out.print(n + ". " + article.getTitre()+"   ");
            System.out.print("Auteurs: ");
            ArrayList<Equipier> listAuteur = article.getAuteurs();
            for (int i = 0; i < listAuteur.size();i++) {
                if(i<listAuteur.size()-1) {
                    System.out.print(listAuteur.get(i).getPrenom() +" "+ listAuteur.get(i).getNomDeFamille() + ", ");
                }else{
                    System.out.print(listAuteur.get(i).getPrenom() +" "+ listAuteur.get(i).getNomDeFamille());
                }
            }

            System.out.print("  Status: "+article.getStatus());
            System.out.println("    " + article.getDatePublication());
        }
    }

    public void afficherListToutOutil() {
        int n = 0;
        for (Outil outil : outils) {
            n++;
            System.out.println(n + ". " + outil.getTitre()+"    "+outil.getVersion()+"    "+outil.getResponsable()
                    +"    "+outil.getCollaborateurs());
        }
    }

    public void afficherListToutProjet() {
        int n = 0;
        for (Projet projet : projets) {
            n++;
            System.out.println(n + " . " + projet.getTitre()+"    "+projet.getResponsable());
        }
    }

    public int chercherArticle(String titreOuAuteurOuMotcle) {
        // article relatif
        ArrayList<Article> articleRelatif = new ArrayList<>();

            for (int i = 0; i < articles.size(); i++) {
                if (String.valueOf(articles.get(i).getTitre()).equals(titreOuAuteurOuMotcle)  ) {
                    articleRelatif.add(articles.get(i));
                }
                for (int j = 0; j < articles.get(i).getAuteurs().size(); j++) {
                    if (String.valueOf(articles.get(i).getAuteurs().get(j).getPrenom()+" "+articles.get(i).getAuteurs().get(j).getNomDeFamille()).equals(titreOuAuteurOuMotcle)){
                        articleRelatif.add(articles.get(i));
                    }
                }

                for (int w = 0; w < articles.get(i).getMotcles().size(); w++) {
                    if (String.valueOf(articles.get(i).getMotcles().get(w)).equals(titreOuAuteurOuMotcle)){
                        articleRelatif.add(articles.get(i));
                    }
                }
            }
        for (Article article : articleRelatif) {
            article.afficheFicheComplet();
        }
            return articleRelatif.size();
    }

    public int chercherProjet(String responsable){
        // projet relatif
        ArrayList<Projet>projetRelatif = new ArrayList<>();
        for(Projet projet : projets){
            if((String.valueOf(projet.getResponsable()).equals(responsable))){
                projetRelatif.add(projet);

            }
           for(Projet projetrelatif : projetRelatif){
               projetrelatif.afficheFicheComplet();
           }

        }
        return projetRelatif.size();
    }

    public Boolean sizeValide(int type, int i){
        if (type==1) {
            if (i > 0 && i <= articles.size()) {
                return true;
            }
            return false;
        }else if (type==2) {
            if (i > 0 && i <= outils.size()) {
                return true;
            }
            return false;
        }else {
            if (i > 0 && i <= projets.size()) {
                return true;
            }
            return false;
        }
    }


    public void afficheFicheComplet(int type, int i){
        if(type == 1) {
            Article article = articles.get(i - 1);
            article.afficheFicheComplet();
        } else if(type == 2) {
            Outil outil = outils.get(i-1);
            outil.afficheFicheComplet();
        }else {
            Projet projet = projets.get(i-1);
            projet.afficheFicheComplet();
        }
    }



    public ArrayList<Article> getArticle(){
        return  articles;
    }

}
*/