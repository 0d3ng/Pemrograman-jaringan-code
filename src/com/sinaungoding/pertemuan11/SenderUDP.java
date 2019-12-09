/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 17, 2019 8:46:38 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class SenderUDP {

    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName("localhost");
            int Port = 2000;
            String s = "Pesan ini dari UDP";
            byte[] b = s.getBytes();
            DatagramPacket dp = new DatagramPacket(b, b.length, ia, Port);
            DatagramSocket sender = new DatagramSocket();
            sender.send(dp);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SenderUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(SenderUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SenderUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
