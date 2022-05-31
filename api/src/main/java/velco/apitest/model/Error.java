package velco.apitest.model;

/**
 * Objet représentant une erreur contenue dans une référence
 * 
 * @author rseisser
 *
 */
public class Error {

	/** Le numéro de ligne de l'erreur */
	private int line;

	/** Le message relatif à l'erreur */
	private String message;

	/** Le contenu de la ligne */
	private String value;

	/**
	 * Constructeur
	 * 
	 * @param line    Le numéro de ligne de l'erreur
	 * @param message Le message relatif à l'erreur
	 * @param value   Le contenu de la ligne
	 */
	public Error(int line, String message, String value) {
		super();
		this.line = line;
		this.message = message;
		this.value = value;
	}

	/**
	 * Obtient le numéro de ligne de l'erreur
	 * 
	 * @return Le numéro de ligne de l'erreur
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Définit le numéro de ligne de l'erreur
	 * 
	 * @param line Le numéro de ligne de l'erreur
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * Obtient le message relatif à l'erreur
	 * 
	 * @return Le message relatif à l'erreur
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Définit le message relatif à l'erreur
	 * 
	 * @param message Le message relatif à l'erreur
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Obtient le contenu de la ligne
	 * 
	 * @return Le contenu de la ligne
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Définit le contenu de la ligne
	 * 
	 * @param value Le contenu de la ligne
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
