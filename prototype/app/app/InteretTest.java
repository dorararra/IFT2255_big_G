import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class InteretTest {
	private String id;
    private String titre;
    private String description;
    private ArrayList<Equipier> membreSouscrit=new ArrayList<>();
    private ArrayList<Activite> activiteSouscrit=new ArrayList<>();

	@Test
	void testInteret() {
		assertEquals(titre, this.titre);
		assertEquals(description, this.description);
	}

	@Test
	void testSetId() {
		assertEquals(id ,this.id);
	}

	@Test
	void testSetTitre() {
		assertEquals(titre, this.titre);
	}

}
