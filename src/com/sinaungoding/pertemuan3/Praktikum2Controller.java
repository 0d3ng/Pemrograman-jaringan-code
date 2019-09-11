/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Sep 8, 2019 11:45:55 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author od3ng
 */
public class Praktikum2Controller {

    private Praktikum2 view;
    private List<Integer> list = new ArrayList<>();

    public Praktikum2Controller(Praktikum2 view) {
        this.view = view;
        this.view.getBtBaca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        });
        this.view.getBtSimpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
    }

    private void proses() {
        JFileChooser loadFile = view.getLoadFile();
        StyledDocument doc = view.getTxtPane().getStyledDocument();
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(loadFile.getSelectedFile());
                int read = inputStream.read();
                doc.insertString(0, "", null);
                while (read != -1) {
                    list.add(read);
                    doc.insertString(doc.getLength(), "" + read, null);
                    System.out.println("" + read);
                    read = inputStream.read();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | BadLocationException ex) {
                Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private void save() {
        JFileChooser loadFile = view.getLoadFile();
        if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
            OutputStream os = null;
            try {
                if (!list.isEmpty()) {
                    os = new FileOutputStream(loadFile.getSelectedFile());
                    byte[] dt = new byte[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        dt[i] = list.get(i).byteValue();
                    }
                    os.write(dt);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (os != null) {
                    try {
                        os.flush();
                        os.close();
                        list.clear();
                    } catch (IOException ex) {
                        Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

}
