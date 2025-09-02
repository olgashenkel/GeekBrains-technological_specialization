package seminar_01.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea logArea = new JTextArea();
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField();
    private final JPasswordField tfPassword = new JPasswordField("05031995");
    private final JButton btnLogin = new JButton("Login");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final ServerWindow serverWindow;

    public ClientGUI(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;

        // Prompt user for login
        String login = JOptionPane.showInputDialog("Введите ваш логин:");
        if (login == null || login.trim().isEmpty()) {
            showError("Логин не может быть пустым. Приложение будет закрыто.");
        }
        tfLogin.setText(login);

        setupWindow();
        setupComponents();
        setVisible(true);
        serverWindow.addClient(this);
    }

    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat client");
    }

    private void setupComponents() {
        JPanel panelTop = new JPanel(new GridLayout(2, 3));
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        logArea.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(logArea);
        add(scrollLog, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        // Message sending actions
        btnSend.addActionListener(e -> sendMessage());
        tfMessage.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String message = tfMessage.getText().trim();
        String login = tfLogin.getText();
        if (!message.isEmpty()) {
            serverWindow.receiveMessage(login, message);
            tfMessage.setText("");
        }
    }

    public void appendLog(String message) {
        logArea.append(message + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}