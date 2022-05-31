/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

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
public class SanPhamController {
    private JPanel jpnTable;
    private JButton jbtAdd;
    private JTextField jtfSearch;
    
    private SanPhamService sps = null;
    private String[] listColumn = {"ID Sản Phẩm", "Tên Sản Phẩm", "Đơn Giá", "Đơn Vị Tính", "Hình Ảnh"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public SanPhamController(JPanel jpnTable, JButton jbtAdd, JTextField jtfSearch){
        this.jpnTable = jpnTable;
        this.jbtAdd = jbtAdd;   
        this.jtfSearch = jtfSearch;
        this.sps = new SanPhamServiceImpl();
    }
    
    public void setDataToTable(){
        List<SanPham> list;
        list = sps.getList();
        DefaultTableModel model = new ClassTableModel().setTableSanPham(list, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText(); 
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText(); 
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }               
        });
        
     table.addMouseListener(new MouseAdapter(){
         @Override
         public void mouseClicked(MouseEvent e){
             if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                 DefaultTableModel model = (DefaultTableModel)table.getModel();
                 int selectedRowIndex = table.getSelectedRow();
                 //selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                 System.out.println(selectedRowIndex);
                 
                 SanPham sp = new SanPham();
                 
                 sp.setIDSP(model.getValueAt(selectedRowIndex, 0).toString());
                 sp.setTenSP(model.getValueAt(selectedRowIndex, 1).toString());
                 sp.setDonGiaSP((int)model.getValueAt(selectedRowIndex, 2));
                 sp.setDvTinh(model.getValueAt(selectedRowIndex, 3).toString());
                 sp.setHinhAnh(model.getValueAt(selectedRowIndex, 4).toString());
                 System.out.println(sp);
                 
                 ModifyProduct frame = new ModifyProduct(sp);
                 frame.setTitle("Thông Tin Sản Phẩm");
                 frame.setResizable(false);
                 frame.setLocationRelativeTo(null);
                 frame.setVisible(true);
             }
         }
     });
     
     table.getTableHeader().setFont(new Font("Arial", Font.BOLD,14));
     table.getTableHeader().setPreferredSize(new Dimension(100,50));
     table.setRowHeight(50);
     table.validate();
     table.repaint();
     
     JScrollPane scrollpane = new JScrollPane();
     scrollpane.getViewport().add(table);
     scrollpane.setPreferredSize(new Dimension(1400, 400));
     
     jpnTable.removeAll();
     jpnTable.setLayout(new CardLayout());
     jpnTable.add(scrollpane);
     jpnTable.validate();
     jpnTable.repaint();
    }
    public void setEvent(){
        jbtAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                AddProduct frame = new AddProduct(new SanPham());
                frame.setTitle("Thêm Sản Phẩm");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }   
            @Override
            public void mouseEntered (MouseEvent e){
                jbtAdd.setBackground(new Color (118,159,205));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                jbtAdd.setBackground(new Color (185,215,234));
            }
        });
    }
}

        
