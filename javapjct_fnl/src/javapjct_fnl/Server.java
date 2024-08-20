package javapjct_fnl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter out;

    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    public Server() {
        // Complexity: O(1) - Only initializes the UI components, constant amount of memory and time
        initializeUI();
    }

    private void startServer() {
        try {
            server = new ServerSocket(7777);
            appendToChatArea("Server is ready to accept the connection...\nWaiting...");
            // Complexity: O(1) - Starts a new thread, time complexity of starting thread is constant
            new Thread(() -> {
                try {
                    socket = server.accept(); // Complexity: O(1) - Blocking call, but constant time to accept a connection
                    appendToChatArea("Client connected.");
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), true);

                    // Enable UI components once client is connected
                    SwingUtilities.invokeLater(() -> {
                        messageField.setEnabled(true);
                        sendButton.setEnabled(true);
                        messageField.requestFocus();
                    });

                    startReading(); // Complexity depends on the number of messages received
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
            appendToChatArea("Failed to start server.");
        }
    }

    private void initializeUI() {
        // Complexity: O(1) - Setup is static and does not scale with input
        frame = new JFrame("Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(0, 1));
        messageField = new JTextField();
        messageField.setEnabled(false);
        inputPanel.add(messageField);

        sendButton = new JButton("Send");
        sendButton.setEnabled(false);
        sendButton.addActionListener(this::sendMessage);
        inputPanel.add(sendButton);

        JButton startServerButton = new JButton("Start Server");
        startServerButton.addActionListener(e -> startServer());
        inputPanel.add(startServerButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));
        inputPanel.add(quitButton);

        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void appendToChatArea(String message) {
        // Complexity: O(1) - Adding text to JTextArea; although appending text grows linearly with text length,
        // each call handles only its own string
        SwingUtilities.invokeLater(() -> chatArea.append(message));
    }

    private void startReading() {
        // Complexity: O(m) - Runs as long as messages are received; m is the number of messages
        new Thread(() -> {
            try {
                String message;
                while ((message = br.readLine()) != null) {
                    appendToChatArea(message + "\n");
                }
                appendToChatArea("Client disconnected.\n");
            } catch (IOException e) {
                appendToChatArea("Connection lost.\n");
            }
        }).start();
    }

    private void sendMessage(ActionEvent e) {
        // Complexity: O(1) - Sending a message; time taken does not scale with number of messages
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            out.println("Server: " + message);
            out.flush();
            messageField.setText("");
        }
    }

    public static void main(String[] args) {
        new Server();
    }

    public String prepareMessageForDisplay(String input) {
        return input + "\n"; 
        }
    }
