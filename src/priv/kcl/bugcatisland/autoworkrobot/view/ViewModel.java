package priv.kcl.bugcatisland.autoworkrobot.view;

import priv.kcl.bugcatisland.autoworkrobot.core.GamblerRPS;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ViewModel {
    public static final String VALUE_ATTRIBUTE_NAME = "Value";
    public static final String ENABLED_ATTRIBUTE_NAME = "Enabled";
    public static final String SELECTED_ATTRIBUTE_NAME = "Selected";
    public static final String TEXT_ATTRIBUTE_NAME = "Text";

    public static final String SPINNER_WORKER_START_DELAY_VALUE = "spinnerWorkerStartDelay_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_WORKER_INTERVAL_VALUE = "spinnerWorkerInterval_" + VALUE_ATTRIBUTE_NAME;

    public static final String CHECKBOX_ENABLE_RECEIVER_SELECTED = "checkboxEnableReceiver_" + SELECTED_ATTRIBUTE_NAME;
    public static final String SPINNER_RECEIVER_START_DELAY_VALUE = "spinnerReceiverStartDelay_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_RECEIVER_START_DELAY_ENABLED = "spinnerReceiverStartDelay_" + ENABLED_ATTRIBUTE_NAME;
    public static final String SPINNER_RECEIVER_INTERVAL_VALUE = "spinnerReceiverInterval_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_RECEIVER_INTERVAL_ENABLED = "spinnerReceiverInterval_" + ENABLED_ATTRIBUTE_NAME;

    public static final String CHECKBOX_ENABLE_RPS_SELECTED = "checkboxEnableRPS_" + SELECTED_ATTRIBUTE_NAME;
    public static final String SPINNER_RPS_START_DELAY_VALUE = "spinnerRPSStartDelay_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_RPS_START_DELAY_ENABLED = "spinnerRPSStartDelay_" + ENABLED_ATTRIBUTE_NAME;
    public static final String SPINNER_RPS_INTERVAL_VALUE = "spinnerRPSInterval_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_RPS_INTERVAL_ENABLED = "spinnerRPSInterval_" + ENABLED_ATTRIBUTE_NAME;
    public static final String SPINNER_RPS_GAMBLE_CASH_VALUE = "spinnerRPSGambleCash_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_RPS_GAMBLE_CASH_ENABLED = "spinnerRPSGambleCash_" + ENABLED_ATTRIBUTE_NAME;
    public static final String RADIO_BUTTON_RPS_ROCK_ENABLED = "radiobuttonRPSRock_" + ENABLED_ATTRIBUTE_NAME;
    public static final String RADIO_BUTTON_RPS_ROCK_SELECTED = "radiobuttonRPSRock_" + SELECTED_ATTRIBUTE_NAME;
    public static final String RADIO_BUTTON_RPS_PAPER_ENABLED = "radiobuttonRPSPaper_" + ENABLED_ATTRIBUTE_NAME;
    public static final String RADIO_BUTTON_RPS_PAPER_SELECTED = "radiobuttonRPSPaper_" + SELECTED_ATTRIBUTE_NAME;
    public static final String RADIO_BUTTON_RPS_SCISSOR_ENABLED = "radiobuttonRPSScissor_" + ENABLED_ATTRIBUTE_NAME;
    public static final String RADIO_BUTTON_RPS_SCISSORS_SELECTED = "radiobuttonRPSScissor_" + SELECTED_ATTRIBUTE_NAME;
    public static final String RADIO_BUTTON_RPS_RANDOM_ENABLED = "radiobuttonRPSRandom_" + ENABLED_ATTRIBUTE_NAME;
    public static final String RADIO_BUTTON_RPS_RANDOM_SELECTED = "radiobuttonRPSRandom_" + SELECTED_ATTRIBUTE_NAME;
    public static final String BUTTON_GROUP_RPS_SELECTED = "buttongroupRPS_" + SELECTED_ATTRIBUTE_NAME;

    public static final String CHECKBOX_ENABLE_DICE_SELECTED = "checkboxEnableDICE_" + SELECTED_ATTRIBUTE_NAME;
    public static final String SPINNER_DICE_START_DELAY_VALUE = "spinnerDICEStartDelay_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_DICE_START_DELAY_ENABLED = "spinnerDICEStartDelay_" + ENABLED_ATTRIBUTE_NAME;
    public static final String SPINNER_DICE_INTERVAL_VALUE = "spinnerDICEInterval_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_DICE_INTERVAL_ENABLED = "spinnerDICEInterval_" + ENABLED_ATTRIBUTE_NAME;
    public static final String SPINNER_DICE_GAMBLE_CASH_VALUE = "spinnerDICEGambleCash_" + VALUE_ATTRIBUTE_NAME;
    public static final String SPINNER_DICE_GAMBLE_CASH_ENABLED = "spinnerDICEGambleCash_" + ENABLED_ATTRIBUTE_NAME;

    public static final String TEXT_AREA_LOG_MESSAGE_TEXT = "textareaLogMessage_" + TEXT_ATTRIBUTE_NAME;

    public static final String BUTTON_START_ROBOT_ENABLED = "buttonStartRobot_" + ENABLED_ATTRIBUTE_NAME;
    public static final String BUTTON_STOP_ROBOT_ENABLED = "buttonStopRobot_" + ENABLED_ATTRIBUTE_NAME;

    public static final int SPINNER_WORK_START_DELAY_UPPER_LIMIT = 86400;
    public static final int SPINNER_WORK_START_DELAY_DEFAULT_VALUE = 5;
    public static final int SPINNER_WORK_START_DELAY_LOWER_LIMIT = 3;
    public static final int SPINNER_WORK_INTERVAL_UPPER_LIMIT = 1440;
    public static final int SPINNER_WORK_INTERVAL_DEFAULT_VALUE = 61;
    public static final int SPINNER_WORK_INTERVAL_LOWER_LIMIT = 60;

    public static final int SPINNER_RECEIVER_START_DELAY_UPPER_LIMIT = 86400;
    public static final int SPINNER_RECEIVER_START_DELAY_DEFAULT_VALUE = 5;
    public static final int SPINNER_RECEIVER_START_DELAY_LOWER_LIMIT = 3;
    public static final int SPINNER_RECEIVER_INTERVAL_UPPER_LIMIT = 2000;
    public static final int SPINNER_RECEIVER_INTERVAL_DEFAULT_VALUE = 1445;
    public static final int SPINNER_RECEIVER_INTERVAL_LOWER_LIMIT = 1440;

    public static final int SPINNER_RPS_START_DELAY_UPPER_LIMIT = 86400;
    public static final int SPINNER_RPS_START_DELAY_DEFAULT_VALUE = 5;
    public static final int SPINNER_RPS_START_DELAY_LOWER_LIMIT = 3;
    public static final int SPINNER_RPS_INTERVAL_UPPER_LIMIT = 86400;
    public static final int SPINNER_RPS_INTERVAL_DEFAULT_VALUE = 65;
    public static final int SPINNER_RPS_INTERVAL_LOWER_LIMIT = 60;
    public static final int SPINNER_RPS_GAMBLE_CASH_UPPER_LIMIT = 240;
    public static final int SPINNER_RPS_GAMBLE_CASH_DEFAULT_VALUE = 240;
    public static final int SPINNER_RPS_GAMBLE_CASH_LOWER_LIMIT = 1;

    public static final int SPINNER_DICE_START_DELAY_UPPER_LIMIT = 86400;
    public static final int SPINNER_DICE_START_DELAY_DEFAULT_VALUE = 5;
    public static final int SPINNER_DICE_START_DELAY_LOWER_LIMIT = 3;
    public static final int SPINNER_DICE_INTERVAL_UPPER_LIMIT = 86400;
    public static final int SPINNER_DICE_INTERVAL_DEFAULT_VALUE = 65;
    public static final int SPINNER_DICE_INTERVAL_LOWER_LIMIT = 60;
    public static final int SPINNER_DICE_GAMBLE_CASH_UPPER_LIMIT = 240;
    public static final int SPINNER_DICE_GAMBLE_CASH_DEFAULT_VALUE = 240;
    public static final int SPINNER_DICE_GAMBLE_CASH_LOWER_LIMIT = 1;

    private final Model model;

    private ViewNotifier notifier;

    private final HashMap<String, Object> viewComponentsAttributes;

    public ViewModel(Model model) {
        this.model = model;

        viewComponentsAttributes = new HashMap<>();

        initLogPrinter();
    }

    private void initLogPrinter() {
        model.setLogPrinter(this::log);
    }

    private void setupRobotAttributes() {
        int workerStartDelay = (int) viewComponentsAttributes.get(SPINNER_WORKER_START_DELAY_VALUE);
        int workerInterval = (int) viewComponentsAttributes.get(SPINNER_WORKER_INTERVAL_VALUE);
        boolean enableReceiver = (boolean) viewComponentsAttributes.get(CHECKBOX_ENABLE_RECEIVER_SELECTED);
        int receiverStartDelay = (int) viewComponentsAttributes.get(SPINNER_RECEIVER_START_DELAY_VALUE);
        int receiverInterval = (int) viewComponentsAttributes.get(SPINNER_RECEIVER_INTERVAL_VALUE);
        boolean enableRPS = (boolean) viewComponentsAttributes.get(CHECKBOX_ENABLE_RPS_SELECTED);
        int gambleRPSStartDelay = (int) viewComponentsAttributes.get(SPINNER_RPS_START_DELAY_VALUE);
        int gambleRPSInterval = (int) viewComponentsAttributes.get(SPINNER_RPS_INTERVAL_VALUE);
        int gambleRPSGambleCash = (int) viewComponentsAttributes.get(SPINNER_RPS_GAMBLE_CASH_VALUE);
        int gambleRPSWhichHand;
        if ((boolean) viewComponentsAttributes.get(RADIO_BUTTON_RPS_ROCK_SELECTED))
            gambleRPSWhichHand = GamblerRPS.RPS_ROCK;
        else if ((boolean) viewComponentsAttributes.get(RADIO_BUTTON_RPS_PAPER_SELECTED))
            gambleRPSWhichHand = GamblerRPS.RPS_PAPER;
        else if ((boolean) viewComponentsAttributes.get(RADIO_BUTTON_RPS_SCISSORS_SELECTED))
            gambleRPSWhichHand = GamblerRPS.RPS_SCISSORS;
        else
            gambleRPSWhichHand = GamblerRPS.RPS_RANDOM;
        boolean enableDICE = (boolean) viewComponentsAttributes.get(CHECKBOX_ENABLE_DICE_SELECTED);
        int gambleDICEStartDelay = (int) viewComponentsAttributes.get(SPINNER_DICE_START_DELAY_VALUE);
        int gambleDICEInterval = (int) viewComponentsAttributes.get(SPINNER_DICE_INTERVAL_VALUE);
        int gambleDICEGambleCash = (int) viewComponentsAttributes.get(SPINNER_DICE_GAMBLE_CASH_VALUE);

        model.setupRobotAttributes(
                workerStartDelay,
                workerInterval,
                enableReceiver,
                receiverStartDelay,
                receiverInterval,
                enableRPS,
                gambleRPSStartDelay,
                gambleRPSInterval,
                gambleRPSGambleCash,
                gambleRPSWhichHand,
                enableDICE,
                gambleDICEStartDelay,
                gambleDICEInterval,
                gambleDICEGambleCash);
    }

    public void notifyView(String key) {
        if (notifier != null)
            notifier.notifyView(key);
    }

    private void checkSpinnerChangedValue(JSpinner spinner, int upperLimit, int lowerLimit) {
        int currentValue = (int) spinner.getValue();
        if (currentValue > upperLimit)
            spinner.setValue(upperLimit);
        else if (currentValue < lowerLimit)
            spinner.setValue(lowerLimit);
    }

    private synchronized void log(String message, Object ... parameters) {
        final String DATE_FORMAT = "[MM/dd HH:mm:ss]";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

        String currentLogMessage = (String) viewComponentsAttributes.get(TEXT_AREA_LOG_MESSAGE_TEXT);
        String finalMessage = currentLogMessage +
                              simpleDateFormat.format(new Date()) + " " + String.format(message, parameters) + "\n";

        viewComponentsAttributes.put(TEXT_AREA_LOG_MESSAGE_TEXT, finalMessage);

        notifyView(TEXT_AREA_LOG_MESSAGE_TEXT);
    }

    private void clearLog() {
        viewComponentsAttributes.put(TEXT_AREA_LOG_MESSAGE_TEXT, "");

        notifyView(TEXT_AREA_LOG_MESSAGE_TEXT);
    }

    private void printAllAttributesToLog() {
        int workerStartDelay = (int) viewComponentsAttributes.get(SPINNER_WORKER_START_DELAY_VALUE);
        int workerInterval = (int) viewComponentsAttributes.get(SPINNER_WORKER_INTERVAL_VALUE);
        boolean enableReceiver = (boolean) viewComponentsAttributes.get(CHECKBOX_ENABLE_RECEIVER_SELECTED);
        int receiverStartDelay = (int) viewComponentsAttributes.get(SPINNER_RECEIVER_START_DELAY_VALUE);
        int receiverInterval = (int) viewComponentsAttributes.get(SPINNER_RECEIVER_INTERVAL_VALUE);
        boolean enableRPS = (boolean) viewComponentsAttributes.get(CHECKBOX_ENABLE_RPS_SELECTED);
        int gambleRPSStartDelay = (int) viewComponentsAttributes.get(SPINNER_RPS_START_DELAY_VALUE);
        int gambleRPSInterval = (int) viewComponentsAttributes.get(SPINNER_RPS_INTERVAL_VALUE);
        int gambleRPSGambleCash = (int) viewComponentsAttributes.get(SPINNER_RPS_GAMBLE_CASH_VALUE);
        int gambleRPSWhichHand;
        if ((boolean) viewComponentsAttributes.get(RADIO_BUTTON_RPS_ROCK_SELECTED))
            gambleRPSWhichHand = GamblerRPS.RPS_ROCK;
        else if ((boolean) viewComponentsAttributes.get(RADIO_BUTTON_RPS_PAPER_SELECTED))
            gambleRPSWhichHand = GamblerRPS.RPS_PAPER;
        else if ((boolean) viewComponentsAttributes.get(RADIO_BUTTON_RPS_SCISSORS_SELECTED))
            gambleRPSWhichHand = GamblerRPS.RPS_SCISSORS;
        else
            gambleRPSWhichHand = GamblerRPS.RPS_RANDOM;
        boolean enableDICE = (boolean) viewComponentsAttributes.get(CHECKBOX_ENABLE_DICE_SELECTED);
        int gambleDICEStartDelay = (int) viewComponentsAttributes.get(SPINNER_DICE_START_DELAY_VALUE);
        int gambleDICEInterval = (int) viewComponentsAttributes.get(SPINNER_DICE_INTERVAL_VALUE);
        int gambleDICEGambleCash = (int) viewComponentsAttributes.get(SPINNER_DICE_GAMBLE_CASH_VALUE);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Robot will start with following attributes...\n");
        stringBuilder.append("workerStartDelay =\t").append(workerStartDelay).append("\n");
        stringBuilder.append("workerInterval =\t").append(workerInterval).append("\n");
        stringBuilder.append("enableDailyReceiver =\t").append(enableReceiver).append("\n");
        if (enableReceiver) {
            stringBuilder.append("receiverStartDelay =\t").append(receiverStartDelay).append("\n");
            stringBuilder.append("receiverInterval =\t").append(receiverInterval).append("\n");
        }
        stringBuilder.append("enableRPS =\t\t").append(enableRPS).append("\n");
        if (enableRPS) {
            stringBuilder.append("rpsStartDelay =\t\t").append(gambleRPSStartDelay).append("\n");
            stringBuilder.append("rpsInterval =\t\t").append(gambleRPSInterval).append("\n");
            stringBuilder.append("rpsCash =\t\t").append(gambleRPSGambleCash).append("\n");
            stringBuilder.append("rpsHand =\t\t").append(gambleRPSWhichHand).append("\n");
        }
        stringBuilder.append("enableDICE =\t\t").append(enableDICE).append("\n");
        if (enableDICE) {
            stringBuilder.append("diceStartDelay =\t").append(gambleDICEStartDelay).append("\n");
            stringBuilder.append("diceInterval =\t\t").append(gambleDICEInterval).append("\n");
            stringBuilder.append("diceCash =\t\t").append(gambleDICEGambleCash).append("\n");
        }

        String logMessage = stringBuilder.toString();
        log(logMessage);
    }

    public void putViewComponentAttribute(String key, Object value) {
        viewComponentsAttributes.put(key, value);
    }

    public void setNotifier(ViewNotifier notifier) {
        this.notifier = notifier;
    }

    private void setAllViewComponentsEnabled(boolean enabled) {
        for (String key : viewComponentsAttributes.keySet())
            if (key.contains(ENABLED_ATTRIBUTE_NAME))
                viewComponentsAttributes.put(key, enabled);
    }

    public Object getViewComponentAttribute(String key) {
        return viewComponentsAttributes.get(key);
    }

    public void spinnerWorkerStartDelay_ChangeListener(ChangeEvent e) {
        JSpinner spinnerWorkerStartDelay = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerWorkerStartDelay, SPINNER_WORK_START_DELAY_UPPER_LIMIT, SPINNER_WORK_START_DELAY_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_WORKER_START_DELAY_VALUE, spinnerWorkerStartDelay.getValue());
    }
    public void spinnerWorkerInterval_ChangeListener(ChangeEvent e) {
        JSpinner spinnerWorkerInterval = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerWorkerInterval, SPINNER_WORK_INTERVAL_UPPER_LIMIT, SPINNER_WORK_INTERVAL_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_WORKER_INTERVAL_VALUE, spinnerWorkerInterval.getValue());
    }
    public void checkboxEnableReceiver_ItemListener(ItemEvent e) {
        JCheckBox checkboxEnableReceiver = (JCheckBox) e.getSource();
        viewComponentsAttributes.put(CHECKBOX_ENABLE_RECEIVER_SELECTED, checkboxEnableReceiver.isSelected());
        viewComponentsAttributes.put(SPINNER_RECEIVER_START_DELAY_ENABLED, checkboxEnableReceiver.isSelected());
        viewComponentsAttributes.put(SPINNER_RECEIVER_INTERVAL_ENABLED, checkboxEnableReceiver.isSelected());

        notifyView(null);
    }
    public void spinnerReceiverStartDelay_ChangeListener(ChangeEvent e) {
        JSpinner spinnerReceiverStartDelay = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerReceiverStartDelay, SPINNER_RECEIVER_START_DELAY_UPPER_LIMIT, SPINNER_RECEIVER_START_DELAY_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_RECEIVER_START_DELAY_VALUE, spinnerReceiverStartDelay.getValue());
    }
    public void spinnerReceiverInterval_ChangeListener(ChangeEvent e) {
        JSpinner spinnerReceiverInterval = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerReceiverInterval, SPINNER_RECEIVER_INTERVAL_UPPER_LIMIT, SPINNER_RECEIVER_INTERVAL_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_RECEIVER_INTERVAL_VALUE, spinnerReceiverInterval.getValue());
    }
    public void checkboxEnableRPS_ItemListener(ItemEvent e) {
        JCheckBox checkboxEnableRPS = (JCheckBox) e.getSource();
        viewComponentsAttributes.put(CHECKBOX_ENABLE_RPS_SELECTED, checkboxEnableRPS.isSelected());
        viewComponentsAttributes.put(SPINNER_RPS_START_DELAY_ENABLED, checkboxEnableRPS.isSelected());
        viewComponentsAttributes.put(SPINNER_RPS_INTERVAL_ENABLED, checkboxEnableRPS.isSelected());
        viewComponentsAttributes.put(SPINNER_RPS_GAMBLE_CASH_ENABLED, checkboxEnableRPS.isSelected());
        viewComponentsAttributes.put(RADIO_BUTTON_RPS_ROCK_ENABLED, checkboxEnableRPS.isSelected());
        viewComponentsAttributes.put(RADIO_BUTTON_RPS_PAPER_ENABLED, checkboxEnableRPS.isSelected());
        viewComponentsAttributes.put(RADIO_BUTTON_RPS_SCISSOR_ENABLED, checkboxEnableRPS.isSelected());
        viewComponentsAttributes.put(RADIO_BUTTON_RPS_RANDOM_ENABLED, checkboxEnableRPS.isSelected());

        notifyView(null);
    }
    public void spinnerRPSStartDelay_ChangeListener(ChangeEvent e) {
        JSpinner spinnerRPSStartDelay = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerRPSStartDelay, SPINNER_RPS_START_DELAY_UPPER_LIMIT, SPINNER_RPS_START_DELAY_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_RPS_START_DELAY_VALUE, spinnerRPSStartDelay.getValue());
    }
    public void spinnerRPSInterval_ChangeListener(ChangeEvent e) {
        JSpinner spinnerRPSInterval = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerRPSInterval, SPINNER_RPS_INTERVAL_UPPER_LIMIT, SPINNER_RPS_INTERVAL_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_RPS_INTERVAL_VALUE, spinnerRPSInterval.getValue());
    }
    public void spinnerRPSGambleAmount_ChangeListener(ChangeEvent e) {
        JSpinner spinnerRPSGambleAmount = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerRPSGambleAmount, SPINNER_RPS_GAMBLE_CASH_UPPER_LIMIT, SPINNER_RPS_GAMBLE_CASH_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_RPS_GAMBLE_CASH_VALUE, spinnerRPSGambleAmount.getValue());
    }
    public void radiobuttonRPSRock_ChangeListener(ChangeEvent e) {
        JRadioButton radiobuttonRPSRock = (JRadioButton) e.getSource();
        if (radiobuttonRPSRock.isSelected()) {
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_ROCK_SELECTED, true);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_PAPER_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_SCISSORS_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_RANDOM_SELECTED, false);
        }
    }
    public void radiobuttonRPSPaper_ChangeListener(ChangeEvent e) {
        JRadioButton radiobuttonRPSPaper = (JRadioButton) e.getSource();
        if (radiobuttonRPSPaper.isSelected()) {
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_ROCK_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_PAPER_SELECTED, true);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_SCISSORS_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_RANDOM_SELECTED, false);
        }
    }
    public void radiobuttonRPSScissors_ChangeListener(ChangeEvent e) {
        JRadioButton radiobuttonRPSScissors = (JRadioButton) e.getSource();
        if (radiobuttonRPSScissors.isSelected()) {
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_ROCK_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_PAPER_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_SCISSORS_SELECTED, true);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_RANDOM_SELECTED, false);
        }
    }
    public void radiobuttonRPSRandom_ChangeListener(ChangeEvent e) {
        JRadioButton radiobuttonRPSRandom = (JRadioButton) e.getSource();
        if (radiobuttonRPSRandom.isSelected()) {
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_ROCK_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_PAPER_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_SCISSORS_SELECTED, false);
            viewComponentsAttributes.put(RADIO_BUTTON_RPS_RANDOM_SELECTED, true);
        }
    }
    public void checkboxEnableDICE_ItemListener(ItemEvent e) {
        JCheckBox checkboxEnableDICE = (JCheckBox) e.getSource();
        viewComponentsAttributes.put(CHECKBOX_ENABLE_DICE_SELECTED, checkboxEnableDICE.isSelected());
        viewComponentsAttributes.put(SPINNER_DICE_START_DELAY_ENABLED, checkboxEnableDICE.isSelected());
        viewComponentsAttributes.put(SPINNER_DICE_INTERVAL_ENABLED, checkboxEnableDICE.isSelected());
        viewComponentsAttributes.put(SPINNER_DICE_GAMBLE_CASH_ENABLED, checkboxEnableDICE.isSelected());

        notifyView(null);
    }
    public void spinnerDICEStartDelay_ChangeListener(ChangeEvent e) {
        JSpinner spinnerDICEStartDelay = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerDICEStartDelay, SPINNER_DICE_START_DELAY_UPPER_LIMIT, SPINNER_DICE_START_DELAY_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_DICE_START_DELAY_VALUE, spinnerDICEStartDelay.getValue());
    }
    public void spinnerDICEInterval_ChangeListener(ChangeEvent e) {
        JSpinner spinnerDICEInterval = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerDICEInterval, SPINNER_DICE_INTERVAL_UPPER_LIMIT, SPINNER_DICE_INTERVAL_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_DICE_INTERVAL_VALUE, spinnerDICEInterval.getValue());
    }
    public void spinnerDICEGambleAmount_ChangeListener(ChangeEvent e) {
        JSpinner spinnerDICEGambleAmount = (JSpinner) e.getSource();
        checkSpinnerChangedValue(spinnerDICEGambleAmount, SPINNER_DICE_GAMBLE_CASH_UPPER_LIMIT, SPINNER_DICE_GAMBLE_CASH_LOWER_LIMIT);
        viewComponentsAttributes.put(SPINNER_DICE_GAMBLE_CASH_VALUE, spinnerDICEGambleAmount.getValue());
    }
    public void buttonStartRobot_ActionListener(ActionEvent e) {
        setupRobotAttributes();
        clearLog();
        printAllAttributesToLog();
        model.startRobot();

        viewComponentsAttributes.put(BUTTON_START_ROBOT_ENABLED, false);
        viewComponentsAttributes.put(BUTTON_STOP_ROBOT_ENABLED, true);

        notifyView(null);
    }
    public void buttonStopRobot_ActionListener(ActionEvent e) {
        model.stopRobot();

        viewComponentsAttributes.put(BUTTON_START_ROBOT_ENABLED, true);
        viewComponentsAttributes.put(BUTTON_STOP_ROBOT_ENABLED, false);

        notifyView(null);
    }

    public interface ViewNotifier {
        void notifyView(String key);
    }
}
