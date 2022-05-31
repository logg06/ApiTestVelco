package velco.apitest.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import velco.apitest.model.Reference;
import velco.apitest.model.JsonResponse;

@RunWith(MockitoJUnitRunner.class)
public class ControlServiceTest {

	@InjectMocks
	private ControlService service;
	
	@Test
	public void controlePatternTest() {
		Reference referenceMock = new Reference(1234567891, "R", (float) 10.0, 50);
		String line = "1234567891;R;10.0;50";
		
		JsonResponse response = new JsonResponse("test");
		response = service.controlPattern(response, line, 1);
		
		Assert.assertNotNull(response.getReferences());
		Assert.assertEquals(response.getReferences().size(), 1);
		Assert.assertEquals(referenceMock.getType(), response.getReferences().get(0).getType());
		Assert.assertEquals(referenceMock.getNumeroReference(), response.getReferences().get(0).getNumeroReference());
		Assert.assertEquals(referenceMock.getSize(), response.getReferences().get(0).getSize());
	}
}
