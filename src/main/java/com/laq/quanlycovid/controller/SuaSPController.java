/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.dao.SanPhamDAO;
import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.model.SanPham;
import com.laq.quanlycovid.service.SanPhamService;
import com.laq.quanlycovid.service.SanPhamServiceImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 *
 * @author Hoàng Lân
 */
public class SuaSPController {
    private JButton xoa;
    private JButton sua;
    private JButton huy;
    private JTextField ID;
    private JTextField ten;
    private JTextField dongia;
    private JTextField dvtinh;
    private JTextField hinhanh;
    private SanPham sp;
    private SanPhamService sanPhamService = null;

    public SuaSPController(JButton xoa, JButton sua, JButton huy, JTextField ID, JTextField ten, JTextField dongia, JTextField dvtinh, JTextField hinhanh) {
        this.xoa = xoa;
        this.sua = sua;
        this.huy = huy;
        this.ID = ID;
        this.ten = ten;
        this.dongia = dongia;
        this.dvtinh = dvtinh;
        this.hinhanh = hinhanh;
        sanPhamService = new SanPhamServiceImpl();
    }
     
    public void setView(SanPham sp){
        this.sp = sp;
        if(sp.getIdSP() != null){
            ID.setEditable(false);
        }
        ID.setText(sp.getIdSP());
        ten.setText(sp.getTenSP());
        dongia.setText(Integer.toString(sp.getDonGiaSP()));
        dvtinh.setText(sp.getDvTinh());
        hinhanh.setText(sp.getHinhAnh());             
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
                if (dvtinh.getText().length() == 0 )
                    filled = false;
                if (hinhanh.getText().length() == 0)
                    filled = false;
                if (!filled){
                    JOptionPane.showMessageDialog(null,"Xin nhập đầy đủ các trường");
                }
                else{
                    if (ID.isEditable()){
                        sp.setIDSP(ID.getText());
                        sp.setTenSP(ten.getText());
                        sp.setDonGiaSP(Integer.parseInt(dongia.getText()));
                        sp.setDvTinh(dvtinh.getText());
                        sp.setHinhAnh(hinhanh.getText());
                        if(showDialog()){
                            int res = sanPhamService.insert(sp);
                            if(res != 0){
                                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                            }
                            int res1 = sanPhamService.delete(ID.getText());
                            if(res1 != 0){
                                JOptionPane.showMessageDialog(null, "Xóa thành công");
                            }
                        }
                        }                    
                    else{
                        SanPham sp = new SanPham();
                        sp.setIDSP(ID.getText());
                        sp.setTenSP(ten.getText());
                        sp.setDonGiaSP(Integer.parseInt(dongia.getText()));
                        sp.setDvTinh(dvtinh.getText());
                        sp.setHinhAnh(hinhanh.getText());
                        if(showDialog()){
                            int res = sanPhamService.update(sp);
                            if(res != 0){
                                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                            }
                            int res1 = sanPhamService.delete(ID.getText());
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
                if (dvtinh.getText().length() == 0 )
                    filled = false;
                if (hinhanh.getText().length() == 0)
                    filled = false;
                if (!filled){
                    JOptionPane.showMessageDialog(null,"Xin nhập đầy đủ các trường");
                }
                else{
                    if (ID.isEditable()){
                        sp.setIDSP(ID.getText());
                        sp.setTenSP(ten.getText());
                        sp.setDonGiaSP(Integer.parseInt(dongia.getText()));
                        sp.setDvTinh(dvtinh.getText());
                        sp.setHinhAnh(hinhanh.getText());
                        if(showDialog()){
//                            int res = sanPhamService.insert(sp);
//                            if(res != 0){
//                                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//                            }
                            int res1 = sanPhamService.delete(ID.getText());
                            if(res1 != 0){
                                JOptionPane.showMessageDialog(null, "Xóa thành công");
                            }
                        }
                        }                    
                    else{
                        SanPham sp = new SanPham();
                        sp.setIDSP(ID.getText());
                        sp.setTenSP(ten.getText());
                        sp.setDonGiaSP(Integer.parseInt(dongia.getText()));
                        sp.setDvTinh(dvtinh.getText());
                        sp.setHinhAnh(hinhanh.getText());
                        if(showDialog()){
//                            int res = sanPhamService.update(sp);
//                            if(res != 0){
//                                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//                            }
                            int res1 = sanPhamService.delete(ID.getText());
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
