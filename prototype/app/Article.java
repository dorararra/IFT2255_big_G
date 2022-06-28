public class Article {

	private String lienArticle;
	private String datePublication;
	private String lienPublication;
	private Equipier[] auteurs;
	private Equipier[] collaborateurs;
	private String[] motcles;
	private articleStatus status;
	private String resume;

	/**
	 * 
	 * @param titreOuAuteurOuMotCle
	 */
	public void chercherArticle(String titreOuAuteurOuMotCle) {
		// TODO - implement Article.chercherArticle
		throw new UnsupportedOperationException();
	}

	public String getLienArticle() {
		return this.lienArticle;
	}

	/**
	 * 
	 * @param lienArticle
	 */
	public void setLienArticle(String lienArticle) {
		this.lienArticle = lienArticle;
	}

}