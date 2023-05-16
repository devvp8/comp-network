import java.io.*;
import java.net.*;
public class TCPClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 10000;
        try {
            Socket so = new Socket(host, port);

            BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));
            PrintWriter out = new PrintWriter(so.getOutputStream(), true);
           BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput = "";
            while (!userInput.equalsIgnoreCase("exit")) {
                System.out.println("Please enter your vote (C1 or C2) or enter Result to get vote count:");
                userInput = stdIn.readLine();
                out.println(userInput);
                String res = in.readLine();
                System.out.println(res);
            }
            in.close();
            out.close();
            stdIn.close();
            so.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
