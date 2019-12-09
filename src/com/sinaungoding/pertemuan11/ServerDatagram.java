/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 17, 2019 9:15:03 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author od3ng
 */
public class ServerDatagram {

    public static DatagramSocket ds;
    public static int clientport = 800, serverport = 900;

    public static void main(String args[]) throws Exception {
        byte buffer[] = new byte[1024];
        ds = new DatagramSocket(serverport);
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server menunggu input");
        InetAddress i = InetAddress.getByName("Localhost");
        while (true) {
            System.out.print("Inputan Server: ");
            String str = dis.readLine();
            if ((str == null || str.equals("end"))) {
                break;
            }
            buffer = str.getBytes();
            ds.send(new DatagramPacket(buffer, str.length(), i, clientport));
        }
    }
}
