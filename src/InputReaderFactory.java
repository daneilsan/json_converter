import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * Created by daniel.garcia on 11/02/2016.
 */
public class InputReaderFactory {
    public static InputReader create(String file, Properties props) throws Exception {
        Class c = Class.forName(props.getProperty("input.type"));
        Constructor constructor = c.getConstructor(String.class, Properties.class);
        InputReader inputReader = (InputReader)constructor.newInstance(file, props);

        return inputReader;
    }
}
