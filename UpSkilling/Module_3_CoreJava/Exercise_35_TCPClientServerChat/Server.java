package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_35_TCPClientServerChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket =
                    new ServerSocket(5000);

            System.out.println(
                    "Server started..."
            );

            System.out.println(
                    "Waiting for client..."
            );

            Socket socket =
                    serverSocket.accept();

            System.out.println(
                    "Client connected."
            );

            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );

            PrintWriter output =
                    new PrintWriter(
                            socket.getOutputStream(),
                            true
                    );

            String clientMessage =
                    input.readLine();

            System.out.println(
                    "Client: "
                            + clientMessage
            );

            output.println(
                    "Hello from Server!"
            );

            input.close();
            output.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}