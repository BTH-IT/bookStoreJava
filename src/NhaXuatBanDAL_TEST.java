
import DAL.NhaXuatBanDAL;
import DTO.NhaXuatBanDTO;
import java.util.ArrayList;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class NhaXuatBanDAL_TEST {
    public static void main(String[] args) {
        NhaXuatBanDTO t = new NhaXuatBanDTO("4","tan","qn","03190320");
//        NhaXuatBanDAL.getInstance().update(t, "1");
        
//    NhaXuatBanDAL.getInstance().delete("4");
//NhaXuatBanDAL.getInstance().insert(t);

//        System.out.println(NhaXuatBanDAL.getInstance().getById("2"));
System.out.println(NhaXuatBanDAL.getInstance().getByCondition("maNXB LIKE 4"));

        
        ArrayList<NhaXuatBanDTO> x = NhaXuatBanDAL.getInstance().getAll();
        for (NhaXuatBanDTO i : x) {
            System.out.println(i.toString());
        }
        
        
       
    }
}
