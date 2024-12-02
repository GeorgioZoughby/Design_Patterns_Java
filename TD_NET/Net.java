package TD_NET;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Net {
    public static void main(String[] args) {
        try {
            InetAddress myMachine = InetAddress.getLocalHost();
            System.out.println(myMachine);
        } catch (UnknownHostException e) {
            System.out.println("Couldn't get local host");
        }

        try {
            if (args.length > 0) {
                // InetAddress server = InetAddress.getByName(args[0]);
                // System.out.println(server);
                InetAddress[] servers = InetAddress.getAllByName(args[0]);
                for (InetAddress serv : servers) {
                    System.out.println(serv);
                }
                // jupiter et titan ne sont pas des domaines valides c'est pourquoi on ne peut pas resolver le hostname.
            }
        } catch (UnknownHostException e) {
            System.out.println("Couldn't get local host");
        }
    }
}


