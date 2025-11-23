package lesson_05.task_02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try {
//            ServerSocket serverSocket = new ServerSocket(1300);
//            Server server = new Server(serverSocket);
//            server.runServer();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Пожалуйста, введите свое имя: ");
            String name = scanner.nextLine();
            Socket socket = new Socket("localhost", 1300);
            Client client = new Client(socket, name);
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("Интернет-адрес: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Удаленный IP: " + remoteIp);
            System.out.println("Локальный порт: " + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
