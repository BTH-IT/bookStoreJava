package DTO;

public class KhachHangDTO extends ConNguoi {
    private String soDienThoai;

    public KhachHangDTO() {

    }

    public KhachHangDTO(String ten, String gioiTinh, String soDienThoai, int namSinh) {
        super(ten, namSinh, gioiTinh);
        this.soDienThoai = soDienThoai;
    }

    public String getSoDienThoai() {
        return this.soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " soDienThoai='" + getSoDienThoai() + "'" +
                "}";
    }

}