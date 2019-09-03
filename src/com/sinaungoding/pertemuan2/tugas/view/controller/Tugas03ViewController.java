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

import com.sinaungoding.pertemuan2.tugas.view.Tugas03View;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.DomainValidator;

/**
 *
 * @author od3ng
 */
public class Tugas03ViewController {

    private Tugas03View view;

    public Tugas03ViewController(Tugas03View view) {
        this.view = view;
    }

    public void proses() {
        String ip = view.getTxtIp().getText();
        DomainValidator validator = DomainValidator.getInstance();
//        if (!isValid(ip)) {
        if (!validator.isValid(ip)) {
            JOptionPane.showMessageDialog(view, "Format URL tidak sesuai!", "Informasi", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                InetAddress address = InetAddress.getByName(ip);
                JOptionPane.showMessageDialog(view, view.getTxtIp().getText() + " Menggunakan ip " + address.getHostAddress(), "Informasi IP", JOptionPane.INFORMATION_MESSAGE);
            } catch (UnknownHostException ex) {
                JOptionPane.showMessageDialog(view, ip + " Ip address tidak ditemukan!", "Informasi", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Tugas03ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
