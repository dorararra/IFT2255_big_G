import java.io.Serializable;

public class ControleurEquipier implements Controller, Serializable {

	private RepertoireEquipier repertoire = new RepertoireEquipier();
	private Membre membreLogin;
	private Superviseur superviseurLogin;
	private Administrateur administrateurLogin;

	public int afficherProfilComplet() {
		// TODO - implement ControleurEquipier.afficherProfilComplet
		throw new UnsupportedOperationException();
	}

	public int afficherListMembre() {
		// TODO - implement ControleurEquipier.afficherListMembre
		repertoire.afficherListToutMembre();
		throw new UnsupportedOperationException();
	}

	public int login(String motDePasse, int equipierType) {
		if (equipierType == 0) {
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
		//pour tous les aures possibles, retourner -1
	}

	public void chercherEquipierParNom() {
		String nomComplet = "big G";                     //a modifier
		String[] nomliste = nomComplet.split(" ");
		String prenom = nomliste[0];
		String nom = nomliste[1];
		Equipier membre = repertoire.chercherMembre(prenom, nom);
		if (membre!=null){
			repertoire.afficherProfilComplet(membre);
		}else{
			String a="afficherinvalide"; //a modifier
		}
	}

	public int chercherEquipierParCourriel(String adresseCourriel) {
		return repertoire.chercherMembreParCourriel(adresseCourriel);


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



	@Override
	public Boolean isValid(String[] info) {
		return null;
	}
}
