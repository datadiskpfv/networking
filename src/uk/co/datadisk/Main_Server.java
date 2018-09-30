package uk.co.datadisk;

import java.io.IOException;
import java.net.ServerSocket;

public class Main_Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            while(true){
               new Echoer(serverSocket.accept()).start();
            }

            //System.out.println("Come back soon!!");

        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}