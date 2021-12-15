package priv.kcl.bugcatisland.autoworkrobot;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try {
            Logger logger = Logger.getLogger(AutoRobot.LOGGER_NAME);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Robot start offset in second (default: 10 sec.) = ");
            String input = scanner.nextLine();
            long startTimeOffset;
            if (input.equals(""))
                startTimeOffset = 10;
            else
                startTimeOffset = Long.parseLong(input);

            logger.log(Level.INFO, "Robot will be started after " + startTimeOffset + " second.");
            logger.log(Level.INFO, "You can stop program anytime by type in Ctrl + C or just simply close this window.");

            new AutoRobot(startTimeOffset * 1000);
        }
        catch (NumberFormatException e) {
            System.err.println("Please enter a valid number");
        }
    }
}
