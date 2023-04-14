/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PhieuBanDAL;
import DTO.PhieuBanDTO;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public class PhieuBanBLL {
    
    private PhieuBanDAL phieuBanDAL = new PhieuBanDAL();
    
    public PhieuBanBLL() {
        
    }
    
    public int getSizePhieuBanList() {
        return phieuBanDAL.getAll().size();
    }
    
<<<<<<< HEAD
    public int insert(PhieuBanDTO pb) {
        return phieuBanDAL.insert(pb.getMaKhachHang(), pb.getMaNhanVien(), pb.getNgayLap(), pb.getTongTien(), pb.getMaKhuyenMai());
=======
    public boolean insert(PhieuBanDTO pb) {
        return phieuBanDAL.insert(pb);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    }
    
    public boolean update(PhieuBanDTO pb) {
        return phieuBanDAL.update(pb);
    }
    
<<<<<<< HEAD
    public boolean delete(int id) {
=======
    public boolean delete(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return phieuBanDAL.delete(id);
    }
    
    public ArrayList<PhieuBanDTO> getAll() {
        return phieuBanDAL.getAll();
    }
    
    public ArrayList<PhieuBanDTO> getByCondition(String condition) {
        return phieuBanDAL.getByCondition(condition);
    }
    
<<<<<<< HEAD
    public PhieuBanDTO getById(int id) {
=======
    public PhieuBanDTO getById(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return phieuBanDAL.getById(id);
    }
}
