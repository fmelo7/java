package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Objeto de negócio contendo os dados retornados pela API caso existam, para o
 * método GET.
 */
@ApiModel(description = "Objeto de negócio contendo os dados retornados pela API caso existam, para o método GET.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class DeviceswifiResponseGET {
	@SerializedName("apiVersion")
	private String apiVersion = null;

	@SerializedName("transactionId")
	private String transactionId = null;

	@SerializedName("data")
	private DeviceswifiResponseGETData data = null;

	public DeviceswifiResponseGET apiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
		return this;
	}

	/**
	 * Retorna sempre a versão major e minor da API efetivamente consumida. O
	 * formato é “versão major;versão minor”. Exemplo: “apiVersion”:
	 * “2;2015-08-12”. Quando a versão minor não é solicitada, a versão
	 * contratada pelo cliente é retornada. Quando não há restrição de
	 * contratação, retorna a última disponível.
	 * 
	 * @return apiVersion
	 **/
	@ApiModelProperty(required = true, value = "Retorna sempre a versão major e minor da API efetivamente consumida. O formato é “versão major;versão minor”. Exemplo: “apiVersion”: “2;2015-08-12”. Quando a versão minor não é solicitada, a versão contratada pelo cliente é retornada. Quando não há restrição de contratação, retorna a última disponível. ")
	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public DeviceswifiResponseGET transactionId(String transactionId) {
		this.transactionId = transactionId;
		return this;
	}

	/**
	 * Retorna o identificador de rastreabilidade de transação gerado pelo API.
	 * 
	 * @return transactionId
	 **/
	@ApiModelProperty(required = true, value = "Retorna o identificador de rastreabilidade de transação gerado pelo API. ")
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public DeviceswifiResponseGET data(DeviceswifiResponseGETData data) {
		this.data = data;
		return this;
	}

	/**
	 * Get data
	 * 
	 * @return data
	 **/
	@ApiModelProperty(value = "")
	public DeviceswifiResponseGETData getData() {
		return data;
	}

	public void setData(DeviceswifiResponseGETData data) {
		this.data = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DeviceswifiResponseGET deviceswifiResponseGET = (DeviceswifiResponseGET) o;
		return Objects.equals(this.apiVersion, deviceswifiResponseGET.apiVersion)
				&& Objects.equals(this.transactionId, deviceswifiResponseGET.transactionId)
				&& Objects.equals(this.data, deviceswifiResponseGET.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apiVersion, transactionId, data);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DeviceswifiResponseGET {\n");

		sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
		sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
