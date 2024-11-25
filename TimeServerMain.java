import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TimeServerMain {
    public static void main(String[] args) {
        try {
            // Start the RMI registry programmatically on port 1099 (default RMI port)
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry started.");

            // Create and bind the TimeServer object
            TimeServer timeServer = new TimeServerImpl();
            Naming.rebind("TimeServer", timeServer);

            System.out.println("TimeServer is running and bound to the RMI registry...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
