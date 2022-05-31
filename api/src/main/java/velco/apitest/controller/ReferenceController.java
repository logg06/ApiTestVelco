package velco.apitest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import velco.apitest.exception.ApiException;
import velco.apitest.model.JsonResponse;
import velco.apitest.service.JsonService;

@SpringBootApplication
@ComponentScan({ "velco.apitest" })
@RestController
public class ReferenceController {

	@Autowired
	private JsonService jsonService;

	@PostMapping("/api/json")
	public String apiJsonPost(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "sortBy", required = false) String sortBy) {
		try {
			JsonResponse jsonObj = jsonService.createJsonFromMultipartFile(file);

			return jsonService.convertToJsonStr(jsonObj, sortBy != null && sortBy.equals("size"),
					sortBy != null && sortBy.equals("price"));

		} catch (ApiException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage());
		}

	}

}