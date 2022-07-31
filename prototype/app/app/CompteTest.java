import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompteTest {
	private String adresseCourriel;
	private String motDePasse;
	private CompteStatus status;
	private Equipier membre;
	private Role role;
	private String numCompte;

	@Test
	void testCompte() {
		assertEquals(adresseCourriel, this.adresseCourriel);
		assertEquals(motDePasse, this.motDePasse);
		assertEquals(status, this.status);
		assertEquals(membre, this.membre);
		assertEquals(role, this.role);
		assertEquals(numCompte,this.numCompte);
	}

	@Test
	void testSetRole() {
		assertEquals(role, this.role);
	}

	@Test
	void testSetMembre() {
		assertEquals(membre, this.membre);
	}

	@Test
	void testSetStatus() {
		assertEquals(status, this.status);
	}

}
