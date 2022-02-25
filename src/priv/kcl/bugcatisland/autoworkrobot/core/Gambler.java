package priv.kcl.bugcatisland.autoworkrobot.core;

import java.awt.*;
import java.util.Scanner;
import java.util.logging.Level;

public class Gambler implements Runnable {

    private static final Level DEFAULT_LOG_LEVEL = Level.INFO;

    private static final long DEFAULT_START_DELAY = 0;
    private static final long DEFAULT_END_DELAY = 0;

    public static final int DEFAULT_GAMBLE_INTERVAL = 70000;

    private static final String TYPE_DICE_UNFORMATTED_TEXT = "/dice\t{0}\t\n";
    private static final String TYPE_RPS_UNFORMATTED_TEXT = "/rps\t{0}\t{1}\t\n";
    private static final String TYPE_ROULETTE_UNFORMATTED_TEXT = "/roulette\t{0}\t\n";

    private final Robot robot;

    private boolean isDoingRPS;
    private boolean isDoingDICE;

    public Gambler(Robot robot, boolean isDoingRPS, boolean isDoingDICE) {
        this.robot = robot;
        this.isDoingRPS = isDoingRPS;
        this.isDoingDICE = isDoingDICE;
    }

    public void letUserInput(Scanner scanner) {

    }


    private void logMessage(String message, Object ... params) {
        AutoRobot.getDefaultLogger().log(DEFAULT_LOG_LEVEL, message, params);
    }

    private void doGamble() {
        // TODO: Complete this method!
//        try {
//
//        }
//        catch (InterruptedException e) {
//            System.err.println("Oops! Something goes wrong while typing 'WORK'!");
//            e.printStackTrace();
//            System.exit(1);
//        }
    }

    @Override
    public void run() {

    }
}
