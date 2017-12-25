
package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ApiCallback;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ApiClient;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ApiException;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ApiResponse;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.Configuration;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.Pair;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ProgressRequestBody;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.ProgressResponseBody;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model.Body;
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model.DeviceswifiResponsePATCH;

public class DeviceswifiPatchApi {
	private ApiClient apiClient;

	public DeviceswifiPatchApi() {
		this(Configuration.getDefaultApiClient());
	}

	public DeviceswifiPatchApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/* Build call for deviceswifiPatch */
	private com.squareup.okhttp.Call deviceswifiPatchCall(String xApiVersion, String xMetadata, Body body,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/deviceswifi".replaceAll("\\{format\\}", "json");

		List<Pair> localVarQueryParams = new ArrayList<Pair>();

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiVersion != null)
			localVarHeaderParams.put("X-Api-Version", apiClient.parameterToString(xApiVersion));
		if (xMetadata != null)
			localVarHeaderParams.put("X-Metadata", apiClient.parameterToString(xMetadata));

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
				@Override
				public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
						throws IOException {
					com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}

		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	/**
	 * Alterar a senha wifi do cliente NET. O recurso /deviceswifi PATCH tem
	 * como objetivo prover para o cliente a funcionalidade de alterar a senha
	 * ou ssid de um dispositivo Wi-Fi Net nos canais de autoatendimento
	 * Digital, Site Net Combo e Mobile.
	 * 
	 * @param xApiVersion
	 *            Header com a definição da versão da API a ser consumida
	 *            (optional)
	 * @param xMetadata
	 *            Header que define a necessidade do campo metada no response.
	 *            Permitido \&quot;true\&quot; ou \&quot;false\&quot;.
	 *            (optional)
	 * @param body
	 *            Objeto com as informações necessárias para alterar a senha ou
	 *            SSID do equipamento (optional)
	 * @return DeviceswifiResponsePATCH
	 * @throws ApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public DeviceswifiResponsePATCH deviceswifiPatch(String xApiVersion, String xMetadata, Body body)
			throws ApiException {
		ApiResponse<DeviceswifiResponsePATCH> resp = deviceswifiPatchWithHttpInfo(xApiVersion, xMetadata, body);
		return resp.getData();
	}

	/**
	 * Alterar a senha wifi do cliente NET. O recurso /deviceswifi PATCH tem
	 * como objetivo prover para o cliente a funcionalidade de alterar a senha
	 * ou ssid de um dispositivo Wi-Fi Net nos canais de autoatendimento
	 * Digital, Site Net Combo e Mobile.
	 * 
	 * @param xApiVersion
	 *            Header com a definição da versão da API a ser consumida
	 *            (optional)
	 * @param xMetadata
	 *            Header que define a necessidade do campo metada no response.
	 *            Permitido \&quot;true\&quot; ou \&quot;false\&quot;.
	 *            (optional)
	 * @param body
	 *            Objeto com as informações necessárias para alterar a senha ou
	 *            SSID do equipamento (optional)
	 * @return ApiResponse&lt;DeviceswifiResponsePATCH&gt;
	 * @throws ApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public ApiResponse<DeviceswifiResponsePATCH> deviceswifiPatchWithHttpInfo(String xApiVersion, String xMetadata,
			Body body) throws ApiException {
		com.squareup.okhttp.Call call = deviceswifiPatchCall(xApiVersion, xMetadata, body, null, null);
		Type localVarReturnType = new TypeToken<DeviceswifiResponsePATCH>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	/**
	 * Alterar a senha wifi do cliente NET. (asynchronously) O recurso
	 * /deviceswifi PATCH tem como objetivo prover para o cliente a
	 * funcionalidade de alterar a senha ou ssid de um dispositivo Wi-Fi Net nos
	 * canais de autoatendimento Digital, Site Net Combo e Mobile.
	 * 
	 * @param xApiVersion
	 *            Header com a definição da versão da API a ser consumida
	 *            (optional)
	 * @param xMetadata
	 *            Header que define a necessidade do campo metada no response.
	 *            Permitido \&quot;true\&quot; ou \&quot;false\&quot;.
	 *            (optional)
	 * @param body
	 *            Objeto com as informações necessárias para alterar a senha ou
	 *            SSID do equipamento (optional)
	 * @param callback
	 *            The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException
	 *             If fail to process the API call, e.g. serializing the request
	 *             body object
	 */
	public com.squareup.okhttp.Call deviceswifiPatchAsync(String xApiVersion, String xMetadata, Body body,
			final ApiCallback<DeviceswifiResponsePATCH> callback) throws ApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		com.squareup.okhttp.Call call = deviceswifiPatchCall(xApiVersion, xMetadata, body, progressListener,
				progressRequestListener);
		Type localVarReturnType = new TypeToken<DeviceswifiResponsePATCH>() {
		}.getType();
		apiClient.executeAsync(call, localVarReturnType, callback);
		return call;
	}
}
