/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 3, 2019 6:10:56 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class Praktikum2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            Tist t = new Tist("" + i);
//            Future<String> submit = executor.submit(t);
//            try {
//                System.out.println("Get -> " + submit.get());
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Praktikum2.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ExecutionException ex) {
//                Logger.getLogger(Praktikum2.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

//        latihan
        for (int i = 0; i < 10; i++) {
            Callable<Long> tost = new Tost();
            Future<Long> submit = executor.submit(tost);
            try {
                System.out.println("GET -> "+submit.get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Praktikum2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        executor.shutdown();
    }
}
