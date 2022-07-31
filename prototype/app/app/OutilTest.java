import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class OutilTest {
	private String id;
	private String titre;
	private Equipier responsable;
	private String version;
    private String lienRepertoire;
    private ArrayList<Equipier> equipiers = new ArrayList<>();
    private ArrayList<Equipier> collaborateurs = new ArrayList<>();
    private ArrayList<Equipier> auteurs = new ArrayList<>();
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Interet> interetsLie = new ArrayList<>();
    private ArrayList<String> motcles = new ArrayList<>();
    private String description;

	@Test
	void testSupprimerCollaborateur() {
		ArrayList <Equipier> collaborateur = new ArrayList<>();
		collaborateur.remove("collaborateurA");
		assertFalse(collaborateur.contains("collaborateurA"));
	}

	@Test
	void testOutil() {
		assertEquals(version, this.version);
		assertEquals(lienRepertoire, this.lienRepertoire);
		assertEquals(collaborateurs, this.collaborateurs);
		assertEquals(description, this.description);
		assertEquals(motcles, this.motcles);
	}

	@Test
	void testAddCollaborateur() {
		ArrayList collaborateur = new ArrayList();
		collaborateur.add("collaborateurA");
		assertEquals(1, collaborateur.size());
		assertTrue(collaborateur.contains("collaborateurA"));
	}

}
