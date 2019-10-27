/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 30, 2019 3:50:15 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan6;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ReadStreamPushBackReader {
    
    public static void main(String[] args) {
        String s = "Polinema tetap jaya selalu di kancah nasional dan akan berlanjut ke internasional";
        PushbackReader reader = new PushbackReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes())));
        char[] words = new char[s.length()];
        
        try {
            reader.read(words);
            System.out.println("" + new String(words));
//            words = new char[s.length()];
            reader.unread(words,0,0);
            reader.read(words);
            System.out.println("" + new String(words));
        } catch (IOException ex) {
            Logger.getLogger(ReadStreamPushBackReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
