package org.yaml.snakeyaml.jelmd;

public abstract class YamlObject implements YamlDump {

	public String toString() {
		StringBuilder sb = new StringBuilder(4096);
		dump(sb, "");
		return sb.toString();
	}
}
