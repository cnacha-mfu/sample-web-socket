package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String args[]) {
        try {
            // TODO 1: open a ServerSocket at port 11222

            System.out.println("Server is listening on port 11222");
            while (true) {
                // TODO 2: accept a client connection to get a client Socket

                // TODO 3: read one line from the client with BufferedReader
                //         and print it out

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
