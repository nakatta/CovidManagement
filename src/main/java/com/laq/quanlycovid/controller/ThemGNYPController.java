/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.model.GoiSanPham;
import com.laq.quanlycovid.service.GoiNhuYeuPhamService;
import com.laq.quanlycovid.service.GoiNhuYeuPhamServiceIpml;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Hoàng Lân
 */
public class ThemGNYPController {
    private JTextField ID;
    private JTextField ten;
    private JTextField donGia;
    private JTextField gioihan;
    private JTextField thoigian;
    private JButton them;
    private JButton huy;
    private GoiSanPham gsp;
    private GoiNhuYeuPhamService goiNhuYeuPhamService = null;
    
    public ThemGNYPController(JButton them, JButton huy, JTextField ID, JTextField ten, JTextField donGia, JTextField gioihan, JTextField thoigian){
        this.them = them;
        this.huy = huy;
        this.ten = ten;
        this.donGia = donGia;
        this.gioihan = gioihan;
        this.thoigian = thoigian;
        this.goiNhuYeuPhamService = new GoiNhuYeuPhamServiceIpml();
    }
    
    
    public void setView(GoiSanPham gsp){
        this.gsp = gsp;
//        if(sp.getIdSP() != null){
//            ID.setEditable(false);
//        }
//        ID.setText(sp.getIdSP());
        ten.setText(gsp.getTenGoi());
        donGia.setText(Integer.toString(gsp.getDonGia()));
        gioihan.setText(Integer.toString(gsp.getMucGioiHan()));
        thoigian.setText(gsp.getTgGioiHan());           
    
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
                if (gioihan.getText().length() == 0 )
                    filled = false;
                if (thoigian.getText().length() == 0)
                    filled = false;
                if (!filled){
                    JOptionPane.showMessageDialog(null,"Xin nhập đầy đủ các trường");
                }
                else{
                    if (ID.isEditable()){
                        gsp.setIdGoi(ID.getText());
                        gsp.setTenGoi(ten.getText());
                        gsp.setDonGia(Integer.parseInt(donGia.getText()));
                        gsp.setMucGioiHan(Integer.parseInt(gioihan.getText()));
                        gsp.setTgGioiHan(thoigian.getText());
                        if(showDialog()){
                            int res = goiNhuYeuPhamService.insert(gsp);
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
