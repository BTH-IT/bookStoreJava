/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhanVienBLL {
    NhanVienDAL nhanVienDAL = new NhanVienDAL();

    public NhanVienBLL() {
    }

    public boolean insert(NhanVienDTO nv) {
        return nhanVienDAL.insert(nv);
    }

    public boolean update(NhanVienDTO nv, String manv) {
        return nhanVienDAL.update(nv, manv);
    }

    public boolean delete(String manv) {
        return nhanVienDAL.delete(manv);
    }

    public ArrayList<NhanVienDTO> getAll() {
        return nhanVienDAL.getAll();
    }

    public NhanVienDTO getByNVid(String manv) {
        return nhanVienDAL.getById(manv);
    }

    public ArrayList<NhanVienDTO> getByCondition(String condition) {
        return nhanVienDAL.getByCondition(condition);
    }
}
