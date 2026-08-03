package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Acts like a web browser: connects to the web server, sends an HTTP GET
 * request, and prints the whole response.
 *
 * Start WebServer first, then run this class.
 */
public class WebClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // TODO 1: send an HTTP GET request the way a browser does:
            //         "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n"

            // TODO 2: read every line of the response with in.readLine()
            //         until it returns null, and print each line

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
