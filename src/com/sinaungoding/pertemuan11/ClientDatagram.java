/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 17, 2019 9:18:52 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan11;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author od3ng
 */
public class ClientDatagram {

    public static DatagramSocket d;
    public static byte buffer[] = new byte[1024];
    public static int clientport = 800, serverport = 900;

    public static void main(String args[]) throws Exception {
        d = new DatagramSocket(clientport);
        System.out.println("Client sedang menunggu server mengirimkan data ");
        System.out.println("tekan Ctrl + C untuk mengakhiri ");
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            d.receive(p);
            String ps = new String(p.getData(), 0, p.getLength());
            System.out.println("From Server: " + ps);
        }
    }
}
