package chat_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;


public class Main {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(1300);
            Server server = new Server(serverSocket);
            server.runServer();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
