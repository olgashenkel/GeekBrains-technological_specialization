package chat_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }


    // Метод запуска сервера
    public void runServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientManager clientManager = new ClientManager(socket);
                System.out.println("Подключен новый клиент!");
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        } catch (IOException e) {
            closeSocket();
        }
    }


    // Метод закрытия сервера
    public void closeSocket() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
