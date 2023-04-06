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

    @Override
    public boolean insert(PhieuBanDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into phieuban "
                        + "(maPhieuBan, maKhachHang, maNhanVien, ngayLap) "
                        + "VALUES (?, ?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getMaPhieuBan());
                stmt.setString(2, t.getMaKhachHang());
                stmt.setString(3, t.getMaNhanVien());
                stmt.setDate(4, t.getNgayLap());

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
                stmt.setString(1, t.getMaKhachHang());
                stmt.setString(2, t.getMaNhanVien());
                stmt.setDate(3, t.getNgayLap());
                stmt.setString(4, t.getMaPhieuBan());

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
    public boolean delete(String id) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "DELETE FROM phieuban "
                        + "WHERE maPhieuBan=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, id); 

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
                String sql = "SELECT * FROM phieuban";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maKhachHang = rs.getString("maKhachHang");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    PhieuBanDTO pb = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap);
                 
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
    public PhieuBanDTO getById(String id) {
        PhieuBanDTO result = null;
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM phieuban WHERE maPhieuBan=\'" + id + "\'";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maKhachHang = rs.getString("maKhachHang");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    result = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap);
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
                String sql = "SELECT * FROM phieuban WHERE " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maKhachHang = rs.getString("maKhachHang");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    PhieuBanDTO pb = new PhieuBanDTO(maPhieuBan, maKhachHang, maNhanVien, ngayLap);
                 
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
}
