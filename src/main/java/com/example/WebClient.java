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

            // send an HTTP GET request, the same way a browser does
            // a blank line marks the end of the request
            String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";
            out.println(request);

            // read every line of the response until the server closes the connection
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
