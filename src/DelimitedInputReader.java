import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Created by daniel.garcia on 11/02/2016.
 */
public class DelimitedInputReader implements InputReader {
    BufferedReader reader;
    String separator;
    boolean isEOFReached = false;
    String lastLineReaded;

    public DelimitedInputReader(String file, Properties properties) throws IOException {
        this(file, Charset.forName(properties.getProperty("DelimitedInputReader.encoding")), properties.getProperty("DelimitedInputReader.separator"));
    }

    public DelimitedInputReader(String path, Charset charset, String separator) throws IOException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), charset));
        this.separator = separator;

        readNextLine();
    }

    public void readNextLine() throws IOException {
        lastLineReaded = reader.readLine();
        if (lastLineReaded == null) {
            reader.close();
            isEOFReached = true;
        }
    }

    @Override
    public String[] readLine() throws IOException {
        String[] result =  lastLineReaded.split(separator);
        readNextLine();
        return result;
    }

    @Override
    public boolean isEOF() {
        return isEOFReached;
    }
}
