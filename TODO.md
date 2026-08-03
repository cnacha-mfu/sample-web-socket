# In-Class Demonstration Flow

This repository has two branches:

- **`main`** — the in-class version. Some code is blanked out with `// TODO` comments. We fill these in together during the demonstration.
- **[`complete`](https://github.com/cnacha-mfu/sample-web-socket/tree/complete)** — the finished code for every example. Use it to catch up or check your work.

Follow the steps in order — each one adds a single new idea.

---

## Step 1: Send one message through a socket

**Files:** `SimpleServer.java`, `SimpleClient.java`

**Idea:** a server is a program that *listens* on a port; a client *connects* to it.

**Fill in together:**
1. In `SimpleServer` — open a `ServerSocket` on port `11222`, `accept()` a connection, read one line with `BufferedReader` and print it.
2. In `SimpleClient` — create a `Socket` to `localhost:11222`, send one message with `PrintWriter`.

**Try it:** run `SimpleServer` first, then `SimpleClient`. The message appears in the *server's* console.

**Solution:** [SimpleServer](https://github.com/cnacha-mfu/sample-web-socket/blob/complete/src/main/java/com/example/SimpleServer.java) · [SimpleClient](https://github.com/cnacha-mfu/sample-web-socket/blob/complete/src/main/java/com/example/SimpleClient.java)

---

## Step 2: Talk in both directions (echo)

**Files:** `EchoServer.java`, `EchoClient.java`

**Idea:** both sides can read **and** write — each side needs a `BufferedReader` (in) and a `PrintWriter` (out).

**Fill in together:**
1. In `EchoServer` — loop with `readLine()`; for every line received, print it and send it back with `out.println(...)`.
2. In `EchoClient` — read the user's keyboard input, send it to the server, print the server's reply.

**Try it:** run `EchoServer`, then `EchoClient`. Type messages in the client console; press Enter on an empty line to quit.

**Solution:** [EchoServer](https://github.com/cnacha-mfu/sample-web-socket/blob/complete/src/main/java/com/example/EchoServer.java) · [EchoClient](https://github.com/cnacha-mfu/sample-web-socket/blob/complete/src/main/java/com/example/EchoClient.java)

---

## Step 3: Speak HTTP — a real web server

**Files:** `WebServer.java`, `WebClient.java`

**Idea:** HTTP is just text over a socket. A response is: a status line, headers, a **blank line**, then the HTML body.

**Fill in together:**
1. In `WebServer` — read the request line (e.g. `GET / HTTP/1.1`) and print it, then send:
   - header: `HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n`
   - body: some HTML such as `<html><body><h1>Hello From Server</h1></body></html>`
2. In `WebClient` — send a `GET` request the way a browser does, then read the whole response until `readLine()` returns `null`.

**Try it:** run `WebServer`, then `WebClient`. Then open <http://localhost:8080> in a real browser — the browser is just another client!

**Solution:** [WebServer](https://github.com/cnacha-mfu/sample-web-socket/blob/complete/src/main/java/com/example/WebServer.java) · [WebClient](https://github.com/cnacha-mfu/sample-web-socket/blob/complete/src/main/java/com/example/WebClient.java)

---

## Step 4: Run servers as threads

**File:** `ThreadedWebServer.java`

**Idea:** a class that `implements Runnable` can run inside a `Thread`. One program can therefore run several servers at once, each on its own port.

**Fill in together:**
1. In `main()` — create a `ThreadedWebServer` object for port `9090`, wrap it in a `Thread`, and `start()` it.
2. Do the same for port `9091`.
3. Discuss: why does `main()` finish its own code immediately while both servers keep running?

**Try it:** run it, then open <http://localhost:9090> and <http://localhost:9091> — two servers, one program.

**Solution:** [ThreadedWebServer](https://github.com/cnacha-mfu/sample-web-socket/blob/complete/src/main/java/com/example/ThreadedWebServer.java)

---

## After class

You are now ready for the graded lab: [lab-web-socket](https://github.com/maefahluang-uni/lab-web-socket). It asks you to build exactly this: a threaded web server (Steps 3 + 4) and a web client (Step 3), checked by an automated test.

> **Tip:** only one program can listen on a port at a time. If you see `Address already in use`, stop the previous server first.
