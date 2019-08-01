import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBack_Usage {
    final static Logger log = LoggerFactory.getLogger(LogBack_Usage.class);
    public static void main(String[] args) {
        log.trace("Trace Level.");
        log.debug("Debug Level.");
        log.info("Info Level.");
        log.warn("Warn Level.");
        log.error("Error Level.");
    }
}
