package org.yaml.snakeyaml.jelmd;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Module extends YamlObject {
	public Integer max_repetitions; // = 25;
	public Integer retries; // = 3;
	public Integer timeout; // = 5;
	public Integer version; // = 2;
	public AuthParams auth;
	public String[] walk;
	public String prefix; // = "";
	public Lookup[] lookups;
	public TreeMap<String, Override> overrides;

	public void dump(StringBuilder sb, String indent) {
		if (prefix != null)
			sb.append(indent).append("prefix: ").append(prefix).append("\n\n");
		if (version != null)
			sb.append(indent).append("version: ").append(version).append('\n');
		if (timeout != null)
			sb.append(indent).append("timeout: ").append(timeout).append('\n');
		if (retries != null)
			sb.append(indent).append("retries: ").append(retries).append('\n');
		if (max_repetitions != null) {
			sb.append(indent).append("max_repetitions: ").append(max_repetitions)
				.append('\n');
		}
		if (auth != null) {
			int mark = sb.length();
			sb.append(indent).append("auth:\n");
			int cp = sb.length();
			auth.dump(sb, indent + "  ");
			if (sb.length() == cp)
				sb.setLength(mark);
		}
		if (walk != null && walk.length != 0) {
			sb.append('\n').append(indent).append("walk:\n");
			indent += "  ";
			for (int i=0; i < walk.length; i++) {
				sb.append(indent).append("- ").append(walk[i]).append('\n');
			}
			indent = indent.substring(2);
		}
		if (lookups != null && lookups.length != 0) {
			int mark = sb.length();
			sb.append('\n').append(indent).append("lookups:\n");
			indent += "  ";
			int cp = sb.length();
			for (int i=0; i < lookups.length; i++) {
				int n = sb.length();
				lookups[i].dump(sb, indent + "  ");
				if (sb.length() != n)
					sb.setCharAt(n + indent.length(), '-');
			}
			indent = indent.substring(2);
			if (sb.length() == cp)
				sb.setLength(mark);
		}
		if (overrides != null && overrides.size() > 0) {
			int mark = sb.length();
			sb.append('\n').append(indent).append("overrides:\n");
			indent += "  ";
			int cp = sb.length();
			for (Map.Entry<String, Override> e: overrides.entrySet()) {
				int mark2 = sb.length();
				sb.append(indent).append(e.getKey()).append(":\n");
				int mark3 = sb.length();
				e.getValue().dump(sb, indent + "  ");
				if (sb.length() == mark3)
					sb.setLength(mark2);
			}
			indent = indent.substring(2);
			if (sb.length() == cp)
				sb.setLength(mark);
		}
	}
}
