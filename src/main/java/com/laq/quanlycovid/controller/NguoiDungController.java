/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.model.DiaChi;
import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.model.NoiDieuTri;
import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import com.laq.quanlycovid.service.NoiDieuTriService;
import com.laq.quanlycovid.service.NoiDieuTriServiceImpl;
import com.laq.quanlycovid.utility.ClassTableModel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Envy
 */
public class NguoiDungController {
    private JButton btnSubmit;
    private JTextField jtfCMND;
    private JTextField jtfHoTen;
    private JTextField jtfYear;
    private JTextField jtfNgLienQuan;
    private JTextField jtfNo;
    private JComboBox jcbTrangThai;
    private JComboBox jcbBenhVien;
    private JTable jtbNgLQ;
    private JTextField jtfDiaChi;
    private JComboBox jcbPhuong;
    private JComboBox jcbQuan;
    private JComboBox jcbTP;
    private JLabel jlbMsg;
    private NguoiDung nguoiDung;
    private DiaChi dc;
    private NguoiDungService nguoiDungService = null;
    private NoiDieuTriService noiDieuTriService = null;

    public NguoiDungController(JButton btnSubmit, JTextField jtfCMND, JTextField jtfHoTen,
            JTextField jtfYear, JTextField jtfNgLienQuan, JTextField jtfNo, JComboBox jcbTrangThai,
            JComboBox jcbBenhVien, JTable jtbNgLQ, JTextField jtfDiaChi, JComboBox jcbPhuong, JComboBox jcbQuan,
            JComboBox jcbTP, JLabel jlbMsg){
        this.btnSubmit = btnSubmit;
        this.jtfCMND = jtfCMND;
        this.jtfHoTen = jtfHoTen;
        this.jtfYear = jtfYear;
        this.jtfNgLienQuan = jtfNgLienQuan;
        this.jtfNo = jtfNo;
        this.jcbTrangThai = jcbTrangThai;
        this.jcbBenhVien = jcbBenhVien;
        this.jtbNgLQ = jtbNgLQ;
        this.jtfDiaChi = jtfDiaChi;
        this.jcbPhuong = jcbPhuong;
        this.jcbQuan = jcbQuan;
        this.jcbTP = jcbTP;
        this.jlbMsg = jlbMsg;
        this.nguoiDungService = new NguoiDungServiceImpl();
        this.noiDieuTriService = new NoiDieuTriServiceImpl();
    }
    
    public void setView(NguoiDung nguoiDung){
        this.nguoiDung = nguoiDung;
        if (nguoiDung.getCMND() != null){
            jtfCMND.setEditable(false);
        }
        jtfCMND.setText(nguoiDung.getCMND());
        jtfHoTen.setText(nguoiDung.getName());
        jtfYear.setText(Integer.toString(nguoiDung.getYear()));
        jtfNgLienQuan.setText(nguoiDung.getLinkedPID());
        jtfNo.setText(Integer.toString(nguoiDung.getDebt()));
        jcbTrangThai.removeAllItems();
        String[] listTT = {"F0", "F1", "F2", "F3"};
        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel(listTT));
        jcbTrangThai.setSelectedItem(nguoiDung.getStatus());
        jcbBenhVien.removeAllItems();
        List<NoiDieuTri> listBV = noiDieuTriService.getList();
        for(NoiDieuTri tmp : listBV){
            jcbBenhVien.addItem(tmp.getTen());
        }
        jcbBenhVien.setMaximumRowCount(6);
        jcbBenhVien.setSelectedItem(nguoiDung.getHospital());
        List<NguoiDung> listLQ = nguoiDungService.getRelateList(nguoiDung.getCMND());
        DefaultTableModel model = (DefaultTableModel) jtbNgLQ.getModel();
        for(NguoiDung a : listLQ){
            model.addRow(new Object[]{a.getCMND(), a.getName(), a.getYear()});
        }
        dc = nguoiDungService.getDiaChi(nguoiDung.getCMND());
        jtfDiaChi.setText(dc.getDiaChi());
        jcbPhuong.removeAllItems();
        List<String> listPhuong = nguoiDungService.getPhuong();
        for(String p : listPhuong){
            jcbPhuong.addItem(p);
        }
        jcbPhuong.setMaximumRowCount(5);
        jcbPhuong.setSelectedItem(dc.getPhuong());
        jcbQuan.removeAllItems();
        List<String> listQuan = nguoiDungService.getQuan();
        for(String q : listQuan){
            jcbQuan.addItem(q);
        }
        jcbQuan.setMaximumRowCount(5);
        jcbQuan.setSelectedItem(dc.getQuan());
        jcbTP.removeAllItems();
        List<String> listTP = nguoiDungService.getThanhPho();
        for(String tp : listTP){
            jcbTP.addItem(tp);
        }
        jcbTP.setMaximumRowCount(5);
        jcbTP.setSelectedItem(dc.getThanhPho());
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                boolean filled = true;
                if (jtfCMND.getText().length() == 0)
                    filled = false;
                if (jtfHoTen.getText().length() == 0 )
                    filled = false;
                if (jtfYear.getText().length() == 0)
                    filled = false;
                if (jtfNgLienQuan.getText().length() == 0 )
                    filled = false;
                if (jtfNo.getText().length() == 0)
                    filled = false;
                if (jtfDiaChi.getText().length() == 0)
                    filled = false;
                if (jcbPhuong.getSelectedItem() == null)
                    filled = false;
                if (jcbQuan.getSelectedItem() == null)
                    filled = false;   
                if (jcbTP.getSelectedItem() == null)
                    filled = false;
                if ( jcbTrangThai.getSelectedItem() == null)
                    filled = false;
                if (jcbBenhVien .getSelectedItem() == null)
                    filled = false;
                if (!filled){
                    jlbMsg.setText("Xin nhập đầy đủ các trường, nếu không có người liên quan điền 0");
                }
                else{
                    if (jtfCMND.isEditable()){
                        nguoiDung.setCMND(jtfCMND.getText());
                        nguoiDung.setName(jtfHoTen.getText());
                        nguoiDung.setYear(Integer.parseInt(jtfYear.getText()));
                        nguoiDung.setLinkedPID(jtfNgLienQuan.getText());
                        nguoiDung.setDebt(Integer.parseInt(jtfNo.getText()));
                        nguoiDung.setStatus(jcbTrangThai.getSelectedItem().toString());
                        nguoiDung.setHospital(jcbBenhVien.getSelectedItem().toString());
                        dc.setDiaChi(jtfDiaChi.getText());
                        dc.setPhuong(jcbPhuong.getSelectedItem().toString());
                        dc.setQuan(jcbQuan.getSelectedItem().toString());
                        dc.setThanhPho(jcbTP.getSelectedItem().toString());
                        if(showDialog()){
                            int res = nguoiDungService.createNguoiDung(nguoiDung, dc);
                            if(res != 0){
                                jlbMsg.setText("Xử lý thêm dữ liệu thành công!");
                            }
                            else
                                jlbMsg.setText("Đã có lỗi xảy ra, xin hãy thử lại!");
                        }
                    }
                    else{
                        NguoiDung tmp = new NguoiDung();
                        tmp.setCMND(jtfCMND.getText());
                        tmp.setName(jtfHoTen.getText());
                        tmp.setYear(Integer.parseInt(jtfYear.getText()));
                        tmp.setLinkedPID(jtfNgLienQuan.getText());
                        tmp.setDebt(Integer.parseInt(jtfNo.getText()));
                        tmp.setStatus(jcbTrangThai.getSelectedItem().toString());
                        tmp.setHospital(jcbBenhVien.getSelectedItem().toString());
                        dc.setDiaChi(jtfDiaChi.getText());
                        dc.setPhuong(jcbPhuong.getSelectedItem().toString());
                        dc.setQuan(jcbQuan.getSelectedItem().toString());
                        dc.setThanhPho(jcbTP.getSelectedItem().toString());
                        if(!tmp.getStatus().equals(nguoiDung.getStatus())){
                             if(showDialog()){
                                int res = nguoiDungService.updateNguoiDung(nguoiDung, tmp, dc, 2);
                                if(res != 0){
                                    jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                                }
                                else
                                    jlbMsg.setText("Đã có lỗi xảy ra, xin hãy thử lại!");
                            }
                        }
                        else if (!tmp.getHospital().equals(nguoiDung.getHospital())){
                            if(showDialog()){
                                int res = nguoiDungService.updateNguoiDung(nguoiDung, tmp, dc, 1);
                                if(res != 0){
                                    jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                                }
                                else
                                    jlbMsg.setText("Đã có lỗi xảy ra, xin hãy thử lại!");
                            }
                        }
                        else{
                            if(showDialog()){
                                int res = nguoiDungService.updateNguoiDung(nguoiDung, tmp, dc, 0);
                                if(res != 0){
                                    jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                                }
                                else
                                    jlbMsg.setText("Đã có lỗi xảy ra, xin hãy thử lại!");
                            }
                        }
                    }
                }
            }
            @Override
            public void mouseEntered (MouseEvent e){
                btnSubmit.setBackground(new Color (185,215,234));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                btnSubmit.setBackground(new Color (214,230,242));
            }
        });
    }
    
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn thêm/cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
