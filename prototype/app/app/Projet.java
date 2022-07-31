import java.util.ArrayList;

public class Projet extends Activite{

    private String dateDeDebut;
    private String dateDeFin;
    private String description;


    public Projet(String id, String titre,String description, String dateDeDebut, String dateDeFin,Equipier responsable,ArrayList<Interet> interetsLie ) {
        super(id,titre,responsable, interetsLie);
        this.dateDeDebut = dateDeDebut;
        this.dateDeFin = dateDeFin;

        this.description = description;

    }

    public String getDateDeDebut(){
        return dateDeDebut;
    }
    public void setDateDeDebut(String dateDeDebut){
        this.dateDeDebut = dateDeDebut;
    }
    public String getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(String dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void afficheFicheComplet(){
        System.out.println("Nom: "+this.getTitre()+"\n"+"Description: "+ this.getDescription()+"\n"+
                "Période: "+this.getDateDeDebut()+" -- "+this.getDateDeFin()+"\n" + "Responsable: "+this.getResponsable()+"\n");
    }
    @Override
    public void printInfoBasic(){
        System.out.println( this.getTitre()+"    "+this.getResponsable());
    }
}
