/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.main;

import static com.laq.quanlycovid.dao.DBConnect.getConnection;
import com.laq.quanlycovid.view.MainJFrame;
import com.laq.quanlycovid.view.MainJFrame_1;
import java.sql.*;
/**
 *
 * @author Envy
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        new MainJFrame().setVisible(true);
//          new MainJFrame_1().setVisible(true);
    }
}
