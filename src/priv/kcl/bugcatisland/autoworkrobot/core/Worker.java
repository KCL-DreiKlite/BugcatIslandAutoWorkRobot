package priv.kcl.bugcatisland.autoworkrobot.core;

import java.util.logging.Level;

public class Worker extends AutoRobot {

    public static final String WORK_THREAD_NAME = "workThread";

    private static final Level DEFAULT_LOG_LEVEL = Level.INFO;

    private static final long DEFAULT_START_DELAY = 2000;
    private static final long DEFAULT_END_DELAY = 0;

    private static final String TYPE_WORK_START_DELAY_LOG_INFO = "Waiting for %dms to start typing 'WORK'...";
    private static final String TYPE_WORK_TYPING_LOG_INFO = "Typing 'WORK'...";
    private static final String TYPE_WORK_INTERVAL_LOG_INFO = "Type 'WORK' completed. Now waiting for %dms...";

    private static final String TYPE_WORK_TEXT = "/work\t\n";

    private static final String INTERRUPTED_EXCEPTION_ERROR_MESSAGE = "Oops! Something goes wrong while typing 'WORK'!";

    public Worker(Typer typer) {
        super(typer, WORK_THREAD_NAME);

        setupErrorLogInfo(INTERRUPTED_EXCEPTION_ERROR_MESSAGE);
    }

    private void work() throws InterruptedException {
        log(TYPE_WORK_START_DELAY_LOG_INFO, startDelay);
        Thread.sleep(startDelay);

        log(TYPE_WORK_TYPING_LOG_INFO);
        typer.typeString(TYPE_WORK_TEXT, DEFAULT_START_DELAY, DEFAULT_END_DELAY);

        log(TYPE_WORK_INTERVAL_LOG_INFO, interval);

        Thread.sleep(interval);
    }

    @Override
    protected void executeJob() throws InterruptedException {
        work();
    }
}
