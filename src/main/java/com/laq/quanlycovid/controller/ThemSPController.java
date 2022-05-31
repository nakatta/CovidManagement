/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.view.AddProduct;

import com.laq.quanlycovid.model.SanPham;
import com.laq.quanlycovid.service.SanPhamService;
import com.laq.quanlycovid.service.SanPhamServiceImpl;
import com.laq.quanlycovid.utility.ClassTableModel;
import com.laq.quanlycovid.view.AddProduct;
import com.laq.quanlycovid.view.ModifyProduct;
import com.laq.quanlycovid.view.NguoiDungJFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hoàng Lân
 */
public class ThemSPController {
    private JTextField ID;
    private JTextField ten;
    private JTextField donGia;
    private JTextField dvTinh;
    private JTextField hinhAnh;
    private JButton them;
    private JButton huy;
    private SanPham sp;
    private SanPhamService sanPhamService = null;
    
    public ThemSPController(JButton them, JButton huy, JTextField ID, JTextField ten, JTextField donGia, JTextField dvTinh, JTextField hinhAnh){
        this.them = them;
        this.huy = huy;
        this.ten = ten;
        this.donGia = donGia;
        this.dvTinh = dvTinh;
        this.hinhAnh = hinhAnh;
        this.sanPhamService = new SanPhamServiceImpl();
    }
    
    
    public void setView(SanPham sp){
        this.sp = sp;
//        if(sp.getIdSP() != null){
//            ID.setEditable(false);
//        }
//        ID.setText(sp.getIdSP());
        ten.setText(sp.getTenSP());
        donGia.setText(Integer.toString(sp.getDonGiaSP()));
        dvTinh.setText(sp.getDvTinh());
        hinhAnh.setText(sp.getHinhAnh());             
    
    }

    public void setEvent(){
        them.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                boolean filled = true;
                if (ID.getText().length() == 0)
                    filled = false;
                if (ten.getText().length() == 0 )
                    filled = false;
                if (donGia.getText().length() == 0)
                    filled = false;
                if (dvTinh.getText().length() == 0 )
                    filled = false;
                if (hinhAnh.getText().length() == 0)
                    filled = false;
                if (!filled){
                    JOptionPane.showMessageDialog(null,"Xin nhập đầy đủ các trường");
                }
                else{
                    if (ID.isEditable()){
                        sp.setIDSP(ID.getText());
                        sp.setTenSP(ten.getText());
                        sp.setDonGiaSP(Integer.parseInt(donGia.getText()));
                        sp.setDvTinh(dvTinh.getText());
                        sp.setHinhAnh(hinhAnh.getText());
                        if(showDialog()){
                            int res = sanPhamService.insert(sp);
                            if(res != 0){
                                JOptionPane.showMessageDialog(null, "Thêm thành công");
                            }
                        }
                    }
                }
            }
            
            @Override
            public void mouseEntered (MouseEvent e){
                them.setBackground(new Color (185,215,234));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                them.setBackground(new Color (214,230,242));
            }
        });
    }
        
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn thêm dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }                   
}
