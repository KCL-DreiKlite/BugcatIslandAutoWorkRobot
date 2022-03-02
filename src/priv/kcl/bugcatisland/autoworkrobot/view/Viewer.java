package priv.kcl.bugcatisland.autoworkrobot.view;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultFormatter;
import java.awt.*;

public class Viewer extends JFrame {


    private final ViewModel viewModel;

    private JLabel labelWorkerStartDelay;
    private JSpinner spinnerWorkerStartDelay;
    private JLabel labelWorkerInterval;
    private JSpinner spinnerWorkerInterval;

    private JCheckBox checkboxEnableReceiver;
    private JLabel labelReceiverStartDelay;
    private JSpinner spinnerReceiverStartDelay;
    private JLabel labelReceiverInterval;
    private JSpinner spinnerReceiverInterval;

    private JCheckBox checkboxEnableRPS;
    private JLabel labelRPSStartDelay;
    private JSpinner spinnerRPSStartDelay;
    private JLabel labelRPSInterval;
    private JSpinner spinnerRPSInterval;
    private JLabel labelRPSGambleAmount;
    private JSpinner spinnerRPSGambleCash;
    private JRadioButton radiobuttonRPSRock;
    private JRadioButton radiobuttonRPSPaper;
    private JRadioButton radiobuttonRPSScissors;
    private JRadioButton radiobuttonRPSRandom;
    private ButtonGroup buttongroupRPSSelection;

    private JCheckBox checkboxEnableDICE;
    private JLabel labelDICEStartDelay;
    private JSpinner spinnerDICEStartDelay;
    private JLabel labelDICEInterval;
    private JSpinner spinnerDICEInterval;
    private JLabel labelDICEGambleAmount;
    private JSpinner spinnerDICEGambleCash;

    private JTextArea textareaLogMessage;

    private JButton buttonStartRobot;
    private JButton buttonStopRobot;

    public Viewer(ViewModel viewModel) {
        this.viewModel = viewModel;

        initViewComponents();
        initListeners();
        initFramePresentation();

        initNotifier();
        initViewModelAttributeMap();

        updateView();
    }

    private void initViewComponents() {
        // Some constants.
        final int DEFAULT_SPINNER_WIDTH = 70;
        final int DEFAULT_SPINNER_HEIGHT = 20;
        final int DEFAULT_SCROLL_PANE_WIDTH = 350;
        final int DEFAULT_SCROLL_PANE_HEIGHT = 500;

        // =========== labelWorkerStartDelay ===========
        labelWorkerStartDelay = new JLabel();
        labelWorkerStartDelay.setText("Start delay (sec.) : ");
        // =========== spinnerWorkerStartDelay ===========
        spinnerWorkerStartDelay = new JSpinner();
        spinnerWorkerStartDelay.setValue(ViewModel.SPINNER_WORK_START_DELAY_DEFAULT_VALUE);
        spinnerWorkerStartDelay.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerWorkerStartDelay);
        // ===========labelWorkerInterval ===========
        labelWorkerInterval = new JLabel();
        labelWorkerInterval.setText("Interval (min.) : ");
        // =========== spinnerWorkerInterval ===========
        spinnerWorkerInterval = new JSpinner();
        spinnerWorkerInterval.setValue(ViewModel.SPINNER_WORK_INTERVAL_DEFAULT_VALUE);
        spinnerWorkerInterval.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerWorkerInterval);

        // =========== checkboxEnableReceiver ===========
        checkboxEnableReceiver = new JCheckBox();
        checkboxEnableReceiver.setText("Enable Daily Receiver");
        checkboxEnableReceiver.setSelected(true);
        // =========== labelReceiverStartDelay ===========
        labelReceiverStartDelay = new JLabel();
        labelReceiverStartDelay.setText("Start delay (sec.) : ");
        // =========== spinnerReceiverStartDelay ===========
        spinnerReceiverStartDelay = new JSpinner();
        spinnerReceiverStartDelay.setValue(ViewModel.SPINNER_RECEIVER_START_DELAY_DEFAULT_VALUE);
        spinnerReceiverStartDelay.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerReceiverStartDelay);
        // =========== labelReceiverInterval ===========
        labelReceiverInterval = new JLabel();
        labelReceiverInterval.setText("Interval (min.) : ");
        // =========== spinnerReceiverInterval ===========
        spinnerReceiverInterval = new JSpinner();
        spinnerReceiverInterval.setValue(ViewModel.SPINNER_RECEIVER_INTERVAL_DEFAULT_VALUE);
        spinnerReceiverInterval.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerReceiverInterval);

        // =========== checkboxEnableRPS ===========
        checkboxEnableRPS = new JCheckBox();
        checkboxEnableRPS.setText("Enable RPS Gambler");
        checkboxEnableRPS.setSelected(false);
        // =========== labelRPSStartDelay ===========
        labelRPSStartDelay = new JLabel();
        labelRPSStartDelay.setText("Start delay (sec.) : ");
        // =========== spinnerRPSStartDelay ===========
        spinnerRPSStartDelay = new JSpinner();
        spinnerRPSStartDelay.setValue(ViewModel.SPINNER_RPS_START_DELAY_DEFAULT_VALUE);
        spinnerRPSStartDelay.setEnabled(false);
        spinnerRPSStartDelay.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerRPSStartDelay);
        // =========== labelRPSInterval ===========
        labelRPSInterval = new JLabel();
        labelRPSInterval.setText("Interval (sec.) : ");
        // =========== spinnerRPSInterval ===========
        spinnerRPSInterval = new JSpinner();
        spinnerRPSInterval.setValue(ViewModel.SPINNER_RPS_INTERVAL_DEFAULT_VALUE);
        spinnerRPSInterval.setEnabled(false);
        spinnerRPSInterval.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerRPSInterval);
        // =========== labelRPSGambleAmount ===========
        labelRPSGambleAmount = new JLabel();
        labelRPSGambleAmount.setText("Price : ");
        // =========== spinnerRPSGambleAmount ===========
        spinnerRPSGambleCash = new JSpinner();
        spinnerRPSGambleCash.setValue(ViewModel.SPINNER_RPS_GAMBLE_CASH_DEFAULT_VALUE);
        spinnerRPSGambleCash.setEnabled(false);
        spinnerRPSGambleCash.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerRPSGambleCash);
        // =========== radiobuttonRPSRock ===========
        radiobuttonRPSRock = new JRadioButton();
        radiobuttonRPSRock.setText("Rock");
        radiobuttonRPSRock.setSelected(true);
        radiobuttonRPSRock.setEnabled(false);
        // =========== radiobuttonRPSPaper ===========
        radiobuttonRPSPaper = new JRadioButton();
        radiobuttonRPSPaper.setText("Paper");
        radiobuttonRPSPaper.setEnabled(false);
        // =========== radiobuttonRPSScissor ===========
        radiobuttonRPSScissors = new JRadioButton();
        radiobuttonRPSScissors.setText("Scissors");
        radiobuttonRPSScissors.setEnabled(false);
        // =========== radiobuttonRPSRandom ===========
        radiobuttonRPSRandom = new JRadioButton();
        radiobuttonRPSRandom.setText("Random");
        radiobuttonRPSRandom.setEnabled(false);
        // =========== buttongroupRPS ===========
        buttongroupRPSSelection = new ButtonGroup();
        buttongroupRPSSelection.add(radiobuttonRPSRock);
        buttongroupRPSSelection.add(radiobuttonRPSPaper);
        buttongroupRPSSelection.add(radiobuttonRPSScissors);
        buttongroupRPSSelection.add(radiobuttonRPSRandom);

        // =========== checkboxEnableDICE ===========
        checkboxEnableDICE = new JCheckBox();
        checkboxEnableDICE.setText("Enable DICE Gambler");
        checkboxEnableDICE.setSelected(true);
        // =========== labelDICEStartDelay ===========
        labelDICEStartDelay = new JLabel();
        labelDICEStartDelay.setText("Start delay (sec.) : ");
        // =========== spinnerDICEStartDelay ===========
        spinnerDICEStartDelay = new JSpinner();
        spinnerDICEStartDelay.setValue(ViewModel.SPINNER_DICE_START_DELAY_DEFAULT_VALUE);
        spinnerDICEStartDelay.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerDICEStartDelay);
        // =========== labelDICEInterval ===========
        labelDICEInterval = new JLabel();
        labelDICEInterval.setText("Interval (sec.) : ");
        // =========== spinnerDICEInterval ===========
        spinnerDICEInterval = new JSpinner();
        spinnerDICEInterval.setValue(ViewModel.SPINNER_DICE_INTERVAL_DEFAULT_VALUE);
        spinnerDICEInterval.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerDICEInterval);
        // =========== labelDICEGambleAmount ===========
        labelDICEGambleAmount = new JLabel();
        labelDICEGambleAmount.setText("Price : ");
        // =========== spinnerDICEGambleAmount ===========
        spinnerDICEGambleCash = new JSpinner();
        spinnerDICEGambleCash.setValue(ViewModel.SPINNER_DICE_GAMBLE_CASH_DEFAULT_VALUE);
        spinnerDICEGambleCash.setPreferredSize(new Dimension(DEFAULT_SPINNER_WIDTH, DEFAULT_SPINNER_HEIGHT));
        setCommitsOnValidEditAsTrue(spinnerDICEGambleCash);

        // =========== textareaLogMessage ===========
        textareaLogMessage = new JTextArea();
        textareaLogMessage.setEditable(false);
        textareaLogMessage.setFont(new Font("Consolas", Font.PLAIN, 10));
        DefaultCaret caret = (DefaultCaret) textareaLogMessage.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        JScrollPane scrollPaneLogMessage = new JScrollPane(textareaLogMessage);
        scrollPaneLogMessage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneLogMessage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneLogMessage.setBorder(BorderFactory.createEmptyBorder());
        scrollPaneLogMessage.setPreferredSize(new Dimension(DEFAULT_SCROLL_PANE_WIDTH, DEFAULT_SCROLL_PANE_HEIGHT));

        // =========== buttonStartRobot ===========
        buttonStartRobot = new JButton();
        buttonStartRobot.setText("Start Robot");
        // =========== buttonStopRobot ===========
        buttonStopRobot = new JButton();
        buttonStopRobot.setText("Stop Robot");
        buttonStopRobot.setEnabled(false);

        // Define the layers.
        GridBagConstraints gbc;

        // =========== workerLayer ===========
        JPanel workerLayer = new JPanel();
        workerLayer.setLayout(new GridBagLayout());
        workerLayer.setBorder(BorderFactory.createTitledBorder("Worker"));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;      gbc.gridy = 0;
        gbc.gridwidth = 1;  gbc.gridheight = 1;
        gbc.weightx = 1.0;  gbc.weighty = 1.0;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.anchor = GridBagConstraints.EAST;
        workerLayer.add(labelWorkerStartDelay, gbc);
        gbc.gridx = 1;      gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        workerLayer.add(spinnerWorkerStartDelay, gbc);
        gbc.gridx = 0;      gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        workerLayer.add(labelWorkerInterval, gbc);
        gbc.gridx = 1;      gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        workerLayer.add(spinnerWorkerInterval, gbc);

        // =========== receiverLayer ===========
        JPanel receiverLayer = new JPanel();
        receiverLayer.setLayout(new GridBagLayout());
        receiverLayer.setBorder(BorderFactory.createTitledBorder("Daily Receiver"));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;      gbc.gridy = 0;
        gbc.gridwidth = 2;  gbc.gridheight = 1;
        gbc.weightx = 1.0;  gbc.weighty = 1.0;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        receiverLayer.add(checkboxEnableReceiver, gbc);
        gbc.gridx = 0;      gbc.gridy = 1;
        gbc.gridwidth = 1;  gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.EAST;
        receiverLayer.add(labelReceiverStartDelay, gbc);
        gbc.gridx = 1;      gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        receiverLayer.add(spinnerReceiverStartDelay, gbc);
        gbc.gridx = 0;      gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        receiverLayer.add(labelReceiverInterval, gbc);
        gbc.gridx = 1;      gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        receiverLayer.add(spinnerReceiverInterval, gbc);

        // =========== gamblerRPSLayer ===========
        JPanel gambleRPSSelectionPanel = new JPanel();
        gambleRPSSelectionPanel.setLayout(new GridLayout(2, 2));
        gambleRPSSelectionPanel.add(radiobuttonRPSRock);
        gambleRPSSelectionPanel.add(radiobuttonRPSPaper);
        gambleRPSSelectionPanel.add(radiobuttonRPSScissors);
        gambleRPSSelectionPanel.add(radiobuttonRPSRandom);
        JPanel gambleRPSLayer = new JPanel();
        gambleRPSLayer.setLayout(new GridBagLayout());
        gambleRPSLayer.setBorder(BorderFactory.createTitledBorder("RPS"));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;      gbc.gridy = 0;
        gbc.gridwidth = 2;  gbc.gridheight = 1;
        gbc.weightx = 1.0;  gbc.weighty = 1.0;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        gambleRPSLayer.add(checkboxEnableRPS, gbc);
        gbc.gridx = 0;      gbc.gridy = 1;
        gbc.gridwidth = 1;  gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gambleRPSLayer.add(labelRPSStartDelay, gbc);
        gbc.gridx = 1;      gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gambleRPSLayer.add(spinnerRPSStartDelay, gbc);
        gbc.gridx = 0;      gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gambleRPSLayer.add(labelRPSInterval, gbc);
        gbc.gridx = 1;      gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gambleRPSLayer.add(spinnerRPSInterval, gbc);
        gbc.gridx = 0;      gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gambleRPSLayer.add(labelRPSGambleAmount, gbc);
        gbc.gridx = 1;      gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gambleRPSLayer.add(spinnerRPSGambleCash, gbc);
        gbc.gridx = 0;      gbc.gridy = 4;
        gbc.gridwidth = 2;  gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gambleRPSLayer.add(gambleRPSSelectionPanel, gbc);

        // =========== gamblerDICELayer ===========
        JPanel gambleDICELayer = new JPanel();
        gambleDICELayer.setLayout(new GridBagLayout());
        gambleDICELayer.setBorder(BorderFactory.createTitledBorder("DICE"));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;      gbc.gridy = 0;
        gbc.gridwidth = 2;  gbc.gridheight = 1;
        gbc.weightx = 1.0;  gbc.weighty = 1.0;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.anchor = GridBagConstraints.CENTER;
        gambleDICELayer.add(checkboxEnableDICE, gbc);
        gbc.gridx = 0;      gbc.gridy = 1;
        gbc.gridwidth = 1;  gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gambleDICELayer.add(labelDICEStartDelay, gbc);
        gbc.gridx = 1;      gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gambleDICELayer.add(spinnerDICEStartDelay, gbc);
        gbc.gridx = 0;      gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gambleDICELayer.add(labelDICEInterval, gbc);
        gbc.gridx = 1;      gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gambleDICELayer.add(spinnerDICEInterval, gbc);
        gbc.gridx = 0;      gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gambleDICELayer.add(labelDICEGambleAmount, gbc);
        gbc.gridx = 1;      gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gambleDICELayer.add(spinnerDICEGambleCash, gbc);
//        JPanel gamblerLayer = new JPanel();
//        gamblerLayer.setLayout(new GridLayout(1, 2));
//        gamblerLayer.setBorder(BorderFactory.createTitledBorder("Gambler"));
//        gamblerLayer.add(gambleRPSLayer);
//        gamblerLayer.add(gambleDICELayer);

        // =========== logMessageLayer ===========
        JPanel logMessageLayer = new JPanel(new BorderLayout());
        logMessageLayer.setBorder(BorderFactory.createTitledBorder("Log"));
        logMessageLayer.add(scrollPaneLogMessage, BorderLayout.CENTER);

        // =========== operationLayer ===========
        JPanel operationLayer = new JPanel();
        operationLayer.setLayout(new GridLayout());
        operationLayer.add(buttonStartRobot);
        operationLayer.add(buttonStopRobot);

        // =========== subRootPanel ===========
        JPanel subRootPanel = new JPanel();
        subRootPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;      gbc.gridy = 0;
        gbc.gridwidth = 1;  gbc.gridheight = 1;
        gbc.weightx = 0.4;  gbc.weighty = 0.25;
        gbc.insets = new Insets(2,2, 2 ,1);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        subRootPanel.add(workerLayer, gbc);
        gbc.gridx = 0;      gbc.gridy = 1;
        subRootPanel.add(receiverLayer, gbc);
        gbc.gridx = 0;      gbc.gridy = 2;
        subRootPanel.add(gambleRPSLayer, gbc);
        gbc.gridx = 0;      gbc.gridy = 3;
        subRootPanel.add(gambleDICELayer, gbc);
        gbc.gridx = 1;      gbc.gridy = 0;
        gbc.gridwidth = 1;  gbc.gridheight = 4;
        gbc.weightx = 0.6;  gbc.weighty = 1;
        gbc.insets = new Insets(2, 1, 2, 2);
        subRootPanel.add(logMessageLayer, gbc);

        // =========== rootPanel ===========
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(subRootPanel, BorderLayout.CENTER);
        rootPanel.add(operationLayer, BorderLayout.SOUTH);

        // And finally, set rootPanel as frame's contentPane.
        this.setContentPane(rootPanel);
    }

    private void initListeners() {
        spinnerWorkerStartDelay.addChangeListener(viewModel::spinnerWorkerStartDelay_ChangeListener);
        spinnerWorkerInterval.addChangeListener(viewModel::spinnerWorkerInterval_ChangeListener);

        checkboxEnableReceiver.addItemListener(viewModel::checkboxEnableReceiver_ItemListener);
        spinnerReceiverStartDelay.addChangeListener(viewModel::spinnerReceiverStartDelay_ChangeListener);
        spinnerReceiverInterval.addChangeListener(viewModel::spinnerReceiverInterval_ChangeListener);

        checkboxEnableRPS.addItemListener(viewModel::checkboxEnableRPS_ItemListener);
        spinnerRPSStartDelay.addChangeListener(viewModel::spinnerRPSStartDelay_ChangeListener);
        spinnerRPSInterval.addChangeListener(viewModel::spinnerRPSInterval_ChangeListener);
        spinnerRPSGambleCash.addChangeListener(viewModel::spinnerRPSGambleAmount_ChangeListener);
        radiobuttonRPSRock.addChangeListener(viewModel::radiobuttonRPSRock_ChangeListener);
        radiobuttonRPSPaper.addChangeListener(viewModel::radiobuttonRPSPaper_ChangeListener);
        radiobuttonRPSScissors.addChangeListener(viewModel::radiobuttonRPSScissors_ChangeListener);
        radiobuttonRPSRandom.addChangeListener(viewModel::radiobuttonRPSRandom_ChangeListener);

        checkboxEnableDICE.addItemListener(viewModel::checkboxEnableDICE_ItemListener);
        spinnerDICEStartDelay.addChangeListener(viewModel::spinnerDICEStartDelay_ChangeListener);
        spinnerDICEInterval.addChangeListener(viewModel::spinnerDICEInterval_ChangeListener);
        spinnerDICEGambleCash.addChangeListener(viewModel::spinnerDICEGambleAmount_ChangeListener);

        buttonStartRobot.addActionListener(viewModel::buttonStartRobot_ActionListener);
        buttonStopRobot.addActionListener(viewModel::buttonStopRobot_ActionListener);
    }

    private void initNotifier() {
        viewModel.setNotifier(this::notifyMe);
    }

    private void initFramePresentation() {
        setTitle("Bugcat Island Autowork Robot");
//        setPreferredSize(new Dimension(500, 500));
        pack();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initViewModelAttributeMap() {
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_WORKER_START_DELAY_VALUE, spinnerWorkerStartDelay.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_WORKER_INTERVAL_VALUE, spinnerWorkerInterval.getValue());

        viewModel.putViewComponentAttribute(ViewModel.CHECKBOX_ENABLE_RECEIVER_SELECTED, checkboxEnableReceiver.isSelected());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RECEIVER_START_DELAY_VALUE, spinnerWorkerStartDelay.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RECEIVER_START_DELAY_ENABLED, spinnerWorkerStartDelay.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RECEIVER_INTERVAL_VALUE, spinnerReceiverInterval.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RECEIVER_INTERVAL_ENABLED, spinnerReceiverInterval.isEnabled());

        viewModel.putViewComponentAttribute(ViewModel.CHECKBOX_ENABLE_RPS_SELECTED, checkboxEnableRPS.isSelected());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RPS_START_DELAY_VALUE, spinnerRPSStartDelay.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RPS_START_DELAY_ENABLED, spinnerRPSStartDelay.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RPS_INTERVAL_VALUE, spinnerRPSInterval.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RPS_INTERVAL_ENABLED, spinnerRPSInterval.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RPS_GAMBLE_CASH_VALUE, spinnerRPSGambleCash.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_RPS_GAMBLE_CASH_ENABLED, spinnerRPSGambleCash.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_ROCK_SELECTED, radiobuttonRPSRock.isSelected());
        viewModel.putViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_ROCK_ENABLED, radiobuttonRPSRock.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_PAPER_SELECTED, radiobuttonRPSPaper.isSelected());
        viewModel.putViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_PAPER_ENABLED, radiobuttonRPSPaper.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_SCISSORS_SELECTED, radiobuttonRPSScissors.isSelected());
        viewModel.putViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_SCISSOR_ENABLED, radiobuttonRPSScissors.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_RANDOM_SELECTED, radiobuttonRPSRandom.isSelected());
        viewModel.putViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_RANDOM_ENABLED, radiobuttonRPSRandom.isEnabled());

        viewModel.putViewComponentAttribute(ViewModel.CHECKBOX_ENABLE_DICE_SELECTED, checkboxEnableDICE.isSelected());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_DICE_START_DELAY_VALUE, spinnerDICEStartDelay.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_DICE_START_DELAY_ENABLED, spinnerDICEStartDelay.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_DICE_INTERVAL_VALUE, spinnerDICEInterval.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_DICE_INTERVAL_ENABLED, spinnerDICEInterval.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_DICE_GAMBLE_CASH_VALUE, spinnerDICEGambleCash.getValue());
        viewModel.putViewComponentAttribute(ViewModel.SPINNER_DICE_GAMBLE_CASH_ENABLED, spinnerDICEGambleCash.isEnabled());

        viewModel.putViewComponentAttribute(ViewModel.TEXT_AREA_LOG_MESSAGE_TEXT, "");

        viewModel.putViewComponentAttribute(ViewModel.BUTTON_START_ROBOT_ENABLED, buttonStartRobot.isEnabled());
        viewModel.putViewComponentAttribute(ViewModel.BUTTON_STOP_ROBOT_ENABLED, buttonStopRobot.isEnabled());
    }

    private void updateView(String key) {
        Object updatedAttributes = viewModel.getViewComponentAttribute(key);
        switch (key) {
            case ViewModel.SPINNER_WORKER_START_DELAY_VALUE:
                spinnerWorkerStartDelay.setValue(updatedAttributes);
                break;
            case ViewModel.SPINNER_WORKER_INTERVAL_VALUE:
                spinnerWorkerInterval.setValue(updatedAttributes);
                break;

//            case ViewModel.CHECKBOX_ENABLE_RECEIVER_SELECTED:
//                checkboxEnableReceiver.setSelected((boolean) updatedAttributes);
//                break;
            case ViewModel.SPINNER_RECEIVER_START_DELAY_VALUE:
                spinnerReceiverStartDelay.setValue(updatedAttributes);
                break;
            case ViewModel.SPINNER_RECEIVER_START_DELAY_ENABLED:
                spinnerReceiverStartDelay.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.SPINNER_RECEIVER_INTERVAL_VALUE:
                spinnerReceiverInterval.setValue(updatedAttributes);
                break;
            case ViewModel.SPINNER_RECEIVER_INTERVAL_ENABLED:
                spinnerReceiverInterval.setEnabled((boolean) updatedAttributes);
                break;

//            case ViewModel.CHECKBOX_ENABLE_RPS_SELECTED:
//                checkboxEnableRPS.setSelected((boolean) updatedAttributes);
//                break;
            case ViewModel.SPINNER_RPS_START_DELAY_VALUE:
                spinnerRPSStartDelay.setValue(updatedAttributes);
                break;
            case ViewModel.SPINNER_RPS_START_DELAY_ENABLED:
                spinnerRPSStartDelay.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.SPINNER_RPS_INTERVAL_VALUE:
                spinnerRPSInterval.setValue(updatedAttributes);
                break;
            case ViewModel.SPINNER_RPS_INTERVAL_ENABLED:
                spinnerRPSInterval.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.SPINNER_RPS_GAMBLE_CASH_VALUE:
                spinnerRPSGambleCash.setValue(updatedAttributes);
                break;
            case ViewModel.SPINNER_RPS_GAMBLE_CASH_ENABLED:
                spinnerRPSGambleCash.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.RADIO_BUTTON_RPS_ROCK_ENABLED:
                radiobuttonRPSRock.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.RADIO_BUTTON_RPS_PAPER_ENABLED:
                radiobuttonRPSPaper.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.RADIO_BUTTON_RPS_SCISSOR_ENABLED:
                radiobuttonRPSScissors.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.RADIO_BUTTON_RPS_RANDOM_ENABLED:
                radiobuttonRPSRandom.setEnabled((boolean) updatedAttributes);
                break;

//            case ViewModel.CHECKBOX_ENABLE_DICE_SELECTED:
//                checkboxEnableDICE.setSelected((boolean) updatedAttributes);
//                break;
            case ViewModel.SPINNER_DICE_START_DELAY_VALUE:
                spinnerDICEStartDelay.setValue(updatedAttributes);
                break;
            case ViewModel.SPINNER_DICE_START_DELAY_ENABLED:
                spinnerDICEStartDelay.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.SPINNER_DICE_INTERVAL_VALUE:
                spinnerDICEInterval.setValue((updatedAttributes));
                break;
            case ViewModel.SPINNER_DICE_INTERVAL_ENABLED:
                spinnerDICEInterval.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.SPINNER_DICE_GAMBLE_CASH_VALUE:
                spinnerDICEGambleCash.setValue((updatedAttributes));
                break;
            case ViewModel.SPINNER_DICE_GAMBLE_CASH_ENABLED:
                spinnerDICEGambleCash.setEnabled((boolean) updatedAttributes);
                break;

            case ViewModel.TEXT_AREA_LOG_MESSAGE_TEXT:
                textareaLogMessage.setText((String) updatedAttributes);
                break;

            case ViewModel.BUTTON_START_ROBOT_ENABLED:
                buttonStartRobot.setEnabled((boolean) updatedAttributes);
                break;
            case ViewModel.BUTTON_STOP_ROBOT_ENABLED:
                buttonStopRobot.setEnabled((boolean) updatedAttributes);
                break;
        }
    }

    private void updateView() {
        spinnerWorkerStartDelay.setValue(viewModel.getViewComponentAttribute(ViewModel.SPINNER_WORKER_START_DELAY_VALUE));
        spinnerWorkerInterval.setValue(viewModel.getViewComponentAttribute(ViewModel.SPINNER_WORKER_INTERVAL_VALUE));

//        checkboxEnableReceiver.setSelected((boolean) viewModel.getViewComponentAttribute(ViewModel.CHECKBOX_ENABLE_RECEIVER_SELECTED));
        spinnerReceiverStartDelay.setValue(viewModel.getViewComponentAttribute(ViewModel.SPINNER_RECEIVER_START_DELAY_VALUE));
        spinnerReceiverStartDelay.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.SPINNER_RECEIVER_START_DELAY_ENABLED));
        spinnerReceiverInterval.setValue(viewModel.getViewComponentAttribute(ViewModel.SPINNER_RECEIVER_INTERVAL_VALUE));
        spinnerReceiverInterval.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.SPINNER_RECEIVER_INTERVAL_ENABLED));

//        checkboxEnableRPS.setSelected((boolean) viewModel.getViewComponentAttribute(ViewModel.CHECKBOX_ENABLE_RPS_SELECTED));
        spinnerRPSStartDelay.setValue(viewModel.getViewComponentAttribute(ViewModel.SPINNER_RPS_START_DELAY_VALUE));
        spinnerRPSStartDelay.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.SPINNER_RPS_START_DELAY_ENABLED));
        spinnerRPSInterval.setValue(viewModel.getViewComponentAttribute(ViewModel.SPINNER_RPS_INTERVAL_VALUE));
        spinnerRPSInterval.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.SPINNER_RPS_INTERVAL_ENABLED));
        spinnerRPSGambleCash.setValue(viewModel.getViewComponentAttribute(ViewModel.SPINNER_RPS_GAMBLE_CASH_VALUE));
        spinnerRPSGambleCash.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.SPINNER_RPS_GAMBLE_CASH_ENABLED));
        radiobuttonRPSRock.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_ROCK_ENABLED));
        radiobuttonRPSPaper.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_PAPER_ENABLED));
        radiobuttonRPSScissors.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_SCISSOR_ENABLED));
        radiobuttonRPSRandom.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.RADIO_BUTTON_RPS_RANDOM_ENABLED));

//        checkboxEnableDICE.setSelected((boolean) viewModel.getViewComponentAttribute(ViewModel.CHECKBOX_ENABLE_DICE_SELECTED));
        spinnerDICEStartDelay.setValue(viewModel.getViewComponentAttribute(ViewModel.SPINNER_DICE_START_DELAY_VALUE));
        spinnerDICEStartDelay.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.SPINNER_DICE_START_DELAY_ENABLED));
        spinnerDICEInterval.setValue((viewModel.getViewComponentAttribute(ViewModel.SPINNER_DICE_INTERVAL_VALUE)));
        spinnerDICEInterval.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.SPINNER_DICE_INTERVAL_ENABLED));
        spinnerDICEGambleCash.setValue((viewModel.getViewComponentAttribute(ViewModel.SPINNER_DICE_GAMBLE_CASH_VALUE)));
        spinnerDICEGambleCash.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.SPINNER_DICE_GAMBLE_CASH_ENABLED));

        textareaLogMessage.setText((String) viewModel.getViewComponentAttribute(ViewModel.TEXT_AREA_LOG_MESSAGE_TEXT));

        buttonStartRobot.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.BUTTON_START_ROBOT_ENABLED));
        buttonStopRobot.setEnabled((boolean) viewModel.getViewComponentAttribute(ViewModel.BUTTON_STOP_ROBOT_ENABLED));
    }

    /**
     * This method is mostly called by view model.
     */
    private void notifyMe(String key) {
        if (key != null && !key.isEmpty())
            updateView(key);
        else
            updateView();
    }

    public void setCommitsOnValidEditAsTrue(JSpinner spinner) {
        JFormattedTextField formattedTextField = ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
        ((DefaultFormatter) formattedTextField.getFormatter()).setCommitsOnValidEdit(true);
    }
}
