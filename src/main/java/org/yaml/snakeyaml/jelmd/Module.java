package org.yaml.snakeyaml.jelmd;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class Module implements Iterable<Object>{
	public Integer max_repetitions; // = 25;
	public Integer retries; // = 3;
	public Integer timeout; // = 5;
	public Integer version; // = 2;
	public AuthParams auth;
	public String[] walk;
	public String prefix; // = "";
	public Lookup[] lookups;
	public Map<String, Override> overrides;
 
	public Iterator<Object> iterator() {
		return Arrays.asList(max_repetitions, retries, timeout, version, auth,
			walk, prefix, lookups, overrides).iterator();

	}
}
