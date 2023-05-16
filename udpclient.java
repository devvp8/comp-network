import java.net.*;
public class UDPClient {
    private static final int SERVER_PORT = 10000;
    private static final String SERVER_IP = "localhost";
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName(SERVER_IP);
        System.out.println("Welcome to voter System");
        System.out.println("Enter the name of your candidate or 'exit' to stop voting.");
        while (true) {
            byte[] sdata = new byte[1024];
            String cname = System.console().readLine();
            if (cname.equalsIgnoreCase("exit")) {
                break;
            }
            sdata = cname.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sdata, sdata.length, serverAddress, SERVER_PORT);
            clientSocket.send(sendPacket);
        }
        clientSocket.close();
    }
}
