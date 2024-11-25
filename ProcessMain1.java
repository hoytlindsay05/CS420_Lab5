public class ProcessMain1 {
    public static void main(String[] args) {
        try {
            String serverAddress = "localhost";
            ProcessImpl process = new ProcessImpl(serverAddress);
            System.out.println("Client 1 starting synchronization...");
            process.synchronize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
