# patternsearch

This sample application demonstrate how to find pattern string in a given file.

## License Summary

-NA-

## Building the examples

### Dependencies

this example is tested on a windows 10 64 bit os with the following software.

* JDK 8(64 bit)
* Apache Maven 3.0.5



### Building

You can build the project using Maven. Maven will copy the required dependent jars into a local repository
and build fat jars which can be executed from the command line. These fat jars will be placed in the
`target/assembly/` directory. To build the project, use the following command:

```
mvn validate
mvn clean package
```

## Running the sample

```
java  -jar target/assembly/patternsearch.jar --help
```

## Running and verifying 

To run and verify, run the command ```mvn verify```
