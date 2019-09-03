/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 2, 2019 12:57:51 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan2.tugas;

import com.sinaungoding.pertemuan2.tugas.view.Tugas03View;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author od3ng
 */
public class Tugas {
    
    public static void ipDetectionClass() {
        Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Input ip address: ");
            String ip = s.next();
            Matcher matcher = pattern.matcher(ip);
            if (!matcher.matches()) {
                System.err.println("Salah format");
            } else {
                int group = Integer.parseInt(matcher.group(1));
                System.out.println("" + group);
                if (group < 128) {
                    System.out.println("Class A");
                } else if (group < 192) {
                    System.out.println("Class B");
                } else if (group < 224) {
                    System.out.println("Class C");
                } else if (group < 248) {
                    System.out.println("Class D");
                } else if (group < 255) {
                    System.out.println("Class E");
                } else {
                    System.out.println("Other class");
                }
            }
        } while (true);
    }
    
    public static void main(String[] args) {
//        ipDetectionClass();
//        Tugas01View view = new Tugas01View();
//        Tugas02View view = new Tugas02View();
        Tugas03View view = new Tugas03View();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
