package TD_NET;

import java.net.*;
import java.io.*;

public class TCPClient {
    Socket so;

    public TCPClient(String host, int port) throws IOException {
        so = new Socket(host, port);
    }

    public void go() {
        try {
            echange(so.getInputStream(), so.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            so.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void echange(InputStream is, OutputStream os) throws IOException {
        DataInputStream dis = new DataInputStream(is);

        while (true) {
            try {
                String message = dis.readUTF();
                System.out.println("Message from server: " + message);
            } catch (EOFException e) {
                System.out.println("Server closed the connection.");
                break;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java TCPClient <host> <port>");
            return;
        }
        TCPClient c = new TCPClient(args[0], Integer.parseInt(args[1]));
        c.go();
    }
}
