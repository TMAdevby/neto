package org.example.TCP_OSI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8089;

        System.out.println("Сервер запущен на порту " + port);
        System.out.println("Ожидаем подключение ... ");

        try (ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                try(Socket clientSocket = serverSocket.accept()){
                    String clientIP = clientSocket.getInetAddress().getHostAddress();
                    int clientPort = clientSocket.getPort();

                    System.out.println("Новое подключение!");
                    System.out.println("IP клиента: " + clientIP);
                    System.out.println("Порт клиента: " + clientPort);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream())
                    );

                    PrintWriter out = new PrintWriter(
                           clientSocket.getOutputStream(),
                    );

                }
            }
        }
    }
}
