/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasoft203_re.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javasoft203_re.Model.LopHoc;
import javasoft203_re.Model.SinhVien;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class SinhVienRepository {

    private List<SinhVien> danhSachSinhVien;
    LopHocRepository lopHocRepository;
    DbContext dbContext;

    public SinhVienRepository() {
        lopHocRepository = new LopHocRepository();
        dbContext = new DbContext();
        danhSachSinhVien = new ArrayList<>();
    }

    public List<SinhVien> layDanhSachSinhVien() {
        String sql = "SELECT * FROM SinhVien";
        List<SinhVien> sinhViens = new ArrayList<>();
        try {
            Connection conn = dbContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            try {
                while (rs.next()) {
                    SinhVien sv = mapping(rs);
                    if (sv != null) {
                        sinhViens.add(sv);
                    }
                }
//                conn.close();
//                st.close();
//                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Lối vl");
            e.printStackTrace();
        }
        return sinhViens;
    }

    private SinhVien mapping(ResultSet rs) {
        try {
            if (rs != null) {
                int id = rs.getInt(1);
                String ten = rs.getString(2);
                int idlop = rs.getInt(3);
                LopHoc lopHoc = this.lopHocRepository.layLopHocTheoid(idlop);
                String monHoc = rs.getString(4);
                List<String> monHocs = new ArrayList<>();
                if (monHoc != null && !monHoc.trim().isEmpty()) {
                    String[] monhocArr = monHoc.split(",");
                    for (String mh : monhocArr) {
                        monHocs.add(mh);
                    }
                }
                return new SinhVien(id, ten, lopHoc, monHocs);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở đây");
        }
        return null;
    }

    public SinhVien luuThongTinSinhVien(SinhVien sinhVien) throws SQLException {
        String ten = sinhVien.getTen();
        int idlop = sinhVien.getLopHoc().getId();
        String monHoc = String.join(",", sinhVien.getMonHoc());

        String sql = "INSERT into sinhVien values(?,?,?)";
        Connection conn = dbContext.getConnection();
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, ten);
        st.setInt(2, idlop);
        st.setString(3, monHoc);
        int kq = st.executeUpdate();
        if (kq > 0) {
            String sqlSelect = "SELECT top 1 * from sinhvien order by id desc";
            PreparedStatement st2 = conn.prepareStatement(sqlSelect);
            ResultSet rs = st2.executeQuery();
            try {
                while (rs.next()) {
                    return this.mapping(rs);
                }
                //  conn.close();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Lỗi vl");
            }
        }
        return null;

    }

    public void xoaThongTinSinhVien(int id) throws SQLException {
        String sql = "DELETE sinhvien where id = ? ";
        try {
            Connection conn = dbContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            int kq = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            // conn.close();
        } catch (Exception e) {
            System.out.println("Loixxx");
            e.printStackTrace();
        }

    }

    public void suaThongTinSinhVien(SinhVien sinhVien) throws SQLException {
        String sql = "UPDATE sinhVien set ten = ?,lophoc = ?,monhoc=? where id = ?";
        try {
            Connection conn = dbContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, sinhVien.getTen());
            st.setInt(2, sinhVien.getLopHoc().getId());
            st.setString(3, String.join(",", sinhVien.getMonHoc()));
            st.setInt(4, sinhVien.getId());
            int kq = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
