package velco.apitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import velco.apitest.controller.ReferenceController;

/**
 * Classe main de l'application
 * 
 * @author rseisser
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(ReferenceController.class, args);
	}
}
