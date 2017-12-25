package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * DeviceswifiResponseGETDataDeviceswifi
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class DeviceswifiResponseGETDataDeviceswifi {
	@SerializedName("portName")
	private String portName = null;

	@SerializedName("installStatus")
	private String installStatus = null;

	@SerializedName("internetProtocol")
	private String internetProtocol = null;

	@SerializedName("manufacturerDescription")
	private String manufacturerDescription = null;

	@SerializedName("physicalResourceModelName")
	private String physicalResourceModelName = null;

	@SerializedName("isWifi")
	private Integer isWifi = null;

	@SerializedName("ssid")
	private String ssid = null;

	@SerializedName("password")
	private String password = null;

	@SerializedName("encryption")
	private String encryption = null;

	public DeviceswifiResponseGETDataDeviceswifi portName(String portName) {
		this.portName = portName;
		return this;
	}

	/**
	 * MacAddress do equipamento
	 * 
	 * @return portName
	 **/
	@ApiModelProperty(value = "MacAddress do equipamento")
	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public DeviceswifiResponseGETDataDeviceswifi installStatus(String installStatus) {
		this.installStatus = installStatus;
		return this;
	}

	/**
	 * Status do equipamento
	 * 
	 * @return installStatus
	 **/
	@ApiModelProperty(value = "Status do equipamento")
	public String getInstallStatus() {
		return installStatus;
	}

	public void setInstallStatus(String installStatus) {
		this.installStatus = installStatus;
	}

	public DeviceswifiResponseGETDataDeviceswifi internetProtocol(String internetProtocol) {
		this.internetProtocol = internetProtocol;
		return this;
	}

	/**
	 * Endereço IP do equipamento
	 * 
	 * @return internetProtocol
	 **/
	@ApiModelProperty(value = "Endereço IP do equipamento")
	public String getInternetProtocol() {
		return internetProtocol;
	}

	public void setInternetProtocol(String internetProtocol) {
		this.internetProtocol = internetProtocol;
	}

	public DeviceswifiResponseGETDataDeviceswifi manufacturerDescription(String manufacturerDescription) {
		this.manufacturerDescription = manufacturerDescription;
		return this;
	}

	/**
	 * Fabricante do equipamento
	 * 
	 * @return manufacturerDescription
	 **/
	@ApiModelProperty(value = "Fabricante do equipamento")
	public String getManufacturerDescription() {
		return manufacturerDescription;
	}

	public void setManufacturerDescription(String manufacturerDescription) {
		this.manufacturerDescription = manufacturerDescription;
	}

	public DeviceswifiResponseGETDataDeviceswifi physicalResourceModelName(String physicalResourceModelName) {
		this.physicalResourceModelName = physicalResourceModelName;
		return this;
	}

	/**
	 * Modelo do equipamento
	 * 
	 * @return physicalResourceModelName
	 **/
	@ApiModelProperty(value = "Modelo do equipamento")
	public String getPhysicalResourceModelName() {
		return physicalResourceModelName;
	}

	public void setPhysicalResourceModelName(String physicalResourceModelName) {
		this.physicalResourceModelName = physicalResourceModelName;
	}

	public DeviceswifiResponseGETDataDeviceswifi isWifi(Integer isWifi) {
		this.isWifi = isWifi;
		return this;
	}

	/**
	 * Indicador se equipamento tem wifi
	 * 
	 * @return isWifi
	 **/
	@ApiModelProperty(value = "Indicador se equipamento tem wifi")
	public Integer getIsWifi() {
		return isWifi;
	}

	public void setIsWifi(Integer isWifi) {
		this.isWifi = isWifi;
	}

	public DeviceswifiResponseGETDataDeviceswifi ssid(String ssid) {
		this.ssid = ssid;
		return this;
	}

	/**
	 * SSID WIFI do equipamento (Virtua) do cliente
	 * 
	 * @return ssid
	 **/
	@ApiModelProperty(value = "SSID WIFI do equipamento (Virtua) do cliente")
	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public DeviceswifiResponseGETDataDeviceswifi password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Senha WIFI do equipamento (Virtua) do cliente
	 * 
	 * @return password
	 **/
	@ApiModelProperty(value = "Senha WIFI do equipamento (Virtua) do cliente")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DeviceswifiResponseGETDataDeviceswifi encryption(String encryption) {
		this.encryption = encryption;
		return this;
	}

	/**
	 * Método de criptografia da senha
	 * 
	 * @return encryption
	 **/
	@ApiModelProperty(value = "Método de criptografia da senha")
	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DeviceswifiResponseGETDataDeviceswifi deviceswifiResponseGETDataDeviceswifi = (DeviceswifiResponseGETDataDeviceswifi) o;
		return Objects.equals(this.portName, deviceswifiResponseGETDataDeviceswifi.portName)
				&& Objects.equals(this.installStatus, deviceswifiResponseGETDataDeviceswifi.installStatus)
				&& Objects.equals(this.internetProtocol, deviceswifiResponseGETDataDeviceswifi.internetProtocol)
				&& Objects.equals(this.manufacturerDescription,
						deviceswifiResponseGETDataDeviceswifi.manufacturerDescription)
				&& Objects.equals(this.physicalResourceModelName,
						deviceswifiResponseGETDataDeviceswifi.physicalResourceModelName)
				&& Objects.equals(this.isWifi, deviceswifiResponseGETDataDeviceswifi.isWifi)
				&& Objects.equals(this.ssid, deviceswifiResponseGETDataDeviceswifi.ssid)
				&& Objects.equals(this.password, deviceswifiResponseGETDataDeviceswifi.password)
				&& Objects.equals(this.encryption, deviceswifiResponseGETDataDeviceswifi.encryption);
	}

	@Override
	public int hashCode() {
		return Objects.hash(portName, installStatus, internetProtocol, manufacturerDescription,
				physicalResourceModelName, isWifi, ssid, password, encryption);
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
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
