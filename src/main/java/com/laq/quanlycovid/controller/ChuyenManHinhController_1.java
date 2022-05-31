/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import java.awt.*;
import javax.swing.*;
import com.laq.quanlycovid.view.TrangChuJPanel;
import com.laq.quanlycovid.bean.DanhMucBean;
import com.laq.quanlycovid.view.LichSuQuanLyJPanel;
import com.laq.quanlycovid.view.ProductsJPanel;
import com.laq.quanlycovid.view.StatisticJPanel;
import com.laq.quanlycovid.view.TrangChuJPanel_1;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
/**
 *
 * @author Envy
 */
public class ChuyenManHinhController_1 {
    private JPanel root;
    private String selected ="";
    private List<DanhMucBean> listItem;
    
    public ChuyenManHinhController_1(JPanel root){
        this.root = root;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem){
        selected = "TrangChu";
        jpnItem.setBackground(new Color(247, 251, 252));
        jlbItem.setBackground(new Color(247, 251, 252));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel_1());
        root.validate();
        root.repaint();
        
    }
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        for (DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "TrangChu":
                    node = new TrangChuJPanel_1();
                    break;
                case "LichSuQL":
                    node = new LichSuQuanLyJPanel();
                    break;
                case "ThongKe":
                    node = new StatisticJPanel();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            selected = kind;
            jpnItem.setBackground(new Color(247,251,252));
            jlbItem.setBackground(new Color(247,251,252));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(247,251,252));
            jlbItem.setBackground(new Color(247,251,252));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!selected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(214,230,242));
                jlbItem.setBackground(new Color(214,230,242));
            }
        }
    }
    
    private void setChangeBackground(String kind){
        for (DanhMucBean item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(247,251,252));
                item.getJlb().setBackground(new Color(247,251,252));
            }
            else{
                item.getJpn().setBackground(new Color(214,230,242));
                item.getJlb().setBackground(new Color(214,230,242));
            }
        }
    }
  
}


