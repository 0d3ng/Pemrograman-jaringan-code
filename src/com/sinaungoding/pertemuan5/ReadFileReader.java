/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 22, 2019 8:07:26 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ReadFileReader {

    public static void main(String[] args) {
        try {
            int desimal;
            char ascii;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("coba.txt"));
            while ((desimal = lineNumberReader.read()) != -1) {
                ascii = (char) desimal;
                System.out.println("" + ascii + " at line " + lineNumberReader.getLineNumber());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
