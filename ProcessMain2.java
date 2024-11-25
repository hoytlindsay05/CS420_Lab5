public class ProcessMain2 {
    public static void main(String[] args) {
        try {
            String serverAddress = "localhost";
            ProcessImpl process = new ProcessImpl(serverAddress);
            System.out.println("Client 2 starting synchronization...");
            process.synchronize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
