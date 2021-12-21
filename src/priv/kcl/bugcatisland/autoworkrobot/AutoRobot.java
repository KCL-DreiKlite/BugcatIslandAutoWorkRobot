package priv.kcl.bugcatisland.autoworkrobot;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoRobot {
    public static final int DEFAULT_OPERATION_DELAY = 200;
    public static final int ONE_DAY_DELAY = 3600000 * 24;
    public static final int ONE_HOUR_DELAY = 3610000;
    public static final int ONE_MINUTE_DELAY = 70000;

    public static final String AUTO_WORK_ROBOT_START__INFO =
            "\n" +
            ">>> ======================================================\n" +
            "This robot is made for automatically work, gamble,\n" +
            "and receive daily reward. You may only use this\n" +
            "robot in Discord server: BUGCAT ISLAND, which\n" +
            "originally created by YARA, the author of \"Bugcat\n" +
            "Capoo\". Also, this robot can be operated in \"Dogdog\n" +
            "bot command text channel\" only. If you use this in\n" +
            "any other text channel, you will be punished by\n" +
            "administrator, so be careful when you trying to use\n" +
            "this robot.\n" +
            "\n" +
            "Author: __**KCL (KCL#7118)**__\n" +
            "SHA256 License:\n" +
            "__**b95b7125c6d21a24e88b85d88ddd0853c5e3b4f108bae0e2bf91949971d9f760**__\n" +
            "Github:\n" +
            "https://github.com/KCL-DreiKlite/BugcatIslandAutoWorkRobot\n" +
            "======================================================";

    public static final String LOGGER_NAME = "AutoWorkRobotLog";

    private Robot robot;

    private Logger logger;

    public AutoRobot(long timeOffset) {
        try {
            logger = Logger.getLogger(LOGGER_NAME);

            // Define a new robot.
            robot = new Robot();
            robot.setAutoDelay(DEFAULT_OPERATION_DELAY);

            Thread.sleep(timeOffset);

            logger.log(Level.INFO, "Robot started...");

            // Enter robot license first.
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(AUTO_WORK_ROBOT_START__INFO), null);
            inputCtrlV();

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

        inputString("/work");
    }

    private void typeDice(int coins) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        inputString("/dice " + coins);
    }

    private void typeDaily() {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        inputString("/daily");
    }

    private synchronized void inputString(String input) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        input = input.toUpperCase();

        for (char c : input.toCharArray())
            inputCharacter(c);
        inputCharacter('\t');
        inputCharacter('\n');
    }

    private synchronized void inputCharacter(char character) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        robot.keyPress(character);
        robot.keyRelease(character);
    }

    private synchronized void inputCtrlV() {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        inputCharacter('\n');
    }
}
