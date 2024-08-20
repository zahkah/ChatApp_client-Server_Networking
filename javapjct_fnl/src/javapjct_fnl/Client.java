package javapjct_fnl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter out;
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;
    private String username;

    public Client() {
        // Complexity: O(1) - Initialization does not depend on any input size
        initializeUI();
    }

    private void initializeUI() {
        // Complexity: O(1) - UI components are created with fixed space usage
        frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2, 0, 0));
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

        messageField = new JTextField();
        messageField.setEnabled(false);
        inputPanel.add(messageField);

        JButton sendButton = new JButton("Send");
        sendButton.setEnabled(false);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Complexity: O(1) - Sending a message is a constant time operation
                sendMessage();
            }
        });
        inputPanel.add(sendButton);

        JLabel usernameLabel = new JLabel("Username:");
        inputPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        inputPanel.add(usernameField);

        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Complexity: O(1) - Establishing connection involves constant time operations
                String usernameInput = usernameField.getText().trim();
                if (!usernameInput.isEmpty()) {
                    username = usernameInput;
                    connectButton.setEnabled(false);
                    usernameField.setEditable(false);
                    try {
                        socket = new Socket("127.0.0.1", 7777);
                        out = new PrintWriter(socket.getOutputStream(), true);
                        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        appendToChatArea("[Client]: Connected to server");
                        startReading();
                        messageField.setEnabled(true);
                        sendButton.setEnabled(true);
                        messageField.requestFocus();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        inputPanel.add(connectButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Complexity: O(1) - Shutdown operations involve constant time to close connections
                shutdown();
            }
        });
        inputPanel.add(quitButton);

        frame.setVisible(true);
    }

    private void appendToChatArea(String message) {
        // Complexity: O(1) - Appending to the chat area is a constant time operation
        SwingUtilities.invokeLater(() -> chatArea.append(message + "\n"));
    }

    private void sendMessage() {
        // Complexity: O(1) - Sending a message to the output stream is a constant time operation
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            out.println(username + ": " + message);
            out.flush();
            messageField.setText("");
        }
    }

    private void shutdown() {
        // Complexity: O(1) - Closing resources involves constant time operations
        try {
            if (socket != null) {
                socket.close();
            }
            if (br != null) {
                br.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void startReading() {
        // Complexity: O(m) - m being the number of messages read; each read operation is O(1)
        Thread readerThread = new Thread(() -> {
            appendToChatArea("Started reading...");
            try {
                String message;
                while ((message = br.readLine()) != null) {
                    appendToChatArea(message);
                }
            } catch (IOException e) {
                appendToChatArea("Connection closed.");
            }
        });
        readerThread.start();
    }

    public static void main(String[] args) {
        new Client();
    }



        public String formatMessageForDisplay(String input) {
            return input + "\n";
        }

        // Other class members and methods...
    }
