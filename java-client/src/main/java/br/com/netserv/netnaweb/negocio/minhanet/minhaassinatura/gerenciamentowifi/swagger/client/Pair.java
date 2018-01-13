package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-20T12:30:03.997Z")
public class Pair {
	private String name = "";
	private String value = "";

	public Pair(String name, String value) {
		setName(name);
		setValue(value);
	}

	private void setName(String name) {
		if (!isValidString(name))
			return;

		this.name = name;
	}

	private void setValue(String value) {
		if (!isValidString(value))
			return;

		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}

	private boolean isValidString(String arg) {
		if (arg == null)
			return false;
		if (arg.trim().isEmpty())
			return false;

		return true;
	}
}