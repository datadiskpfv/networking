package uk.co.datadisk;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Main_Server_RMI extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUID = 1L;

    protected Main_Server_RMI() throws RemoteException {
        super(5000);            // specify port
    }

    @Override
    public String helloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact");
        return "Server says hello to " + name;
    }

    public static void main(String[] args) {

        try {
            Naming.rebind("//localhost/MyServer", new Main_Server_RMI());
            System.err.println("Server ready");

        } catch (Exception e){
            System.out.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
