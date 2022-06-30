import java.util.ArrayList;

public class Projet extends Activite{

    private String dateDeDebut;
    private String dateDeFin;
    private Superviseur responsable;
    private String description;

    public Projet(String id, String titre, ArrayList<Interet> interetsLie,String dateDeDebut, String dateDeFin, Superviseur responsable, String description) {
        super(id,titre,interetsLie);
        this.dateDeDebut = dateDeDebut;
        this.dateDeFin = dateDeFin;
        this.responsable = responsable;
        this.description = description;
    }

    public String getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(String dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public String getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(String dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public Superviseur getResponsable() {
        return responsable;
    }

    public void setResponsable(Superviseur responsable) {
        this.responsable = responsable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void afficheFicheComplet(Activite activite){
        System.out.println("Titre: "+this.getTitre()+"Description: "+ this.getDescription()+
                "Période: "+this.getDateDeDebut()+"--"+this.getDateDeFin() + "Responsable: "+this.getResponsable());
    }
}
