import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.server.UnicastRemoteObject;

public class ProcessImpl extends UnicastRemoteObject implements Process {
    private long localClock;
    private final TimeServer timeServer;

    protected ProcessImpl(String serverAddress) throws RemoteException {
        super();
        this.localClock = System.currentTimeMillis();
        TimeServer serverReference = null;
        try {
            serverReference = (TimeServer) Naming.lookup("//" + serverAddress + "/TimeServer");
        } catch (NotBoundException e) {
            System.err.println("TimeServer not bound in RMI registry.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error connecting to TimeServer.");
            e.printStackTrace();
        }
        this.timeServer = serverReference;
    }

    @Override
    public void synchronize() throws RemoteException {
        if (timeServer != null) {
            long serverTime = timeServer.getTime();
            long offset = serverTime - localClock;
            localClock += offset;
            System.out.println("Synchronized! Offset: " + offset + "ms, Updated Local Clock: " + localClock);
        } else {
            System.err.println("Cannot synchronize: TimeServer reference is null.");
        }
    }
}
