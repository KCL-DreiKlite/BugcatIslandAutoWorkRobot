package priv.kcl.bugcatisland.autoworkrobot.core;

import priv.kcl.bugcatisland.autoworkrobot.view.Model;

import java.awt.*;
import java.util.logging.Level;

public class Typer {
    private static final Level DEFAULT_LOGGER_LEVEL = Level.FINEST;

    private static final String TYPE_STRING_CONVERT_TO_UPPERCASE_LOG_INFO = "Converting %s to upper case ...";
    private static final String TYPE_STRING_START_DELAY_LOG_INFO = "Ready to type \"%s\", start time delay = %d ms.";
    private static final String TYPE_STRING_TYPING_LOG_INFO = "Typing \"%s\" ...";
    private static final String TYPE_STRING_END_DELAY_LOG_INFO = "Type \"%s\" completed. End time delay = %d ms.";

    private static final String TYPE_CHARACTER_TYPING_LOG_INFO = "Typing '%c' ...";

    private Robot robot;
    private Model.LogPrinter logPrinter;

    private boolean isStopTyping = false;

    private boolean isDebugMode = false;

    public Typer(Robot robot) {
        this.robot = robot;
    }

    public synchronized void typeString(String text, long startDelay, long endDelay) throws InterruptedException {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }
        if (isStopTyping)
            return;

        if (isDebugMode) log(TYPE_STRING_CONVERT_TO_UPPERCASE_LOG_INFO, text);
        String preTypedText = text.toUpperCase();

        if (isDebugMode) log(TYPE_STRING_START_DELAY_LOG_INFO, preTypedText, startDelay);
        Thread.sleep(startDelay);

        if (isDebugMode) log(TYPE_STRING_TYPING_LOG_INFO, preTypedText);
        for (char c : preTypedText.toCharArray())
            typeCharacter(robot, c);

        if (isDebugMode) log(TYPE_STRING_END_DELAY_LOG_INFO, preTypedText, endDelay);
        Thread.sleep(endDelay);
    }

    public synchronized void typeCharacter(Robot robot, char character) {
        if (robot == null) {
            System.err.println("Error! Robot is not declared!");
            return;
        }
        if (isStopTyping)
            return;

        if (isDebugMode) log(TYPE_CHARACTER_TYPING_LOG_INFO, character);
        robot.keyPress(character);
        robot.keyRelease(character);
    }

    public synchronized void turnOnTyper() {
        isStopTyping = false;
    }

    public synchronized void turnOffTyper() {
        isStopTyping = true;
    }

    private void log(String message, Object ... parameters) {
        if (logPrinter == null)
            return;

        logPrinter.log(message, parameters);
    }

    public void setLogPrinter(Model.LogPrinter logPrinter) {
        this.logPrinter = logPrinter;
    }

    public void setDebugMode(boolean debugMode) {
        isDebugMode = debugMode;
    }
}
