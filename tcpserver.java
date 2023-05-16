import java.io.*;
import java.net.*;
public class TCPServer {
    public static void main(String[] args) {
        int port = 10000; 
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Voting Server Started on port " + port);
            int c1vote = 0;
            int c2vote = 0;

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostName());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientInput = in.readLine();

                if (clientInput.equalsIgnoreCase("C1")) {
                    c1vote++;
                    out.println("Vote  registered for Candidate1");
                } else if (clientInput.equalsIgnoreCase("C2")) {
                    c2vote++;
                    out.println("Vote  registered for Candidate2");
                } else if (clientInput.equalsIgnoreCase("Result")) {
                    out.println("Candidate1 Votes: " + c1vote + "\nCandidate2 Votes: " + c2vote);
                } else {
                    out.println("Invalid input");
                }

                in.close();
                out.close();
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
