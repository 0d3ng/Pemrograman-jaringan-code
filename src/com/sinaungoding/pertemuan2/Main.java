/*
 * Pertemuan-2

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 1, 2019 9:29:44 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class Main {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.polinema.ac.id");
            InetAddress address2 = InetAddress.getByName("114.6.41.77");//menggunakan jaringan luar
            System.out.println("" + address.getHostAddress());
            System.out.println("" + address2.getHostName());
            if (address.equals(address2)) {
                System.out.println("Alamat sama");
            } else {
                System.out.println("Alamat tidak sama");
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
