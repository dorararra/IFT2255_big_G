import java.util.ArrayList;

public class RepertoireOutil extends Repertoire {
    private ArrayList<Outil> outils = new ArrayList<>();

    public void ajouter(Activite activite){
        Outil outil = (Outil) activite;
        outil.setId(generateId());
        outils.add(outil);
    }

    public void supprimer(Activite activite) {
        Outil outil = (Outil) activite;
        outils.remove(outil);
    }

    public Outil chercherParNum(int i){
        Outil outil = outils.get(i-1);
        return outil;
    }

    public ArrayList getActivites(){
        ArrayList activites = this.outils;
        return activites;
    }
}