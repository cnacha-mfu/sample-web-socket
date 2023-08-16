package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
   
    public static void main(String[] args) {
        int webport = 80;
        String header = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n";
         // web server that response Hello using ServerSocket
          try (ServerSocket serverSocket = new ServerSocket(webport)) {
            System.out.println("Server is listening on port " + webport);
            
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)){

                        out.println(header + "<html><body><h1>Hello From Server</h1></body></html>");
                    }
                }
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }

    }
    
}
