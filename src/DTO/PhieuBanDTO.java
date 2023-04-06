package DTO;

import java.sql.Date;

public class PhieuBanDTO extends Phieu {
    private String maPhieuBan;
    private String maKhachHang;
    
    public PhieuBanDTO(String maPhieuBan, String maKhachHang, String nhanVien, Date ngayLap) {
        super(nhanVien, ngayLap);
        this.maPhieuBan = maPhieuBan.toUpperCase();
        this.maKhachHang = maKhachHang;
    }

    public PhieuBanDTO() {
        super();
        this.maPhieuBan = "";
        this.maKhachHang = null;
    }
    
    public String getMaPhieuBan() {
        return this.maPhieuBan;
    }

    public void setMaPhieuBan(String maPhieuBan) {
        this.maPhieuBan = maPhieuBan;
    }
    
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
}
