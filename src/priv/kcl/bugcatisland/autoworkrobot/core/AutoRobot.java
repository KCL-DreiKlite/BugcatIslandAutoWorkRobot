package priv.kcl.bugcatisland.autoworkrobot.core;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoRobot {
    public static final int WORK_ONLY = 1;
    public static final int WORK_AND_DAILY = 2;
    public static final int WORK_DAILY_GAMBLE = 3;

    public static final long DEFAULT_OPERATION_DELAY = 100;
    public static final long ONE_DAY_DELAY = 3600000 * 24;
    public static final long ONE_HOUR_DELAY = 3600000;
    public static final long ONE_MINUTE_DELAY = 60000;
    public static final long ONE_SECOND_DELAY = 1000;

    public static final int DISABLE_GAMBLE = -1;
    public static final int DICE_ONLY = 1;
    public static final int RPS_ONLY = 2;
    public static final int DICE_AND_RPS = 3;

    public static final String RPS_STONE = "stone";
    public static final String RPS_PAPER = "paper";
    public static final String RPS_SCISSORS = "scissors";

    public static final int DEFAULT_GAMBLE_AMOUNT = 240;
    public static final int RANDOM_GAMBLE_AMOUNT = -1;

    public static final int DEFAULT_GAMBLE_DELAY = 70000;

    public static final long DEFAULT_DELAY_TIME = 2000;

    public static final String AUTO_WORK_ROBOT_START_INFO =
            "\n" +
            ">>> =====================================\n" +
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
            "Author: __**KCL (<@353144875874648065>)**__\n" +
            "SHA256 License:\n" +
            "__**b95b7125c6d21a24e88b85d88ddd0853c5e3b4f108bae0e2bf91949971d9f760**__\n" +
            "Github:\n" +
            "__**https://github.com/KCL-DreiKlite/BugcatIslandAutoWorkRobot**__\n" +
            "=====================================";

    public static final String LOGGER_NAME = "AutoWorkRobotLog";

    public static Logger getDefaultLogger() {
        return Logger.getLogger(LOGGER_NAME);
    }

    private Robot robot;

    private Logger logger;

    private final int autoMode;
    private final long autoWorkDelay;
    private final int openedGames;
    private final int gambleAmount;
    private final long gambleDelay;
    private final long timeOffset;

    private boolean isOccupiedTextField = false;

    public AutoRobot(
            int autoMode,
            long autoWorkDelay,
            int openedGames,
            int gambleAmount,
            long gambleDelay,
            long timeOffset) {
        this.autoMode = autoMode;
        this.autoWorkDelay = autoWorkDelay;
        this.openedGames = openedGames;
        this.gambleAmount = gambleAmount;
        this.gambleDelay = gambleDelay;
        this.timeOffset = timeOffset;

        try {
            logger = Logger.getLogger(LOGGER_NAME);

            // Define a new robot.
            robot = new Robot();
            robot.setAutoDelay((int)DEFAULT_OPERATION_DELAY);
            Thread.sleep(timeOffset);

            logger.log(Level.INFO, "Robot started...");

            // Enter robot license first.
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable originalContent = clipboard.getContents(null);     // Make sure we won't affect the original content of system clipboard
            clipboard.setContents(new StringSelection(AUTO_WORK_ROBOT_START_INFO), null);
            inputCtrlV();
            clipboard.setContents(originalContent, null);   // Give back the original clipboard content

            // Auto work thread
            new Thread(() -> {
                try {
                    while (true) {
                        logger.info("Typing 'WORK'...");
                        typeWork(DEFAULT_DELAY_TIME);
                        logger.info("Type in 'WORK' completed. Now waiting...");
                        Thread.sleep(ONE_HOUR_DELAY);
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
                    Thread.sleep(500);
                    while (true) {
                        logger.info("Typing 'DAILY'...");
                        typeDaily(DEFAULT_DELAY_TIME);
                        logger.info("Type in 'DAILY' completed. Now waiting...");
                        Thread.sleep(ONE_DAY_DELAY);
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
                        typeDice(240, 0);
                        logger.info("Type in 'DICE' completed. Now waiting...");
                        Thread.sleep(ONE_MINUTE_DELAY);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }).start();

            // Auto rps thread

        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void typeWork(long timeOffset) throws InterruptedException {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

//        inputString("/work\t\n");

        Thread.sleep(timeOffset);
    }

    private void typeRps(int coins, long timeOffset) throws InterruptedException {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        String sign = RPS_STONE;


    }

    private void typeDice(int coins, long timeOffset) throws InterruptedException {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

//        inputString("/dice " + coins + "\t\n");

        Thread.sleep(timeOffset);
    }

    private void typeDaily(long timeOffset) throws InterruptedException {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

//        inputString("/daily\t\n");

        Thread.sleep(timeOffset);
    }

//    private synchronized void inputString(String input) {
//        if (robot == null) {
//            System.err.println("Error! Robot is not declared!");
//            return;
//        }
//
//        input = input.toUpperCase();
//
//        for (char c : input.toCharArray())
//            inputCharacter(c);
//    }
//
//    private synchronized void inputCharacter(char character) {
//        if (robot == null) {
//            System.err.println("Error! Robot is not declared!");
//            return;
//        }
//
//        robot.keyPress(character);
//        robot.keyRelease(character);
//    }

    private synchronized void inputCtrlV() {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

//        inputCharacter('\n');
    }

    private synchronized void occupiyTextfield(long delay) throws InterruptedException {
        Thread.sleep(500);
    }
}
