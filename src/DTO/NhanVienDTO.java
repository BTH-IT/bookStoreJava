package DTO;

public class NhanVienDTO extends ConNguoi {
    private String maNhanVien;
    private long mucLuong;
    private String soDienThoai;
    private int soNgayDaNghi;
    private String vaiTro;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNhanVien, String ten, int namSinh, String gioiTinh, String soDienThoai, long mucLuong,
            int soNgayDaNghi, String vaiTro) {
        super(ten, namSinh, gioiTinh);
        this.maNhanVien = maNhanVien;
        this.mucLuong = mucLuong;
        this.soDienThoai = soDienThoai;
        this.soNgayDaNghi = soNgayDaNghi;
        this.vaiTro = vaiTro;

    }

    public String getMaNhanVien() {
        return this.maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public long getMucLuong() {
        return this.mucLuong;
    }

    public void setMucLuong(long mucLuong) {
        this.mucLuong = mucLuong;
    }

    public String getSoDienThoai() {
        return this.soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoNgayDaNghi() {
        return this.soNgayDaNghi;
    }

    public void setSoNgayDaNghi(int soNgayDaNghi) {
        this.soNgayDaNghi = soNgayDaNghi;
    }

    public String getVaiTro() {
        return this.vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " maNhanVien='" + getMaNhanVien() + "'" +
                ", mucLuong='" + getMucLuong() + "'" +
                ", soDienThoai='" + getSoDienThoai() + "'" +
                ", soNgayDaNghi='" + getSoNgayDaNghi() + "'" +
                ", vaiTro='" + getVaiTro() + "'" +
                "}";
    }

}
