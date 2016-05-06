This is a simple command line application used to convert files to json format ready to be consumed by Elasticsearch bulk loader.

Right now, the only input format implemented is "delimiter separator value" files (csv, tsv, ...) but you can extend the program implementing the InputReader interface with whatever format you like. If you do that, create the class that implements this interface with a constructor that accepts a String and a Properties object that you can use to set parameters at the program start.

To use the program use the following syntax:

    java -jar <input file> <input properties file> <output file>

For example, for a "Tab-separated values" file, create a input.properties file with the following content:

```
input.type=DelimitedInputReader
DelimitedInputReader.encoding=UTF-8
DelimitedInputReader.separator=\t
input.fields=a,b,c,d,e,f
```

and use the next command supposing data.tsv file exists:

    java -jar data.tsv input.properties data.json

