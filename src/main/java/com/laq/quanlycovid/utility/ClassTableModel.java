
package com.laq.quanlycovid.utility;

import com.laq.quanlycovid.model.GoiSanPham;
import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.model.SanPham;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Envy
 */
public class ClassTableModel {
    public DefaultTableModel setTableNguoiDung(List<NguoiDung> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        System.out.println("So Dòng " + rows);
        if (rows > 0){
            for (int i =0; i < rows; i++){
                NguoiDung nguoiDung = listItem.get(i);
                obj = new Object[columns];
                obj[0] = nguoiDung.getCMND();
                obj[1] = nguoiDung.getName();
                obj[2] = nguoiDung.getYear();
                obj[3] = nguoiDung.getStatus();
                obj[4] = nguoiDung.getHospital();
                obj[5] = nguoiDung.getLinkedPID();
                obj[6] = nguoiDung.getDebt();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
    
    public DefaultTableModel setTableSanPham(List<SanPham> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        System.out.println("So Dòng " + rows);
        if (rows > 0){
            for (int i =0; i < rows; i++){
                SanPham sp = listItem.get(i);
                obj = new Object[columns];
                obj[0] = sp.getIdSP();
                obj[1] = sp.getTenSP();
                obj[2] = sp.getDonGiaSP();
                obj[3] = sp.getDvTinh();
                obj[4] = sp.getHinhAnh();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
   
    public DefaultTableModel setTableGoiSanPham(List<GoiSanPham> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        System.out.println("So Dòng " + rows);
        if (rows > 0){
            for (int i =0; i < rows; i++){
                GoiSanPham gsp = listItem.get(i);
                obj = new Object[columns];
                obj[0] = gsp.getIdGoi();
                obj[1] = gsp.getTenGoi();
                obj[2] = gsp.getDonGia();
                obj[3] = gsp.getMucGioiHan();
                obj[4] = gsp.getTgGioiHan();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
