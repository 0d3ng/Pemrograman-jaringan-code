/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Oct 20, 2019 1:38:14 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan8.tugas;

import com.sinaungoding.pertemuan8.Mahasiswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author od3ng
 */
public class ModelMahasiswa extends AbstractTableModel {

    private final List<Mahasiswa> mahasiswas;
    private final String[] COLUMNS = {"No", "NIM", "Nama", "Jurusan", "Prodi", "IPK"};

    public ModelMahasiswa() {
        mahasiswas = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return mahasiswas.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex+1;
            case 1:
                return mahasiswas.get(rowIndex).getNim();
            case 2:
                return mahasiswas.get(rowIndex).getNama();
            case 3:
                return mahasiswas.get(rowIndex).getJurusan();
            case 4:
                return mahasiswas.get(rowIndex).getProdi();
            case 5:
                return mahasiswas.get(rowIndex).getIpk();
            default:
                return null;
        }
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }
    
    public void addAll(List<Mahasiswa> list){
        mahasiswas.addAll(list);
        fireTableDataChanged();
    }

    public void addMahasiswa(Mahasiswa mahasiswa, int index) {
        mahasiswas.add(index, mahasiswa);
        fireTableRowsInserted(index, index + 1);
    }

    public void deleteMahasiswa(int index) {
        mahasiswas.remove(index);
        fireTableRowsDeleted(index, index + 1);
    }

    public void updateMahasiswa(Mahasiswa mahasiswa, int index) {
        mahasiswas.set(index, mahasiswa);
        fireTableRowsUpdated(index, index + 1);
    }

}
