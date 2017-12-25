
package br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.auth;

import java.util.List;
import java.util.Map;

import com.squareup.okhttp.Credentials;

import br.com.netserv.netnaweb.negocio.minhanet.minhaassinatura.gerenciamentowifi.swagger.client.Pair;

public class HttpBasicAuth implements Authentication {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
		if (username == null && password == null) {
			return;
		}
		headerParams.put("Authorization",
				Credentials.basic(username == null ? "" : username, password == null ? "" : password));
	}
}
