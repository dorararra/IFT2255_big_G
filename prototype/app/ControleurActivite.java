import java.io.Serializable;

public class ControleurActivite implements Serializable, Controller {
	private Article article;
	private Outil outil;
	private Projet projet;

	private RepertoireActivite repertoire = new RepertoireActivite();

	public void ajouteArticle(){
		repertoire.ajouteArticle(article);
		System.out.println("Article a déjà ajouté");
		System.out.println("ID: "+article.getId());
	}
	public  void ajouteProjet(){
		repertoire.ajouteProjet(projet);
		System.out.println("Projet a déjà ajouté");
		System.out.println("ID: "+ projet.getId());
	}
	public  void ajouteOutil(){
		repertoire. ajouteOutil(outil);
		System.out.println("Outil a déjà ajouté ");
		System.out.println("ID: "+ outil.getId());
	}


	public void afficherListDeArticle() {
		repertoire.afficherListToutArticle();
	}
	public void afficherListToutOutil(){
		repertoire.afficherListToutOutil();
	}
	public void afficherListToutProjet(){
		repertoire.afficherListToutProjet();
	}

	public Boolean afficherFicheComplet() {
		// TODO - implement ControleurActivite.afficherFicheComplet
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement ControleurActivite.operation
		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param info
	 */
	@Override
	public Boolean isValid(String[] info) {
		return null;
	}

}