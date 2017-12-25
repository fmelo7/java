
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
import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model.DeviceswifiResponseGET;

public class DeviceswifiGetApi {
	private ApiClient apiClient;

	public DeviceswifiGetApi() {
		this(Configuration.getDefaultApiClient());
	}

	public DeviceswifiGetApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/* Build call for deviceswifiGet */
	private com.squareup.okhttp.Call deviceswifiGetCall(String filter, String xApiVersion, String xMetadata,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'filter' is set
		if (filter == null) {
			throw new ApiException("Missing the required parameter 'filter' when calling deviceswifiGet(Async)");
		}

		// create path and map variables
		String localVarPath = "/deviceswifi".replaceAll("\\{format\\}", "json");

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (filter != null)
			localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter", filter));

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

		final String[] localVarContentTypes = {

		};
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
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	/**
	 * Recuperar a senha wifi do cliente NET. O recurso /deviceswifi GET tem
	 * como objetivo prover para o cliente a funcionalidade de recuperar a
	 * senha/ssid de um dispositivo Wi-Fi Net nos canais de autoatendimento
	 * Digital, Site Net Combo e Mobile.
	 * 
	 * @param filter
	 *            Filtros para deviceswifi. Formato para envio dos filtros
	 *            \&quot;filter&#x3D;\&quot;legalNatureCode::VALOR|customerAccountId::VALOR\&quot;.
	 *            Campos obrigatorios &gt; Os campos legalNatureCode (Código
	 *            operadora) e customerAccountId (Contrato do cliente) são ambos
	 *            obrigatórios. (required)
	 * @param xApiVersion
	 *            Header com a definição da versão da API a ser consumida
	 *            (optional)
	 * @param xMetadata
	 *            Header que define a necessidade do campo metada no response.
	 *            Permitido \&quot;true\&quot; ou \&quot;false\&quot;.
	 *            (optional)
	 * @return DeviceswifiResponseGET
	 * @throws ApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public DeviceswifiResponseGET deviceswifiGet(String filter, String xApiVersion, String xMetadata)
			throws ApiException {
		ApiResponse<DeviceswifiResponseGET> resp = deviceswifiGetWithHttpInfo(filter, xApiVersion, xMetadata);
		return resp.getData();
	}

	/**
	 * Recuperar a senha wifi do cliente NET. O recurso /deviceswifi GET tem
	 * como objetivo prover para o cliente a funcionalidade de recuperar a
	 * senha/ssid de um dispositivo Wi-Fi Net nos canais de autoatendimento
	 * Digital, Site Net Combo e Mobile.
	 * 
	 * @param filter
	 *            Filtros para deviceswifi. Formato para envio dos filtros
	 *            \&quot;filter&#x3D;\&quot;legalNatureCode::VALOR|customerAccountId::VALOR\&quot;.
	 *            Campos obrigatorios &gt; Os campos legalNatureCode (Código
	 *            operadora) e customerAccountId (Contrato do cliente) são ambos
	 *            obrigatórios. (required)
	 * @param xApiVersion
	 *            Header com a definição da versão da API a ser consumida
	 *            (optional)
	 * @param xMetadata
	 *            Header que define a necessidade do campo metada no response.
	 *            Permitido \&quot;true\&quot; ou \&quot;false\&quot;.
	 *            (optional)
	 * @return ApiResponse&lt;DeviceswifiResponseGET&gt;
	 * @throws ApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public ApiResponse<DeviceswifiResponseGET> deviceswifiGetWithHttpInfo(String filter, String xApiVersion,
			String xMetadata) throws ApiException {
		com.squareup.okhttp.Call call = deviceswifiGetCall(filter, xApiVersion, xMetadata, null, null);
		Type localVarReturnType = new TypeToken<DeviceswifiResponseGET>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	/**
	 * Recuperar a senha wifi do cliente NET. (asynchronously) O recurso
	 * /deviceswifi GET tem como objetivo prover para o cliente a funcionalidade
	 * de recuperar a senha/ssid de um dispositivo Wi-Fi Net nos canais de
	 * autoatendimento Digital, Site Net Combo e Mobile.
	 * 
	 * @param filter
	 *            Filtros para deviceswifi. Formato para envio dos filtros
	 *            \&quot;filter&#x3D;\&quot;legalNatureCode::VALOR|customerAccountId::VALOR\&quot;.
	 *            Campos obrigatorios &gt; Os campos legalNatureCode (Código
	 *            operadora) e customerAccountId (Contrato do cliente) são ambos
	 *            obrigatórios. (required)
	 * @param xApiVersion
	 *            Header com a definição da versão da API a ser consumida
	 *            (optional)
	 * @param xMetadata
	 *            Header que define a necessidade do campo metada no response.
	 *            Permitido \&quot;true\&quot; ou \&quot;false\&quot;.
	 *            (optional)
	 * @param callback
	 *            The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException
	 *             If fail to process the API call, e.g. serializing the request
	 *             body object
	 */
	public com.squareup.okhttp.Call deviceswifiGetAsync(String filter, String xApiVersion, String xMetadata,
			final ApiCallback<DeviceswifiResponseGET> callback) throws ApiException {

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

		com.squareup.okhttp.Call call = deviceswifiGetCall(filter, xApiVersion, xMetadata, progressListener,
				progressRequestListener);
		Type localVarReturnType = new TypeToken<DeviceswifiResponseGET>() {
		}.getType();
		apiClient.executeAsync(call, localVarReturnType, callback);
		return call;
	}
}
