package uk.co.datadisk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main_Client {

    private static String HOST = "localhost";
    private static int PORT = 5000;

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT)){

            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);


            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.print("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if(!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                    System.out.println();
                }
            } while(!echoString.equals("exit"));

        } catch (IOException e){
            System.out.println("ERROR: unable to connect to the server " + e.getMessage());
        }
    }
}