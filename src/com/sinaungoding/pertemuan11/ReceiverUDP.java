/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 17, 2019 8:50:20 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ReceiverUDP {
    public static void main(String[] args) {
        try {
            byte buffer[] = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer,buffer.length);
            DatagramSocket ds = new DatagramSocket(2000);
            ds.receive(incoming);
            byte[] data = incoming.getData();
//            byte[] trim = trim(data);
//            String s = new String(trim);
            String s = new String(data, 0, data.length);
            System.out.println("Port " + incoming.getPort() + " on " + incoming.getAddress() + " sent this message:");
            System.out.println(s);
        } catch (SocketException ex) {
            Logger.getLogger(ReceiverUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReceiverUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static byte[] trim(byte[] bytes) {
        int i = bytes.length - 1;
        while (i >= 0 && bytes[i] == 0) {
            --i;
        }
        return Arrays.copyOf(bytes, i + 1);
    }
}
