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
    
    public boolean insert(PhieuNhapDTO pn) {
        return phieuNhapDAL.insert(pn);
    }
    
    public boolean update(PhieuNhapDTO pb) {
        return phieuNhapDAL.update(pb);
    }
    
    public boolean delete(String id) {
        return phieuNhapDAL.delete(id);
    }
    
    public ArrayList<PhieuNhapDTO> getAll() {
        return phieuNhapDAL.getAll();
    }
    
    public ArrayList<PhieuNhapDTO> getByCondition(String condition) {
        return phieuNhapDAL.getByCondition(condition);
    }
    
    public PhieuNhapDTO getById(String id) {
        return phieuNhapDAL.getById(id);
    }
}
