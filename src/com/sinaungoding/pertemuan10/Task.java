/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 2, 2019 3:01:58 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan10;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class Task implements Runnable {

    private String nama;

    public Task(String nama) {
        this.nama = nama;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("" + nama + " result: " + i);
            Long delay = (long) (Math.random() * 10);
            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
