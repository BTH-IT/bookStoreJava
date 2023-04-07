/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.TacGiaDAL;
import DTO.TacGiaDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TacGiaBLL {
     TacGiaDAL tacGiaDAL = new TacGiaDAL();

    public TacGiaBLL() {

    }

    public boolean insert(TacGiaDTO tg) {
        return tacGiaDAL.insert(tg);
    }

    public boolean update(TacGiaDTO tg, String matg) {
        return tacGiaDAL.update(tg, matg);
    }

    public boolean delete(String matg) {
        return tacGiaDAL.delete(matg);
    }

    public ArrayList<TacGiaDTO> getAll() {
        return tacGiaDAL.getAll();
    }

    public TacGiaDTO getByKHid(String matg) {
        return tacGiaDAL.getById(matg);
    }
    
    public ArrayList<TacGiaDTO> getByCondition(String condition){
        return tacGiaDAL.getByCondition(condition);
    }
}
