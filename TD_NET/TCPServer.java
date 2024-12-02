package TD_NET;

import java.net.*;
import java.io.*;

public class TCPServer {
    ServerSocket ss;

    public TCPServer(int port) throws IOException {
        ss = new ServerSocket(port);
    }

    public void go() {
        System.out.println("Server is running. Waiting for a client...");
        while (true) {
            try {
                Socket so = ss.accept();
                System.out.println("Client connected!");
                echange(so.getInputStream(), so.getOutputStream());
                so.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void echange(InputStream is, OutputStream os) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(os);

        String message;
        System.out.println("Type a message to send to the client:");
        while ((message = consoleReader.readLine()) != null) {
            dos.writeUTF(message);
            dos.flush();
            System.out.println("Message sent: " + message);
            System.out.println("Type another message to send to the client:");
        }
    }

    public static void main(String args[]) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: java TCPServer <port>");
            return;
        }
        TCPServer s = new TCPServer(Integer.parseInt(args[0]));
        s.go();
    }
}
