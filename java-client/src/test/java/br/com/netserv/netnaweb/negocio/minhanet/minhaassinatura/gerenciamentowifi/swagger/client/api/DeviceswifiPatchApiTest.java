package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.api;

import org.junit.Assert;
import org.junit.Test;

import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ApiClient;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ApiException;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.api.DeviceswifiPatchApi;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model.Body;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model.DeviceswifiData;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model.DeviceswifiResponsePATCH;

/**
 * API tests for DeviceswifiPatchApi
 */
public class DeviceswifiPatchApiTest {

	private final DeviceswifiPatchApi api = new DeviceswifiPatchApi();

	/**
	 * Alterar a senha wifi do cliente NET.
	 *
	 * O recurso /deviceswifi PATCH tem como objetivo prover para o cliente a
	 * funcionalidade de alterar a senha ou ssid de um dispositivo Wi-Fi Net nos
	 * canais de autoatendimento Digital, Site Net Combo e Mobile.
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void deviceswifiPatchTest() throws ApiException {
		ApiClient apiClient = api.getApiClient();
		// apiClient.setBasePath("http://10.28.234.27:8080/sdp");
		apiClient.setBasePath("http://localhost:8080/sdp");

		apiClient.setUsername("APP_MOBILE"); // APP_MOBILE");
		apiClient.setPassword("x1234567");

		Body body = createBodyAlterarRede();

		String xApiVersion = "1";
		String xMetadata = "true";

		DeviceswifiResponsePATCH response = api.deviceswifiPatch(xApiVersion, xMetadata, body);

		Assert.assertNotNull(response);

		System.out.println("response: " + response);
	}

	private Body createBodyAlterarRede() {
		Body body = new Body();
		DeviceswifiData data = new DeviceswifiData();
		data.setLegalNatureCode("003");
		data.setInternetProtocol("10.40.15.168");
		data.setPhysicalResourceModelName("HG100R-L2");
		data.setPortName("");
		data.setSsid("teste_ssid");
		body.data(data);
		return body;
	}
}
