/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;


import com.laq.quanlycovid.dao.NguoiDungDAO;
import com.laq.quanlycovid.dao.NguoiDungDAOImpl;
import com.laq.quanlycovid.model.DiaChi;
import com.laq.quanlycovid.model.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Envy
 */
public class NguoiDungServiceImpl implements NguoiDungService {
    private NguoiDungDAO nguoiDungDAO = null;
    public NguoiDungServiceImpl(){
        nguoiDungDAO = new NguoiDungDAOImpl();
    }
    @Override
    public ArrayList<NguoiDung> getList() {
        return nguoiDungDAO.getList();
    }
     public List<NguoiDung> getRelateList(String cmnd) {
        return nguoiDungDAO.getRelateList(cmnd);
    }
     public DiaChi getDiaChi (String cmnd){
         return nguoiDungDAO.getDiaChi(cmnd);
     }
     public int createNguoiDung(NguoiDung nd, DiaChi dc){
         return nguoiDungDAO.createNguoiDung(nd, dc);
     }
    public int updateNguoiDung(NguoiDung old, NguoiDung upd, DiaChi dc_old, int flag){
        return nguoiDungDAO.updateNguoiDung(old, upd, dc_old, flag);
    }
    public List<String> getPhuong(){
        return nguoiDungDAO.getPhuong();
    }
    public List<String> getQuan(){
        return nguoiDungDAO.getQuan();
    }
    public List<String> getThanhPho(){
        return nguoiDungDAO.getThanhPho();
    }
    
}
