/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip_adresse;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;

public class NetworkUtil {

    
    public void printAllOwnerMacs() {
        
        InetAddress[] ias;
        try {
            ias = InetAddress.getAllByName(getOwnerHostName());
            if (ias != null) {
                for (InetAddress ia : ias) {
                    System.out.println(ia.getHostAddress());
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Unbekannter Hostname");
        }
    }

    public String getOwnerHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOwnerNetworkDeviceName() {
        try {
            NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress
                    .getLocalHost());
            if (ni != null) {
                return ni.getDisplayName();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOwnerMac() {
        try {
            NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress
                    .getLocalHost());
            byte[] hwa = ni.getHardwareAddress();
            if (hwa == null) {
                return null;
            }
            String mac = "";
            for (int i = 0; i < hwa.length; i++) {
                mac += String.format("%x:", hwa[i]);
            }
            if (mac.length() > 0 && !ni.isLoopback()) {
                return mac.toLowerCase().substring(0, mac.length() - 1);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOwnerIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }


}
