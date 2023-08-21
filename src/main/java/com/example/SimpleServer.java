package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String args[]){
        // open socket server at port 11222
        try( ServerSocket serverSocket = new ServerSocket(11222)){
            System.out.println("Server is listening on port 11222");
            while(true){
                // accept client connection
                Socket clientSocket = serverSocket.accept();
                // read message from client
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // send message to client
                System.out.println("Received from client: " + in.readLine());
                
            }

        } catch (Exception e) {
        }

        // send message to client
    }
}
