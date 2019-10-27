/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Oct 20, 2019 10:13:32 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan8;

import java.io.Serializable;

/**
 *
 * @author od3ng
 */
public class MataKuliah implements Serializable{

    private static final long serialVersionUID = 5559055602375093688L;
    
    private String kodeMk;
    private transient String nama;
    private static byte sks;

    public MataKuliah(String kodeMk, String nama, byte sks) {
        this.kodeMk = kodeMk;
        this.nama = nama;
        this.sks = sks;
    }

    public String getKodeMk() {
        return kodeMk;
    }

    public void setKodeMk(String kodeMk) {
        this.kodeMk = kodeMk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public byte getSks() {
        return sks;
    }

    public void setSks(byte sks) {
        this.sks = sks;
    }

    @Override
    public String toString() {
        return "MataKuliah{" + "kodeMk=" + kodeMk + ", nama=" + nama + ", sks=" + sks + '}';
    }
    
    
    
}
