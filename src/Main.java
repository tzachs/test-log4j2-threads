import org.apache.logging.log4j.ThreadContext;

/**
 * Created by tzach on 5/16/15.
 */
public class Main {

    public static void main(String[] args) {
        ThreadContext.put("logFilename","main");
        MyLogger.init();


        int i;
        MyLogger.getLogger().info("Started");
        TestThread testThread;
        testThread = new TestThread("test1");
        testThread.start();
        testThread = new TestThread("test2");
        testThread.start();

        for ( i = 0; i < 4; i++){
            try {

                MyLogger.getLogger().debug("GUI log");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MyLogger.getLogger().info("Finished");
    }
}
