/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Oct 20, 2019 10:42:29 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class Praktikum2 {

    public static void main(String[] args) {
        MataKuliah mk = new MataKuliah("001", "Pemrograman Jaringan", (byte) 3);
        try {
            System.out.println("" + mk);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mk.obj"));
            oos.writeObject(mk);
            oos.flush();
            oos.close();
            mk.setSks((byte) 2);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mk.obj"));
            try {
                MataKuliah mk1 = (MataKuliah) ois.readObject();
                System.out.println("" + mk1);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Praktikum2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Praktikum2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Praktikum2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
