/**
 * Copyright (c) 2022, Jens Elkner (jel+snakeyaml@cs.uni-magdeburg.de).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yaml.snakeyaml.jelmd;

import java.io.FileReader;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;
/**
 * Simple snmp_exporter generator configuration converter.
 *
 * @author Jens Elkner (jel+snakeyaml@cs.uni-magdeburg.de)
 *
 */
public class Yaml2Yaml {
	/**
	 * Simple Application, which reads in a yaml document, merges the values of
	 * duplicated keys and pretty prints the resulting document to stdout.
	 * @param args the path to the yaml file to read.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: java -jar snakeyaml.jar  file.yml");
			System.exit(1);
		}
		LoaderOptions opts = new LoaderOptions();
		opts.setAllowDuplicateKeys(true);
		opts.setEnumCaseSensitive(true);
		opts.setMergeDuplicates(true);
		DumperOptions dopts = new DumperOptions();
		dopts.setIndent(2);
		dopts.setPrettyFlow(true);
		dopts.setDefaultFlowStyle(FlowStyle.BLOCK);
		dopts.setCanonical(false);
		//Yaml yaml= new Yaml(new SafeConstructor(opts));
		Representer representer = new Representer(dopts) {
			protected NodeTuple representJavaBeanProperty(Object javaBean,
				Property property, Object propertyValue,Tag customTag)
			{
				// if value of property is null, ignore it.
				return (propertyValue == null)
					? null
					: super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
			}
		};

		Yaml yaml = new Yaml(new Constructor(GeneratorConfig.class, opts), representer, dopts, opts);
		FileReader fr = null;
		try {
			fr = new FileReader(args[0]);
			GeneratorConfig config = yaml.load(fr);
			String s = yaml.dump(config);
			System.out.print(s.replaceAll("'<<':", "<<:"));
		} catch (Exception e) {
			System.err.print(e.getLocalizedMessage());
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (Exception e) {
					System.err.print(e.getLocalizedMessage());
				}
			}
		}
	}
}
