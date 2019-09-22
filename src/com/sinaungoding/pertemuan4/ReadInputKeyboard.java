/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 11, 2019 11:06:59 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ReadInputKeyboard {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Masukan karakter apapun, [tekan keluar tekan `q`]: ");
        char input = 0;
        do {
            try {
                input = (char) br.read();
                System.out.print("" + input);
            } catch (IOException ex) {
                Logger.getLogger(ReadInputKeyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (input != 'q');
    }

}
