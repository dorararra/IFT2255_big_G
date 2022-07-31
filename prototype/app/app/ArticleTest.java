import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArticleTest {
	private String id;
	private String titre;
	private Equipier responsable;
	private ArrayList<Interet> interetsLie;
	private String datePublication;
	private String lienPublication;
	private ArrayList<String> motcles;
	private articleStatus status;
	private String resume;
    private ArrayList<Equipier> auteurs;
    private ArrayList<Equipier> collaborateurs;
    private Article article;

	@Test
	void testAddMotcles() {
		ArrayList motcle = new ArrayList();
		motcle.add("motcleA");
		assertEquals(1,motcle.size());
		assertTrue(motcle.contains("motcleA"));
		
	}

	@Test
	void testArticle() { 
		assertEquals(id, this.id);
		assertEquals(titre, this.titre);
		assertEquals(resume,this.resume);
		assertEquals(lienPublication, this.lienPublication);
		assertEquals(datePublication, this.datePublication);
		assertEquals(status, this.status);
		assertEquals(responsable, this.responsable);
		assertEquals(auteurs, this.auteurs);
		assertEquals(collaborateurs, this.collaborateurs);
		assertEquals(motcles, this.motcles);
		assertEquals(interetsLie, this.interetsLie);
		}

	@Test
	void testGetDatePublication() {
		assertNull(datePublication);
	}

	@Test
	void testSetDatePublication() {
		assertEquals(datePublication, this.datePublication);
	}
	void testSupprimerMotcle(int i) {
		ArrayList motcle = new ArrayList();
		motcle.remove(i);
		assertFalse(motcle.contains(i));
	}
}
