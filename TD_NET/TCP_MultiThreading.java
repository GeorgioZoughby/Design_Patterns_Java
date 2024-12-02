package TD_NET;

import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.*;

public class TCP_MultiThreading {
}


class Service extends Thread {
    Socket socket;
    BufferedReader entree;
    PrintStream sortie;

    Service(Socket socket) {
        this.socket = socket;
        try {
            entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sortie = new PrintStream(socket.getOutputStream());
        } catch (IOException exc) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
        this.start();
    }

    public void run() {
        String texte;
        int compteur = 0;
        StringTokenizer st;
        try {
            while (!(texte = entree.readLine()).equals("xxxxxx")) compteur += (new
                    StringTokenizer(texte)).countTokens();
            sortie.println("votre texte possede " + compteur + " mots");
        } catch (IOException exc) {
        }
        try {
            socket.close();
        } catch (IOException e) {
        }
    }
}

class Serveur extends Thread {
    final static int port = 10000;
    ServerSocket receptionniste;

    Serveur() {
        try {
            receptionniste = new ServerSocket(port);
        } catch (IOException exc) {
            System.out.println("impossible de creer le serveur");
        }
        this.start();
    }

    public void run() {
        Socket socket;
        Service c;
        try {
            while (true) {
                socket = receptionniste.accept();
                c = new Service(socket);
            }
        } catch (IOException exc) {
            System.out.println("probleme de connection");
        }
    }

    public static void main(String argv[]) {
        new Serveur();
    }
}


class Client {
    static final int port = 10000;

    public static void main(String[] argv) {
        BufferedReader lecteurFichier = null;
        BufferedReader entree = null;
        PrintStream sortie = null;
        String ligne = null;
        Socket socket = null;
        try {
            socket = new Socket(argv[1], port);
            lecteurFichier = new BufferedReader(new FileReader(argv[0]));
            entree = new BufferedReader(new
                    InputStreamReader(socket.getInputStream()));
            sortie = new PrintStream(socket.getOutputStream());
            while ((ligne = lecteurFichier.readLine()) != null) sortie.println(ligne);
            sortie.println("xxxxxx");
            System.out.println(entree.readLine());
            socket.close();
        } catch (IOException exc) {
            System.out.println("probleme a determiner");
        }
    }
}