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
            Scanner scanner = new Scanner(System.in);
            System.out.print("Robot start offset in second (default: 10 sec.) = ");
            String input = scanner.nextLine();
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
