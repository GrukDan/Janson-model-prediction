package server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RunServer {

    public static int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started...");
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    (new Server(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
