package priv.kcl.bugcatisland.autoworkrobot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoRobot implements Runnable {
    public static final int DEFAULT_OPERATION_DELAY = 200;
    public static final int ONE_HOUR_DELAY = 3610000;

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
            new Thread(this).start();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                logger.log(Level.INFO, "Typing...");
                typeWork();
                logger.log(Level.INFO, "Type in completed. Now waiting...");
                Thread.sleep(ONE_HOUR_DELAY);
            }
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

        typeCharacter(KeyEvent.VK_SLASH);
        typeCharacter(KeyEvent.VK_W);
        typeCharacter(KeyEvent.VK_O);
        typeCharacter(KeyEvent.VK_R);
        typeCharacter(KeyEvent.VK_K);
        typeCharacter(KeyEvent.VK_TAB);
        typeCharacter(KeyEvent.VK_ENTER);
    }
    private void typeCharacter(int character) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        robot.keyPress(character);
        robot.keyRelease(character);
    }
}
