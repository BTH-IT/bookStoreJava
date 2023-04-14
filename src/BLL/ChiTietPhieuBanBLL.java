/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ChiTietPhieuBanDAL;
import DTO.ChiTietPhieuBanDTO;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public class ChiTietPhieuBanBLL {
    ChiTietPhieuBanDAL chiTietPhieuBanDAL = new ChiTietPhieuBanDAL();
    
    public ChiTietPhieuBanBLL() {
        
    }
    
    public boolean insert(ChiTietPhieuBanDTO ctpb) {
        return chiTietPhieuBanDAL.insert(ctpb);
    }
    
<<<<<<< HEAD
    public boolean update(ChiTietPhieuBanDTO ctpb) {
        return chiTietPhieuBanDAL.update(ctpb);
    }
    
    public boolean delete(int maPhieuBan, int maSach) {
=======
    public boolean update(ChiTietPhieuBanDTO ctpb, String maPhieuBan, String maSach) {
        return chiTietPhieuBanDAL.update(ctpb, maPhieuBan, maSach);
    }
    
    public boolean delete(String maPhieuBan, String maSach) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return chiTietPhieuBanDAL.delete(maPhieuBan, maSach);
    }
    
    public ArrayList<ChiTietPhieuBanDTO> getAll() {
        return chiTietPhieuBanDAL.getAll();
    }
    
<<<<<<< HEAD
    public ArrayList<ChiTietPhieuBanDTO> getByPBId(int id) {
=======
    public ArrayList<ChiTietPhieuBanDTO> getByPBId(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        return chiTietPhieuBanDAL.getByPBId(id);
    }
}
