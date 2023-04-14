package DTO;

import java.sql.Date;

public class PhieuNhapDTO extends Phieu {
<<<<<<< HEAD
    private int maPhieuNhap;
    
    public PhieuNhapDTO(int maPhieuNhap, int maNhanVien, Date ngayLap, double tongTien) {
        super(maNhanVien, ngayLap, tongTien);
=======
    private String maPhieuNhap;
    
    public PhieuNhapDTO(String maPhieuNhap, String maNhanVien, Date ngayLap) {
        super(maNhanVien, ngayLap);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        this.maPhieuNhap = maPhieuNhap;
    }

    public PhieuNhapDTO() {
        super();
<<<<<<< HEAD
        this.maPhieuNhap = 0;
    }

    public int getMaPhieuNhap() {
        return this.maPhieuNhap;
    }
=======
        this.maPhieuNhap = "";
    }

    public String getMaPhieuNhap() {
        return this.maPhieuNhap;
    }
    
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
}