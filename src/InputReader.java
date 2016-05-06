import java.io.IOException;
import java.util.Properties;

/**
 * Created by daniel.garcia on 11/02/2016.
 */
public interface InputReader {
    // InputReader(String file, Properties properties);
    String[] readLine() throws IOException;
    boolean isEOF();
}
