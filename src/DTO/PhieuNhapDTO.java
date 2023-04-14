package DTO;

import java.sql.Date;

public class PhieuNhapDTO extends Phieu {
    private int maPhieuNhap;
    
    public PhieuNhapDTO(int maPhieuNhap, int maNhanVien, Date ngayLap, double tongTien) {
        super(maNhanVien, ngayLap, tongTien);
        this.maPhieuNhap = maPhieuNhap;
    }

    public PhieuNhapDTO() {
        super();
        this.maPhieuNhap = 0;
    }

    public int getMaPhieuNhap() {
        return this.maPhieuNhap;
    }
}