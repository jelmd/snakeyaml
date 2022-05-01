package org.yaml.snakeyaml.jelmd;

public class AuthParams extends YamlObject {
	public String community; // = "public";
	public String context_name; // = "";

	public String security_level; // = "noAuthNoPriv";
	public String auth_protocol; // = "MD5";
	public String username;
	public String password;
	public String priv_protocol;
	public String priv_password;

	public void dump(StringBuilder sb, String indent) {
		if (community != null)
			sb.append(indent).append("community: ").append(community).append('\n');
		if (context_name != null)
			sb.append(indent).append("context_name: ").append(context_name).append('\n');
		if (security_level != null)
			sb.append(indent).append("security_level: ").append(security_level).append('\n');
		if (auth_protocol != null)
			sb.append(indent).append("auth_protocol: ").append(auth_protocol).append('\n');
		if (username != null)
			sb.append(indent).append("username: ").append(username).append('\n');
		if (password != null)
			sb.append(indent).append("password: '").append(password).append("'\n");
		if (priv_protocol != null)
			sb.append(indent).append("priv_protocol: ").append(priv_protocol).append('\n');
		if (priv_password != null)
			sb.append(indent).append("priv_password: '").append(priv_password).append("'\n");
	}
}