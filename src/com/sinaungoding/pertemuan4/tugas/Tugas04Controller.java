/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 15, 2019 11:04:21 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan4.tugas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author od3ng
 */
public class Tugas04Controller {

    private Tugas04 view;

    public Tugas04Controller(Tugas04 view) {
        this.view = view;
        view.setLocationRelativeTo(null);
        view.getBtHitung().addActionListener((ActionEvent e) -> {
            hitung();
        });
        view.getBtReset().addActionListener((ActionEvent e) -> {
            reset();
        });
        view.getTxtPanjang().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                numberOnly(e);
            }

        });
        view.getTxtLebar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                numberOnly(e);
            }

        });
        loggingInfo();
        loggingError();
    }

    private void hitung() {
        String panjang = view.getTxtPanjang().getText();
        String lebar = view.getTxtLebar().getText();
        if (!panjang.isEmpty() && panjang != null && !lebar.isEmpty() && lebar != null) {
            try {
                double luas = Double.parseDouble(panjang) * Double.parseDouble(lebar);
                double keliling = 2 * (Double.parseDouble(panjang) + Double.parseDouble(lebar));
                view.getTxtLuas().setText("" + luas);
                view.getTxtKeliling().setText("" + keliling);
                System.out.println("panjang :" + panjang);
                System.out.println("lebar   :" + lebar);
                System.out.println("luas    :" + luas);
                System.out.println("keliling:" + keliling);
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("Field null");
            JOptionPane.showMessageDialog(view, "Panjang atau lebar tidak boleh kosong", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void numberOnly(KeyEvent keyEvent) {
        if (!Character.isDigit(keyEvent.getKeyChar())) {
            keyEvent.consume();
        }
    }

    private void reset() {
        view.getTxtKeliling().setText("");
        view.getTxtLuas().setText("");
        view.getTxtPanjang().setText("");
        view.getTxtLebar().setText("");
    }

    private void loggingInfo() {
        PrintStream info;
        try {
            File f = new File("log");
            if (!f.exists()) {
                f.mkdir();
            }
            File log = new File(f.getAbsoluteFile()+File.separator+"log.log");
            info = new PrintStream(new FilterOutputStream(new FileOutputStream(log, true)), true);
            System.setOut(info);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tugas04Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loggingError() {
        PrintStream error;
        try {
            File f = new File("log");
            if (!f.exists()) {
                f.mkdir();
            }
            File log = new File(f.getAbsoluteFile()+File.separator+"log.err");
            error = new PrintStream(new FilterOutputStream(new FileOutputStream(log, true)), true);
            System.setErr(error);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tugas04Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
