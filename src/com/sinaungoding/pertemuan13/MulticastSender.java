/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Dec 2, 2019 8:42:38 AM
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
import java.net.SocketException;

/**
 *
 * @author od3ng
 */
public class MulticastSender {

    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        InetAddress ia = null;
        int port = 0;
        byte ttl = (byte) 1;
        // read the address from the command line
        try {
            ia = InetAddress.getByName("224.0.0.1");
            port = Integer.parseInt("8888");
            if (args.length > 2) {
                ttl = (byte) Integer.parseInt("1000");
            }
        } catch (Exception ex) {
            System.err.println(ex);
            System.err.println(
                    "Usage: java MulticastSender multicast_address port ttl");
            System.exit(1);
        }
        byte[] data = "Here's some multicast data\r\n".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
        try {
            MulticastSocket ms = new MulticastSocket();
            ms.joinGroup(ia);
            for (int i = 1; i <= 10; i++) {
                ms.send(dp, ttl);
            }
            ms.leaveGroup(ia);
            ms.close();
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
