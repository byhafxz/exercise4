import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class ServerTranslationApplication {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		
		try {
			
			int portNo = 4228;
			serverSocket = new ServerSocket(portNo);
			
			String text1 = "Good adfternoon";
			System.out.println("Waiting for request");
			
			while (true) {
				
				Socket clientSocket = serverSocket.accept();
				
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				outputStream.writeUTF(text1);
				
				clientSocket.close();
				
			}
		}	catch (IOException ioe) {
			
			if (serverSocket != null)
				serverSocket.close();
			
			ioe.printStackTrace();
		}
	}

}
