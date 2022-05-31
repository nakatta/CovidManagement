/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Lân
 */
public class QueryForProduct {
    public static List<SanPham> getList(){
        Connection conn = DBConnect.getConnection();
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        
        try{

            String sql = ("SELECT idSP, tenSP, dvtinh, donGiaSP, hinhAnh FROM SANPHAM");
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                         
            while(rs.next()){
                SanPham p = new SanPham(
                        rs.getString("idSP"),
                        rs.getString("tenSP"),
                        rs.getInt("donGiaSP"),
                        rs.getString("dvtinh"),
                        rs.getString("hinhAnh")                    
            );
            list.add(p);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace(); 
        }
        return list;
    }
    
    public static void insert(SanPham sp ){
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "insert into SANPHAM values (?,?,?,?,?)";
            PreparedStatement ptmt  = conn.prepareStatement(sql);
            ptmt.setString(1, sp.getIdSP());
            ptmt.setString(2, sp.getTenSP());
            ptmt.setInt(3, sp.getDonGiaSP());
            ptmt.setString(4, sp.getDvTinh());
            ptmt.setString(5, sp.getHinhAnh());
            ptmt.executeUpdate();                             
        } catch(SQLException e){
            e.printStackTrace();
        }            
    }
 
    public static void update(SanPham sp){
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "update SANPHAM set idSP=?, tenSP=?, donGiaSP=?, dtTinh=?, hinhAnh=?)";
            PreparedStatement ptmt  = conn.prepareStatement(sql);
            ptmt.setString(1, sp.getIdSP());
            ptmt.setString(2, sp.getTenSP());
            ptmt.setInt(3, sp.getDonGiaSP());
            ptmt.setString(4, sp.getDvTinh());
            ptmt.setString(5, sp.getHinhAnh());
            ptmt.executeUpdate();                             
        } catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
    public static void delete(String idSP){
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "delete SANPHAM where idSP=?";
            PreparedStatement ptmt  = conn.prepareStatement(sql);
            ptmt.setString(1, idSP);

            ptmt.executeUpdate();                             
        } catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
    
    public static List<SanPham> findByTenSP(String tenSP){
        Connection conn = DBConnect.getConnection();
        List<SanPham> list = new ArrayList<SanPham>();
        try {           
            String sql = "select * from SANPHAM where tenSP like ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%"+tenSP +"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                SanPham p = new SanPham(
                        rs.getString("idSP"),
                        rs.getString("tenSP"),
                        rs.getInt("donGiaSP"),
                        rs.getString("dvtinh"),
                        rs.getString("hinhAnh")                    
            );
            list.add(p);
            }
        }catch (SQLException e) {
                e.printStackTrace();
    }
        return list;
    }
}
