package priv.kcl.bugcatisland.autoworkrobot;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] %5$s%6$s%n");
    }

    public static void main(String[] args) {
//        String string = "This is a copied string";
//        StringSelection stringSelection = new StringSelection(string);
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(stringSelection, null);

        try {
            // Define new console scanner.
            Scanner scanner = new Scanner(System.in);

            // Let scanner have a place to store input
            String input;

            // Define logger.
//            Logger logger = Logger.getLogger(AutoRobot.LOGGER_NAME);

            // Let user select auto mode.
            int autoMode;
            while (true) {
                System.out.print(
                        "Which robot do you prefer to use?\n" +
                        "1) Work only\n" +
                        "2) Work and receive Daily reward\n" +
                        "3) Work, receive Daily reward, and gamble\n" +
                        "[Default: 3] : ");
                input = scanner.nextLine();
                if (input.equals("")) {
                    autoMode = AutoRobot.WORK_DAILY_GAMBLE;
                }
                else {
                    try {
                        int tmp = Integer.parseInt(input);
                        if (tmp < 1 || tmp > 3) {
                            System.out.println("Please enter a valid number\n");
                            continue;
                        }
                        autoMode = tmp;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number\n");
                        continue;
                    }
                }
                break;
            }

            // Let user adjust work delay time.
            int autoWorkDelay;
            while (true) {
                System.out.print(
                        "How long would you like to work everytime? (min.)\n" +
                        "[Default: 60 min.] : ");
                input = scanner.nextLine();
                if (input.equals("")) {
                    autoWorkDelay = AutoRobot.ONE_HOUR_DELAY;
                }
                else {
                    try {
                        int tmp = Integer.parseInt(input) * 1000 + 1000;
                        if (tmp < 60) {
                            System.out.println("The delay time must at least 60 min.\n");
                            continue;
                        }
                        autoWorkDelay = tmp;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number\n");
                        continue;
                    }
                }
                break;
            }



            System.out.print("Robot start offset in second (default: 10 sec.) = ");
            long startTimeOffset;
            if (input.equals(""))
                startTimeOffset = 10;
            else
                startTimeOffset = Long.parseLong(input);

            Logger logger = Logger.getLogger(AutoRobot.LOGGER_NAME);

            logger.info("Robot will be started after " + startTimeOffset + " second.");
            logger.info("You can stop program anytime by type in Ctrl + C or just simply close this window.");

            new AutoRobot(startTimeOffset * 1000);
        }
        catch (NumberFormatException e) {
            System.err.println("Please enter a valid number");
        }
    }
}
