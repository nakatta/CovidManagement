/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.model;

import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoàng Lân
 */
public class SanPham extends DefaultTableModel implements Serializable {
    private String idSP;
    private String tenSP;
    private String dvTinh;
    private int donGiaSP;
    private String hinhAnh;

    public SanPham(String idSP, String tenSP, int donGiaSP, String dvTinh, String hinhAnh) {
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.dvTinh = dvTinh;
        this.donGiaSP = donGiaSP;
        this.hinhAnh = hinhAnh;
    }
    
    public String getIdSP() {
        return idSP;
    }
    
    public void setIDSP(String idSP) {
        this.idSP = idSP;
    }
    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDvTinh() {
        return dvTinh;
    }

    public void setDvTinh(String dvTinh) {
        this.dvTinh = dvTinh;
    }

    public int getDonGiaSP() {
        return donGiaSP;
    }

    public void setDonGiaSP(int donGiaSP) {
        this.donGiaSP = donGiaSP;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
    public SanPham(){
        
    }

    @Override
    public String toString() {
        return "SanPham{" + "idSP=" + idSP + ", tenSP=" + tenSP + ", dvTinh=" + dvTinh + ", donGiaSP=" + donGiaSP + ", hinhAnh=" + hinhAnh + '}';
    }
    
     
}

