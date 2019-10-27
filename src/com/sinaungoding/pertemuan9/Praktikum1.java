/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Oct 28, 2019 12:25:20 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan9;

/**
 *
 * @author od3ng
 */
public class Praktikum1 {
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadOne("Thread Satu"));
        t.start();
        ThreadTwo t2 = new ThreadTwo();
        t2.setName("Thread Dua");
        t2.start();
    }
}
