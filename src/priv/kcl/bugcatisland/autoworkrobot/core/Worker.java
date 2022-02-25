package priv.kcl.bugcatisland.autoworkrobot.core;

import priv.kcl.bugcatisland.autoworkrobot.view.Model;

import java.awt.*;
import java.util.Scanner;
import java.util.logging.Level;

public class Worker implements Runnable {

    public static final String WORK_THREAD_NAME = "workThread";

    private static final Level DEFAULT_LOG_LEVEL = Level.INFO;

    private static final long DEFAULT_START_DELAY = 1000;
    private static final long DEFAULT_END_DELAY = 0;

    private static final String TYPE_WORK_STARY_DELAY_INFO = "Waiting for %dms to start typing 'WORK'...";
    private static final String TYPE_WORK_TYPING_LOG_INFO = "Typing 'WORK' ...";
    private static final String TYPE_WORK_TYPE_INTERVAL_INFO = "Type 'WORK' completed. Now waiting for %dms ...";

    private static final String TYPE_WORK_TEXT = "/work\t\n";

    private static final String INTERRUPTED_EXCEPTION_ERROR_MESSAGE = "Oops! Something goes wrong while typing 'WORK'!";

    private Robot robot;

    private long workerStartDelay;
    private long workerInterval;

    private Thread workThread;

    private boolean isKeepThreadRunning;

    private Model.LogPrinter logPrinter;

    public Worker(Robot robot) {
        this.robot = robot;
    }

    public Worker(Robot robot, long workerStartDelay, long workerInterval) {
        this.robot = robot;
        this.workerStartDelay = workerStartDelay;
        this.workerInterval = workerInterval;
    }

    private void initWorkThread() {
        workThread = new Thread(this);
        workThread.setName(WORK_THREAD_NAME);

        setKeepThreadRunning(true);
    }

    public void setupAttributes(long workerStartDelay, long workerInterval) {
        this.workerStartDelay = workerStartDelay;
        this.workerInterval = workerInterval;
    }

    public void startWorking() {
        setKeepThreadRunning(true);
        initWorkThread();
        workThread.start();
    }

    public void stopWorking() {
        setKeepThreadRunning(false);
    }

//    private void logMessage(String message, Object ... params) {
//        AutoRobot.getDefaultLogger().log(DEFAULT_LOG_LEVEL, message, params);
//    }

    private void log(String message, Object ... parameters) {
        if (logPrinter == null)
            return;

        logPrinter.log(message, parameters);
    }

    private void work() throws InterruptedException {
        log(TYPE_WORK_TYPING_LOG_INFO);
        Typer.typeString(robot, TYPE_WORK_TEXT, DEFAULT_START_DELAY, DEFAULT_END_DELAY);

        log(TYPE_WORK_TYPE_INTERVAL_INFO, workerInterval);

        Thread.sleep(workerInterval);
    }

    public void setLogPrinter(Model.LogPrinter logPrinter) {
        this.logPrinter = logPrinter;
    }

    public synchronized void setKeepThreadRunning(boolean keepThreadRunning) {
        isKeepThreadRunning = keepThreadRunning;
    }

    @Override
    public void run() {
        try {
            log(TYPE_WORK_STARY_DELAY_INFO, workerStartDelay);
            Thread.sleep(workerStartDelay);

            while (isKeepThreadRunning)
                work();
        }
        catch (InterruptedException e) {
            log(INTERRUPTED_EXCEPTION_ERROR_MESSAGE);
            e.printStackTrace();

            System.exit(1);
        }
    }
}
