package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        // port 8080 is a common choice for a web server during development
        // (port 80 is the real web port but needs admin permission on many systems)
        int webport = 8080;
        // Web server that responds Hello using ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(webport)) {
            System.out.println("Server is listening on port " + webport);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // TODO 1: read the first line of the request with
                    //         in.readLine() and print it, e.g. "GET / HTTP/1.1"

                    // TODO 2: send the HTTP response with out.println(...):
                    //         header "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n"
                    //         followed by an HTML body

                }
            }
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }

    }

}
