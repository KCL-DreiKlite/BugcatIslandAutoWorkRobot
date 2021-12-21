package priv.kcl.bugcatisland.autoworkrobot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoRobot {
    public static final int DEFAULT_OPERATION_DELAY = 200;
    public static final int ONE_DAY_DELAY = 3600000 * 24;
    public static final int ONE_HOUR_DELAY = 3610000;
    public static final int ONE_MINUTE_DELAY = 70000;

    public static final String AUTO_WORK_ROBOT_LICENSE_INFO =
            "=================================\n" +
            "This robot is made for auto work,\n" +
            "auto gamble, and auto ";

    public static final String LOGGER_NAME = "AutoWorkRobotLog";

    private Robot robot;

    private Logger logger;

    public AutoRobot(long timeOffset) {
        try {
            logger = Logger.getLogger(LOGGER_NAME);

            robot = new Robot();
            robot.setAutoDelay(DEFAULT_OPERATION_DELAY);

            Thread.sleep(timeOffset);



            logger.log(Level.INFO, "Robot started...");
            // Auto work thread
            new Thread(() -> {
                try {
                    while (true) {
                        logger.info("Typing 'WORK'...");
                        typeWork();
                        logger.info("Type in 'WORK' completed. Now waiting...");
                        Thread.sleep(ONE_HOUR_DELAY);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }).start();
            // Auto dice thread
            new Thread(() -> {
                try {
                    while (true) {
                        logger.info("Typing 'DICE'...");
                        typeDice(240);
                        logger.info("Type in 'DICE' completed. Now waiting...");
                        Thread.sleep(ONE_MINUTE_DELAY);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }).start();
            // Auto daily thread
            new Thread(() -> {
                try {
                    while (true) {
                        logger.info("Typing 'DAILY'...");
                        typeDaily();
                        logger.info("Type in 'DAILY' completed. Now waiting...");
                        Thread.sleep(ONE_DAY_DELAY);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }).start();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void typeWork() {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        typeString("/work");
    }

    private void typeDice(int coins) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        typeString("/dice " + coins);
    }

    private void typeDaily() {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        typeString("/daily");
    }

    private synchronized void typeString(String input) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        input = input.toUpperCase();

        for (char c : input.toCharArray())
            typeCharacter(c);
        typeCharacter('\t');
        typeCharacter('\n');
    }

    private synchronized void typeCharacter(char character) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        robot.keyPress(character);
        robot.keyRelease(character);
    }
}
