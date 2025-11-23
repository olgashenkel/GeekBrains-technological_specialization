package chat_client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private String name;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;


    public Client(Socket socket, String userName) throws IOException {
        this.socket = socket;
        name = userName;

        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    /**
     * Закрытие приложения
     * @param socket
     * @param bufferedReader
     * @param bufferedWriter
     */
    private void closeEverything (Socket socket, BufferedReader bufferedReader,
                                  BufferedWriter bufferedWriter){
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Слушатель для входящих сообщений
     */
    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFromGroup;
                while (socket.isConnected()){
                    try {
                        messageFromGroup = bufferedReader.readLine();
                        System.out.println(messageFromGroup);
                    } catch (IOException e){
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    /**
     * Отправить сообщение
     */
    public void sendMessage(){
        try {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()){
                String message = scanner.nextLine();
                bufferedWriter.write(name+": "+ message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

}