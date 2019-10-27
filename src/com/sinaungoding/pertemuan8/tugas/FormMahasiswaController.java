/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Oct 20, 2019 11:12:28 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan8.tugas;

import com.sinaungoding.pertemuan8.Mahasiswa;
import com.sinaungoding.pertemuan8.Praktikum1;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author od3ng
 */
public class FormMahasiswaController {

    private final FormMahasiswa fm;
    private final ModelMahasiswa modelMahasiswa;
    private int selectRow;

    public FormMahasiswaController(FormMahasiswa fm) {
        this.fm = fm;
        this.fm.setLocationRelativeTo(null);
        modelMahasiswa = new ModelMahasiswa();
        this.fm.getTblMahasiswa().setModel(modelMahasiswa);
        loadData();
    }

    public void save() {
        String nim = fm.getTxtNIM().getText();
        String nama = fm.getTxtNama().getText();
        String jurusan = fm.getTxtJurusan().getText();
        String prodi = fm.getTxtProdi().getText();
        String ipk = fm.getTxtIPK().getText();
        if (!nim.isEmpty() && !nama.isEmpty() && !jurusan.isEmpty() && !prodi.isEmpty() && !ipk.isEmpty()) {
            Mahasiswa m = new Mahasiswa(nim, nama, jurusan, prodi, Float.parseFloat(ipk));
            modelMahasiswa.addMahasiswa(m, modelMahasiswa.getMahasiswas().size());
            clear();
            writeData();
        }
    }

    public void update() {
        String nim = fm.getTxtNIM().getText();
        String nama = fm.getTxtNama().getText();
        String jurusan = fm.getTxtJurusan().getText();
        String prodi = fm.getTxtProdi().getText();
        String ipk = fm.getTxtIPK().getText();
        if (!nim.isEmpty() && !nama.isEmpty() && !jurusan.isEmpty() && !prodi.isEmpty() && !ipk.isEmpty()) {
            Mahasiswa m = new Mahasiswa(nim, nama, jurusan, prodi, Float.parseFloat(ipk));
            modelMahasiswa.updateMahasiswa(m, selectRow);
            clear();
            writeData();
        }
    }

    public void delete() {
        int selectedRow = fm.getTblMahasiswa().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(fm, "Pilih dahulu baris yang akan dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(fm, "Anda yakin akan menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                modelMahasiswa.deleteMahasiswa(selectedRow);
                clear();
                writeData();
            }
        }
    }

    public void clear() {
        fm.getTxtNIM().setText("");
        fm.getTxtNama().setText("");
        fm.getTxtJurusan().setText("");
        fm.getTxtProdi().setText("");
        fm.getTxtIPK().setText("");
        fm.getTblMahasiswa().getSelectionModel().clearSelection();
        selectRow = -1;
    }

    public void selectOnTable() {
        int selectedRow = fm.getTblMahasiswa().getSelectedRow();
        if (selectedRow >= 0) {
            this.selectRow = selectedRow;
            Mahasiswa mhs = modelMahasiswa.getMahasiswas().get(selectedRow);
            fm.getTxtNIM().setText(mhs.getNim());
            fm.getTxtNama().setText(mhs.getNama());
            fm.getTxtJurusan().setText(mhs.getJurusan());
            fm.getTxtProdi().setText(mhs.getProdi());
            fm.getTxtIPK().setText("" + mhs.getIpk());
        }
    }

    private void writeData() {
        if (!modelMahasiswa.getMahasiswas().isEmpty()) {
            try {
                Praktikum1.writeObject(modelMahasiswa.getMahasiswas());
            } catch (Exception ex) {
                Logger.getLogger(FormMahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadData() {
        try {
            List<Mahasiswa> readObject = (List<Mahasiswa>) Praktikum1.readObject();
            if (readObject != null && !readObject.isEmpty()) {
                readObject.forEach((mahasiswa) -> {
                    System.out.println("" + mahasiswa);
                });
                modelMahasiswa.addAll(readObject);
            }
        } catch (Exception ex) {
            Logger.getLogger(FormMahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
