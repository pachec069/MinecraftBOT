package re.alwyn974.minecraft.bot.gui;

import re.alwyn974.logger.LoggerFactory;
import re.alwyn974.minecraft.bot.entity.EntityBOT;
import re.alwyn974.minecraft.bot.logging.JTextAreaLogHandler;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MCBOTPanel extends JPanel implements ActionListener {

    private final JPanel topPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel();

    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JTextField hostField = new JTextField("127.0.0.1");
    private final JTextField portField = new JTextField("25565");
    private final JTextField outputField = new JTextField();

    private final JButton connectButton = new JButton("Connect");
    private final JButton disconnectButton = new JButton("Disconnect");
    private final JCheckBox debugBox = new JCheckBox("Debug");

    private EntityBOT bot = null;

    public MCBOTPanel() {
        this.setLayout(new BorderLayout());

        addTopPanel();
        addCenterPanel();
        addBottomPanel();
    }

    private void addTopPanel() {
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(new JLabel("Host: "));

        topPanel.add(hostField, BorderLayout.PAGE_START);

        topPanel.add(new JLabel("Port: "));
        topPanel.add(portField, BorderLayout.PAGE_START);

        topPanel.add(new JLabel("Email: "));
        topPanel.add(usernameField, BorderLayout.PAGE_START);

        topPanel.add(new JLabel("Password: "));
        topPanel.add(passwordField, BorderLayout.PAGE_START);

        connectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        connectButton.addActionListener(this);
        topPanel.add(connectButton, BorderLayout.PAGE_START);

        disconnectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        disconnectButton.addActionListener(this);
        topPanel.add(disconnectButton, BorderLayout.PAGE_START);

        topPanel.add(debugBox, BorderLayout.PAGE_START);

        this.add(topPanel, BorderLayout.PAGE_START);
    }

    private void addCenterPanel() {
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setBackground(Color.decode("#2c2f33"));

        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setAutoscrolls(true);
        jScrollPane.getViewport().setView(logArea);

        LoggerFactory.addSharedHandler(new JTextAreaLogHandler(logArea));

        this.add(jScrollPane, BorderLayout.CENTER);
    }

    private void addBottomPanel() {
        bottomPanel.setLayout(new BorderLayout());
        JLabel chatLabel = new JLabel("Chat: ");
        bottomPanel.add(chatLabel, BorderLayout.WEST);

        outputField.addActionListener(this);
        bottomPanel.add(outputField, BorderLayout.CENTER);

        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connectButton) {

        } else if (e.getSource() == disconnectButton) {

        }
    }

}