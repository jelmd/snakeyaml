package org.yaml.snakeyaml.jelmd;

import java.util.Map;
import java.util.TreeMap;

public class Lookup extends YamlObject {
	public String[] mprefix;
	public String[] source_indexes;
	public String lookup;
	public String rename; // = "";
	public RegexReplace revalue;
	public Boolean drop_source_indexes; // = false;
	public TreeMap<String, String> remap;
	public TreeMap<String, String> sub_oid_remap;
	public String sub_oids;

	public void dump(StringBuilder sb, String indent) {
		if (source_indexes != null) {
			sb.append(indent).append("source_indexes: [");
			int mark = sb.length();
			for (int i=0; i < source_indexes.length; i++) {
				if (source_indexes[i] == null || source_indexes[i].length() == 0)
					continue;
				sb.append(source_indexes[i]).append(", ");
			}
			if (sb.length() != mark)
				sb.setLength(sb.length() - 2);
			sb.append("]\n");
		}
		if (mprefix != null && mprefix.length != 0) {
			int mark = sb.length();
			sb.append(indent).append("mprefix: [");
			int cp = sb.length();
			for (int i=0; i < mprefix.length; i++) {
				if (mprefix[i] == null || mprefix[i].length() == 0)
					continue;
				sb.append('\'').append(mprefix[i]).append("', ");
			}
			if (sb.length() != cp) {
				sb.setLength(sb.length() - 2);
				sb.append("]\n");
			} else {
				sb.setLength(mark);
			}
		}
		if (sub_oids != null)
			sb.append(indent).append("sub_oids: '").append(sub_oids).append("'\n");
		if (lookup != null)
			sb.append(indent).append("lookup: ").append(lookup).append('\n');
		if (rename != null)
			sb.append(indent).append("rename: ").append(rename).append('\n');
		if (revalue != null) {
			int mark = sb.length();
			sb.append(indent).append("revalue:\n");
			int cp = sb.length();
			revalue.dump(sb, indent + "  ");
			if (sb.length() == cp)
				sb.setLength(mark);
		}
		if (remap != null && remap.size() != 0) {
			sb.append(indent).append("remap:\n");
			indent += "  ";
			for (Map.Entry<String, String> e: remap.entrySet()) {
				sb.append(indent).append('\'').append(e.getKey()).append("': '")
					.append(e.getValue()).append("'\n");
			}
			indent = indent.substring(2);
		}
		if (sub_oid_remap != null && sub_oid_remap.size() != 0) {
			sb.append(indent).append("sub_oid_remap:\n");
			indent += "  ";
			for (Map.Entry<String, String> e: sub_oid_remap.entrySet()) {
				sb.append(indent).append('\'').append(e.getKey()).append("': '")
					.append(e.getValue()).append("'\n");
			}
			indent = indent.substring(2);
		}
		if (drop_source_indexes != null)
			sb.append(indent).append("drop_source_indexes: true\n");
	}
}
