/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Hung
 */
public class ChiTietPhieuNhapDTO extends ChiTietPhieu {
<<<<<<< HEAD
    private int maPhieuNhap;

    public ChiTietPhieuNhapDTO(int maPhieuNhap, int maSach, int soLuong, long donGia) {
=======
    private String maPhieuNhap;

    public ChiTietPhieuNhapDTO(String maPhieuNhap, String maSach, int soLuong, long donGia) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        super(maSach, soLuong, donGia);
        this.maPhieuNhap = maPhieuNhap;
    }

    public ChiTietPhieuNhapDTO() {
    }

<<<<<<< HEAD
    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }
=======
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
}
