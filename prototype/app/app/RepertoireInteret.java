import java.util.ArrayList;

public class RepertoireInteret {

	private ArrayList<Interet> interets = new ArrayList<>() ;
    public void ajouterInteret(Interet interet){
        interets.add(interet);
    }
    public ArrayList<Interet> getListeInteret(){
        return interets;
    }
    public void afficherListeInteret(){
        int n=0;
        for(Interet interet:interets){
            n++;
            System.out.println(n + ". " + interet.getTitre());
        }
    }
    public void supprimerInteret(Interet interet){
        this.interets.remove(interet);
    }

}