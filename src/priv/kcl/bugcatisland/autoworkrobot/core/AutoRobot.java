package priv.kcl.bugcatisland.autoworkrobot.core;

import priv.kcl.bugcatisland.autoworkrobot.view.Model;

public abstract class AutoRobot implements Runnable {

    protected final Typer typer;
    protected final String robotThreadName;

    protected long startDelay;
    protected long interval;

    protected String interruptedExceptionLogInfo;

    protected Thread robotThread;
    protected boolean stopThread;

    protected Model.LogPrinter logPrinter;

    public AutoRobot(Typer typer, String robotThreadName) {
        this.typer = typer;
        this.robotThreadName = robotThreadName;
    }

    protected void initRobotThread() {
        robotThread = new Thread(this);
        robotThread.setName(robotThreadName);
    }

    public void setupAttributes(long startDelay, long interval) {
        this.startDelay = startDelay;
        this.interval = interval;
    }

    protected void setupErrorLogInfo(String interruptedExceptionLogInfo) {
        this.interruptedExceptionLogInfo = interruptedExceptionLogInfo;
    }

    public void startRobot() {
        initRobotThread();
        stopThread = false;
        robotThread.start();
    }

    public void stopRobot() {
        stopThread = true;
    }

    protected void log(String message, Object ... parameters) {
        if (logPrinter == null)
            return;

        logPrinter.log(message, parameters);
    }

    protected void executeJob() throws InterruptedException {}

    public void setLogPrinter(Model.LogPrinter logPrinter) {
        this.logPrinter = logPrinter;
    }

    @Override
    public void run() {
        try {
            while (!stopThread) {
                executeJob();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            log(interruptedExceptionLogInfo);
            stopRobot();
        }
    }
}
