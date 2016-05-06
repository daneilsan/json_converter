import java.util.Date;

/**
 * Created by daniel.garcia on 11/02/2016.
 */
public class Statistics {
    long start;

    public Statistics() {
        start = System.currentTimeMillis();
    }

    public long timeSpent() {
        return  System.currentTimeMillis() - start;
    }
}
