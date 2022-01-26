package ru.knyazevvb.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        new EchoServer().start();
    }

    public void start() {
        Socket clientSocket = null;
        Scanner scanner = new Scanner(System.in);

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключение...");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился " + clientSocket.getRemoteSocketAddress());
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            Thread serverThread = new Thread(() -> {
                try {
                    while (true) {
                        outputStream.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverThread.setDaemon(true);
            serverThread.start();

            while (true) {
                String clientMessage = inputStream.readUTF();
                if ("/end".equalsIgnoreCase(clientMessage)) {
                    System.out.println("Клиент отключился");
                    outputStream.writeUTF("/end");
                    break;
                }
                System.out.println("Ответ клиента: " + clientMessage);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (clientSocket != null) {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}