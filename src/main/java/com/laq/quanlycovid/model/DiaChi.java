/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.model;
import java.io.Serializable;
/**
 *
 * @author Envy
 */

public class DiaChi implements Serializable{
    private String diachi;
    private String phuong;
    private String quan;
    private String thanh_pho;
    
    public DiaChi(){};
    public DiaChi(String sn,String ph,String q,String tp){
    	diachi = sn;
    	phuong = ph;
    	quan = q;
    	thanh_pho =tp;
    };


    public void setPhuong(String P) {
        phuong = P;
    }
    public String getPhuong(){
        return phuong;
    }

    public void setQuan(String n) {
        quan = n;
    }
    public String getQuan(){
        return quan;
    }

    public void setDiaChi(String d) {
        diachi = d;
    }
    public String getDiaChi(){
        return diachi;
    }

    public void setThanhPho(String n) {
        thanh_pho = n;
    }
    public String getThanhPho(){
        return thanh_pho;
    }
    
    @Override
    public String toString(){
        return (diachi + " " + phuong + " " + quan + " "  + thanh_pho);
    }
}

