/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasoft203_re.Service;

import java.sql.SQLException;
import java.util.List;
import javasoft203_re.Model.SinhVien;
import javasoft203_re.Repository.SinhVienRepository;

/**
 *
 * @author ADMIN
 */
public class SinhVienService {
    SinhVienRepository sinhVienRepository;
    public SinhVienService() {
        sinhVienRepository = new SinhVienRepository();
    }
    public List<SinhVien> layDanhSachSinhVien(){
        return this.sinhVienRepository.layDanhSachSinhVien();
    }
    public SinhVien luuThongTinSinhVien(SinhVien sinhVien) throws SQLException{
        return this.sinhVienRepository.luuThongTinSinhVien(sinhVien);
        
    }
    
    public void xoaThongTinSinhVien(int id) throws SQLException{
        this.sinhVienRepository.xoaThongTinSinhVien(id);
    }
    public void suaThongTinSinhVien(SinhVien sinhVien) throws SQLException{
        this.sinhVienRepository.suaThongTinSinhVien(sinhVien);
    }
    
    
    
}
