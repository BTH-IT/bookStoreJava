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
    
    public boolean update(ChiTietPhieuNhapDTO ctpb) {
        return chiTietPhieuNhapDAL.update(ctpb);
    }
    
    public boolean delete(int maPhieuBan, int maSach) {
        return chiTietPhieuNhapDAL.delete(maPhieuBan, maSach);
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> getAll() {
        return chiTietPhieuNhapDAL.getAll();
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> getByPNId(int id) {
        return chiTietPhieuNhapDAL.getByPNId(id);
    }
}
