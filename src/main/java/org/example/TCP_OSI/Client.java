package org.example.TCP_OSI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverIP = "localhost"; // 127.0.0.1

        int serverPort = 8089;

        try(Socket socket = new Socket(serverIP, serverPort)){
            System.out.println("Подключились успешно!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
        }
    }
}
