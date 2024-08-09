package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WebClient {
    public static void main(String[]args){
          try (Socket socket = new Socket("localhost", 80)) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
