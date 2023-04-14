package test;

import java.util.ArrayList;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;

public class NhanVienDAL_TEST {
    public static void main(String[] args) {
        ArrayList<NhanVienDTO> x = NhanVienDAL.getInstance().getAll();
        for (NhanVienDTO i : x) {
            System.out.println(i.toString());
        }
    }
}
