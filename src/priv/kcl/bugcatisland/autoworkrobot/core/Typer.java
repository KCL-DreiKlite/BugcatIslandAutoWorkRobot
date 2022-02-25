package priv.kcl.bugcatisland.autoworkrobot.core;

import java.awt.*;
import java.util.logging.Level;

public class Typer {
    private static final Level DEFAULT_LOGGER_LEVEL = Level.FINEST;

    private static final String TYPE_STRING_CONVERT_TO_UPPERCASE_LOG_INFO = "Converting {0} to upper case ...";
    private static final String TYPE_STRING_START_DELAY_LOG_INFO = "Ready to type \"{0}\", start time delay = {1} ms.";
    private static final String TYPE_STRING_TYPING_LOG_INFO = "Typing \"{0}\" ...";
    private static final String TYPE_STRING_END_DELAY_LOG_INFO = "Type \"{0}\" completed. End time delay = {1} ms.";

    private static final String TYPE_CHARACTER_TYPING_LOG_INFO = "Typing '{0}' ...";

    public static synchronized void typeString(Robot robot, String text, long startDelay, long endDelay) throws InterruptedException {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
//            getDefaultLogger().severe("Error! Robot is not declared!");
            return;
        }

        logMessage(TYPE_STRING_CONVERT_TO_UPPERCASE_LOG_INFO, text);
        String preTypedText = text.toUpperCase();

        logMessage(TYPE_STRING_START_DELAY_LOG_INFO, preTypedText, startDelay);
        Thread.sleep(startDelay);

        logMessage(TYPE_STRING_TYPING_LOG_INFO, preTypedText);
        for (char c : preTypedText.toCharArray())
            typeCharacter(robot, c);

        logMessage(TYPE_STRING_END_DELAY_LOG_INFO, preTypedText, endDelay);
        Thread.sleep(endDelay);
    }

    public static synchronized void typeCharacter(Robot robot, char character) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }

        logMessage(TYPE_CHARACTER_TYPING_LOG_INFO, character);
        robot.keyPress(character);
        robot.keyRelease(character);
    }

    private static void logMessage(String message, Object ... params) {
        AutoRobot.getDefaultLogger().log(DEFAULT_LOGGER_LEVEL, message, params);
    }

//    private static Logger getDefaultLogger() {
//        return Logger.getLogger(AutoRobot.LOGGER_NAME);
//    }
}
