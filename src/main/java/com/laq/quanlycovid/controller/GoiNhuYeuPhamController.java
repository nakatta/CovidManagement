/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.model.GoiSanPham;
import com.laq.quanlycovid.service.GoiNhuYeuPhamService;
import com.laq.quanlycovid.service.GoiNhuYeuPhamServiceIpml;
import com.laq.quanlycovid.utility.ClassTableModel;
import com.laq.quanlycovid.view.AddPackage;
import com.laq.quanlycovid.view.ModifyPackage;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hoàng Lân
 */
public class GoiNhuYeuPhamController {
    private JPanel jpnTable;
    private JButton jbtAdd;
    private JTextField jtfSearch;
    
    private GoiNhuYeuPhamService sps = null;
    private String[] listColumn = {"ID Gói", "Tên Gói", "Đơn Giá", "Giới Hạn/Người", "Thời Gian"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public GoiNhuYeuPhamController(JPanel jpnTable, JButton jbtAdd, JTextField jtfSearch){
        this.jpnTable = jpnTable;
        this.jbtAdd = jbtAdd;   
        this.jtfSearch = jtfSearch;
        this.sps = new GoiNhuYeuPhamServiceIpml();
    }
    
    public void setDataToTable(){
        List<GoiSanPham> list;
        list = sps.getList();
        DefaultTableModel model = new ClassTableModel().setTableGoiSanPham(list, listColumn);
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
                 
                 GoiSanPham gsp = new GoiSanPham();
                 
                 gsp.setIdGoi(model.getValueAt(selectedRowIndex, 0).toString());
                 gsp.setTenGoi(model.getValueAt(selectedRowIndex, 1).toString());
                 gsp.setDonGia((int)model.getValueAt(selectedRowIndex, 2));
                 gsp.setMucGioiHan((int)model.getValueAt(selectedRowIndex, 3));
                 gsp.setTgGioiHan(model.getValueAt(selectedRowIndex, 4).toString());
                 System.out.println(gsp);
                 
                 ModifyPackage frame = new ModifyPackage(gsp);
                 frame.setTitle("Thông Tin Gói Sản Phẩm");
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
                AddPackage frame = new AddPackage(new GoiSanPham());
                frame.setTitle("Thêm Gói Sản Phẩm");
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
