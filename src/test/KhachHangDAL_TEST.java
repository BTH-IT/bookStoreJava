package test;

import java.util.ArrayList;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;

public class KhachHangDAL_TEST {
    public static void main(String[] args) {
        ArrayList<KhachHangDTO> x = KhachHangDAL.getInstance().getAll();
        for (KhachHangDTO i : x) {
            System.out.println(i.toString());

        }
    }
}
