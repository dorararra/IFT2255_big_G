import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ControleurEquipier {

	private RepertoireEquipier repertoire = new RepertoireEquipier();
	private Equipier equipierLog;

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

	public void afficherListMembre() {
		// TODO - implement ControleurEquipier.afficherListMembre
		repertoire.afficherListToutMembre();

	}

	public boolean login(String motDePasse, Equipier equipier) {
    	this.equipierLog=equipier;
    	String eId = equipier.getId();
		char fir = eId.charAt (0);
		int equipierType = Character.getNumericValue(fir);
		if(equipierLog.getCompte().getMotDePasse().equals(motDePasse)){
			return true;
		}
		//pour tous les autres possibles, retourner -1
		return false;
	}

	public boolean chercherEquipierParNom(String prenom ,String nom) {

		Equipier membre = repertoire.chercherMembre(prenom, nom);
		if (membre!=null){
			repertoire.afficherProfilComplet(membre);
			return true;
		}else{
			return false;
		}
	}

	public Equipier chercherEquipierParCourriel(String adresseCourriel) {
		return repertoire.chercherMembreParCourriel(adresseCourriel);
	}

	public void ajouterMembre(Membre membre){
		repertoire.ajouterMembre(membre);
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

	public void setEquipierLog(Equipier equipierLog) {
		this.equipierLog = equipierLog;
	}

	/*for (int i=0;i < repertoire.membres.size();i++) {
                        if (repertoire.membres.get(i).getCodeIdentification().equals(codeId)) {
                            membreLogin = repertoire.membres.get(i);
                            return 0;
                        }
                    }
                    for (int i=0;i < repertoire.superviseurs.size();i++) {
                        if (repertoire.superviseurs.get(i).getCodeIdentification().equals(codeId)) {
                            superviseurLogin = repertoire.superviseurs.get(i);
                            return 1;
                        }
                    }
                    for (int i=0;i < repertoire.administrateurs.size();i++) {
                        if (repertoire.administrateurs.get(i).getCodeIdentification().equals(codeId)) {
                            administrateurLogin = repertoire.administrateurs.get(i);
                            return 1;
                        }
                    }
                    return -1;

                     */
	public void setRepertoire(RepertoireEquipier repertoire) {
		this.repertoire = repertoire;
	}


}
