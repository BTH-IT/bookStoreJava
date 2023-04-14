package DTO;

import java.sql.Date;

public class PhieuBanDTO extends Phieu {
<<<<<<< HEAD
    private int maPhieuBan;
    private int maKhachHang;
    private int maKhuyenMai;
    
    public PhieuBanDTO(int maPhieuBan, int maKhachHang, int nhanVien, Date ngayLap, double tongTien, int maKhuyenMai) {
        super(nhanVien, ngayLap, tongTien);
        this.maPhieuBan = maPhieuBan;
        this.maKhachHang = maKhachHang;
        this.maKhuyenMai = maKhuyenMai;
=======
    private String maPhieuBan;
    private String maKhachHang;
    
    public PhieuBanDTO(String maPhieuBan, String maKhachHang, String nhanVien, Date ngayLap) {
        super(nhanVien, ngayLap);
        this.maPhieuBan = maPhieuBan.toUpperCase();
        this.maKhachHang = maKhachHang;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    }

    public PhieuBanDTO() {
        super();
<<<<<<< HEAD
        this.maPhieuBan = 0;
        this.maKhachHang = 0;
    }
    
    public int getMaPhieuBan() {
        return this.maPhieuBan;
    }
    
    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }
    
    
=======
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
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
}
