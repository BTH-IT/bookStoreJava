/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author Hung
 */
public class ChiTietPhieuBanDTO extends ChiTietPhieu {
    Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
    private int maPhieuBan;
=======
    private String maPhieuBan;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

    public ChiTietPhieuBanDTO() {
    }

<<<<<<< HEAD
    public ChiTietPhieuBanDTO(int maPhieuBan, int maSach, int soLuong, long donGia) {
=======
    public ChiTietPhieuBanDTO(String maPhieuBan, String maSach, int soLuong, long donGia) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        super(maSach, soLuong, donGia);
        this.maPhieuBan = maPhieuBan;
    }

<<<<<<< HEAD
    public int getMaPhieuBan() {
        return maPhieuBan;
    }

    public void setMaPhieuBan(int maPhieuBan) {
=======
    public String getMaPhieuBan() {
        return maPhieuBan;
    }

    public void setMaPhieuBan(String maPhieuBan) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        this.maPhieuBan = maPhieuBan;
    }
}
