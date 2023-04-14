package DTO;

import java.sql.Date;


public abstract class Phieu {
    private Date ngayLap;
<<<<<<< HEAD
    private int maNhanVien;
    private double tongTien;

    public Phieu(int maNhanVien, Date ngayLap, double tongTien) {
        this.maNhanVien = maNhanVien;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
=======
    private String maNhanVien;

    public Phieu(String maNhanVien, Date ngayLap) {
        this.maNhanVien = maNhanVien;
        this.ngayLap = ngayLap;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    }

    public Phieu() {
        this.ngayLap = null;
<<<<<<< HEAD
        this.maNhanVien = 0;
        this.tongTien = 0;
=======
        this.maNhanVien = null;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    }

    public Date getNgayLap() {
        return this.ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

<<<<<<< HEAD
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    
=======
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
}
