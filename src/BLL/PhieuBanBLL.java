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
    
    public boolean insert(PhieuBanDTO pb) {
        return phieuBanDAL.insert(pb);
    }
    
    public boolean update(PhieuBanDTO pb) {
        return phieuBanDAL.update(pb);
    }
    
    public boolean delete(String id) {
        return phieuBanDAL.delete(id);
    }
    
    public ArrayList<PhieuBanDTO> getAll() {
        return phieuBanDAL.getAll();
    }
    
    public ArrayList<PhieuBanDTO> getByCondition(String condition) {
        return phieuBanDAL.getByCondition(condition);
    }
    
    public PhieuBanDTO getById(String id) {
        return phieuBanDAL.getById(id);
    }
}
