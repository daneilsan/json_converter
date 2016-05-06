/**
 * Created by daniel.garcia on 11/02/2016.
 */
public class ArgsChecker {
    public static void check(String[] args) {
        if (args.length != 3) {
            System.out.println("The correct usage is:");
            System.out.println("<input> <input.properties> <output>");
            System.exit(-1);
        }
    }
}
