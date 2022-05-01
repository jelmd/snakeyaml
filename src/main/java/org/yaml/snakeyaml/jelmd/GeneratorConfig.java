package org.yaml.snakeyaml.jelmd;

import java.util.Map;
import java.util.TreeMap;

public class GeneratorConfig extends YamlObject {
	public TreeMap<String, Module> modules;

	public void dump(StringBuilder sb, String indent) {
		int mark = sb.length();
		sb.append(indent).append("modules:\n");
		indent += "  ";
		int cp = sb.length();
		for (Map.Entry<String, Module> e: modules.entrySet()) {
			int mark2 = sb.length();
			sb.append("\n\n").append(indent).append(e.getKey()).append(":\n");
			int mark3 = sb.length();
			e.getValue().dump(sb, indent + "  ");
			if (sb.length() == mark3)
				sb.setLength(mark2);
		}
		if (sb.length() == cp)
			sb.setLength(mark);
	}
}