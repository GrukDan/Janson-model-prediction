package server.server;

import server.Controller.RequestController;
import server.database.DatabaseHandler;

import java.io.*;
import java.net.Socket;

public class Server extends Thread {

    Socket socket;
    BufferedWriter bw;
    BufferedReader br;

    public Server(Socket socket) {
        this.socket = socket;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            if (!socket.isClosed()) {
                System.out.println("======================================================");
                System.out.println("======================================================");
                System.out.println("Thread: " + this.getName() + " started...");
                System.out.println("IP: " + socket.getLocalAddress().getHostName() + " PORT: " + socket.getLocalPort());

                RequestController requestController = new RequestController(bw,br);
                requestController.requestHandler();

            } else System.out.println("Socket is closed...");
        } finally {
            try {
                bw.close();
                br.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
