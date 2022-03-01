package priv.kcl.bugcatisland.autoworkrobot;

import priv.kcl.bugcatisland.autoworkrobot.core.Typer;
import priv.kcl.bugcatisland.autoworkrobot.view.Model;
import priv.kcl.bugcatisland.autoworkrobot.view.ViewModel;
import priv.kcl.bugcatisland.autoworkrobot.view.Viewer;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
//    static {
//        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] %5$s%6$s%n");
//    }

    public static void main(String[] args) {
        final int robotAutoDelay = 200;
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(robotAutoDelay);

            Typer typer = new Typer(robot);
            typer.setDebugMode(false);

            SwingUtilities.invokeLater(() -> {
                new Viewer(new ViewModel(new Model(typer)));
            });
        }
        catch (AWTException e) {

        }
////        try {
//            // Define new console scanner.
//            Scanner scanner = new Scanner(System.in);
//
//            // Let scanner have a place to store input
//            String input;
//
//            // Define logger.
////            Logger logger = Logger.getLogger(AutoRobot.LOGGER_NAME);
//
//            // Define some attributes.
//            int autoMode = AutoRobot.WORK_DAILY_GAMBLE;
//            long autoWorkDelay = AutoRobot.ONE_HOUR_DELAY;
//            int openedGames = AutoRobot.DISABLE_GAMBLE;
//            int gambleAmount = AutoRobot.DEFAULT_GAMBLE_AMOUNT;
//            long gambleDelay = AutoRobot.DEFAULT_GAMBLE_DELAY;
//            long startTimeOffset;
//
//            // Let user select auto mode.
//            while (true) {
//                System.out.print(
//                        "\n" +
//                        "Which robot do you prefer to use?\n" +
//                        "1) Work only\n" +
//                        "2) Work and receive Daily reward\n" +
//                        "3) Work, receive Daily reward, and gamble\n" +
//                        "[Default: 3] : ");
//                input = scanner.nextLine();
//                if (input.equals("")) {
//                    autoMode = AutoRobot.WORK_DAILY_GAMBLE;
//                }
//                else {
//                    try {
//                        int tmp = Integer.parseInt(input);
//                        if (tmp < 1 || tmp > 3) {
//                            System.out.println("Please enter a valid number");
//                            continue;
//                        }
//                        autoMode = tmp;
//                    }
//                    catch (NumberFormatException e) {
//                        System.out.println("Please enter a valid number");
//                        continue;
//                    }
//                }
//                break;
//            }
//
//            // Let user adjust work delay time.
//            while (true) {
//                System.out.print(
//                        "\n" +
//                        "How long would you like to work everytime? (min.)\n" +
//                        "[Default: 60 min., Min: 60 min.] : ");
//                input = scanner.nextLine();
//                if (input.equals("")) {
//                    autoWorkDelay = AutoRobot.ONE_HOUR_DELAY;
//                }
//                else {
//                    try {
//                        int tmp = Integer.parseInt(input);
//                        if (tmp < 60) {
//                            System.out.println("The delay time must at least 60 min.");
//                            continue;
//                        }
//                        autoWorkDelay = tmp * 1000 + 1000;
//                    }
//                    catch (NumberFormatException e) {
//                        System.out.println("Please enter a valid number");
//                        continue;
//                    }
//                }
//                break;
//            }
//
//            // Let user decide to open some game or not
//            if (autoMode == AutoRobot.WORK_DAILY_GAMBLE) {
//                while (true) {
//                    System.out.print(
//                            "\n" +
//                            "Which game would you like to open?\n" +
//                            "1) DICE only\n" +
//                            "2) RPS only\n" +
//                            "3) DICE and RPS\n" +
//                            "[Default: 3] : ");
//                    input = scanner.nextLine();
//                    if (input.equals(""))
//                        openedGames = AutoRobot.DICE_AND_RPS;
//                    else {
//                        try {
//                            int tmp = Integer.parseInt(input);
//                            if (tmp < 1 || tmp > 3) {
//                                System.out.println("Please enter a valid number");
//                                continue;
//                            }
//                            openedGames = tmp;
//                        }
//                        catch (NumberFormatException e) {
//                            System.out.println("Please enter a valid number");
//                            continue;
//                        }
//                    }
//                    break;
//                }
//            }
//
//            // Let user adjust the amount of every gamble.
//            if (autoMode == AutoRobot.WORK_DAILY_GAMBLE) {
//                while (true) {
//                    System.out.print(
//                            "\n" +
//                            "How much money would you like to use for each gamble?\n" +
//                            "If you want to place order with random money, please enter -1.\n" +
//                            "[Default: 240, Available: -1; 1 ~ 240] : ");
//                    input = scanner.nextLine();
//                    if (input.equals(""))
//                        gambleAmount = AutoRobot.DEFAULT_GAMBLE_AMOUNT;
//                    else {
//                        try {
//                            int tmp = Integer.parseInt(input);
//                            if (tmp < -1 || tmp > 240) {
//                                System.out.println("Please enter a valid number");
//                                continue;
//                            }
//                            else if (tmp == 0) {
//                                System.out.println("0 is not allowed");
//                                continue;
//                            }
//                            gambleAmount = tmp;
//                        }
//                        catch (NumberFormatException e) {
//                            System.out.println("Please enter a valid number");
//                            continue;
//                        }
//                    }
//                    break;
//                }
//            }
//
//            // Let user adjust the delay time of every gamble.
//            if (autoMode == AutoRobot.WORK_DAILY_GAMBLE) {
//                while (true) {
//                    System.out.print(
//                            "\n" +
//                            "How long would you like to delay between each game?\n" +
//                            "[Default: 70 sec., Min: 70 sec.] : ");
//                    input = scanner.nextLine();
//                    if (input.equals(""))
//                        gambleDelay = AutoRobot.DEFAULT_GAMBLE_DELAY;
//                    else {
//                        try {
//                            int tmp = Integer.parseInt(input);
//                            if (tmp < 70) {
//                                System.out.println("Please enter a valid number");
//                                continue;
//                            }
//                            gambleDelay = tmp;
//                        }
//                        catch (NumberFormatException e) {
//                            System.out.println("Please enter a valid number");
//                            continue;
//                        }
//                    }
//                    break;
//                }
//            }
//
//            // Enter the start offset time.
//            while (true) {
//                System.out.print("Robot start offset [Default: 10 sec., Min: 3 sec.] : ");
//                input = scanner.nextLine();
//                if (input.equals(""))
//                    startTimeOffset = 10000;
//                else {
//                    try {
//                        int tmp = Integer.parseInt(input);
//                        if (tmp < 3) {
//                            System.out.println("Please enter a valid number");
//                            continue;
//                        }
//                        startTimeOffset = tmp * 1000L;
//                    }
//                    catch (NumberFormatException e) {
//                        System.out.println("Please enter a valid number");
//                        continue;
//                    }
//                }
//                break;
//            }
//
////            System.out.print("Robot start offset in second (default: 10 sec.) = ");
////            if (input.equals(""))
////                startTimeOffset = 10;
////            else
////                startTimeOffset = Long.parseLong(input);
//
//            Logger logger = Logger.getLogger(AutoRobot.LOGGER_NAME);
//
//            logger.info("Robot will be started after " + startTimeOffset + " second.");
//            logger.info("You can stop program anytime by type in Ctrl + C or just simply close this window.");
//
//            new AutoRobot(autoMode, autoWorkDelay, openedGames, gambleAmount, gambleDelay, startTimeOffset);
//        }
//        catch (NumberFormatException e) {
//            System.err.println("Please enter a valid number");
//        }
    }
}
