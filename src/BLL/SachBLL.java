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
    
<<<<<<< HEAD
    public SachDTO getById(int id){ 
=======
    public SachDTO getById(String id){ 
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return sachDAL.getById(id);
    }
    
    public ArrayList<SachDTO> getByCondition(String condition){ 
        return sachDAL.getByCondition(condition);
    }
    
<<<<<<< HEAD
    public boolean update(SachDTO s) {
        return sachDAL.update(s);
    }
    
    public int insert(SachDTO s) {
        return sachDAL.insert(s.getTenSach(), s.getMaTheLoai(), s.getMaTacGia(), s.getMaNhaXuatBan(), s.getSoLuongConLai(), s.getGiaBan(), s.getGiaNhap(), s.getNamXuatBan());
    }
    
    public boolean delete(int maSach) {
=======
    public boolean update(SachDTO s, String maSach) {
        return sachDAL.update(s, maSach);
    }
    
    public boolean insert(SachDTO s) {
        return sachDAL.insert(s);
    }
    
    public boolean delete(String maSach) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return sachDAL.delete(maSach);
    }
}
