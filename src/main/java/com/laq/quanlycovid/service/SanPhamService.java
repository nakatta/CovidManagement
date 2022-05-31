/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.laq.quanlycovid.service;

import com.laq.quanlycovid.model.SanPham;
import java.util.List;

/**
 *
 * @author Hoàng Lân
 */
public interface SanPhamService {
    public List<SanPham> getList();
    public int insert(SanPham sp);
    public int update(SanPham sp);

    public int delete(String IdSP);
    

}
