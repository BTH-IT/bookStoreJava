/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ChiTietPhieuNhapDAL;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public class ChiTietPhieuNhapBLL {
    ChiTietPhieuNhapDAL chiTietPhieuNhapDAL = new ChiTietPhieuNhapDAL();
    
    public ChiTietPhieuNhapBLL() {
        
    }
    
    public boolean insert(ChiTietPhieuNhapDTO ctpb) {
        return chiTietPhieuNhapDAL.insert(ctpb);
    }
    
<<<<<<< HEAD
    public boolean update(ChiTietPhieuNhapDTO ctpb) {
        return chiTietPhieuNhapDAL.update(ctpb);
    }
    
    public boolean delete(int maPhieuBan, int maSach) {
=======
    public boolean update(ChiTietPhieuNhapDTO ctpb, String maPhieuNhap, String maSach) {
        return chiTietPhieuNhapDAL.update(ctpb, maPhieuNhap, maSach);
    }
    
    public boolean delete(String maPhieuBan, String maSach) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return chiTietPhieuNhapDAL.delete(maPhieuBan, maSach);
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> getAll() {
        return chiTietPhieuNhapDAL.getAll();
    }
    
<<<<<<< HEAD
    public ArrayList<ChiTietPhieuNhapDTO> getByPNId(int id) {
=======
    public ArrayList<ChiTietPhieuNhapDTO> getByPNId(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return chiTietPhieuNhapDAL.getByPNId(id);
    }
}
