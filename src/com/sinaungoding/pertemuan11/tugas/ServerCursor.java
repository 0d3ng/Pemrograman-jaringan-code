/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 17, 2019 9:33:26 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan11.tugas;

import java.awt.MouseInfo;
import java.awt.Point;
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
public class ServerCursor implements Runnable {

    private DatagramSocket datagramSocket;
    private InetAddress address;
    private DatagramPacket packet;

    public ServerCursor(DatagramSocket datagramSocket, InetAddress address) {
        this.datagramSocket = datagramSocket;
        this.address = address;
    }

    public static void main(String[] args) {
        try {
            int port = 2001;
            System.out.println("Server running on port " + port);
            DatagramSocket datagramSocket = new DatagramSocket(port);
            InetAddress address = InetAddress.getByName("localhost");
            Thread t = new Thread(new ServerCursor(datagramSocket, address));
            t.start();
        } catch (SocketException ex) {
            Logger.getLogger(ServerCursor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerCursor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                Point location = MouseInfo.getPointerInfo().getLocation();
                Lokasi l = new Lokasi(location.x, location.y);
                byte[] objectToByteArray = Util.objectToByteArray(l);
                packet = new DatagramPacket(objectToByteArray, 0, objectToByteArray.length, address, 2000);
                datagramSocket.send(packet);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerCursor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServerCursor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
