import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志文件和LogBack基本相同
 */
public class SLF4J_LogBack {
    final static Logger logger = LoggerFactory.getLogger(SLF4J_LogBack.class);
    public static void main(String[] args) {
        logger.trace("Trace Level.");
        logger.info("Info Level.");
        logger.warn("Warn Level.");
        logger.error("Error Level.");
    }
}
