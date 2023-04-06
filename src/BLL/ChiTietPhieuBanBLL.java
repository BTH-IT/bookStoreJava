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
    
    public boolean update(ChiTietPhieuBanDTO ctpb, String maPhieuBan, String maSach) {
        return chiTietPhieuBanDAL.update(ctpb, maPhieuBan, maSach);
    }
    
    public boolean delete(String maPhieuBan, String maSach) {
        return chiTietPhieuBanDAL.delete(maPhieuBan, maSach);
    }
    
    public ArrayList<ChiTietPhieuBanDTO> getAll() {
        return chiTietPhieuBanDAL.getAll();
    }
    
    public ArrayList<ChiTietPhieuBanDTO> getByPBId(String id) {
        return chiTietPhieuBanDAL.getByPBId(id);
    }
}
