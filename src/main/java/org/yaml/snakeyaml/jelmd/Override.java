package org.yaml.snakeyaml.jelmd;

import java.util.Map;
import java.util.TreeMap;

public class Override extends YamlObject {
	public String type; // = "";
	public Boolean ignore; // = false;
	public Boolean auto_index; // = false;
	public TreeMap<String, RegexReplace[]> regex_extracts;
	public TreeMap<String, String> remap;
	public RegexReplace[] rename;
	public String fallback_label; // = "";

	public void dump(StringBuilder sb, String indent) {
		if (ignore != null)
			sb.append(indent).append("ignore: ").append(ignore).append('\n');
		if (type != null)
			sb.append(indent).append("type: ").append(type).append('\n');
		if (fallback_label != null)
			sb.append(indent).append("fallback_label: ").append(fallback_label).append('\n');
		if (auto_index != null)
			sb.append(indent).append("auto_index: ").append(auto_index).append('\n');
		if (rename != null && rename.length != 0) {
			int mark = sb.length();
			sb.append(indent).append("rename:\n");
			indent += "  ";
			int cp = sb.length();
			for (int i=0; i < rename.length; i++) {
				int n = sb.length();
				rename[i].dump(sb, indent + "  ");
				if (sb.length() != n)
					sb.setCharAt(n + indent.length(), '-');
			}
			if (sb.length() == cp)
				sb.setLength(mark);
			indent = indent.substring(2);
		}
		if (regex_extracts != null && regex_extracts.size() != 0) {
			int mark = sb.length();
			sb.append(indent).append("regex_extracts:\n");
			indent += "  ";
			int cp = sb.length();
			for (Map.Entry<String, RegexReplace[]> e: regex_extracts.entrySet()) {
				RegexReplace[] rr = e.getValue();
				if (rr == null || rr.length == 0)
					continue;
				int mark2 = sb.length();
				sb.append(indent).append('\'').append(e.getKey()).append("':\n");
				int mark3 = sb.length();
				for (int i=0; i < rr.length; i++) {
					int n = sb.length();
					rr[i].dump(sb, indent + "    ");
					if (sb.length() != n)
						sb.setCharAt(n + indent.length() + 2, '-');
				}
				if (sb.length() == mark3)
					sb.setLength(mark2);
			}
			if (sb.length() == cp)
				sb.setLength(mark);
			indent = indent.substring(2);
		}
		if (remap != null && remap.size() != 0) {
			sb.append(indent).append("remap:\n");
			indent += "  ";
			for (Map.Entry<String, String> e: remap.entrySet()) {
				sb.append(indent).append("'").append(e.getKey()).append("': '")
					.append(e.getValue()).append("'\n");
			}
			indent = indent.substring(2);
		}
	}
}
