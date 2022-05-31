/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;

import com.laq.quanlycovid.dao.SanPhamDAO;
import com.laq.quanlycovid.dao.SanPhamDAOImpl;
import com.laq.quanlycovid.model.SanPham;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Hoàng Lân
 */
public class SanPhamServiceImpl implements SanPhamService{
    private SanPhamDAO spdao = null;
    
    public SanPhamServiceImpl(){
        spdao = new SanPhamDAOImpl();
    }
    
    @Override
    public List<SanPham> getList(){
        return spdao.getList();
    }
    
     public int insert(SanPham sp){
         return spdao.insert(sp);
     }
     
     public int update(SanPham sp){
         return spdao.update(sp);
     }
     
     public int delete(String IdSP){
         return spdao.delete(IdSP);
     }
}
