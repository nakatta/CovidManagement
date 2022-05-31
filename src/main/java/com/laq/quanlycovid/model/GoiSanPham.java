
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.laq.quanlycovid.model;
import java.io.Serializable;
import java.util.Date;
//import com.laq.quanlycovid.utility.Pair;


/**
 *
 * @author Hoàng Lân
 */

public class GoiSanPham implements Serializable {
    public String idGoi;
    public String tenGoi;
    public int mucGioiHan;
    public String tgGioiHan;
    public int donGia;

    public GoiSanPham() {
    }
    
    

    public GoiSanPham(String idGoi, String tenGoi, int mucGioiHan, String tgGioiHan, int donGia) {
        this.idGoi = idGoi;
        this.tenGoi = tenGoi;
        this.mucGioiHan = mucGioiHan;
        this.tgGioiHan = tgGioiHan;
        this.donGia = donGia;
    }

    
    public String getIdGoi() {
        return idGoi;
    }

    public void setIdGoi(String idGoi) {
        this.idGoi = idGoi;
    }

    public String getTenGoi() {
        return tenGoi;
    }

    public void setTenGoi(String tenGoi) {
        this.tenGoi = tenGoi;
    }

    public int getMucGioiHan() {
        return mucGioiHan;
    }

    public void setMucGioiHan(int mucGioiHan) {
        this.mucGioiHan = mucGioiHan;
    }

    public String getTgGioiHan() {
        return tgGioiHan;
    }

    public void setTgGioiHan(String tgGioiHan) {
        this.tgGioiHan = tgGioiHan;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
   
}

    