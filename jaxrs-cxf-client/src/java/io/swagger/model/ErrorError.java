package io.swagger.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorError", propOrder = { "httpCode", "errorCode", "message", "detailedMessage", "link" })

@XmlRootElement(name = "ErrorError")
public class ErrorError {

	@XmlElement(name = "httpCode")
	@ApiModelProperty(value = "Código de erro HTTP")
	private String httpCode = null;

	@XmlElement(name = "errorCode")
	@ApiModelProperty(value = "Código de erro interno da API no formato. Ex.: API-3566. Esse código poderá ser utilizado internamente pelo cliente para mapeamento customizado da mensagem de erro.")
	private String errorCode = null;

	@XmlElement(name = "message")
	@ApiModelProperty(value = "Mensagem de erro resumida")
	private String message = null;

	@XmlElement(name = "detailedMessage")
	@ApiModelProperty(value = "Mensagem de erro detalhada")
	private String detailedMessage = null;

	@XmlElement(name = "link")
	@ApiModelProperty(value = "")
	private ErrorErrorLink link = null;

	/**
	 * Código de erro HTTP
	 * 
	 * @return httpCode
	 **/
	public String getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

	/**
	 * Código de erro interno da API no formato. Ex.: API-3566. Esse código
	 * poderá ser utilizado internamente pelo cliente para mapeamento
	 * customizado da mensagem de erro.
	 * 
	 * @return errorCode
	 **/
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Mensagem de erro resumida
	 * 
	 * @return message
	 **/
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Mensagem de erro detalhada
	 * 
	 * @return detailedMessage
	 **/
	public String getDetailedMessage() {
		return detailedMessage;
	}

	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}

	/**
	 * Get link
	 * 
	 * @return link
	 **/
	public ErrorErrorLink getLink() {
		return link;
	}

	public void setLink(ErrorErrorLink link) {
		this.link = link;
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
	private static String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
