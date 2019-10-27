/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Oct 28, 2019 12:50:31 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan9;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class Generator {

    private int low, high;

    public Generator(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public synchronized void generateRandomNumber(String name) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int result = r.nextInt(high - low) + low;
            System.out.println(name + ": " + result);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
