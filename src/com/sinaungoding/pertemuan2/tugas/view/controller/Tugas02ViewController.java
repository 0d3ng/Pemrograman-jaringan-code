/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 2, 2019 9:19:42 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan2.tugas.view.controller;

import com.sinaungoding.pertemuan2.tugas.view.Tugas02View;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author od3ng
 */
public class Tugas02ViewController {

    private Tugas02View view;

    private final Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private Matcher matcher;

    public Tugas02ViewController(Tugas02View view) {
        this.view = view;
    }

    public void proses() {
        if (!isIp()) {
            JOptionPane.showMessageDialog(view, "Format alamat ip tidak sesuai!", "Informasi", JOptionPane.ERROR_MESSAGE);
        } else {
            int group = Integer.parseInt(matcher.group(1));
            System.out.println("" + group);
            String ipClass;
            if (group < 128) {
                ipClass = "A";
                System.out.println("Class A");
            } else if (group < 192) {
                System.out.println("Class B");
                ipClass = "B";
            } else if (group < 224) {
                System.out.println("Class C");
                ipClass = "C";
            } else if (group < 248) {
                System.out.println("Class D");
                ipClass = "D";
            } else if (group < 255) {
                System.out.println("Class E");
                ipClass = "E";
            } else {
                System.out.println("Other class");
                ipClass = "Other class";
            }
            JOptionPane.showMessageDialog(view, view.getTxtIp().getText() + " adalah ip kelas " + ipClass, "Informasi Kelas IP", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isIp() {
        try {
            String ip = view.getTxtIp().getText();
            matcher = pattern.matcher(ip);
            return matcher.matches();
        } catch (Exception e) {
            Logger.getLogger(Tugas02ViewController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
