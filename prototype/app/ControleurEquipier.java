import java.io.Serializable;
import java.util.HashMap;

public class ControleurEquipier {

	private RepertoireEquipier repertoire = new RepertoireEquipier();
	private Membre membreLogin;
	private Superviseur superviseurLogin;
	private Administrateur administrateurLogin;

	public boolean afficherProfilComplet(int num) {
		// TODO - implement ControleurEquipier.afficherProfilComplet
		if(num>repertoire.getEquipier().size() || num<0) {
            System.out.println("invalide");
			return false;
		}else{
			Equipier membrecherche = repertoire.getEquipier().get(num);
			repertoire.afficherProfilComplet(membrecherche);
			return true;
		}
	}

	public void afficherListMembre() {
		// TODO - implement ControleurEquipier.afficherListMembre
		repertoire.afficherListToutMembre();

	}

	public int login(String motDePasse, Equipier equipier) {
		 String eId = equipier.getId();
		char fir = eId.charAt (0);
		int equipierType = Character.getNumericValue(fir);

		if (equipierType == 0) {
			this.membreLogin = (Membre)equipier;
			if (membreLogin.getCompte().getMotDePasse().equals(motDePasse)) {
				return 0;
			}
		} else if (equipierType == 1) {
			if (administrateurLogin.getCompte().getMotDePasse().equals(motDePasse)) {
				return 1;
			}
		} else {
			if (superviseurLogin.getCompte().getMotDePasse().equals(motDePasse)) {
				return 2;
			}
		}
		return -1;
		//pour tous les autres possibles, retourner -1
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

	public Membre getMembreLogin() {
		return membreLogin;
	}

	public void setMembreLogin(Membre membreLogin) {
		this.membreLogin = membreLogin;
	}

	public Superviseur getSuperviseurLogin() {
		return superviseurLogin;
	}

	public void setSuperviseurLogin(Superviseur superviseurLogin) {
		this.superviseurLogin = superviseurLogin;
	}

	public Administrateur getAdministrateurLogin() {
		return administrateurLogin;
	}

	public void setAdministrateurLogin(Administrateur administrateurLogin) {
		this.administrateurLogin = administrateurLogin;
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
