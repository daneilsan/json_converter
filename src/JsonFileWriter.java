import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Created by daniel.garcia on 11/02/2016.
 */
public class JsonFileWriter {
    BufferedWriter writer;
    String[] fieldNames;
    long linesWrote;

    public JsonFileWriter(String path, Properties properties) throws Exception {
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), Charset.forName("UTF-8").newEncoder()));
        this.fieldNames = properties.getProperty("input.fields").split(",");
    }

    public void writeLine(String[] fields) throws Exception {
        StringBuilder sb = new StringBuilder("{");

        for (int j = 0; j < fieldNames.length; j++ ) {
            if (j < fieldNames.length - 1) { // adds a coma
                sb.append("\"" + fieldNames[j] + "\":\"" + fields[j] + "\",");
            } else { // close the braket
                sb.append("\"" + fieldNames[j] + "\":\"" + fields[j] + "\"}\n");
            }
        }

        writer.write(sb.toString());
        linesWrote++;
    }

    public long getLinesWrote() {
        return linesWrote;
    }

    public void close() throws Exception {
        writer.close();
    }
}
