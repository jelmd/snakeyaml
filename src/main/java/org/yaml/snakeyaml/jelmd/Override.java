package org.yaml.snakeyaml.jelmd;

import java.util.Map;

public class Override {
	public String type; // = "";
	public Boolean ignore; // = false;
	public Map<String, RegexReplace[]> regex_extracts;
	public Map<String, String> remap;
	public RegexReplace[] rename;
}
