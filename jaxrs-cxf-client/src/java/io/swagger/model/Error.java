package io.swagger.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Error", propOrder = { "apiVersion", "transactionId", "error" })

@XmlRootElement(name = "Error")
@ApiModel(description = "Objeto retornado na ocorrência de algum erro (4xx/5xx)")
public class Error {

	@XmlElement(name = "apiVersion")
	@ApiModelProperty(required = true, value = "Retorna sempre a versão major e minor da API efetivamente consumida. O formato é “versão major;versão minor”. Exemplo: “apiVersion”: “2;2015-08-12”. Quando a versão minor não é solicitada, a versão contratada pelo cliente é retornada. Quando não há restrição de contratação, retorna a última disponível.")
	private String apiVersion = null;

	@XmlElement(name = "transactionId")
	@ApiModelProperty(required = true, value = "Retorna o identificador de rastreabilidade de transação gerado pelo API. ")
	private String transactionId = null;

	@XmlElement(name = "error")
	@ApiModelProperty(value = "")
	private ErrorError error = null;

	/**
	 * Retorna sempre a versão major e minor da API efetivamente consumida. O
	 * formato é “versão major;versão minor”. Exemplo: “apiVersion”:
	 * “2;2015-08-12”. Quando a versão minor não é solicitada, a versão
	 * contratada pelo cliente é retornada. Quando não há restrição de
	 * contratação, retorna a última disponível.
	 * 
	 * @return apiVersion
	 **/
	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	/**
	 * Retorna o identificador de rastreabilidade de transação gerado pelo API.
	 * 
	 * @return transactionId
	 **/
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Get error
	 * 
	 * @return error
	 **/
	public ErrorError getError() {
		return error;
	}

	public void setError(ErrorError error) {
		this.error = error;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Error {\n");

		sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
		sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
		sb.append("    error: ").append(toIndentedString(error)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private static String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
