package io.swagger.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body", propOrder = { "transactionId", "data" })

@XmlRootElement(name = "Body")
public class Body {

	@XmlElement(name = "transactionId")
	@ApiModelProperty(value = "Retorna o identificador de rastreabilidade de transação gerado pelo API. ")
	private String transactionId = null;

	@XmlElement(name = "data")
	@ApiModelProperty(value = "")
	private DeviceswifiData data = null;

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
	 * Get data
	 * 
	 * @return data
	 **/
	public DeviceswifiData getData() {
		return data;
	}

	public void setData(DeviceswifiData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Body {\n");

		sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
