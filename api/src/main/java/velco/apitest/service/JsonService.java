package velco.apitest.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import velco.apitest.exception.ApiException;
import velco.apitest.exception.LigneException;
import velco.apitest.model.JsonResponse;
import velco.apitest.model.Reference;

/**
 * Service de création de la réponse JSON
 * 
 * @author rseisser
 *
 */
@Service
public class JsonService {

	@Autowired
	private ControlService controlService;

	/**
	 * Création reponse JSON (liste de références + éventuelles erreurs fichier)
	 * 
	 * @param multipartFile Le fichier multipart uploadé
	 * @return La réponse JSON
	 */
	public JsonResponse createJsonFromMultipartFile(MultipartFile multipartFile) throws ApiException {
		final JsonResponse json = new JsonResponse(multipartFile.getOriginalFilename());
		try (FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(fileInputStream, StandardCharsets.UTF_8))) {
			String ligne = null;

			int cpt = 0;
			while ((ligne = bufferedReader.readLine()) != null) {
				cpt++;
				controlService.controlPattern(json, ligne, cpt);
			}
		} catch (final IOException e) {
			throw new ApiException("Erreur d'accessibilite du fichier");
		}

		return json;
	}

	/**
	 * Construit la réponse JSON en String
	 * 
	 * @param jsonResponse L'objet ReponseJson
	 * @param size         Booleen permettant de trier par taille croissante si à
	 *                     true
	 * @param price        Booleen permettant de trier par prix croissant si à true
	 * @return Le JSON au format String
	 * @throws ApiException
	 */
	public String convertToJsonStr(JsonResponse jsonResponse, boolean size, boolean price) throws ApiException {
		String jsonStr = "";

		final ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			String debutJson = String.format(Locale.getDefault(), "\"inputFile\" : \"%s\", %n \"references\" :",
					jsonResponse.getFileName());
			String referencesJson = "";
			if (size) {
				referencesJson = mapper.writeValueAsString(jsonResponse.getReferences().stream()
						.sorted(Comparator.comparingInt(Reference::getSize)).collect(Collectors.toList()));
			} else if (price) {
				referencesJson = mapper.writeValueAsString(jsonResponse.getReferences().stream()
						.sorted(Comparator.comparingDouble(Reference::getPrice)).collect(Collectors.toList()));
			} else {
				referencesJson = mapper.writeValueAsString(jsonResponse.getReferences());
			}
			String separatorError = ", \n\"errors :\"";
			String erreursJson = mapper.writeValueAsString(jsonResponse.getErrors());
			jsonStr = String.format(Locale.getDefault(), "%s%s%s%s", debutJson, referencesJson, separatorError,
					erreursJson);
		} catch (final JsonProcessingException e) {
			throw new ApiException("Erreur sur le parsing JSON");
		}

		return jsonStr;
	}

}
