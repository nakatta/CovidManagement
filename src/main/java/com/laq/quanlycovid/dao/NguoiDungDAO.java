package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Envy
 */
public interface NguoiDungDAO {
    public ArrayList<NguoiDung> getList();
    public List<NguoiDung> getRelateList(String cmnd);
    public DiaChi getDiaChi (String cmnd);
    public List<String> getPhuong();
    public List<String> getQuan();
    public List<String> getThanhPho();
    public int createNguoiDung(NguoiDung nd, DiaChi dc);
    public int updateNguoiDung(NguoiDung old, NguoiDung upd, DiaChi dc, int flag);
}
