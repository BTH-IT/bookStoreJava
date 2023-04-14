package test;

import java.util.ArrayList;

import DAL.TacGiaDAL;
import DTO.TacGiaDTO;

public class TacGiaDAL_TEST {
    public static void main(String[] args) {
        ArrayList<TacGiaDTO> x = TacGiaDAL.getInstance().getAll();
        for (TacGiaDTO i : x) {
            System.out.println(i.toString());
        }
    }
}
