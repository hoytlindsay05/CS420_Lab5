import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TimeServerImpl extends UnicastRemoteObject implements TimeServer {
    private final long referenceClock;
    private final List<String> registeredProcesses;

    protected TimeServerImpl() throws RemoteException {
        super();
        this.referenceClock = System.currentTimeMillis(); // Reference clock
        this.registeredProcesses = new ArrayList<>();
    }

    @Override
    public long getTime() throws RemoteException {
        return System.currentTimeMillis();
    }

    @Override
    public void register(String processName) throws RemoteException {
        registeredProcesses.add(processName);
        System.out.println("Registered process: " + processName);
    }
}
