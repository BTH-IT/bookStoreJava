/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.SachDAL;
import DTO.SachDTO;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public class SachBLL {
    private SachDAL sachDAL = new SachDAL();
    
    public SachBLL() {
        
    }
    
    public ArrayList<SachDTO> getAllSach(){ 
        return sachDAL.getAll();
    }
    
    public SachDTO getById(String id){ 
        return sachDAL.getById(id);
    }
    
    public ArrayList<SachDTO> getByCondition(String condition){ 
        return sachDAL.getByCondition(condition);
    }
    
    public boolean update(SachDTO s, String maSach) {
        return sachDAL.update(s, maSach);
    }
    
    public boolean insert(SachDTO s) {
        return sachDAL.insert(s);
    }
    
    public boolean delete(String maSach) {
        return sachDAL.delete(maSach);
    }
}
