package priv.kcl.bugcatisland.autoworkrobot.view;

import priv.kcl.bugcatisland.autoworkrobot.core.*;

import java.awt.*;

public class Model {

    public static final int RPS_ROCK = 0;
    public static final int RPS_PAPER = 1;
    public static final int RPS_SCISSOR = 2;
    public static final int RPS_RANDOM = 3;

    private LogPrinter logPrinter;

    private Robot robot;

    private Worker worker;
    private DailyReceiver dailyReceiver;
    private Gambler gambler;
    private GamblerRPS gamblerRPS;
    private GamblerDICE gamblerDICE;

    public Model(Robot robot) {
        this.robot = robot;

        worker = new Worker(robot);
    }

    private void initAllLogPrinter() {
        worker.setLogPrinter(this.logPrinter);
    }

    public void setupRobotAttributes(int workerStartDelay,
                                     int workerInterval,
                                     boolean enableReceiver,
                                     int receiverStartDelay,
                                     int receiverInterval,
                                     boolean enableRPS,
                                     int gambleRPSStartDelay,
                                     int gambleRPSInterval,
                                     int gambleRPSGambleCash,
                                     int gambleRPSWhichHand,
                                     boolean enableDICE,
                                     int gambleDICEStartDelay,
                                     int gambleDICEInterval,
                                     int gambleDICEGambleCash) {
        worker.setupAttributes(workerStartDelay * 1000L, workerInterval * 1000L);
    }

    public void startRobot() {
        worker.startWorking();
    }

    public void stopRobot() {
        worker.stopWorking();
    }

    private void log(String message, Object ... parameters) {
        if (logPrinter == null)
            return;

        logPrinter.log(message, parameters);
    }

    public void setLogPrinter(LogPrinter logPrinter) {
        this.logPrinter = logPrinter;

        initAllLogPrinter();
    }

    public interface LogPrinter {
        void log(String message, Object ... parameters);
    }
}
