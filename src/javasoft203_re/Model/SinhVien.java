/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasoft203_re.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SinhVien {
    private int id ;
    private String ten;
    private LopHoc lopHoc;
    private List<String> monHoc = new ArrayList<>();

    public SinhVien() {
    }

    public SinhVien(int id, String ten, LopHoc lopHoc,List<String> monhoc) {
        this.id = id;
        this.ten = ten;
        this.lopHoc = lopHoc;
        this.monHoc=monhoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LopHoc getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }

    public List<String> getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(List<String> monHoc) {
        this.monHoc = monHoc;
    }
    
    
    
    
    
}
