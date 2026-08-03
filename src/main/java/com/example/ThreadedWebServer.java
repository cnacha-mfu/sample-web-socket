package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

/**
 * Demonstrates running a web server as a THREAD.
 *
 * A class that implements Runnable can be run inside a Thread. The code in
 * run() is what the thread executes. Because each server runs in its own
 * thread, one program can run several servers at the same time - here we
 * start two, each listening on a different port.
 *
 * Run this class, then open http://localhost:9090 and http://localhost:9091
 * in your browser. Each one answers from a different server instance.
 */
public class ThreadedWebServer implements Runnable {

    private int port;

    public ThreadedWebServer(int port) {
        this.port = port;
    }

    // this method is executed when the thread starts
    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Threaded server is listening on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // read the first line of the request from the client
                    String request = in.readLine();
                    System.out.println("Port " + port + " received: " + request);

                    // send an HTTP response back
                    String header = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n";
                    out.println(header + "<html><body><h1>Time from server on port " + port
                            + " is " + LocalTime.now() + "</h1></body></html>");
                }
            }
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // create two server objects listening on different ports
        // and start each one in its own thread
        Thread server1 = new Thread(new ThreadedWebServer(9090));
        server1.start();

        Thread server2 = new Thread(new ThreadedWebServer(9091));
        server2.start();

        // main() continues immediately - both servers keep running
        // in their own threads until you stop the program
        System.out.println("Two servers started from one program!");
    }

}
