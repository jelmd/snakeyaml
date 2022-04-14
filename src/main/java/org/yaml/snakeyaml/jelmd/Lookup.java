package org.yaml.snakeyaml.jelmd;

import java.util.Map;

public class Lookup {
	public String[] mprefix;
	public String[] source_indexes;
	public String lookup;
	public String rename; // = "";
	public RegexReplace revalue;
	public Boolean drop_source_indexes; // = false;
	public Map<String, String> remap;
}
