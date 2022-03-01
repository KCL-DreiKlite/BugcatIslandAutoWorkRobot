package priv.kcl.bugcatisland.autoworkrobot.core;

public class GamblerDICE extends AutoRobot {

    public static final String GAMBLE_DICE_THREAD_NAME = "gambleDICEThread";

    private static final long DEFAULT_START_DELAY = 2000;
    private static final long DEFAULT_END_DELAY = 3000;

    private static final String TYPE_GAMBLE_DICE_START_DELAY_LOG_INFO = "Waiting for %dms to start typing 'DICE'...";
    private static final String TYPE_GAMBLE_DICE_TYPING_LOG_INFO = "Typing 'DICE'...";
    private static final String TYPE_GAMBLE_DICE_INTERVAL_LOG_INFO = "Type 'DICE' completed. Now waiting for %dms...";

    private static final String TYPE_GAMBLE_DICE_TEXT = "/dice\t%d\t\n";

    private static final String INTERRUPTED_EXCEPTION_ERROR_MESSAGE = "Oops! Something goes wrong while typing 'DICE'!";

    private int gambleCash;

    public GamblerDICE(Typer typer) {
        super(typer, GAMBLE_DICE_THREAD_NAME);

        setupErrorLogInfo(INTERRUPTED_EXCEPTION_ERROR_MESSAGE);
    }

    public void setupAttributes(long startDelay, long interval, int gambleCash) {
        setupAttributes(startDelay, interval);
        this.gambleCash = gambleCash;
    }

    private void gamble() throws InterruptedException {
        log(TYPE_GAMBLE_DICE_START_DELAY_LOG_INFO, startDelay);
        Thread.sleep(startDelay);

        log(TYPE_GAMBLE_DICE_TYPING_LOG_INFO);
        String preTypedText = String.format(TYPE_GAMBLE_DICE_TEXT, gambleCash);
        typer.typeString(preTypedText, DEFAULT_START_DELAY, DEFAULT_END_DELAY);

        log(TYPE_GAMBLE_DICE_INTERVAL_LOG_INFO, interval);

        Thread.sleep(interval);
    }

    @Override
    protected void executeJob() throws InterruptedException {
        gamble();
    }
}
