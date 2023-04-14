/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class NhaXuatBanDTO {
    private String maNXB;
    private String tenNXB;
    private String diaChi;
    private String soDienThoai;

    public NhaXuatBanDTO() {
    }

    public NhaXuatBanDTO(String maNXB, String tenNXB, String diaChi, String soDienThoai) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getMaNXB() {
        return this.maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return this.tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return this.soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "{" +
                " maNXB='" + getMaNXB() + "'" +
                ", tenNXB='" + getTenNXB() + "'" +
                ", diaChi='" + getDiaChi() + "'" +
                ", soDienThoai='" + getSoDienThoai() + "'" +
                "}";
    }

}
