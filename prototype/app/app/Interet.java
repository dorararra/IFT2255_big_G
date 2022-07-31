import java.util.ArrayList;

public class Interet{

    private String id;
    private String titre;
    private String description;
    private ArrayList<Equipier> membreSouscrit=new ArrayList<>();
    private ArrayList<Activite> activiteSouscrit=new ArrayList<>();

    public Interet(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public void afficherActiviteAssocieInteret() {
        // TODO - implement Interet.afficherActiviteAssocieInteret
        int num = 0;
        for (Activite act : this.activiteSouscrit) {
            num++;
            System.out.print(num + ". ");
            act.printInfoBasic();
        }
    }

    public ArrayList<Activite> getActiviteSouscrit(){
        return this.activiteSouscrit;
    }

    public ArrayList<Equipier> getMembreSouscrit() {
        return membreSouscrit;
    }

    public void afficherMembreAssocieInteret() {
        // TODO - implement Interet.afficherMembreAssocieInteret
        int num = 0;
        for(Equipier mem : this.membreSouscrit){
            num ++;
            System.out.print(num + ". " + mem.getPrenom() + " " + mem.getNomDeFamille() + "     " + mem.getAdresseCourriel()
                    + "    " + mem.getNumeroDeTele());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setMembreSouscrit(Equipier equipier){
        this.membreSouscrit.add(equipier);
    }
    public void setActiviteSouscrit(Activite activite){
        this.activiteSouscrit.add(activite);
    }
    public void supprimerMembreSouscrit(Equipier equipier){
        this.membreSouscrit.remove(equipier);
    }
    public void supprimerActiviteSouscrit(Activite activite){
        this.activiteSouscrit.remove(activite);
    }
}
