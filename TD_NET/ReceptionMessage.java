package TD_NET;

import java.net.*;
import java.io.*;


public class ReceptionMessage {
    static final int port=4500;
    public static void main(String argv[]) throws SocketException,IOException {
        byte[] memoire = new byte[1000]; //Tableau qui contiendra les bytes reçus
        String texte;
        DatagramSocket socket =new DatagramSocket(port);
        DatagramPacket reception = new DatagramPacket(memoire,memoire.length);
        socket.receive(reception);
        texte=new String(memoire);
        System.out.println("Reception de la machine "+
                reception.getAddress().getHostName()+ " sur le port " +reception.getPort()+
                " :\n"+ texte ); }
}


