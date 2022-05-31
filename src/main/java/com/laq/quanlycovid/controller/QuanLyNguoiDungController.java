/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import com.laq.quanlycovid.utility.ClassTableModel;
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
 * @author Envy
 */
public class QuanLyNguoiDungController {    
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private NguoiDungService nguoiDungService = null;
    private String[] listColumn= {"CMND","Họ và Tên","Năm Sinh","Trạng Thái","Bệnh viện","Người liên quan","Nợ"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLyNguoiDungController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch){
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.nguoiDungService = new NguoiDungServiceImpl();
    }
    
    public void setDataToTable(){
        ArrayList<NguoiDung> listItem;
        listItem = nguoiDungService.getList();
        DefaultTableModel model = new ClassTableModel().setTableNguoiDung(listItem, listColumn);
        JTable table= new JTable(model);
        
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
                 
                 NguoiDung nguoiDung = new NguoiDung();
                 
                 nguoiDung.setCMND(model.getValueAt(selectedRowIndex, 0).toString());
                 nguoiDung.setName(model.getValueAt(selectedRowIndex, 1).toString());
                 nguoiDung.setYear((int)model.getValueAt(selectedRowIndex, 2));
                 nguoiDung.setStatus(model.getValueAt(selectedRowIndex, 3).toString());
                 nguoiDung.setHospital(model.getValueAt(selectedRowIndex, 4).toString());
                 nguoiDung.setLinkedPID(model.getValueAt(selectedRowIndex, 5).toString());
                 nguoiDung.setDebt((int)model.getValueAt(selectedRowIndex, 6));
                 System.out.println(nguoiDung);
                 
                 NguoiDungJFrame frame = new NguoiDungJFrame(nguoiDung);
                 frame.setTitle("Thông Tin Người Dùng");
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
     
     jpnView.removeAll();
     jpnView.setLayout(new CardLayout());
     jpnView.add(scrollpane);
     jpnView.validate();
     jpnView.repaint();
    }
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                NguoiDungJFrame frame = new NguoiDungJFrame(new NguoiDung());
                frame.setTitle("Thêm người");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            @Override
            public void mouseEntered (MouseEvent e){
                btnAdd.setBackground(new Color (118,159,205));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                btnAdd.setBackground(new Color (185,215,234));
            }
        });
    }
}
