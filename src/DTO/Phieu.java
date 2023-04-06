package DTO;

import java.sql.Date;


public abstract class Phieu {
    private Date ngayLap;
    private String maNhanVien;

    public Phieu(String maNhanVien, Date ngayLap) {
        this.maNhanVien = maNhanVien;
        this.ngayLap = ngayLap;
    }

    public Phieu() {
        this.ngayLap = null;
        this.maNhanVien = null;
    }

    public Date getNgayLap() {
        return this.ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}
