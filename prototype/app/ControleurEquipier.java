import java.io.Serializable;

public class ControleurEquipier implements Controller, Serializable{

	private RepertoireEquipier repertoire;
	private Membre membreLogin;
	private Superviseur superviseurLogin;
	private Administrateur administrateurLogin;

	public int afficherProfilComplet() {
		// TODO - implement ControleurEquipier.afficherProfilComplet
		throw new UnsupportedOperationException();
	}

	public int afficherListMembre() {
		// TODO - implement ControleurEquipier.afficherListMembre
		throw new UnsupportedOperationException();
	}

	public int login(String motDePasse, int equipierType) {
		if (equipierType == 0) {
			if (membreLogin.getMotDePasse().equals(motDePasse)) {
				return 0;
			}
		} else if (equipierType == 1) {
			if (administrateurLogin.getMotDePasse().equals(motDePasse)) {
				return 1;
			}
		} else {
			if (superviseurLogin.getMotDePasse().equals(motDePasse)) {
				return 2;
			}
			return -1;
		}

		public int chercherEquipier(String codeId){

			for (int i=0;i < repertoire.membres.size();i++) {
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

		}
	}

	@Override
	public Boolean isValid(String[] info) {
		return null;
	}
}
