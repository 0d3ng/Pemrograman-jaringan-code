/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Oct 28, 2019 1:02:14 AM
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
public class Praktikum2 extends Thread {

    private Generator generator;

    public Praktikum2(Generator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        generator.generateRandomNumber(getName());
    }

    public static void main(String[] args) {
        Generator g = new Generator(10, 100);
        Praktikum2 p = new Praktikum2(g);
        Praktikum2 p2 = new Praktikum2(g);
        p.start();
        p2.start();
    }

}
