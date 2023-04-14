package BLL;

import java.util.ArrayList;
import DAL.KhachHangDAL;
import DTO.KhachHangDTO;

public class KhachHangBLL {
    KhachHangDAL khachHangDAL = new KhachHangDAL();

    public KhachHangBLL() {

    }

    public boolean insert(KhachHangDTO kh) {
        return khachHangDAL.insert(kh);
    }

    public boolean update(KhachHangDTO kh, String sdt) {
        return khachHangDAL.update(kh, sdt);
    }

    public boolean delete(String sdt) {
        return khachHangDAL.delete(sdt);
    }

    public ArrayList<KhachHangDTO> getAll() {
        return khachHangDAL.getAll();
    }

    public KhachHangDTO getByKHid(String sdt) {
        return khachHangDAL.getById(sdt);
    }
    
    public ArrayList<KhachHangDTO> getByCondition(String condition){
        return khachHangDAL.getByCondition(condition);
    }
}
