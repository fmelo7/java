package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.api;

import org.junit.Assert;
import org.junit.Test;

import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ApiClient;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ApiException;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.api.DeviceswifiGetApi;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model.DeviceswifiResponseGET;

/**
 * API tests for DeviceswifiGetApi
 */
public class DeviceswifiGetApiTest {

	private final DeviceswifiGetApi api = new DeviceswifiGetApi();

	/**
	 * Recuperar a senha wifi do cliente NET.
	 *
	 * O recurso /deviceswifi GET tem como objetivo prover para o cliente a
	 * funcionalidade de recuperar a senha/ssid de um dispositivo Wi-Fi Net nos
	 * canais de autoatendimento Digital, Site Net Combo e Mobile.
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void deviceswifiGetTest() throws ApiException {
		ApiClient apiClient = api.getApiClient();
		// apiClient.setBasePath("http://10.28.234.27:8080/sdp");
		apiClient.setBasePath("http://localhost:8080/sdp");

		apiClient.setUsername("APP_MOBILE"); // APP_MOBILE");
		apiClient.setPassword("x1234567");

		// "teste_eng_dev_mso" ; // "003301169670"; // "003301169670";
		String codigoNet = "003349338695";

		String codigoOperadora = "003";
		String filter = "legalNatureCode::" + codigoOperadora + "|customerAccountId::" + codigoNet;
		String xApiVersion = "1";
		String xMetadata = "true"; // para visualzar
		// devApi.ping();

		DeviceswifiResponseGET response = api.deviceswifiGet(filter, xApiVersion, xMetadata);

		Assert.assertNotNull(response);

		System.out.println("response: " + response);
	}

}
