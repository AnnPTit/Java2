/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasoft203_re.Model;

/**
 *
 * @author ADMIN
 */
public class LopHoc {
    private int id;
    private String ten ;
    //

    public LopHoc() {
    }

    public LopHoc(int id, String ten) {
        this.id = id;
        this.ten = ten;
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
    
    
}
