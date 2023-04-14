/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author Hung
 */

import DTO.PhieuBanDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuBanDAL implements DALInterface<PhieuBanDTO>{
    
    public static PhieuBanDAL getInstance() {
        return new PhieuBanDAL();
    }

<<<<<<< HEAD
    public int insert(int maKhachHang, int maNhanVien, Date ngayLap, double tongTien, int maKhuyenMai) {
        boolean result = false;
        int auto_id = -1;
=======
    @Override
    public boolean insert(PhieuBanDTO t) {
        boolean result = false;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into phieuban "
<<<<<<< HEAD
                        + "(maKhachHang, maNhanVien, ngayLap, tongTien, maKhuyenMai) "
                        + "VALUES (?, ?, ?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                stmt.setInt(1, maKhachHang);
                stmt.setInt(2, maNhanVien);
                stmt.setDate(3, ngayLap);
                stmt.setDouble(4, tongTien);
                stmt.setDouble(5, maKhuyenMai);

                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
=======
                        + "(maPhieuBan, maKhachHang, maNhanVien, ngayLap) "
                        + "VALUES (?, ?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getMaPhieuBan());
                stmt.setString(2, t.getMaKhachHang());
                stmt.setString(3, t.getMaNhanVien());
                stmt.setDate(4, t.getNgayLap());

                result = stmt.executeUpdate()>=1;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
            } catch (SQLException ex) {
                Logger.getLogger(PhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
<<<<<<< HEAD
        return auto_id;
=======
        return result;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    }

    @Override
    public boolean update(PhieuBanDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE phieuban SET "
                        + "maKhachHang=?, maNhanVien=?, ngayLap=? "
                        + "WHERE maPhieuBan=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
<<<<<<< HEAD
                stmt.setInt(1, t.getMaKhachHang());
                stmt.setInt(2, t.getMaNhanVien());
                stmt.setDate(3, t.getNgayLap());
                stmt.setInt(4, t.getMaPhieuBan());
=======
                stmt.setString(1, t.getMaKhachHang());
                stmt.setString(2, t.getMaNhanVien());
                stmt.setDate(3, t.getNgayLap());
                stmt.setString(4, t.getMaPhieuBan());
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(PhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
<<<<<<< HEAD
    public boolean delete(int id) {
=======
    public boolean delete(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
<<<<<<< HEAD
                String sql = "UPDATE phieuban SET hienThi=0 "
=======
                String sql = "DELETE FROM phieuban "
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                        + "WHERE maPhieuBan=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
<<<<<<< HEAD
                stmt.setInt(1, id); 
=======
                stmt.setString(1, id); 
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(PhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<PhieuBanDTO> getAll() {
        ArrayList<PhieuBanDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
<<<<<<< HEAD
                String sql = "SELECT * FROM phieuban WHERE hienThi=1";
=======
                String sql = "SELECT * FROM phieuban";
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuBan = rs.getInt("maPhieuBan");
                    int maKhachHang = rs.getInt("maKhachHang");
                    int maNhanVien = rs.getInt("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    double tongTien = rs.getDouble("tongTien");
                    int maKhuyenMai = rs.getInt("maKhuyenMai");
                    
                    PhieuBanDTO pb = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap, tongTien, maKhuyenMai);
=======
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maKhachHang = rs.getString("maKhachHang");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    PhieuBanDTO pb = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                 
                    result.add(pb);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
<<<<<<< HEAD
    public PhieuBanDTO getById(int id) {
=======
    public PhieuBanDTO getById(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        PhieuBanDTO result = null;
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
<<<<<<< HEAD
                String sql = "SELECT * FROM phieuban WHERE hienThi=1 AND maPhieuBan=" + id;
=======
                String sql = "SELECT * FROM phieuban WHERE maPhieuBan=\'" + id + "\'";
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuBan = rs.getInt("maPhieuBan");
                    int maKhachHang = rs.getInt("maKhachHang");
                    int maNhanVien = rs.getInt("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    double tongTien = rs.getDouble("tongTien");
                    int maKhuyenMai = rs.getInt("maKhuyenMai");
                    
                    PhieuBanDTO pb = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap, tongTien, maKhuyenMai);
=======
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maKhachHang = rs.getString("maKhachHang");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    result = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<PhieuBanDTO> getByCondition(String condition) {
        ArrayList<PhieuBanDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
<<<<<<< HEAD
                String sql = "SELECT * FROM phieuban WHERE hienThi=1 AND " + condition;
=======
                String sql = "SELECT * FROM phieuban WHERE " + condition;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuBan = rs.getInt("maPhieuBan");
                    int maKhachHang = rs.getInt("maKhachHang");
                    int maNhanVien = rs.getInt("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    double tongTien = rs.getDouble("tongTien");
                    int maKhuyenMai = rs.getInt("maKhuyenMai");
                    
                    PhieuBanDTO pb = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap, tongTien, maKhuyenMai);
=======
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maKhachHang = rs.getString("maKhachHang");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    PhieuBanDTO pb = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                 
                    result.add(pb);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }
<<<<<<< HEAD

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(PhieuBanDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PhieuBanDTO getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
=======
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
}
