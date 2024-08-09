package Apps;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final Integer PORT = 8080;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server started");
            while(true){
                try(Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ){
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d",name,clientSocket.getPort()));
                }catch (InterruptedIOException e){
                    throw new RuntimeException(e);
                }
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
