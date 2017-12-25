package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * DeviceswifiResponsePATCHData
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class DeviceswifiResponsePATCHData {
	@SerializedName("code")
	private Integer code = null;

	@SerializedName("message")
	private String message = null;

	public DeviceswifiResponsePATCHData code(Integer code) {
		this.code = code;
		return this;
	}

	/**
	 * Código de retorno da engenharia
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código de retorno da engenharia")
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public DeviceswifiResponsePATCHData message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Mensagem de retorno da engenharia
	 * 
	 * @return message
	 **/
	@ApiModelProperty(value = "Mensagem de retorno da engenharia")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DeviceswifiResponsePATCHData deviceswifiResponsePATCHData = (DeviceswifiResponsePATCHData) o;
		return Objects.equals(this.code, deviceswifiResponsePATCHData.code)
				&& Objects.equals(this.message, deviceswifiResponsePATCHData.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DeviceswifiResponsePATCHData {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
