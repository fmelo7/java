package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Os seguintes campos são obrigatórios: legalNatureCode, portName,
 * physicalResourceModelName, internetProtocol. Para alteração do SSID, o
 * parâmetro ssid deve ser passado e é obrigatório. Para alteração de senha, os
 * parâmetros password e encryption devem ser passados e são obrigatórios
 */
@ApiModel(description = "Os seguintes campos são obrigatórios: legalNatureCode,  portName, physicalResourceModelName, internetProtocol.  Para alteração do SSID, o parâmetro ssid deve ser passado e é obrigatório. Para alteração de senha, os parâmetros password e encryption devem ser passados e são obrigatórios")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class DeviceswifiData {
	@SerializedName("legalNatureCode")
	private String legalNatureCode = null;

	@SerializedName("portName")
	private String portName = null;

	@SerializedName("physicalResourceModelName")
	private String physicalResourceModelName = null;

	@SerializedName("internetProtocol")
	private String internetProtocol = null;

	@SerializedName("ssid")
	private String ssid = null;

	@SerializedName("password")
	private String password = null;

	@SerializedName("encryption")
	private String encryption = null;

	public DeviceswifiData legalNatureCode(String legalNatureCode) {
		this.legalNatureCode = legalNatureCode;
		return this;
	}

	/**
	 * Código operadora
	 * 
	 * @return legalNatureCode
	 **/
	@ApiModelProperty(required = true, value = "Código operadora")
	public String getLegalNatureCode() {
		return legalNatureCode;
	}

	public void setLegalNatureCode(String legalNatureCode) {
		this.legalNatureCode = legalNatureCode;
	}

	public DeviceswifiData portName(String portName) {
		this.portName = portName;
		return this;
	}

	/**
	 * MacAddress do equipamento (Virtua) do cliente
	 * 
	 * @return portName
	 **/
	@ApiModelProperty(required = true, value = "MacAddress do equipamento (Virtua) do cliente")
	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public DeviceswifiData physicalResourceModelName(String physicalResourceModelName) {
		this.physicalResourceModelName = physicalResourceModelName;
		return this;
	}

	/**
	 * Modelo do equipamento
	 * 
	 * @return physicalResourceModelName
	 **/
	@ApiModelProperty(required = true, value = "Modelo do equipamento")
	public String getPhysicalResourceModelName() {
		return physicalResourceModelName;
	}

	public void setPhysicalResourceModelName(String physicalResourceModelName) {
		this.physicalResourceModelName = physicalResourceModelName;
	}

	public DeviceswifiData internetProtocol(String internetProtocol) {
		this.internetProtocol = internetProtocol;
		return this;
	}

	/**
	 * Endereço IP do equipamento
	 * 
	 * @return internetProtocol
	 **/
	@ApiModelProperty(required = true, value = "Endereço IP do equipamento")
	public String getInternetProtocol() {
		return internetProtocol;
	}

	public void setInternetProtocol(String internetProtocol) {
		this.internetProtocol = internetProtocol;
	}

	public DeviceswifiData ssid(String ssid) {
		this.ssid = ssid;
		return this;
	}

	/**
	 * Novo SSID WIFI do equipamento (Virtua) do cliente
	 * 
	 * @return ssid
	 **/
	@ApiModelProperty(value = "Novo SSID WIFI do equipamento (Virtua) do cliente")
	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public DeviceswifiData password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Nova senha WIFI do equipamento (Virtua) do cliente
	 * 
	 * @return password
	 **/
	@ApiModelProperty(value = "Nova senha WIFI do equipamento (Virtua) do cliente")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DeviceswifiData encryption(String encryption) {
		this.encryption = encryption;
		return this;
	}

	/**
	 * Método de criptografia da senha WIFI do equipamento (Virtua) do cliente
	 * 
	 * @return encryption
	 **/
	@ApiModelProperty(value = "Método de criptografia da senha WIFI do equipamento (Virtua) do cliente")
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
		DeviceswifiData deviceswifiData = (DeviceswifiData) o;
		return Objects.equals(this.legalNatureCode, deviceswifiData.legalNatureCode)
				&& Objects.equals(this.portName, deviceswifiData.portName)
				&& Objects.equals(this.physicalResourceModelName, deviceswifiData.physicalResourceModelName)
				&& Objects.equals(this.internetProtocol, deviceswifiData.internetProtocol)
				&& Objects.equals(this.ssid, deviceswifiData.ssid)
				&& Objects.equals(this.password, deviceswifiData.password)
				&& Objects.equals(this.encryption, deviceswifiData.encryption);
	}

	@Override
	public int hashCode() {
		return Objects.hash(legalNatureCode, portName, physicalResourceModelName, internetProtocol, ssid, password,
				encryption);
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
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
