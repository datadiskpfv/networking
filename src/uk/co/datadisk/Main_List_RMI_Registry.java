package uk.co.datadisk;

import javax.naming.Name;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main_List_RMI_Registry {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // Find registry (on default port 1099)
        Registry registry = LocateRegistry.getRegistry();

        // Get list of names bound to this registry
        String[] boundNames = registry.list();
        String[] namingList = Naming.list("MyServer");

        Remote namingRO = Naming.lookup("MyServer");
        Remote registryRO = registry.lookup("MyServer");


        System.out.println("------- Methods -------------------------");
        for( Method method : namingRO.getClass().getMethods()){
            System.out.println(method.getName());
        }

        System.out.println("--------- Binding List ---------------------");
        for (String name : boundNames)
        {
            System.out.println(name);
        }

        System.out.println("--------- Naming List ---------------------");
        for (String name : namingList)
        {
            System.out.println(name);
        }
    }
}
