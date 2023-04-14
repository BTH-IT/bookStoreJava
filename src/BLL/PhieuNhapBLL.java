/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PhieuNhapDAL;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public class PhieuNhapBLL {
    
    private PhieuNhapDAL phieuNhapDAL = new PhieuNhapDAL();
    
    public PhieuNhapBLL() {
        
    }
    
    public int getSizePhieuBanList() {
        return phieuNhapDAL.getAll().size();
    }
    
<<<<<<< HEAD
    public int insert(PhieuNhapDTO pn) {
        return phieuNhapDAL.insert(pn.getMaNhanVien(), pn.getNgayLap(), pn.getTongTien());
=======
    public boolean insert(PhieuNhapDTO pn) {
        return phieuNhapDAL.insert(pn);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    }
    
    public boolean update(PhieuNhapDTO pb) {
        return phieuNhapDAL.update(pb);
    }
    
<<<<<<< HEAD
    public boolean delete(int id) {
=======
    public boolean delete(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return phieuNhapDAL.delete(id);
    }
    
    public ArrayList<PhieuNhapDTO> getAll() {
        return phieuNhapDAL.getAll();
    }
    
    public ArrayList<PhieuNhapDTO> getByCondition(String condition) {
        return phieuNhapDAL.getByCondition(condition);
    }
    
<<<<<<< HEAD
    public PhieuNhapDTO getById(int id) {
=======
    public PhieuNhapDTO getById(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return phieuNhapDAL.getById(id);
    }
}
