package io.swagger.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceswifiResponseGETData", propOrder = { "code", "message", "deviceswifi" })

@XmlRootElement(name = "DeviceswifiResponseGETData")
public class DeviceswifiResponseGETData {

	@XmlElement(name = "code")
	@ApiModelProperty(value = "Código de retorno da engenharia")
	private Integer code = null;

	@XmlElement(name = "message")
	@ApiModelProperty(value = "Mensagem de retorno da engenharia")
	private String message = null;

	@XmlElement(name = "deviceswifi")
	@ApiModelProperty(value = "")
	private List<DeviceswifiResponseGETDataDeviceswifi> deviceswifi = new ArrayList<DeviceswifiResponseGETDataDeviceswifi>();

	/**
	 * Código de retorno da engenharia
	 * 
	 * @return code
	 **/
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Mensagem de retorno da engenharia
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
	 * Get deviceswifi
	 * 
	 * @return deviceswifi
	 **/
	public List<DeviceswifiResponseGETDataDeviceswifi> getDeviceswifi() {
		return deviceswifi;
	}

	public void setDeviceswifi(List<DeviceswifiResponseGETDataDeviceswifi> deviceswifi) {
		this.deviceswifi = deviceswifi;
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
	private static String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
