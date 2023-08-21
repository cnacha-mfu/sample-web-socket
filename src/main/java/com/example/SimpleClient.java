package com.example;

import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String args[]){
        try(Socket socket = new Socket("localhost", 11222)){
            // send message to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from Nacha !!!");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
