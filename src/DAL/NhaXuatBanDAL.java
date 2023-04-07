/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.NhaXuatBanDTO;

/**
 *
 * @author Admin
 */
public class NhaXuatBanDAL implements DALInterface<NhaXuatBanDTO> {

    public static NhaXuatBanDAL getInstance() {
        return new NhaXuatBanDAL();
    }

    @Override
    public boolean insert(NhaXuatBanDTO t) {
        boolean result = false;

        Connection connect = ConnectDatabase.openConnection();

        if (connect != null) {
            {
                try {
                    String sql = "INSERT INTO nhaxuatban" + "(maNXB, tenNXB, diaChi, soDienThoai)" + " VALUES(?,?,?,?)";

                    PreparedStatement stmt = connect.prepareStatement(sql);
                    stmt.setString(1, t.getMaNXB());
                    stmt.setString(2, t.getTenNXB());
                    stmt.setString(3, t.getDiaChi());
                    stmt.setString(4, t.getSoDienThoai());

                    result = stmt.executeUpdate() >= 1;
                } catch (SQLException e) {
                    // TODO: handle exception
                    Logger.getLogger(NhaXuatBanDAL.class.getName()).log(Level.SEVERE, null, e);
                } finally {
                    ConnectDatabase.closeConnection(connect);
                }
            }
        }

        return result;

    }

    public boolean update(NhaXuatBanDTO t, String maNXB) {
        boolean result = false;

        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();

        if (connect != null) {
            try {
                String sql = "UPDATE nhaxuatban SET "
                        + "maNXB=?, tenNXB=?, diaChi=?, soDienThoai=? "
                        + "WHERE maNXB=?";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, t.getMaNXB());
                stmt.setString(2, t.getTenNXB());
                stmt.setString(3, t.getDiaChi());
                stmt.setString(4, t.getSoDienThoai());
                stmt.setString(5, maNXB);

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    }

    public boolean delete(String maNXB) {
        boolean result = false;
        // Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "DELETE FROM nhaxuatban "
                        + "WHERE maNXB=?";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);
                stmt.setString(1, maNXB);

                result = stmt.executeUpdate() >= 1;
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    }

    public ArrayList<NhaXuatBanDTO> getAll() {
        ArrayList<NhaXuatBanDTO> result = new ArrayList<>();

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {

            try {
                String sql = "SELECT * FROM nhaxuatban";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String maNXB = rs.getString("maNXB");
                    String tenNXB = rs.getString("tenNXB");
                    String diaChi = rs.getString("diaChi");
                    String soDienThoai = rs.getString("soDienThoai");

                    NhaXuatBanDTO s = new NhaXuatBanDTO(maNXB, tenNXB, diaChi, soDienThoai);

                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    }

    public NhaXuatBanDTO getById(String manxb) {
        NhaXuatBanDTO result = null;

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM nhaxuatban WHERE maNXB=\'" + manxb + "\'";

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {

                    String maNXB = rs.getString("maNXB");
                    String tenNXB = rs.getString("tenNXB");
                    String diaChi = rs.getString("diaChi");
                    String soDienThoai = rs.getString("soDienThoai");

                    result = new NhaXuatBanDTO(maNXB, tenNXB, diaChi, soDienThoai);

                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    }

    public ArrayList<NhaXuatBanDTO> getByCondition(String condition) {
        ArrayList<NhaXuatBanDTO> result = new ArrayList<>();

        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {

            try {
                String sql = "SELECT * FROM nhaxuatban WHERE " + condition;

                // Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                // Bước 3: lấy dữ liệu
                while (rs.next()) {
                    String maNXB = rs.getString("maNXB");
                    String tenNXB = rs.getString("tenNXB");
                    String diaChi = rs.getString("diaChi");
                    String soDienThoai = rs.getString("soDienThoai");

                    NhaXuatBanDTO s = new NhaXuatBanDTO(maNXB, tenNXB, diaChi, soDienThoai);
                    result.add(s);

                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }

        return result;
    };

    public boolean update(NhaXuatBanDTO t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}