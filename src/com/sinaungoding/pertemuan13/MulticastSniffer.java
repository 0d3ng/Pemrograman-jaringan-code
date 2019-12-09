/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Dec 2, 2019 8:22:29 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class MulticastSniffer {
    
    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        InetAddress group = null;
        int port = 0;
        // read the address from the command line
        try {
            group = InetAddress.getByName("224.0.0.1");
            port = Integer.parseInt("8888");
        } // end try
        catch (Exception ex) {
            // ArrayIndexOutOfBoundsException, NumberFormatException,
            // or UnknownHostException
            System.err.println(
                    "Usage: java MulticastSniffer multicast_address port");
            System.exit(1);
        }
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);
            byte[] buffer = new byte[8192];
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer,
                        buffer.length);
                ms.receive(dp);
                String s = new String(dp.getData());
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException ex) {
                    Logger.getLogger(MulticastSniffer.class.getName()).log(Level.SEVERE, "", ex);
                }
            }
        }
    }
}
