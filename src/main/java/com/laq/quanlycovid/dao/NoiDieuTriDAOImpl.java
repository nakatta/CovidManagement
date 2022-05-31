/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.NoiDieuTri;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Envy
 */
public class NoiDieuTriDAOImpl implements NoiDieuTriDAO {
    @Override
    public List<NoiDieuTri> getList() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM COQUAN WHERE SOLUONG < SUCCHUA";
            List<NoiDieuTri> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NoiDieuTri tmp = new NoiDieuTri();
                tmp.setTen(rs.getString("TEN"));
                tmp.setSucChua(rs.getInt("SUCCHUA"));
                tmp.setSoLuongHienTai(rs.getInt("SOLUONG"));
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
    public static void main(String args[]){
        NoiDieuTriDAO a = new NoiDieuTriDAOImpl();
        System.out.println(a.getList());
    }
}
