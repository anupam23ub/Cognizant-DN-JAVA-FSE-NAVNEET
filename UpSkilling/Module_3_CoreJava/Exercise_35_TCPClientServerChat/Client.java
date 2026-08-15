package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_35_TCPClientServerChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {

            Socket socket =
                    new Socket(
                            "localhost",
                            5000
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

            output.println(
                    "Hello from Client!"
            );

            String serverMessage =
                    input.readLine();

            System.out.println(
                    "Server: "
                            + serverMessage
            );

            input.close();
            output.close();
            socket.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}