/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Hung
 */
public class SachDTO {
    private String maSach;
    private String tenSach;
    private String maTacGia;
    private String maTheLoai;
    private String maNhaXuatBan;
    private int namXuatBan;
    private int soLuongConLai;
    private long giaBan;
    private long giaNhap;

    public SachDTO(String maSach, String tenSach, String maTheLoai, String maTacGia,
            String maNhaXuatBan, int soLuongConLai, long giaBan, long giaNhap, int namXuatBan) {
        this.maSach = maSach.toUpperCase();
        this.tenSach = tenSach;
        this.maTacGia = maTacGia;
        this.maTheLoai = maTheLoai;
        this.maNhaXuatBan = maNhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.soLuongConLai = soLuongConLai;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
    }

    public SachDTO() {
        this.maSach = "";
        this.tenSach = "";
        this.maTacGia = "";
        this.maTheLoai = "";
        this.maNhaXuatBan = "";
        this.namXuatBan = 0;
        this.soLuongConLai = 0;
        this.giaBan = 0;
        this.giaNhap = 0;
    }

    public String getMaSach() {
        return this.maSach;
    }
    
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return this.tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getMaNhaXuatBan() {
        return maNhaXuatBan;
    }

    public void setMaNhaXuatBan(String maNhaXuatBan) {
        this.maNhaXuatBan = maNhaXuatBan;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }

    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", maTacGia=" + maTacGia + ", maTheLoai=" + maTheLoai + ", maNhaXuatBan=" + maNhaXuatBan + ", namXuatBan=" + namXuatBan + ", soLuongConLai=" + soLuongConLai + ", giaBan=" + giaBan + ", giaNhap=" + giaNhap + '}';
    }

    public int getNamXuatBan() {
        return this.namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
    
    public int getSoLuongConLai() {
    	return this.soLuongConLai;
    }
    
    public void setSoLuongConLai(int soLuongConLai) {
        this.soLuongConLai = soLuongConLai;
    }
}
