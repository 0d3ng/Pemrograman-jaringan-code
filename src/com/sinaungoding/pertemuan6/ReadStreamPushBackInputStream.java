/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 30, 2019 2:57:22 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan6;

import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ReadStreamPushBackInputStream {

    public static void main(String[] args) {
        PushbackInputStream stream = new PushbackInputStream(System.in);
        System.out.print("Masukan karakter apapun: ");
        try {
            int read = stream.read();
            stream.unread(read);
            int read2 = stream.read();
            System.out.print("" + (char) read);
            System.out.print("" + (char) read2);
        } catch (IOException ex) {
            Logger.getLogger(ReadStreamPushBackInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
