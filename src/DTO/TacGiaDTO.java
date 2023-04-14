package DTO;

public class TacGiaDTO extends ConNguoi {
    private String maTacGia;

    public TacGiaDTO() {
    }

    public TacGiaDTO(String maTacGia, String ten, String gioiTinh, int namSinh) {
        super(ten, namSinh, gioiTinh);
        this.maTacGia = maTacGia;

    }

    public String getMaTacGia() {
        return this.maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                " maTacGia='" + getMaTacGia() + "'" +
                "}";
    }

}
