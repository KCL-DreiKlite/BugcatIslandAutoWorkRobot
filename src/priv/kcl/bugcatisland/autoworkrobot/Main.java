package priv.kcl.bugcatisland.autoworkrobot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Robot start offset in second (default: 10 sec.) = ");
            String input = scanner.nextLine();
            long startTimeOffset;
            if (input.equals(""))
                startTimeOffset = 10;
            else
                startTimeOffset = Long.parseLong(input);

            System.out.println("Robot will be started after " + startTimeOffset + " second.");
            System.out.println("You can stop program anytime by type in Ctrl + C or just simply close this window.");

            new AutoRobot(startTimeOffset * 1000);
        }
        catch (NumberFormatException e) {
            System.err.println("Please enter a valid number");
        }
    }
}
