package velco.apitest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import velco.apitest.controller.ReferenceController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceControllerTest {

		@Autowired
		private ReferenceController controller;
		
		@Test
		public void contextLoads() throws Exception {
			assertThat(controller).isNotNull();
		}
		
	}