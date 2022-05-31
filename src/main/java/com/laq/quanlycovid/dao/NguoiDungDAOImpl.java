/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.DiaChi;
import com.laq.quanlycovid.model.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Envy
 */
public class NguoiDungDAOImpl implements NguoiDungDAO {
    @Override
    public ArrayList<NguoiDung> getList() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM NGUOI_LIEN_QUAN";
            ArrayList<NguoiDung> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NguoiDung tmp = new NguoiDung();
                tmp.setCMND(rs.getString("CMND"));
                tmp.setName(rs.getString("TEN"));
                tmp.setYear(rs.getInt("NAMSINH"));
                tmp.setStatus(rs.getString("TRANGTHAI"));
                tmp.setDebt(rs.getInt("DUNO"));
                tmp.setLinkedPID(rs.getString("NGLIENQUAN"));
                tmp.setHospital(rs.getString("BV"));
                list.add(tmp);
            }
            ps.close();
            rs.close();
            conn.close();
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NguoiDung> getRelateList(String cmnd) {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM NGUOI_LIEN_QUAN WHERE NGLIENQUAN = ?";
            List<NguoiDung> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, cmnd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NguoiDung tmp = new NguoiDung();
                tmp.setCMND(rs.getString("CMND"));
                tmp.setName(rs.getString("TEN"));
                tmp.setYear(rs.getInt("NAMSINH"));
                tmp.setStatus(rs.getString("TRANGTHAI"));
                tmp.setDebt(rs.getInt("DUNO"));
                tmp.setLinkedPID(rs.getString("NGLIENQUAN"));
                tmp.setHospital(rs.getString("BV"));
                list.add(tmp);
            }
            ps.close();
            rs.close();
            conn.close();
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public DiaChi getDiaChi (String cmnd){
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM DIACHI WHERE ID = ?";
            DiaChi dc = new DiaChi();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, cmnd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NguoiDung tmp = new NguoiDung();
                dc.setDiaChi(rs.getString("DUONG"));
                dc.setPhuong(rs.getString("PHUONG"));
                dc.setQuan(rs.getString("QUAN"));
                dc.setThanhPho(rs.getString("TP"));
            }
            ps.close();
            rs.close();
            conn.close();
            return dc;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public int createNguoiDung(NguoiDung nd, DiaChi dc){
        try{
            Connection conn = DBConnect.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO NGUOI_LIEN_QUAN(CMND, TEN, NAMSINH, TRANGTHAI,"
                    + " DUNO, NGLIENQUAN, BV) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, nd.getCMND());
            ps.setString(2, nd.getName());
            ps.setInt(3, nd.getYear());
            ps.setString(4, nd.getStatus());
            ps.setInt(5, nd.getDebt());
            ps.setString(6, nd.getLinkedPID());
            ps.setString(7, nd.getHospital());
            ps.executeUpdate();
            sql = "INSERT INTO LS_QUAN_LY(CMND, TRANGTHAI_MOI, TRANGTHAI_CU,DIADIEM_MOI, DIADIEM_CU) "
                    + "VALUES (?,?,?,?,?)";
            ps = conn.prepareCall(sql);
            ps.setString(1, nd.getCMND());
            ps.setString(2, nd.getStatus());
            ps.setString(3, "Ko");
            ps.setString(4, nd.getHospital());
            ps.setString(5, "Ko");
            ps.executeUpdate();
            sql = "UPDATE COQUAN SET SOLUONG = SOLUONG + 1 WHERE TEN =?";
            ps = conn.prepareCall(sql);
            ps.setString(1, nd.getHospital());
            ps.executeUpdate();
            sql = "INSERT INTO DIACHI(ID, DUONG, PHUONG, QUAN, TP) "
                    + "VALUES (?,?,?,?,?)";
            ps = conn.prepareCall(sql);
            ps.setString(1, nd.getCMND());
            ps.setString(2, dc.getDiaChi());
            ps.setString(3, dc.getPhuong());
            ps.setString(4, dc.getQuan());
            ps.setString(5, dc.getThanhPho());
            ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();
            return 1;
        }catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }
    }
    @Override
    public int updateNguoiDung(NguoiDung old, NguoiDung upd, DiaChi dc, int flag){
        // case update normal info only
        if (flag == 0){
            try{
                Connection conn = DBConnect.getConnection();
                conn.setAutoCommit(false);
                System.out.println("update normal info mode");
                System.out.println("update nglienquan");
                
                String sql = "UPDATE NGUOI_LIEN_QUAN SET TEN=?, NAMSINH=?,"
                    + " DUNO=?, NGLIENQUAN=? WHERE CMND=?";
                PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, upd.getName());
                ps.setInt(2, upd.getYear());
                ps.setInt(3, upd.getDebt());
                ps.setString(4, upd.getLinkedPID());
                ps.setString(5, upd.getCMND());
                ps.executeUpdate();
                System.out.println("update nglq done");
                System.out.println("update dia chi");
                sql = "UPDATE DIACHI SET DUONG=?, PHUONG=?, QUAN=?, TP=? WHERE ID = ? ";
                ps = conn.prepareCall(sql);
                ps.setString(1, dc.getDiaChi());
                ps.setString(2, dc.getPhuong());
                ps.setString(3, dc.getQuan());
                ps.setString(4, dc.getThanhPho());
                ps.setString(5, upd.getCMND());
                ps.executeUpdate();
                System.out.println("update dia chi done");
                conn.commit();
                ps.close();
                conn.close();
                return 1;
            }catch(SQLException ex){
                ex.printStackTrace();
                return 0;
            }
        }
        // case update normal info with hospital only
        else if (flag == 1){
            try{
                Connection conn = DBConnect.getConnection();
                conn.setAutoCommit(false);
                System.out.println("update hospital mode");
                System.out.println("update nglq");
                String sql = "UPDATE NGUOI_LIEN_QUAN SET TEN=?, NAMSINH=?,"
                    + " DUNO=?, NGLIENQUAN=?, BV=? WHERE CMND=?";
                PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, upd.getName());
                ps.setInt(2, upd.getYear());
                ps.setInt(3, upd.getDebt());
                ps.setString(4, upd.getLinkedPID());
                ps.setString(5, upd.getHospital());
                ps.setString(6, upd.getCMND());
                ps.executeUpdate();
                System.out.println("update nglq done");
                System.out.println("insert lsql");
                sql = "INSERT INTO LS_QUAN_LY(CMND, TRANGTHAI_MOI, TRANGTHAI_CU, DIADIEM_MOI, DIADIEM_CU) "
                    + "VALUES (?,?,?,?,?)";
                ps = conn.prepareCall(sql);
                ps.setString(1, upd.getCMND());
                ps.setString(2, upd.getStatus());
                ps.setString(3, old.getStatus());
                ps.setString(4, upd.getHospital());
                ps.setString(5, old.getHospital());
                ps.executeUpdate();
                System.out.println("insert lsql done");
                System.out.println("tăng soluong cua bv");
                sql = "UPDATE COQUAN SET SOLUONG = SOLUONG + 1 WHERE TEN =?";
                ps = conn.prepareCall(sql);
                ps.setString(1, upd.getHospital());
                ps.executeUpdate();
                System.out.println("tăng so luong done");
                System.out.println("giam soluong bv cũ");
                sql = "UPDATE COQUAN SET SOLUONG = SOLUONG - 1 WHERE TEN =?";
                ps = conn.prepareCall(sql);
                ps.setString(1, old.getHospital());
                ps.executeUpdate();
                sql = "UPDATE DIACHI SET DUONG=?, PHUONG=?, QUAN=?, TP=? WHERE ID = ? ";
                ps = conn.prepareCall(sql);
                ps.setString(1, dc.getDiaChi());
                ps.setString(2, dc.getPhuong());
                ps.setString(3, dc.getQuan());
                ps.setString(4, dc.getThanhPho());
                ps.setString(5, upd.getCMND());
                ps.executeUpdate();
                System.out.println("update dia chi done");
                conn.commit();
                ps.close();
                conn.close();
                return 1;
            }catch(SQLException ex){
                ex.printStackTrace();
                return 0;
            }
        }
        // case update normal info with hospital and status
        else{
            try{
                Connection conn = DBConnect.getConnection();
                conn.setAutoCommit(false);
                System.out.println("update status mode");
                System.out.println("update nglq");
                String sql = "UPDATE NGUOI_LIEN_QUAN SET TEN=?, NAMSINH=?,"
                    + " DUNO=?, NGLIENQUAN=?, BV=?, TRANGTHAI=? WHERE CMND=?";
                PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, upd.getName());
                ps.setInt(2, upd.getYear());
                ps.setInt(3, upd.getDebt());
                ps.setString(4, upd.getLinkedPID());
                ps.setString(5, upd.getHospital());
                ps.setString(6, upd.getStatus());
                ps.setString(7, upd.getCMND());
                int t = ps.executeUpdate();
                System.out.println(t);
                System.out.println("update nglq done");
                System.out.println("insert lsql");
                sql = "INSERT INTO LS_QUAN_LY(CMND, TRANGTHAI_MOI, TRANGTHAI_CU, DIADIEM_MOI, DIADIEM_CU) "
                    + "VALUES (?,?,?,?,?)";
                ps = conn.prepareCall(sql);
                ps.setString(1, upd.getCMND());
                ps.setString(2, upd.getStatus());
                ps.setString(3, old.getStatus());
                ps.setString(4, upd.getHospital());
                ps.setString(5, old.getHospital());
                ps.executeUpdate();
                System.out.println("insert lsql done");
                System.out.println("tăng soluong cua bv");
                sql = "UPDATE COQUAN SET SOLUONG = SOLUONG + 1 WHERE TEN =?";
                ps = conn.prepareCall(sql);
                ps.setString(1, upd.getHospital());
                ps.executeUpdate();
                System.out.println("tăng so luong done");
                System.out.println("giam soluong bv cũ");
                sql = "UPDATE COQUAN SET SOLUONG = SOLUONG - 1 WHERE TEN =?";
                ps = conn.prepareCall(sql);
                ps.setString(1, old.getHospital());
                ps.executeUpdate();
                System.out.println("giam soluong done");
                System.out.println("update diachi");
                sql = "UPDATE DIACHI SET DUONG=?, PHUONG=?, QUAN=?, TP=? WHERE ID = ? ";
                ps = conn.prepareCall(sql);
                ps.setString(1, dc.getDiaChi());
                ps.setString(2, dc.getPhuong());
                ps.setString(3, dc.getQuan());
                ps.setString(4, dc.getThanhPho());
                ps.setString(5, upd.getCMND());
                ps.executeUpdate();
                System.out.println("update dia chi done");
                conn.commit();
                ps.close();
                conn.close();
                System.out.println("update trang thai cua ng lq");
                List<NguoiDung> tmp = getRelateList(upd.getCMND());
                System.out.println("So ng lq: " +  tmp.size());
                String stat = increaseStatus(upd.getStatus());
                System.out.println(stat);
                for (NguoiDung nd : tmp ){
                    UpdateStatus(nd,stat);
                }
                return 1;
            }catch(SQLException ex){
                ex.printStackTrace();
                return 0;
            }
        }
        
    }
    
    
    
    public void UpdateStatus(NguoiDung tmp, String status){
        try{
            Connection conn = DBConnect.getConnection();
             // -------- Update status------------ \\
            System.out.println("update ng can cap nhat");
            String sql = "UPDATE NGUOI_LIEN_QUAN SET TRANGTHAI=? WHERE CMND=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, tmp.getCMND());
            System.out.println(status + " " +tmp.getCMND());
            int t = ps.executeUpdate();
            System.out.println(t);
            // ----------Insert record change log into db------------ \\
            System.out.println("update ls ng can cap nhat");
            sql = "INSERT INTO LS_QUAN_LY(CMND, TRANGTHAI_MOI, TRANGTHAI_CU, DIADIEM_MOI, DIADIEM_CU) "
                    + "VALUES (?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, tmp.getCMND());
            ps.setString(2, status);
            ps.setString(3, tmp.getStatus());
            ps.setString(4, tmp.getHospital());
            ps.setString(5, tmp.getHospital());
            ps.executeUpdate();
            //------------Get related patient list-------------\\
            System.out.println("get ng lq cua ng can cap nhat");
            List<NguoiDung> list = getRelateList(tmp.getCMND());
                System.out.println("So ng lq: " +  list.size());
                String stat = increaseStatus(status);
                System.out.println(stat);
                System.out.println(list);
                if(!list.isEmpty()) {
                    for (NguoiDung nd : list) {
                            System.out.println("Update ng lq cua ng lq");
                            UpdateStatus(nd, stat);
                    }
                }
//            conn.commit();
            ps.close();
            conn.close();
            return;
        }catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    private String increaseStatus(String stat){
        int tmp = Integer.parseInt(stat.substring(1)) + 1;
        return "F" + Integer.toString(tmp);
    }
    public List<String> getPhuong(){
         try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM PHUONG";
            List<String> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String tmp = rs.getString("TEN");
                list.add(tmp);
            }
            ps.close();
            rs.close();
            conn.close();
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<String> getQuan(){
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM QUAN";
            List<String> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String tmp = rs.getString("TEN");
                list.add(tmp);
            }
            ps.close();
            rs.close();
            conn.close();
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<String> getThanhPho(){
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM THANHPHO";
            List<String> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String tmp = rs.getString("TEN");
                list.add(tmp);
            }
            System.out.println(list);
            ps.close();
            rs.close();
            conn.close();
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String args[]){
        NguoiDungDAO a = new NguoiDungDAOImpl();
        System.out.println(a.getDiaChi("10000001"));
    }
}
