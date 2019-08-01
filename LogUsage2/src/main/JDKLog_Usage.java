import java.util.logging.Level;
import java.util.logging.Logger;

public class JDKLog_Usage {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("JDKLog");

        log.log(Level.INFO,"这是info级别的日志");
    }
}
