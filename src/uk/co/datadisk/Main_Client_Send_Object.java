package uk.co.datadisk;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main_Client_Send_Object {

    private static String HOST = "localhost";
    private static int PORT = 5000;

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT)){

            Employee emp1 = new Employee("Paul", "Valle");
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(emp1);
            out.flush();
            out.close();

        } catch (SocketTimeoutException e) {
            System.out.println("The client socket timed out, exiting.....");
        } catch (IOException e){
            System.out.println("ERROR: unable to connect to the server " + e.getMessage());
        }
    }
}