/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasoft203_re.Service;

import java.util.List;
import javasoft203_re.Model.LopHoc;
import javasoft203_re.Repository.LopHocRepository;

/**
 *
 * @author ADMIN
 */
public class LopHocService {
    LopHocRepository lopHocRepository ;
    public LopHocService() {
        this.lopHocRepository = new LopHocRepository();
    }
    public List<LopHoc> layTatCaLopHoc(){
        return this.lopHocRepository.layTatCaLopHoc();
    }
    public LopHoc layLopHocTheoTen( String tenlophoc){
        return this.lopHocRepository.layLopHocTheoTen(tenlophoc);
    }
        
}
