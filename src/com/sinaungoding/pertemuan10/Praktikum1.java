/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 2, 2019 3:08:05 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author od3ng
 */
public class Praktikum1 {

    public static void main(String[] args) {
        ScheduledExecutorService exe = Executors.newSingleThreadScheduledExecutor();       
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService executor = Executors.newCachedThreadPool();
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Task t = new Task("Task " + i);
            executor.execute(t);
        }
        executor.shutdown();
    }
}
