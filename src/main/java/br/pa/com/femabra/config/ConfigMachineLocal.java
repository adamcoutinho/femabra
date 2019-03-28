package br.pa.com.femabra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

@Component
public class ConfigMachineLocal {

    @Bean
    public void component() throws UnknownHostException, SocketException {

        System.out.println(System.getProperty("os.name").toLowerCase());
        Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
        NetworkInterface inter;
        while (networks.hasMoreElements()) {
            inter = networks.nextElement();
            byte[] mac = inter.getHardwareAddress();
            if (mac != null) {
                for (int i = 0; i < mac.length; i++) {
                    System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                }
                System.out.println("");
            }
        }
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            System.out.println(ipAddr.getHostName());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }


    }






}

