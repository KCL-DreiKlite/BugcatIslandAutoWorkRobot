package priv.kcl.bugcatisland.autoworkrobot.core;

public class DailyReceiver extends AutoRobot {

    public static final String RECEIVER_THREAD_NAME = "receiverThread";

    private static final long DEFAULT_START_DELAY = 2000;
    private static final long DEFAULT_END_DELAY = 0;

    public static final String TYPE_RECEIVE_START_DELAY_LOG_INFO = "Waiting for %dms to start typing 'DAILY'...";
    public static final String TYPE_RECEIVE_TYPING_LOG_INFO = "Typing 'DAILY'...";
    public static final String TYPE_RECEIVE_INTERVAL_LOG_INFO = "Type 'DAILY' completed. Now waiting for %d ms...";

    public static final String TYPE_RECEIVE_TEXT = "/daily\t\n";
    public static final String INTERRUPTED_EXCEPTION_ERROR_MESSAGE = "Oops! Something goes wrong while typing 'DAILY'!";
//    private Robot robot;
//
//    private long receiverStartDelay;
//    private long receiverInterval;
//
//    private Thread receiverThread;
//
//    private Model.LogPrinter logPrinter;
//
//    private boolean keepThreadRunning;

    public DailyReceiver(Typer typer) {
        super(typer, RECEIVER_THREAD_NAME);

        setupLogInfo(TYPE_RECEIVE_START_DELAY_LOG_INFO, TYPE_RECEIVE_INTERVAL_LOG_INFO, INTERRUPTED_EXCEPTION_ERROR_MESSAGE);
    }

    private void receiveDailyReward() throws InterruptedException {
        log(TYPE_RECEIVE_START_DELAY_LOG_INFO, startDelay);
        Thread.sleep(startDelay);

        log(TYPE_RECEIVE_TYPING_LOG_INFO);
        typer.typeString(TYPE_RECEIVE_TEXT, DEFAULT_START_DELAY, DEFAULT_END_DELAY);

        log(TYPE_RECEIVE_INTERVAL_LOG_INFO, interval);

        Thread.sleep(interval);
    }

    @Override
    protected void executeJob() throws InterruptedException {
        receiveDailyReward();
    }

    //    public DailyReceiver(Robot robot, long receiverStartDelay, long receiverInterval) {
//        this.robot = robot;
//        this.receiverStartDelay = receiverStartDelay;
//        this.receiverInterval = receiverInterval;
//    }
//
//    private void initReceiverThread() {
//        receiverThread = new Thread(this);
//        receiverThread.setName(RECEIVER_THREAD_NAME);
//
//        setKeepThreadRunning(true);
//    }
//
//    public void startReceiver() {
//
//    }
//
//    public void stopReceiver() {
//
//    }
//
//    private void log(String message, Object ... parameters) {
//        if (logPrinter == null)
//            return;
//
//        logPrinter.log(message, parameters);
//    }
//
//    public void setLogPrinter(Model.LogPrinter logPrinter) {
//        this.logPrinter = logPrinter;
//    }

//    public synchronized void setKeepThreadRunning(boolean keepThreadRunning) {
//        this.keepThreadRunning = keepThreadRunning;
//    }
//
//    @Override
//    public void run() {
//
//    }
}
