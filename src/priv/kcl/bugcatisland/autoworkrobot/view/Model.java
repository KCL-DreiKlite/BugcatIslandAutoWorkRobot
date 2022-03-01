package priv.kcl.bugcatisland.autoworkrobot.view;

import priv.kcl.bugcatisland.autoworkrobot.core.*;

public class Model {

    private LogPrinter logPrinter;

    private Typer typer;

    private Worker worker;
    private DailyReceiver dailyReceiver;
    private GamblerRPS gamblerRPS;
    private GamblerDICE gamblerDICE;

    private boolean isEnableReceiver;
    private boolean isEnableRPS;
    private boolean isEnableDICE;

    public Model(Typer typer) {
        this.typer = typer;

        initAllRobots();
    }

    private void initAllRobots() {
        worker = new Worker(typer);
        dailyReceiver = new DailyReceiver(typer);
        gamblerRPS = new GamblerRPS(typer);
        gamblerDICE = new GamblerDICE(typer);
    }

    private void initAllLogPrinter() {
        typer.setLogPrinter(this.logPrinter);
        worker.setLogPrinter(this.logPrinter);
        dailyReceiver.setLogPrinter(this.logPrinter);
        gamblerRPS.setLogPrinter(this.logPrinter);
        gamblerDICE.setLogPrinter(this.logPrinter);
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
        this.isEnableReceiver = enableReceiver;
        this.isEnableRPS = enableRPS;
        this.isEnableDICE = enableDICE;

        worker.setupAttributes(workerStartDelay * 1000L, workerInterval * 1000L * 60);
        dailyReceiver.setupAttributes(receiverStartDelay * 1000L, receiverInterval * 1000L * 60 * 60 * 24);
        gamblerRPS.setupAttributes(gambleRPSStartDelay * 1000L, gambleRPSInterval * 1000L, gambleRPSGambleCash, gambleRPSWhichHand);
        gamblerDICE.setupAttributes(gambleDICEStartDelay * 1000L, gambleDICEInterval * 1000L, gambleDICEGambleCash);
    }

    public void startRobot() {
        typer.turnOnTyper();

        worker.startRobot();
        if (isEnableReceiver) dailyReceiver.startRobot();
        if (isEnableRPS) gamblerRPS.startRobot();
        if (isEnableDICE) gamblerDICE.startRobot();
    }

    public void stopRobot() {
        typer.turnOffTyper();

        worker.stopRobot();
        dailyReceiver.stopRobot();
        gamblerRPS.stopRobot();
        gamblerDICE.stopRobot();
    }

    private synchronized void log(String message, Object ... parameters) {
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
