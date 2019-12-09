/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 17, 2019 10:14:12 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan11.tugas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ClientCursor implements Runnable {

    private DatagramSocket ds;
    private DatagramPacket packet;
    private final byte[] buff = new byte[65536];

    public ClientCursor(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        while (true) {
            packet = new DatagramPacket(buff, buff.length);
            try {
                ds.receive(packet);
                byte[] data = packet.getData();
                Lokasi lokasi = (Lokasi) Util.byteArrayToObject(data);
                System.out.println("Port " + packet.getPort() + " on " + packet.getAddress() + " sent this message:");
                System.out.println("" + lokasi);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ClientCursor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientCursor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(2000);
            Thread t = new Thread(new ClientCursor(datagramSocket));
            t.start();
        } catch (SocketException ex) {
            Logger.getLogger(ClientCursor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
