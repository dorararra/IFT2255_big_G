public class Compte {

	private String adresseCourriel;
	private String motDePasse;
	private CompteStatus status;
	private Equipier membre;
	private Role role;
	private String numCompte;


    public Compte(String adresseCourriel, String motDePasse, CompteStatus status, Equipier membre, Role role, String numCompte) {
        this.adresseCourriel = adresseCourriel;
        this.motDePasse = motDePasse;
        this.status = status;
        this.membre = membre;
        this.role = role;
        this.numCompte = numCompte;
    }

    public String getAdresseCourriel() {
        return adresseCourriel;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Equipier getMembre() {
        return membre;
    }

    public void setMembre(Equipier membre) {
        this.membre = membre;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setAdresseCourriel(String adresseCourriel) {
        this.adresseCourriel = adresseCourriel;
    }

    public CompteStatus getStatus() {
        return status;
    }

    public void setStatus(CompteStatus status) {
        this.status = status;
    }
}