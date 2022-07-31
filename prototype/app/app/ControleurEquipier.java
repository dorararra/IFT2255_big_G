import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ControleurEquipier {

	private RepertoireEquipier repertoire = new RepertoireEquipier();
	private Equipier equipierLog;

	public void afficherInscrireInteret(){
		int n = 0;
		ArrayList<Interet> inscrireInteret = this.getEquipierLog().getInscrireInteret_();
		for (Interet interet : inscrireInteret) {
			n++;
			System.out.println(n+". " + interet.getTitre());
		}
	}
	public void afficherInscrireActivite(){
		int n = 0;
		ArrayList<Activite> inscrireActivite = this.getEquipierLog().getInscrireActivite_();
		for (Activite activite :inscrireActivite){
			n++;
			System.out.println(n+". " + activite.getTitre());
		}
	}

	public boolean afficherProfilComplet(int num) {
		// TODO - implement ControleurEquipier.afficherProfilComplet
		if(num>repertoire.getEquipier().size() || num<0) {
			return false;
		}else{
			Equipier membrecherche = repertoire.getEquipier().get(num-1);
			repertoire.afficherProfilComplet(membrecherche);
			return true;
		}
	}

	public void afficherListMembre(int n) {
		// TODO - implement ControleurEquipier.afficherListMembre
		repertoire.afficherListToutMembre(n);
	}
    public boolean pagePrecedent(){
        return repertoire.pagePrecedent();
    }



	public boolean chercherEquipierParNom(String prenomOuNomOuInteret) {

		int membre = repertoire.chercherMembre(prenomOuNomOuInteret);
		if (membre>0){
			return true;
		}else{
			return false;
		}
	}
    public int getEquipierSize(){
       return repertoire.getEquipierSize();
    }




	public void ajouterMembre(Equipier membre){
		repertoire.ajouterMembre(membre);
	}
	public void supprimerMembre(Equipier membre){
		repertoire.supprimerMembre(membre);
	}


    public void ajouterAuteur(Membre auteur){ repertoire.ajouterAuteur(auteur);}
    public void ajouterCollaborateur(Membre collaborateur){repertoire.ajouterCollaborateur(collaborateur);}
    public ArrayList<Equipier> getAuteurs(){
        ArrayList<Equipier> auteurs = repertoire.getAuteurs();
        return auteurs;

    }
    public ArrayList<Equipier> getCollaborateurs(){
        ArrayList<Equipier> collaborateurs = repertoire.getCollaborateurs();
        return  collaborateurs;
    }

	public RepertoireEquipier getRepertoire() {
		return repertoire;
	}

	public Equipier getEquipierLog() {
		return equipierLog;
	}

	public Equipier getEquipierTrouve(int n){
		return repertoire.getEquipierTrouve(n);
	}
	public void setEquipierLog(Equipier equipierLog) {
		this.equipierLog = equipierLog;
	}


	public void setRepertoire(RepertoireEquipier repertoire) {
		this.repertoire = repertoire;
	}


}
