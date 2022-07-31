import java.util.ArrayList;

public class Outil extends Activite {

    private String version;
    private String lienRepertoire;

    private ArrayList<Equipier> equipiers = new ArrayList<>();
    private ArrayList<Equipier> collaborateurs = new ArrayList<>();
    private ArrayList<Equipier> auteurs = new ArrayList<>();
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Interet> interetsLie = new ArrayList<>();
    private ArrayList<String> motcles = new ArrayList<>();
    private String description;
    public  Outil(String id,String titre,String description,String version,String lienRepertoire,  Equipier responsable,ArrayList<Equipier> collaborateurs,
                  ArrayList<String> motcles ,ArrayList<Interet> interetsLie){
        super(id, titre,responsable, interetsLie);
        this.version = version;
        this.lienRepertoire =lienRepertoire;
        this.collaborateurs = collaborateurs;
        this.description = description;
        this.motcles = motcles;




    }





    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLienRepertoire() {
        return lienRepertoire;
    }

    public void setLienRepertoire(String lienRepertoire) {
        this.lienRepertoire = lienRepertoire;
    }


    public ArrayList<Equipier> getEquipiers() {
        return equipiers;
    }

    public void addEquipiers( Equipier equipier) {
        this.equipiers.add(equipier);
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }



    public ArrayList<Interet> getInteretLie() {
        return interetsLie;
    }

    public void addInteretLie(Interet interetLie) {
        this.interetsLie.add(interetLie);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getCollaborateurs() {
        for(int i = 0;i<collaborateurs.size();i++){
            System.out.println ((i+1)+"."+collaborateurs.get(i).getPrenom()+" "+ collaborateurs.get(i).getNomDeFamille());
        }

    }
    public ArrayList<Equipier> getListCollaborateurs(){
        return collaborateurs;
    }
    public void addCollaborateur(Equipier collaborateur){this.collaborateurs.add(collaborateur);}
    public void supprimerCollaborateur(int i){
        this.collaborateurs.remove(i-1);

    }



    public String getMotcle(){
        for(int i = 0;i<motcles.size();i++){
            return ((i+1)+"."+motcles.get(i));
        }
        return null;

    }
    public void supprimerMotcle(int i){
        motcles.remove(i-1);
    }
    public ArrayList<String> getListMotcle(){
        return motcles;
    }


    public void addMotcles(String motcles) {
        this.motcles.add(motcles);
    }

    @Override
    public void afficheFicheComplet(){
        System.out.println("Nom: "+this.getTitre()+"\n"+ "Description: "+this.getDescription()+"\n"+ "Version: "+ this.getVersion()+"\n"+"Responsable: "+this.getResponsable()
                +"\n"+ "Collaborateurs: ");
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

        System.out.println("Lien du Répertoire: "+ this.getLienRepertoire()+"\n");
    }
    @Override
    public void printInfoBasic(){
        System.out.println( this.getTitre()+"    "+this.getVersion()+"    "+this.getResponsable());
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
    }
}