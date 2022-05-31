/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;

import com.laq.quanlycovid.dao.NoiDieuTriDAO;
import com.laq.quanlycovid.dao.NoiDieuTriDAOImpl;
import com.laq.quanlycovid.model.NoiDieuTri;
import java.util.List;

/**
 *
 * @author Envy
 */
public class NoiDieuTriServiceImpl implements NoiDieuTriService {
    private NoiDieuTriDAO noiDieuTriDAO = null;
    public NoiDieuTriServiceImpl(){
        noiDieuTriDAO = new NoiDieuTriDAOImpl();
    }
    @Override
    public List<NoiDieuTri> getList() {
        return noiDieuTriDAO.getList();
    }
}
