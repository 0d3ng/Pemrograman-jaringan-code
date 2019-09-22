/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 22, 2019 7:35:36 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ReadFile {

    public static void main(String[] args) {
        try {
            int desimal;
            char ascii;
            LineNumberInputStream inputStream = new LineNumberInputStream(new FileInputStream("coba.txt"));
            while ((desimal = inputStream.read()) != -1) {
                ascii = (char) desimal;
                System.out.println("" + ascii + " at line " + inputStream.getLineNumber());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
