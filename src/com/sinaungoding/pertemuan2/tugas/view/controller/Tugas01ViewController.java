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

import com.sinaungoding.pertemuan2.tugas.view.Tugas01View;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author od3ng
 */
public class Tugas01ViewController {

    private Tugas01View view;

    private final Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public Tugas01ViewController(Tugas01View view) {
        this.view = view;
    }

    public void proses() {
        if (!isIp()) {
            JOptionPane.showMessageDialog(view, "Format alamat ip tidak sesuai!", "Informasi", JOptionPane.ERROR_MESSAGE);
        } else {
            int segment = Integer.parseInt(view.getTxtSegment().getText());
            view.getAreaOutput().append("Segmen :"+segment);
            view.getAreaOutput().append("\n");
            int hostId = (int) Math.pow(2, (32 - segment));
            view.getAreaOutput().append("Host ID:"+hostId);
            view.getAreaOutput().append("\n\n");
            System.out.println("" + hostId);
            String ip = view.getTxtIp().getText();
            System.out.println("" + ip);
            String[] ipAdd = ip.split("\\.");
            String ipAwal = ipAdd[0] + "." + ipAdd[1] + "." + ipAdd[2] + "." + 0;//check formula
            String ipAkhir = ipAdd[0] + "." + ipAdd[1] + "." + ipAdd[2] + "." + (hostId - 2);
            view.getAreaOutput().append("Ip Awal    :"+ipAwal);
            view.getAreaOutput().append("\n");
            view.getAreaOutput().append("Ip Akhir   :"+ipAkhir);
            view.getAreaOutput().append("\n");
            view.getAreaOutput().append("Range IP\n");
            for (int i = 1; i <= hostId - 2; i++) {
                String range = ipAdd[0] + "." + ipAdd[1] + "." + ipAdd[2] + "." + i;
                view.getAreaOutput().append(""+range);
                view.getAreaOutput().append("\n");
            }
            String subnet = "" + (256 - hostId);
            view.getAreaOutput().append("Subnet     :"+subnet);
        }
    }

    private boolean isIp() {
        try {
            String ip = view.getTxtIp().getText();
            Matcher matcher = pattern.matcher(ip);
            return matcher.matches();
        } catch (Exception e) {
            Logger.getLogger(Tugas01ViewController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
