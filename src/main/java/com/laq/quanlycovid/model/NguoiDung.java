/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.model;
import java.io.Serializable;
/**
 *
 * @author Envy
 */
public class NguoiDung implements Serializable  {
	private String cmnd;
	private String name;
	private int YOB;
	private String status;
	private int debt = 0;
	private String linkedPID;
	private String Hospital;
	public NguoiDung(String id, String n, int y, String stat, String pid){
		cmnd = id;
		name = n;
		YOB = y;
		debt = 0;
		linkedPID = pid;
		status = stat;
	}
	public NguoiDung(String id, String n, int y, String stat, String pid, int d){
		cmnd = id;
		name = n;
		YOB = y;
		debt = d;
		linkedPID = pid;
		status = stat;
	}
	public NguoiDung(String id, String n, int y, String stat, String pid, int d, String bv){
		cmnd = id;
		name = n;
		YOB = y;
		debt = d;
		linkedPID = pid;
		status = stat;
		Hospital = bv;
	}
	public NguoiDung(){
	}
	public void setCMND(String n) {
		cmnd = n;
	}
	public String getCMND() {
		return cmnd;
	}
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	public void setYear(int y) {
		YOB = y;
	}
	public int getYear() {
		return YOB;
	}
	public void setStatus(String s) {
		status = s;
	}
	public String getStatus() {
		return status;
	}
	public void setDebt(int d) {
		debt = d;
	}
	public int getDebt() {
		return debt;
	}
	public void addDebt(int a) {
		debt = debt + a;
	}
	public void minusDebt(int m) {
		debt = debt - m;
	}
	public String getLinkedPID() {
		return linkedPID;
	}
	public void setLinkedPID(String l) {
		linkedPID = l;
	}
	public String getHospital() {
		return Hospital;
	}
	public void setHospital(String l) {
		Hospital = l;
	}
        @Override
	public String toString() {
		return cmnd + " " + name + " " + YOB + " " + status + " " + linkedPID + " " + debt + " " + Hospital;
	}
}