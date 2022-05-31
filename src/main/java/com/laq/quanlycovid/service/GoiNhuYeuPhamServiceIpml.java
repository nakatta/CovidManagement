/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;

import com.laq.quanlycovid.dao.GoiNhuYeuPhamDAO;
import com.laq.quanlycovid.dao.GoiNhuYeuPhamDAOImpl;
import com.laq.quanlycovid.model.GoiSanPham;
import java.util.List;

/**
 *
 * @author Hoàng Lân
 */
public class GoiNhuYeuPhamServiceIpml implements GoiNhuYeuPhamService{
        private GoiNhuYeuPhamDAO gspdao = null;
    
    public GoiNhuYeuPhamServiceIpml(){
        gspdao = new GoiNhuYeuPhamDAOImpl();
    }
    
   @Override
    public List<GoiSanPham> getList(){
        return gspdao.getList();
    }
    
     public int insert(GoiSanPham gsp){
         return gspdao.insert(gsp);
     }
     
     public int update(GoiSanPham gsp){
         return gspdao.update(gsp);
     }
     
     public int delete(String IdSP){
         return gspdao.delete(IdSP);
     }
}
