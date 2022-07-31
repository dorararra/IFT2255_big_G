import java.util.ArrayList;

public class RepertoireProjet extends Repertoire{
    private ArrayList<Projet> projets = new ArrayList<>();

    public void ajouter(Activite activite){
        Projet projet = (Projet) activite;
        projet.setId(generateId());
        projets.add(projet);
    }

    public void supprimer(Activite activite) {
        Projet projet = (Projet) activite;
        projets.remove(projet);
    }

    public Projet chercherParNum(int i) {
        Projet projet = projets.get(i-1);
        return projet;

    }

    public ArrayList getActivites(){
        ArrayList activites = this.projets;
        return activites;
    }
}
