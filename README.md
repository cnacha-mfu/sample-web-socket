# Sample: Sockets and a Simple Web Server in Java

These examples show, step by step, how a web server works underneath: it is just a program that listens on a network port with a **socket**, reads a request, and writes a response back.

Study the examples **in this order** — each one adds one new idea. Together they prepare you for the [lab-web-socket](https://github.com/maefahluang-uni/lab-web-socket) lab.

| # | Files | What you learn |
|---|-------|----------------|
| 1 | `SimpleServer` + `SimpleClient` | Open a `ServerSocket`, `accept()` a connection, send one message from client to server |
| 2 | `EchoServer` + `EchoClient` | Two-way communication: both sides read **and** write using `BufferedReader` and `PrintWriter` |
| 3 | `WebServer` + `WebClient` | Speak HTTP: the client sends a `GET` request, the server replies with an HTTP header and HTML — a browser can talk to it too |
| 4 | `ThreadedWebServer` | Run a server as a **thread** (`Runnable`), so one program can run two servers on different ports at the same time |

## How to run

Open this folder in VS Code. For each pair, **start the server first**, then run the client (use the *Run* button above `main`, or run each class from the terminal).

1. **SimpleServer / SimpleClient** — run `SimpleServer`, then `SimpleClient`. The server console prints the message from the client.
2. **EchoServer / EchoClient** — run `EchoServer`, then `EchoClient`. Type a message in the client console and press Enter; the server echoes it back. Press Enter on an empty line to quit.
3. **WebServer / WebClient** — run `WebServer`, then `WebClient`. The client prints the full HTTP response. Also try opening <http://localhost:8080> in your web browser — the browser is just another client!
4. **ThreadedWebServer** — run it, then open <http://localhost:9090> and <http://localhost:9091>. Two servers, two ports, one program — thanks to threads.

> **Tip:** only one program can listen on a port at a time. If you get an error like `Address already in use`, stop the previous server before starting a new one.

## Key ideas to take into the lab

- `ServerSocket` waits for connections; `accept()` returns a `Socket` for one client.
- `BufferedReader` reads text from a socket; `PrintWriter` writes text to it.
- An HTTP response is plain text: a status line, headers, a **blank line**, then the HTML body.
- A class that `implements Runnable` can be started with `new Thread(...).start()` — that is how one program runs many servers.
- Always close the client socket when you are done with it (the examples use *try-with-resources*, which closes it automatically).
