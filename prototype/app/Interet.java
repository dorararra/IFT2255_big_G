import java.util.ArrayList;

public class Interet {

    private String id;
    private String titre;
    private String description;
    private ArrayList<Equipier> membreSouscrit;
    private ArrayList<Activite> activiteSouscrit;

    /**
     *
     * @param interet
     */
    public Activite[] afficherActiviteAssocieInteret(String interet) {
        // TODO - implement Interet.afficherActiviteAssocieInteret
        int num = 0;
        for(Activite act : this.activiteSouscrit){
            num ++;
            System.out.print(num + "." + act.getTitre());

        }
        throw new UnsupportedOperationException();

    }

    /**
     *
     * @param interet
     */
    public Equipier[] afficherMembreAssocieInteret(String interet) {
        // TODO - implement Interet.afficherMembreAssocieInteret
        int num = 0;
        for(Equipier mem : this.membreSouscrit){
            num ++;
            System.out.print(num + "." + mem.getPrenom() + " " + mem.getNomDeFamille());
        }

        throw new UnsupportedOperationException();
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
}
}