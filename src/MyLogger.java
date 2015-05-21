import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by tzach on 5/16/15.
 */
public class MyLogger {

    private static Logger logger;

    public static void init(){
        logger = LogManager.getLogger("test-log4j2-threads");
    }

    public static Logger getLogger(){
        return logger;
    }
}
