/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;

import com.laq.quanlycovid.dao.ThongKeDAO;
import com.laq.quanlycovid.dao.ThongKeDAOImpl;

/**
 *
 * @author Envy
 */
public class ThongKeServiceImpl implements ThongKeService {
    private ThongKeDAO thongKeDAO = null;
    public ThongKeServiceImpl(){
        thongKeDAO = new ThongKeDAOImpl();
    }
    @Override
    public int getNumF0() {
        return thongKeDAO.getNumF0();
    }

    @Override
    public int getNumF1() {
        return thongKeDAO.getNumF1();
    }

    @Override
    public int getNumF2() {
        return thongKeDAO.getNumF2();
    }

    @Override
    public int getNumF3() {
        return thongKeDAO.getNumF3();
    }

    @Override
    public int getNumNormal() {
        return thongKeDAO.getNumNormal();
    }

    @Override
    public int getNumInfected() {
        return thongKeDAO.getNumInfected();
    }

    @Override
    public int getNumQuarantine() {
        return thongKeDAO.getNumQuarantine();
    }
    
}
