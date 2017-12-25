package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Objeto para conter o link para a página com a documentação detalhada dos
 * códigos e descrições dos erros no API Portal
 */
@ApiModel(description = "Objeto para conter o link para a página com a documentação detalhada dos códigos e descrições dos erros no API Portal ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class ErrorErrorLink {
	/**
	 * Para referenciar a página de erros do API portal será utilizada a
	 * semântica “related” nesse cenário
	 */
	public enum RelEnum {
		@SerializedName("related")
		RELATED("related");

		private String value;

		RelEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("rel")
	private RelEnum rel = null;

	@SerializedName("href")
	private String href = null;

	public ErrorErrorLink rel(RelEnum rel) {
		this.rel = rel;
		return this;
	}

	/**
	 * Para referenciar a página de erros do API portal será utilizada a
	 * semântica “related” nesse cenário
	 * 
	 * @return rel
	 **/
	@ApiModelProperty(value = "Para referenciar a página de erros do API portal será utilizada a semântica “related” nesse cenário")
	public RelEnum getRel() {
		return rel;
	}

	public void setRel(RelEnum rel) {
		this.rel = rel;
	}

	public ErrorErrorLink href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * URL completa do recurso
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "URL completa do recurso")
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ErrorErrorLink errorErrorLink = (ErrorErrorLink) o;
		return Objects.equals(this.rel, errorErrorLink.rel) && Objects.equals(this.href, errorErrorLink.href);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rel, href);
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
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
