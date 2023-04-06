package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.TacGiaDTO;

public class TacGiaDAL implements DALInterface<TacGiaDTO> {
    public static TacGiaDAL getInstance() {
        return new TacGiaDAL();
    }

    @Override
    public boolean insert(TacGiaDTO t) {
        boolean result = false;

        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into tacgia "
                        + "(maTacGia, ten, gioiTinh, namSinh) "
                        + "VALUES (?, ?, ?, ?)";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, t.getMaTacGia());
                stmt.setString(2, t.getTen());
                stmt.setString(3, t.getGioiTinh());
                stmt.setInt(4, t.getNamSinh());

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean update(TacGiaDTO t, String maTacGia) {
        boolean result = false;
        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();

        if (connect != null) {
            try {
                String sql = "UPDATE tacgia SET "
                        + "maTacGia=?, ten=?, gioiTinh=?, namSinh=? "
                        + "WHERE maTacGia=?";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, t.getMaTacGia());
                stmt.setString(2, t.getTen());
                stmt.setString(3, t.getGioiTinh());
                stmt.setInt(4, t.getNamSinh());
                stmt.setString(5, maTacGia);

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean delete(String maTacGia) {
        boolean result = false;
        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "DELETE FROM tacgia "
                        + "WHERE maTacGia=?";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, maTacGia);

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    }

    public ArrayList<TacGiaDTO> getAll() {
        ArrayList<TacGiaDTO> result = new ArrayList<>();

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {

            try {
                String sql = "SELECT * FROM tacgia";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String maTacGia = rs.getString("maTacGia");
                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");

                    TacGiaDTO s = new TacGiaDTO(maTacGia, ten, gioiTinh, namSinh);

                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public TacGiaDTO getById(String maTacGia) {
        TacGiaDTO result = null;

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM tacgia WHERE soDienThoai=\'" + maTacGia + "\'";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");

                    result = new TacGiaDTO(maTacGia, ten, gioiTinh, namSinh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public ArrayList<TacGiaDTO> getByCondition(String condition) {
        ArrayList<TacGiaDTO> result = new ArrayList<>();

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {

            try {
                String sql = "SELECT * FROM tacgia WHERE " + condition;

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String maTacGia = rs.getString("maTacGia");
                    String ten = rs.getString("ten");
                    String gioiTinh = rs.getString("gioiTinh");
                    int namSinh = rs.getInt("namSinh");

                    TacGiaDTO s = new TacGiaDTO(maTacGia, ten, gioiTinh, namSinh);

                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean update(TacGiaDTO t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
