import java.util.ArrayList;

public class Article extends Activite {

	private String datePublication;
	private String lienPublication;
	private ArrayList<String> motcles;
	private articleStatus status;
	private String resume;
    private ArrayList<Equipier> auteurs;
    private ArrayList<Equipier> collaborateurs;
    private Article article;

    public Article(String id, String titre,String resume,String lienPublication,String datePublication,articleStatus status,Equipier responsable,ArrayList<Equipier> auteurs,ArrayList<Equipier> collaborateurs ,ArrayList<String> motcles, ArrayList<Interet> interetsLie) {
        super(id, titre,responsable, interetsLie);
        this.datePublication = datePublication;
        this.lienPublication = lienPublication;
        this.motcles = motcles;
        this.status = status;
        this.resume = resume;
        this.auteurs = auteurs;
        this.collaborateurs = collaborateurs;

    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getLienPublication() {
        return lienPublication;
    }

    public void setLienPublication(String lienPublication) {
        this.lienPublication = lienPublication;
    }


    @Override
    public void supprimerMotcle(int i){
        motcles.remove(i-1);
    }

    public ArrayList<String> getMotcles() {
        return motcles;
    }

    public void addMotcles(String motcle) {
        this.motcles.add(new String(motcle));
    }

    public articleStatus getStatus() {
        return status;
    }

    public void setStatus(articleStatus status) {
        this.status = status;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }


    public ArrayList<Equipier> getAuteurs() {
        return auteurs;
        }


    public void addAuteur(Equipier auteur) {
        this.auteurs.add(auteur);

	}
    public void supprimerAuteur(Equipier auteur){
        for (int i = 0;i<this.auteurs.size();i++){
            if(this.auteurs.get(i).equals(auteur)){
                this.auteurs.remove(this.auteurs.get(i));
            }
            else{
                System.out.println("Cette personne n'est pas existe.");
            }
        }
    }
    public void getCollaborateurs() {
        for(int i = 0;i<collaborateurs.size();i++){
            System.out.println ((i+1)+"."+collaborateurs.get(i).getPrenom()+" "+ collaborateurs.get(i).getNomDeFamille());
        }
    }

    @Override
    public ArrayList<Equipier> getListCollaborateurs() {
        return collaborateurs;
    }
    @Override
    public void addCollaborateurs(Equipier collaborateurs) {
        this.collaborateurs.add(collaborateurs);
    }
    @Override
    public void afficheFicheComplet() {
        System.out.println("Titre: " + this.getTitre()+"\n"+"Résumé: " + this.getResume());
        System.out.println("Statut: "+this.getStatus());
        System.out.println("Responsable: "+this.getResponsable());

        System.out.print("Auteurs: ");
        ArrayList<Equipier> listAuteur = this.getAuteurs();
        for (int i = 0; i < listAuteur.size();i++) {
            if(i<listAuteur.size()-1) {
                System.out.print(listAuteur.get(i).getPrenom() +" "+ listAuteur.get(i).getNomDeFamille() + ", ");
            }else{
                System.out.println(listAuteur.get(i).getPrenom() +" "+ listAuteur.get(i).getNomDeFamille());
            }
        }
        System.out.print("Collaborateurs: ");
        ArrayList<Equipier> listCollaborateurs = this.getListCollaborateurs();
        if(listCollaborateurs.size() == 0){
            System.out.print("None\n");
        }
        else {
            for (int i = 0; i < listCollaborateurs.size(); i++) {
                if (i < listCollaborateurs.size() - 1) {
                    System.out.print(listCollaborateurs.get(i).getPrenom() + " " + listCollaborateurs.get(i).getNomDeFamille() + ", ");
                } else {
                    System.out.println(listCollaborateurs.get(i).getPrenom() + " " + listCollaborateurs.get(i).getNomDeFamille());
                }
            }
        }
        System.out.println("Date de Publication: "+this.getDatePublication() +"\n"+
                "Lien de Publication: "+this.getLienPublication()+"\n");
    }
    public ArrayList<String> getMotChercher() {
        ArrayList<String> motChercher = new ArrayList<String>();
        motChercher.addAll(motcles);
        motChercher.add(this.getTitre());
        for (int j = 0; j < this.auteurs.size(); j++) {
            motChercher.add(auteurs.get(j).getPrenom() + " " + auteurs.get(j).getNomDeFamille());
        }
        return motChercher;
    }
    @Override
    public String getMotcle(){
        for(int i = 0;i<motcles.size();i++){
            return ((i+1)+"."+motcles.get(i));
        }
        return null;

    }
    @Override
    public ArrayList<String> getListMotcle(){
        return motcles;
    }

    public void printInfoBasic(){

        System.out.print(super.getTitre() + "    ");
        System.out.print("Auteurs: ");
        ArrayList<Equipier> listAuteur = this.getAuteurs();
        for (int i = 0; i < listAuteur.size();i++) {
            System.out.print(listAuteur.get(i).getPrenom() + " " + listAuteur.get(i).getNomDeFamille() + "  ");
        }
        System.out.print("    " + "Statut: "+this.getStatus());
        System.out.println("    " + this.getDatePublication());
    }
}