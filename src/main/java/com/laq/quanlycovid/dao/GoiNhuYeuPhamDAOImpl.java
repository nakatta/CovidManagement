/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.GoiSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Lân
 */
public class GoiNhuYeuPhamDAOImpl implements GoiNhuYeuPhamDAO{
    @Override
    public List<GoiSanPham> getList(){
        GoiSanPham gsp = new GoiSanPham();
        Connection conn = DBConnect.getConnection();
        ArrayList<GoiSanPham> list = new ArrayList<GoiSanPham>();
//        String tgGioiHan = new SimpleDateFormat("yyyy-MM-dd").format(gsp.getTgGioiHan());
        
        try{

            String sql = ("SELECT idGoi, tenGoi, mucGioiHan, tgGioiHan, donGia FROM GOINYP");
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                         
            while(rs.next()){
                GoiSanPham p = new GoiSanPham(
                        rs.getString("idGoi"),
                        rs.getString("tenGoi"),
                        rs.getInt("mucGioiHan"),
                        rs.getString("tgGioiHan"),
                        Integer.parseInt(rs.getString("donGia"))                    
            );
            list.add(p);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace(); 
        }
        return list;
    }
    
    @Override
    public int insert(GoiSanPham gsp){
        Connection conn = DBConnect.getConnection();
//        String tgGioiHan = new SimpleDateFormat("yyyy-MM-dd").format(gsp.getTgGioiHan());
        String sql = "Insert into GOINYP(idgoi, tenGoi, mucGioiHan, tgGioiHan, donGia)" + " Values(?,?,?,?,?)";
        PreparedStatement  stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, gsp.getIdGoi());
            stmt.setString(2, gsp.getTenGoi());
            stmt.setInt(3, gsp.getMucGioiHan());
            stmt.setString(4, gsp.getTgGioiHan());
            stmt.setInt(5, gsp.getDonGia());
            
            stmt.executeUpdate();
            return 1;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }                  
    }
 
    @Override
    public int update(GoiSanPham gsp){
        Connection conn = DBConnect.getConnection();
//        String tgGioiHan = new SimpleDateFormat("yyyy-MM-dd").format(gsp.getTgGioiHan());
        String sql = "Update GOINYP " + " Set tenGoi = ?, mucGioiHan = ?, tgGioiHan = ?, donGia = ?" + " where idGoi = ?";
	PreparedStatement stmt;
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, gsp.getTenGoi());
            stmt.setInt(2, gsp.getMucGioiHan());
            stmt.setString(3, gsp.getTgGioiHan());
            stmt.setInt(4, gsp.getDonGia());
            stmt.setString(5, gsp.getIdGoi());
            
            stmt.executeUpdate();
            return 1;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }        
    }
    
    @Override
    public int delete(String id){
        Connection conn = DBConnect.getConnection();
        String sql = "Delete from GOINYP where idGoi=?";
        PreparedStatement stmt;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
            return 1;
            
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    

    
    public static void main(String[] args){
        SanPhamDAO spdao = new SanPhamDAOImpl();
        System.out.println(spdao.getList());
    }
}    
    
