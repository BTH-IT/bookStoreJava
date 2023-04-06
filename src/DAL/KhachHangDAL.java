package DAL;

import DAL.ConnectDatabase;
import DAL.DALInterface;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.KhachHangDTO;

public class KhachHangDAL implements DALInterface<KhachHangDTO> {

    public static KhachHangDAL getInstance() {
        return new KhachHangDAL();
    }

    @Override
    public boolean insert(KhachHangDTO t) {
        boolean result = false;

        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into khachhang "
                        + "(ten, gioiTinh, namSinh, soDienThoai) "
                        + "VALUES (?, ?, ?, ?)";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, t.getTen());
                stmt.setString(2, t.getGioiTinh());
                stmt.setInt(3, t.getNamSinh());
                stmt.setString(4, t.getSoDienThoai());

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean update(KhachHangDTO t, String soDienThoai) {
        boolean result = false;
        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();

        if (connect != null) {
            try {
                String sql = "UPDATE khachhang SET "
                        + "ten=?, gioiTinh=?, namSinh=?, soDienThoai=? "
                        + "WHERE soDienThoai=?";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, t.getTen());
                stmt.setString(2, t.getGioiTinh());
                stmt.setInt(3, t.getNamSinh());
                stmt.setString(4, t.getSoDienThoai());
                stmt.setString(5, soDienThoai);

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean delete(String soDienThoai) {
        boolean result = false;
        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "DELETE FROM khachhang "
                        + "WHERE soDienThoai=?";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, soDienThoai);

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    }

    public ArrayList<KhachHangDTO> getAll() {
        ArrayList<KhachHangDTO> result = new ArrayList<>();

        Connection connect = ConnectDatabase.openConnection();

        if (connect != null) {

            try {
                String sql = "SELECT * FROM khachhang";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");
                    String soDienThoai = rs.getString("soDienThoai");

                    KhachHangDTO s = new KhachHangDTO(ten, gioiTinh, soDienThoai, namSinh);

                    result.add(s);
                }
            } catch (SQLException ex) {

                Logger.getLogger(KhachHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public KhachHangDTO getById(String soDienThoai) {
        KhachHangDTO result = null;

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM khachhang WHERE soDienThoai=\'" + soDienThoai + "\'";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");

                    result = new KhachHangDTO(ten, gioiTinh, soDienThoai, namSinh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public ArrayList<KhachHangDTO> getByCondition(String condition) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {

            try {
                String sql = "SELECT * FROM khachhang WHERE " + condition;

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");
                    String soDienThoai = rs.getString("soDienThoai");

                    KhachHangDTO s = new KhachHangDTO(ten, gioiTinh, soDienThoai, namSinh);

                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean update(KhachHangDTO t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        ArrayList<KhachHangDTO> x = KhachHangDAL.getInstance().getAll();
        for (KhachHangDTO i : x) {
            System.out.println(i.toString());

        }
    }
}
