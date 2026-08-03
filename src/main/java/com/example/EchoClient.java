package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int portNumber = 12345;

        try (Socket socket = new Socket(serverAddress, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            // TODO: read the user's input from stdIn until an empty line;
            //       send each line to the server with out.println(...)
            //       and print the server's reply from in.readLine()

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
