/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.service.ThongKeService;
import com.laq.quanlycovid.service.ThongKeServiceImpl;
import javax.swing.*;

/**
 *
 * @author Envy
 */
public class ThongKeController {
    private JLabel jlbEmergency;
    private JLabel jlbF0;
    private JLabel jlbF1;
    private JLabel jlbF2;
    private JLabel jlbF3;
    private JLabel jlbHealthy;
    private JLabel jlbMask;
    private ThongKeService thongKeService = null;
    public ThongKeController(JLabel jlbF0, JLabel jlbF1, JLabel jlbF2, JLabel jlbF3, JLabel jlbHealthy, JLabel jlbEmergency, JLabel jlbMask) {
        this.jlbEmergency = jlbEmergency;
        this.jlbF0 = jlbF0;
        this.jlbF1 = jlbF1;
        this.jlbF2 = jlbF2;
        this.jlbF3 = jlbF3;
        this.jlbHealthy = jlbHealthy;
        this.jlbMask = jlbMask;
        this.thongKeService = new ThongKeServiceImpl();
    }
    public void setView(){
        jlbF0.setText(jlbF0.getText() + ": " +thongKeService.getNumF0());
        jlbF1.setText(jlbF1.getText() + ": " +thongKeService.getNumF1());
        jlbF2.setText(jlbF2.getText() + ": " +thongKeService.getNumF2());
        jlbF3.setText(jlbF3.getText() + ": " +thongKeService.getNumF3());
        jlbHealthy.setText(jlbHealthy.getText() + ": " +thongKeService.getNumNormal());
        jlbMask.setText(jlbMask.getText() + ": " +thongKeService.getNumQuarantine());
        jlbEmergency.setText(jlbEmergency.getText() + ": " +thongKeService.getNumInfected());
    }
}
