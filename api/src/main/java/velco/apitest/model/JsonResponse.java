package velco.apitest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * La réponse JSON contenant le nom du fichier, les références et les
 * éventuelles erreurs
 * 
 * @author rseisser
 *
 */
public class JsonResponse {

	/** Le nom du fichier contenant les références */
	String fileName;

	/** La liste des références du fichier */
	List<Reference> references;

	/** La liste des éventuelles erreurs contenues dans le fichier */
	List<Error> errors;

	/** Le constructeur */
	public JsonResponse(String fileName) {
		super();
		this.fileName = fileName;
		this.references = new ArrayList<>();
		this.errors = new ArrayList<>();
	}

	/**
	 * Obtient le nom du fichier
	 * 
	 * @return Le nom du fichier
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Définit le nom du fichier
	 * 
	 * @param fileName Le nom du fichier
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Obtient la liste des références
	 * 
	 * @return La liste des références
	 */
	public List<Reference> getReferences() {
		return references;
	}

	/**
	 * Définit la liste des références
	 * 
	 * @param references La liste des références
	 */
	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	/**
	 * Obtient la liste des erreurs
	 * 
	 * @return La liste des erreurs
	 */
	public List<Error> getErrors() {
		return errors;
	}

	/**
	 * Définit la liste des erreurs
	 * 
	 * @param errors La liste des erreurs
	 */
	public void setErreurs(List<Error> errors) {
		this.errors = errors;
	}

	/**
	 * Ajoute une erreur à la liste des erreurs
	 * 
	 * @param error L'erreur à ajouter
	 */
	public void addError(Error error) {
		errors.add(error);
	}

	/**
	 * Ajoute une référence à la liste des références
	 * 
	 * @param reference La référence
	 */
	public void addReference(Reference reference) {
		references.add(reference);
	}
}
