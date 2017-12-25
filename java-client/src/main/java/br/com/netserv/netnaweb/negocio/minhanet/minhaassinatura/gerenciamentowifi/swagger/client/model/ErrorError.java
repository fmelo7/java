package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * ErrorError
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class ErrorError {
	@SerializedName("httpCode")
	private String httpCode = null;

	@SerializedName("errorCode")
	private String errorCode = null;

	@SerializedName("message")
	private String message = null;

	@SerializedName("detailedMessage")
	private String detailedMessage = null;

	@SerializedName("link")
	private ErrorErrorLink link = null;

	public ErrorError httpCode(String httpCode) {
		this.httpCode = httpCode;
		return this;
	}

	/**
	 * Código de erro HTTP
	 * 
	 * @return httpCode
	 **/
	@ApiModelProperty(value = "Código de erro HTTP")
	public String getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

	public ErrorError errorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	/**
	 * Código de erro interno da API no formato. Ex.: API-3566. Esse código
	 * poderá ser utilizado internamente pelo cliente para mapeamento
	 * customizado da mensagem de erro.
	 * 
	 * @return errorCode
	 **/
	@ApiModelProperty(value = "Código de erro interno da API no formato. Ex.: API-3566. Esse código poderá ser utilizado internamente pelo cliente para mapeamento customizado da mensagem de erro.")
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorError message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Mensagem de erro resumida
	 * 
	 * @return message
	 **/
	@ApiModelProperty(value = "Mensagem de erro resumida")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorError detailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
		return this;
	}

	/**
	 * Mensagem de erro detalhada
	 * 
	 * @return detailedMessage
	 **/
	@ApiModelProperty(value = "Mensagem de erro detalhada")
	public String getDetailedMessage() {
		return detailedMessage;
	}

	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}

	public ErrorError link(ErrorErrorLink link) {
		this.link = link;
		return this;
	}

	/**
	 * Get link
	 * 
	 * @return link
	 **/
	@ApiModelProperty(value = "")
	public ErrorErrorLink getLink() {
		return link;
	}

	public void setLink(ErrorErrorLink link) {
		this.link = link;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ErrorError errorError = (ErrorError) o;
		return Objects.equals(this.httpCode, errorError.httpCode)
				&& Objects.equals(this.errorCode, errorError.errorCode)
				&& Objects.equals(this.message, errorError.message)
				&& Objects.equals(this.detailedMessage, errorError.detailedMessage)
				&& Objects.equals(this.link, errorError.link);
	}

	@Override
	public int hashCode() {
		return Objects.hash(httpCode, errorCode, message, detailedMessage, link);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorError {\n");

		sb.append("    httpCode: ").append(toIndentedString(httpCode)).append("\n");
		sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    detailedMessage: ").append(toIndentedString(detailedMessage)).append("\n");
		sb.append("    link: ").append(toIndentedString(link)).append("\n");
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
