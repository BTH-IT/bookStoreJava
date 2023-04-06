package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.NhanVienDTO;

public class NhanVienDAL implements DALInterface<NhanVienDTO> {
    public static NhanVienDAL getInstance() {
        return new NhanVienDAL();
    }

    @Override
    public boolean insert(NhanVienDTO t) {
        boolean result = false;

        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into nhanvien "
                        + "(maNhanVien ,ten, gioiTinh, namSinh, soDienThoai, mucLuong, soNgayDaNghi, vaiTro) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, t.getMaNhanVien());
                stmt.setString(2, t.getTen());
                stmt.setString(3, t.getGioiTinh());
                stmt.setInt(4, t.getNamSinh());
                stmt.setString(5, t.getSoDienThoai());
                stmt.setLong(6, t.getMucLuong());
                stmt.setInt(7, t.getSoNgayDaNghi());
                stmt.setString(8, t.getVaiTro());

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean update(NhanVienDTO t, String maNhanVien) {
        boolean result = false;
        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();

        if (connect != null) {
            try {
                String sql = "UPDATE nhanvien SET "
                        + "maNhanVien=?, ten=?, gioiTinh=?, namSinh=?, soDienThoai=?, mucLuong=?, soNgayDaNghi=?, vaiTro=? "
                        + "WHERE maNhanVien=?";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, t.getMaNhanVien());
                stmt.setString(2, t.getTen());
                stmt.setString(3, t.getGioiTinh());
                stmt.setInt(4, t.getNamSinh());
                stmt.setString(5, t.getSoDienThoai());
                stmt.setLong(6, t.getMucLuong());
                stmt.setInt(7, t.getSoNgayDaNghi());
                stmt.setString(8, t.getVaiTro());
                stmt.setString(9, maNhanVien);

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean delete(String maNhanVien) {
        boolean result = false;
        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "DELETE FROM nhanvien "
                        + "WHERE maNhanVien=?";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, maNhanVien);

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    }

    public ArrayList<NhanVienDTO> getAll() {
        ArrayList<NhanVienDTO> result = new ArrayList<>();

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {

            try {
                String sql = "SELECT * FROM nhanvien";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String maNhanVien = rs.getString("maNhanvien");
                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");
                    String soDienThoai = rs.getString("soDienThoai");
                    Long mucLuong = rs.getLong("mucLuong");
                    int soNgayDaNghi = rs.getInt("soNgayDaNghi");
                    String vaiTro = rs.getString("vaiTro");

                    NhanVienDTO s = new NhanVienDTO(maNhanVien, ten, namSinh, gioiTinh, soDienThoai, mucLuong,
                            soNgayDaNghi, vaiTro);

                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public NhanVienDTO getById(String maNhanVien) {
        NhanVienDTO result = null;

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM nhanvien WHERE soDienThoai=\'" + maNhanVien + "\'";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {

                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");
                    String soDienThoai = rs.getString("soDienThoai");
                    Long mucLuong = rs.getLong("mucLuong");
                    int soNgayDaNghi = rs.getInt("soNgayDaNghi");
                    String vaiTro = rs.getString("vaiTro");

                    result = new NhanVienDTO(maNhanVien, ten, namSinh, gioiTinh, soDienThoai, mucLuong, soNgayDaNghi,
                            vaiTro);

                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public ArrayList<NhanVienDTO> getByCondition(String condition) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {

            try {
                String sql = "SELECT * FROM nhanvien WHERE " + condition;

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String maNhanVien = rs.getString("maNhanvien");
                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");
                    String soDienThoai = rs.getString("soDienThoai");
                    Long mucLuong = rs.getLong("mucLuong");
                    int soNgayDaNghi = rs.getInt("soNgayDaNghi");
                    String vaiTro = rs.getString("vaiTro");

                    NhanVienDTO s = new NhanVienDTO(maNhanVien, ten, namSinh, gioiTinh, soDienThoai, mucLuong,
                            soNgayDaNghi, vaiTro);
                    result.add(s);

                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean update(NhanVienDTO t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
