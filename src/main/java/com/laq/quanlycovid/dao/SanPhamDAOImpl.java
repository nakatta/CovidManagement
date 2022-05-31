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
public class SanPhamDAOImpl implements SanPhamDAO{
    @Override
    public List<SanPham> getList(){
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
    
    @Override
    public int insert(SanPham sp ){
        try{
            Connection conn = DBConnect.getConnection();
//            String sql = ("SELECT max(idSP) idSP  FROM SANPHAM");
//            PreparedStatement ps = conn.prepareCall(sql);
//            ResultSet rs = ps.executeQuery();
            
            conn.setAutoCommit(false);
            String insertSql = "insert into SANPHAM(IdSP, tenSP, donGiaSP, dvTinh, hinhAnh) values (?,?,?,?,?)";
            PreparedStatement ptmt  = conn.prepareStatement(insertSql);
            ptmt.setString(1, sp.getIdSP());
            ptmt.setString(2, sp.getTenSP());
            ptmt.setInt(3, sp.getDonGiaSP());
            ptmt.setString(4, sp.getDvTinh());
            ptmt.setString(5, sp.getHinhAnh());
            
            ptmt.executeUpdate();
            return 1;
        } catch(SQLException e){
            e.printStackTrace();
            return 0;
        }            
    }
 
    @Override
    public int update(SanPham sp){
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "update SANPHAM set tenSP=?, donGiaSP=?, dvTinh=?, hinhAnh=? where idSP = ?";
            
            PreparedStatement ptmt  = conn.prepareStatement(sql);
//            
            ptmt.setString(1, sp.getTenSP());
            ptmt.setInt(2, sp.getDonGiaSP());
            ptmt.setString(3, sp.getDvTinh());
            ptmt.setString(4, sp.getHinhAnh());
            ptmt.setString(5, sp.getIdSP());
            ptmt.executeUpdate(); 
            return 1;
        } catch(SQLException e){
            e.printStackTrace();
            return 0;
        } 
    }
    
    @Override
    public int delete(String idSP){
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "delete SANPHAM where idSP=?";
            PreparedStatement ptmt  = conn.prepareStatement(sql);
            ptmt.setString(1, idSP);

            ptmt.executeUpdate();
            return 1;
        } catch(SQLException e){
            e.printStackTrace();
            return 0;
        } 
    }
    
    @Override
    public List<SanPham> findByTenSP(String tenSP){
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
    
    public static void main(String[] args){
        SanPhamDAO spdao = new SanPhamDAOImpl();
        System.out.println(spdao.getList());
    }
}