/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 17, 2019 10:01:10 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan11.tugas;

import java.io.Serializable;

/**
 *
 * @author od3ng
 */
public class Lokasi implements Serializable{

    private static final long serialVersionUID = 9084975315636057626L;
    
    private int x;
    private int y;

    public Lokasi(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Lokasi{" + "x=" + x + ", y=" + y + '}';
    }
    
    
    
}
