import org.apache.logging.log4j.ThreadContext;

/**
 * Created by tzach on 5/16/15.
 */
public class TestThread extends Thread implements Runnable {

    private final String threadName;

    public TestThread(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(threadName);
        ThreadContext.put("logFilename",   Thread.currentThread().getName());

        MyLogger.getLogger().debug("Starting new loop");
        int i = 0;
        long threadId = Thread.currentThread().getId();
        for ( int z = 0; z < 3; z++){
            MyLogger.getLogger().warn("Thread number: " + threadId + " message number " + ++i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                MyLogger.getLogger().error(e.toString(),e);
            }
        }
    }
}
