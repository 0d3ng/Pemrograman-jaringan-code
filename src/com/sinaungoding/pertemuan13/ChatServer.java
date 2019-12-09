/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Dec 2, 2019 7:51:38 AM
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
public class ChatServer {

    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        try {
            MulticastSocket server = new MulticastSocket(1234);
            InetAddress group = InetAddress.getByName("224.0.0.1");
            //getByName – Mengembalikan alamat IP yang diberikan oleh Host
            server.joinGroup(group);
            boolean infinite = true;
            /* Server terus-menerus menerima data dan mencetak mereka */
            while (infinite) {
                byte buf[] = new byte[1024];
                DatagramPacket data = new DatagramPacket(buf,
                        buf.length);
                server.receive(data);
                String msg = new String(data.getData()).trim();
                System.out.println(msg);
            }
            server.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
