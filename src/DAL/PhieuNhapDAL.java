/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author Hung
 */

import DTO.PhieuNhapDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapDAL implements DALInterface<PhieuNhapDTO>{
    
    public static PhieuNhapDAL getInstance() {
        return new PhieuNhapDAL();
    }

    @Override
    public boolean insert(PhieuNhapDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into phieunhap "
                        + "(maPhieuNhap, maNhanVien, ngayLap) "
                        + "VALUES (?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getMaPhieuNhap());
                stmt.setString(2, t.getMaNhanVien());
                stmt.setDate(3, t.getNgayLap());

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public boolean update(PhieuNhapDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE phieunhap SET "
                        + "maNhanVien=?, ngayLap=? "
                        + "WHERE maPhieuNhap=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getMaNhanVien());
                stmt.setDate(2, t.getNgayLap());
                stmt.setString(3, t.getMaPhieuNhap());

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "DELETE FROM phieunhap "
                        + "WHERE maPhieuNhap=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, id); 

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<PhieuNhapDTO> getAll() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM phieunhap";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    PhieuNhapDTO pn = new PhieuNhapDTO(maPhieuNhap, maNhanVien, ngayLap);
                 
                    result.add(pn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public PhieuNhapDTO getById(String id) {
        PhieuNhapDTO result = null;
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM phieunhap WHERE maPhieuNhap=\'" + id + "\'";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    result = new PhieuNhapDTO(maPhieuNhap, maNhanVien, ngayLap);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<PhieuNhapDTO> getByCondition(String condition) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM phieunhap WHERE " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maNhanVien = rs.getString("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    
                    PhieuNhapDTO pn = new PhieuNhapDTO(maPhieuNhap, maNhanVien, ngayLap);
                 
                    result.add(pn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }
}
