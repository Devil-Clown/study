import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4J_JDKLog {
    final static Logger logger = LoggerFactory.getLogger(SLF4J_JDKLog.class);
    public static void main(String[] args) {
        logger.trace("Trace Level.");
        logger.info("Info Level.");
        logger.warn("Warn Level.");
        logger.error("Error Level.");
    }
}
