import java.util.ArrayList;

public class Projet extends Activite{

    private String dateDeDebut;
    private String dateDeFin;
    private Equipier responsable;
    private String description;


    public Projet(String id, String titre,String description, String dateDeDebut, String dateDeFin,Equipier responsable,ArrayList<Interet> interetsLie ) {
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

    public Equipier getResponsable() {
        return responsable;
    }

    public void setResponsable(Equipier responsable) {
        this.responsable = responsable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void afficheFicheComplet(){
        System.out.println("Titre: "+this.getTitre()+"\n"+"Description: "+ this.getDescription()+"\n"+
                "Période: "+this.getDateDeDebut()+"--"+this.getDateDeFin()+"\n" + "Responsable: "+this.getResponsable()+"\n");
    }
}
