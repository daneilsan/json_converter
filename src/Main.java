import java.io.*;
import java.util.Properties;

/**
 * Created by daniel.garcia on 11/02/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        ArgsChecker.check(args);

        Properties prop = new Properties();
        prop.load(new BufferedReader(new FileReader(args[1])));

        InputReader input = InputReaderFactory.create(args[0], prop);
        JsonFileWriter json = new JsonFileWriter(args[2], prop);

        Statistics stats = new Statistics();
        while (!input.isEOF()) {
            json.writeLine(input.readLine());
        }

        json.close();
        System.out.println(String.format("%d lines processed in %d miliseconds", json.getLinesWrote(), stats.timeSpent()));
    }
}
