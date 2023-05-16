import java.net.*;
import java.io.*;
class Server {
public static void main(String args[]) throws Exception
{
ServerSocket ss = new ServerSocket(8000);
Socket s = ss.accept();
DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str1 = "", str2 = "";
System.out.println("Server started");
while (!str1.equals("close"))
{
str1 = din.readUTF();
System.out.println("Client typed : " + str1);
System.out.print("Type a message to client : ");
str2 = br.readLine();
dout.writeUTF(str2);
dout.flush();
}
din.close();
s.close();
ss.close();
}
}
class Client {
public static void main(String args[]) throws Exception
{
Socket s = new Socket("localhost", 8000);
DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str1 = "", str2 = "";
System.out.println("Client started");
while (!str1.equals("close"))
{
System.out.print("Type a message to server : ");
str1 = br.readLine();
dout.writeUTF(str1);
dout.flush();
str2 = din.readUTF();
Department of Computer Engineering
Class: S.Y. B.Tech. Semester: IV
Course Code: DJ19CEL405 Course Name: Computer Networks Lab
System.out.println("Server typed : " + str2);
}
dout.close();
s.close();
}
}
