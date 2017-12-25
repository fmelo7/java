package io.swagger.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorErrorLink", propOrder = { "rel", "href" })

@XmlRootElement(name = "ErrorErrorLink")
@ApiModel(description = "Objeto para conter o link para a página com a documentação detalhada dos códigos e descrições dos erros no API Portal ")
public class ErrorErrorLink {

	@XmlType(name = "RelEnum")
	@XmlEnum(String.class)
	public enum RelEnum {

		@XmlEnumValue("related")
		RELATED(String.valueOf("related"));

		private String value;

		RelEnum(String v) {
			value = v;
		}

		public String value() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static RelEnum fromValue(String v) {
			for (RelEnum b : RelEnum.values()) {
				if (String.valueOf(b.value).equals(v)) {
					return b;
				}
			}
			return null;
		}
	}

	@XmlElement(name = "rel")
	@ApiModelProperty(value = "Para referenciar a página de erros do API portal será utilizada a semântica “related” nesse cenário")
	private RelEnum rel = null;

	@XmlElement(name = "href")
	@ApiModelProperty(value = "URL completa do recurso")
	private String href = null;

	/**
	 * Para referenciar a página de erros do API portal será utilizada a
	 * semântica “related” nesse cenário
	 * 
	 * @return rel
	 **/
	public RelEnum getRel() {
		return rel;
	}

	public void setRel(RelEnum rel) {
		this.rel = rel;
	}

	/**
	 * URL completa do recurso
	 * 
	 * @return href
	 **/
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorErrorLink {\n");

		sb.append("    rel: ").append(toIndentedString(rel)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
