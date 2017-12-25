package io.swagger.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceswifiData", propOrder = { "legalNatureCode", "portName", "physicalResourceModelName",
		"internetProtocol", "ssid", "password", "encryption" })

@XmlRootElement(name = "DeviceswifiData")
@ApiModel(description = "Os seguintes campos são obrigatórios: legalNatureCode,  portName, physicalResourceModelName, internetProtocol.  Para alteração do SSID, o parâmetro ssid deve ser passado e é obrigatório. Para alteração de senha, os parâmetros password e encryption devem ser passados e são obrigatórios")
public class DeviceswifiData {

	@XmlElement(name = "legalNatureCode")
	@ApiModelProperty(required = true, value = "Código operadora")
	private String legalNatureCode = null;

	@XmlElement(name = "portName")
	@ApiModelProperty(required = true, value = "MacAddress do equipamento (Virtua) do cliente")
	private String portName = null;

	@XmlElement(name = "physicalResourceModelName")
	@ApiModelProperty(required = true, value = "Modelo do equipamento")
	private String physicalResourceModelName = null;

	@XmlElement(name = "internetProtocol")
	@ApiModelProperty(required = true, value = "Endereço IP do equipamento")
	private String internetProtocol = null;

	@XmlElement(name = "ssid")
	@ApiModelProperty(value = "Novo SSID WIFI do equipamento (Virtua) do cliente")
	private String ssid = null;

	@XmlElement(name = "password")
	@ApiModelProperty(value = "Nova senha WIFI do equipamento (Virtua) do cliente")
	private String password = null;

	@XmlElement(name = "encryption")
	@ApiModelProperty(value = "Método de criptografia da senha WIFI do equipamento (Virtua) do cliente")
	private String encryption = null;

	/**
	 * Código operadora
	 * 
	 * @return legalNatureCode
	 **/
	public String getLegalNatureCode() {
		return legalNatureCode;
	}

	public void setLegalNatureCode(String legalNatureCode) {
		this.legalNatureCode = legalNatureCode;
	}

	/**
	 * MacAddress do equipamento (Virtua) do cliente
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
	 * Novo SSID WIFI do equipamento (Virtua) do cliente
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
	 * Nova senha WIFI do equipamento (Virtua) do cliente
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
	 * Método de criptografia da senha WIFI do equipamento (Virtua) do cliente
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
		sb.append("class DeviceswifiData {\n");

		sb.append("    legalNatureCode: ").append(toIndentedString(legalNatureCode)).append("\n");
		sb.append("    portName: ").append(toIndentedString(portName)).append("\n");
		sb.append("    physicalResourceModelName: ").append(toIndentedString(physicalResourceModelName)).append("\n");
		sb.append("    internetProtocol: ").append(toIndentedString(internetProtocol)).append("\n");
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
