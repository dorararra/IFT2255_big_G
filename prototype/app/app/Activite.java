import java.util.ArrayList;

public abstract class Activite {

	private String id;
	private String titre;
    private Equipier responsable;
	private ArrayList<Interet> interetsLie;
    private ArrayList<Equipier> membreSouscrit=new ArrayList<>();

    public Activite(String id,String titre,Equipier responsable, ArrayList<Interet> interetsLie){
        this.id = id;
        this.titre = titre;
        this.responsable = responsable;
        this.interetsLie = interetsLie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void getInteretsLie() {
        for (int i = 0;i<interetsLie.size();i++) {
            System.out.println ((i+1)+"."+interetsLie.get(i).getTitre());
        }
    }

    public ArrayList<Interet> getListInteretsLie(){
        return interetsLie;
    }

    public void addCollaborateurs(Equipier collaborateurs) {
    }
    public void getCollaborateurs(){
    }
    public ArrayList<Equipier> getListCollaborateurs(){
        return null;
    }
    public void supprimerCollaborateur(int i){

    }
    public void addMotcles(String motcle){

    }
    public void supprimerMotcle(int i){

    }


    public void addInteretsLie(Interet interetsLie) {
        this.interetsLie.add(interetsLie);
    }
    public void supprimerInteretLIe(int i){
        interetsLie.remove(i-1);
    }
    public void supprimerInteret(Interet interet){
        interetsLie.remove(interet);
    }

    public String getResponsable() {
        return (responsable.getPrenom()+" "+responsable.getNomDeFamille());
    }

    public void setResponsable(Equipier responsable) {
        this.responsable = responsable;
    }

    public void afficheFicheComplet() {
    }

    public ArrayList<String> getListMotcle() {
        return null;
    }
    public String getMotcle(){
        return null;
    }

    public ArrayList<Equipier> getMembreSouscrit() {
        return membreSouscrit;
    }

    public void addMembreSouscrit(Equipier equipier){
        this.membreSouscrit.add(equipier);
    }

    public void supprimerMembreSouscrit(Equipier equipier){
        this.membreSouscrit.remove(equipier);
    }

    public abstract void printInfoBasic();

}


