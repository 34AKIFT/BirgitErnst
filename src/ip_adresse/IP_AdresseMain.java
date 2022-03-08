
package ip_adresse;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Bix
 */
public class IP_AdresseMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
        System.out.println("Meine IP Adresse ist: "+InetAddress.getLocalHost().getHostAddress());
       } catch(Exception e)
       {
           e.printStackTrace();
       }
               NetworkUtil nu = new NetworkUtil();
        nu.printAllOwnerMacs();
        System.out.println("Host-Name: " + nu.getOwnerHostName());
        System.out.println("Device-Name: " + nu.getOwnerNetworkDeviceName());
        System.out.println("Mac-Adresse: " + nu.getOwnerMac());
        System.out.println("IP: " + nu.getOwnerIp());
    }

    
}
