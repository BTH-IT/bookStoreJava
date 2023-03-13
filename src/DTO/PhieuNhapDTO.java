package DTO;

import java.sql.Date;

public class PhieuNhapDTO extends Phieu {
    private String maPhieuNhap;
    
    public PhieuNhapDTO(String maPhieuNhap, String maNhanVien, Date ngayLap) {
        super(maNhanVien, ngayLap);
        this.maPhieuNhap = maPhieuNhap;
    }

    public PhieuNhapDTO() {
        super();
        this.maPhieuNhap = "";
    }

    public String getMaPhieuNhap() {
        return this.maPhieuNhap;
    }
    
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
}