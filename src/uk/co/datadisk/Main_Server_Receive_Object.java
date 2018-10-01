package uk.co.datadisk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main_Server_Receive_Object {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            Socket s = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            Employee emp1 = (Employee) in.readObject();

            System.out.println("Object Received: ");
            System.out.println("\t" + emp1.getFirstName() + " " + emp1.getLastName());

            // You can also use RMI, RPC or REST
            if(emp1 instanceof Employee){
                callFromClient();
            }

            in.close();

        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void callFromClient() {
        System.out.println("This was called by the client");
    }
}