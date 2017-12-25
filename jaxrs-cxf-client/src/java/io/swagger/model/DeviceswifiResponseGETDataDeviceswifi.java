package io.swagger.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceswifiResponseGETDataDeviceswifi", propOrder = { "portName", "installStatus", "internetProtocol",
		"manufacturerDescription", "physicalResourceModelName", "isWifi", "ssid", "password", "encryption" })

@XmlRootElement(name = "DeviceswifiResponseGETDataDeviceswifi")
public class DeviceswifiResponseGETDataDeviceswifi {

	@XmlElement(name = "portName")
	@ApiModelProperty(value = "MacAddress do equipamento")
	private String portName = null;

	@XmlElement(name = "installStatus")
	@ApiModelProperty(value = "Status do equipamento")
	private String installStatus = null;

	@XmlElement(name = "internetProtocol")
	@ApiModelProperty(value = "Endereço IP do equipamento")
	private String internetProtocol = null;

	@XmlElement(name = "manufacturerDescription")
	@ApiModelProperty(value = "Fabricante do equipamento")
	private String manufacturerDescription = null;

	@XmlElement(name = "physicalResourceModelName")
	@ApiModelProperty(value = "Modelo do equipamento")
	private String physicalResourceModelName = null;

	@XmlElement(name = "isWifi")
	@ApiModelProperty(value = "Indicador se equipamento tem wifi")
	private Integer isWifi = null;

	@XmlElement(name = "ssid")
	@ApiModelProperty(value = "SSID WIFI do equipamento (Virtua) do cliente")
	private String ssid = null;

	@XmlElement(name = "password")
	@ApiModelProperty(value = "Senha WIFI do equipamento (Virtua) do cliente")
	private String password = null;

	@XmlElement(name = "encryption")
	@ApiModelProperty(value = "Método de criptografia da senha")
	private String encryption = null;

	/**
	 * MacAddress do equipamento
	 * 
	 * @return portName
	 **/
	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	/**
	 * Status do equipamento
	 * 
	 * @return installStatus
	 **/
	public String getInstallStatus() {
		return installStatus;
	}

	public void setInstallStatus(String installStatus) {
		this.installStatus = installStatus;
	}

	/**
	 * Endereço IP do equipamento
	 * 
	 * @return internetProtocol
	 **/
	public String getInternetProtocol() {
		return internetProtocol;
	}

	public void setInternetProtocol(String internetProtocol) {
		this.internetProtocol = internetProtocol;
	}

	/**
	 * Fabricante do equipamento
	 * 
	 * @return manufacturerDescription
	 **/
	public String getManufacturerDescription() {
		return manufacturerDescription;
	}

	public void setManufacturerDescription(String manufacturerDescription) {
		this.manufacturerDescription = manufacturerDescription;
	}

	/**
	 * Modelo do equipamento
	 * 
	 * @return physicalResourceModelName
	 **/
	public String getPhysicalResourceModelName() {
		return physicalResourceModelName;
	}

	public void setPhysicalResourceModelName(String physicalResourceModelName) {
		this.physicalResourceModelName = physicalResourceModelName;
	}

	/**
	 * Indicador se equipamento tem wifi
	 * 
	 * @return isWifi
	 **/
	public Integer getIsWifi() {
		return isWifi;
	}

	public void setIsWifi(Integer isWifi) {
		this.isWifi = isWifi;
	}

	/**
	 * SSID WIFI do equipamento (Virtua) do cliente
	 * 
	 * @return ssid
	 **/
	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	/**
	 * Senha WIFI do equipamento (Virtua) do cliente
	 * 
	 * @return password
	 **/
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Método de criptografia da senha
	 * 
	 * @return encryption
	 **/
	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DeviceswifiResponseGETDataDeviceswifi {\n");
		sb.append("    portName: ").append(toIndentedString(portName)).append("\n");
		sb.append("    installStatus: ").append(toIndentedString(installStatus)).append("\n");
		sb.append("    internetProtocol: ").append(toIndentedString(internetProtocol)).append("\n");
		sb.append("    manufacturerDescription: ").append(toIndentedString(manufacturerDescription)).append("\n");
		sb.append("    physicalResourceModelName: ").append(toIndentedString(physicalResourceModelName)).append("\n");
		sb.append("    isWifi: ").append(toIndentedString(isWifi)).append("\n");
		sb.append("    ssid: ").append(toIndentedString(ssid)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    encryption: ").append(toIndentedString(encryption)).append("\n");
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
