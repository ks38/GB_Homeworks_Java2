package ru.knyazevvb.networkchat.Server;

import ru.knyazevvb.networkchat.Command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static ru.knyazevvb.networkchat.Command.*;

public class ClientHandler {

    private final Socket socket;
    private final ChatServer chatServer;
    private final DataInputStream in;
    private final DataOutputStream out;
    private boolean isNotDisconnected;

    private String nick;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        try {
            this.nick = "";
            this.socket = socket;
            this.chatServer = chatServer;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            isNotDisconnected = false;

            // добавление таймера
            Thread timerThread = new Thread(() -> {
                try {
                    Thread.sleep(120_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!isNotDisconnected) {
                  sendMessage(END.getCommand());
                  closeConnection();
                }
            });
            timerThread.start();
            //конец добавления таймера

            new Thread(() -> {
                try {
                    authenticate();
                    if (isNotDisconnected) {
                        readMessage();
                    }
                } finally {
                    closeConnection();
                    isNotDisconnected = true;
                }

            }).start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void closeConnection() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket != null) {
            try {
                socket.close();
                chatServer.unsubscribe(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readMessage() {
        try {
            while (true) {
                final String message = in.readUTF();
                if (Command.isCommand(message)) {
                    if (getCommandByText(message) == END) {
                        break;
                    }
                    if (getCommandByText(message) == PRIVATE_MESSAGE) {
                        final String[] split = message.split(" ");
                        final String nickTo = split[1];
                        chatServer.sendMessageToClient(this, nickTo, message
                                .substring(PRIVATE_MESSAGE.getCommand().length() + 2 +
                                        nickTo.length()));
                    }
                    continue;
                }
                chatServer.broadcast(nick + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void authenticate() {
        try {
            while (true) {
                String message = in.readUTF();
                if (message.startsWith("/end")) {
                    sendMessage(message);
                    isNotDisconnected = false;
                    break;
                }
                if (getCommandByText(message) == AUTH) {
                    isNotDisconnected = true;
                    final String[] split = message.split(" ");
                    final String login = split[1];
                    final String password = split[2];
                    final String nick = chatServer.getAuthService()
                            .getNickByLoginAndPassword(login, password);
                    if (nick != null) {
                        if (chatServer.isNickBusy(nick)) {
                            isNotDisconnected = true;
                            sendMessage("Пользователь уже авторизован");
                            continue;
                        }
                        sendMessage(Command.AUTHOK, nick);
                        this.nick = nick;
                        chatServer.broadcast("Пользователь " + nick + " зашел в чат");
                        isNotDisconnected = true;
                        chatServer.subscribe(this);
                        break;
                    } else {
                        sendMessage("Неверный логин и пароль");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Command command, String message) {
        try {
            out.writeUTF(command.getCommand() + " " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void sendMessage(String message) {
        try {

            out.writeUTF(getNick() + ": " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick == null ? "" : nick;
    }
}