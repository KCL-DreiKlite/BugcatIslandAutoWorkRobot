package priv.kcl.bugcatisland.autoworkrobot.core;

public class GamblerRPS extends AutoRobot {

    public static final String GAMBLE_RPS_THREAD_NAME = "gambleRPSThread";

    public static final int RPS_ROCK = 1;
    public static final int RPS_PAPER = 2;
    public static final int RPS_SCISSORS = 3;
    public static final int RPS_RANDOM = 4;

    private static final long DEFAULT_START_DELAY = 2000;
    private static final long DEFAULT_END_DELAY = 5000;

    private static final String TYPE_GAMBLE_RPS_START_DELAY_LOG_INFO = "Waiting for %dms to start typing 'RPS'...";
    private static final String TYPE_GAMBLE_RPS_TYPING_LOG_INFO = "Typing 'RPS'...";
    private static final String TYPE_GAMBLE_RPS_INTERVAL_LOG_INFO = "Type 'RPS' completed. Now waiting for %dms...";

    private static final String TYPE_GAMBLE_RPS_TEXT = "/rps\t%d\t%s\t\n";
    private static final String TYPE_ROCK_TEXT = "rock";
    private static final String TYPE_PAPER_TEXT = "paper";
    private static final String TYPE_SCISSORS_TEXT = "scissors";

    private static final String INTERRUPTED_EXCEPTION_ERROR_MESSAGE = "Oops! Something goes wrong while typing 'RPS'!";

    private int gambleCash;
    private int rpsWhichHand;

    public GamblerRPS(Typer typer) {
        super(typer, GAMBLE_RPS_THREAD_NAME);

        setupErrorLogInfo(INTERRUPTED_EXCEPTION_ERROR_MESSAGE);
    }

    public void setupAttributes(long startDelay, long interval, int gambleCash, int rpsWhichHand) {
        setupAttributes(startDelay, interval);
        this.gambleCash = gambleCash;
        this.rpsWhichHand = rpsWhichHand;
    }

    private void gamble() throws InterruptedException {
        log(TYPE_GAMBLE_RPS_START_DELAY_LOG_INFO, startDelay);
        Thread.sleep(startDelay);

        log(TYPE_GAMBLE_RPS_TYPING_LOG_INFO);
        String whichHand;
        switch (rpsWhichHand) {
            case RPS_ROCK:
                whichHand = TYPE_ROCK_TEXT;
                break;
            case RPS_PAPER:
                whichHand = TYPE_PAPER_TEXT;
                break;
            case RPS_SCISSORS:
                whichHand = TYPE_SCISSORS_TEXT;
                break;
            default:
                int random = (int) (Math.random() * 3);
                switch (random) {
                    case 0:
                        whichHand = TYPE_ROCK_TEXT;
                        break;
                    case 1:
                        whichHand = TYPE_PAPER_TEXT;
                        break;
                    default:
                        whichHand = TYPE_SCISSORS_TEXT;
                }
        }
        String preTypedText = String.format(TYPE_GAMBLE_RPS_TEXT, gambleCash, whichHand);
        typer.typeString(preTypedText, DEFAULT_START_DELAY, DEFAULT_END_DELAY);

        log(TYPE_GAMBLE_RPS_INTERVAL_LOG_INFO, interval);

        Thread.sleep(interval);
    }

    @Override
    protected void executeJob() throws InterruptedException {
        gamble();
    }
}
