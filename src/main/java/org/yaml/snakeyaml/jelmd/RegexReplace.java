package org.yaml.snakeyaml.jelmd;

public class RegexReplace extends YamlObject {
	public String regex;
	public String value;
	public String sub_oids;

	public void dump(StringBuilder sb, String indent) {
		if (regex != null)
			sb.append(indent).append("regex: '").append(regex).append("'\n");
		if (sub_oids != null)
			sb.append(indent).append("sub_oids: '").append(sub_oids).append("'\n");
		if (value != null)
			sb.append(indent).append("value: '").append(value).append("'\n");
	}
}
