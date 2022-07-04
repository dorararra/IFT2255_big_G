import java.util.ArrayList;

public class RepertoireInteret {

	private ArrayList<Interet> interets = new ArrayList<>() ;
    public void ajouterInteret(Interet interet){
        interets.add(interet);
    }
    public ArrayList<Interet> getListeInteret(){
        return interets;
    }

}