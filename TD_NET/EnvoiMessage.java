package TD_NET;

import java.net.*; import java.io.*;
class EnvoiMessage {
    static final int port=4500;
    public static void main(String argv[]) throws SocketException, IOException {
        if (argv.length!=1) {
            System.out.println ("donnez le nom de la machine destinataire");
            System.exit(0);
        }
        BufferedReader entree =new BufferedReader (new InputStreamReader(System.in));
        String ligne=entree.readLine();
        int longueur=ligne.length();
        byte[] message=new byte[longueur];
        InetAddress adresse=null;
        DatagramSocket socket;
        try { adresse = InetAddress.getByName(argv[0]); }
        catch(UnknownHostException exc) {System.out.println("destinataire inconnu"); }
        message=ligne.getBytes();
        DatagramPacket envoi= new DatagramPacket(message,longueur,adresse,port);
        socket=new DatagramSocket();
        socket.send(envoi);
    }
}