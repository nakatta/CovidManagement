/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.GoiSanPham;
import java.util.List;

/**
 *
 * @author Hoàng Lân
 */
public interface GoiNhuYeuPhamDAO {
    public List<GoiSanPham> getList();
    public int insert(GoiSanPham gsp);
    public int update(GoiSanPham sp);
    public int delete(String idSP);
}
