/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasoft203_re.Repository;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import javasoft203_re.Model.LopHoc;

/**
 *
 * @author ADMIN
 */
public class LopHocRepository {

    DbContext dbContext = new DbContext();

    public List<LopHoc> layTatCaLopHoc() {
        List<LopHoc> lopHocs = new ArrayList<>();
        String sql = "SELECT * FROM LOPHOC";
        try {
            Connection connection = dbContext.getConnection();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String ten = rs.getString(2);
                LopHoc lopHoc = new LopHoc(id, ten);
                lopHocs.add(lopHoc);
                //connection.close();
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return lopHocs;
    }

    public LopHoc layLopHocTheoTen(String ten) {

        String sql = "SELECT * from lophoc where ten =?";
        try {
            Connection conn = dbContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, ten);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idlop = rs.getInt(1);
                String tenlop = rs.getString(2);
                LopHoc lopHoc = new LopHoc(idlop, tenlop);

                return lopHoc;
            }
           conn.close();
          // st.close();
           // rs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public LopHoc layLopHocTheoid(int id) {

        String sql = "SELECT * from lophoc where id =?";
        try {
            Connection conn = dbContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idlop = rs.getInt(1);
                String tenlop = rs.getString(2);
                LopHoc lopHoc = new LopHoc(idlop, tenlop);
               // conn.close();
               // st.close();
              //  rs.close();
                return lopHoc;
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Lõi");
        }
        return null;
    }

}
