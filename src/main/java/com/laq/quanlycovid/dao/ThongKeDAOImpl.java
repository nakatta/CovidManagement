/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.NoiDieuTri;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Envy
 */
public class ThongKeDAOImpl implements ThongKeDAO {
    @Override
    public int getNumF0() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT (*) FROM NGUOI_LIEN_QUAN WHERE TRANGTHAI = ?";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, "F0");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps.close();
            rs.close();
            conn.close();
            return count;
        }catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getNumF1() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT (*) FROM NGUOI_LIEN_QUAN WHERE TRANGTHAI = ?";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, "F1");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps.close();
            rs.close();
            conn.close();
            return count;
        }catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getNumF2() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT (*) FROM NGUOI_LIEN_QUAN WHERE TRANGTHAI = ?";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, "F2");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps.close();
            rs.close();
            conn.close();
            return count;
        }catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getNumF3() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT (*) FROM NGUOI_LIEN_QUAN WHERE TRANGTHAI = ?";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, "F3");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps.close();
            rs.close();
            conn.close();
            return count;
        }catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getNumNormal() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT (*) FROM NGUOI_LIEN_QUAN WHERE TRANGTHAI = ?";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, "Ko");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps.close();
            rs.close();
            conn.close();
            return count;
        }catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getNumInfected() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT (*) FROM LS_QUAN_LY WHERE TRANGTHAI_MOI = ?";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, "F0");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps.close();
            rs.close();
            conn.close();
            return count;
        }catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getNumQuarantine() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT(*) FROM NGUOI_LIEN_QUAN WHERE TRANGTHAI != ? AND TRANGTHAI != ?";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, "F0");
            ps.setString(2, "Ko");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps.close();
            rs.close();
            conn.close();
            return count;
        }catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }
    public static void main(String args[]){
        ThongKeDAO a = new ThongKeDAOImpl();
        System.out.println(a.getNumF0());
        System.out.println(a.getNumF1());
        System.out.println(a.getNumF2());
        System.out.println(a.getNumF3());
        System.out.println(a.getNumNormal());
        System.out.println(a.getNumInfected());
        System.out.println(a.getNumQuarantine());
        
    }
}
