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
public class SuaGSPController {
    private JButton xoa;
    private JButton sua;
    private JButton huy;
    private JTextField ID;
    private JTextField ten;
    private JTextField dongia;
    private JTextField gioihan;
    private JTextField thoigian;
    private GoiSanPham gsp;
    private GoiNhuYeuPhamService goiNhuYeuPhamService = null;

    public SuaGSPController(JButton xoa, JButton sua, JButton huy, JTextField ID, JTextField ten, JTextField dongia, JTextField gioihan, JTextField thoigian) {
        this.xoa = xoa;
        this.sua = sua;
        this.huy = huy;
        this.ID = ID;
        this.ten = ten;
        this.dongia = dongia;
        this.gioihan = gioihan;
        this.thoigian = thoigian;
        goiNhuYeuPhamService = new GoiNhuYeuPhamServiceIpml();
    }
     
    public void setView(GoiSanPham gsp){
        this.gsp = gsp;
        if(gsp.getIdGoi()!= null){
            ID.setEditable(false);
        }
        ID.setText(gsp.getIdGoi());
        ten.setText(gsp.getTenGoi());
        dongia.setText(Integer.toString(gsp.getDonGia()));
        gioihan.setText(Integer.toString(gsp.getMucGioiHan()));
        thoigian.setText(gsp.getTgGioiHan());             
    }

    public void setEvent(){
        sua.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                boolean filled = true;
                if (ID.getText().length() == 0)
                    filled = false;
                if (ten.getText().length() == 0 )
                    filled = false;
                if (dongia.getText().length() == 0)
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
                        gsp.setDonGia(Integer.parseInt(dongia.getText()));
                        gsp.setMucGioiHan(Integer.parseInt(gioihan.getText()));
                        gsp.setTgGioiHan(thoigian.getText());
                        if(showDialog()){
                            int res = goiNhuYeuPhamService.insert(gsp);
                            if(res != 0){
                                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                            }
                            int res1 = goiNhuYeuPhamService.delete(ID.getText());
                            if(res1 != 0){
                                JOptionPane.showMessageDialog(null, "Xóa thành công");
                            }
                        }
                        }                    
                    else{
                        GoiSanPham gsp = new GoiSanPham();
                        gsp.setIdGoi(ID.getText());
                        gsp.setTenGoi(ten.getText());
                        gsp.setDonGia(Integer.parseInt(dongia.getText()));
                        gsp.setMucGioiHan(Integer.parseInt(gioihan.getText()));
                        gsp.setTgGioiHan(thoigian .getText());
                        if(showDialog()){
                            int res = goiNhuYeuPhamService.update(gsp);
                            if(res != 0){
                                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                            }
                            int res1 = goiNhuYeuPhamService.delete(ID.getText());
                            if(res1 != 0){
                                JOptionPane.showMessageDialog(null, "Xóa thành công");
                            }
                        }
                    }
                }
            }
                
            @Override
            public void mouseEntered (MouseEvent e){
                sua.setBackground(new Color (185,215,234));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                sua.setBackground(new Color (214,230,242));
            }
        });
        
        xoa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                boolean filled = true;
                if (ID.getText().length() == 0)
                    filled = false;
                if (ten.getText().length() == 0 )
                    filled = false;
                if (dongia.getText().length() == 0)
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
                        gsp.setDonGia(Integer.parseInt(dongia.getText()));
                        gsp.setMucGioiHan(Integer.parseInt(gioihan.getText()));
                        gsp.setTgGioiHan(thoigian.getText());
                        if(showDialog()){
//                            int res = sanPhamService.insert(sp);
//                            if(res != 0){
//                                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//                            }
                            int res1 = goiNhuYeuPhamService.delete(ID.getText());
                            if(res1 != 0){
                                JOptionPane.showMessageDialog(null, "Xóa thành công");
                            }
                        }
                        }                    
                    else{
                        GoiSanPham sp = new GoiSanPham();
                        gsp.setIdGoi(ID.getText());
                        gsp.setTenGoi(ten.getText());
                        gsp.setDonGia(Integer.parseInt(dongia.getText()));
                        gsp.setMucGioiHan(Integer.parseInt(gioihan.getText()));
                        gsp.setTgGioiHan(thoigian.getText());
                        if(showDialog()){
//                            int res = sanPhamService.update(sp);
//                            if(res != 0){
//                                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//                            }
                            int res1 = goiNhuYeuPhamService.delete(ID.getText());
                            if(res1 != 0){
                                JOptionPane.showMessageDialog(null, "Xóa thành công");
                            }
                        }
                    }
                }
            }
                
            @Override
            public void mouseEntered (MouseEvent e){
                xoa.setBackground(new Color (185,215,234));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                xoa.setBackground(new Color (214,230,242));
            }
        });        
    }
    
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn thêm/cập nhật/xóa dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }    
}
