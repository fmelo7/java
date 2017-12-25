package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Body
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class Body {
	@SerializedName("transactionId")
	private String transactionId = null;

	@SerializedName("data")
	private DeviceswifiData data = null;

	public Body transactionId(String transactionId) {
		this.transactionId = transactionId;
		return this;
	}

	/**
	 * Retorna o identificador de rastreabilidade de transação gerado pelo API.
	 * 
	 * @return transactionId
	 **/
	@ApiModelProperty(value = "Retorna o identificador de rastreabilidade de transação gerado pelo API. ")
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Body data(DeviceswifiData data) {
		this.data = data;
		return this;
	}

	/**
	 * Get data
	 * 
	 * @return data
	 **/
	@ApiModelProperty(value = "")
	public DeviceswifiData getData() {
		return data;
	}

	public void setData(DeviceswifiData data) {
		this.data = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Body body = (Body) o;
		return Objects.equals(this.transactionId, body.transactionId) && Objects.equals(this.data, body.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(transactionId, data);
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
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
