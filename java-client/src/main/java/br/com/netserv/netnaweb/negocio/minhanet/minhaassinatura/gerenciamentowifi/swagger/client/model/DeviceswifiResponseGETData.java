package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * DeviceswifiResponseGETData
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class DeviceswifiResponseGETData {
	@SerializedName("code")
	private Integer code = null;

	@SerializedName("message")
	private String message = null;

	@SerializedName("deviceswifi")
	private List<DeviceswifiResponseGETDataDeviceswifi> deviceswifi = new ArrayList<DeviceswifiResponseGETDataDeviceswifi>();

	public DeviceswifiResponseGETData code(Integer code) {
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

	public DeviceswifiResponseGETData message(String message) {
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

	public DeviceswifiResponseGETData deviceswifi(List<DeviceswifiResponseGETDataDeviceswifi> deviceswifi) {
		this.deviceswifi = deviceswifi;
		return this;
	}

	public DeviceswifiResponseGETData addDeviceswifiItem(DeviceswifiResponseGETDataDeviceswifi deviceswifiItem) {
		this.deviceswifi.add(deviceswifiItem);
		return this;
	}

	/**
	 * Get deviceswifi
	 * 
	 * @return deviceswifi
	 **/
	@ApiModelProperty(value = "")
	public List<DeviceswifiResponseGETDataDeviceswifi> getDeviceswifi() {
		return deviceswifi;
	}

	public void setDeviceswifi(List<DeviceswifiResponseGETDataDeviceswifi> deviceswifi) {
		this.deviceswifi = deviceswifi;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DeviceswifiResponseGETData deviceswifiResponseGETData = (DeviceswifiResponseGETData) o;
		return Objects.equals(this.code, deviceswifiResponseGETData.code)
				&& Objects.equals(this.message, deviceswifiResponseGETData.message)
				&& Objects.equals(this.deviceswifi, deviceswifiResponseGETData.deviceswifi);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message, deviceswifi);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DeviceswifiResponseGETData {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    deviceswifi: ").append(toIndentedString(deviceswifi)).append("\n");
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
