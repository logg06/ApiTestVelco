package velco.apitest.service;

import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import velco.apitest.exception.LigneException;
import velco.apitest.model.Error;
import velco.apitest.model.Reference;
import velco.apitest.model.JsonResponse;

/**
 * Service de controle
 * 
 * @author rseisser
 *
 */
@Service
public class ControlService {

	/**
	 * Controle sur le pattern
	 * 
	 * @param json  Objet contenant une liste de références et d'erreurs
	 * @param line La ligne à contrôler
	 * @param cpt   Le compteur de la ligne
	 * @return Objet contenant une liste de références et d'erreurs
	 */
	public JsonResponse controlPattern(JsonResponse json, String line, int cpt) {

		try {
			final int numeroReference = Integer.parseInt(line.split(";")[0]);
			final String type = line.split(";")[1];
			final float price = Float.parseFloat(line.split(";")[2]);
			final int size = Integer.parseInt(line.split(";")[3]);

			controlLine(numeroReference, type);
			final Reference reference = new Reference(numeroReference, type, price, size);
			json.addReference(reference);
		} catch (final PatternSyntaxException pattExc) {
			Error error = new Error(cpt, "Erreur de pattern", line);
			json.addError(error);
		} catch (final LigneException ligneExc) {
			Error error = new Error(cpt, ligneExc.getMessage(), line);
			json.addError(error);
		}

		return json;

	}

	/**
	 * Méthode de controle d'une ligne sur le numéro de référence et la couleur
	 * 
	 * @param numeroReference Le numéro de référence
	 * @param type         La couleur
	 * @throws LigneException Exception relevée sur le contrôle de la ligne
	 */
	private void controlLine(int numeroReference, String type) throws LigneException {
		if (String.valueOf(numeroReference).length() != 10) {
			throw new LigneException("Le numero de référence n'est pas composé de 10 chiffres");
		}
		if (!StringUtils.equals(type, "R") && !StringUtils.equals(type, "G")
				&& !StringUtils.equals(type, "B")) {
			throw new LigneException("Couleur incorrecte");
		}
	}
}
