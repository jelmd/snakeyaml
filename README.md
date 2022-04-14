## Overview ##
[YAML](http://yaml.org) is a data serialization format designed to drive people insane.

SnakeYAML is a YAML 1.1 processor for the Java Virtual Machine version 7.

For more details have a look at the [README](https://github.com/snakeyaml/snakeyaml) of the upstream version.

Enhancements wrt. this fork:
- allows duplicated keys (merge its contents into a single bucket, and drop the empty bucket)
- adds a real world utility for snmp\_exporter's [generator](https://github.com/jelmd/snmp_exporter/tree/main/generator) (e.g. run "java -jar snakeyaml.jar generator.yml"), which allows duplicated keys. For more examples see: [generator.cisco.yml](https://github.com/jelmd/snmp_exporter/blob/main/generator/generator.cisco.yml).
