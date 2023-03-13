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
    private String maPhieuNhap;

    public ChiTietPhieuNhapDTO(String maPhieuNhap, String maSach, int soLuong, long donGia) {
        super(maSach, soLuong, donGia);
        this.maPhieuNhap = maPhieuNhap;
    }

    public ChiTietPhieuNhapDTO() {
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
}
