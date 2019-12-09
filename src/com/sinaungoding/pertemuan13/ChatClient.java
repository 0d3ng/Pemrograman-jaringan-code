/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Dec 2, 2019 7:52:58 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ChatClient {

    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        try {
            MulticastSocket chat = new MulticastSocket(1234);

            InetAddress group = InetAddress.getByName("224.0.0.1");
            chat.joinGroup(group);
            String msg = "hallo";
            System.out.println("Type a message for the server:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            msg = br.readLine();
            DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, 1234);
            chat.send(data);
            chat.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
